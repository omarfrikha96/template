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

package salesforce.updatetrestclient_0_1;

import routines.Numeric;
import routines.DataOperation;
import routines.TalendDataGenerator;
import routines.TalendStringUtil;
import routines.TalendString;
import routines.StringHandling;
import routines.TokenException;
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

//the import part of tJavaRow_1
//import java.util.List;

//the import part of tJavaRow_2
//import java.util.List;

@SuppressWarnings("unused")

/**
 * Job: updateTrestClient Purpose: <br>
 * Description: <br>
 * 
 * @author user@talend.com
 * @version 8.0.1.20211109_1610
 * @status
 */
public class updateTrestClient implements TalendJob {
	static {
		System.setProperty("TalendJob.log", "updateTrestClient.log");
	}

	private static org.apache.logging.log4j.Logger log = org.apache.logging.log4j.LogManager
			.getLogger(updateTrestClient.class);

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

			if (csv_path != null) {

				this.setProperty("csv_path", csv_path.toString());

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

		public String csv_path;

		public String getCsv_path() {
			return this.csv_path;
		}
	}

	protected ContextProperties context = new ContextProperties(); // will be instanciated by MS.

	public ContextProperties getContext() {
		return this.context;
	}

	private final String jobVersion = "0.1";
	private final String jobName = "updateTrestClient";
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

	LogCatcherUtils tLogCatcher_1 = new LogCatcherUtils();

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
					updateTrestClient.this.exception = e;
				}
			}
			if (!(e instanceof TalendException)) {
				try {
					for (java.lang.reflect.Method m : this.getClass().getEnclosingClass().getMethods()) {
						if (m.getName().compareTo(currentComponent + "_error") == 0) {
							m.invoke(updateTrestClient.this, new Object[] { e, currentComponent, globalMap });
							break;
						}
					}

					if (!(e instanceof TDieException)) {
						tLogCatcher_1.addMessage("Java Exception", currentComponent, 6,
								e.getClass().getName() + ":" + e.getMessage(), 1);
						tLogCatcher_1Process(globalMap);
					}
				} catch (TalendException e) {
					// do nothing

				} catch (Exception e) {
					this.e.printStackTrace();
				}
			}
		}
	}

	public void tLogCatcher_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tLogCatcher_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tJavaRow_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tLogCatcher_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tMap_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tLogCatcher_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tJavaRow_2_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tLogCatcher_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tFlowToIterate_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tLogCatcher_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tFixedFlowInput_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tLogCatcher_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tRESTResponse_2_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tLogCatcher_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tPrejob_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tPrejob_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tSetGlobalVar_2_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tSetGlobalVar_2_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tSetGlobalVar_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tRESTRequest_1_Loop_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tFixedFlowInput_2_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFixedFlowInput_2_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tExtractJSONFields_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFixedFlowInput_2_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tMap_2_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFixedFlowInput_2_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tRESTClient_2_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFixedFlowInput_2_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tRESTResponse_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFixedFlowInput_2_onSubJobError(exception, errorComponent, globalMap);
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

	public void tLogCatcher_1_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public void tPrejob_1_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public void tSetGlobalVar_2_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public void tFixedFlowInput_2_onSubJobError(Exception exception, String errorComponent,
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
		return "/api/v1.0.0";
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

		private final updateTrestClient job;

		public RestServiceProviderImpl4TalendJob(updateTrestClient job) {
			this.job = job;
		}

		private void populateRequestWithJobContext(java.util.Map<String, Object> requestGlobalMap,
				updateTrestClient job) {
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

		@javax.ws.rs.PUT()

		@javax.ws.rs.Path("/pet")
		@javax.ws.rs.Consumes({ "application/json" })
		@javax.ws.rs.Produces({ "application/xml", "text/xml", "application/json" })
		public javax.ws.rs.core.Response header(

				@javax.ws.rs.HeaderParam("Authorization") String Authorization

				, String body

		) {
			java.util.Map<String, Object> request_tRESTRequest_1 = new java.util.HashMap<String, Object>();
			request_tRESTRequest_1.put("VERB", "PUT");
			request_tRESTRequest_1.put("OPERATION", "header");
			request_tRESTRequest_1.put("PATTERN", "/pet");

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

		private final updateTrestClient job;

		private org.apache.cxf.endpoint.Server server;

		private org.apache.cxf.jaxrs.JAXRSServerFactoryBean sf;

		public Thread4RestServiceProviderEndpoint(updateTrestClient job, String endpointUrl) {
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
			java.io.InputStream inContext = updateTrestClient.class.getClassLoader()
					.getResourceAsStream("salesforce/updatetrestclient_0_1/contexts/" + context + ".properties");
			if (inContext == null) {
				inContext = updateTrestClient.class.getClassLoader()
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

	public static class row7Struct implements routines.system.IPersistableRow<row7Struct> {
		final static byte[] commonByteArrayLock_SALESFORCE_updateTrestClient = new byte[0];
		static byte[] commonByteArray_SALESFORCE_updateTrestClient = new byte[0];

		public String body;

		public String getBody() {
			return this.body;
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_SALESFORCE_updateTrestClient.length) {
					if (length < 1024 && commonByteArray_SALESFORCE_updateTrestClient.length == 0) {
						commonByteArray_SALESFORCE_updateTrestClient = new byte[1024];
					} else {
						commonByteArray_SALESFORCE_updateTrestClient = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_SALESFORCE_updateTrestClient, 0, length);
				strReturn = new String(commonByteArray_SALESFORCE_updateTrestClient, 0, length, utf8Charset);
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
				if (length > commonByteArray_SALESFORCE_updateTrestClient.length) {
					if (length < 1024 && commonByteArray_SALESFORCE_updateTrestClient.length == 0) {
						commonByteArray_SALESFORCE_updateTrestClient = new byte[1024];
					} else {
						commonByteArray_SALESFORCE_updateTrestClient = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_SALESFORCE_updateTrestClient, 0, length);
				strReturn = new String(commonByteArray_SALESFORCE_updateTrestClient, 0, length, utf8Charset);
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

			synchronized (commonByteArrayLock_SALESFORCE_updateTrestClient) {

				try {

					int length = 0;

					this.body = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_SALESFORCE_updateTrestClient) {

				try {

					int length = 0;

					this.body = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.body, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.body, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("body=" + body);
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

	public static class row3Struct implements routines.system.IPersistableRow<row3Struct> {
		final static byte[] commonByteArrayLock_SALESFORCE_updateTrestClient = new byte[0];
		static byte[] commonByteArray_SALESFORCE_updateTrestClient = new byte[0];

		public Integer httpCode;

		public Integer getHttpCode() {
			return this.httpCode;
		}

		public String error_message;

		public String getError_message() {
			return this.error_message;
		}

		private Integer readInteger(ObjectInputStream dis) throws IOException {
			Integer intReturn;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				intReturn = null;
			} else {
				intReturn = dis.readInt();
			}
			return intReturn;
		}

		private Integer readInteger(org.jboss.marshalling.Unmarshaller dis) throws IOException {
			Integer intReturn;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				intReturn = null;
			} else {
				intReturn = dis.readInt();
			}
			return intReturn;
		}

		private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException {
			if (intNum == null) {
				dos.writeByte(-1);
			} else {
				dos.writeByte(0);
				dos.writeInt(intNum);
			}
		}

		private void writeInteger(Integer intNum, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (intNum == null) {
				marshaller.writeByte(-1);
			} else {
				marshaller.writeByte(0);
				marshaller.writeInt(intNum);
			}
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_SALESFORCE_updateTrestClient.length) {
					if (length < 1024 && commonByteArray_SALESFORCE_updateTrestClient.length == 0) {
						commonByteArray_SALESFORCE_updateTrestClient = new byte[1024];
					} else {
						commonByteArray_SALESFORCE_updateTrestClient = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_SALESFORCE_updateTrestClient, 0, length);
				strReturn = new String(commonByteArray_SALESFORCE_updateTrestClient, 0, length, utf8Charset);
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
				if (length > commonByteArray_SALESFORCE_updateTrestClient.length) {
					if (length < 1024 && commonByteArray_SALESFORCE_updateTrestClient.length == 0) {
						commonByteArray_SALESFORCE_updateTrestClient = new byte[1024];
					} else {
						commonByteArray_SALESFORCE_updateTrestClient = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_SALESFORCE_updateTrestClient, 0, length);
				strReturn = new String(commonByteArray_SALESFORCE_updateTrestClient, 0, length, utf8Charset);
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

			synchronized (commonByteArrayLock_SALESFORCE_updateTrestClient) {

				try {

					int length = 0;

					this.httpCode = readInteger(dis);

					this.error_message = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_SALESFORCE_updateTrestClient) {

				try {

					int length = 0;

					this.httpCode = readInteger(dis);

					this.error_message = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// Integer

				writeInteger(this.httpCode, dos);

				// String

				writeString(this.error_message, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// Integer

				writeInteger(this.httpCode, dos);

				// String

				writeString(this.error_message, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("httpCode=" + String.valueOf(httpCode));
			sb.append(",error_message=" + error_message);
			sb.append("]");

			return sb.toString();
		}

		public String toLogString() {
			StringBuilder sb = new StringBuilder();

			if (httpCode == null) {
				sb.append("<null>");
			} else {
				sb.append(httpCode);
			}

			sb.append("|");

			if (error_message == null) {
				sb.append("<null>");
			} else {
				sb.append(error_message);
			}

			sb.append("|");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(row3Struct other) {

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

	public static class out3Struct implements routines.system.IPersistableRow<out3Struct> {
		final static byte[] commonByteArrayLock_SALESFORCE_updateTrestClient = new byte[0];
		static byte[] commonByteArray_SALESFORCE_updateTrestClient = new byte[0];

		public Integer httpCode;

		public Integer getHttpCode() {
			return this.httpCode;
		}

		public String error_message;

		public String getError_message() {
			return this.error_message;
		}

		private Integer readInteger(ObjectInputStream dis) throws IOException {
			Integer intReturn;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				intReturn = null;
			} else {
				intReturn = dis.readInt();
			}
			return intReturn;
		}

		private Integer readInteger(org.jboss.marshalling.Unmarshaller dis) throws IOException {
			Integer intReturn;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				intReturn = null;
			} else {
				intReturn = dis.readInt();
			}
			return intReturn;
		}

		private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException {
			if (intNum == null) {
				dos.writeByte(-1);
			} else {
				dos.writeByte(0);
				dos.writeInt(intNum);
			}
		}

		private void writeInteger(Integer intNum, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (intNum == null) {
				marshaller.writeByte(-1);
			} else {
				marshaller.writeByte(0);
				marshaller.writeInt(intNum);
			}
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_SALESFORCE_updateTrestClient.length) {
					if (length < 1024 && commonByteArray_SALESFORCE_updateTrestClient.length == 0) {
						commonByteArray_SALESFORCE_updateTrestClient = new byte[1024];
					} else {
						commonByteArray_SALESFORCE_updateTrestClient = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_SALESFORCE_updateTrestClient, 0, length);
				strReturn = new String(commonByteArray_SALESFORCE_updateTrestClient, 0, length, utf8Charset);
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
				if (length > commonByteArray_SALESFORCE_updateTrestClient.length) {
					if (length < 1024 && commonByteArray_SALESFORCE_updateTrestClient.length == 0) {
						commonByteArray_SALESFORCE_updateTrestClient = new byte[1024];
					} else {
						commonByteArray_SALESFORCE_updateTrestClient = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_SALESFORCE_updateTrestClient, 0, length);
				strReturn = new String(commonByteArray_SALESFORCE_updateTrestClient, 0, length, utf8Charset);
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

			synchronized (commonByteArrayLock_SALESFORCE_updateTrestClient) {

				try {

					int length = 0;

					this.httpCode = readInteger(dis);

					this.error_message = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_SALESFORCE_updateTrestClient) {

				try {

					int length = 0;

					this.httpCode = readInteger(dis);

					this.error_message = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// Integer

				writeInteger(this.httpCode, dos);

				// String

				writeString(this.error_message, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// Integer

				writeInteger(this.httpCode, dos);

				// String

				writeString(this.error_message, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("httpCode=" + String.valueOf(httpCode));
			sb.append(",error_message=" + error_message);
			sb.append("]");

			return sb.toString();
		}

		public String toLogString() {
			StringBuilder sb = new StringBuilder();

			if (httpCode == null) {
				sb.append("<null>");
			} else {
				sb.append(httpCode);
			}

			sb.append("|");

			if (error_message == null) {
				sb.append("<null>");
			} else {
				sb.append(error_message);
			}

			sb.append("|");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(out3Struct other) {

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

	public static class row5Struct implements routines.system.IPersistableRow<row5Struct> {
		final static byte[] commonByteArrayLock_SALESFORCE_updateTrestClient = new byte[0];
		static byte[] commonByteArray_SALESFORCE_updateTrestClient = new byte[0];

		public Integer httpCode;

		public Integer getHttpCode() {
			return this.httpCode;
		}

		public String error_message;

		public String getError_message() {
			return this.error_message;
		}

		public String origin;

		public String getOrigin() {
			return this.origin;
		}

		public String type;

		public String getType() {
			return this.type;
		}

		private Integer readInteger(ObjectInputStream dis) throws IOException {
			Integer intReturn;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				intReturn = null;
			} else {
				intReturn = dis.readInt();
			}
			return intReturn;
		}

		private Integer readInteger(org.jboss.marshalling.Unmarshaller dis) throws IOException {
			Integer intReturn;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				intReturn = null;
			} else {
				intReturn = dis.readInt();
			}
			return intReturn;
		}

		private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException {
			if (intNum == null) {
				dos.writeByte(-1);
			} else {
				dos.writeByte(0);
				dos.writeInt(intNum);
			}
		}

		private void writeInteger(Integer intNum, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (intNum == null) {
				marshaller.writeByte(-1);
			} else {
				marshaller.writeByte(0);
				marshaller.writeInt(intNum);
			}
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_SALESFORCE_updateTrestClient.length) {
					if (length < 1024 && commonByteArray_SALESFORCE_updateTrestClient.length == 0) {
						commonByteArray_SALESFORCE_updateTrestClient = new byte[1024];
					} else {
						commonByteArray_SALESFORCE_updateTrestClient = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_SALESFORCE_updateTrestClient, 0, length);
				strReturn = new String(commonByteArray_SALESFORCE_updateTrestClient, 0, length, utf8Charset);
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
				if (length > commonByteArray_SALESFORCE_updateTrestClient.length) {
					if (length < 1024 && commonByteArray_SALESFORCE_updateTrestClient.length == 0) {
						commonByteArray_SALESFORCE_updateTrestClient = new byte[1024];
					} else {
						commonByteArray_SALESFORCE_updateTrestClient = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_SALESFORCE_updateTrestClient, 0, length);
				strReturn = new String(commonByteArray_SALESFORCE_updateTrestClient, 0, length, utf8Charset);
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

			synchronized (commonByteArrayLock_SALESFORCE_updateTrestClient) {

				try {

					int length = 0;

					this.httpCode = readInteger(dis);

					this.error_message = readString(dis);

					this.origin = readString(dis);

					this.type = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_SALESFORCE_updateTrestClient) {

				try {

					int length = 0;

					this.httpCode = readInteger(dis);

					this.error_message = readString(dis);

					this.origin = readString(dis);

					this.type = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// Integer

				writeInteger(this.httpCode, dos);

				// String

				writeString(this.error_message, dos);

				// String

				writeString(this.origin, dos);

				// String

				writeString(this.type, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// Integer

				writeInteger(this.httpCode, dos);

				// String

				writeString(this.error_message, dos);

				// String

				writeString(this.origin, dos);

				// String

				writeString(this.type, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("httpCode=" + String.valueOf(httpCode));
			sb.append(",error_message=" + error_message);
			sb.append(",origin=" + origin);
			sb.append(",type=" + type);
			sb.append("]");

			return sb.toString();
		}

		public String toLogString() {
			StringBuilder sb = new StringBuilder();

			if (httpCode == null) {
				sb.append("<null>");
			} else {
				sb.append(httpCode);
			}

			sb.append("|");

			if (error_message == null) {
				sb.append("<null>");
			} else {
				sb.append(error_message);
			}

			sb.append("|");

			if (origin == null) {
				sb.append("<null>");
			} else {
				sb.append(origin);
			}

			sb.append("|");

			if (type == null) {
				sb.append("<null>");
			} else {
				sb.append(type);
			}

			sb.append("|");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(row5Struct other) {

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
		final static byte[] commonByteArrayLock_SALESFORCE_updateTrestClient = new byte[0];
		static byte[] commonByteArray_SALESFORCE_updateTrestClient = new byte[0];

		public java.util.Date moment;

		public java.util.Date getMoment() {
			return this.moment;
		}

		public String pid;

		public String getPid() {
			return this.pid;
		}

		public String root_pid;

		public String getRoot_pid() {
			return this.root_pid;
		}

		public String father_pid;

		public String getFather_pid() {
			return this.father_pid;
		}

		public String project;

		public String getProject() {
			return this.project;
		}

		public String job;

		public String getJob() {
			return this.job;
		}

		public String context;

		public String getContext() {
			return this.context;
		}

		public Integer priority;

		public Integer getPriority() {
			return this.priority;
		}

		public String type;

		public String getType() {
			return this.type;
		}

		public String origin;

		public String getOrigin() {
			return this.origin;
		}

		public String message;

		public String getMessage() {
			return this.message;
		}

		public Integer code;

		public Integer getCode() {
			return this.code;
		}

		private java.util.Date readDate(ObjectInputStream dis) throws IOException {
			java.util.Date dateReturn = null;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				dateReturn = null;
			} else {
				dateReturn = new Date(dis.readLong());
			}
			return dateReturn;
		}

		private java.util.Date readDate(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			java.util.Date dateReturn = null;
			int length = 0;
			length = unmarshaller.readByte();
			if (length == -1) {
				dateReturn = null;
			} else {
				dateReturn = new Date(unmarshaller.readLong());
			}
			return dateReturn;
		}

		private void writeDate(java.util.Date date1, ObjectOutputStream dos) throws IOException {
			if (date1 == null) {
				dos.writeByte(-1);
			} else {
				dos.writeByte(0);
				dos.writeLong(date1.getTime());
			}
		}

		private void writeDate(java.util.Date date1, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (date1 == null) {
				marshaller.writeByte(-1);
			} else {
				marshaller.writeByte(0);
				marshaller.writeLong(date1.getTime());
			}
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_SALESFORCE_updateTrestClient.length) {
					if (length < 1024 && commonByteArray_SALESFORCE_updateTrestClient.length == 0) {
						commonByteArray_SALESFORCE_updateTrestClient = new byte[1024];
					} else {
						commonByteArray_SALESFORCE_updateTrestClient = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_SALESFORCE_updateTrestClient, 0, length);
				strReturn = new String(commonByteArray_SALESFORCE_updateTrestClient, 0, length, utf8Charset);
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
				if (length > commonByteArray_SALESFORCE_updateTrestClient.length) {
					if (length < 1024 && commonByteArray_SALESFORCE_updateTrestClient.length == 0) {
						commonByteArray_SALESFORCE_updateTrestClient = new byte[1024];
					} else {
						commonByteArray_SALESFORCE_updateTrestClient = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_SALESFORCE_updateTrestClient, 0, length);
				strReturn = new String(commonByteArray_SALESFORCE_updateTrestClient, 0, length, utf8Charset);
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

		private Integer readInteger(ObjectInputStream dis) throws IOException {
			Integer intReturn;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				intReturn = null;
			} else {
				intReturn = dis.readInt();
			}
			return intReturn;
		}

		private Integer readInteger(org.jboss.marshalling.Unmarshaller dis) throws IOException {
			Integer intReturn;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				intReturn = null;
			} else {
				intReturn = dis.readInt();
			}
			return intReturn;
		}

		private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException {
			if (intNum == null) {
				dos.writeByte(-1);
			} else {
				dos.writeByte(0);
				dos.writeInt(intNum);
			}
		}

		private void writeInteger(Integer intNum, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (intNum == null) {
				marshaller.writeByte(-1);
			} else {
				marshaller.writeByte(0);
				marshaller.writeInt(intNum);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_SALESFORCE_updateTrestClient) {

				try {

					int length = 0;

					this.moment = readDate(dis);

					this.pid = readString(dis);

					this.root_pid = readString(dis);

					this.father_pid = readString(dis);

					this.project = readString(dis);

					this.job = readString(dis);

					this.context = readString(dis);

					this.priority = readInteger(dis);

					this.type = readString(dis);

					this.origin = readString(dis);

					this.message = readString(dis);

					this.code = readInteger(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_SALESFORCE_updateTrestClient) {

				try {

					int length = 0;

					this.moment = readDate(dis);

					this.pid = readString(dis);

					this.root_pid = readString(dis);

					this.father_pid = readString(dis);

					this.project = readString(dis);

					this.job = readString(dis);

					this.context = readString(dis);

					this.priority = readInteger(dis);

					this.type = readString(dis);

					this.origin = readString(dis);

					this.message = readString(dis);

					this.code = readInteger(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// java.util.Date

				writeDate(this.moment, dos);

				// String

				writeString(this.pid, dos);

				// String

				writeString(this.root_pid, dos);

				// String

				writeString(this.father_pid, dos);

				// String

				writeString(this.project, dos);

				// String

				writeString(this.job, dos);

				// String

				writeString(this.context, dos);

				// Integer

				writeInteger(this.priority, dos);

				// String

				writeString(this.type, dos);

				// String

				writeString(this.origin, dos);

				// String

				writeString(this.message, dos);

				// Integer

				writeInteger(this.code, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// java.util.Date

				writeDate(this.moment, dos);

				// String

				writeString(this.pid, dos);

				// String

				writeString(this.root_pid, dos);

				// String

				writeString(this.father_pid, dos);

				// String

				writeString(this.project, dos);

				// String

				writeString(this.job, dos);

				// String

				writeString(this.context, dos);

				// Integer

				writeInteger(this.priority, dos);

				// String

				writeString(this.type, dos);

				// String

				writeString(this.origin, dos);

				// String

				writeString(this.message, dos);

				// Integer

				writeInteger(this.code, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("moment=" + String.valueOf(moment));
			sb.append(",pid=" + pid);
			sb.append(",root_pid=" + root_pid);
			sb.append(",father_pid=" + father_pid);
			sb.append(",project=" + project);
			sb.append(",job=" + job);
			sb.append(",context=" + context);
			sb.append(",priority=" + String.valueOf(priority));
			sb.append(",type=" + type);
			sb.append(",origin=" + origin);
			sb.append(",message=" + message);
			sb.append(",code=" + String.valueOf(code));
			sb.append("]");

			return sb.toString();
		}

		public String toLogString() {
			StringBuilder sb = new StringBuilder();

			if (moment == null) {
				sb.append("<null>");
			} else {
				sb.append(moment);
			}

			sb.append("|");

			if (pid == null) {
				sb.append("<null>");
			} else {
				sb.append(pid);
			}

			sb.append("|");

			if (root_pid == null) {
				sb.append("<null>");
			} else {
				sb.append(root_pid);
			}

			sb.append("|");

			if (father_pid == null) {
				sb.append("<null>");
			} else {
				sb.append(father_pid);
			}

			sb.append("|");

			if (project == null) {
				sb.append("<null>");
			} else {
				sb.append(project);
			}

			sb.append("|");

			if (job == null) {
				sb.append("<null>");
			} else {
				sb.append(job);
			}

			sb.append("|");

			if (context == null) {
				sb.append("<null>");
			} else {
				sb.append(context);
			}

			sb.append("|");

			if (priority == null) {
				sb.append("<null>");
			} else {
				sb.append(priority);
			}

			sb.append("|");

			if (type == null) {
				sb.append("<null>");
			} else {
				sb.append(type);
			}

			sb.append("|");

			if (origin == null) {
				sb.append("<null>");
			} else {
				sb.append(origin);
			}

			sb.append("|");

			if (message == null) {
				sb.append("<null>");
			} else {
				sb.append(message);
			}

			sb.append("|");

			if (code == null) {
				sb.append("<null>");
			} else {
				sb.append(code);
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

	public void tLogCatcher_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tLogCatcher_1_SUBPROCESS_STATE", 0);

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
				row5Struct row5 = new row5Struct();
				out3Struct out3 = new out3Struct();
				row3Struct row3 = new row3Struct();
				row7Struct row7 = new row7Struct();

				/**
				 * [tFlowToIterate_1 begin ] start
				 */

				int NB_ITERATE_tFixedFlowInput_1 = 0; // for statistics

				ok_Hash.put("tFlowToIterate_1", false);
				start_Hash.put("tFlowToIterate_1", System.currentTimeMillis());

				currentComponent = "tFlowToIterate_1";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "row3");
				}

				int tos_count_tFlowToIterate_1 = 0;

				if (log.isDebugEnabled())
					log.debug("tFlowToIterate_1 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tFlowToIterate_1 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tFlowToIterate_1 = new StringBuilder();
							log4jParamters_tFlowToIterate_1.append("Parameters:");
							log4jParamters_tFlowToIterate_1.append("DEFAULT_MAP" + " = " + "false");
							log4jParamters_tFlowToIterate_1.append(" | ");
							log4jParamters_tFlowToIterate_1.append("MAP" + " = " + "[{VALUE=" + ("httpCode") + ", KEY="
									+ ("\"i_httpCode\"") + "}, {VALUE=" + ("error_message") + ", KEY="
									+ ("\"error_message\"") + "}]");
							log4jParamters_tFlowToIterate_1.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tFlowToIterate_1 - " + (log4jParamters_tFlowToIterate_1));
						}
					}
					new BytesLimit65535_tFlowToIterate_1().limitLog4jByte();
				}

				int nb_line_tFlowToIterate_1 = 0;
				int counter_tFlowToIterate_1 = 0;

				/**
				 * [tFlowToIterate_1 begin ] stop
				 */

				/**
				 * [tJavaRow_2 begin ] start
				 */

				ok_Hash.put("tJavaRow_2", false);
				start_Hash.put("tJavaRow_2", System.currentTimeMillis());

				currentComponent = "tJavaRow_2";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "out3");
				}

				int tos_count_tJavaRow_2 = 0;

				int nb_line_tJavaRow_2 = 0;

				/**
				 * [tJavaRow_2 begin ] stop
				 */

				/**
				 * [tMap_1 begin ] start
				 */

				ok_Hash.put("tMap_1", false);
				start_Hash.put("tMap_1", System.currentTimeMillis());

				currentComponent = "tMap_1";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "row5");
				}

				int tos_count_tMap_1 = 0;

				if (log.isDebugEnabled())
					log.debug("tMap_1 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tMap_1 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tMap_1 = new StringBuilder();
							log4jParamters_tMap_1.append("Parameters:");
							log4jParamters_tMap_1.append("LINK_STYLE" + " = " + "AUTO");
							log4jParamters_tMap_1.append(" | ");
							log4jParamters_tMap_1.append("TEMPORARY_DATA_DIRECTORY" + " = " + "");
							log4jParamters_tMap_1.append(" | ");
							log4jParamters_tMap_1.append("ROWS_BUFFER_SIZE" + " = " + "2000000");
							log4jParamters_tMap_1.append(" | ");
							log4jParamters_tMap_1.append("CHANGE_HASH_AND_EQUALS_FOR_BIGDECIMAL" + " = " + "true");
							log4jParamters_tMap_1.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tMap_1 - " + (log4jParamters_tMap_1));
						}
					}
					new BytesLimit65535_tMap_1().limitLog4jByte();
				}

// ###############################
// # Lookup's keys initialization
				int count_row5_tMap_1 = 0;

// ###############################        

// ###############################
// # Vars initialization
				class Var__tMap_1__Struct {
					String var1;
				}
				Var__tMap_1__Struct Var__tMap_1 = new Var__tMap_1__Struct();
// ###############################

// ###############################
// # Outputs initialization
				int count_out3_tMap_1 = 0;

				out3Struct out3_tmp = new out3Struct();
// ###############################

				/**
				 * [tMap_1 begin ] stop
				 */

				/**
				 * [tJavaRow_1 begin ] start
				 */

				ok_Hash.put("tJavaRow_1", false);
				start_Hash.put("tJavaRow_1", System.currentTimeMillis());

				currentComponent = "tJavaRow_1";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "row4");
				}

				int tos_count_tJavaRow_1 = 0;

				int nb_line_tJavaRow_1 = 0;

				/**
				 * [tJavaRow_1 begin ] stop
				 */

				/**
				 * [tLogCatcher_1 begin ] start
				 */

				ok_Hash.put("tLogCatcher_1", false);
				start_Hash.put("tLogCatcher_1", System.currentTimeMillis());

				currentComponent = "tLogCatcher_1";

				int tos_count_tLogCatcher_1 = 0;

				if (log.isDebugEnabled())
					log.debug("tLogCatcher_1 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tLogCatcher_1 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tLogCatcher_1 = new StringBuilder();
							log4jParamters_tLogCatcher_1.append("Parameters:");
							log4jParamters_tLogCatcher_1.append("CATCH_JAVA_EXCEPTION" + " = " + "true");
							log4jParamters_tLogCatcher_1.append(" | ");
							log4jParamters_tLogCatcher_1.append("CATCH_TDIE" + " = " + "true");
							log4jParamters_tLogCatcher_1.append(" | ");
							log4jParamters_tLogCatcher_1.append("CATCH_TWARN" + " = " + "true");
							log4jParamters_tLogCatcher_1.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tLogCatcher_1 - " + (log4jParamters_tLogCatcher_1));
						}
					}
					new BytesLimit65535_tLogCatcher_1().limitLog4jByte();
				}

				try {
					for (LogCatcherUtils.LogCatcherMessage lcm : tLogCatcher_1.getMessages()) {
						row4.type = lcm.getType();
						row4.origin = (lcm.getOrigin() == null || lcm.getOrigin().length() < 1 ? null
								: lcm.getOrigin());
						row4.priority = lcm.getPriority();
						row4.message = lcm.getMessage();
						row4.code = lcm.getCode();

						row4.moment = java.util.Calendar.getInstance().getTime();

						row4.pid = pid;
						row4.root_pid = rootPid;
						row4.father_pid = fatherPid;

						row4.project = projectName;
						row4.job = jobName;
						row4.context = contextStr;

						/**
						 * [tLogCatcher_1 begin ] stop
						 */

						/**
						 * [tLogCatcher_1 main ] start
						 */

						currentComponent = "tLogCatcher_1";

						tos_count_tLogCatcher_1++;

						/**
						 * [tLogCatcher_1 main ] stop
						 */

						/**
						 * [tLogCatcher_1 process_data_begin ] start
						 */

						currentComponent = "tLogCatcher_1";

						/**
						 * [tLogCatcher_1 process_data_begin ] stop
						 */

						/**
						 * [tJavaRow_1 main ] start
						 */

						currentComponent = "tJavaRow_1";

						if (execStat) {
							runStat.updateStatOnConnection(iterateId, 1, 1

									, "row4"

							);
						}

						if (log.isTraceEnabled()) {
							log.trace("row4 - " + (row4 == null ? "" : row4.toLogString()));
						}

						// Get input from tLogCatcher
						row5.origin = row4.origin;
						row5.type = row4.type;
						String logMessage = row4.message;

//Declare the HTTP code variable
						Integer httpCode;

// Customize these responses according to your API response

						if (logMessage != null && logMessage.contains("Not Found")) {
							row5.error_message = "Pet Not Found";
							row5.httpCode = 404;
						} else if (logMessage != null && logMessage.contains("Bad Request")) {
							row5.error_message = "Invalid ID supplied";
							row5.httpCode = 400;
						}

// These are standard responses, don't change them!
						else if (logMessage != null && logMessage.contains("Invalid JWS")) {
							row5.error_message = "invalid token";
							row5.httpCode = 401;
						} else {
							row5.error_message = logMessage;
							row5.httpCode = 500;
						}

						nb_line_tJavaRow_1++;

						tos_count_tJavaRow_1++;

						/**
						 * [tJavaRow_1 main ] stop
						 */

						/**
						 * [tJavaRow_1 process_data_begin ] start
						 */

						currentComponent = "tJavaRow_1";

						/**
						 * [tJavaRow_1 process_data_begin ] stop
						 */

						/**
						 * [tMap_1 main ] start
						 */

						currentComponent = "tMap_1";

						if (execStat) {
							runStat.updateStatOnConnection(iterateId, 1, 1

									, "row5"

							);
						}

						if (log.isTraceEnabled()) {
							log.trace("row5 - " + (row5 == null ? "" : row5.toLogString()));
						}

						boolean hasCasePrimitiveKeyWithNull_tMap_1 = false;

						// ###############################
						// # Input tables (lookups)
						boolean rejectedInnerJoin_tMap_1 = false;
						boolean mainRowRejected_tMap_1 = false;

						// ###############################
						{ // start of Var scope

							// ###############################
							// # Vars tables

							Var__tMap_1__Struct Var = Var__tMap_1;
							Var.var1 = "{" + "\n\t\t\t\t\"origin\":\"" + row5.origin + "\"," + "\n\t\t\t\t\"type\":\""
									+ row5.type + "\"," + "\n\t\t\t\t\"message\":\"" + row5.error_message + "\"" + "}";// ###############################
																														// ###############################
																														// #
																														// Output
																														// tables

							out3 = null;

// # Output table : 'out3'
							count_out3_tMap_1++;

							out3_tmp.httpCode = row5.httpCode;
							out3_tmp.error_message = Var.var1;
							out3 = out3_tmp;
							log.debug("tMap_1 - Outputting the record " + count_out3_tMap_1
									+ " of the output table 'out3'.");

// ###############################

						} // end of Var scope

						rejectedInnerJoin_tMap_1 = false;

						tos_count_tMap_1++;

						/**
						 * [tMap_1 main ] stop
						 */

						/**
						 * [tMap_1 process_data_begin ] start
						 */

						currentComponent = "tMap_1";

						/**
						 * [tMap_1 process_data_begin ] stop
						 */
// Start of branch "out3"
						if (out3 != null) {

							/**
							 * [tJavaRow_2 main ] start
							 */

							currentComponent = "tJavaRow_2";

							if (execStat) {
								runStat.updateStatOnConnection(iterateId, 1, 1

										, "out3"

								);
							}

							if (log.isTraceEnabled()) {
								log.trace("out3 - " + (out3 == null ? "" : out3.toLogString()));
							}

							row3.httpCode = out3.httpCode;
							row3.error_message = out3.error_message;

							nb_line_tJavaRow_2++;

							tos_count_tJavaRow_2++;

							/**
							 * [tJavaRow_2 main ] stop
							 */

							/**
							 * [tJavaRow_2 process_data_begin ] start
							 */

							currentComponent = "tJavaRow_2";

							/**
							 * [tJavaRow_2 process_data_begin ] stop
							 */

							/**
							 * [tFlowToIterate_1 main ] start
							 */

							currentComponent = "tFlowToIterate_1";

							if (execStat) {
								runStat.updateStatOnConnection(iterateId, 1, 1

										, "row3"

								);
							}

							if (log.isTraceEnabled()) {
								log.trace("row3 - " + (row3 == null ? "" : row3.toLogString()));
							}

							if (log.isTraceEnabled())
								log.trace("tFlowToIterate_1 - " + ("Set global var, key=") + ("i_httpCode")
										+ (", value=") + (row3.httpCode) + ("."));
							globalMap.put("i_httpCode", row3.httpCode);
							if (log.isTraceEnabled())
								log.trace("tFlowToIterate_1 - " + ("Set global var, key=") + ("error_message")
										+ (", value=") + (row3.error_message) + ("."));
							globalMap.put("error_message", row3.error_message);
							nb_line_tFlowToIterate_1++;
							counter_tFlowToIterate_1++;
							if (log.isDebugEnabled())
								log.debug("tFlowToIterate_1 - " + ("Current iteration is: ")
										+ (counter_tFlowToIterate_1) + ("."));
							globalMap.put("tFlowToIterate_1_CURRENT_ITERATION", counter_tFlowToIterate_1);

							tos_count_tFlowToIterate_1++;

							/**
							 * [tFlowToIterate_1 main ] stop
							 */

							/**
							 * [tFlowToIterate_1 process_data_begin ] start
							 */

							currentComponent = "tFlowToIterate_1";

							/**
							 * [tFlowToIterate_1 process_data_begin ] stop
							 */
							NB_ITERATE_tFixedFlowInput_1++;

							if (execStat) {
								runStat.updateStatOnConnection("row7", 3, 0);
							}

							if (execStat) {
								runStat.updateStatOnConnection("iterate1", 1, "exec" + NB_ITERATE_tFixedFlowInput_1);
								// Thread.sleep(1000);
							}

							/**
							 * [tRESTResponse_2 begin ] start
							 */

							ok_Hash.put("tRESTResponse_2", false);
							start_Hash.put("tRESTResponse_2", System.currentTimeMillis());

							currentComponent = "tRESTResponse_2";

							if (execStat) {
								runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "row7");
							}

							int tos_count_tRESTResponse_2 = 0;

							/**
							 * [tRESTResponse_2 begin ] stop
							 */

							/**
							 * [tFixedFlowInput_1 begin ] start
							 */

							ok_Hash.put("tFixedFlowInput_1", false);
							start_Hash.put("tFixedFlowInput_1", System.currentTimeMillis());

							currentComponent = "tFixedFlowInput_1";

							int tos_count_tFixedFlowInput_1 = 0;

							for (int i_tFixedFlowInput_1 = 0; i_tFixedFlowInput_1 < 1; i_tFixedFlowInput_1++) {

								row7.body = (String) globalMap.get("error_message");

								/**
								 * [tFixedFlowInput_1 begin ] stop
								 */

								/**
								 * [tFixedFlowInput_1 main ] start
								 */

								currentComponent = "tFixedFlowInput_1";

								tos_count_tFixedFlowInput_1++;

								/**
								 * [tFixedFlowInput_1 main ] stop
								 */

								/**
								 * [tFixedFlowInput_1 process_data_begin ] start
								 */

								currentComponent = "tFixedFlowInput_1";

								/**
								 * [tFixedFlowInput_1 process_data_begin ] stop
								 */

								/**
								 * [tRESTResponse_2 main ] start
								 */

								currentComponent = "tRESTResponse_2";

								if (execStat) {
									runStat.updateStatOnConnection(iterateId, 1, 1

											, "row7"

									);
								}

								if (log.isTraceEnabled()) {
									log.trace("row7 - " + (row7 == null ? "" : row7.toLogString()));
								}

								java.io.OutputStream outputStream_tRESTResponse_2 = (java.io.OutputStream) globalMap
										.get("restResponseStream");
								boolean responseAlreadySent_tRESTResponse_2 = globalMap.containsKey("restResponse");

								if (null == outputStream_tRESTResponse_2 && responseAlreadySent_tRESTResponse_2) {
									throw new RuntimeException("Rest response already sent.");
								} else if (!globalMap.containsKey("restRequest")) {
									throw new RuntimeException("Not received rest request yet.");
								} else {
									Integer restProviderStatusCode_tRESTResponse_2 = (Integer) globalMap
											.get("i_httpCode");

									Object restProviderResponse_tRESTResponse_2 = null;
									restProviderResponse_tRESTResponse_2 = row7.body;

									java.util.Map<String, String> restProviderResponseHeaders_tRESTResponse_2 = new java.util.TreeMap<String, String>(
											String.CASE_INSENSITIVE_ORDER);
									java.lang.StringBuilder restProviderResponseHeader_cookies_tRESTResponse_2 = new java.lang.StringBuilder();
									final String setCookieHeader = "Set-Cookie";

									if (restProviderResponseHeader_cookies_tRESTResponse_2.length() > 0) {
										restProviderResponseHeaders_tRESTResponse_2.put(setCookieHeader,
												restProviderResponseHeader_cookies_tRESTResponse_2.toString());
									}

									java.util.Map<String, Object> restRequest_tRESTResponse_2 = (java.util.Map<String, Object>) globalMap
											.get("restRequest");
									org.apache.cxf.jaxrs.ext.MessageContext messageContext_tRESTResponse_2 = (org.apache.cxf.jaxrs.ext.MessageContext) restRequest_tRESTResponse_2
											.get("MESSAGE_CONTEXT");

									if (null == outputStream_tRESTResponse_2) {
										java.util.Map<String, Object> restResponse_tRESTResponse_2 = new java.util.HashMap<String, Object>();
										restResponse_tRESTResponse_2.put("BODY", restProviderResponse_tRESTResponse_2);
										restResponse_tRESTResponse_2.put("STATUS",
												restProviderStatusCode_tRESTResponse_2);
										restResponse_tRESTResponse_2.put("HEADERS",
												restProviderResponseHeaders_tRESTResponse_2);
										restResponse_tRESTResponse_2.put("drop.json.root.element",
												Boolean.valueOf(false));
										globalMap.put("restResponse", restResponse_tRESTResponse_2);

									} else {

										javax.ws.rs.core.MediaType responseMediaType_tRESTResponse_2 = null;
										if (!responseAlreadySent_tRESTResponse_2) {
											org.apache.cxf.message.Message currentMessage = null;
											if (org.apache.cxf.jaxrs.utils.JAXRSUtils.getCurrentMessage() != null) {
												currentMessage = org.apache.cxf.jaxrs.utils.JAXRSUtils
														.getCurrentMessage();
											} else {
												currentMessage = ((org.apache.cxf.message.Message) restRequest_tRESTResponse_2
														.get("CURRENT_MESSAGE"));
											}

											if (currentMessage != null && currentMessage.getExchange() != null) {
												currentMessage.getExchange()
														.put(StreamingDOM4JProvider.SUPRESS_XML_DECLARATION, true);
											}

											messageContext_tRESTResponse_2.put(
													org.apache.cxf.message.Message.RESPONSE_CODE,
													restProviderStatusCode_tRESTResponse_2);
											javax.ws.rs.core.MultivaluedMap<String, String> headersMultivaluedMap_tRESTResponse_2 = new org.apache.cxf.jaxrs.impl.MetadataMap<String, String>();
											for (java.util.Map.Entry<String, String> multivaluedHeader : restProviderResponseHeaders_tRESTResponse_2
													.entrySet()) {
												headersMultivaluedMap_tRESTResponse_2.putSingle(
														multivaluedHeader.getKey(), multivaluedHeader.getValue());
											}
											messageContext_tRESTResponse_2.put(
													org.apache.cxf.message.Message.PROTOCOL_HEADERS,
													headersMultivaluedMap_tRESTResponse_2);

											String responseContentType_tRESTResponse_2 = null;

											if (currentMessage != null && currentMessage.getExchange() != null) {
												responseContentType_tRESTResponse_2 = (String) currentMessage
														.getExchange().get(org.apache.cxf.message.Message.CONTENT_TYPE);
											}

											if (null == responseContentType_tRESTResponse_2) {
												// this should not be needed, just in case. set it to the first value in
												// the sorted list returned from HttpHeaders
												responseMediaType_tRESTResponse_2 = messageContext_tRESTResponse_2
														.getHttpHeaders().getAcceptableMediaTypes().get(0);
											} else {
												responseMediaType_tRESTResponse_2 = org.apache.cxf.jaxrs.utils.JAXRSUtils
														.toMediaType(responseContentType_tRESTResponse_2);
											}
											globalMap.put("restResponseMediaType", responseMediaType_tRESTResponse_2);

											String responseMediaSubType_tRESTResponse_2 = responseMediaType_tRESTResponse_2
													.getSubtype();
											if (responseMediaSubType_tRESTResponse_2.equals("xml")
													|| responseMediaSubType_tRESTResponse_2.endsWith("+xml")) {
												outputStream_tRESTResponse_2.write("<wrapper>".getBytes());
												globalMap.put("restResponseWrappingClosure", "</wrapper>");
											}
											if (responseMediaSubType_tRESTResponse_2.equals("json")
													|| responseMediaSubType_tRESTResponse_2.endsWith("+json")) {
												outputStream_tRESTResponse_2.write("[".getBytes());
												globalMap.put("restResponseWrappingClosure", "]");
											}

											globalMap.put("restResponse", true);
										} else {
											responseMediaType_tRESTResponse_2 = (javax.ws.rs.core.MediaType) globalMap
													.get("restResponseMediaType");
										}

										if (null != restProviderResponse_tRESTResponse_2) {
											String responseMediaSubType_tRESTResponse_2 = responseMediaType_tRESTResponse_2
													.getSubtype();
											if (responseMediaSubType_tRESTResponse_2.equals("json")
													|| responseMediaSubType_tRESTResponse_2.endsWith("+json")) {
												if (globalMap.containsKey("restResponseJsonStarted")) {
													outputStream_tRESTResponse_2.write(",".getBytes());
												} else {
													globalMap.put("restResponseJsonStarted", true);
												}
											}

											Class<? extends Object> responseBodyClass_tRESTResponse_2 = restProviderResponse_tRESTResponse_2
													.getClass();
											javax.ws.rs.ext.Providers messageBodyProviders_tRESTResponse_2 = messageContext_tRESTResponse_2
													.getProviders();
											javax.ws.rs.ext.MessageBodyWriter messageBodyWriter_tRESTResponse_2 = messageBodyProviders_tRESTResponse_2
													.getMessageBodyWriter(responseBodyClass_tRESTResponse_2,
															responseBodyClass_tRESTResponse_2, null,
															responseMediaType_tRESTResponse_2);

											if (messageBodyWriter_tRESTResponse_2 instanceof StreamingDOM4JProvider) {
												((StreamingDOM4JProvider) messageBodyWriter_tRESTResponse_2)
														.setGlobalMap(globalMap);
											}

											messageBodyWriter_tRESTResponse_2.writeTo(
													restProviderResponse_tRESTResponse_2,
													responseBodyClass_tRESTResponse_2,
													responseBodyClass_tRESTResponse_2,
													new java.lang.annotation.Annotation[] {},
													responseMediaType_tRESTResponse_2, null,
													outputStream_tRESTResponse_2);
										}
										// initial variant
										// outputStream_tRESTResponse_2.write(String.valueOf(restProviderResponse_tRESTResponse_2).getBytes());
										outputStream_tRESTResponse_2.flush();
									}
								}

								tos_count_tRESTResponse_2++;

								/**
								 * [tRESTResponse_2 main ] stop
								 */

								/**
								 * [tRESTResponse_2 process_data_begin ] start
								 */

								currentComponent = "tRESTResponse_2";

								/**
								 * [tRESTResponse_2 process_data_begin ] stop
								 */

								/**
								 * [tRESTResponse_2 process_data_end ] start
								 */

								currentComponent = "tRESTResponse_2";

								/**
								 * [tRESTResponse_2 process_data_end ] stop
								 */

								/**
								 * [tFixedFlowInput_1 process_data_end ] start
								 */

								currentComponent = "tFixedFlowInput_1";

								/**
								 * [tFixedFlowInput_1 process_data_end ] stop
								 */

								/**
								 * [tFixedFlowInput_1 end ] start
								 */

								currentComponent = "tFixedFlowInput_1";

							}
							globalMap.put("tFixedFlowInput_1_NB_LINE", 1);

							ok_Hash.put("tFixedFlowInput_1", true);
							end_Hash.put("tFixedFlowInput_1", System.currentTimeMillis());

							/**
							 * [tFixedFlowInput_1 end ] stop
							 */

							/**
							 * [tRESTResponse_2 end ] start
							 */

							currentComponent = "tRESTResponse_2";

							if (execStat) {
								runStat.updateStat(resourceMap, iterateId, 2, 0, "row7");
							}

							ok_Hash.put("tRESTResponse_2", true);
							end_Hash.put("tRESTResponse_2", System.currentTimeMillis());

							/**
							 * [tRESTResponse_2 end ] stop
							 */

							if (execStat) {
								runStat.updateStatOnConnection("iterate1", 2, "exec" + NB_ITERATE_tFixedFlowInput_1);
							}

							/**
							 * [tFlowToIterate_1 process_data_end ] start
							 */

							currentComponent = "tFlowToIterate_1";

							/**
							 * [tFlowToIterate_1 process_data_end ] stop
							 */

							/**
							 * [tJavaRow_2 process_data_end ] start
							 */

							currentComponent = "tJavaRow_2";

							/**
							 * [tJavaRow_2 process_data_end ] stop
							 */

						} // End of branch "out3"

						/**
						 * [tMap_1 process_data_end ] start
						 */

						currentComponent = "tMap_1";

						/**
						 * [tMap_1 process_data_end ] stop
						 */

						/**
						 * [tJavaRow_1 process_data_end ] start
						 */

						currentComponent = "tJavaRow_1";

						/**
						 * [tJavaRow_1 process_data_end ] stop
						 */

						/**
						 * [tLogCatcher_1 process_data_end ] start
						 */

						currentComponent = "tLogCatcher_1";

						/**
						 * [tLogCatcher_1 process_data_end ] stop
						 */

						/**
						 * [tLogCatcher_1 end ] start
						 */

						currentComponent = "tLogCatcher_1";

					}
				} catch (Exception e_tLogCatcher_1) {
					globalMap.put("tLogCatcher_1_ERROR_MESSAGE", e_tLogCatcher_1.getMessage());
					logIgnoredError(String.format(
							"tLogCatcher_1 - tLogCatcher failed to process log message(s) due to internal error: %s",
							e_tLogCatcher_1), e_tLogCatcher_1);
				}

				if (log.isDebugEnabled())
					log.debug("tLogCatcher_1 - " + ("Done."));

				ok_Hash.put("tLogCatcher_1", true);
				end_Hash.put("tLogCatcher_1", System.currentTimeMillis());

				/**
				 * [tLogCatcher_1 end ] stop
				 */

				/**
				 * [tJavaRow_1 end ] start
				 */

				currentComponent = "tJavaRow_1";

				globalMap.put("tJavaRow_1_NB_LINE", nb_line_tJavaRow_1);
				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "row4");
				}

				ok_Hash.put("tJavaRow_1", true);
				end_Hash.put("tJavaRow_1", System.currentTimeMillis());

				/**
				 * [tJavaRow_1 end ] stop
				 */

				/**
				 * [tMap_1 end ] start
				 */

				currentComponent = "tMap_1";

// ###############################
// # Lookup hashes releasing
// ###############################      
				log.debug("tMap_1 - Written records count in the table 'out3': " + count_out3_tMap_1 + ".");

				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "row5");
				}

				if (log.isDebugEnabled())
					log.debug("tMap_1 - " + ("Done."));

				ok_Hash.put("tMap_1", true);
				end_Hash.put("tMap_1", System.currentTimeMillis());

				/**
				 * [tMap_1 end ] stop
				 */

				/**
				 * [tJavaRow_2 end ] start
				 */

				currentComponent = "tJavaRow_2";

				globalMap.put("tJavaRow_2_NB_LINE", nb_line_tJavaRow_2);
				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "out3");
				}

				ok_Hash.put("tJavaRow_2", true);
				end_Hash.put("tJavaRow_2", System.currentTimeMillis());

				/**
				 * [tJavaRow_2 end ] stop
				 */

				/**
				 * [tFlowToIterate_1 end ] start
				 */

				currentComponent = "tFlowToIterate_1";

				globalMap.put("tFlowToIterate_1_NB_LINE", nb_line_tFlowToIterate_1);
				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "row3");
				}

				if (log.isDebugEnabled())
					log.debug("tFlowToIterate_1 - " + ("Done."));

				ok_Hash.put("tFlowToIterate_1", true);
				end_Hash.put("tFlowToIterate_1", System.currentTimeMillis());

				/**
				 * [tFlowToIterate_1 end ] stop
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
				 * [tLogCatcher_1 finally ] start
				 */

				currentComponent = "tLogCatcher_1";

				/**
				 * [tLogCatcher_1 finally ] stop
				 */

				/**
				 * [tJavaRow_1 finally ] start
				 */

				currentComponent = "tJavaRow_1";

				/**
				 * [tJavaRow_1 finally ] stop
				 */

				/**
				 * [tMap_1 finally ] start
				 */

				currentComponent = "tMap_1";

				/**
				 * [tMap_1 finally ] stop
				 */

				/**
				 * [tJavaRow_2 finally ] start
				 */

				currentComponent = "tJavaRow_2";

				/**
				 * [tJavaRow_2 finally ] stop
				 */

				/**
				 * [tFlowToIterate_1 finally ] start
				 */

				currentComponent = "tFlowToIterate_1";

				/**
				 * [tFlowToIterate_1 finally ] stop
				 */

				/**
				 * [tFixedFlowInput_1 finally ] start
				 */

				currentComponent = "tFixedFlowInput_1";

				/**
				 * [tFixedFlowInput_1 finally ] stop
				 */

				/**
				 * [tRESTResponse_2 finally ] start
				 */

				currentComponent = "tRESTResponse_2";

				/**
				 * [tRESTResponse_2 finally ] stop
				 */

			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tLogCatcher_1_SUBPROCESS_STATE", 1);
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
				tSetGlobalVar_2Process(globalMap);

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
									+ ("new TokenException(context.azure_tenant_id, context.azure_client_id)")
									+ ", KEY=" + ("\"tokenException\"") + "}]");
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

				globalMap.put("tokenException", new TokenException(context.azure_tenant_id, context.azure_client_id));

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

	public static class row1Struct implements routines.system.IPersistableRow<row1Struct> {
		final static byte[] commonByteArrayLock_SALESFORCE_updateTrestClient = new byte[0];
		static byte[] commonByteArray_SALESFORCE_updateTrestClient = new byte[0];

		public Integer statusCode;

		public Integer getStatusCode() {
			return this.statusCode;
		}

		public routines.system.Document body;

		public routines.system.Document getBody() {
			return this.body;
		}

		public String string;

		public String getString() {
			return this.string;
		}

		private Integer readInteger(ObjectInputStream dis) throws IOException {
			Integer intReturn;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				intReturn = null;
			} else {
				intReturn = dis.readInt();
			}
			return intReturn;
		}

		private Integer readInteger(org.jboss.marshalling.Unmarshaller dis) throws IOException {
			Integer intReturn;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				intReturn = null;
			} else {
				intReturn = dis.readInt();
			}
			return intReturn;
		}

		private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException {
			if (intNum == null) {
				dos.writeByte(-1);
			} else {
				dos.writeByte(0);
				dos.writeInt(intNum);
			}
		}

		private void writeInteger(Integer intNum, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (intNum == null) {
				marshaller.writeByte(-1);
			} else {
				marshaller.writeByte(0);
				marshaller.writeInt(intNum);
			}
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_SALESFORCE_updateTrestClient.length) {
					if (length < 1024 && commonByteArray_SALESFORCE_updateTrestClient.length == 0) {
						commonByteArray_SALESFORCE_updateTrestClient = new byte[1024];
					} else {
						commonByteArray_SALESFORCE_updateTrestClient = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_SALESFORCE_updateTrestClient, 0, length);
				strReturn = new String(commonByteArray_SALESFORCE_updateTrestClient, 0, length, utf8Charset);
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
				if (length > commonByteArray_SALESFORCE_updateTrestClient.length) {
					if (length < 1024 && commonByteArray_SALESFORCE_updateTrestClient.length == 0) {
						commonByteArray_SALESFORCE_updateTrestClient = new byte[1024];
					} else {
						commonByteArray_SALESFORCE_updateTrestClient = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_SALESFORCE_updateTrestClient, 0, length);
				strReturn = new String(commonByteArray_SALESFORCE_updateTrestClient, 0, length, utf8Charset);
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

			synchronized (commonByteArrayLock_SALESFORCE_updateTrestClient) {

				try {

					int length = 0;

					this.statusCode = readInteger(dis);

					this.body = (routines.system.Document) dis.readObject();

					this.string = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				} catch (ClassNotFoundException eCNFE) {
					throw new RuntimeException(eCNFE);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_SALESFORCE_updateTrestClient) {

				try {

					int length = 0;

					this.statusCode = readInteger(dis);

					this.body = (routines.system.Document) dis.readObject();

					this.string = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				} catch (ClassNotFoundException eCNFE) {
					throw new RuntimeException(eCNFE);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// Integer

				writeInteger(this.statusCode, dos);

				// Document

				dos.writeObject(this.body);

				// String

				writeString(this.string, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// Integer

				writeInteger(this.statusCode, dos);

				// Document

				dos.writeObject(this.body);

				// String

				writeString(this.string, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("statusCode=" + String.valueOf(statusCode));
			sb.append(",body=" + String.valueOf(body));
			sb.append(",string=" + string);
			sb.append("]");

			return sb.toString();
		}

		public String toLogString() {
			StringBuilder sb = new StringBuilder();

			if (statusCode == null) {
				sb.append("<null>");
			} else {
				sb.append(statusCode);
			}

			sb.append("|");

			if (body == null) {
				sb.append("<null>");
			} else {
				sb.append(body);
			}

			sb.append("|");

			if (string == null) {
				sb.append("<null>");
			} else {
				sb.append(string);
			}

			sb.append("|");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(row1Struct other) {

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

	public static class bodyStruct implements routines.system.IPersistableRow<bodyStruct> {
		final static byte[] commonByteArrayLock_SALESFORCE_updateTrestClient = new byte[0];
		static byte[] commonByteArray_SALESFORCE_updateTrestClient = new byte[0];

		public String string;

		public String getString() {
			return this.string;
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_SALESFORCE_updateTrestClient.length) {
					if (length < 1024 && commonByteArray_SALESFORCE_updateTrestClient.length == 0) {
						commonByteArray_SALESFORCE_updateTrestClient = new byte[1024];
					} else {
						commonByteArray_SALESFORCE_updateTrestClient = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_SALESFORCE_updateTrestClient, 0, length);
				strReturn = new String(commonByteArray_SALESFORCE_updateTrestClient, 0, length, utf8Charset);
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
				if (length > commonByteArray_SALESFORCE_updateTrestClient.length) {
					if (length < 1024 && commonByteArray_SALESFORCE_updateTrestClient.length == 0) {
						commonByteArray_SALESFORCE_updateTrestClient = new byte[1024];
					} else {
						commonByteArray_SALESFORCE_updateTrestClient = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_SALESFORCE_updateTrestClient, 0, length);
				strReturn = new String(commonByteArray_SALESFORCE_updateTrestClient, 0, length, utf8Charset);
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

			synchronized (commonByteArrayLock_SALESFORCE_updateTrestClient) {

				try {

					int length = 0;

					this.string = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_SALESFORCE_updateTrestClient) {

				try {

					int length = 0;

					this.string = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.string, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.string, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("string=" + string);
			sb.append("]");

			return sb.toString();
		}

		public String toLogString() {
			StringBuilder sb = new StringBuilder();

			if (string == null) {
				sb.append("<null>");
			} else {
				sb.append(string);
			}

			sb.append("|");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(bodyStruct other) {

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
		final static byte[] commonByteArrayLock_SALESFORCE_updateTrestClient = new byte[0];
		static byte[] commonByteArray_SALESFORCE_updateTrestClient = new byte[0];

		public Integer id;

		public Integer getId() {
			return this.id;
		}

		public String name;

		public String getName() {
			return this.name;
		}

		public Integer id_c;

		public Integer getId_c() {
			return this.id_c;
		}

		public String name_c;

		public String getName_c() {
			return this.name_c;
		}

		public String photoUrls;

		public String getPhotoUrls() {
			return this.photoUrls;
		}

		public Integer id_t;

		public Integer getId_t() {
			return this.id_t;
		}

		public String name_t;

		public String getName_t() {
			return this.name_t;
		}

		public String status;

		public String getStatus() {
			return this.status;
		}

		private Integer readInteger(ObjectInputStream dis) throws IOException {
			Integer intReturn;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				intReturn = null;
			} else {
				intReturn = dis.readInt();
			}
			return intReturn;
		}

		private Integer readInteger(org.jboss.marshalling.Unmarshaller dis) throws IOException {
			Integer intReturn;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				intReturn = null;
			} else {
				intReturn = dis.readInt();
			}
			return intReturn;
		}

		private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException {
			if (intNum == null) {
				dos.writeByte(-1);
			} else {
				dos.writeByte(0);
				dos.writeInt(intNum);
			}
		}

		private void writeInteger(Integer intNum, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (intNum == null) {
				marshaller.writeByte(-1);
			} else {
				marshaller.writeByte(0);
				marshaller.writeInt(intNum);
			}
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_SALESFORCE_updateTrestClient.length) {
					if (length < 1024 && commonByteArray_SALESFORCE_updateTrestClient.length == 0) {
						commonByteArray_SALESFORCE_updateTrestClient = new byte[1024];
					} else {
						commonByteArray_SALESFORCE_updateTrestClient = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_SALESFORCE_updateTrestClient, 0, length);
				strReturn = new String(commonByteArray_SALESFORCE_updateTrestClient, 0, length, utf8Charset);
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
				if (length > commonByteArray_SALESFORCE_updateTrestClient.length) {
					if (length < 1024 && commonByteArray_SALESFORCE_updateTrestClient.length == 0) {
						commonByteArray_SALESFORCE_updateTrestClient = new byte[1024];
					} else {
						commonByteArray_SALESFORCE_updateTrestClient = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_SALESFORCE_updateTrestClient, 0, length);
				strReturn = new String(commonByteArray_SALESFORCE_updateTrestClient, 0, length, utf8Charset);
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

			synchronized (commonByteArrayLock_SALESFORCE_updateTrestClient) {

				try {

					int length = 0;

					this.id = readInteger(dis);

					this.name = readString(dis);

					this.id_c = readInteger(dis);

					this.name_c = readString(dis);

					this.photoUrls = readString(dis);

					this.id_t = readInteger(dis);

					this.name_t = readString(dis);

					this.status = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_SALESFORCE_updateTrestClient) {

				try {

					int length = 0;

					this.id = readInteger(dis);

					this.name = readString(dis);

					this.id_c = readInteger(dis);

					this.name_c = readString(dis);

					this.photoUrls = readString(dis);

					this.id_t = readInteger(dis);

					this.name_t = readString(dis);

					this.status = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// Integer

				writeInteger(this.id, dos);

				// String

				writeString(this.name, dos);

				// Integer

				writeInteger(this.id_c, dos);

				// String

				writeString(this.name_c, dos);

				// String

				writeString(this.photoUrls, dos);

				// Integer

				writeInteger(this.id_t, dos);

				// String

				writeString(this.name_t, dos);

				// String

				writeString(this.status, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// Integer

				writeInteger(this.id, dos);

				// String

				writeString(this.name, dos);

				// Integer

				writeInteger(this.id_c, dos);

				// String

				writeString(this.name_c, dos);

				// String

				writeString(this.photoUrls, dos);

				// Integer

				writeInteger(this.id_t, dos);

				// String

				writeString(this.name_t, dos);

				// String

				writeString(this.status, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("id=" + String.valueOf(id));
			sb.append(",name=" + name);
			sb.append(",id_c=" + String.valueOf(id_c));
			sb.append(",name_c=" + name_c);
			sb.append(",photoUrls=" + photoUrls);
			sb.append(",id_t=" + String.valueOf(id_t));
			sb.append(",name_t=" + name_t);
			sb.append(",status=" + status);
			sb.append("]");

			return sb.toString();
		}

		public String toLogString() {
			StringBuilder sb = new StringBuilder();

			if (id == null) {
				sb.append("<null>");
			} else {
				sb.append(id);
			}

			sb.append("|");

			if (name == null) {
				sb.append("<null>");
			} else {
				sb.append(name);
			}

			sb.append("|");

			if (id_c == null) {
				sb.append("<null>");
			} else {
				sb.append(id_c);
			}

			sb.append("|");

			if (name_c == null) {
				sb.append("<null>");
			} else {
				sb.append(name_c);
			}

			sb.append("|");

			if (photoUrls == null) {
				sb.append("<null>");
			} else {
				sb.append(photoUrls);
			}

			sb.append("|");

			if (id_t == null) {
				sb.append("<null>");
			} else {
				sb.append(id_t);
			}

			sb.append("|");

			if (name_t == null) {
				sb.append("<null>");
			} else {
				sb.append(name_t);
			}

			sb.append("|");

			if (status == null) {
				sb.append("<null>");
			} else {
				sb.append(status);
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

	public static class row2Struct implements routines.system.IPersistableRow<row2Struct> {
		final static byte[] commonByteArrayLock_SALESFORCE_updateTrestClient = new byte[0];
		static byte[] commonByteArray_SALESFORCE_updateTrestClient = new byte[0];

		public String body;

		public String getBody() {
			return this.body;
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_SALESFORCE_updateTrestClient.length) {
					if (length < 1024 && commonByteArray_SALESFORCE_updateTrestClient.length == 0) {
						commonByteArray_SALESFORCE_updateTrestClient = new byte[1024];
					} else {
						commonByteArray_SALESFORCE_updateTrestClient = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_SALESFORCE_updateTrestClient, 0, length);
				strReturn = new String(commonByteArray_SALESFORCE_updateTrestClient, 0, length, utf8Charset);
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
				if (length > commonByteArray_SALESFORCE_updateTrestClient.length) {
					if (length < 1024 && commonByteArray_SALESFORCE_updateTrestClient.length == 0) {
						commonByteArray_SALESFORCE_updateTrestClient = new byte[1024];
					} else {
						commonByteArray_SALESFORCE_updateTrestClient = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_SALESFORCE_updateTrestClient, 0, length);
				strReturn = new String(commonByteArray_SALESFORCE_updateTrestClient, 0, length, utf8Charset);
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

			synchronized (commonByteArrayLock_SALESFORCE_updateTrestClient) {

				try {

					int length = 0;

					this.body = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_SALESFORCE_updateTrestClient) {

				try {

					int length = 0;

					this.body = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.body, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.body, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("body=" + body);
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
		public int compareTo(row2Struct other) {

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

	public void tFixedFlowInput_2Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tFixedFlowInput_2_SUBPROCESS_STATE", 0);

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

				row2Struct row2 = new row2Struct();
				row6Struct row6 = new row6Struct();
				bodyStruct body = new bodyStruct();
				row1Struct row1 = new row1Struct();

				/**
				 * [tRESTResponse_1 begin ] start
				 */

				ok_Hash.put("tRESTResponse_1", false);
				start_Hash.put("tRESTResponse_1", System.currentTimeMillis());

				currentComponent = "tRESTResponse_1";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "row1");
				}

				int tos_count_tRESTResponse_1 = 0;

				/**
				 * [tRESTResponse_1 begin ] stop
				 */

				/**
				 * [tRESTClient_2 begin ] start
				 */

				ok_Hash.put("tRESTClient_2", false);
				start_Hash.put("tRESTClient_2", System.currentTimeMillis());

				currentComponent = "tRESTClient_2";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "body");
				}

				int tos_count_tRESTClient_2 = 0;

				/**
				 * [tRESTClient_2 begin ] stop
				 */

				/**
				 * [tMap_2 begin ] start
				 */

				ok_Hash.put("tMap_2", false);
				start_Hash.put("tMap_2", System.currentTimeMillis());

				currentComponent = "tMap_2";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "row6");
				}

				int tos_count_tMap_2 = 0;

				if (log.isDebugEnabled())
					log.debug("tMap_2 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tMap_2 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tMap_2 = new StringBuilder();
							log4jParamters_tMap_2.append("Parameters:");
							log4jParamters_tMap_2.append("LINK_STYLE" + " = " + "AUTO");
							log4jParamters_tMap_2.append(" | ");
							log4jParamters_tMap_2.append("TEMPORARY_DATA_DIRECTORY" + " = " + "");
							log4jParamters_tMap_2.append(" | ");
							log4jParamters_tMap_2.append("ROWS_BUFFER_SIZE" + " = " + "2000000");
							log4jParamters_tMap_2.append(" | ");
							log4jParamters_tMap_2.append("CHANGE_HASH_AND_EQUALS_FOR_BIGDECIMAL" + " = " + "true");
							log4jParamters_tMap_2.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tMap_2 - " + (log4jParamters_tMap_2));
						}
					}
					new BytesLimit65535_tMap_2().limitLog4jByte();
				}

// ###############################
// # Lookup's keys initialization
				int count_row6_tMap_2 = 0;

// ###############################        

// ###############################
// # Vars initialization
				class Var__tMap_2__Struct {
					String var1;
				}
				Var__tMap_2__Struct Var__tMap_2 = new Var__tMap_2__Struct();
// ###############################

// ###############################
// # Outputs initialization
				int count_body_tMap_2 = 0;

				bodyStruct body_tmp = new bodyStruct();
// ###############################

				/**
				 * [tMap_2 begin ] stop
				 */

				/**
				 * [tExtractJSONFields_1 begin ] start
				 */

				ok_Hash.put("tExtractJSONFields_1", false);
				start_Hash.put("tExtractJSONFields_1", System.currentTimeMillis());

				currentComponent = "tExtractJSONFields_1";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "row2");
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
							log4jParamters_tExtractJSONFields_1
									.append("MAPPING_4_JSONPATH" + " = " + "[{QUERY=" + ("\"id\"") + ", SCHEMA_COLUMN="
											+ ("id") + "}, {QUERY=" + ("\"name\"") + ", SCHEMA_COLUMN=" + ("name")
											+ "}, {QUERY=" + ("\"category.id\"") + ", SCHEMA_COLUMN=" + ("id_c")
											+ "}, {QUERY=" + ("\"category.name\"") + ", SCHEMA_COLUMN=" + ("name_c")
											+ "}, {QUERY=" + ("\"photoUrls\"") + ", SCHEMA_COLUMN=" + ("photoUrls")
											+ "}, {QUERY=" + ("\"tags.id\"") + ", SCHEMA_COLUMN=" + ("id_t")
											+ "}, {QUERY=" + ("\"tags.name\"") + ", SCHEMA_COLUMN=" + ("name_t")
											+ "}, {QUERY=" + ("\"status\"") + ", SCHEMA_COLUMN=" + ("status") + "}]");
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
				 * [tFixedFlowInput_2 begin ] start
				 */

				ok_Hash.put("tFixedFlowInput_2", false);
				start_Hash.put("tFixedFlowInput_2", System.currentTimeMillis());

				currentComponent = "tFixedFlowInput_2";

				int tos_count_tFixedFlowInput_2 = 0;

				for (int i_tFixedFlowInput_2 = 0; i_tFixedFlowInput_2 < 1; i_tFixedFlowInput_2++) {

					row2.body = (String) globalMap.get("body");

					/**
					 * [tFixedFlowInput_2 begin ] stop
					 */

					/**
					 * [tFixedFlowInput_2 main ] start
					 */

					currentComponent = "tFixedFlowInput_2";

					tos_count_tFixedFlowInput_2++;

					/**
					 * [tFixedFlowInput_2 main ] stop
					 */

					/**
					 * [tFixedFlowInput_2 process_data_begin ] start
					 */

					currentComponent = "tFixedFlowInput_2";

					/**
					 * [tFixedFlowInput_2 process_data_begin ] stop
					 */

					/**
					 * [tExtractJSONFields_1 main ] start
					 */

					currentComponent = "tExtractJSONFields_1";

					if (execStat) {
						runStat.updateStatOnConnection(iterateId, 1, 1

								, "row2"

						);
					}

					if (log.isTraceEnabled()) {
						log.trace("row2 - " + (row2 == null ? "" : row2.toLogString()));
					}

					if (row2.body != null) {// C_01
						jsonStr_tExtractJSONFields_1 = row2.body.toString();

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
									jsonPath_tExtractJSONFields_1 = "id";
									compiledJsonPath_tExtractJSONFields_1 = jsonPathCache_tExtractJSONFields_1
											.getCompiledJsonPath(jsonPath_tExtractJSONFields_1);

									try {

										value_tExtractJSONFields_1 = compiledJsonPath_tExtractJSONFields_1
												.read(row_tExtractJSONFields_1);

										if (value_tExtractJSONFields_1 != null
												&& !value_tExtractJSONFields_1.toString().isEmpty()) {
											row6.id = ParserUtils
													.parseTo_Integer(value_tExtractJSONFields_1.toString());
										} else {
											row6.id =

													null

											;
										}
									} catch (com.jayway.jsonpath.PathNotFoundException e_tExtractJSONFields_1) {
										globalMap.put("tExtractJSONFields_1_ERROR_MESSAGE",
												e_tExtractJSONFields_1.getMessage());
										row6.id =

												null

										;
									}
									jsonPath_tExtractJSONFields_1 = "name";
									compiledJsonPath_tExtractJSONFields_1 = jsonPathCache_tExtractJSONFields_1
											.getCompiledJsonPath(jsonPath_tExtractJSONFields_1);

									try {

										value_tExtractJSONFields_1 = compiledJsonPath_tExtractJSONFields_1
												.read(row_tExtractJSONFields_1);

										row6.name = value_tExtractJSONFields_1 == null ?

												null

												: value_tExtractJSONFields_1.toString();
									} catch (com.jayway.jsonpath.PathNotFoundException e_tExtractJSONFields_1) {
										globalMap.put("tExtractJSONFields_1_ERROR_MESSAGE",
												e_tExtractJSONFields_1.getMessage());
										row6.name =

												null

										;
									}
									jsonPath_tExtractJSONFields_1 = "category.id";
									compiledJsonPath_tExtractJSONFields_1 = jsonPathCache_tExtractJSONFields_1
											.getCompiledJsonPath(jsonPath_tExtractJSONFields_1);

									try {

										value_tExtractJSONFields_1 = compiledJsonPath_tExtractJSONFields_1
												.read(row_tExtractJSONFields_1);

										if (value_tExtractJSONFields_1 != null
												&& !value_tExtractJSONFields_1.toString().isEmpty()) {
											row6.id_c = ParserUtils
													.parseTo_Integer(value_tExtractJSONFields_1.toString());
										} else {
											row6.id_c =

													null

											;
										}
									} catch (com.jayway.jsonpath.PathNotFoundException e_tExtractJSONFields_1) {
										globalMap.put("tExtractJSONFields_1_ERROR_MESSAGE",
												e_tExtractJSONFields_1.getMessage());
										row6.id_c =

												null

										;
									}
									jsonPath_tExtractJSONFields_1 = "category.name";
									compiledJsonPath_tExtractJSONFields_1 = jsonPathCache_tExtractJSONFields_1
											.getCompiledJsonPath(jsonPath_tExtractJSONFields_1);

									try {

										value_tExtractJSONFields_1 = compiledJsonPath_tExtractJSONFields_1
												.read(row_tExtractJSONFields_1);

										row6.name_c = value_tExtractJSONFields_1 == null ?

												null

												: value_tExtractJSONFields_1.toString();
									} catch (com.jayway.jsonpath.PathNotFoundException e_tExtractJSONFields_1) {
										globalMap.put("tExtractJSONFields_1_ERROR_MESSAGE",
												e_tExtractJSONFields_1.getMessage());
										row6.name_c =

												null

										;
									}
									jsonPath_tExtractJSONFields_1 = "photoUrls";
									compiledJsonPath_tExtractJSONFields_1 = jsonPathCache_tExtractJSONFields_1
											.getCompiledJsonPath(jsonPath_tExtractJSONFields_1);

									try {

										value_tExtractJSONFields_1 = compiledJsonPath_tExtractJSONFields_1
												.read(row_tExtractJSONFields_1);

										row6.photoUrls = value_tExtractJSONFields_1 == null ?

												null

												: value_tExtractJSONFields_1.toString();
									} catch (com.jayway.jsonpath.PathNotFoundException e_tExtractJSONFields_1) {
										globalMap.put("tExtractJSONFields_1_ERROR_MESSAGE",
												e_tExtractJSONFields_1.getMessage());
										row6.photoUrls =

												null

										;
									}
									jsonPath_tExtractJSONFields_1 = "tags.id";
									compiledJsonPath_tExtractJSONFields_1 = jsonPathCache_tExtractJSONFields_1
											.getCompiledJsonPath(jsonPath_tExtractJSONFields_1);

									try {

										value_tExtractJSONFields_1 = compiledJsonPath_tExtractJSONFields_1
												.read(row_tExtractJSONFields_1);

										if (value_tExtractJSONFields_1 != null
												&& !value_tExtractJSONFields_1.toString().isEmpty()) {
											row6.id_t = ParserUtils
													.parseTo_Integer(value_tExtractJSONFields_1.toString());
										} else {
											row6.id_t =

													null

											;
										}
									} catch (com.jayway.jsonpath.PathNotFoundException e_tExtractJSONFields_1) {
										globalMap.put("tExtractJSONFields_1_ERROR_MESSAGE",
												e_tExtractJSONFields_1.getMessage());
										row6.id_t =

												null

										;
									}
									jsonPath_tExtractJSONFields_1 = "tags.name";
									compiledJsonPath_tExtractJSONFields_1 = jsonPathCache_tExtractJSONFields_1
											.getCompiledJsonPath(jsonPath_tExtractJSONFields_1);

									try {

										value_tExtractJSONFields_1 = compiledJsonPath_tExtractJSONFields_1
												.read(row_tExtractJSONFields_1);

										row6.name_t = value_tExtractJSONFields_1 == null ?

												null

												: value_tExtractJSONFields_1.toString();
									} catch (com.jayway.jsonpath.PathNotFoundException e_tExtractJSONFields_1) {
										globalMap.put("tExtractJSONFields_1_ERROR_MESSAGE",
												e_tExtractJSONFields_1.getMessage());
										row6.name_t =

												null

										;
									}
									jsonPath_tExtractJSONFields_1 = "status";
									compiledJsonPath_tExtractJSONFields_1 = jsonPathCache_tExtractJSONFields_1
											.getCompiledJsonPath(jsonPath_tExtractJSONFields_1);

									try {

										value_tExtractJSONFields_1 = compiledJsonPath_tExtractJSONFields_1
												.read(row_tExtractJSONFields_1);

										row6.status = value_tExtractJSONFields_1 == null ?

												null

												: value_tExtractJSONFields_1.toString();
									} catch (com.jayway.jsonpath.PathNotFoundException e_tExtractJSONFields_1) {
										globalMap.put("tExtractJSONFields_1_ERROR_MESSAGE",
												e_tExtractJSONFields_1.getMessage());
										row6.status =

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
								 * [tMap_2 main ] start
								 */

								currentComponent = "tMap_2";

								if (execStat) {
									runStat.updateStatOnConnection(iterateId, 1, 1

											, "row6"

									);
								}

								if (log.isTraceEnabled()) {
									log.trace("row6 - " + (row6 == null ? "" : row6.toLogString()));
								}

								boolean hasCasePrimitiveKeyWithNull_tMap_2 = false;

								// ###############################
								// # Input tables (lookups)
								boolean rejectedInnerJoin_tMap_2 = false;
								boolean mainRowRejected_tMap_2 = false;

								// ###############################
								{ // start of Var scope

									// ###############################
									// # Vars tables

									Var__tMap_2__Struct Var = Var__tMap_2;
									Var.var1 = "{" + "\n\t\t\t\"id\":" + row6.id + "," + "\n\t\t\t\"name\":\""
											+ row6.name + "\"," + "\n\t\t\t\"category\":" + "{" + "\n\t\t\t\t\"id\":"
											+ row6.id_c + "," + "\n\t\t\t\t\"name\":\"" + row6.name_c + "\""
											+ "\n\t\t\t}," + "\n\t\t\t\"photoUrls\":" + row6.photoUrls + ","
											+ "\n\t\t\t\"tags\":" + "[" + "\n\t\t\t\t{" + "\n\t\t\t\t\"id\":"
											+ row6.id_t + "," + "\n\t\t\t\t\"name\":\"" + row6.name_t + "\""
											+ "\n\t\t\t\t}" + "\n\t\t\t]," + "\n\t\t\t\"status\":\"" + row6.status
											+ "\"" + "\n\t\t}";// ###############################
									// ###############################
									// # Output tables

									body = null;

// # Output table : 'body'
									count_body_tMap_2++;

									body_tmp.string = Var.var1;
									body = body_tmp;
									log.debug("tMap_2 - Outputting the record " + count_body_tMap_2
											+ " of the output table 'body'.");

// ###############################

								} // end of Var scope

								rejectedInnerJoin_tMap_2 = false;

								tos_count_tMap_2++;

								/**
								 * [tMap_2 main ] stop
								 */

								/**
								 * [tMap_2 process_data_begin ] start
								 */

								currentComponent = "tMap_2";

								/**
								 * [tMap_2 process_data_begin ] stop
								 */
// Start of branch "body"
								if (body != null) {

									/**
									 * [tRESTClient_2 main ] start
									 */

									currentComponent = "tRESTClient_2";

									if (execStat) {
										runStat.updateStatOnConnection(iterateId, 1, 1

												, "body"

										);
									}

									if (log.isTraceEnabled()) {
										log.trace("body - " + (body == null ? "" : body.toLogString()));
									}

									row1 = null;

// expected response body
									javax.ws.rs.core.Response responseDoc_tRESTClient_2 = null;

									try {
										// request body
										org.dom4j.Document requestDoc_tRESTClient_2 = null;
										String requestString_tRESTClient_2 = null;
										requestString_tRESTClient_2 = body.string;

										Object requestBody_tRESTClient_2 = requestDoc_tRESTClient_2 != null
												? requestDoc_tRESTClient_2
												: requestString_tRESTClient_2;

										// resposne class name
										Class<?> responseClass_tRESTClient_2 = String.class;

										// create web client instance
										org.apache.cxf.jaxrs.client.JAXRSClientFactoryBean factoryBean_tRESTClient_2 = new org.apache.cxf.jaxrs.client.JAXRSClientFactoryBean();

										boolean inOSGi = routines.system.BundleUtils.inOSGi();

										final java.util.List<org.apache.cxf.feature.Feature> features_tRESTClient_2 = new java.util.ArrayList<org.apache.cxf.feature.Feature>();

										String url = "https://petstore3.swagger.io/api/v3/pet";
										// {baseUri}tRESTClient
										factoryBean_tRESTClient_2
												.setServiceName(new javax.xml.namespace.QName(url, "tRESTClient"));
										factoryBean_tRESTClient_2.setAddress(url);

										factoryBean_tRESTClient_2.setFeatures(features_tRESTClient_2);

										java.util.List<Object> providers_tRESTClient_2 = new java.util.ArrayList<Object>();
										providers_tRESTClient_2
												.add(new org.apache.cxf.jaxrs.provider.dom4j.DOM4JProvider() {
													// workaround for https://jira.talendforge.org/browse/TESB-7276
													public org.dom4j.Document readFrom(Class<org.dom4j.Document> cls,
															java.lang.reflect.Type type,
															java.lang.annotation.Annotation[] anns,
															javax.ws.rs.core.MediaType mt,
															javax.ws.rs.core.MultivaluedMap<String, String> headers,
															java.io.InputStream is)
															throws IOException, javax.ws.rs.WebApplicationException {
														String contentLength = headers.getFirst("Content-Length");
														if (!org.apache.cxf.common.util.StringUtils
																.isEmpty(contentLength)
																&& Integer.valueOf(contentLength) <= 0) {
															try {
																return org.dom4j.DocumentHelper.parseText("<root/>");
															} catch (org.dom4j.DocumentException e_tRESTClient_2) {
																e_tRESTClient_2.printStackTrace();
															}
															return null;
														}
														return super.readFrom(cls, type, anns, mt, headers, is);
													}
												});
										org.apache.cxf.jaxrs.provider.json.JSONProvider jsonProvider_tRESTClient_2 = new org.apache.cxf.jaxrs.provider.json.JSONProvider();
										jsonProvider_tRESTClient_2.setIgnoreNamespaces(true);
										jsonProvider_tRESTClient_2.setAttributesToElements(true);

										jsonProvider_tRESTClient_2.setSerializeAsArray(true);
										List<String> arrayKeys = new java.util.ArrayList<String>(
												java.util.Arrays.asList("".split(" ")));
										jsonProvider_tRESTClient_2.setArrayKeys(arrayKeys);

										jsonProvider_tRESTClient_2.setSupportUnwrapped(true);
										jsonProvider_tRESTClient_2.setWrapperName("root");

										jsonProvider_tRESTClient_2.setDropRootElement(false);
										jsonProvider_tRESTClient_2.setConvertTypesToStrings(false);
										providers_tRESTClient_2.add(jsonProvider_tRESTClient_2);
										factoryBean_tRESTClient_2.setProviders(providers_tRESTClient_2);
										factoryBean_tRESTClient_2
												.setTransportId("http://cxf.apache.org/transports/http");

										boolean use_auth_tRESTClient_2 = false;

										org.apache.cxf.jaxrs.client.WebClient webClient_tRESTClient_2 = factoryBean_tRESTClient_2
												.createWebClient();

										// set request path
										webClient_tRESTClient_2.path("");

										// set connection properties
										org.apache.cxf.jaxrs.client.ClientConfiguration clientConfig_tRESTClient_2 = org.apache.cxf.jaxrs.client.WebClient
												.getConfig(webClient_tRESTClient_2);
										org.apache.cxf.transport.http.auth.HttpAuthSupplier httpAuthSupplerHttpConduit = null;
										org.apache.cxf.transport.http.HTTPConduit conduit_tRESTClient_2 = clientConfig_tRESTClient_2
												.getHttpConduit();

										if (clientConfig_tRESTClient_2.getEndpoint() != null) {
											org.apache.cxf.service.model.EndpointInfo endpointInfo_tRESTClient_2 = clientConfig_tRESTClient_2
													.getEndpoint().getEndpointInfo();
											if (endpointInfo_tRESTClient_2 != null) {
												endpointInfo_tRESTClient_2
														.setProperty("enable.webclient.operation.reporting", true);
											}
										}

										if (!inOSGi) {
											conduit_tRESTClient_2.getClient().setReceiveTimeout((long) (60 * 1000L));
											conduit_tRESTClient_2.getClient().setConnectionTimeout((long) (30 * 1000L));
											boolean use_proxy_tRESTClient_2 = false;

										}

										// set Content-Type
										webClient_tRESTClient_2.type("application/json");

										// set Accept-Type
										webClient_tRESTClient_2.accept("*/*");

										// set optional query and header properties if any

										if (use_auth_tRESTClient_2 && "OAUTH2_BEARER".equals("OAUTH2_BEARER")) {
											// set oAuth2 bearer token
											org.apache.cxf.rs.security.oauth2.client.BearerAuthSupplier authSupplier = new org.apache.cxf.rs.security.oauth2.client.BearerAuthSupplier();
											authSupplier.setAccessToken(
													"00Dd20000018x0j!AQEAQFMFk5hyrAJPhE1IGUQqzZhX7OKdofoQMJwAwgUkdAeveXM4tX9QfXnKmvWFhgXIPgiXyVBJNeSXa7KES6tbTYMRprl1");
											conduit_tRESTClient_2.setAuthSupplier(authSupplier);
										}

										// if FORM request then capture query parameters into Form, otherwise set them
										// as queries

										try {
											// start send request

											responseDoc_tRESTClient_2 = webClient_tRESTClient_2
													.put(requestBody_tRESTClient_2);

											int webClientResponseStatus_tRESTClient_2 = webClient_tRESTClient_2
													.getResponse().getStatus();
											if (webClientResponseStatus_tRESTClient_2 >= 300) {
												throw new javax.ws.rs.WebApplicationException(
														webClient_tRESTClient_2.getResponse());
											}

											if (row1 == null) {
												row1 = new row1Struct();
											}

											row1.statusCode = webClientResponseStatus_tRESTClient_2;
											row1.string = "";

											Object responseObj_tRESTClient_2 = null;
											if (responseDoc_tRESTClient_2 != null
													&& responseDoc_tRESTClient_2.hasEntity()) {
												responseObj_tRESTClient_2 = responseDoc_tRESTClient_2
														.readEntity(responseClass_tRESTClient_2);

												if (responseObj_tRESTClient_2 != null) {
													if (responseClass_tRESTClient_2 == String.class
															&& responseObj_tRESTClient_2 instanceof String) {
														row1.string = (String) responseObj_tRESTClient_2;
													} else {
														routines.system.Document responseTalendDoc_tRESTClient_2 = null;
														if (null != responseObj_tRESTClient_2) {
															responseTalendDoc_tRESTClient_2 = new routines.system.Document();
															if (responseObj_tRESTClient_2 instanceof org.dom4j.Document) {
																responseTalendDoc_tRESTClient_2.setDocument(
																		(org.dom4j.Document) responseObj_tRESTClient_2);
															}
														}
														row1.body = responseTalendDoc_tRESTClient_2;
													}
												}
											}

											globalMap.put("tRESTClient_2_HEADERS",
													webClient_tRESTClient_2.getResponse().getHeaders());
											globalMap.put("tRESTClient_2_COOKIES",
													webClient_tRESTClient_2.getResponse().getCookies());

										} catch (javax.ws.rs.WebApplicationException ex_tRESTClient_2) {
											globalMap.put("tRESTClient_2_ERROR_MESSAGE", ex_tRESTClient_2.getMessage());

											throw ex_tRESTClient_2;

										}

									} catch (Exception e_tRESTClient_2) {
										globalMap.put("tRESTClient_2_ERROR_MESSAGE", e_tRESTClient_2.getMessage());

										throw new TalendException(e_tRESTClient_2, currentComponent, globalMap);

									}

									tos_count_tRESTClient_2++;

									/**
									 * [tRESTClient_2 main ] stop
									 */

									/**
									 * [tRESTClient_2 process_data_begin ] start
									 */

									currentComponent = "tRESTClient_2";

									/**
									 * [tRESTClient_2 process_data_begin ] stop
									 */
// Start of branch "row1"
									if (row1 != null) {

										/**
										 * [tRESTResponse_1 main ] start
										 */

										currentComponent = "tRESTResponse_1";

										if (execStat) {
											runStat.updateStatOnConnection(iterateId, 1, 1

													, "row1"

											);
										}

										if (log.isTraceEnabled()) {
											log.trace("row1 - " + (row1 == null ? "" : row1.toLogString()));
										}

										java.io.OutputStream outputStream_tRESTResponse_1 = (java.io.OutputStream) globalMap
												.get("restResponseStream");
										boolean responseAlreadySent_tRESTResponse_1 = globalMap
												.containsKey("restResponse");

										if (null == outputStream_tRESTResponse_1
												&& responseAlreadySent_tRESTResponse_1) {
											throw new RuntimeException("Rest response already sent.");
										} else if (!globalMap.containsKey("restRequest")) {
											throw new RuntimeException("Not received rest request yet.");
										} else {
											Integer restProviderStatusCode_tRESTResponse_1 = 200;

											Object restProviderResponse_tRESTResponse_1 = null;
											restProviderResponse_tRESTResponse_1 = row1.string;
											if (null != row1.body) {
												restProviderResponse_tRESTResponse_1 = row1.body.getDocument();
											}

											java.util.Map<String, String> restProviderResponseHeaders_tRESTResponse_1 = new java.util.TreeMap<String, String>(
													String.CASE_INSENSITIVE_ORDER);
											java.lang.StringBuilder restProviderResponseHeader_cookies_tRESTResponse_1 = new java.lang.StringBuilder();
											final String setCookieHeader = "Set-Cookie";

											if (restProviderResponseHeader_cookies_tRESTResponse_1.length() > 0) {
												restProviderResponseHeaders_tRESTResponse_1.put(setCookieHeader,
														restProviderResponseHeader_cookies_tRESTResponse_1.toString());
											}

											java.util.Map<String, Object> restRequest_tRESTResponse_1 = (java.util.Map<String, Object>) globalMap
													.get("restRequest");
											org.apache.cxf.jaxrs.ext.MessageContext messageContext_tRESTResponse_1 = (org.apache.cxf.jaxrs.ext.MessageContext) restRequest_tRESTResponse_1
													.get("MESSAGE_CONTEXT");

											if (null == outputStream_tRESTResponse_1) {
												java.util.Map<String, Object> restResponse_tRESTResponse_1 = new java.util.HashMap<String, Object>();
												restResponse_tRESTResponse_1.put("BODY",
														restProviderResponse_tRESTResponse_1);
												restResponse_tRESTResponse_1.put("STATUS",
														restProviderStatusCode_tRESTResponse_1);
												restResponse_tRESTResponse_1.put("HEADERS",
														restProviderResponseHeaders_tRESTResponse_1);
												restResponse_tRESTResponse_1.put("drop.json.root.element",
														Boolean.valueOf(false));
												globalMap.put("restResponse", restResponse_tRESTResponse_1);

											} else {

												javax.ws.rs.core.MediaType responseMediaType_tRESTResponse_1 = null;
												if (!responseAlreadySent_tRESTResponse_1) {
													org.apache.cxf.message.Message currentMessage = null;
													if (org.apache.cxf.jaxrs.utils.JAXRSUtils
															.getCurrentMessage() != null) {
														currentMessage = org.apache.cxf.jaxrs.utils.JAXRSUtils
																.getCurrentMessage();
													} else {
														currentMessage = ((org.apache.cxf.message.Message) restRequest_tRESTResponse_1
																.get("CURRENT_MESSAGE"));
													}

													if (currentMessage != null
															&& currentMessage.getExchange() != null) {
														currentMessage.getExchange().put(
																StreamingDOM4JProvider.SUPRESS_XML_DECLARATION, true);
													}

													messageContext_tRESTResponse_1.put(
															org.apache.cxf.message.Message.RESPONSE_CODE,
															restProviderStatusCode_tRESTResponse_1);
													javax.ws.rs.core.MultivaluedMap<String, String> headersMultivaluedMap_tRESTResponse_1 = new org.apache.cxf.jaxrs.impl.MetadataMap<String, String>();
													for (java.util.Map.Entry<String, String> multivaluedHeader : restProviderResponseHeaders_tRESTResponse_1
															.entrySet()) {
														headersMultivaluedMap_tRESTResponse_1.putSingle(
																multivaluedHeader.getKey(),
																multivaluedHeader.getValue());
													}
													messageContext_tRESTResponse_1.put(
															org.apache.cxf.message.Message.PROTOCOL_HEADERS,
															headersMultivaluedMap_tRESTResponse_1);

													String responseContentType_tRESTResponse_1 = null;

													if (currentMessage != null
															&& currentMessage.getExchange() != null) {
														responseContentType_tRESTResponse_1 = (String) currentMessage
																.getExchange()
																.get(org.apache.cxf.message.Message.CONTENT_TYPE);
													}

													if (null == responseContentType_tRESTResponse_1) {
														// this should not be needed, just in case. set it to the first
														// value in the sorted list returned from HttpHeaders
														responseMediaType_tRESTResponse_1 = messageContext_tRESTResponse_1
																.getHttpHeaders().getAcceptableMediaTypes().get(0);
													} else {
														responseMediaType_tRESTResponse_1 = org.apache.cxf.jaxrs.utils.JAXRSUtils
																.toMediaType(responseContentType_tRESTResponse_1);
													}
													globalMap.put("restResponseMediaType",
															responseMediaType_tRESTResponse_1);

													String responseMediaSubType_tRESTResponse_1 = responseMediaType_tRESTResponse_1
															.getSubtype();
													if (responseMediaSubType_tRESTResponse_1.equals("xml")
															|| responseMediaSubType_tRESTResponse_1.endsWith("+xml")) {
														outputStream_tRESTResponse_1.write("<wrapper>".getBytes());
														globalMap.put("restResponseWrappingClosure", "</wrapper>");
													}
													if (responseMediaSubType_tRESTResponse_1.equals("json")
															|| responseMediaSubType_tRESTResponse_1.endsWith("+json")) {
														outputStream_tRESTResponse_1.write("[".getBytes());
														globalMap.put("restResponseWrappingClosure", "]");
													}

													globalMap.put("restResponse", true);
												} else {
													responseMediaType_tRESTResponse_1 = (javax.ws.rs.core.MediaType) globalMap
															.get("restResponseMediaType");
												}

												if (null != restProviderResponse_tRESTResponse_1) {
													String responseMediaSubType_tRESTResponse_1 = responseMediaType_tRESTResponse_1
															.getSubtype();
													if (responseMediaSubType_tRESTResponse_1.equals("json")
															|| responseMediaSubType_tRESTResponse_1.endsWith("+json")) {
														if (globalMap.containsKey("restResponseJsonStarted")) {
															outputStream_tRESTResponse_1.write(",".getBytes());
														} else {
															globalMap.put("restResponseJsonStarted", true);
														}
													}

													Class<? extends Object> responseBodyClass_tRESTResponse_1 = restProviderResponse_tRESTResponse_1
															.getClass();
													javax.ws.rs.ext.Providers messageBodyProviders_tRESTResponse_1 = messageContext_tRESTResponse_1
															.getProviders();
													javax.ws.rs.ext.MessageBodyWriter messageBodyWriter_tRESTResponse_1 = messageBodyProviders_tRESTResponse_1
															.getMessageBodyWriter(responseBodyClass_tRESTResponse_1,
																	responseBodyClass_tRESTResponse_1, null,
																	responseMediaType_tRESTResponse_1);

													if (messageBodyWriter_tRESTResponse_1 instanceof StreamingDOM4JProvider) {
														((StreamingDOM4JProvider) messageBodyWriter_tRESTResponse_1)
																.setGlobalMap(globalMap);
													}

													messageBodyWriter_tRESTResponse_1.writeTo(
															restProviderResponse_tRESTResponse_1,
															responseBodyClass_tRESTResponse_1,
															responseBodyClass_tRESTResponse_1,
															new java.lang.annotation.Annotation[] {},
															responseMediaType_tRESTResponse_1, null,
															outputStream_tRESTResponse_1);
												}
												// initial variant
												// outputStream_tRESTResponse_1.write(String.valueOf(restProviderResponse_tRESTResponse_1).getBytes());
												outputStream_tRESTResponse_1.flush();
											}
										}

										tos_count_tRESTResponse_1++;

										/**
										 * [tRESTResponse_1 main ] stop
										 */

										/**
										 * [tRESTResponse_1 process_data_begin ] start
										 */

										currentComponent = "tRESTResponse_1";

										/**
										 * [tRESTResponse_1 process_data_begin ] stop
										 */

										/**
										 * [tRESTResponse_1 process_data_end ] start
										 */

										currentComponent = "tRESTResponse_1";

										/**
										 * [tRESTResponse_1 process_data_end ] stop
										 */

									} // End of branch "row1"

									/**
									 * [tRESTClient_2 process_data_end ] start
									 */

									currentComponent = "tRESTClient_2";

									/**
									 * [tRESTClient_2 process_data_end ] stop
									 */

								} // End of branch "body"

								/**
								 * [tMap_2 process_data_end ] start
								 */

								currentComponent = "tMap_2";

								/**
								 * [tMap_2 process_data_end ] stop
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
					 * [tFixedFlowInput_2 process_data_end ] start
					 */

					currentComponent = "tFixedFlowInput_2";

					/**
					 * [tFixedFlowInput_2 process_data_end ] stop
					 */

					/**
					 * [tFixedFlowInput_2 end ] start
					 */

					currentComponent = "tFixedFlowInput_2";

				}
				globalMap.put("tFixedFlowInput_2_NB_LINE", 1);

				ok_Hash.put("tFixedFlowInput_2", true);
				end_Hash.put("tFixedFlowInput_2", System.currentTimeMillis());

				/**
				 * [tFixedFlowInput_2 end ] stop
				 */

				/**
				 * [tExtractJSONFields_1 end ] start
				 */

				currentComponent = "tExtractJSONFields_1";

				globalMap.put("tExtractJSONFields_1_NB_LINE", nb_line_tExtractJSONFields_1);
				log.debug("tExtractJSONFields_1 - Extracted records count: " + nb_line_tExtractJSONFields_1 + " .");

				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "row2");
				}

				if (log.isDebugEnabled())
					log.debug("tExtractJSONFields_1 - " + ("Done."));

				ok_Hash.put("tExtractJSONFields_1", true);
				end_Hash.put("tExtractJSONFields_1", System.currentTimeMillis());

				/**
				 * [tExtractJSONFields_1 end ] stop
				 */

				/**
				 * [tMap_2 end ] start
				 */

				currentComponent = "tMap_2";

// ###############################
// # Lookup hashes releasing
// ###############################      
				log.debug("tMap_2 - Written records count in the table 'body': " + count_body_tMap_2 + ".");

				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "row6");
				}

				if (log.isDebugEnabled())
					log.debug("tMap_2 - " + ("Done."));

				ok_Hash.put("tMap_2", true);
				end_Hash.put("tMap_2", System.currentTimeMillis());

				/**
				 * [tMap_2 end ] stop
				 */

				/**
				 * [tRESTClient_2 end ] start
				 */

				currentComponent = "tRESTClient_2";

				if (globalMap.get("tRESTClient_2_NB_LINE") == null) {
					globalMap.put("tRESTClient_2_NB_LINE", 1);
				}

// [tRESTCliend_end]
				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "body");
				}

				ok_Hash.put("tRESTClient_2", true);
				end_Hash.put("tRESTClient_2", System.currentTimeMillis());

				/**
				 * [tRESTClient_2 end ] stop
				 */

				/**
				 * [tRESTResponse_1 end ] start
				 */

				currentComponent = "tRESTResponse_1";

				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "row1");
				}

				ok_Hash.put("tRESTResponse_1", true);
				end_Hash.put("tRESTResponse_1", System.currentTimeMillis());

				/**
				 * [tRESTResponse_1 end ] stop
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
				 * [tFixedFlowInput_2 finally ] start
				 */

				currentComponent = "tFixedFlowInput_2";

				/**
				 * [tFixedFlowInput_2 finally ] stop
				 */

				/**
				 * [tExtractJSONFields_1 finally ] start
				 */

				currentComponent = "tExtractJSONFields_1";

				/**
				 * [tExtractJSONFields_1 finally ] stop
				 */

				/**
				 * [tMap_2 finally ] start
				 */

				currentComponent = "tMap_2";

				/**
				 * [tMap_2 finally ] stop
				 */

				/**
				 * [tRESTClient_2 finally ] start
				 */

				currentComponent = "tRESTClient_2";

				/**
				 * [tRESTClient_2 finally ] stop
				 */

				/**
				 * [tRESTResponse_1 finally ] start
				 */

				currentComponent = "tRESTResponse_1";

				/**
				 * [tRESTResponse_1 finally ] stop
				 */

			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tFixedFlowInput_2_SUBPROCESS_STATE", 1);
	}

	public static class headerStruct implements routines.system.IPersistableRow<headerStruct> {
		final static byte[] commonByteArrayLock_SALESFORCE_updateTrestClient = new byte[0];
		static byte[] commonByteArray_SALESFORCE_updateTrestClient = new byte[0];

		public String Authorization;

		public String getAuthorization() {
			return this.Authorization;
		}

		public String correlationId;

		public String getCorrelationId() {
			return this.correlationId;
		}

		public String body;

		public String getBody() {
			return this.body;
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_SALESFORCE_updateTrestClient.length) {
					if (length < 1024 && commonByteArray_SALESFORCE_updateTrestClient.length == 0) {
						commonByteArray_SALESFORCE_updateTrestClient = new byte[1024];
					} else {
						commonByteArray_SALESFORCE_updateTrestClient = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_SALESFORCE_updateTrestClient, 0, length);
				strReturn = new String(commonByteArray_SALESFORCE_updateTrestClient, 0, length, utf8Charset);
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
				if (length > commonByteArray_SALESFORCE_updateTrestClient.length) {
					if (length < 1024 && commonByteArray_SALESFORCE_updateTrestClient.length == 0) {
						commonByteArray_SALESFORCE_updateTrestClient = new byte[1024];
					} else {
						commonByteArray_SALESFORCE_updateTrestClient = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_SALESFORCE_updateTrestClient, 0, length);
				strReturn = new String(commonByteArray_SALESFORCE_updateTrestClient, 0, length, utf8Charset);
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

			synchronized (commonByteArrayLock_SALESFORCE_updateTrestClient) {

				try {

					int length = 0;

					this.Authorization = readString(dis);

					this.correlationId = readString(dis);

					this.body = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_SALESFORCE_updateTrestClient) {

				try {

					int length = 0;

					this.Authorization = readString(dis);

					this.correlationId = readString(dis);

					this.body = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.Authorization, dos);

				// String

				writeString(this.correlationId, dos);

				// String

				writeString(this.body, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.Authorization, dos);

				// String

				writeString(this.correlationId, dos);

				// String

				writeString(this.body, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("Authorization=" + Authorization);
			sb.append(",correlationId=" + correlationId);
			sb.append(",body=" + body);
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

			if (correlationId == null) {
				sb.append("<null>");
			} else {
				sb.append(correlationId);
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
										+ ("((TokenException)globalMap.get(\"tokenException\")).validateToken(header.Authorization)")
										+ ", KEY=" + ("\"is_valid_token\"") + "}, {VALUE=" + ("0") + ", KEY="
										+ ("\"i_stepSequence\"") + "}, {VALUE="
										+ ("TokenException.isBlank(header.correlationId) ? StringHandling.SUBSTR((java.util.UUID.randomUUID()).toString(), 10, 14) : header.correlationId")
										+ ", KEY=" + ("\"s_correlationId\"") + "}, {VALUE=" + ("header.body") + ", KEY="
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
							if (params_tRESTRequest_1.containsKey("PATH:correlationId:id_String")) {

								header.correlationId = (String) params_tRESTRequest_1
										.get("PATH:correlationId:id_String");

							}
							Object bodyObject_tRESTRequest_1 = requestMessage_tRESTRequest_1.get("BODY");
							if (null != bodyObject_tRESTRequest_1) {

								header.body = (String) bodyObject_tRESTRequest_1;

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

						globalMap.put("is_valid_token",
								((TokenException) globalMap.get("tokenException")).validateToken(header.Authorization));
						globalMap.put("i_stepSequence", 0);
						globalMap.put("s_correlationId",
								TokenException.isBlank(header.correlationId)
										? StringHandling.SUBSTR((java.util.UUID.randomUUID()).toString(), 10, 14)
										: header.correlationId);
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
							runStat.updateStatOnConnection("If2", 0, "true");
						}
						tFixedFlowInput_2Process(globalMap);
					}

					else {
						if (execStat) {
							runStat.updateStatOnConnection("If2", 0, "false");
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
		final updateTrestClient updateTrestClientClass = new updateTrestClient();

		int exitCode = updateTrestClientClass.runJobInTOS(args);
		if (exitCode == 0) {
			log.info("TalendJob: 'updateTrestClient' - Done.");
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
		log.info("TalendJob: 'updateTrestClient' - Start.");

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
			java.io.InputStream inContext = updateTrestClient.class.getClassLoader()
					.getResourceAsStream("salesforce/updatetrestclient_0_1/contexts/" + contextStr + ".properties");
			if (inContext == null) {
				inContext = updateTrestClient.class.getClassLoader()
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
					context.setContextType("csv_path", "id_String");
					if (context.getStringValue("csv_path") == null) {
						context.csv_path = null;
					} else {
						context.csv_path = (String) context.getProperty("csv_path");
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
			if (parentContextMap.containsKey("csv_path")) {
				context.csv_path = (String) parentContextMap.get("csv_path");
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
					(endUsedMemory - startUsedMemory) + " bytes memory increase when running : updateTrestClient");
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

	}

	private java.util.Map<String, Object> getSharedConnections4REST() {
		java.util.Map<String, Object> connections = new java.util.HashMap<String, Object>();

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
 * 228781 characters generated by Talend Open Studio for ESB on the 16 août 2024
 * à 9:55:32 AM CET
 ************************************************************************************************/