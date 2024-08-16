package routines;

import java.util.Base64;


import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSObject;
import com.nimbusds.jose.crypto.RSASSAVerifier;
import com.nimbusds.jose.jwk.JWK;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;

import java.net.URL;
import java.security.PublicKey;
import java.security.interfaces.RSAPublicKey;


public class TokenValidatorService {
	
	private  String tenantId; 

    private  String clientId; 
	
	public TokenValidatorService(String tenantId, String clientId) {
		this.clientId=clientId;
		this.tenantId=tenantId;		
	}


    public  boolean validateToken(String token) {
    	token = token.substring(7, token.length());  // Remove "Bearer " prefix
        try {
        	// Construct the URL to retrieve the public keys
            URL jwkSetURL = new URL("https://login.microsoftonline.com/" + tenantId + "/discovery/keys?appid=" + clientId);
           
            // Load the public keys
            JWKSet jwkSet = JWKSet.load(jwkSetURL);
            
            // Parse the JWT
            JWSObject jwsObject = JWSObject.parse(token);

         // Check the algorithm used
            JWSAlgorithm algorithm = jwsObject.getHeader().getAlgorithm();
            if (!algorithm.equals(JWSAlgorithm.RS256)) {
                throw new IllegalArgumentException("No RS256");
            }

         // Find the public key that matches the key ID in the token
            RSAKey rsaKey = null;
            for (JWK jwk : jwkSet.getKeys()) {
                if (jwk.getKeyID().equals(jwsObject.getHeader().getKeyID())) {
                    rsaKey = (RSAKey) jwk;
                    break;
                }
            }
            if (rsaKey == null) {
                throw new IllegalArgumentException("No publicKey");
            }

         // Convert the RSA key to a public key
            PublicKey publicKey = rsaKey.toRSAPublicKey();
            RSASSAVerifier verifier = new RSASSAVerifier((RSAPublicKey) publicKey);
            
            // Decode the payload and extract the client ID
            Base64.Decoder decoder = Base64.getUrlDecoder();
            String payloadDecode = new String(decoder.decode(token.split("\\.")[1]));
            System.out.println(payloadDecode);
            String clientIdentifier = payloadDecode.substring(payloadDecode.indexOf("appid") + 8, payloadDecode.indexOf("appid") + 8 + clientId.length());
            System.out.println(clientIdentifier);
            boolean isClientValid = clientIdentifier.equals(clientId);
            System.out.println(isClientValid);

            // Verify the signature and client ID
            boolean isVerified = isClientValid && (jwsObject.verify(verifier));
            return isVerified;
        } catch (Exception e) {
        	System.out.println("Token validation error: " + e.getMessage());
            e.printStackTrace();
            return false;

        }
    }
    
	public static boolean isBlank(final CharSequence cs) {
		int strLen;
		if (cs == null || (strLen = cs.length()) == 0) {
			return true;
		}
		for (int i = 0; i < strLen; i++) {
			if (!Character.isWhitespace(cs.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	
}
