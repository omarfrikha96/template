// ============================================================================
//
// Copyright (c) 2006-2015, Talend SA
//
// Ce code source a été automatiquement généré par_Talend Open Studio for ESB
// / Soumis à la Licence Apache, Version 2.0 (la "Licence") ;
// votre utilisation de ce fichier doit respecter les termes de la Licence.
// Vous pouvez obtenir une copie de la Licence sur
// http://www.apache.org/licenses/LICENSE-2.0
// 
// Sauf lorsqu'explicitement prévu par la loi en vigueur ou accepté par écrit, le logiciel
// distribué sous la Licence est distribué "TEL QUEL",
// SANS GARANTIE OU CONDITION D'AUCUNE SORTE, expresse ou implicite.
// Consultez la Licence pour connaître la terminologie spécifique régissant les autorisations et
// les limites prévues par la Licence.

package salesforce.copy_of_postrequest_0_1;

import routines.Numeric;
import routines.DataOperation;
import routines.TalendDataGenerator;
import routines.TalendStringUtil;
import routines.TalendString;
import routines.StringHandling;
import routines.TalendDate;
import routines.Relational;
import routines.Mathematical;
import routines.TokenValidatorService;
import routines.system.*;
import routines.system.api.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.math.BigDecimal;
import java.io.ByteArrayOutputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.util.Comparator;

@SuppressWarnings("unused")

/**
 * Job: Copy_of_PostRequest Purpose: <br>
 * Description: <br>
 * 
 * @author user@talend.com
 * @version 8.0.1.20211109_1610
 * @status
 */
public class Copy_of_PostRequest implements TalendJob {
	static {
		System.setProperty("TalendJob.log", "Copy_of_PostRequest.log");
	}

	private static org.apache.logging.log4j.Logger log = org.apache.logging.log4j.LogManager
			.getLogger(Copy_of_PostRequest.class);

	protected static void logIgnoredError(String message, Throwable cause) {
		log.error(message, cause);

	}

	public final Object obj = new Object();

	// for transmiting parameters purpose
	private Object valueObject = null;

	public Object getValueObject() {
		return this.valueObject;
	}

	public void setValueObject(Object valueObject) {
		this.valueObject = valueObject;
	}

	private final static String defaultCharset = java.nio.charset.Charset.defaultCharset().name();

	private final static String utf8Charset = "UTF-8";

	// contains type for every context property
	public class PropertiesWithType extends java.util.Properties {
		private static final long serialVersionUID = 1L;
		private java.util.Map<String, String> propertyTypes = new java.util.HashMap<>();

		public PropertiesWithType(java.util.Properties properties) {
			super(properties);
		}

		public PropertiesWithType() {
			super();
		}

		public void setContextType(String key, String type) {
			propertyTypes.put(key, type);
		}

		public String getContextType(String key) {
			return propertyTypes.get(key);
		}
	}

	// create and load default properties
	private java.util.Properties defaultProps = new java.util.Properties();

	// create application properties with default
	public class ContextProperties extends PropertiesWithType {

		private static final long serialVersionUID = 1L;

		public ContextProperties(java.util.Properties properties) {
			super(properties);
		}

		public ContextProperties() {
			super();
		}

		public void synchronizeContext() {

			if (azure_access_token != null) {

				this.setProperty("azure_access_token", azure_access_token.toString());

			}

			if (azure_client_id != null) {

				this.setProperty("azure_client_id", azure_client_id.toString());

			}

			if (azure_client_secret != null) {

				this.setProperty("azure_client_secret", azure_client_secret.toString());

			}

			if (azure_content_type_token != null) {

				this.setProperty("azure_content_type_token", azure_content_type_token.toString());

			}

			if (azure_grant_type != null) {

				this.setProperty("azure_grant_type", azure_grant_type.toString());

			}

			if (azure_resource != null) {

				this.setProperty("azure_resource", azure_resource.toString());

			}

			if (azure_tenant_id != null) {

				this.setProperty("azure_tenant_id", azure_tenant_id.toString());

			}

			if (azure_token_type != null) {

				this.setProperty("azure_token_type", azure_token_type.toString());

			}

			if (azure_url_token != null) {

				this.setProperty("azure_url_token", azure_url_token.toString());

			}

		}

		// if the stored or passed value is "<TALEND_NULL>" string, it mean null
		public String getStringValue(String key) {
			String origin_value = this.getProperty(key);
			if (NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY.equals(origin_value)) {
				return null;
			}
			return origin_value;
		}

		public String azure_access_token;

		public String getAzure_access_token() {
			return this.azure_access_token;
		}

		public String azure_client_id;

		public String getAzure_client_id() {
			return this.azure_client_id;
		}

		public String azure_client_secret;

		public String getAzure_client_secret() {
			return this.azure_client_secret;
		}

		public String azure_content_type_token;

		public String getAzure_content_type_token() {
			return this.azure_content_type_token;
		}

		public String azure_grant_type;

		public String getAzure_grant_type() {
			return this.azure_grant_type;
		}

		public String azure_resource;

		public String getAzure_resource() {
			return this.azure_resource;
		}

		public String azure_tenant_id;

		public String getAzure_tenant_id() {
			return this.azure_tenant_id;
		}

		public String azure_token_type;

		public String getAzure_token_type() {
			return this.azure_token_type;
		}

		public String azure_url_token;

		public String getAzure_url_token() {
			return this.azure_url_token;
		}
	}

	protected ContextProperties context = new ContextProperties(); // will be instanciated by MS.

	public ContextProperties getContext() {
		return this.context;
	}

	private final String jobVersion = "0.1";
	private final String jobName = "Copy_of_PostRequest";
	private final String projectName = "SALESFORCE";
	public Integer errorCode = null;
	private String currentComponent = "";

	private final java.util.Map<String, Object> globalMap = new java.util.HashMap<String, Object>();
	private final static java.util.Map<String, Object> junitGlobalMap = new java.util.HashMap<String, Object>();

	private final java.util.Map<String, Long> start_Hash = new java.util.HashMap<String, Long>();
	private final java.util.Map<String, Long> end_Hash = new java.util.HashMap<String, Long>();
	private final java.util.Map<String, Boolean> ok_Hash = new java.util.HashMap<String, Boolean>();
	public final java.util.List<String[]> globalBuffer = new java.util.ArrayList<String[]>();

	private RunStat runStat = new RunStat();

	// OSGi DataSource
	private final static String KEY_DB_DATASOURCES = "KEY_DB_DATASOURCES";

	private final static String KEY_DB_DATASOURCES_RAW = "KEY_DB_DATASOURCES_RAW";

	public void setDataSources(java.util.Map<String, javax.sql.DataSource> dataSources) {
		java.util.Map<String, routines.system.TalendDataSource> talendDataSources = new java.util.HashMap<String, routines.system.TalendDataSource>();
		for (java.util.Map.Entry<String, javax.sql.DataSource> dataSourceEntry : dataSources.entrySet()) {
			talendDataSources.put(dataSourceEntry.getKey(),
					new routines.system.TalendDataSource(dataSourceEntry.getValue()));
		}
		globalMap.put(KEY_DB_DATASOURCES, talendDataSources);
		globalMap.put(KEY_DB_DATASOURCES_RAW, new java.util.HashMap<String, javax.sql.DataSource>(dataSources));
	}

	public void setDataSourceReferences(List serviceReferences) throws Exception {

		java.util.Map<String, routines.system.TalendDataSource> talendDataSources = new java.util.HashMap<String, routines.system.TalendDataSource>();
		java.util.Map<String, javax.sql.DataSource> dataSources = new java.util.HashMap<String, javax.sql.DataSource>();

		for (java.util.Map.Entry<String, javax.sql.DataSource> entry : BundleUtils
				.getServices(serviceReferences, javax.sql.DataSource.class).entrySet()) {
			dataSources.put(entry.getKey(), entry.getValue());
			talendDataSources.put(entry.getKey(), new routines.system.TalendDataSource(entry.getValue()));
		}

		globalMap.put(KEY_DB_DATASOURCES, talendDataSources);
		globalMap.put(KEY_DB_DATASOURCES_RAW, new java.util.HashMap<String, javax.sql.DataSource>(dataSources));
	}

	private final java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
	private final java.io.PrintStream errorMessagePS = new java.io.PrintStream(new java.io.BufferedOutputStream(baos));

	public String getExceptionStackTrace() {
		if ("failure".equals(this.getStatus())) {
			errorMessagePS.flush();
			return baos.toString();
		}
		return null;
	}

	private Exception exception;

	public Exception getException() {
		if ("failure".equals(this.getStatus())) {
			return this.exception;
		}
		return null;
	}

	private class TalendException extends Exception {

		private static final long serialVersionUID = 1L;

		private java.util.Map<String, Object> globalMap = null;
		private Exception e = null;
		private String currentComponent = null;
		private String virtualComponentName = null;

		public void setVirtualComponentName(String virtualComponentName) {
			this.virtualComponentName = virtualComponentName;
		}

		private TalendException(Exception e, String errorComponent, final java.util.Map<String, Object> globalMap) {
			this.currentComponent = errorComponent;
			this.globalMap = globalMap;
			this.e = e;
		}

		public Exception getException() {
			return this.e;
		}

		public String getCurrentComponent() {
			return this.currentComponent;
		}

		public String getExceptionCauseMessage(Exception e) {
			Throwable cause = e;
			String message = null;
			int i = 10;
			while (null != cause && 0 < i--) {
				message = cause.getMessage();
				if (null == message) {
					cause = cause.getCause();
				} else {
					break;
				}
			}
			if (null == message) {
				message = e.getClass().getName();
			}
			return message;
		}

		@Override
		public void printStackTrace() {
			if (!(e instanceof TalendException || e instanceof TDieException)) {
				if (virtualComponentName != null && currentComponent.indexOf(virtualComponentName + "_") == 0) {
					globalMap.put(virtualComponentName + "_ERROR_MESSAGE", getExceptionCauseMessage(e));
				}
				globalMap.put(currentComponent + "_ERROR_MESSAGE", getExceptionCauseMessage(e));
				System.err.println("Exception in component " + currentComponent + " (" + jobName + ")");
			}
			if (!(e instanceof TDieException)) {
				if (e instanceof TalendException) {
					e.printStackTrace();
				} else {
					e.printStackTrace();
					e.printStackTrace(errorMessagePS);
					Copy_of_PostRequest.this.exception = e;
				}
			}
			if (!(e instanceof TalendException)) {
				try {
					for (java.lang.reflect.Method m : this.getClass().getEnclosingClass().getMethods()) {
						if (m.getName().compareTo(currentComponent + "_error") == 0) {
							m.invoke(Copy_of_PostRequest.this, new Object[] { e, currentComponent, globalMap });
							break;
						}
					}

					if (!(e instanceof TDieException)) {
					}
				} catch (Exception e) {
					this.e.printStackTrace();
				}
			}
		}
	}

	public void tDBConnection_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBConnection_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tSetGlobalVar_2_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tSetGlobalVar_2_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tFixedFlowInput_5_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFixedFlowInput_5_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tExtractJSONFields_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFixedFlowInput_5_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tLogRow_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFixedFlowInput_5_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tRESTResponse_5_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFixedFlowInput_5_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tPrejob_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tPrejob_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tSetGlobalVar_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tRESTRequest_1_Loop_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tRESTRequest_1_Loop_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		tRESTRequest_1_In_error(exception, errorComponent, globalMap);

	}

	public void tRESTRequest_1_In_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tRESTRequest_1_Loop_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDBConnection_1_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public void tSetGlobalVar_2_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public void tFixedFlowInput_5_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public void tPrejob_1_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public void tRESTRequest_1_Loop_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	private boolean runInTalendEsbRuntimeContainer = false;

	public void setRunInTalendEsbRuntimeContainer(boolean flag) {
		runInTalendEsbRuntimeContainer = flag;
	}

	protected String restEndpoint;

	public void setRestEndpoint(String restEndpoint) {
		this.restEndpoint = restEndpoint;
	}

	public String getRestEndpoint() {
		return "/api/v1";
	}

	private boolean runInDaemonMode = true;

	public void setRunInDaemonMode(boolean flag) {
		runInDaemonMode = flag;
	}

	private boolean restTalendJobAlreadyStarted = false;

	/**
	 * REST provider implementation
	 */
	@javax.ws.rs.Path("/")

	public static class RestServiceProviderImpl4TalendJob {

		@javax.ws.rs.core.Context
		private org.apache.cxf.jaxrs.ext.MessageContext messageContext;
		private final String setCookieHeader = "Set-Cookie";

		private final Copy_of_PostRequest job;

		public RestServiceProviderImpl4TalendJob(Copy_of_PostRequest job) {
			this.job = job;
		}

		private void populateRequestWithJobContext(java.util.Map<String, Object> requestGlobalMap,
				Copy_of_PostRequest job) {
			// pass job DataSources
			java.util.Map<String, routines.system.TalendDataSource> talendDataSources = (java.util.Map<String, routines.system.TalendDataSource>) job.globalMap
					.get(KEY_DB_DATASOURCES);
			if (null != talendDataSources) {
				java.util.Map<String, routines.system.TalendDataSource> restDataSources = new java.util.HashMap<String, routines.system.TalendDataSource>();
				for (java.util.Map.Entry<String, routines.system.TalendDataSource> talendDataSourceEntry : talendDataSources
						.entrySet()) {
					restDataSources.put(talendDataSourceEntry.getKey(),
							new routines.system.TalendDataSource(talendDataSourceEntry.getValue().getRawDataSource()));
				}
				requestGlobalMap.put(KEY_DB_DATASOURCES, restDataSources);
			}

			if (null != job.globalMap.get(KEY_DB_DATASOURCES_RAW)) {
				requestGlobalMap.put(KEY_DB_DATASOURCES_RAW, job.globalMap.get(KEY_DB_DATASOURCES_RAW));
			}

			// pass job shared connections
			requestGlobalMap.putAll(job.getSharedConnections4REST());

			// pass job concurrent map
			requestGlobalMap.put("concurrentHashMap", job.globalMap.get("concurrentHashMap"));

			requestGlobalMap.putAll(job.globalMap);
		}

		private void closePassedDataSourceConnections(java.util.Map<String, Object> requestGlobalMap) {
			// close connections in passed job DataSources
			try {
				java.util.Map<String, routines.system.TalendDataSource> restDataSources = (java.util.Map<String, routines.system.TalendDataSource>) requestGlobalMap
						.get(KEY_DB_DATASOURCES);
				if (null != restDataSources) {
					for (routines.system.TalendDataSource restDataSource : restDataSources.values()) {
						restDataSource.close();
					}
				}
			} catch (Throwable e) {
				e.printStackTrace(System.err);
			}
		}

		private javax.ws.rs.core.Response processRequest(java.util.Map<String, Object> request) {

			final java.util.Map<String, Object> globalMap = new java.util.HashMap<String, Object>();

			try {
				globalMap.put("restRequest", request);

				populateRequestWithJobContext(globalMap, job);

				job.tRESTRequest_1_LoopProcess(globalMap);

				java.util.Map<String, Object> response = (java.util.Map<String, Object>) globalMap.get("restResponse");

				Object responseBody = null;
				Integer status = null;
				java.util.Map<String, String> headers = null;
				if (null != response) {
					Object dropJsonRootProp = response.get("drop.json.root.element");
					Boolean dropJsonRoot = (null == dropJsonRootProp) ? false : (Boolean) dropJsonRootProp;
					messageContext.put("drop.json.root.element", dropJsonRoot.toString());

					responseBody = response.get("BODY");
					status = (Integer) response.get("STATUS");
					headers = (java.util.Map<String, String>) response.get("HEADERS");
				}
				if (null == status) {
					status = (request.containsKey("STATUS")) ? (Integer) request.get("STATUS") : 404;
				}

				javax.ws.rs.core.Response.ResponseBuilder responseBuilder = javax.ws.rs.core.Response.status(status)
						.entity(responseBody);
				if (headers != null) {
					for (java.util.Map.Entry<String, String> header : headers.entrySet()) {
						if (header.getKey().equalsIgnoreCase(setCookieHeader)) {
							String cookies = header.getValue().trim();
							String cookiesList[] = cookies.split(";");

							for (String cookie : cookiesList) {
								String cookieTokens[] = cookie.trim().split("=");

								if (cookieTokens.length == 2) {

									String cookieName = cookieTokens[0].trim();
									String cookieValue = cookieTokens[1].trim();

									if (cookieName.length() > 0 && cookieValue.length() > 0) {
										javax.ws.rs.core.NewCookie newCookie = new javax.ws.rs.core.NewCookie(
												cookieName, cookieValue);
										responseBuilder.cookie(newCookie);
									}
								}
							}
						} else {
							responseBuilder.header(header.getKey(), header.getValue());
						}
					}
				}

				return responseBuilder.build();

			} catch (Throwable ex) {
				ex.printStackTrace();
				throw new javax.ws.rs.WebApplicationException(ex, 500);
			} finally {
				// close DB connections
				closePassedDataSourceConnections(globalMap);
			}
		}

		private javax.ws.rs.core.Response processStreamingResponseRequest(final java.util.Map<String, Object> request) {

			javax.ws.rs.core.StreamingOutput streamingOutput = new javax.ws.rs.core.StreamingOutput() {
				public void write(java.io.OutputStream output) {

					final java.util.Map<String, Object> globalMap = new java.util.HashMap<String, Object>();

					try {
						globalMap.put("restResponseStream", output);

						globalMap.put("restRequest", request);

						populateRequestWithJobContext(globalMap, job);

						job.tRESTRequest_1_LoopProcess(globalMap);

						if (globalMap.containsKey("restResponseWrappingClosure")) {
							output.write(((String) globalMap.get("restResponseWrappingClosure")).getBytes());
						}
					} catch (Throwable ex) {
						ex.printStackTrace();
						throw new javax.ws.rs.WebApplicationException(ex, 500);
					} finally {
						// close DB connections
						closePassedDataSourceConnections(globalMap);
					}
				}
			};

			return javax.ws.rs.core.Response.ok().entity(streamingOutput).build();
		}

		@javax.ws.rs.POST()

		@javax.ws.rs.Path("/product")
		@javax.ws.rs.Consumes({ "application/json" })
		@javax.ws.rs.Produces({ "application/json" })
		public javax.ws.rs.core.Response header(

				@javax.ws.rs.HeaderParam("Authorization") String Authorization

				, org.dom4j.Document body

		) {
			java.util.Map<String, Object> request_tRESTRequest_1 = new java.util.HashMap<String, Object>();
			request_tRESTRequest_1.put("VERB", "POST");
			request_tRESTRequest_1.put("OPERATION", "header");
			request_tRESTRequest_1.put("PATTERN", "/product");

			request_tRESTRequest_1.put("BODY", body);

			populateRequestInfo(request_tRESTRequest_1, messageContext);

			java.util.Map<String, Object> parameters_tRESTRequest_1 = new java.util.HashMap<String, Object>();

			parameters_tRESTRequest_1.put("HEADER:Authorization:id_String", Authorization);

			request_tRESTRequest_1.put("PARAMS", parameters_tRESTRequest_1);

			return processRequest(request_tRESTRequest_1);
		}

		public javax.ws.rs.core.Response handleWrongRequest(org.apache.cxf.jaxrs.ext.MessageContext context, int status,
				String error) {

			// System.out.println("wrong call [uri: " + context.getUriInfo().getPath() + " ;
			// method: " + context.getRequest().getMethod() + " ; status: " + status + " ;
			// error: " + error + "]");

			java.util.Map<String, Object> wrongRequest = new java.util.HashMap<String, Object>();

			wrongRequest.put("ERROR", error);
			wrongRequest.put("STATUS", status);
			wrongRequest.put("VERB", context.getRequest().getMethod());
			wrongRequest.put("URI", context.getUriInfo().getPath());
			wrongRequest.put("URI_BASE", context.getUriInfo().getBaseUri().toString());
			wrongRequest.put("URI_ABSOLUTE", context.getUriInfo().getAbsolutePath().toString());
			wrongRequest.put("URI_REQUEST", context.getUriInfo().getRequestUri().toString());

			return processRequest(wrongRequest);
		}

		private void populateRequestInfo(java.util.Map<String, Object> request,
				org.apache.cxf.jaxrs.ext.MessageContext context) {
			final javax.ws.rs.core.UriInfo ui = context.getUriInfo();

			request.put("URI", ui.getPath());
			request.put("URI_BASE", ui.getBaseUri().toString());
			request.put("URI_ABSOLUTE", ui.getAbsolutePath().toString());
			request.put("URI_REQUEST", ui.getRequestUri().toString());

			request.put("ALL_HEADER_PARAMS", context.getHttpHeaders().getRequestHeaders());
			request.put("ALL_QUERY_PARAMS", ui.getQueryParameters());

			javax.ws.rs.core.SecurityContext securityContext = context.getSecurityContext();
			if (null != securityContext && null != securityContext.getUserPrincipal()) {
				request.put("PRINCIPAL_NAME", securityContext.getUserPrincipal().getName());
			}

			request.put("CorrelationID", context.get("CorrelationID"));

			request.put("MESSAGE_CONTEXT", context);
		}

		private void populateMultipartRequestInfo(java.util.Map<String, Object> request,
				org.apache.cxf.jaxrs.ext.MessageContext context, java.util.List<String> partNames) {
			java.util.Map<String, String> attachmentFilenames = new java.util.HashMap<String, String>();

			java.util.Map<String, java.util.Map<String, java.util.List<String>>> attachmentHeaders = new java.util.HashMap<String, java.util.Map<String, java.util.List<String>>>();

			for (String partName : partNames) {
				org.apache.cxf.jaxrs.ext.multipart.Attachment attachment = getFirstMatchingPart(context, partName);
				if (null != attachment) {
					attachmentHeaders.put(partName, attachment.getHeaders());
					if (null != attachment.getContentDisposition()) {
						String filename = attachment.getContentDisposition().getParameter("filename");
						if (null != filename) {
							attachmentFilenames.put(partName, filename);
						}
					}
				}
			}

			request.put("ATTACHMENT_HEADERS", attachmentHeaders);
			request.put("ATTACHMENT_FILENAMES", attachmentFilenames);
		}

		private static org.apache.cxf.jaxrs.ext.multipart.Attachment getFirstMatchingPart(
				org.apache.cxf.jaxrs.ext.MessageContext context, String partName) {
			List<org.apache.cxf.jaxrs.ext.multipart.Attachment> attachments = org.apache.cxf.jaxrs.utils.multipart.AttachmentUtils
					.getAttachments(context);
			for (org.apache.cxf.jaxrs.ext.multipart.Attachment attachment : attachments) {
				if (partName.equals(attachment.getContentId())) {
					return attachment;
				}
				org.apache.cxf.jaxrs.ext.multipart.ContentDisposition cd = attachment.getContentDisposition();
				if (null != cd && partName.equals(cd.getParameter("name"))) {
					return attachment;
				}
			}
			// unexpected
			throw new javax.ws.rs.InternalServerErrorException();
		}
	}

	public static class ExceptionMapper4TalendJobRestService
			extends org.apache.cxf.jaxrs.impl.WebApplicationExceptionMapper {

		@javax.ws.rs.core.Context
		private org.apache.cxf.jaxrs.ext.MessageContext messageContext;

		private RestServiceProviderImpl4TalendJob provider;

		public ExceptionMapper4TalendJobRestService(RestServiceProviderImpl4TalendJob provider) {
			this.provider = provider;
		}

		public javax.ws.rs.core.Response toResponse(javax.ws.rs.WebApplicationException ex) {
			String error = null;
			javax.ws.rs.core.Response response = ex.getResponse();
			if (null != response && null != response.getEntity()) {
				error = response.getEntity().toString();
			}
			response = super.toResponse(ex);
			if (null == error) {
				if (null != response && null != response.getEntity()) {
					error = response.getEntity().toString();
				} else {
					error = null == ex.getCause() ? ex.getMessage() : ex.getCause().getMessage();
				}
			}
			response = provider.handleWrongRequest(messageContext, response.getStatus(), error);

			java.util.List<javax.ws.rs.core.MediaType> accepts = messageContext.getHttpHeaders()
					.getAcceptableMediaTypes();
			javax.ws.rs.core.MediaType responseType = accepts.isEmpty() ? null : accepts.get(0);

			if (responseType == null
					|| !responseType.getSubtype().equals("xml") && !responseType.getSubtype().equals("json")) {
				responseType = javax.ws.rs.core.MediaType.APPLICATION_XML_TYPE;
			}

			javax.ws.rs.core.Response r = javax.ws.rs.core.Response.status(response.getStatus())
					.entity(response.getEntity()).type(responseType).build();

			if (response.getHeaders() != null) {
				r.getHeaders().putAll(response.getHeaders());
			}

			return r;
		}
	}

	protected String checkEndpointUrl(String url) {
		final String defaultEndpointUrl = "http://127.0.0.1:8090/";

		String endpointUrl = url;
		if (null == endpointUrl || endpointUrl.trim().isEmpty()) {
			endpointUrl = defaultEndpointUrl;
		} else if (!endpointUrl.contains("://")) { // relative
			if (endpointUrl.startsWith("/")) {
				endpointUrl = endpointUrl.substring(1);
			}
			endpointUrl = defaultEndpointUrl + endpointUrl;
		}

		// test for busy
		java.net.URI endpointURI = java.net.URI.create(endpointUrl);
		String host = endpointURI.getHost();
		try {
			if (java.net.InetAddress.getByName(host).isLoopbackAddress()) {
				int port = endpointURI.getPort();
				java.net.ServerSocket ss = null;
				try {
					ss = new java.net.ServerSocket(port);
				} catch (IOException e) {
					// rethrow exception
					throw new IllegalArgumentException(
							"Cannot start provider with uri: " + endpointUrl + ". Port " + port + " already in use.");
				} finally {
					if (ss != null) {
						try {
							ss.close();
						} catch (IOException e) {
							// ignore
						}
					}
				}
				try {
					// ok, let's doublecheck for silent listeners
					java.net.Socket cs = new java.net.Socket(host, port);
					// if succeed - somebody silently listening, fail!
					cs.close();
					// rethrow exception
					throw new IllegalArgumentException(
							"Cannot start provider with uri: " + endpointUrl + ". Port " + port + " already in use.");
				} catch (IOException e) {
					// ok, nobody listens, proceed
				}
			}
		} catch (java.net.UnknownHostException e) {
			// ignore
		}

		return endpointUrl;
	}

	public static class StreamingDOM4JProvider extends org.apache.cxf.jaxrs.provider.dom4j.DOM4JProvider {

		public static final String SUPRESS_XML_DECLARATION = "supress.xml.declaration";

		private java.util.Map<String, Object> globalMap = null;

		public void setGlobalMap(java.util.Map<String, Object> globalMap) {
			this.globalMap = globalMap;
		}

		public void writeTo(org.dom4j.Document doc, Class<?> cls, java.lang.reflect.Type type,
				java.lang.annotation.Annotation[] anns, javax.ws.rs.core.MediaType mt,
				javax.ws.rs.core.MultivaluedMap<String, Object> headers, java.io.OutputStream os)
				throws java.io.IOException, javax.ws.rs.WebApplicationException {
			if (mt.getSubtype().contains("xml")) {
				org.dom4j.io.XMLWriter writer;
				org.apache.cxf.message.Message currentMessage = null;
				if (org.apache.cxf.jaxrs.utils.JAXRSUtils.getCurrentMessage() != null) {
					currentMessage = org.apache.cxf.jaxrs.utils.JAXRSUtils.getCurrentMessage();
				} else {
					currentMessage = (org.apache.cxf.message.Message) ((java.util.Map<String, Object>) globalMap
							.get("restRequest")).get("CURRENT_MESSAGE");
				}

				if (currentMessage != null && currentMessage.getExchange() != null
						&& currentMessage.getExchange().containsKey(SUPRESS_XML_DECLARATION)) {
					org.dom4j.io.OutputFormat format = new org.dom4j.io.OutputFormat();
					format.setSuppressDeclaration(true);
					writer = new org.dom4j.io.XMLWriter(os, format);
				} else {
					writer = new org.dom4j.io.XMLWriter(os);
				}
				writer.write(doc);
				writer.flush();
			} else {
				super.writeTo(doc, cls, type, anns, mt, headers, os);
			}
		}
	}

	Thread4RestServiceProviderEndpoint thread4RestServiceProviderEndpoint = null;

	class Thread4RestServiceProviderEndpoint extends Thread {

		private final String endpointUrl;

		private final Copy_of_PostRequest job;

		private org.apache.cxf.endpoint.Server server;

		private org.apache.cxf.jaxrs.JAXRSServerFactoryBean sf;

		public Thread4RestServiceProviderEndpoint(Copy_of_PostRequest job, String endpointUrl) {
			this.job = job;
			this.endpointUrl = endpointUrl;
			this.sf = new org.apache.cxf.jaxrs.JAXRSServerFactoryBean();
		}

		boolean inOSGi = routines.system.BundleUtils.inOSGi();

		public org.apache.cxf.endpoint.Server getServer() {
			return server;
		}

		public org.apache.cxf.jaxrs.JAXRSServerFactoryBean getJAXRSServerFactoryBean() {
			return sf;
		}

		public void run() {

			try {
				RestServiceProviderImpl4TalendJob provider = new RestServiceProviderImpl4TalendJob(job);

				if (sf.getProperties() == null) {
					sf.setProperties(new java.util.HashMap<String, Object>());
				}

				java.util.List<Object> providers = (java.util.List<Object>) sf.getProviders();
				providers.add(new ExceptionMapper4TalendJobRestService(provider));
				providers.add(new StreamingDOM4JProvider());

				org.apache.cxf.jaxrs.provider.json.JSONProvider jsonProvider = new org.apache.cxf.jaxrs.provider.json.JSONProvider();
				jsonProvider.setIgnoreNamespaces(true);

				jsonProvider.setAttributesToElements(true);

				jsonProvider.setConvertTypesToStrings(false);

				providers.add(jsonProvider);
				sf.setProviders(providers);
				sf.setTransportId("http://cxf.apache.org/transports/http");
				sf.setResourceClasses(RestServiceProviderImpl4TalendJob.class);
				sf.setResourceProvider(RestServiceProviderImpl4TalendJob.class,
						new org.apache.cxf.jaxrs.lifecycle.SingletonResourceProvider(provider));
				sf.setAddress(endpointUrl);

				final java.util.List<org.apache.cxf.feature.Feature> features = sf.getFeatures() == null
						? new java.util.ArrayList<org.apache.cxf.feature.Feature>()
						: sf.getFeatures();

				sf.setFeatures(features);

				server = sf.create();

				// System.out.println("REST service [endpoint: " + endpointUrl + "] published");
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}

		public void stopEndpoint() {
			if (null != server) {
				server.stop();
				server.destroy();
				// System.out.println("REST service [endpoint: " + endpointUrl + "]
				// unpublished");
			}
		}
	}

	public static class ContextBean {
		static String evaluate(String context, String contextExpression)
				throws IOException, javax.script.ScriptException {
			boolean isExpression = contextExpression.contains("+") || contextExpression.contains("(");
			final String prefix = isExpression ? "\"" : "";
			java.util.Properties defaultProps = new java.util.Properties();
			java.io.InputStream inContext = Copy_of_PostRequest.class.getClassLoader()
					.getResourceAsStream("salesforce/copy_of_postrequest_0_1/contexts/" + context + ".properties");
			if (inContext == null) {
				inContext = Copy_of_PostRequest.class.getClassLoader()
						.getResourceAsStream("config/contexts/" + context + ".properties");
			}
			try {
				defaultProps.load(inContext);
			} finally {
				inContext.close();
			}
			java.util.regex.Pattern pattern = java.util.regex.Pattern.compile("context.([\\w]+)");
			java.util.regex.Matcher matcher = pattern.matcher(contextExpression);

			while (matcher.find()) {
				contextExpression = contextExpression.replaceAll(matcher.group(0),
						prefix + defaultProps.getProperty(matcher.group(1)) + prefix);
			}
			if (contextExpression.startsWith("/services")) {
				contextExpression = contextExpression.replaceFirst("/services", "");
			}
			return isExpression ? evaluateContextExpression(contextExpression) : contextExpression;
		}

		public static String evaluateContextExpression(String expression) throws javax.script.ScriptException {
			javax.script.ScriptEngineManager manager = new javax.script.ScriptEngineManager();
			javax.script.ScriptEngine engine = manager.getEngineByName("nashorn");
			// Add some import for Java
			expression = expression.replaceAll("System.getProperty", "java.lang.System.getProperty");
			return engine.eval(expression).toString();
		}

		public static String getContext(String context, String contextName, String jobName) throws Exception {

			String currentContext = null;
			String jobNameStripped = jobName.substring(jobName.lastIndexOf(".") + 1);

			boolean inOSGi = routines.system.BundleUtils.inOSGi();

			if (inOSGi) {
				java.util.Dictionary<String, Object> jobProperties = routines.system.BundleUtils
						.getJobProperties(jobNameStripped);

				if (jobProperties != null) {
					currentContext = (String) jobProperties.get("context");
				}
			}

			return contextName.contains("context.")
					? evaluate(currentContext == null ? context : currentContext, contextName)
					: contextName;
		}
	}

	public void tDBConnection_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tDBConnection_1_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		String iterateId = "";

		String currentComponent = "";
		java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

		try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { // start the resume
				globalResumeTicket = true;

				/**
				 * [tDBConnection_1 begin ] start
				 */

				ok_Hash.put("tDBConnection_1", false);
				start_Hash.put("tDBConnection_1", System.currentTimeMillis());

				currentComponent = "tDBConnection_1";

				int tos_count_tDBConnection_1 = 0;

				if (log.isDebugEnabled())
					log.debug("tDBConnection_1 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tDBConnection_1 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tDBConnection_1 = new StringBuilder();
							log4jParamters_tDBConnection_1.append("Parameters:");
							log4jParamters_tDBConnection_1.append("DB_VERSION" + " = " + "V9_X");
							log4jParamters_tDBConnection_1.append(" | ");
							log4jParamters_tDBConnection_1.append("HOST" + " = " + "\"localhost\"");
							log4jParamters_tDBConnection_1.append(" | ");
							log4jParamters_tDBConnection_1.append("PORT" + " = " + "\"5433\"");
							log4jParamters_tDBConnection_1.append(" | ");
							log4jParamters_tDBConnection_1.append("DBNAME" + " = " + "\"restapi\"");
							log4jParamters_tDBConnection_1.append(" | ");
							log4jParamters_tDBConnection_1.append("SCHEMA_DB" + " = " + "\"API_TALEND\"");
							log4jParamters_tDBConnection_1.append(" | ");
							log4jParamters_tDBConnection_1.append("USER" + " = " + "\"postgres\"");
							log4jParamters_tDBConnection_1.append(" | ");
							log4jParamters_tDBConnection_1.append("PASS" + " = " + String.valueOf(
									"enc:routine.encryption.key.v1:RD0eL+VmriLpWwwTczpspN7K0iL9ogbQFzmWRs+UTx0=")
									.substring(0, 4) + "...");
							log4jParamters_tDBConnection_1.append(" | ");
							log4jParamters_tDBConnection_1.append("USE_SHARED_CONNECTION" + " = " + "false");
							log4jParamters_tDBConnection_1.append(" | ");
							log4jParamters_tDBConnection_1.append("SPECIFY_DATASOURCE_ALIAS" + " = " + "false");
							log4jParamters_tDBConnection_1.append(" | ");
							log4jParamters_tDBConnection_1.append("PROPERTIES" + " = " + "\"\"");
							log4jParamters_tDBConnection_1.append(" | ");
							log4jParamters_tDBConnection_1.append("AUTO_COMMIT" + " = " + "true");
							log4jParamters_tDBConnection_1.append(" | ");
							log4jParamters_tDBConnection_1
									.append("UNIFIED_COMPONENTS" + " = " + "tPostgresqlConnection");
							log4jParamters_tDBConnection_1.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tDBConnection_1 - " + (log4jParamters_tDBConnection_1));
						}
					}
					new BytesLimit65535_tDBConnection_1().limitLog4jByte();
				}

				String dbProperties_tDBConnection_1 = "";
				String url_tDBConnection_1 = "jdbc:postgresql://" + "localhost" + ":" + "5433" + "/" + "restapi";

				if (dbProperties_tDBConnection_1 != null && !"".equals(dbProperties_tDBConnection_1.trim())) {
					url_tDBConnection_1 = url_tDBConnection_1 + "?" + dbProperties_tDBConnection_1;
				}
				String dbUser_tDBConnection_1 = "postgres";

				final String decryptedPassword_tDBConnection_1 = routines.system.PasswordEncryptUtil
						.decryptPassword("enc:routine.encryption.key.v1:sxLXl20DyLAUks6q6fFR4/KbVQjMZ0Z4jyuxNGi/Cmo=");
				String dbPwd_tDBConnection_1 = decryptedPassword_tDBConnection_1;

				java.sql.Connection conn_tDBConnection_1 = null;

				java.util.Enumeration<java.sql.Driver> drivers_tDBConnection_1 = java.sql.DriverManager.getDrivers();
				java.util.Set<String> redShiftDriverNames_tDBConnection_1 = new java.util.HashSet<String>(
						java.util.Arrays.asList("com.amazon.redshift.jdbc.Driver", "com.amazon.redshift.jdbc41.Driver",
								"com.amazon.redshift.jdbc42.Driver"));
				while (drivers_tDBConnection_1.hasMoreElements()) {
					java.sql.Driver d_tDBConnection_1 = drivers_tDBConnection_1.nextElement();
					if (redShiftDriverNames_tDBConnection_1.contains(d_tDBConnection_1.getClass().getName())) {
						try {
							java.sql.DriverManager.deregisterDriver(d_tDBConnection_1);
							java.sql.DriverManager.registerDriver(d_tDBConnection_1);
						} catch (java.lang.Exception e_tDBConnection_1) {
							globalMap.put("tDBConnection_1_ERROR_MESSAGE", e_tDBConnection_1.getMessage());
							// do nothing
						}
					}
				}
				String driverClass_tDBConnection_1 = "org.postgresql.Driver";
				java.lang.Class jdbcclazz_tDBConnection_1 = java.lang.Class.forName(driverClass_tDBConnection_1);
				globalMap.put("driverClass_tDBConnection_1", driverClass_tDBConnection_1);

				log.debug("tDBConnection_1 - Driver ClassName: " + driverClass_tDBConnection_1 + ".");

				log.debug("tDBConnection_1 - Connection attempt to '" + url_tDBConnection_1 + "' with the username '"
						+ dbUser_tDBConnection_1 + "'.");

				conn_tDBConnection_1 = java.sql.DriverManager.getConnection(url_tDBConnection_1, dbUser_tDBConnection_1,
						dbPwd_tDBConnection_1);
				log.debug("tDBConnection_1 - Connection to '" + url_tDBConnection_1 + "' has succeeded.");

				globalMap.put("conn_tDBConnection_1", conn_tDBConnection_1);
				if (null != conn_tDBConnection_1) {

					log.debug("tDBConnection_1 - Connection is set auto commit to 'true'.");
					conn_tDBConnection_1.setAutoCommit(true);
				}

				globalMap.put("schema_" + "tDBConnection_1", "API_TALEND");

				/**
				 * [tDBConnection_1 begin ] stop
				 */

				/**
				 * [tDBConnection_1 main ] start
				 */

				currentComponent = "tDBConnection_1";

				tos_count_tDBConnection_1++;

				/**
				 * [tDBConnection_1 main ] stop
				 */

				/**
				 * [tDBConnection_1 process_data_begin ] start
				 */

				currentComponent = "tDBConnection_1";

				/**
				 * [tDBConnection_1 process_data_begin ] stop
				 */

				/**
				 * [tDBConnection_1 process_data_end ] start
				 */

				currentComponent = "tDBConnection_1";

				/**
				 * [tDBConnection_1 process_data_end ] stop
				 */

				/**
				 * [tDBConnection_1 end ] start
				 */

				currentComponent = "tDBConnection_1";

				if (log.isDebugEnabled())
					log.debug("tDBConnection_1 - " + ("Done."));

				ok_Hash.put("tDBConnection_1", true);
				end_Hash.put("tDBConnection_1", System.currentTimeMillis());

				if (execStat) {
					runStat.updateStatOnConnection("OnComponentOk3", 0, "ok");
				}
				tSetGlobalVar_2Process(globalMap);

				/**
				 * [tDBConnection_1 end ] stop
				 */
			} // end the resume

		} catch (java.lang.Exception e) {

			if (!(e instanceof TalendException)) {
				log.fatal(currentComponent + " " + e.getMessage(), e);
			}

			TalendException te = new TalendException(e, currentComponent, globalMap);

			throw te;
		} catch (java.lang.Error error) {

			runStat.stopThreadStat();

			throw error;
		} finally {

			try {

				/**
				 * [tDBConnection_1 finally ] start
				 */

				currentComponent = "tDBConnection_1";

				/**
				 * [tDBConnection_1 finally ] stop
				 */
			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tDBConnection_1_SUBPROCESS_STATE", 1);
	}

	public void tSetGlobalVar_2Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tSetGlobalVar_2_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		String iterateId = "";

		String currentComponent = "";
		java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

		try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { // start the resume
				globalResumeTicket = true;

				/**
				 * [tSetGlobalVar_2 begin ] start
				 */

				ok_Hash.put("tSetGlobalVar_2", false);
				start_Hash.put("tSetGlobalVar_2", System.currentTimeMillis());

				currentComponent = "tSetGlobalVar_2";

				int tos_count_tSetGlobalVar_2 = 0;

				if (log.isDebugEnabled())
					log.debug("tSetGlobalVar_2 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tSetGlobalVar_2 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tSetGlobalVar_2 = new StringBuilder();
							log4jParamters_tSetGlobalVar_2.append("Parameters:");
							log4jParamters_tSetGlobalVar_2.append("VARIABLES" + " = " + "[{VALUE="
									+ ("new TokenValidatorService(context.azure_tenant_id, context.azure_client_id)")
									+ ", KEY=" + ("\"tokenValidatorService\"") + "}]");
							log4jParamters_tSetGlobalVar_2.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tSetGlobalVar_2 - " + (log4jParamters_tSetGlobalVar_2));
						}
					}
					new BytesLimit65535_tSetGlobalVar_2().limitLog4jByte();
				}

				/**
				 * [tSetGlobalVar_2 begin ] stop
				 */

				/**
				 * [tSetGlobalVar_2 main ] start
				 */

				currentComponent = "tSetGlobalVar_2";

				globalMap.put("tokenValidatorService",
						new TokenValidatorService(context.azure_tenant_id, context.azure_client_id));

				tos_count_tSetGlobalVar_2++;

				/**
				 * [tSetGlobalVar_2 main ] stop
				 */

				/**
				 * [tSetGlobalVar_2 process_data_begin ] start
				 */

				currentComponent = "tSetGlobalVar_2";

				/**
				 * [tSetGlobalVar_2 process_data_begin ] stop
				 */

				/**
				 * [tSetGlobalVar_2 process_data_end ] start
				 */

				currentComponent = "tSetGlobalVar_2";

				/**
				 * [tSetGlobalVar_2 process_data_end ] stop
				 */

				/**
				 * [tSetGlobalVar_2 end ] start
				 */

				currentComponent = "tSetGlobalVar_2";

				if (log.isDebugEnabled())
					log.debug("tSetGlobalVar_2 - " + ("Done."));

				ok_Hash.put("tSetGlobalVar_2", true);
				end_Hash.put("tSetGlobalVar_2", System.currentTimeMillis());

				/**
				 * [tSetGlobalVar_2 end ] stop
				 */
			} // end the resume

		} catch (java.lang.Exception e) {

			if (!(e instanceof TalendException)) {
				log.fatal(currentComponent + " " + e.getMessage(), e);
			}

			TalendException te = new TalendException(e, currentComponent, globalMap);

			throw te;
		} catch (java.lang.Error error) {

			runStat.stopThreadStat();

			throw error;
		} finally {

			try {

				/**
				 * [tSetGlobalVar_2 finally ] start
				 */

				currentComponent = "tSetGlobalVar_2";

				/**
				 * [tSetGlobalVar_2 finally ] stop
				 */
			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tSetGlobalVar_2_SUBPROCESS_STATE", 1);
	}

	public static class row7Struct implements routines.system.IPersistableRow<row7Struct> {
		final static byte[] commonByteArrayLock_SALESFORCE_Copy_of_PostRequest = new byte[0];
		static byte[] commonByteArray_SALESFORCE_Copy_of_PostRequest = new byte[0];

		public String test;

		public String getTest() {
			return this.test;
		}

		public String newColumn;

		public String getNewColumn() {
			return this.newColumn;
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_SALESFORCE_Copy_of_PostRequest.length) {
					if (length < 1024 && commonByteArray_SALESFORCE_Copy_of_PostRequest.length == 0) {
						commonByteArray_SALESFORCE_Copy_of_PostRequest = new byte[1024];
					} else {
						commonByteArray_SALESFORCE_Copy_of_PostRequest = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_SALESFORCE_Copy_of_PostRequest, 0, length);
				strReturn = new String(commonByteArray_SALESFORCE_Copy_of_PostRequest, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_SALESFORCE_Copy_of_PostRequest.length) {
					if (length < 1024 && commonByteArray_SALESFORCE_Copy_of_PostRequest.length == 0) {
						commonByteArray_SALESFORCE_Copy_of_PostRequest = new byte[1024];
					} else {
						commonByteArray_SALESFORCE_Copy_of_PostRequest = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_SALESFORCE_Copy_of_PostRequest, 0, length);
				strReturn = new String(commonByteArray_SALESFORCE_Copy_of_PostRequest, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_SALESFORCE_Copy_of_PostRequest) {

				try {

					int length = 0;

					this.test = readString(dis);

					this.newColumn = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_SALESFORCE_Copy_of_PostRequest) {

				try {

					int length = 0;

					this.test = readString(dis);

					this.newColumn = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.test, dos);

				// String

				writeString(this.newColumn, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.test, dos);

				// String

				writeString(this.newColumn, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("test=" + test);
			sb.append(",newColumn=" + newColumn);
			sb.append("]");

			return sb.toString();
		}

		public String toLogString() {
			StringBuilder sb = new StringBuilder();

			if (test == null) {
				sb.append("<null>");
			} else {
				sb.append(test);
			}

			sb.append("|");

			if (newColumn == null) {
				sb.append("<null>");
			} else {
				sb.append(newColumn);
			}

			sb.append("|");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(row7Struct other) {

			int returnValue = -1;

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(), object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public static class row6Struct implements routines.system.IPersistableRow<row6Struct> {
		final static byte[] commonByteArrayLock_SALESFORCE_Copy_of_PostRequest = new byte[0];
		static byte[] commonByteArray_SALESFORCE_Copy_of_PostRequest = new byte[0];

		public String test;

		public String getTest() {
			return this.test;
		}

		public String newColumn;

		public String getNewColumn() {
			return this.newColumn;
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_SALESFORCE_Copy_of_PostRequest.length) {
					if (length < 1024 && commonByteArray_SALESFORCE_Copy_of_PostRequest.length == 0) {
						commonByteArray_SALESFORCE_Copy_of_PostRequest = new byte[1024];
					} else {
						commonByteArray_SALESFORCE_Copy_of_PostRequest = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_SALESFORCE_Copy_of_PostRequest, 0, length);
				strReturn = new String(commonByteArray_SALESFORCE_Copy_of_PostRequest, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_SALESFORCE_Copy_of_PostRequest.length) {
					if (length < 1024 && commonByteArray_SALESFORCE_Copy_of_PostRequest.length == 0) {
						commonByteArray_SALESFORCE_Copy_of_PostRequest = new byte[1024];
					} else {
						commonByteArray_SALESFORCE_Copy_of_PostRequest = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_SALESFORCE_Copy_of_PostRequest, 0, length);
				strReturn = new String(commonByteArray_SALESFORCE_Copy_of_PostRequest, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_SALESFORCE_Copy_of_PostRequest) {

				try {

					int length = 0;

					this.test = readString(dis);

					this.newColumn = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_SALESFORCE_Copy_of_PostRequest) {

				try {

					int length = 0;

					this.test = readString(dis);

					this.newColumn = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.test, dos);

				// String

				writeString(this.newColumn, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.test, dos);

				// String

				writeString(this.newColumn, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("test=" + test);
			sb.append(",newColumn=" + newColumn);
			sb.append("]");

			return sb.toString();
		}

		public String toLogString() {
			StringBuilder sb = new StringBuilder();

			if (test == null) {
				sb.append("<null>");
			} else {
				sb.append(test);
			}

			sb.append("|");

			if (newColumn == null) {
				sb.append("<null>");
			} else {
				sb.append(newColumn);
			}

			sb.append("|");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(row6Struct other) {

			int returnValue = -1;

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(), object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public static class row4Struct implements routines.system.IPersistableRow<row4Struct> {
		final static byte[] commonByteArrayLock_SALESFORCE_Copy_of_PostRequest = new byte[0];
		static byte[] commonByteArray_SALESFORCE_Copy_of_PostRequest = new byte[0];

		public routines.system.Document body;

		public routines.system.Document getBody() {
			return this.body;
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_SALESFORCE_Copy_of_PostRequest) {

				try {

					int length = 0;

					this.body = (routines.system.Document) dis.readObject();

				} catch (IOException e) {
					throw new RuntimeException(e);

				} catch (ClassNotFoundException eCNFE) {
					throw new RuntimeException(eCNFE);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_SALESFORCE_Copy_of_PostRequest) {

				try {

					int length = 0;

					this.body = (routines.system.Document) dis.readObject();

				} catch (IOException e) {
					throw new RuntimeException(e);

				} catch (ClassNotFoundException eCNFE) {
					throw new RuntimeException(eCNFE);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// Document

				dos.writeObject(this.body);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// Document

				dos.writeObject(this.body);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("body=" + String.valueOf(body));
			sb.append("]");

			return sb.toString();
		}

		public String toLogString() {
			StringBuilder sb = new StringBuilder();

			if (body == null) {
				sb.append("<null>");
			} else {
				sb.append(body);
			}

			sb.append("|");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(row4Struct other) {

			int returnValue = -1;

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(), object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public void tFixedFlowInput_5Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tFixedFlowInput_5_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		String iterateId = "";

		String currentComponent = "";
		java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

		try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { // start the resume
				globalResumeTicket = true;

				row4Struct row4 = new row4Struct();
				row6Struct row6 = new row6Struct();
				row6Struct row7 = row6;

				/**
				 * [tRESTResponse_5 begin ] start
				 */

				ok_Hash.put("tRESTResponse_5", false);
				start_Hash.put("tRESTResponse_5", System.currentTimeMillis());

				currentComponent = "tRESTResponse_5";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "row7");
				}

				int tos_count_tRESTResponse_5 = 0;

				/**
				 * [tRESTResponse_5 begin ] stop
				 */

				/**
				 * [tLogRow_1 begin ] start
				 */

				ok_Hash.put("tLogRow_1", false);
				start_Hash.put("tLogRow_1", System.currentTimeMillis());

				currentComponent = "tLogRow_1";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "row6");
				}

				int tos_count_tLogRow_1 = 0;

				if (log.isDebugEnabled())
					log.debug("tLogRow_1 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tLogRow_1 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tLogRow_1 = new StringBuilder();
							log4jParamters_tLogRow_1.append("Parameters:");
							log4jParamters_tLogRow_1.append("BASIC_MODE" + " = " + "false");
							log4jParamters_tLogRow_1.append(" | ");
							log4jParamters_tLogRow_1.append("TABLE_PRINT" + " = " + "true");
							log4jParamters_tLogRow_1.append(" | ");
							log4jParamters_tLogRow_1.append("VERTICAL" + " = " + "false");
							log4jParamters_tLogRow_1.append(" | ");
							log4jParamters_tLogRow_1.append("PRINT_CONTENT_WITH_LOG4J" + " = " + "true");
							log4jParamters_tLogRow_1.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tLogRow_1 - " + (log4jParamters_tLogRow_1));
						}
					}
					new BytesLimit65535_tLogRow_1().limitLog4jByte();
				}

				///////////////////////

				class Util_tLogRow_1 {

					String[] des_top = { ".", ".", "-", "+" };

					String[] des_head = { "|=", "=|", "-", "+" };

					String[] des_bottom = { "'", "'", "-", "+" };

					String name = "";

					java.util.List<String[]> list = new java.util.ArrayList<String[]>();

					int[] colLengths = new int[2];

					public void addRow(String[] row) {

						for (int i = 0; i < 2; i++) {
							if (row[i] != null) {
								colLengths[i] = Math.max(colLengths[i], row[i].length());
							}
						}
						list.add(row);
					}

					public void setTableName(String name) {

						this.name = name;
					}

					public StringBuilder format() {

						StringBuilder sb = new StringBuilder();

						sb.append(print(des_top));

						int totals = 0;
						for (int i = 0; i < colLengths.length; i++) {
							totals = totals + colLengths[i];
						}

						// name
						sb.append("|");
						int k = 0;
						for (k = 0; k < (totals + 1 - name.length()) / 2; k++) {
							sb.append(' ');
						}
						sb.append(name);
						for (int i = 0; i < totals + 1 - name.length() - k; i++) {
							sb.append(' ');
						}
						sb.append("|\n");

						// head and rows
						sb.append(print(des_head));
						for (int i = 0; i < list.size(); i++) {

							String[] row = list.get(i);

							java.util.Formatter formatter = new java.util.Formatter(new StringBuilder());

							StringBuilder sbformat = new StringBuilder();
							sbformat.append("|%1$-");
							sbformat.append(colLengths[0]);
							sbformat.append("s");

							sbformat.append("|%2$-");
							sbformat.append(colLengths[1]);
							sbformat.append("s");

							sbformat.append("|\n");

							formatter.format(sbformat.toString(), (Object[]) row);

							sb.append(formatter.toString());
							if (i == 0)
								sb.append(print(des_head)); // print the head
						}

						// end
						sb.append(print(des_bottom));
						return sb;
					}

					private StringBuilder print(String[] fillChars) {
						StringBuilder sb = new StringBuilder();
						// first column
						sb.append(fillChars[0]);
						for (int i = 0; i < colLengths[0] - fillChars[0].length() + 1; i++) {
							sb.append(fillChars[2]);
						}
						sb.append(fillChars[3]);

						// last column
						for (int i = 0; i < colLengths[1] - fillChars[1].length() + 1; i++) {
							sb.append(fillChars[2]);
						}
						sb.append(fillChars[1]);
						sb.append("\n");
						return sb;
					}

					public boolean isTableEmpty() {
						if (list.size() > 1)
							return false;
						return true;
					}
				}
				Util_tLogRow_1 util_tLogRow_1 = new Util_tLogRow_1();
				util_tLogRow_1.setTableName("tLogRow_1");
				util_tLogRow_1.addRow(new String[] { "test", "newColumn", });
				StringBuilder strBuffer_tLogRow_1 = null;
				int nb_line_tLogRow_1 = 0;
///////////////////////    			

				/**
				 * [tLogRow_1 begin ] stop
				 */

				/**
				 * [tExtractJSONFields_1 begin ] start
				 */

				ok_Hash.put("tExtractJSONFields_1", false);
				start_Hash.put("tExtractJSONFields_1", System.currentTimeMillis());

				currentComponent = "tExtractJSONFields_1";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "row4");
				}

				int tos_count_tExtractJSONFields_1 = 0;

				if (log.isDebugEnabled())
					log.debug("tExtractJSONFields_1 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tExtractJSONFields_1 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tExtractJSONFields_1 = new StringBuilder();
							log4jParamters_tExtractJSONFields_1.append("Parameters:");
							log4jParamters_tExtractJSONFields_1.append("READ_BY" + " = " + "JSONPATH");
							log4jParamters_tExtractJSONFields_1.append(" | ");
							log4jParamters_tExtractJSONFields_1.append("JSON_PATH_VERSION" + " = " + "2_1_0");
							log4jParamters_tExtractJSONFields_1.append(" | ");
							log4jParamters_tExtractJSONFields_1.append("JSONFIELD" + " = " + "body");
							log4jParamters_tExtractJSONFields_1.append(" | ");
							log4jParamters_tExtractJSONFields_1.append("JSON_LOOP_QUERY" + " = " + "\"$\"");
							log4jParamters_tExtractJSONFields_1.append(" | ");
							log4jParamters_tExtractJSONFields_1.append("MAPPING_4_JSONPATH" + " = " + "[{QUERY="
									+ ("\"products.product.CD_PRODUIT\"") + ", SCHEMA_COLUMN=" + ("test") + "}, {QUERY="
									+ ("\"products.product.NOM_PRODUIT\"") + ", SCHEMA_COLUMN=" + ("newColumn") + "}]");
							log4jParamters_tExtractJSONFields_1.append(" | ");
							log4jParamters_tExtractJSONFields_1.append("DIE_ON_ERROR" + " = " + "false");
							log4jParamters_tExtractJSONFields_1.append(" | ");
							log4jParamters_tExtractJSONFields_1.append("USE_LOOP_AS_ROOT" + " = " + "true");
							log4jParamters_tExtractJSONFields_1.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tExtractJSONFields_1 - " + (log4jParamters_tExtractJSONFields_1));
						}
					}
					new BytesLimit65535_tExtractJSONFields_1().limitLog4jByte();
				}

				int nb_line_tExtractJSONFields_1 = 0;
				String jsonStr_tExtractJSONFields_1 = "";

				class JsonPathCache_tExtractJSONFields_1 {
					final java.util.Map<String, com.jayway.jsonpath.JsonPath> jsonPathString2compiledJsonPath = new java.util.HashMap<String, com.jayway.jsonpath.JsonPath>();

					public com.jayway.jsonpath.JsonPath getCompiledJsonPath(String jsonPath) {
						if (jsonPathString2compiledJsonPath.containsKey(jsonPath)) {
							return jsonPathString2compiledJsonPath.get(jsonPath);
						} else {
							com.jayway.jsonpath.JsonPath compiledLoopPath = com.jayway.jsonpath.JsonPath
									.compile(jsonPath);
							jsonPathString2compiledJsonPath.put(jsonPath, compiledLoopPath);
							return compiledLoopPath;
						}
					}
				}

				JsonPathCache_tExtractJSONFields_1 jsonPathCache_tExtractJSONFields_1 = new JsonPathCache_tExtractJSONFields_1();

				/**
				 * [tExtractJSONFields_1 begin ] stop
				 */

				/**
				 * [tFixedFlowInput_5 begin ] start
				 */

				ok_Hash.put("tFixedFlowInput_5", false);
				start_Hash.put("tFixedFlowInput_5", System.currentTimeMillis());

				currentComponent = "tFixedFlowInput_5";

				int tos_count_tFixedFlowInput_5 = 0;

				for (int i_tFixedFlowInput_5 = 0; i_tFixedFlowInput_5 < 1; i_tFixedFlowInput_5++) {

					row4.body = (Document) globalMap.get("body");

					/**
					 * [tFixedFlowInput_5 begin ] stop
					 */

					/**
					 * [tFixedFlowInput_5 main ] start
					 */

					currentComponent = "tFixedFlowInput_5";

					tos_count_tFixedFlowInput_5++;

					/**
					 * [tFixedFlowInput_5 main ] stop
					 */

					/**
					 * [tFixedFlowInput_5 process_data_begin ] start
					 */

					currentComponent = "tFixedFlowInput_5";

					/**
					 * [tFixedFlowInput_5 process_data_begin ] stop
					 */

					/**
					 * [tExtractJSONFields_1 main ] start
					 */

					currentComponent = "tExtractJSONFields_1";

					if (execStat) {
						runStat.updateStatOnConnection(iterateId, 1, 1

								, "row4"

						);
					}

					if (log.isTraceEnabled()) {
						log.trace("row4 - " + (row4 == null ? "" : row4.toLogString()));
					}

					if (row4.body != null) {// C_01
						jsonStr_tExtractJSONFields_1 = row4.body.toString();

						row6 = null;

						String loopPath_tExtractJSONFields_1 = "$";
						java.util.List<Object> resultset_tExtractJSONFields_1 = new java.util.ArrayList<Object>();

						boolean isStructError_tExtractJSONFields_1 = true;
						com.jayway.jsonpath.ReadContext document_tExtractJSONFields_1 = null;
						try {
							document_tExtractJSONFields_1 = com.jayway.jsonpath.JsonPath
									.parse(jsonStr_tExtractJSONFields_1);
							com.jayway.jsonpath.JsonPath compiledLoopPath_tExtractJSONFields_1 = jsonPathCache_tExtractJSONFields_1
									.getCompiledJsonPath(loopPath_tExtractJSONFields_1);
							Object result_tExtractJSONFields_1 = document_tExtractJSONFields_1
									.read(compiledLoopPath_tExtractJSONFields_1, net.minidev.json.JSONObject.class);
							if (result_tExtractJSONFields_1 instanceof net.minidev.json.JSONArray) {
								resultset_tExtractJSONFields_1 = (net.minidev.json.JSONArray) result_tExtractJSONFields_1;
							} else {
								resultset_tExtractJSONFields_1.add(result_tExtractJSONFields_1);
							}

							isStructError_tExtractJSONFields_1 = false;
						} catch (java.lang.Exception ex_tExtractJSONFields_1) {
							globalMap.put("tExtractJSONFields_1_ERROR_MESSAGE", ex_tExtractJSONFields_1.getMessage());
							log.error("tExtractJSONFields_1 - " + ex_tExtractJSONFields_1.getMessage());
							System.err.println(ex_tExtractJSONFields_1.getMessage());
						}

						String jsonPath_tExtractJSONFields_1 = null;
						com.jayway.jsonpath.JsonPath compiledJsonPath_tExtractJSONFields_1 = null;

						Object value_tExtractJSONFields_1 = null;

						Object root_tExtractJSONFields_1 = null;
						for (int i_tExtractJSONFields_1 = 0; isStructError_tExtractJSONFields_1
								|| (i_tExtractJSONFields_1 < resultset_tExtractJSONFields_1
										.size()); i_tExtractJSONFields_1++) {
							if (!isStructError_tExtractJSONFields_1) {
								Object row_tExtractJSONFields_1 = resultset_tExtractJSONFields_1
										.get(i_tExtractJSONFields_1);
								row6 = null;
								row6 = new row6Struct();
								nb_line_tExtractJSONFields_1++;
								try {
									jsonPath_tExtractJSONFields_1 = "products.product.CD_PRODUIT";
									compiledJsonPath_tExtractJSONFields_1 = jsonPathCache_tExtractJSONFields_1
											.getCompiledJsonPath(jsonPath_tExtractJSONFields_1);

									try {

										value_tExtractJSONFields_1 = compiledJsonPath_tExtractJSONFields_1
												.read(row_tExtractJSONFields_1);

										row6.test = value_tExtractJSONFields_1 == null ?

												null

												: value_tExtractJSONFields_1.toString();
									} catch (com.jayway.jsonpath.PathNotFoundException e_tExtractJSONFields_1) {
										globalMap.put("tExtractJSONFields_1_ERROR_MESSAGE",
												e_tExtractJSONFields_1.getMessage());
										row6.test =

												null

										;
									}
									jsonPath_tExtractJSONFields_1 = "products.product.NOM_PRODUIT";
									compiledJsonPath_tExtractJSONFields_1 = jsonPathCache_tExtractJSONFields_1
											.getCompiledJsonPath(jsonPath_tExtractJSONFields_1);

									try {

										value_tExtractJSONFields_1 = compiledJsonPath_tExtractJSONFields_1
												.read(row_tExtractJSONFields_1);

										row6.newColumn = value_tExtractJSONFields_1 == null ?

												null

												: value_tExtractJSONFields_1.toString();
									} catch (com.jayway.jsonpath.PathNotFoundException e_tExtractJSONFields_1) {
										globalMap.put("tExtractJSONFields_1_ERROR_MESSAGE",
												e_tExtractJSONFields_1.getMessage());
										row6.newColumn =

												null

										;
									}
								} catch (java.lang.Exception ex_tExtractJSONFields_1) {
									globalMap.put("tExtractJSONFields_1_ERROR_MESSAGE",
											ex_tExtractJSONFields_1.getMessage());
									log.error("tExtractJSONFields_1 - " + ex_tExtractJSONFields_1.getMessage());
									System.err.println(ex_tExtractJSONFields_1.getMessage());
									row6 = null;
								}

							}

							isStructError_tExtractJSONFields_1 = false;

							log.debug("tExtractJSONFields_1 - Extracting the record " + nb_line_tExtractJSONFields_1
									+ ".");
//}

							tos_count_tExtractJSONFields_1++;

							/**
							 * [tExtractJSONFields_1 main ] stop
							 */

							/**
							 * [tExtractJSONFields_1 process_data_begin ] start
							 */

							currentComponent = "tExtractJSONFields_1";

							/**
							 * [tExtractJSONFields_1 process_data_begin ] stop
							 */
// Start of branch "row6"
							if (row6 != null) {

								/**
								 * [tLogRow_1 main ] start
								 */

								currentComponent = "tLogRow_1";

								if (execStat) {
									runStat.updateStatOnConnection(iterateId, 1, 1

											, "row6"

									);
								}

								if (log.isTraceEnabled()) {
									log.trace("row6 - " + (row6 == null ? "" : row6.toLogString()));
								}

///////////////////////		

								String[] row_tLogRow_1 = new String[2];

								if (row6.test != null) { //
									row_tLogRow_1[0] = String.valueOf(row6.test);

								} //

								if (row6.newColumn != null) { //
									row_tLogRow_1[1] = String.valueOf(row6.newColumn);

								} //

								util_tLogRow_1.addRow(row_tLogRow_1);
								nb_line_tLogRow_1++;
								log.info("tLogRow_1 - Content of row " + nb_line_tLogRow_1 + ": "
										+ TalendString.unionString("|", row_tLogRow_1));
//////

//////                    

///////////////////////    			

								row7 = row6;

								tos_count_tLogRow_1++;

								/**
								 * [tLogRow_1 main ] stop
								 */

								/**
								 * [tLogRow_1 process_data_begin ] start
								 */

								currentComponent = "tLogRow_1";

								/**
								 * [tLogRow_1 process_data_begin ] stop
								 */

								/**
								 * [tRESTResponse_5 main ] start
								 */

								currentComponent = "tRESTResponse_5";

								if (execStat) {
									runStat.updateStatOnConnection(iterateId, 1, 1

											, "row7"

									);
								}

								if (log.isTraceEnabled()) {
									log.trace("row7 - " + (row7 == null ? "" : row7.toLogString()));
								}

								java.io.OutputStream outputStream_tRESTResponse_5 = (java.io.OutputStream) globalMap
										.get("restResponseStream");
								boolean responseAlreadySent_tRESTResponse_5 = globalMap.containsKey("restResponse");

								if (null == outputStream_tRESTResponse_5 && responseAlreadySent_tRESTResponse_5) {
									throw new RuntimeException("Rest response already sent.");
								} else if (!globalMap.containsKey("restRequest")) {
									throw new RuntimeException("Not received rest request yet.");
								} else {
									Integer restProviderStatusCode_tRESTResponse_5 = 200;

									Object restProviderResponse_tRESTResponse_5 = null;

									java.util.Map<String, String> restProviderResponseHeaders_tRESTResponse_5 = new java.util.TreeMap<String, String>(
											String.CASE_INSENSITIVE_ORDER);
									java.lang.StringBuilder restProviderResponseHeader_cookies_tRESTResponse_5 = new java.lang.StringBuilder();
									final String setCookieHeader = "Set-Cookie";

									if (restProviderResponseHeader_cookies_tRESTResponse_5.length() > 0) {
										restProviderResponseHeaders_tRESTResponse_5.put(setCookieHeader,
												restProviderResponseHeader_cookies_tRESTResponse_5.toString());
									}

									java.util.Map<String, Object> restRequest_tRESTResponse_5 = (java.util.Map<String, Object>) globalMap
											.get("restRequest");
									org.apache.cxf.jaxrs.ext.MessageContext messageContext_tRESTResponse_5 = (org.apache.cxf.jaxrs.ext.MessageContext) restRequest_tRESTResponse_5
											.get("MESSAGE_CONTEXT");

									if (null == outputStream_tRESTResponse_5) {
										java.util.Map<String, Object> restResponse_tRESTResponse_5 = new java.util.HashMap<String, Object>();
										restResponse_tRESTResponse_5.put("BODY", restProviderResponse_tRESTResponse_5);
										restResponse_tRESTResponse_5.put("STATUS",
												restProviderStatusCode_tRESTResponse_5);
										restResponse_tRESTResponse_5.put("HEADERS",
												restProviderResponseHeaders_tRESTResponse_5);
										restResponse_tRESTResponse_5.put("drop.json.root.element",
												Boolean.valueOf(false));
										globalMap.put("restResponse", restResponse_tRESTResponse_5);

									} else {

										javax.ws.rs.core.MediaType responseMediaType_tRESTResponse_5 = null;
										if (!responseAlreadySent_tRESTResponse_5) {
											org.apache.cxf.message.Message currentMessage = null;
											if (org.apache.cxf.jaxrs.utils.JAXRSUtils.getCurrentMessage() != null) {
												currentMessage = org.apache.cxf.jaxrs.utils.JAXRSUtils
														.getCurrentMessage();
											} else {
												currentMessage = ((org.apache.cxf.message.Message) restRequest_tRESTResponse_5
														.get("CURRENT_MESSAGE"));
											}

											if (currentMessage != null && currentMessage.getExchange() != null) {
												currentMessage.getExchange()
														.put(StreamingDOM4JProvider.SUPRESS_XML_DECLARATION, true);
											}

											messageContext_tRESTResponse_5.put(
													org.apache.cxf.message.Message.RESPONSE_CODE,
													restProviderStatusCode_tRESTResponse_5);
											javax.ws.rs.core.MultivaluedMap<String, String> headersMultivaluedMap_tRESTResponse_5 = new org.apache.cxf.jaxrs.impl.MetadataMap<String, String>();
											for (java.util.Map.Entry<String, String> multivaluedHeader : restProviderResponseHeaders_tRESTResponse_5
													.entrySet()) {
												headersMultivaluedMap_tRESTResponse_5.putSingle(
														multivaluedHeader.getKey(), multivaluedHeader.getValue());
											}
											messageContext_tRESTResponse_5.put(
													org.apache.cxf.message.Message.PROTOCOL_HEADERS,
													headersMultivaluedMap_tRESTResponse_5);

											String responseContentType_tRESTResponse_5 = null;

											if (currentMessage != null && currentMessage.getExchange() != null) {
												responseContentType_tRESTResponse_5 = (String) currentMessage
														.getExchange().get(org.apache.cxf.message.Message.CONTENT_TYPE);
											}

											if (null == responseContentType_tRESTResponse_5) {
												// this should not be needed, just in case. set it to the first value in
												// the sorted list returned from HttpHeaders
												responseMediaType_tRESTResponse_5 = messageContext_tRESTResponse_5
														.getHttpHeaders().getAcceptableMediaTypes().get(0);
											} else {
												responseMediaType_tRESTResponse_5 = org.apache.cxf.jaxrs.utils.JAXRSUtils
														.toMediaType(responseContentType_tRESTResponse_5);
											}
											globalMap.put("restResponseMediaType", responseMediaType_tRESTResponse_5);

											String responseMediaSubType_tRESTResponse_5 = responseMediaType_tRESTResponse_5
													.getSubtype();
											if (responseMediaSubType_tRESTResponse_5.equals("xml")
													|| responseMediaSubType_tRESTResponse_5.endsWith("+xml")) {
												outputStream_tRESTResponse_5.write("<wrapper>".getBytes());
												globalMap.put("restResponseWrappingClosure", "</wrapper>");
											}
											if (responseMediaSubType_tRESTResponse_5.equals("json")
													|| responseMediaSubType_tRESTResponse_5.endsWith("+json")) {
												outputStream_tRESTResponse_5.write("[".getBytes());
												globalMap.put("restResponseWrappingClosure", "]");
											}

											globalMap.put("restResponse", true);
										} else {
											responseMediaType_tRESTResponse_5 = (javax.ws.rs.core.MediaType) globalMap
													.get("restResponseMediaType");
										}

										if (null != restProviderResponse_tRESTResponse_5) {
											String responseMediaSubType_tRESTResponse_5 = responseMediaType_tRESTResponse_5
													.getSubtype();
											if (responseMediaSubType_tRESTResponse_5.equals("json")
													|| responseMediaSubType_tRESTResponse_5.endsWith("+json")) {
												if (globalMap.containsKey("restResponseJsonStarted")) {
													outputStream_tRESTResponse_5.write(",".getBytes());
												} else {
													globalMap.put("restResponseJsonStarted", true);
												}
											}

											Class<? extends Object> responseBodyClass_tRESTResponse_5 = restProviderResponse_tRESTResponse_5
													.getClass();
											javax.ws.rs.ext.Providers messageBodyProviders_tRESTResponse_5 = messageContext_tRESTResponse_5
													.getProviders();
											javax.ws.rs.ext.MessageBodyWriter messageBodyWriter_tRESTResponse_5 = messageBodyProviders_tRESTResponse_5
													.getMessageBodyWriter(responseBodyClass_tRESTResponse_5,
															responseBodyClass_tRESTResponse_5, null,
															responseMediaType_tRESTResponse_5);

											if (messageBodyWriter_tRESTResponse_5 instanceof StreamingDOM4JProvider) {
												((StreamingDOM4JProvider) messageBodyWriter_tRESTResponse_5)
														.setGlobalMap(globalMap);
											}

											messageBodyWriter_tRESTResponse_5.writeTo(
													restProviderResponse_tRESTResponse_5,
													responseBodyClass_tRESTResponse_5,
													responseBodyClass_tRESTResponse_5,
													new java.lang.annotation.Annotation[] {},
													responseMediaType_tRESTResponse_5, null,
													outputStream_tRESTResponse_5);
										}
										// initial variant
										// outputStream_tRESTResponse_5.write(String.valueOf(restProviderResponse_tRESTResponse_5).getBytes());
										outputStream_tRESTResponse_5.flush();
									}
								}

								tos_count_tRESTResponse_5++;

								/**
								 * [tRESTResponse_5 main ] stop
								 */

								/**
								 * [tRESTResponse_5 process_data_begin ] start
								 */

								currentComponent = "tRESTResponse_5";

								/**
								 * [tRESTResponse_5 process_data_begin ] stop
								 */

								/**
								 * [tRESTResponse_5 process_data_end ] start
								 */

								currentComponent = "tRESTResponse_5";

								/**
								 * [tRESTResponse_5 process_data_end ] stop
								 */

								/**
								 * [tLogRow_1 process_data_end ] start
								 */

								currentComponent = "tLogRow_1";

								/**
								 * [tLogRow_1 process_data_end ] stop
								 */

							} // End of branch "row6"

							// end for
						}

					} // C_01

					/**
					 * [tExtractJSONFields_1 process_data_end ] start
					 */

					currentComponent = "tExtractJSONFields_1";

					/**
					 * [tExtractJSONFields_1 process_data_end ] stop
					 */

					/**
					 * [tFixedFlowInput_5 process_data_end ] start
					 */

					currentComponent = "tFixedFlowInput_5";

					/**
					 * [tFixedFlowInput_5 process_data_end ] stop
					 */

					/**
					 * [tFixedFlowInput_5 end ] start
					 */

					currentComponent = "tFixedFlowInput_5";

				}
				globalMap.put("tFixedFlowInput_5_NB_LINE", 1);

				ok_Hash.put("tFixedFlowInput_5", true);
				end_Hash.put("tFixedFlowInput_5", System.currentTimeMillis());

				/**
				 * [tFixedFlowInput_5 end ] stop
				 */

				/**
				 * [tExtractJSONFields_1 end ] start
				 */

				currentComponent = "tExtractJSONFields_1";

				globalMap.put("tExtractJSONFields_1_NB_LINE", nb_line_tExtractJSONFields_1);
				log.debug("tExtractJSONFields_1 - Extracted records count: " + nb_line_tExtractJSONFields_1 + " .");

				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "row4");
				}

				if (log.isDebugEnabled())
					log.debug("tExtractJSONFields_1 - " + ("Done."));

				ok_Hash.put("tExtractJSONFields_1", true);
				end_Hash.put("tExtractJSONFields_1", System.currentTimeMillis());

				/**
				 * [tExtractJSONFields_1 end ] stop
				 */

				/**
				 * [tLogRow_1 end ] start
				 */

				currentComponent = "tLogRow_1";

//////

				java.io.PrintStream consoleOut_tLogRow_1 = null;
				if (globalMap.get("tLogRow_CONSOLE") != null) {
					consoleOut_tLogRow_1 = (java.io.PrintStream) globalMap.get("tLogRow_CONSOLE");
				} else {
					consoleOut_tLogRow_1 = new java.io.PrintStream(new java.io.BufferedOutputStream(System.out));
					globalMap.put("tLogRow_CONSOLE", consoleOut_tLogRow_1);
				}

				consoleOut_tLogRow_1.println(util_tLogRow_1.format().toString());
				consoleOut_tLogRow_1.flush();
//////
				globalMap.put("tLogRow_1_NB_LINE", nb_line_tLogRow_1);
				if (log.isInfoEnabled())
					log.info("tLogRow_1 - " + ("Printed row count: ") + (nb_line_tLogRow_1) + ("."));

///////////////////////    			

				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "row6");
				}

				if (log.isDebugEnabled())
					log.debug("tLogRow_1 - " + ("Done."));

				ok_Hash.put("tLogRow_1", true);
				end_Hash.put("tLogRow_1", System.currentTimeMillis());

				/**
				 * [tLogRow_1 end ] stop
				 */

				/**
				 * [tRESTResponse_5 end ] start
				 */

				currentComponent = "tRESTResponse_5";

				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "row7");
				}

				ok_Hash.put("tRESTResponse_5", true);
				end_Hash.put("tRESTResponse_5", System.currentTimeMillis());

				/**
				 * [tRESTResponse_5 end ] stop
				 */

			} // end the resume

		} catch (java.lang.Exception e) {

			if (!(e instanceof TalendException)) {
				log.fatal(currentComponent + " " + e.getMessage(), e);
			}

			TalendException te = new TalendException(e, currentComponent, globalMap);

			throw te;
		} catch (java.lang.Error error) {

			runStat.stopThreadStat();

			throw error;
		} finally {

			try {

				/**
				 * [tFixedFlowInput_5 finally ] start
				 */

				currentComponent = "tFixedFlowInput_5";

				/**
				 * [tFixedFlowInput_5 finally ] stop
				 */

				/**
				 * [tExtractJSONFields_1 finally ] start
				 */

				currentComponent = "tExtractJSONFields_1";

				/**
				 * [tExtractJSONFields_1 finally ] stop
				 */

				/**
				 * [tLogRow_1 finally ] start
				 */

				currentComponent = "tLogRow_1";

				/**
				 * [tLogRow_1 finally ] stop
				 */

				/**
				 * [tRESTResponse_5 finally ] start
				 */

				currentComponent = "tRESTResponse_5";

				/**
				 * [tRESTResponse_5 finally ] stop
				 */

			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tFixedFlowInput_5_SUBPROCESS_STATE", 1);
	}

	public void tPrejob_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tPrejob_1_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		String iterateId = "";

		String currentComponent = "";
		java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

		try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { // start the resume
				globalResumeTicket = true;

				/**
				 * [tPrejob_1 begin ] start
				 */

				ok_Hash.put("tPrejob_1", false);
				start_Hash.put("tPrejob_1", System.currentTimeMillis());

				currentComponent = "tPrejob_1";

				int tos_count_tPrejob_1 = 0;

				/**
				 * [tPrejob_1 begin ] stop
				 */

				/**
				 * [tPrejob_1 main ] start
				 */

				currentComponent = "tPrejob_1";

				tos_count_tPrejob_1++;

				/**
				 * [tPrejob_1 main ] stop
				 */

				/**
				 * [tPrejob_1 process_data_begin ] start
				 */

				currentComponent = "tPrejob_1";

				/**
				 * [tPrejob_1 process_data_begin ] stop
				 */

				/**
				 * [tPrejob_1 process_data_end ] start
				 */

				currentComponent = "tPrejob_1";

				/**
				 * [tPrejob_1 process_data_end ] stop
				 */

				/**
				 * [tPrejob_1 end ] start
				 */

				currentComponent = "tPrejob_1";

				ok_Hash.put("tPrejob_1", true);
				end_Hash.put("tPrejob_1", System.currentTimeMillis());

				if (execStat) {
					runStat.updateStatOnConnection("OnComponentOk2", 0, "ok");
				}
				tDBConnection_1Process(globalMap);

				/**
				 * [tPrejob_1 end ] stop
				 */
			} // end the resume

		} catch (java.lang.Exception e) {

			if (!(e instanceof TalendException)) {
				log.fatal(currentComponent + " " + e.getMessage(), e);
			}

			TalendException te = new TalendException(e, currentComponent, globalMap);

			throw te;
		} catch (java.lang.Error error) {

			runStat.stopThreadStat();

			throw error;
		} finally {

			try {

				/**
				 * [tPrejob_1 finally ] start
				 */

				currentComponent = "tPrejob_1";

				/**
				 * [tPrejob_1 finally ] stop
				 */
			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tPrejob_1_SUBPROCESS_STATE", 1);
	}

	public static class headerStruct implements routines.system.IPersistableRow<headerStruct> {
		final static byte[] commonByteArrayLock_SALESFORCE_Copy_of_PostRequest = new byte[0];
		static byte[] commonByteArray_SALESFORCE_Copy_of_PostRequest = new byte[0];

		public String Authorization;

		public String getAuthorization() {
			return this.Authorization;
		}

		public routines.system.Document body;

		public routines.system.Document getBody() {
			return this.body;
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_SALESFORCE_Copy_of_PostRequest.length) {
					if (length < 1024 && commonByteArray_SALESFORCE_Copy_of_PostRequest.length == 0) {
						commonByteArray_SALESFORCE_Copy_of_PostRequest = new byte[1024];
					} else {
						commonByteArray_SALESFORCE_Copy_of_PostRequest = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_SALESFORCE_Copy_of_PostRequest, 0, length);
				strReturn = new String(commonByteArray_SALESFORCE_Copy_of_PostRequest, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_SALESFORCE_Copy_of_PostRequest.length) {
					if (length < 1024 && commonByteArray_SALESFORCE_Copy_of_PostRequest.length == 0) {
						commonByteArray_SALESFORCE_Copy_of_PostRequest = new byte[1024];
					} else {
						commonByteArray_SALESFORCE_Copy_of_PostRequest = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_SALESFORCE_Copy_of_PostRequest, 0, length);
				strReturn = new String(commonByteArray_SALESFORCE_Copy_of_PostRequest, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_SALESFORCE_Copy_of_PostRequest) {

				try {

					int length = 0;

					this.Authorization = readString(dis);

					this.body = (routines.system.Document) dis.readObject();

				} catch (IOException e) {
					throw new RuntimeException(e);

				} catch (ClassNotFoundException eCNFE) {
					throw new RuntimeException(eCNFE);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_SALESFORCE_Copy_of_PostRequest) {

				try {

					int length = 0;

					this.Authorization = readString(dis);

					this.body = (routines.system.Document) dis.readObject();

				} catch (IOException e) {
					throw new RuntimeException(e);

				} catch (ClassNotFoundException eCNFE) {
					throw new RuntimeException(eCNFE);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.Authorization, dos);

				// Document

				dos.writeObject(this.body);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.Authorization, dos);

				// Document

				dos.writeObject(this.body);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("Authorization=" + Authorization);
			sb.append(",body=" + String.valueOf(body));
			sb.append("]");

			return sb.toString();
		}

		public String toLogString() {
			StringBuilder sb = new StringBuilder();

			if (Authorization == null) {
				sb.append("<null>");
			} else {
				sb.append(Authorization);
			}

			sb.append("|");

			if (body == null) {
				sb.append("<null>");
			} else {
				sb.append(body);
			}

			sb.append("|");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(headerStruct other) {

			int returnValue = -1;

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(), object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public void tRESTRequest_1_LoopProcess(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tRESTRequest_1_Loop_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;
		String currentVirtualComponent = null;

		String iterateId = "";

		String currentComponent = "";
		java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

		try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { // start the resume
				globalResumeTicket = true;

				headerStruct header = new headerStruct();

				/**
				 * [tRESTRequest_1_Loop begin ] start
				 */

				int NB_ITERATE_tRESTRequest_1_In = 0; // for statistics

				ok_Hash.put("tRESTRequest_1_Loop", false);
				start_Hash.put("tRESTRequest_1_Loop", System.currentTimeMillis());

				currentVirtualComponent = "tRESTRequest_1";

				currentComponent = "tRESTRequest_1_Loop";

				int tos_count_tRESTRequest_1_Loop = 0;

				if (execStat) {
					runStat.updateStatOnConnection(iterateId, 0, 0, "header");
				}

				header = null;

				int nb_line_tRESTRequest_1 = 0;

				try {

					java.util.Map<String, Object> requestMessage_tRESTRequest_1 = (java.util.Map<String, Object>) globalMap
							.get("restRequest");

					restEndpoint = getRestEndpoint();

					if (null == requestMessage_tRESTRequest_1) {

						if (restTalendJobAlreadyStarted) {
							throw new RuntimeException("request is not provided");
						} else {
							if (!runInTalendEsbRuntimeContainer && null == thread4RestServiceProviderEndpoint) {
								String endpointUrl_tRESTRequest_1 = checkEndpointUrl(restEndpoint);
								// *** external thread for endpoint initialization
								thread4RestServiceProviderEndpoint = new Thread4RestServiceProviderEndpoint(this,
										endpointUrl_tRESTRequest_1);
								thread4RestServiceProviderEndpoint.start();
								// *** external thread for endpoint initialization
							}

							restTalendJobAlreadyStarted = true;

							if (runInDaemonMode) {
								Thread.currentThread();
								try {
									while (true) {
										Thread.sleep(60000);
									}
								} catch (InterruptedException e_tRESTRequest_1) {
									// e_tRESTRequest_1.printStackTrace();
									// throw new TalendException(e_tRESTRequest_1, "wholeJob", globalMap);
								}
							}
						}
						return;
					}

					requestMessage_tRESTRequest_1.put("CURRENT_MESSAGE",
							org.apache.cxf.jaxrs.utils.JAXRSUtils.getCurrentMessage());

					Object ctx_tRESTRequest_1 = requestMessage_tRESTRequest_1.get("MESSAGE_CONTEXT");
					if (ctx_tRESTRequest_1 != null
							&& ctx_tRESTRequest_1 instanceof org.apache.cxf.jaxrs.impl.tl.ThreadLocalMessageContext) {
						requestMessage_tRESTRequest_1.put("MESSAGE_CONTEXT",
								((org.apache.cxf.jaxrs.impl.tl.ThreadLocalMessageContext) ctx_tRESTRequest_1).get());
					}

					/**
					 * [tRESTRequest_1_Loop begin ] stop
					 */

					/**
					 * [tRESTRequest_1_Loop main ] start
					 */

					currentVirtualComponent = "tRESTRequest_1";

					currentComponent = "tRESTRequest_1_Loop";

					resourceMap.put("inIterateVComp", true);

					tos_count_tRESTRequest_1_Loop++;

					/**
					 * [tRESTRequest_1_Loop main ] stop
					 */

					/**
					 * [tRESTRequest_1_Loop process_data_begin ] start
					 */

					currentVirtualComponent = "tRESTRequest_1";

					currentComponent = "tRESTRequest_1_Loop";

					/**
					 * [tRESTRequest_1_Loop process_data_begin ] stop
					 */
					NB_ITERATE_tRESTRequest_1_In++;

					if (execStat) {
						runStat.updateStatOnConnection("Iterate", 1, "exec" + NB_ITERATE_tRESTRequest_1_In);
						// Thread.sleep(1000);
					}

					/**
					 * [tSetGlobalVar_1 begin ] start
					 */

					ok_Hash.put("tSetGlobalVar_1", false);
					start_Hash.put("tSetGlobalVar_1", System.currentTimeMillis());

					currentComponent = "tSetGlobalVar_1";

					if (execStat) {
						runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "header");
					}

					int tos_count_tSetGlobalVar_1 = 0;

					if (log.isDebugEnabled())
						log.debug("tSetGlobalVar_1 - " + ("Start to work."));
					if (log.isDebugEnabled()) {
						class BytesLimit65535_tSetGlobalVar_1 {
							public void limitLog4jByte() throws Exception {
								StringBuilder log4jParamters_tSetGlobalVar_1 = new StringBuilder();
								log4jParamters_tSetGlobalVar_1.append("Parameters:");
								log4jParamters_tSetGlobalVar_1.append("VARIABLES" + " = " + "[{VALUE="
										+ ("((TokenValidatorService)globalMap.get(\"tokenValidatorService\")).validateToken(header.Authorization)")
										+ ", KEY=" + ("\"is_valid_token\"") + "}, {VALUE=" + ("0") + ", KEY="
										+ ("\"i_stepSequence\"") + "}, {VALUE=" + ("header.body") + ", KEY="
										+ ("\"body\"") + "}]");
								log4jParamters_tSetGlobalVar_1.append(" | ");
								if (log.isDebugEnabled())
									log.debug("tSetGlobalVar_1 - " + (log4jParamters_tSetGlobalVar_1));
							}
						}
						new BytesLimit65535_tSetGlobalVar_1().limitLog4jByte();
					}

					/**
					 * [tSetGlobalVar_1 begin ] stop
					 */

					/**
					 * [tRESTRequest_1_In begin ] start
					 */

					ok_Hash.put("tRESTRequest_1_In", false);
					start_Hash.put("tRESTRequest_1_In", System.currentTimeMillis());

					currentVirtualComponent = "tRESTRequest_1";

					currentComponent = "tRESTRequest_1_In";

					int tos_count_tRESTRequest_1_In = 0;

					resourceMap.remove("inIterateVComp");

					/**
					 * [tRESTRequest_1_In begin ] stop
					 */

					/**
					 * [tRESTRequest_1_In main ] start
					 */

					currentVirtualComponent = "tRESTRequest_1";

					currentComponent = "tRESTRequest_1_In";

					if (requestMessage_tRESTRequest_1.containsKey("ERROR")) { // wrong request received
						header = null;
					} else { // non-error (not wrong request)

						String matchedUriPattern_tRESTRequest_1 = (String) requestMessage_tRESTRequest_1.get("PATTERN");
						String matchedFlow_tRESTRequest_1 = (String) requestMessage_tRESTRequest_1.get("OPERATION");

						java.util.Map<String, Object> params_tRESTRequest_1 = (java.util.Map<String, Object>) requestMessage_tRESTRequest_1
								.get("PARAMS");
						if (matchedFlow_tRESTRequest_1.equals("header")) {
							header = new headerStruct();
							if (params_tRESTRequest_1.containsKey("HEADER:Authorization:id_String")) {

								header.Authorization = (String) params_tRESTRequest_1
										.get("HEADER:Authorization:id_String");

							}
							Object bodyObject_tRESTRequest_1 = requestMessage_tRESTRequest_1.get("BODY");
							if (null != bodyObject_tRESTRequest_1) {

								routines.system.Document body_tRESTRequest_1 = new routines.system.Document();
								body_tRESTRequest_1.setDocument((org.dom4j.Document) bodyObject_tRESTRequest_1);
								header.body = body_tRESTRequest_1;

							}
						} else { // non matched flow
							header = null;
						}

					}

					globalMap.put("tRESTRequest_1_URI", (String) requestMessage_tRESTRequest_1.get("URI"));
					globalMap.put("tRESTRequest_1_URI_BASE", (String) requestMessage_tRESTRequest_1.get("URI_BASE"));
					globalMap.put("tRESTRequest_1_URI_ABSOLUTE",
							(String) requestMessage_tRESTRequest_1.get("URI_ABSOLUTE"));
					globalMap.put("tRESTRequest_1_URI_REQUEST",
							(String) requestMessage_tRESTRequest_1.get("URI_REQUEST"));
					globalMap.put("tRESTRequest_1_HTTP_METHOD", (String) requestMessage_tRESTRequest_1.get("VERB"));

					globalMap.put("tRESTRequest_1_ATTACHMENT_HEADERS",
							requestMessage_tRESTRequest_1.get("ATTACHMENT_HEADERS"));
					globalMap.put("tRESTRequest_1_ATTACHMENT_FILENAMES",
							requestMessage_tRESTRequest_1.get("ATTACHMENT_FILENAMES"));

					globalMap.put("tRESTRequest_1_PRINCIPAL_NAME",
							(String) requestMessage_tRESTRequest_1.get("PRINCIPAL_NAME"));
					globalMap.put("tRESTRequest_1_CORRELATION_ID",
							(String) requestMessage_tRESTRequest_1.get("CorrelationID"));

					tos_count_tRESTRequest_1_In++;

					/**
					 * [tRESTRequest_1_In main ] stop
					 */

					/**
					 * [tRESTRequest_1_In process_data_begin ] start
					 */

					currentVirtualComponent = "tRESTRequest_1";

					currentComponent = "tRESTRequest_1_In";

					/**
					 * [tRESTRequest_1_In process_data_begin ] stop
					 */
// Start of branch "header"
					if (header != null) {

						/**
						 * [tSetGlobalVar_1 main ] start
						 */

						currentComponent = "tSetGlobalVar_1";

						if (execStat) {
							runStat.updateStatOnConnection(iterateId, 1, 1

									, "header"

							);
						}

						if (log.isTraceEnabled()) {
							log.trace("header - " + (header == null ? "" : header.toLogString()));
						}

						globalMap.put("is_valid_token", ((TokenValidatorService) globalMap.get("tokenValidatorService"))
								.validateToken(header.Authorization));
						globalMap.put("i_stepSequence", 0);
						globalMap.put("body", header.body);

						tos_count_tSetGlobalVar_1++;

						/**
						 * [tSetGlobalVar_1 main ] stop
						 */

						/**
						 * [tSetGlobalVar_1 process_data_begin ] start
						 */

						currentComponent = "tSetGlobalVar_1";

						/**
						 * [tSetGlobalVar_1 process_data_begin ] stop
						 */

						/**
						 * [tSetGlobalVar_1 process_data_end ] start
						 */

						currentComponent = "tSetGlobalVar_1";

						/**
						 * [tSetGlobalVar_1 process_data_end ] stop
						 */

					} // End of branch "header"

					/**
					 * [tRESTRequest_1_In process_data_end ] start
					 */

					currentVirtualComponent = "tRESTRequest_1";

					currentComponent = "tRESTRequest_1_In";

					/**
					 * [tRESTRequest_1_In process_data_end ] stop
					 */

					/**
					 * [tRESTRequest_1_In end ] start
					 */

					currentVirtualComponent = "tRESTRequest_1";

					currentComponent = "tRESTRequest_1_In";

					resourceMap.put("inIterateVComp", true);

					ok_Hash.put("tRESTRequest_1_In", true);
					end_Hash.put("tRESTRequest_1_In", System.currentTimeMillis());

					/**
					 * [tRESTRequest_1_In end ] stop
					 */

					/**
					 * [tSetGlobalVar_1 end ] start
					 */

					currentComponent = "tSetGlobalVar_1";

					if (execStat) {
						runStat.updateStat(resourceMap, iterateId, 2, 0, "header");
					}

					if (log.isDebugEnabled())
						log.debug("tSetGlobalVar_1 - " + ("Done."));

					ok_Hash.put("tSetGlobalVar_1", true);
					end_Hash.put("tSetGlobalVar_1", System.currentTimeMillis());

					if ((Boolean) globalMap.get("is_valid_token")) {

						if (execStat) {
							runStat.updateStatOnConnection("If5", 0, "true");
						}
						tFixedFlowInput_5Process(globalMap);
					}

					else {
						if (execStat) {
							runStat.updateStatOnConnection("If5", 0, "false");
						}
					}

					/**
					 * [tSetGlobalVar_1 end ] stop
					 */

					if (execStat) {
						runStat.updateStatOnConnection("Iterate", 2, "exec" + NB_ITERATE_tRESTRequest_1_In);
					}

					/**
					 * [tRESTRequest_1_Loop process_data_end ] start
					 */

					currentVirtualComponent = "tRESTRequest_1";

					currentComponent = "tRESTRequest_1_Loop";

					/**
					 * [tRESTRequest_1_Loop process_data_end ] stop
					 */

					/**
					 * [tRESTRequest_1_Loop end ] start
					 */

					currentVirtualComponent = "tRESTRequest_1";

					currentComponent = "tRESTRequest_1_Loop";

					resourceMap.remove("inIterateVComp");

				} catch (Throwable e_tRESTRequest_1) {
					if (e_tRESTRequest_1 instanceof Exception) {
						new TalendException((Exception) e_tRESTRequest_1, currentComponent, globalMap)
								.printStackTrace();
					} else {
						new TalendException(new RuntimeException(e_tRESTRequest_1), currentComponent, globalMap)
								.printStackTrace();
					}
					if (!globalMap.containsKey("restResponse")) {
						java.util.Map<String, Object> restFault_tRESTRequest_1 = new java.util.HashMap<String, Object>();
						restFault_tRESTRequest_1.put("STATUS", 500);
						restFault_tRESTRequest_1.put("BODY", e_tRESTRequest_1.getMessage());
						globalMap.put("restResponse", restFault_tRESTRequest_1);
					}
					return;
				}
				nb_line_tRESTRequest_1++;
				globalMap.put("tRESTRequest_1_NB_LINE", nb_line_tRESTRequest_1);

				if (execStat) {
					runStat.updateStatOnConnection(iterateId, 2, 0, "header");
				}

				ok_Hash.put("tRESTRequest_1_Loop", true);
				end_Hash.put("tRESTRequest_1_Loop", System.currentTimeMillis());

				/**
				 * [tRESTRequest_1_Loop end ] stop
				 */
			} // end the resume

		} catch (java.lang.Exception e) {

			if (!(e instanceof TalendException)) {
				log.fatal(currentComponent + " " + e.getMessage(), e);
			}

			TalendException te = new TalendException(e, currentComponent, globalMap);

			te.setVirtualComponentName(currentVirtualComponent);

			throw te;
		} catch (java.lang.Error error) {

			runStat.stopThreadStat();

			throw error;
		} finally {

			try {

				/**
				 * [tRESTRequest_1_Loop finally ] start
				 */

				currentVirtualComponent = "tRESTRequest_1";

				currentComponent = "tRESTRequest_1_Loop";

				/**
				 * [tRESTRequest_1_Loop finally ] stop
				 */

				/**
				 * [tRESTRequest_1_In finally ] start
				 */

				currentVirtualComponent = "tRESTRequest_1";

				currentComponent = "tRESTRequest_1_In";

				/**
				 * [tRESTRequest_1_In finally ] stop
				 */

				/**
				 * [tSetGlobalVar_1 finally ] start
				 */

				currentComponent = "tSetGlobalVar_1";

				/**
				 * [tSetGlobalVar_1 finally ] stop
				 */

			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tRESTRequest_1_Loop_SUBPROCESS_STATE", 1);
	}

	public String resuming_logs_dir_path = null;
	public String resuming_checkpoint_path = null;
	public String parent_part_launcher = null;
	private String resumeEntryMethodName = null;
	private boolean globalResumeTicket = false;

	public boolean watch = false;
	// portStats is null, it means don't execute the statistics
	public Integer portStats = null;
	public int portTraces = 4334;
	public String clientHost;
	public String defaultClientHost = "localhost";
	public String contextStr = "DEV";
	public boolean isDefaultContext = true;
	public String pid = "0";
	public String rootPid = null;
	public String fatherPid = null;
	public String fatherNode = null;
	public long startTime = 0;
	public boolean isChildJob = false;
	public String log4jLevel = "";

	private boolean enableLogStash;

	private boolean execStat = true;

	private ThreadLocal<java.util.Map<String, String>> threadLocal = new ThreadLocal<java.util.Map<String, String>>() {
		protected java.util.Map<String, String> initialValue() {
			java.util.Map<String, String> threadRunResultMap = new java.util.HashMap<String, String>();
			threadRunResultMap.put("errorCode", null);
			threadRunResultMap.put("status", "");
			return threadRunResultMap;
		};
	};

	protected PropertiesWithType context_param = new PropertiesWithType();
	public java.util.Map<String, Object> parentContextMap = new java.util.HashMap<String, Object>();

	public String status = "";

	public static void main(String[] args) {
		final Copy_of_PostRequest Copy_of_PostRequestClass = new Copy_of_PostRequest();

		int exitCode = Copy_of_PostRequestClass.runJobInTOS(args);
		if (exitCode == 0) {
			log.info("TalendJob: 'Copy_of_PostRequest' - Done.");
		}

		System.exit(exitCode);
	}

	public String[][] runJob(String[] args) {

		int exitCode = runJobInTOS(args);
		String[][] bufferValue = new String[][] { { Integer.toString(exitCode) } };

		return bufferValue;
	}

	public boolean hastBufferOutputComponent() {
		boolean hastBufferOutput = false;

		return hastBufferOutput;
	}

	public int runJobInTOS(String[] args) {
		// reset status
		status = "";

		String lastStr = "";
		for (String arg : args) {
			if (arg.equalsIgnoreCase("--context_param")) {
				lastStr = arg;
			} else if (lastStr.equals("")) {
				evalParam(arg);
			} else {
				evalParam(lastStr + " " + arg);
				lastStr = "";
			}
		}
		enableLogStash = "true".equalsIgnoreCase(System.getProperty("audit.enabled"));

		if (!"".equals(log4jLevel)) {

			if ("trace".equalsIgnoreCase(log4jLevel)) {
				org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(),
						org.apache.logging.log4j.Level.TRACE);
			} else if ("debug".equalsIgnoreCase(log4jLevel)) {
				org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(),
						org.apache.logging.log4j.Level.DEBUG);
			} else if ("info".equalsIgnoreCase(log4jLevel)) {
				org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(),
						org.apache.logging.log4j.Level.INFO);
			} else if ("warn".equalsIgnoreCase(log4jLevel)) {
				org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(),
						org.apache.logging.log4j.Level.WARN);
			} else if ("error".equalsIgnoreCase(log4jLevel)) {
				org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(),
						org.apache.logging.log4j.Level.ERROR);
			} else if ("fatal".equalsIgnoreCase(log4jLevel)) {
				org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(),
						org.apache.logging.log4j.Level.FATAL);
			} else if ("off".equalsIgnoreCase(log4jLevel)) {
				org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(),
						org.apache.logging.log4j.Level.OFF);
			}
			org.apache.logging.log4j.core.config.Configurator
					.setLevel(org.apache.logging.log4j.LogManager.getRootLogger().getName(), log.getLevel());

		}
		log.info("TalendJob: 'Copy_of_PostRequest' - Start.");

		if (clientHost == null) {
			clientHost = defaultClientHost;
		}

		if (pid == null || "0".equals(pid)) {
			pid = TalendString.getAsciiRandomString(6);
		}

		if (rootPid == null) {
			rootPid = pid;
		}
		if (fatherPid == null) {
			fatherPid = pid;
		} else {
			isChildJob = true;
		}

		if (portStats != null) {
			// portStats = -1; //for testing
			if (portStats < 0 || portStats > 65535) {
				// issue:10869, the portStats is invalid, so this client socket can't open
				System.err.println("The statistics socket port " + portStats + " is invalid.");
				execStat = false;
			}
		} else {
			execStat = false;
		}
		boolean inOSGi = routines.system.BundleUtils.inOSGi();

		if (inOSGi) {
			java.util.Dictionary<String, Object> jobProperties = routines.system.BundleUtils.getJobProperties(jobName);

			if (jobProperties != null && jobProperties.get("context") != null) {
				contextStr = (String) jobProperties.get("context");
			}
		}

		try {
			// call job/subjob with an existing context, like: --context=production. if
			// without this parameter, there will use the default context instead.
			java.io.InputStream inContext = Copy_of_PostRequest.class.getClassLoader()
					.getResourceAsStream("salesforce/copy_of_postrequest_0_1/contexts/" + contextStr + ".properties");
			if (inContext == null) {
				inContext = Copy_of_PostRequest.class.getClassLoader()
						.getResourceAsStream("config/contexts/" + contextStr + ".properties");
			}
			if (inContext != null) {
				try {
					// defaultProps is in order to keep the original context value
					if (context != null && context.isEmpty()) {
						defaultProps.load(inContext);
						context = new ContextProperties(defaultProps);
					}
				} finally {
					inContext.close();
				}
			} else if (!isDefaultContext) {
				// print info and job continue to run, for case: context_param is not empty.
				System.err.println("Could not find the context " + contextStr);
			}

			if (!context_param.isEmpty()) {
				context.putAll(context_param);
				// set types for params from parentJobs
				for (Object key : context_param.keySet()) {
					String context_key = key.toString();
					String context_type = context_param.getContextType(context_key);
					context.setContextType(context_key, context_type);

				}
			}
			class ContextProcessing {
				private void processContext_0() {
					context.setContextType("azure_access_token", "id_String");
					if (context.getStringValue("azure_access_token") == null) {
						context.azure_access_token = null;
					} else {
						context.azure_access_token = (String) context.getProperty("azure_access_token");
					}
					context.setContextType("azure_client_id", "id_String");
					if (context.getStringValue("azure_client_id") == null) {
						context.azure_client_id = null;
					} else {
						context.azure_client_id = (String) context.getProperty("azure_client_id");
					}
					context.setContextType("azure_client_secret", "id_String");
					if (context.getStringValue("azure_client_secret") == null) {
						context.azure_client_secret = null;
					} else {
						context.azure_client_secret = (String) context.getProperty("azure_client_secret");
					}
					context.setContextType("azure_content_type_token", "id_String");
					if (context.getStringValue("azure_content_type_token") == null) {
						context.azure_content_type_token = null;
					} else {
						context.azure_content_type_token = (String) context.getProperty("azure_content_type_token");
					}
					context.setContextType("azure_grant_type", "id_String");
					if (context.getStringValue("azure_grant_type") == null) {
						context.azure_grant_type = null;
					} else {
						context.azure_grant_type = (String) context.getProperty("azure_grant_type");
					}
					context.setContextType("azure_resource", "id_String");
					if (context.getStringValue("azure_resource") == null) {
						context.azure_resource = null;
					} else {
						context.azure_resource = (String) context.getProperty("azure_resource");
					}
					context.setContextType("azure_tenant_id", "id_String");
					if (context.getStringValue("azure_tenant_id") == null) {
						context.azure_tenant_id = null;
					} else {
						context.azure_tenant_id = (String) context.getProperty("azure_tenant_id");
					}
					context.setContextType("azure_token_type", "id_String");
					if (context.getStringValue("azure_token_type") == null) {
						context.azure_token_type = null;
					} else {
						context.azure_token_type = (String) context.getProperty("azure_token_type");
					}
					context.setContextType("azure_url_token", "id_String");
					if (context.getStringValue("azure_url_token") == null) {
						context.azure_url_token = null;
					} else {
						context.azure_url_token = (String) context.getProperty("azure_url_token");
					}
				}

				public void processAllContext() {
					processContext_0();
				}
			}

			new ContextProcessing().processAllContext();
		} catch (java.io.IOException ie) {
			System.err.println("Could not load context " + contextStr);
			ie.printStackTrace();
		}

		// get context value from parent directly
		if (parentContextMap != null && !parentContextMap.isEmpty()) {
			if (parentContextMap.containsKey("azure_access_token")) {
				context.azure_access_token = (String) parentContextMap.get("azure_access_token");
			}
			if (parentContextMap.containsKey("azure_client_id")) {
				context.azure_client_id = (String) parentContextMap.get("azure_client_id");
			}
			if (parentContextMap.containsKey("azure_client_secret")) {
				context.azure_client_secret = (String) parentContextMap.get("azure_client_secret");
			}
			if (parentContextMap.containsKey("azure_content_type_token")) {
				context.azure_content_type_token = (String) parentContextMap.get("azure_content_type_token");
			}
			if (parentContextMap.containsKey("azure_grant_type")) {
				context.azure_grant_type = (String) parentContextMap.get("azure_grant_type");
			}
			if (parentContextMap.containsKey("azure_resource")) {
				context.azure_resource = (String) parentContextMap.get("azure_resource");
			}
			if (parentContextMap.containsKey("azure_tenant_id")) {
				context.azure_tenant_id = (String) parentContextMap.get("azure_tenant_id");
			}
			if (parentContextMap.containsKey("azure_token_type")) {
				context.azure_token_type = (String) parentContextMap.get("azure_token_type");
			}
			if (parentContextMap.containsKey("azure_url_token")) {
				context.azure_url_token = (String) parentContextMap.get("azure_url_token");
			}
		}

		// Resume: init the resumeUtil
		resumeEntryMethodName = ResumeUtil.getResumeEntryMethodName(resuming_checkpoint_path);
		resumeUtil = new ResumeUtil(resuming_logs_dir_path, isChildJob, rootPid);
		resumeUtil.initCommonInfo(pid, rootPid, fatherPid, projectName, jobName, contextStr, jobVersion);

		List<String> parametersToEncrypt = new java.util.ArrayList<String>();
		// Resume: jobStart
		resumeUtil.addLog("JOB_STARTED", "JOB:" + jobName, parent_part_launcher, Thread.currentThread().getId() + "",
				"", "", "", "", resumeUtil.convertToJsonText(context, parametersToEncrypt));

		if (execStat) {
			try {
				runStat.openSocket(!isChildJob);
				runStat.setAllPID(rootPid, fatherPid, pid, jobName);
				runStat.startThreadStat(clientHost, portStats);
				runStat.updateStatOnJob(RunStat.JOBSTART, fatherNode);
			} catch (java.io.IOException ioException) {
				ioException.printStackTrace();
			}
		}

		java.util.concurrent.ConcurrentHashMap<Object, Object> concurrentHashMap = new java.util.concurrent.ConcurrentHashMap<Object, Object>();
		globalMap.put("concurrentHashMap", concurrentHashMap);

		long startUsedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		long endUsedMemory = 0;
		long end = 0;

		startTime = System.currentTimeMillis();

		this.globalResumeTicket = true;// to run tPreJob

		try {
			errorCode = null;
			tPrejob_1Process(globalMap);
			if (!"failure".equals(status)) {
				status = "end";
			}
		} catch (TalendException e_tPrejob_1) {
			globalMap.put("tPrejob_1_SUBPROCESS_STATE", -1);

			e_tPrejob_1.printStackTrace();

		}

		this.globalResumeTicket = false;// to run others jobs

		try {
			errorCode = null;
			tRESTRequest_1_LoopProcess(globalMap);
			if (!"failure".equals(status)) {
				status = "end";
			}
		} catch (TalendException e_tRESTRequest_1_Loop) {
			globalMap.put("tRESTRequest_1_Loop_SUBPROCESS_STATE", -1);

			e_tRESTRequest_1_Loop.printStackTrace();

		}

		this.globalResumeTicket = true;// to run tPostJob

		end = System.currentTimeMillis();

		if (watch) {
			System.out.println((end - startTime) + " milliseconds");
		}

		endUsedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		if (false) {
			System.out.println(
					(endUsedMemory - startUsedMemory) + " bytes memory increase when running : Copy_of_PostRequest");
		}

		if (execStat) {
			runStat.updateStatOnJob(RunStat.JOBEND, fatherNode);
			runStat.stopThreadStat();
		}
		int returnCode = 0;

		if (errorCode == null) {
			returnCode = status != null && status.equals("failure") ? 1 : 0;
		} else {
			returnCode = errorCode.intValue();
		}
		resumeUtil.addLog("JOB_ENDED", "JOB:" + jobName, parent_part_launcher, Thread.currentThread().getId() + "", "",
				"" + returnCode, "", "", "");

		return returnCode;

	}

	// only for OSGi env
	public void destroy() {
		closeSqlDbConnections();

	}

	private void closeSqlDbConnections() {
		try {
			Object obj_conn;
			obj_conn = globalMap.remove("conn_tDBConnection_1");
			if (null != obj_conn) {
				((java.sql.Connection) obj_conn).close();
			}
		} catch (java.lang.Exception e) {
		}
	}

	private java.util.Map<String, Object> getSharedConnections4REST() {
		java.util.Map<String, Object> connections = new java.util.HashMap<String, Object>();
		connections.put("conn_tDBConnection_1", globalMap.get("conn_tDBConnection_1"));

		return connections;
	}

	private void evalParam(String arg) {
		if (arg.startsWith("--resuming_logs_dir_path")) {
			resuming_logs_dir_path = arg.substring(25);
		} else if (arg.startsWith("--resuming_checkpoint_path")) {
			resuming_checkpoint_path = arg.substring(27);
		} else if (arg.startsWith("--parent_part_launcher")) {
			parent_part_launcher = arg.substring(23);
		} else if (arg.startsWith("--watch")) {
			watch = true;
		} else if (arg.startsWith("--stat_port=")) {
			String portStatsStr = arg.substring(12);
			if (portStatsStr != null && !portStatsStr.equals("null")) {
				portStats = Integer.parseInt(portStatsStr);
			}
		} else if (arg.startsWith("--trace_port=")) {
			portTraces = Integer.parseInt(arg.substring(13));
		} else if (arg.startsWith("--client_host=")) {
			clientHost = arg.substring(14);
		} else if (arg.startsWith("--context=")) {
			contextStr = arg.substring(10);
			isDefaultContext = false;
		} else if (arg.startsWith("--father_pid=")) {
			fatherPid = arg.substring(13);
		} else if (arg.startsWith("--root_pid=")) {
			rootPid = arg.substring(11);
		} else if (arg.startsWith("--father_node=")) {
			fatherNode = arg.substring(14);
		} else if (arg.startsWith("--pid=")) {
			pid = arg.substring(6);
		} else if (arg.startsWith("--context_type")) {
			String keyValue = arg.substring(15);
			int index = -1;
			if (keyValue != null && (index = keyValue.indexOf('=')) > -1) {
				if (fatherPid == null) {
					context_param.setContextType(keyValue.substring(0, index),
							replaceEscapeChars(keyValue.substring(index + 1)));
				} else { // the subjob won't escape the especial chars
					context_param.setContextType(keyValue.substring(0, index), keyValue.substring(index + 1));
				}

			}

		} else if (arg.startsWith("--context_param")) {
			String keyValue = arg.substring(16);
			int index = -1;
			if (keyValue != null && (index = keyValue.indexOf('=')) > -1) {
				if (fatherPid == null) {
					context_param.put(keyValue.substring(0, index), replaceEscapeChars(keyValue.substring(index + 1)));
				} else { // the subjob won't escape the especial chars
					context_param.put(keyValue.substring(0, index), keyValue.substring(index + 1));
				}
			}
		} else if (arg.startsWith("--log4jLevel=")) {
			log4jLevel = arg.substring(13);
		} else if (arg.startsWith("--audit.enabled") && arg.contains("=")) {// for trunjob call
			final int equal = arg.indexOf('=');
			final String key = arg.substring("--".length(), equal);
			System.setProperty(key, arg.substring(equal + 1));
		}
	}

	private static final String NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY = "<TALEND_NULL>";

	private final String[][] escapeChars = { { "\\\\", "\\" }, { "\\n", "\n" }, { "\\'", "\'" }, { "\\r", "\r" },
			{ "\\f", "\f" }, { "\\b", "\b" }, { "\\t", "\t" } };

	private String replaceEscapeChars(String keyValue) {

		if (keyValue == null || ("").equals(keyValue.trim())) {
			return keyValue;
		}

		StringBuilder result = new StringBuilder();
		int currIndex = 0;
		while (currIndex < keyValue.length()) {
			int index = -1;
			// judege if the left string includes escape chars
			for (String[] strArray : escapeChars) {
				index = keyValue.indexOf(strArray[0], currIndex);
				if (index >= 0) {

					result.append(keyValue.substring(currIndex, index + strArray[0].length()).replace(strArray[0],
							strArray[1]));
					currIndex = index + strArray[0].length();
					break;
				}
			}
			// if the left string doesn't include escape chars, append the left into the
			// result
			if (index < 0) {
				result.append(keyValue.substring(currIndex));
				currIndex = currIndex + keyValue.length();
			}
		}

		return result.toString();
	}

	public Integer getErrorCode() {
		return errorCode;
	}

	public String getStatus() {
		return status;
	}

	ResumeUtil resumeUtil = null;
}
/************************************************************************************************
 * 140048 characters generated by Talend Open Studio for ESB on the 5 août 2024
 * à 10:47:21 AM CET
 ************************************************************************************************/