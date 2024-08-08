package routines;
import java.io.UnsupportedEncodingException;
import java.util.Base64;


public class ValidateCredentials {

  
	public static Boolean IsAuthorized(String username, String password, String authHeader) {
	    Boolean authStatus = false;
	    if (authHeader != null && authHeader.startsWith("Basic ")) {
	        String base64Credentials = authHeader.substring("Basic ".length()).trim();
	        try {
	            String credentials = new String(Base64.getDecoder().decode(base64Credentials), "UTF-8");
	            String[] values = credentials.split(":", 2);
	            String inputusername = values[0];
	            String inputpassword = values[1];
	            
	            //System.out.println("Username: " + username);
	            //System.out.println("Password: " + password);

	            if (username.equals(inputusername) && password.equals(inputpassword)) {
	                return authStatus = true;
	            } else {
	                return authStatus = false;
	            }
	        } catch (UnsupportedEncodingException e) {
	            e.printStackTrace();
	        }
	    } else {
	        return authStatus = false;
	    }
	    return authStatus;
	}

        
}
