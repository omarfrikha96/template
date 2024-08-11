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

package salesforce.copy_of_getallrequest_d_0_1;

import routines.Numeric;
import routines.DataOperation;
import routines.TalendDataGenerator;
import routines.TalendStringUtil;
import routines.TalendString;
import routines.StringHandling;
import routines.TalendDate;
import routines.Relational;
import routines.JacquemusUtils;
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
 * Job: Copy_of_GetAllRequest_d Purpose: <br>
 * Description: <br>
 * 
 * @author user@talend.com
 * @version 8.0.1.20211109_1610
 * @status
 */
public class Copy_of_GetAllRequest_d implements TalendJob {
	static {
		System.setProperty("TalendJob.log", "Copy_of_GetAllRequest_d.log");
	}

	private static org.apache.logging.log4j.Logger log = org.apache.logging.log4j.LogManager
			.getLogger(Copy_of_GetAllRequest_d.class);

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
	private final String jobName = "Copy_of_GetAllRequest_d";
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
					Copy_of_GetAllRequest_d.this.exception = e;
				}
			}
			if (!(e instanceof TalendException)) {
				try {
					for (java.lang.reflect.Method m : this.getClass().getEnclosingClass().getMethods()) {
						if (m.getName().compareTo(currentComponent + "_error") == 0) {
							m.invoke(Copy_of_GetAllRequest_d.this, new Object[] { e, currentComponent, globalMap });
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

	public void tPrejob_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tPrejob_1_onSubJobError(exception, errorComponent, globalMap);
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

	public void tSetGlobalVar_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		try {

			if (this.execStat) {
				runStat.updateStatOnConnection("OnComponentError1", 0, "error");
			}

			errorCode = null;
			tFixedFlowInput_3Process(globalMap);
			if (!"failure".equals(status)) {
				status = "end";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		tRESTRequest_1_Loop_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDBInput_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tRESTResponse_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tFixedFlowInput_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFixedFlowInput_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tRESTResponse_4_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFixedFlowInput_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tFixedFlowInput_2_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFixedFlowInput_2_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tRESTResponse_2_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFixedFlowInput_2_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tFixedFlowInput_3_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFixedFlowInput_3_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tRESTResponse_3_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFixedFlowInput_3_onSubJobError(exception, errorComponent, globalMap);
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

	public void tXMLMap_1_TXMLMAP_OUT_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		tXMLMap_1_TXMLMAP_IN_error(exception, errorComponent, globalMap);

	}

	public void tXMLMap_1_TXMLMAP_IN_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tPrejob_1_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

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

	public void tDBInput_1_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public void tFixedFlowInput_1_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public void tFixedFlowInput_2_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public void tFixedFlowInput_3_onSubJobError(Exception exception, String errorComponent,
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

		private final Copy_of_GetAllRequest_d job;

		public RestServiceProviderImpl4TalendJob(Copy_of_GetAllRequest_d job) {
			this.job = job;
		}

		private void populateRequestWithJobContext(java.util.Map<String, Object> requestGlobalMap,
				Copy_of_GetAllRequest_d job) {
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

		@javax.ws.rs.GET()

		@javax.ws.rs.Path("/products")
		@javax.ws.rs.Produces({ "application/xml", "text/xml", "application/json" })
		public javax.ws.rs.core.Response header(

				@javax.ws.rs.HeaderParam("Authorization") String Authorization

		) {
			java.util.Map<String, Object> request_tRESTRequest_1 = new java.util.HashMap<String, Object>();
			request_tRESTRequest_1.put("VERB", "GET");
			request_tRESTRequest_1.put("OPERATION", "header");
			request_tRESTRequest_1.put("PATTERN", "/products");

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

		private final Copy_of_GetAllRequest_d job;

		private org.apache.cxf.endpoint.Server server;

		private org.apache.cxf.jaxrs.JAXRSServerFactoryBean sf;

		public Thread4RestServiceProviderEndpoint(Copy_of_GetAllRequest_d job, String endpointUrl) {
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
			java.io.InputStream inContext = Copy_of_GetAllRequest_d.class.getClassLoader()
					.getResourceAsStream("salesforce/copy_of_getallrequest_d_0_1/contexts/" + context + ".properties");
			if (inContext == null) {
				inContext = Copy_of_GetAllRequest_d.class.getClassLoader()
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
									"enc:routine.encryption.key.v1:k+BL54yTCDmxgGI06KKfUEf2s/sDRxaoWP8Whx37DB0=")
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
						.decryptPassword("enc:routine.encryption.key.v1:JhHScMjwABZco+uFmjovqnOR1E/PdIRgCKb0lpg8VNg=");
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

	public static class ressssStruct implements routines.system.IPersistableRow<ressssStruct> {
		final static byte[] commonByteArrayLock_SALESFORCE_Copy_of_GetAllRequest_d = new byte[0];
		static byte[] commonByteArray_SALESFORCE_Copy_of_GetAllRequest_d = new byte[0];

		public routines.system.Document body;

		public routines.system.Document getBody() {
			return this.body;
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_SALESFORCE_Copy_of_GetAllRequest_d) {

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

			synchronized (commonByteArrayLock_SALESFORCE_Copy_of_GetAllRequest_d) {

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
		public int compareTo(ressssStruct other) {

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

	public static class row1Struct implements routines.system.IPersistableRow<row1Struct> {
		final static byte[] commonByteArrayLock_SALESFORCE_Copy_of_GetAllRequest_d = new byte[0];
		static byte[] commonByteArray_SALESFORCE_Copy_of_GetAllRequest_d = new byte[0];

		public String CD_PRODUIT;

		public String getCD_PRODUIT() {
			return this.CD_PRODUIT;
		}

		public String NOM_PRODUIT;

		public String getNOM_PRODUIT() {
			return this.NOM_PRODUIT;
		}

		public BigDecimal PRIX_ACHAT_PRODUIT;

		public BigDecimal getPRIX_ACHAT_PRODUIT() {
			return this.PRIX_ACHAT_PRODUIT;
		}

		public BigDecimal PRIX_VENTE_PRODUIT;

		public BigDecimal getPRIX_VENTE_PRODUIT() {
			return this.PRIX_VENTE_PRODUIT;
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_SALESFORCE_Copy_of_GetAllRequest_d.length) {
					if (length < 1024 && commonByteArray_SALESFORCE_Copy_of_GetAllRequest_d.length == 0) {
						commonByteArray_SALESFORCE_Copy_of_GetAllRequest_d = new byte[1024];
					} else {
						commonByteArray_SALESFORCE_Copy_of_GetAllRequest_d = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_SALESFORCE_Copy_of_GetAllRequest_d, 0, length);
				strReturn = new String(commonByteArray_SALESFORCE_Copy_of_GetAllRequest_d, 0, length, utf8Charset);
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
				if (length > commonByteArray_SALESFORCE_Copy_of_GetAllRequest_d.length) {
					if (length < 1024 && commonByteArray_SALESFORCE_Copy_of_GetAllRequest_d.length == 0) {
						commonByteArray_SALESFORCE_Copy_of_GetAllRequest_d = new byte[1024];
					} else {
						commonByteArray_SALESFORCE_Copy_of_GetAllRequest_d = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_SALESFORCE_Copy_of_GetAllRequest_d, 0, length);
				strReturn = new String(commonByteArray_SALESFORCE_Copy_of_GetAllRequest_d, 0, length, utf8Charset);
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

			synchronized (commonByteArrayLock_SALESFORCE_Copy_of_GetAllRequest_d) {

				try {

					int length = 0;

					this.CD_PRODUIT = readString(dis);

					this.NOM_PRODUIT = readString(dis);

					this.PRIX_ACHAT_PRODUIT = (BigDecimal) dis.readObject();

					this.PRIX_VENTE_PRODUIT = (BigDecimal) dis.readObject();

				} catch (IOException e) {
					throw new RuntimeException(e);

				} catch (ClassNotFoundException eCNFE) {
					throw new RuntimeException(eCNFE);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_SALESFORCE_Copy_of_GetAllRequest_d) {

				try {

					int length = 0;

					this.CD_PRODUIT = readString(dis);

					this.NOM_PRODUIT = readString(dis);

					this.PRIX_ACHAT_PRODUIT = (BigDecimal) dis.readObject();

					this.PRIX_VENTE_PRODUIT = (BigDecimal) dis.readObject();

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

				writeString(this.CD_PRODUIT, dos);

				// String

				writeString(this.NOM_PRODUIT, dos);

				// BigDecimal

				dos.writeObject(this.PRIX_ACHAT_PRODUIT);

				// BigDecimal

				dos.writeObject(this.PRIX_VENTE_PRODUIT);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.CD_PRODUIT, dos);

				// String

				writeString(this.NOM_PRODUIT, dos);

				// BigDecimal

				dos.writeObject(this.PRIX_ACHAT_PRODUIT);

				// BigDecimal

				dos.writeObject(this.PRIX_VENTE_PRODUIT);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("CD_PRODUIT=" + CD_PRODUIT);
			sb.append(",NOM_PRODUIT=" + NOM_PRODUIT);
			sb.append(",PRIX_ACHAT_PRODUIT=" + String.valueOf(PRIX_ACHAT_PRODUIT));
			sb.append(",PRIX_VENTE_PRODUIT=" + String.valueOf(PRIX_VENTE_PRODUIT));
			sb.append("]");

			return sb.toString();
		}

		public String toLogString() {
			StringBuilder sb = new StringBuilder();

			if (CD_PRODUIT == null) {
				sb.append("<null>");
			} else {
				sb.append(CD_PRODUIT);
			}

			sb.append("|");

			if (NOM_PRODUIT == null) {
				sb.append("<null>");
			} else {
				sb.append(NOM_PRODUIT);
			}

			sb.append("|");

			if (PRIX_ACHAT_PRODUIT == null) {
				sb.append("<null>");
			} else {
				sb.append(PRIX_ACHAT_PRODUIT);
			}

			sb.append("|");

			if (PRIX_VENTE_PRODUIT == null) {
				sb.append("<null>");
			} else {
				sb.append(PRIX_VENTE_PRODUIT);
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

	public void tDBInput_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tDBInput_1_SUBPROCESS_STATE", 0);

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

				row1Struct row1 = new row1Struct();
				ressssStruct ressss = new ressssStruct();

				/**
				 * [tXMLMap_1_TXMLMAP_OUT begin ] start
				 */

				ok_Hash.put("tXMLMap_1_TXMLMAP_OUT", false);
				start_Hash.put("tXMLMap_1_TXMLMAP_OUT", System.currentTimeMillis());

				currentVirtualComponent = "tXMLMap_1";

				currentComponent = "tXMLMap_1_TXMLMAP_OUT";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "row1");
				}

				int tos_count_tXMLMap_1_TXMLMAP_OUT = 0;

				if (log.isDebugEnabled())
					log.debug("tXMLMap_1_TXMLMAP_OUT - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tXMLMap_1_TXMLMAP_OUT {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tXMLMap_1_TXMLMAP_OUT = new StringBuilder();
							log4jParamters_tXMLMap_1_TXMLMAP_OUT.append("Parameters:");
							log4jParamters_tXMLMap_1_TXMLMAP_OUT.append("KEEP_ORDER_FOR_DOCUMENT" + " = " + "false");
							log4jParamters_tXMLMap_1_TXMLMAP_OUT.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tXMLMap_1_TXMLMAP_OUT - " + (log4jParamters_tXMLMap_1_TXMLMAP_OUT));
						}
					}
					new BytesLimit65535_tXMLMap_1_TXMLMAP_OUT().limitLog4jByte();
				}

//===============================input xml init part===============================
				class XML_API_tXMLMap_1_TXMLMAP_OUT {
					public boolean isDefNull(org.dom4j.Node node) throws javax.xml.transform.TransformerException {
						if (node != null && node instanceof org.dom4j.Element) {
							org.dom4j.Attribute attri = ((org.dom4j.Element) node).attribute("nil");
							if (attri != null && ("true").equals(attri.getText())) {
								return true;
							}
						}
						return false;
					}

					public boolean isMissing(org.dom4j.Node node) throws javax.xml.transform.TransformerException {
						return node == null ? true : false;
					}

					public boolean isEmpty(org.dom4j.Node node) throws javax.xml.transform.TransformerException {
						if (node != null) {
							return node.getText().length() == 0;
						}
						return false;
					}
				}
				class Var__tXMLMap_1_TXMLMAP_OUT__Struct {
				}
				Var__tXMLMap_1_TXMLMAP_OUT__Struct Var__tXMLMap_1_TXMLMAP_OUT = new Var__tXMLMap_1_TXMLMAP_OUT__Struct();
// ###############################
// # Outputs initialization
				ressssStruct ressss_tmp = new ressssStruct();
				ressssStruct ressss_save = null;
//the aggregate variable
				ressssStruct ressss_aggregate = null;
				int count_ressss_tXMLMap_1_TXMLMAP_OUT = 0;
//init the resultset for aggregate
				java.util.List<Object> allOutsForAggregate_tXMLMap_1 = new java.util.ArrayList<Object>();
				globalMap.put("allOutsForAggregate_tXMLMap_1", allOutsForAggregate_tXMLMap_1);
// ###############################
				int nb_line_tXMLMap_1_TXMLMAP_OUT = 0;

				XML_API_tXMLMap_1_TXMLMAP_OUT xml_api_tXMLMap_1_TXMLMAP_OUT = new XML_API_tXMLMap_1_TXMLMAP_OUT();

				// the map store the previous value of aggregate columns
				java.util.Map<String, Object> aggregateCacheMap_tXMLMap_1_TXMLMAP_OUT = new java.util.HashMap<String, Object>();

				class GenerateDocument_ressss {

					java.util.Map<String, Object> valueMap = null;

					routines.system.DocumentGenerateOrderHelper orderHelper = new routines.system.DocumentGenerateOrderHelper(
							1);

					org.dom4j.Document doc = null;

					org.dom4j.Element root4Group = null;

					org.dom4j.io.OutputFormat format = null;

					java.util.List<java.util.List<String>> groupbyList = null;
					java.util.List<org.dom4j.Element> groupElementList = null;
					int order = 0;

					boolean isFirst = true;

					boolean needRoot = true;

					String currentValue = null;

					org.dom4j.Element subTreeLoopParent0 = null;
					public boolean subTreeLoop0 = false;

					public GenerateDocument_ressss() {
//    	this.treeNodeAPI = treeNodeAPI;

						valueMap = new java.util.HashMap<String, Object>();

						groupbyList = new java.util.ArrayList<java.util.List<String>>();
						groupElementList = new java.util.ArrayList<org.dom4j.Element>();

						doc = org.dom4j.DocumentHelper.createDocument();
						format = org.dom4j.io.OutputFormat.createPrettyPrint();
						format.setTrimText(false);
					}

					public org.dom4j.Document getDocument() {
						return this.doc;
					}

					// We generate the TreeNode_API object only if there is a document in the main
					// input table.
					void generateElements(boolean isInnerJoin, row1Struct row1,
							Var__tXMLMap_1_TXMLMAP_OUT__Struct Var) {

						/*
						 * if(this.treeNodeAPI==null) { this.treeNodeAPI = treeNodeAPI; }
						 */

						org.dom4j.Element subTreeRootParent = null;
// build root xml tree 
						if (needRoot) {
							needRoot = false;
							org.dom4j.Element root = null;
							root = doc.addElement("products");
							subTreeRootParent = root;
							subTreeLoopParent0 = root;
							root4Group = subTreeRootParent;
						} else {
							subTreeRootParent = root4Group;
						}
						/* build group xml tree */
						boolean isNewElement = false;
						isNewElement = false;
						org.dom4j.Element loop = null;
						loop = org.dom4j.DocumentHelper.createElement("product");
						subTreeRootParent.elements().add(orderHelper.getInsertLocation(0, 0), loop);
						subTreeRootParent = loop;
						org.dom4j.Element loop_0 = null;
						loop_0 = loop.addElement("CD_PRODUIT");
						valueMap.put("loop_0", row1.CD_PRODUIT);
						if (valueMap.get("loop_0") != null) {
							routines.system.NestXMLTool.setText(loop_0,
									FormatterUtils.fm(valueMap.get("loop_0"), null));
						}
						org.dom4j.Element loop_1 = null;
						loop_1 = loop.addElement("NOM_PRODUIT");
						valueMap.put("loop_1", row1.NOM_PRODUIT);
						if (valueMap.get("loop_1") != null) {
							routines.system.NestXMLTool.setText(loop_1,
									FormatterUtils.fm(valueMap.get("loop_1"), null));
						}
						org.dom4j.Element loop_2 = null;
						loop_2 = loop.addElement("PRIX_ACHAT_PRODUIT");
						valueMap.put("loop_2", row1.PRIX_ACHAT_PRODUIT);
						if (valueMap.get("loop_2") != null) {
							routines.system.NestXMLTool.setText(loop_2,
									FormatterUtils.fm(valueMap.get("loop_2"), null));
						}
						org.dom4j.Element loop_3 = null;
						loop_3 = loop.addElement("PRIX_VENTE_PRODUIT");
						valueMap.put("loop_3", row1.PRIX_VENTE_PRODUIT);
						if (valueMap.get("loop_3") != null) {
							routines.system.NestXMLTool.setText(loop_3,
									FormatterUtils.fm(valueMap.get("loop_3"), null));
						}
					}
				}

				GenerateDocument_ressss gen_Doc_ressss_tXMLMap_1_TXMLMAP_OUT = new GenerateDocument_ressss();
				boolean docAlreadyInstanciate_ressss = false;

				/**
				 * [tXMLMap_1_TXMLMAP_OUT begin ] stop
				 */

				/**
				 * [tDBInput_1 begin ] start
				 */

				ok_Hash.put("tDBInput_1", false);
				start_Hash.put("tDBInput_1", System.currentTimeMillis());

				currentComponent = "tDBInput_1";

				int tos_count_tDBInput_1 = 0;

				if (log.isDebugEnabled())
					log.debug("tDBInput_1 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tDBInput_1 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tDBInput_1 = new StringBuilder();
							log4jParamters_tDBInput_1.append("Parameters:");
							log4jParamters_tDBInput_1.append("USE_EXISTING_CONNECTION" + " = " + "true");
							log4jParamters_tDBInput_1.append(" | ");
							log4jParamters_tDBInput_1.append("CONNECTION" + " = " + "tDBConnection_1");
							log4jParamters_tDBInput_1.append(" | ");
							log4jParamters_tDBInput_1.append("QUERYSTORE" + " = " + "\"\"");
							log4jParamters_tDBInput_1.append(" | ");
							log4jParamters_tDBInput_1.append("QUERY" + " = "
									+ "\"SELECT    \\\"API_TALEND\\\".\\\"Produit\\\".\\\"CD_PRODUIT\\\",    \\\"API_TALEND\\\".\\\"Produit\\\".\\\"NOM_PRODUIT\\\",    \\\"API_TALEND\\\".\\\"Produit\\\".\\\"PRIX_ACHAT_PRODUIT\\\",    \\\"API_TALEND\\\".\\\"Produit\\\".\\\"PRIX_VENTE_PRODUIT\\\" FROM \\\"API_TALEND\\\".\\\"Produit\\\"\"");
							log4jParamters_tDBInput_1.append(" | ");
							log4jParamters_tDBInput_1.append("USE_CURSOR" + " = " + "false");
							log4jParamters_tDBInput_1.append(" | ");
							log4jParamters_tDBInput_1.append("TRIM_ALL_COLUMN" + " = " + "false");
							log4jParamters_tDBInput_1.append(" | ");
							log4jParamters_tDBInput_1.append("TRIM_COLUMN" + " = " + "[{TRIM=" + ("false")
									+ ", SCHEMA_COLUMN=" + ("CD_PRODUIT") + "}, {TRIM=" + ("false") + ", SCHEMA_COLUMN="
									+ ("NOM_PRODUIT") + "}, {TRIM=" + ("false") + ", SCHEMA_COLUMN="
									+ ("PRIX_ACHAT_PRODUIT") + "}, {TRIM=" + ("false") + ", SCHEMA_COLUMN="
									+ ("PRIX_VENTE_PRODUIT") + "}]");
							log4jParamters_tDBInput_1.append(" | ");
							log4jParamters_tDBInput_1.append("UNIFIED_COMPONENTS" + " = " + "tPostgresqlInput");
							log4jParamters_tDBInput_1.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tDBInput_1 - " + (log4jParamters_tDBInput_1));
						}
					}
					new BytesLimit65535_tDBInput_1().limitLog4jByte();
				}

				int nb_line_tDBInput_1 = 0;
				java.sql.Connection conn_tDBInput_1 = null;
				conn_tDBInput_1 = (java.sql.Connection) globalMap.get("conn_tDBConnection_1");

				if (conn_tDBInput_1 != null) {
					if (conn_tDBInput_1.getMetaData() != null) {

						log.debug("tDBInput_1 - Uses an existing connection with username '"
								+ conn_tDBInput_1.getMetaData().getUserName() + "'. Connection URL: "
								+ conn_tDBInput_1.getMetaData().getURL() + ".");

					}
				}

				java.sql.Statement stmt_tDBInput_1 = conn_tDBInput_1.createStatement();

				String dbquery_tDBInput_1 = "SELECT \n  \"API_TALEND\".\"Produit\".\"CD_PRODUIT\", \n  \"API_TALEND\".\"Produit\".\"NOM_PRODUIT\", \n  \"API_TALEND\"."
						+ "\"Produit\".\"PRIX_ACHAT_PRODUIT\", \n  \"API_TALEND\".\"Produit\".\"PRIX_VENTE_PRODUIT\"\nFROM \"API_TALEND\".\"Produit\""
						+ "";

				log.debug("tDBInput_1 - Executing the query: '" + dbquery_tDBInput_1 + "'.");

				globalMap.put("tDBInput_1_QUERY", dbquery_tDBInput_1);
				java.sql.ResultSet rs_tDBInput_1 = null;

				try {
					rs_tDBInput_1 = stmt_tDBInput_1.executeQuery(dbquery_tDBInput_1);
					java.sql.ResultSetMetaData rsmd_tDBInput_1 = rs_tDBInput_1.getMetaData();
					int colQtyInRs_tDBInput_1 = rsmd_tDBInput_1.getColumnCount();

					String tmpContent_tDBInput_1 = null;

					log.debug("tDBInput_1 - Retrieving records from the database.");

					while (rs_tDBInput_1.next()) {
						nb_line_tDBInput_1++;

						if (colQtyInRs_tDBInput_1 < 1) {
							row1.CD_PRODUIT = null;
						} else {

							row1.CD_PRODUIT = routines.system.JDBCUtil.getString(rs_tDBInput_1, 1, false);
						}
						if (colQtyInRs_tDBInput_1 < 2) {
							row1.NOM_PRODUIT = null;
						} else {

							row1.NOM_PRODUIT = routines.system.JDBCUtil.getString(rs_tDBInput_1, 2, false);
						}
						if (colQtyInRs_tDBInput_1 < 3) {
							row1.PRIX_ACHAT_PRODUIT = null;
						} else {

							row1.PRIX_ACHAT_PRODUIT = rs_tDBInput_1.getBigDecimal(3);
							if (rs_tDBInput_1.wasNull()) {
								throw new RuntimeException("Null value in non-Nullable column");
							}
						}
						if (colQtyInRs_tDBInput_1 < 4) {
							row1.PRIX_VENTE_PRODUIT = null;
						} else {

							row1.PRIX_VENTE_PRODUIT = rs_tDBInput_1.getBigDecimal(4);
							if (rs_tDBInput_1.wasNull()) {
								throw new RuntimeException("Null value in non-Nullable column");
							}
						}

						log.debug("tDBInput_1 - Retrieving the record " + nb_line_tDBInput_1 + ".");

						/**
						 * [tDBInput_1 begin ] stop
						 */

						/**
						 * [tDBInput_1 main ] start
						 */

						currentComponent = "tDBInput_1";

						tos_count_tDBInput_1++;

						/**
						 * [tDBInput_1 main ] stop
						 */

						/**
						 * [tDBInput_1 process_data_begin ] start
						 */

						currentComponent = "tDBInput_1";

						/**
						 * [tDBInput_1 process_data_begin ] stop
						 */

						/**
						 * [tXMLMap_1_TXMLMAP_OUT main ] start
						 */

						currentVirtualComponent = "tXMLMap_1";

						currentComponent = "tXMLMap_1_TXMLMAP_OUT";

						if (execStat) {
							runStat.updateStatOnConnection(iterateId, 1, 1

									, "row1"

							);
						}

						if (log.isTraceEnabled()) {
							log.trace("row1 - " + (row1 == null ? "" : row1.toLogString()));
						}

						boolean rejectedInnerJoin_tXMLMap_1_TXMLMAP_OUT = false;
						boolean rejectedDocInnerJoin_tXMLMap_1_TXMLMAP_OUT = false;
						boolean mainRowRejected_tXMLMap_1_TXMLMAP_OUT = false;
						boolean isMatchDocRowtXMLMap_1_TXMLMAP_OUT = false;

						ressss_tmp.body = null;

						{ // start of Var scope

							// ###############################
							// # Vars tables

							Var__tXMLMap_1_TXMLMAP_OUT__Struct Var = Var__tXMLMap_1_TXMLMAP_OUT;
							// ###############################
							// # Output tables

							ressss = null;

// # Output table : 'ressss'
							count_ressss_tXMLMap_1_TXMLMAP_OUT++;

							if (!docAlreadyInstanciate_ressss) {
								docAlreadyInstanciate_ressss = true;
								gen_Doc_ressss_tXMLMap_1_TXMLMAP_OUT = new GenerateDocument_ressss();
//init one new out struct for cache the result.
								ressss_aggregate = new ressssStruct();
								ressss_aggregate.body = new routines.system.Document();
								ressss_aggregate.body.setDocument(gen_Doc_ressss_tXMLMap_1_TXMLMAP_OUT.getDocument());

//construct the resultset
								allOutsForAggregate_tXMLMap_1.add(ressss_aggregate);
							}

							gen_Doc_ressss_tXMLMap_1_TXMLMAP_OUT
									.generateElements(rejectedDocInnerJoin_tXMLMap_1_TXMLMAP_OUT, row1, Var);

							log.debug("tXMLMap_1 - Outputting the record " + count_ressss_tXMLMap_1_TXMLMAP_OUT
									+ " of the output table 'ressss'.");

// ###############################

						} // end of Var scope

						rejectedInnerJoin_tXMLMap_1_TXMLMAP_OUT = false;

						tos_count_tXMLMap_1_TXMLMAP_OUT++;

						/**
						 * [tXMLMap_1_TXMLMAP_OUT main ] stop
						 */

						/**
						 * [tXMLMap_1_TXMLMAP_OUT process_data_begin ] start
						 */

						currentVirtualComponent = "tXMLMap_1";

						currentComponent = "tXMLMap_1_TXMLMAP_OUT";

						/**
						 * [tXMLMap_1_TXMLMAP_OUT process_data_begin ] stop
						 */

						/**
						 * [tXMLMap_1_TXMLMAP_OUT process_data_end ] start
						 */

						currentVirtualComponent = "tXMLMap_1";

						currentComponent = "tXMLMap_1_TXMLMAP_OUT";

						/**
						 * [tXMLMap_1_TXMLMAP_OUT process_data_end ] stop
						 */

						/**
						 * [tDBInput_1 process_data_end ] start
						 */

						currentComponent = "tDBInput_1";

						/**
						 * [tDBInput_1 process_data_end ] stop
						 */

						/**
						 * [tDBInput_1 end ] start
						 */

						currentComponent = "tDBInput_1";

					}
				} finally {
					if (rs_tDBInput_1 != null) {
						rs_tDBInput_1.close();
					}
					if (stmt_tDBInput_1 != null) {
						stmt_tDBInput_1.close();
					}
				}
				globalMap.put("tDBInput_1_NB_LINE", nb_line_tDBInput_1);
				log.debug("tDBInput_1 - Retrieved records count: " + nb_line_tDBInput_1 + " .");

				if (log.isDebugEnabled())
					log.debug("tDBInput_1 - " + ("Done."));

				ok_Hash.put("tDBInput_1", true);
				end_Hash.put("tDBInput_1", System.currentTimeMillis());

				if (((Integer) globalMap.get("tDBInput_1_NB_LINE")) == 0) {

					if (execStat) {
						runStat.updateStatOnConnection("If4", 0, "true");
					}
					tFixedFlowInput_1Process(globalMap);
				}

				else {
					if (execStat) {
						runStat.updateStatOnConnection("If4", 0, "false");
					}
				}

				/**
				 * [tDBInput_1 end ] stop
				 */

				/**
				 * [tXMLMap_1_TXMLMAP_OUT end ] start
				 */

				currentVirtualComponent = "tXMLMap_1";

				currentComponent = "tXMLMap_1_TXMLMAP_OUT";

				log.debug("tXMLMap_1 - Written records count in the table 'ressss': "
						+ count_ressss_tXMLMap_1_TXMLMAP_OUT + ".");

				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "row1");
				}

				if (log.isDebugEnabled())
					log.debug("tXMLMap_1_TXMLMAP_OUT - " + ("Done."));

				ok_Hash.put("tXMLMap_1_TXMLMAP_OUT", true);
				end_Hash.put("tXMLMap_1_TXMLMAP_OUT", System.currentTimeMillis());

				/**
				 * [tXMLMap_1_TXMLMAP_OUT end ] stop
				 */

				/**
				 * [tRESTResponse_1 begin ] start
				 */

				ok_Hash.put("tRESTResponse_1", false);
				start_Hash.put("tRESTResponse_1", System.currentTimeMillis());

				currentComponent = "tRESTResponse_1";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "ressss");
				}

				int tos_count_tRESTResponse_1 = 0;

				/**
				 * [tRESTResponse_1 begin ] stop
				 */

				/**
				 * [tXMLMap_1_TXMLMAP_IN begin ] start
				 */

				ok_Hash.put("tXMLMap_1_TXMLMAP_IN", false);
				start_Hash.put("tXMLMap_1_TXMLMAP_IN", System.currentTimeMillis());

				currentVirtualComponent = "tXMLMap_1";

				currentComponent = "tXMLMap_1_TXMLMAP_IN";

				int tos_count_tXMLMap_1_TXMLMAP_IN = 0;

				if (log.isDebugEnabled())
					log.debug("tXMLMap_1_TXMLMAP_IN - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tXMLMap_1_TXMLMAP_IN {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tXMLMap_1_TXMLMAP_IN = new StringBuilder();
							log4jParamters_tXMLMap_1_TXMLMAP_IN.append("Parameters:");
							log4jParamters_tXMLMap_1_TXMLMAP_IN.append("KEEP_ORDER_FOR_DOCUMENT" + " = " + "false");
							log4jParamters_tXMLMap_1_TXMLMAP_IN.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tXMLMap_1_TXMLMAP_IN - " + (log4jParamters_tXMLMap_1_TXMLMAP_IN));
						}
					}
					new BytesLimit65535_tXMLMap_1_TXMLMAP_IN().limitLog4jByte();
				}
				java.util.List<Object> outs_tXMLMap_1 = (java.util.List<Object>) globalMap
						.get("allOutsForAggregate_tXMLMap_1");
				for (Object row_out_tXMLMap_1_TXMLMAP_IN : outs_tXMLMap_1) {// TD512

					/**
					 * [tXMLMap_1_TXMLMAP_IN begin ] stop
					 */

					/**
					 * [tXMLMap_1_TXMLMAP_IN main ] start
					 */

					currentVirtualComponent = "tXMLMap_1";

					currentComponent = "tXMLMap_1_TXMLMAP_IN";

					ressss = null;
					if (row_out_tXMLMap_1_TXMLMAP_IN != null && row_out_tXMLMap_1_TXMLMAP_IN instanceof ressssStruct) {
						ressss = (ressssStruct) row_out_tXMLMap_1_TXMLMAP_IN;
						routines.system.NestXMLTool.generateOk(ressss.body, false);
					}

					tos_count_tXMLMap_1_TXMLMAP_IN++;

					/**
					 * [tXMLMap_1_TXMLMAP_IN main ] stop
					 */

					/**
					 * [tXMLMap_1_TXMLMAP_IN process_data_begin ] start
					 */

					currentVirtualComponent = "tXMLMap_1";

					currentComponent = "tXMLMap_1_TXMLMAP_IN";

					/**
					 * [tXMLMap_1_TXMLMAP_IN process_data_begin ] stop
					 */
// Start of branch "ressss"
					if (ressss != null) {

						/**
						 * [tRESTResponse_1 main ] start
						 */

						currentComponent = "tRESTResponse_1";

						if (execStat) {
							runStat.updateStatOnConnection(iterateId, 1, 1

									, "ressss"

							);
						}

						if (log.isTraceEnabled()) {
							log.trace("ressss - " + (ressss == null ? "" : ressss.toLogString()));
						}

						java.io.OutputStream outputStream_tRESTResponse_1 = (java.io.OutputStream) globalMap
								.get("restResponseStream");
						boolean responseAlreadySent_tRESTResponse_1 = globalMap.containsKey("restResponse");

						if (null == outputStream_tRESTResponse_1 && responseAlreadySent_tRESTResponse_1) {
							throw new RuntimeException("Rest response already sent.");
						} else if (!globalMap.containsKey("restRequest")) {
							throw new RuntimeException("Not received rest request yet.");
						} else {
							Integer restProviderStatusCode_tRESTResponse_1 = 200;

							Object restProviderResponse_tRESTResponse_1 = null;
							if (null != ressss.body) {
								restProviderResponse_tRESTResponse_1 = ressss.body.getDocument();
							}

							java.util.Map<String, String> restProviderResponseHeaders_tRESTResponse_1 = new java.util.TreeMap<String, String>(
									String.CASE_INSENSITIVE_ORDER);
							java.lang.StringBuilder restProviderResponseHeader_cookies_tRESTResponse_1 = new java.lang.StringBuilder();
							final String setCookieHeader = "Set-Cookie";
							if ("correlationId".equalsIgnoreCase(setCookieHeader)) {
								restProviderResponseHeader_cookies_tRESTResponse_1
										.append((String) globalMap.get("s_correlationId"));
								restProviderResponseHeader_cookies_tRESTResponse_1.append(";");
							} else {
								restProviderResponseHeaders_tRESTResponse_1.put("correlationId",
										(String) globalMap.get("s_correlationId"));
							}
							if ("Content-Type".equalsIgnoreCase(setCookieHeader)) {
								restProviderResponseHeader_cookies_tRESTResponse_1.append("application/json");
								restProviderResponseHeader_cookies_tRESTResponse_1.append(";");
							} else {
								restProviderResponseHeaders_tRESTResponse_1.put("Content-Type", "application/json");
							}

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
								restResponse_tRESTResponse_1.put("BODY", restProviderResponse_tRESTResponse_1);
								restResponse_tRESTResponse_1.put("STATUS", restProviderStatusCode_tRESTResponse_1);
								restResponse_tRESTResponse_1.put("HEADERS",
										restProviderResponseHeaders_tRESTResponse_1);
								restResponse_tRESTResponse_1.put("drop.json.root.element", Boolean.valueOf(false));
								globalMap.put("restResponse", restResponse_tRESTResponse_1);

							} else {

								javax.ws.rs.core.MediaType responseMediaType_tRESTResponse_1 = null;
								if (!responseAlreadySent_tRESTResponse_1) {
									org.apache.cxf.message.Message currentMessage = null;
									if (org.apache.cxf.jaxrs.utils.JAXRSUtils.getCurrentMessage() != null) {
										currentMessage = org.apache.cxf.jaxrs.utils.JAXRSUtils.getCurrentMessage();
									} else {
										currentMessage = ((org.apache.cxf.message.Message) restRequest_tRESTResponse_1
												.get("CURRENT_MESSAGE"));
									}

									if (currentMessage != null && currentMessage.getExchange() != null) {
										currentMessage.getExchange().put(StreamingDOM4JProvider.SUPRESS_XML_DECLARATION,
												true);
									}

									messageContext_tRESTResponse_1.put(org.apache.cxf.message.Message.RESPONSE_CODE,
											restProviderStatusCode_tRESTResponse_1);
									javax.ws.rs.core.MultivaluedMap<String, String> headersMultivaluedMap_tRESTResponse_1 = new org.apache.cxf.jaxrs.impl.MetadataMap<String, String>();
									for (java.util.Map.Entry<String, String> multivaluedHeader : restProviderResponseHeaders_tRESTResponse_1
											.entrySet()) {
										headersMultivaluedMap_tRESTResponse_1.putSingle(multivaluedHeader.getKey(),
												multivaluedHeader.getValue());
									}
									messageContext_tRESTResponse_1.put(org.apache.cxf.message.Message.PROTOCOL_HEADERS,
											headersMultivaluedMap_tRESTResponse_1);

									String responseContentType_tRESTResponse_1 = null;

									if (currentMessage != null && currentMessage.getExchange() != null) {
										responseContentType_tRESTResponse_1 = (String) currentMessage.getExchange()
												.get(org.apache.cxf.message.Message.CONTENT_TYPE);
									}

									if (null == responseContentType_tRESTResponse_1) {
										// this should not be needed, just in case. set it to the first value in the
										// sorted list returned from HttpHeaders
										responseMediaType_tRESTResponse_1 = messageContext_tRESTResponse_1
												.getHttpHeaders().getAcceptableMediaTypes().get(0);
									} else {
										responseMediaType_tRESTResponse_1 = org.apache.cxf.jaxrs.utils.JAXRSUtils
												.toMediaType(responseContentType_tRESTResponse_1);
									}
									globalMap.put("restResponseMediaType", responseMediaType_tRESTResponse_1);

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

									messageBodyWriter_tRESTResponse_1.writeTo(restProviderResponse_tRESTResponse_1,
											responseBodyClass_tRESTResponse_1, responseBodyClass_tRESTResponse_1,
											new java.lang.annotation.Annotation[] {}, responseMediaType_tRESTResponse_1,
											null, outputStream_tRESTResponse_1);
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

					} // End of branch "ressss"

					/**
					 * [tXMLMap_1_TXMLMAP_IN process_data_end ] start
					 */

					currentVirtualComponent = "tXMLMap_1";

					currentComponent = "tXMLMap_1_TXMLMAP_IN";

					/**
					 * [tXMLMap_1_TXMLMAP_IN process_data_end ] stop
					 */

					/**
					 * [tXMLMap_1_TXMLMAP_IN end ] start
					 */

					currentVirtualComponent = "tXMLMap_1";

					currentComponent = "tXMLMap_1_TXMLMAP_IN";

				} // TD512

				if (log.isDebugEnabled())
					log.debug("tXMLMap_1_TXMLMAP_IN - " + ("Done."));

				ok_Hash.put("tXMLMap_1_TXMLMAP_IN", true);
				end_Hash.put("tXMLMap_1_TXMLMAP_IN", System.currentTimeMillis());

				/**
				 * [tXMLMap_1_TXMLMAP_IN end ] stop
				 */

				/**
				 * [tRESTResponse_1 end ] start
				 */

				currentComponent = "tRESTResponse_1";

				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "ressss");
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

			te.setVirtualComponentName(currentVirtualComponent);

			throw te;
		} catch (java.lang.Error error) {

			runStat.stopThreadStat();

			throw error;
		} finally {

			try {

				/**
				 * [tDBInput_1 finally ] start
				 */

				currentComponent = "tDBInput_1";

				/**
				 * [tDBInput_1 finally ] stop
				 */

				/**
				 * [tXMLMap_1_TXMLMAP_OUT finally ] start
				 */

				currentVirtualComponent = "tXMLMap_1";

				currentComponent = "tXMLMap_1_TXMLMAP_OUT";

				/**
				 * [tXMLMap_1_TXMLMAP_OUT finally ] stop
				 */

				/**
				 * [tXMLMap_1_TXMLMAP_IN finally ] start
				 */

				currentVirtualComponent = "tXMLMap_1";

				currentComponent = "tXMLMap_1_TXMLMAP_IN";

				/**
				 * [tXMLMap_1_TXMLMAP_IN finally ] stop
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

		globalMap.put("tDBInput_1_SUBPROCESS_STATE", 1);
	}

	public static class row4Struct implements routines.system.IPersistableRow<row4Struct> {
		final static byte[] commonByteArrayLock_SALESFORCE_Copy_of_GetAllRequest_d = new byte[0];
		static byte[] commonByteArray_SALESFORCE_Copy_of_GetAllRequest_d = new byte[0];

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
				if (length > commonByteArray_SALESFORCE_Copy_of_GetAllRequest_d.length) {
					if (length < 1024 && commonByteArray_SALESFORCE_Copy_of_GetAllRequest_d.length == 0) {
						commonByteArray_SALESFORCE_Copy_of_GetAllRequest_d = new byte[1024];
					} else {
						commonByteArray_SALESFORCE_Copy_of_GetAllRequest_d = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_SALESFORCE_Copy_of_GetAllRequest_d, 0, length);
				strReturn = new String(commonByteArray_SALESFORCE_Copy_of_GetAllRequest_d, 0, length, utf8Charset);
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
				if (length > commonByteArray_SALESFORCE_Copy_of_GetAllRequest_d.length) {
					if (length < 1024 && commonByteArray_SALESFORCE_Copy_of_GetAllRequest_d.length == 0) {
						commonByteArray_SALESFORCE_Copy_of_GetAllRequest_d = new byte[1024];
					} else {
						commonByteArray_SALESFORCE_Copy_of_GetAllRequest_d = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_SALESFORCE_Copy_of_GetAllRequest_d, 0, length);
				strReturn = new String(commonByteArray_SALESFORCE_Copy_of_GetAllRequest_d, 0, length, utf8Charset);
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

			synchronized (commonByteArrayLock_SALESFORCE_Copy_of_GetAllRequest_d) {

				try {

					int length = 0;

					this.body = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_SALESFORCE_Copy_of_GetAllRequest_d) {

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

	public void tFixedFlowInput_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tFixedFlowInput_1_SUBPROCESS_STATE", 0);

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

				/**
				 * [tRESTResponse_4 begin ] start
				 */

				ok_Hash.put("tRESTResponse_4", false);
				start_Hash.put("tRESTResponse_4", System.currentTimeMillis());

				currentComponent = "tRESTResponse_4";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "row4");
				}

				int tos_count_tRESTResponse_4 = 0;

				/**
				 * [tRESTResponse_4 begin ] stop
				 */

				/**
				 * [tFixedFlowInput_1 begin ] start
				 */

				ok_Hash.put("tFixedFlowInput_1", false);
				start_Hash.put("tFixedFlowInput_1", System.currentTimeMillis());

				currentComponent = "tFixedFlowInput_1";

				int tos_count_tFixedFlowInput_1 = 0;

				for (int i_tFixedFlowInput_1 = 0; i_tFixedFlowInput_1 < 1; i_tFixedFlowInput_1++) {

					row4.body = "Products not found";

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
					 * [tRESTResponse_4 main ] start
					 */

					currentComponent = "tRESTResponse_4";

					if (execStat) {
						runStat.updateStatOnConnection(iterateId, 1, 1

								, "row4"

						);
					}

					if (log.isTraceEnabled()) {
						log.trace("row4 - " + (row4 == null ? "" : row4.toLogString()));
					}

					java.io.OutputStream outputStream_tRESTResponse_4 = (java.io.OutputStream) globalMap
							.get("restResponseStream");
					boolean responseAlreadySent_tRESTResponse_4 = globalMap.containsKey("restResponse");

					if (null == outputStream_tRESTResponse_4 && responseAlreadySent_tRESTResponse_4) {
						throw new RuntimeException("Rest response already sent.");
					} else if (!globalMap.containsKey("restRequest")) {
						throw new RuntimeException("Not received rest request yet.");
					} else {
						Integer restProviderStatusCode_tRESTResponse_4 = 404;

						Object restProviderResponse_tRESTResponse_4 = null;
						restProviderResponse_tRESTResponse_4 = row4.body;

						java.util.Map<String, String> restProviderResponseHeaders_tRESTResponse_4 = new java.util.TreeMap<String, String>(
								String.CASE_INSENSITIVE_ORDER);
						java.lang.StringBuilder restProviderResponseHeader_cookies_tRESTResponse_4 = new java.lang.StringBuilder();
						final String setCookieHeader = "Set-Cookie";
						if ("correlationId".equalsIgnoreCase(setCookieHeader)) {
							restProviderResponseHeader_cookies_tRESTResponse_4
									.append((String) globalMap.get("s_correlationId"));
							restProviderResponseHeader_cookies_tRESTResponse_4.append(";");
						} else {
							restProviderResponseHeaders_tRESTResponse_4.put("correlationId",
									(String) globalMap.get("s_correlationId"));
						}
						if ("Content-Type".equalsIgnoreCase(setCookieHeader)) {
							restProviderResponseHeader_cookies_tRESTResponse_4.append("application/json");
							restProviderResponseHeader_cookies_tRESTResponse_4.append(";");
						} else {
							restProviderResponseHeaders_tRESTResponse_4.put("Content-Type", "application/json");
						}

						if (restProviderResponseHeader_cookies_tRESTResponse_4.length() > 0) {
							restProviderResponseHeaders_tRESTResponse_4.put(setCookieHeader,
									restProviderResponseHeader_cookies_tRESTResponse_4.toString());
						}

						java.util.Map<String, Object> restRequest_tRESTResponse_4 = (java.util.Map<String, Object>) globalMap
								.get("restRequest");
						org.apache.cxf.jaxrs.ext.MessageContext messageContext_tRESTResponse_4 = (org.apache.cxf.jaxrs.ext.MessageContext) restRequest_tRESTResponse_4
								.get("MESSAGE_CONTEXT");

						if (null == outputStream_tRESTResponse_4) {
							java.util.Map<String, Object> restResponse_tRESTResponse_4 = new java.util.HashMap<String, Object>();
							restResponse_tRESTResponse_4.put("BODY", restProviderResponse_tRESTResponse_4);
							restResponse_tRESTResponse_4.put("STATUS", restProviderStatusCode_tRESTResponse_4);
							restResponse_tRESTResponse_4.put("HEADERS", restProviderResponseHeaders_tRESTResponse_4);
							restResponse_tRESTResponse_4.put("drop.json.root.element", Boolean.valueOf(false));
							globalMap.put("restResponse", restResponse_tRESTResponse_4);

						} else {

							javax.ws.rs.core.MediaType responseMediaType_tRESTResponse_4 = null;
							if (!responseAlreadySent_tRESTResponse_4) {
								org.apache.cxf.message.Message currentMessage = null;
								if (org.apache.cxf.jaxrs.utils.JAXRSUtils.getCurrentMessage() != null) {
									currentMessage = org.apache.cxf.jaxrs.utils.JAXRSUtils.getCurrentMessage();
								} else {
									currentMessage = ((org.apache.cxf.message.Message) restRequest_tRESTResponse_4
											.get("CURRENT_MESSAGE"));
								}

								if (currentMessage != null && currentMessage.getExchange() != null) {
									currentMessage.getExchange().put(StreamingDOM4JProvider.SUPRESS_XML_DECLARATION,
											true);
								}

								messageContext_tRESTResponse_4.put(org.apache.cxf.message.Message.RESPONSE_CODE,
										restProviderStatusCode_tRESTResponse_4);
								javax.ws.rs.core.MultivaluedMap<String, String> headersMultivaluedMap_tRESTResponse_4 = new org.apache.cxf.jaxrs.impl.MetadataMap<String, String>();
								for (java.util.Map.Entry<String, String> multivaluedHeader : restProviderResponseHeaders_tRESTResponse_4
										.entrySet()) {
									headersMultivaluedMap_tRESTResponse_4.putSingle(multivaluedHeader.getKey(),
											multivaluedHeader.getValue());
								}
								messageContext_tRESTResponse_4.put(org.apache.cxf.message.Message.PROTOCOL_HEADERS,
										headersMultivaluedMap_tRESTResponse_4);

								String responseContentType_tRESTResponse_4 = null;

								if (currentMessage != null && currentMessage.getExchange() != null) {
									responseContentType_tRESTResponse_4 = (String) currentMessage.getExchange()
											.get(org.apache.cxf.message.Message.CONTENT_TYPE);
								}

								if (null == responseContentType_tRESTResponse_4) {
									// this should not be needed, just in case. set it to the first value in the
									// sorted list returned from HttpHeaders
									responseMediaType_tRESTResponse_4 = messageContext_tRESTResponse_4.getHttpHeaders()
											.getAcceptableMediaTypes().get(0);
								} else {
									responseMediaType_tRESTResponse_4 = org.apache.cxf.jaxrs.utils.JAXRSUtils
											.toMediaType(responseContentType_tRESTResponse_4);
								}
								globalMap.put("restResponseMediaType", responseMediaType_tRESTResponse_4);

								String responseMediaSubType_tRESTResponse_4 = responseMediaType_tRESTResponse_4
										.getSubtype();
								if (responseMediaSubType_tRESTResponse_4.equals("xml")
										|| responseMediaSubType_tRESTResponse_4.endsWith("+xml")) {
									outputStream_tRESTResponse_4.write("<wrapper>".getBytes());
									globalMap.put("restResponseWrappingClosure", "</wrapper>");
								}
								if (responseMediaSubType_tRESTResponse_4.equals("json")
										|| responseMediaSubType_tRESTResponse_4.endsWith("+json")) {
									outputStream_tRESTResponse_4.write("[".getBytes());
									globalMap.put("restResponseWrappingClosure", "]");
								}

								globalMap.put("restResponse", true);
							} else {
								responseMediaType_tRESTResponse_4 = (javax.ws.rs.core.MediaType) globalMap
										.get("restResponseMediaType");
							}

							if (null != restProviderResponse_tRESTResponse_4) {
								String responseMediaSubType_tRESTResponse_4 = responseMediaType_tRESTResponse_4
										.getSubtype();
								if (responseMediaSubType_tRESTResponse_4.equals("json")
										|| responseMediaSubType_tRESTResponse_4.endsWith("+json")) {
									if (globalMap.containsKey("restResponseJsonStarted")) {
										outputStream_tRESTResponse_4.write(",".getBytes());
									} else {
										globalMap.put("restResponseJsonStarted", true);
									}
								}

								Class<? extends Object> responseBodyClass_tRESTResponse_4 = restProviderResponse_tRESTResponse_4
										.getClass();
								javax.ws.rs.ext.Providers messageBodyProviders_tRESTResponse_4 = messageContext_tRESTResponse_4
										.getProviders();
								javax.ws.rs.ext.MessageBodyWriter messageBodyWriter_tRESTResponse_4 = messageBodyProviders_tRESTResponse_4
										.getMessageBodyWriter(responseBodyClass_tRESTResponse_4,
												responseBodyClass_tRESTResponse_4, null,
												responseMediaType_tRESTResponse_4);

								if (messageBodyWriter_tRESTResponse_4 instanceof StreamingDOM4JProvider) {
									((StreamingDOM4JProvider) messageBodyWriter_tRESTResponse_4)
											.setGlobalMap(globalMap);
								}

								messageBodyWriter_tRESTResponse_4.writeTo(restProviderResponse_tRESTResponse_4,
										responseBodyClass_tRESTResponse_4, responseBodyClass_tRESTResponse_4,
										new java.lang.annotation.Annotation[] {}, responseMediaType_tRESTResponse_4,
										null, outputStream_tRESTResponse_4);
							}
							// initial variant
							// outputStream_tRESTResponse_4.write(String.valueOf(restProviderResponse_tRESTResponse_4).getBytes());
							outputStream_tRESTResponse_4.flush();
						}
					}

					tos_count_tRESTResponse_4++;

					/**
					 * [tRESTResponse_4 main ] stop
					 */

					/**
					 * [tRESTResponse_4 process_data_begin ] start
					 */

					currentComponent = "tRESTResponse_4";

					/**
					 * [tRESTResponse_4 process_data_begin ] stop
					 */

					/**
					 * [tRESTResponse_4 process_data_end ] start
					 */

					currentComponent = "tRESTResponse_4";

					/**
					 * [tRESTResponse_4 process_data_end ] stop
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
				 * [tRESTResponse_4 end ] start
				 */

				currentComponent = "tRESTResponse_4";

				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "row4");
				}

				ok_Hash.put("tRESTResponse_4", true);
				end_Hash.put("tRESTResponse_4", System.currentTimeMillis());

				/**
				 * [tRESTResponse_4 end ] stop
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
				 * [tFixedFlowInput_1 finally ] start
				 */

				currentComponent = "tFixedFlowInput_1";

				/**
				 * [tFixedFlowInput_1 finally ] stop
				 */

				/**
				 * [tRESTResponse_4 finally ] start
				 */

				currentComponent = "tRESTResponse_4";

				/**
				 * [tRESTResponse_4 finally ] stop
				 */

			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tFixedFlowInput_1_SUBPROCESS_STATE", 1);
	}

	public static class row2Struct implements routines.system.IPersistableRow<row2Struct> {
		final static byte[] commonByteArrayLock_SALESFORCE_Copy_of_GetAllRequest_d = new byte[0];
		static byte[] commonByteArray_SALESFORCE_Copy_of_GetAllRequest_d = new byte[0];

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
				if (length > commonByteArray_SALESFORCE_Copy_of_GetAllRequest_d.length) {
					if (length < 1024 && commonByteArray_SALESFORCE_Copy_of_GetAllRequest_d.length == 0) {
						commonByteArray_SALESFORCE_Copy_of_GetAllRequest_d = new byte[1024];
					} else {
						commonByteArray_SALESFORCE_Copy_of_GetAllRequest_d = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_SALESFORCE_Copy_of_GetAllRequest_d, 0, length);
				strReturn = new String(commonByteArray_SALESFORCE_Copy_of_GetAllRequest_d, 0, length, utf8Charset);
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
				if (length > commonByteArray_SALESFORCE_Copy_of_GetAllRequest_d.length) {
					if (length < 1024 && commonByteArray_SALESFORCE_Copy_of_GetAllRequest_d.length == 0) {
						commonByteArray_SALESFORCE_Copy_of_GetAllRequest_d = new byte[1024];
					} else {
						commonByteArray_SALESFORCE_Copy_of_GetAllRequest_d = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_SALESFORCE_Copy_of_GetAllRequest_d, 0, length);
				strReturn = new String(commonByteArray_SALESFORCE_Copy_of_GetAllRequest_d, 0, length, utf8Charset);
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

			synchronized (commonByteArrayLock_SALESFORCE_Copy_of_GetAllRequest_d) {

				try {

					int length = 0;

					this.body = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_SALESFORCE_Copy_of_GetAllRequest_d) {

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

				/**
				 * [tRESTResponse_2 begin ] start
				 */

				ok_Hash.put("tRESTResponse_2", false);
				start_Hash.put("tRESTResponse_2", System.currentTimeMillis());

				currentComponent = "tRESTResponse_2";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "row2");
				}

				int tos_count_tRESTResponse_2 = 0;

				/**
				 * [tRESTResponse_2 begin ] stop
				 */

				/**
				 * [tFixedFlowInput_2 begin ] start
				 */

				ok_Hash.put("tFixedFlowInput_2", false);
				start_Hash.put("tFixedFlowInput_2", System.currentTimeMillis());

				currentComponent = "tFixedFlowInput_2";

				int tos_count_tFixedFlowInput_2 = 0;

				for (int i_tFixedFlowInput_2 = 0; i_tFixedFlowInput_2 < 1; i_tFixedFlowInput_2++) {

					row2.body = "{\"valide\": false}";

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
					 * [tRESTResponse_2 main ] start
					 */

					currentComponent = "tRESTResponse_2";

					if (execStat) {
						runStat.updateStatOnConnection(iterateId, 1, 1

								, "row2"

						);
					}

					if (log.isTraceEnabled()) {
						log.trace("row2 - " + (row2 == null ? "" : row2.toLogString()));
					}

					java.io.OutputStream outputStream_tRESTResponse_2 = (java.io.OutputStream) globalMap
							.get("restResponseStream");
					boolean responseAlreadySent_tRESTResponse_2 = globalMap.containsKey("restResponse");

					if (null == outputStream_tRESTResponse_2 && responseAlreadySent_tRESTResponse_2) {
						throw new RuntimeException("Rest response already sent.");
					} else if (!globalMap.containsKey("restRequest")) {
						throw new RuntimeException("Not received rest request yet.");
					} else {
						Integer restProviderStatusCode_tRESTResponse_2 = 401;

						Object restProviderResponse_tRESTResponse_2 = null;
						restProviderResponse_tRESTResponse_2 = row2.body;

						java.util.Map<String, String> restProviderResponseHeaders_tRESTResponse_2 = new java.util.TreeMap<String, String>(
								String.CASE_INSENSITIVE_ORDER);
						java.lang.StringBuilder restProviderResponseHeader_cookies_tRESTResponse_2 = new java.lang.StringBuilder();
						final String setCookieHeader = "Set-Cookie";
						if ("correlationId".equalsIgnoreCase(setCookieHeader)) {
							restProviderResponseHeader_cookies_tRESTResponse_2
									.append((String) globalMap.get("s_correlationId"));
							restProviderResponseHeader_cookies_tRESTResponse_2.append(";");
						} else {
							restProviderResponseHeaders_tRESTResponse_2.put("correlationId",
									(String) globalMap.get("s_correlationId"));
						}
						if ("Content-Type".equalsIgnoreCase(setCookieHeader)) {
							restProviderResponseHeader_cookies_tRESTResponse_2.append("application/json");
							restProviderResponseHeader_cookies_tRESTResponse_2.append(";");
						} else {
							restProviderResponseHeaders_tRESTResponse_2.put("Content-Type", "application/json");
						}

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
							restResponse_tRESTResponse_2.put("STATUS", restProviderStatusCode_tRESTResponse_2);
							restResponse_tRESTResponse_2.put("HEADERS", restProviderResponseHeaders_tRESTResponse_2);
							restResponse_tRESTResponse_2.put("drop.json.root.element", Boolean.valueOf(false));
							globalMap.put("restResponse", restResponse_tRESTResponse_2);

						} else {

							javax.ws.rs.core.MediaType responseMediaType_tRESTResponse_2 = null;
							if (!responseAlreadySent_tRESTResponse_2) {
								org.apache.cxf.message.Message currentMessage = null;
								if (org.apache.cxf.jaxrs.utils.JAXRSUtils.getCurrentMessage() != null) {
									currentMessage = org.apache.cxf.jaxrs.utils.JAXRSUtils.getCurrentMessage();
								} else {
									currentMessage = ((org.apache.cxf.message.Message) restRequest_tRESTResponse_2
											.get("CURRENT_MESSAGE"));
								}

								if (currentMessage != null && currentMessage.getExchange() != null) {
									currentMessage.getExchange().put(StreamingDOM4JProvider.SUPRESS_XML_DECLARATION,
											true);
								}

								messageContext_tRESTResponse_2.put(org.apache.cxf.message.Message.RESPONSE_CODE,
										restProviderStatusCode_tRESTResponse_2);
								javax.ws.rs.core.MultivaluedMap<String, String> headersMultivaluedMap_tRESTResponse_2 = new org.apache.cxf.jaxrs.impl.MetadataMap<String, String>();
								for (java.util.Map.Entry<String, String> multivaluedHeader : restProviderResponseHeaders_tRESTResponse_2
										.entrySet()) {
									headersMultivaluedMap_tRESTResponse_2.putSingle(multivaluedHeader.getKey(),
											multivaluedHeader.getValue());
								}
								messageContext_tRESTResponse_2.put(org.apache.cxf.message.Message.PROTOCOL_HEADERS,
										headersMultivaluedMap_tRESTResponse_2);

								String responseContentType_tRESTResponse_2 = null;

								if (currentMessage != null && currentMessage.getExchange() != null) {
									responseContentType_tRESTResponse_2 = (String) currentMessage.getExchange()
											.get(org.apache.cxf.message.Message.CONTENT_TYPE);
								}

								if (null == responseContentType_tRESTResponse_2) {
									// this should not be needed, just in case. set it to the first value in the
									// sorted list returned from HttpHeaders
									responseMediaType_tRESTResponse_2 = messageContext_tRESTResponse_2.getHttpHeaders()
											.getAcceptableMediaTypes().get(0);
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

								messageBodyWriter_tRESTResponse_2.writeTo(restProviderResponse_tRESTResponse_2,
										responseBodyClass_tRESTResponse_2, responseBodyClass_tRESTResponse_2,
										new java.lang.annotation.Annotation[] {}, responseMediaType_tRESTResponse_2,
										null, outputStream_tRESTResponse_2);
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
				 * [tRESTResponse_2 end ] start
				 */

				currentComponent = "tRESTResponse_2";

				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "row2");
				}

				ok_Hash.put("tRESTResponse_2", true);
				end_Hash.put("tRESTResponse_2", System.currentTimeMillis());

				/**
				 * [tRESTResponse_2 end ] stop
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

		globalMap.put("tFixedFlowInput_2_SUBPROCESS_STATE", 1);
	}

	public static class row3Struct implements routines.system.IPersistableRow<row3Struct> {
		final static byte[] commonByteArrayLock_SALESFORCE_Copy_of_GetAllRequest_d = new byte[0];
		static byte[] commonByteArray_SALESFORCE_Copy_of_GetAllRequest_d = new byte[0];

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
				if (length > commonByteArray_SALESFORCE_Copy_of_GetAllRequest_d.length) {
					if (length < 1024 && commonByteArray_SALESFORCE_Copy_of_GetAllRequest_d.length == 0) {
						commonByteArray_SALESFORCE_Copy_of_GetAllRequest_d = new byte[1024];
					} else {
						commonByteArray_SALESFORCE_Copy_of_GetAllRequest_d = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_SALESFORCE_Copy_of_GetAllRequest_d, 0, length);
				strReturn = new String(commonByteArray_SALESFORCE_Copy_of_GetAllRequest_d, 0, length, utf8Charset);
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
				if (length > commonByteArray_SALESFORCE_Copy_of_GetAllRequest_d.length) {
					if (length < 1024 && commonByteArray_SALESFORCE_Copy_of_GetAllRequest_d.length == 0) {
						commonByteArray_SALESFORCE_Copy_of_GetAllRequest_d = new byte[1024];
					} else {
						commonByteArray_SALESFORCE_Copy_of_GetAllRequest_d = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_SALESFORCE_Copy_of_GetAllRequest_d, 0, length);
				strReturn = new String(commonByteArray_SALESFORCE_Copy_of_GetAllRequest_d, 0, length, utf8Charset);
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

			synchronized (commonByteArrayLock_SALESFORCE_Copy_of_GetAllRequest_d) {

				try {

					int length = 0;

					this.body = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_SALESFORCE_Copy_of_GetAllRequest_d) {

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

	public void tFixedFlowInput_3Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tFixedFlowInput_3_SUBPROCESS_STATE", 0);

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

				row3Struct row3 = new row3Struct();

				/**
				 * [tRESTResponse_3 begin ] start
				 */

				ok_Hash.put("tRESTResponse_3", false);
				start_Hash.put("tRESTResponse_3", System.currentTimeMillis());

				currentComponent = "tRESTResponse_3";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "row3");
				}

				int tos_count_tRESTResponse_3 = 0;

				/**
				 * [tRESTResponse_3 begin ] stop
				 */

				/**
				 * [tFixedFlowInput_3 begin ] start
				 */

				ok_Hash.put("tFixedFlowInput_3", false);
				start_Hash.put("tFixedFlowInput_3", System.currentTimeMillis());

				currentComponent = "tFixedFlowInput_3";

				int tos_count_tFixedFlowInput_3 = 0;

				for (int i_tFixedFlowInput_3 = 0; i_tFixedFlowInput_3 < 1; i_tFixedFlowInput_3++) {

					row3.body = "Internal server error";

					/**
					 * [tFixedFlowInput_3 begin ] stop
					 */

					/**
					 * [tFixedFlowInput_3 main ] start
					 */

					currentComponent = "tFixedFlowInput_3";

					tos_count_tFixedFlowInput_3++;

					/**
					 * [tFixedFlowInput_3 main ] stop
					 */

					/**
					 * [tFixedFlowInput_3 process_data_begin ] start
					 */

					currentComponent = "tFixedFlowInput_3";

					/**
					 * [tFixedFlowInput_3 process_data_begin ] stop
					 */

					/**
					 * [tRESTResponse_3 main ] start
					 */

					currentComponent = "tRESTResponse_3";

					if (execStat) {
						runStat.updateStatOnConnection(iterateId, 1, 1

								, "row3"

						);
					}

					if (log.isTraceEnabled()) {
						log.trace("row3 - " + (row3 == null ? "" : row3.toLogString()));
					}

					java.io.OutputStream outputStream_tRESTResponse_3 = (java.io.OutputStream) globalMap
							.get("restResponseStream");
					boolean responseAlreadySent_tRESTResponse_3 = globalMap.containsKey("restResponse");

					if (null == outputStream_tRESTResponse_3 && responseAlreadySent_tRESTResponse_3) {
						throw new RuntimeException("Rest response already sent.");
					} else if (!globalMap.containsKey("restRequest")) {
						throw new RuntimeException("Not received rest request yet.");
					} else {
						Integer restProviderStatusCode_tRESTResponse_3 = 500;

						Object restProviderResponse_tRESTResponse_3 = null;
						restProviderResponse_tRESTResponse_3 = row3.body;

						java.util.Map<String, String> restProviderResponseHeaders_tRESTResponse_3 = new java.util.TreeMap<String, String>(
								String.CASE_INSENSITIVE_ORDER);
						java.lang.StringBuilder restProviderResponseHeader_cookies_tRESTResponse_3 = new java.lang.StringBuilder();
						final String setCookieHeader = "Set-Cookie";

						if (restProviderResponseHeader_cookies_tRESTResponse_3.length() > 0) {
							restProviderResponseHeaders_tRESTResponse_3.put(setCookieHeader,
									restProviderResponseHeader_cookies_tRESTResponse_3.toString());
						}

						java.util.Map<String, Object> restRequest_tRESTResponse_3 = (java.util.Map<String, Object>) globalMap
								.get("restRequest");
						org.apache.cxf.jaxrs.ext.MessageContext messageContext_tRESTResponse_3 = (org.apache.cxf.jaxrs.ext.MessageContext) restRequest_tRESTResponse_3
								.get("MESSAGE_CONTEXT");

						if (null == outputStream_tRESTResponse_3) {
							java.util.Map<String, Object> restResponse_tRESTResponse_3 = new java.util.HashMap<String, Object>();
							restResponse_tRESTResponse_3.put("BODY", restProviderResponse_tRESTResponse_3);
							restResponse_tRESTResponse_3.put("STATUS", restProviderStatusCode_tRESTResponse_3);
							restResponse_tRESTResponse_3.put("HEADERS", restProviderResponseHeaders_tRESTResponse_3);
							restResponse_tRESTResponse_3.put("drop.json.root.element", Boolean.valueOf(false));
							globalMap.put("restResponse", restResponse_tRESTResponse_3);

						} else {

							javax.ws.rs.core.MediaType responseMediaType_tRESTResponse_3 = null;
							if (!responseAlreadySent_tRESTResponse_3) {
								org.apache.cxf.message.Message currentMessage = null;
								if (org.apache.cxf.jaxrs.utils.JAXRSUtils.getCurrentMessage() != null) {
									currentMessage = org.apache.cxf.jaxrs.utils.JAXRSUtils.getCurrentMessage();
								} else {
									currentMessage = ((org.apache.cxf.message.Message) restRequest_tRESTResponse_3
											.get("CURRENT_MESSAGE"));
								}

								if (currentMessage != null && currentMessage.getExchange() != null) {
									currentMessage.getExchange().put(StreamingDOM4JProvider.SUPRESS_XML_DECLARATION,
											true);
								}

								messageContext_tRESTResponse_3.put(org.apache.cxf.message.Message.RESPONSE_CODE,
										restProviderStatusCode_tRESTResponse_3);
								javax.ws.rs.core.MultivaluedMap<String, String> headersMultivaluedMap_tRESTResponse_3 = new org.apache.cxf.jaxrs.impl.MetadataMap<String, String>();
								for (java.util.Map.Entry<String, String> multivaluedHeader : restProviderResponseHeaders_tRESTResponse_3
										.entrySet()) {
									headersMultivaluedMap_tRESTResponse_3.putSingle(multivaluedHeader.getKey(),
											multivaluedHeader.getValue());
								}
								messageContext_tRESTResponse_3.put(org.apache.cxf.message.Message.PROTOCOL_HEADERS,
										headersMultivaluedMap_tRESTResponse_3);

								String responseContentType_tRESTResponse_3 = null;

								if (currentMessage != null && currentMessage.getExchange() != null) {
									responseContentType_tRESTResponse_3 = (String) currentMessage.getExchange()
											.get(org.apache.cxf.message.Message.CONTENT_TYPE);
								}

								if (null == responseContentType_tRESTResponse_3) {
									// this should not be needed, just in case. set it to the first value in the
									// sorted list returned from HttpHeaders
									responseMediaType_tRESTResponse_3 = messageContext_tRESTResponse_3.getHttpHeaders()
											.getAcceptableMediaTypes().get(0);
								} else {
									responseMediaType_tRESTResponse_3 = org.apache.cxf.jaxrs.utils.JAXRSUtils
											.toMediaType(responseContentType_tRESTResponse_3);
								}
								globalMap.put("restResponseMediaType", responseMediaType_tRESTResponse_3);

								String responseMediaSubType_tRESTResponse_3 = responseMediaType_tRESTResponse_3
										.getSubtype();
								if (responseMediaSubType_tRESTResponse_3.equals("xml")
										|| responseMediaSubType_tRESTResponse_3.endsWith("+xml")) {
									outputStream_tRESTResponse_3.write("<wrapper>".getBytes());
									globalMap.put("restResponseWrappingClosure", "</wrapper>");
								}
								if (responseMediaSubType_tRESTResponse_3.equals("json")
										|| responseMediaSubType_tRESTResponse_3.endsWith("+json")) {
									outputStream_tRESTResponse_3.write("[".getBytes());
									globalMap.put("restResponseWrappingClosure", "]");
								}

								globalMap.put("restResponse", true);
							} else {
								responseMediaType_tRESTResponse_3 = (javax.ws.rs.core.MediaType) globalMap
										.get("restResponseMediaType");
							}

							if (null != restProviderResponse_tRESTResponse_3) {
								String responseMediaSubType_tRESTResponse_3 = responseMediaType_tRESTResponse_3
										.getSubtype();
								if (responseMediaSubType_tRESTResponse_3.equals("json")
										|| responseMediaSubType_tRESTResponse_3.endsWith("+json")) {
									if (globalMap.containsKey("restResponseJsonStarted")) {
										outputStream_tRESTResponse_3.write(",".getBytes());
									} else {
										globalMap.put("restResponseJsonStarted", true);
									}
								}

								Class<? extends Object> responseBodyClass_tRESTResponse_3 = restProviderResponse_tRESTResponse_3
										.getClass();
								javax.ws.rs.ext.Providers messageBodyProviders_tRESTResponse_3 = messageContext_tRESTResponse_3
										.getProviders();
								javax.ws.rs.ext.MessageBodyWriter messageBodyWriter_tRESTResponse_3 = messageBodyProviders_tRESTResponse_3
										.getMessageBodyWriter(responseBodyClass_tRESTResponse_3,
												responseBodyClass_tRESTResponse_3, null,
												responseMediaType_tRESTResponse_3);

								if (messageBodyWriter_tRESTResponse_3 instanceof StreamingDOM4JProvider) {
									((StreamingDOM4JProvider) messageBodyWriter_tRESTResponse_3)
											.setGlobalMap(globalMap);
								}

								messageBodyWriter_tRESTResponse_3.writeTo(restProviderResponse_tRESTResponse_3,
										responseBodyClass_tRESTResponse_3, responseBodyClass_tRESTResponse_3,
										new java.lang.annotation.Annotation[] {}, responseMediaType_tRESTResponse_3,
										null, outputStream_tRESTResponse_3);
							}
							// initial variant
							// outputStream_tRESTResponse_3.write(String.valueOf(restProviderResponse_tRESTResponse_3).getBytes());
							outputStream_tRESTResponse_3.flush();
						}
					}

					tos_count_tRESTResponse_3++;

					/**
					 * [tRESTResponse_3 main ] stop
					 */

					/**
					 * [tRESTResponse_3 process_data_begin ] start
					 */

					currentComponent = "tRESTResponse_3";

					/**
					 * [tRESTResponse_3 process_data_begin ] stop
					 */

					/**
					 * [tRESTResponse_3 process_data_end ] start
					 */

					currentComponent = "tRESTResponse_3";

					/**
					 * [tRESTResponse_3 process_data_end ] stop
					 */

					/**
					 * [tFixedFlowInput_3 process_data_end ] start
					 */

					currentComponent = "tFixedFlowInput_3";

					/**
					 * [tFixedFlowInput_3 process_data_end ] stop
					 */

					/**
					 * [tFixedFlowInput_3 end ] start
					 */

					currentComponent = "tFixedFlowInput_3";

				}
				globalMap.put("tFixedFlowInput_3_NB_LINE", 1);

				ok_Hash.put("tFixedFlowInput_3", true);
				end_Hash.put("tFixedFlowInput_3", System.currentTimeMillis());

				/**
				 * [tFixedFlowInput_3 end ] stop
				 */

				/**
				 * [tRESTResponse_3 end ] start
				 */

				currentComponent = "tRESTResponse_3";

				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "row3");
				}

				ok_Hash.put("tRESTResponse_3", true);
				end_Hash.put("tRESTResponse_3", System.currentTimeMillis());

				/**
				 * [tRESTResponse_3 end ] stop
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
				 * [tFixedFlowInput_3 finally ] start
				 */

				currentComponent = "tFixedFlowInput_3";

				/**
				 * [tFixedFlowInput_3 finally ] stop
				 */

				/**
				 * [tRESTResponse_3 finally ] start
				 */

				currentComponent = "tRESTResponse_3";

				/**
				 * [tRESTResponse_3 finally ] stop
				 */

			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tFixedFlowInput_3_SUBPROCESS_STATE", 1);
	}

	public static class headerStruct implements routines.system.IPersistableRow<headerStruct> {
		final static byte[] commonByteArrayLock_SALESFORCE_Copy_of_GetAllRequest_d = new byte[0];
		static byte[] commonByteArray_SALESFORCE_Copy_of_GetAllRequest_d = new byte[0];

		public String Authorization;

		public String getAuthorization() {
			return this.Authorization;
		}

		public String correlationId;

		public String getCorrelationId() {
			return this.correlationId;
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_SALESFORCE_Copy_of_GetAllRequest_d.length) {
					if (length < 1024 && commonByteArray_SALESFORCE_Copy_of_GetAllRequest_d.length == 0) {
						commonByteArray_SALESFORCE_Copy_of_GetAllRequest_d = new byte[1024];
					} else {
						commonByteArray_SALESFORCE_Copy_of_GetAllRequest_d = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_SALESFORCE_Copy_of_GetAllRequest_d, 0, length);
				strReturn = new String(commonByteArray_SALESFORCE_Copy_of_GetAllRequest_d, 0, length, utf8Charset);
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
				if (length > commonByteArray_SALESFORCE_Copy_of_GetAllRequest_d.length) {
					if (length < 1024 && commonByteArray_SALESFORCE_Copy_of_GetAllRequest_d.length == 0) {
						commonByteArray_SALESFORCE_Copy_of_GetAllRequest_d = new byte[1024];
					} else {
						commonByteArray_SALESFORCE_Copy_of_GetAllRequest_d = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_SALESFORCE_Copy_of_GetAllRequest_d, 0, length);
				strReturn = new String(commonByteArray_SALESFORCE_Copy_of_GetAllRequest_d, 0, length, utf8Charset);
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

			synchronized (commonByteArrayLock_SALESFORCE_Copy_of_GetAllRequest_d) {

				try {

					int length = 0;

					this.Authorization = readString(dis);

					this.correlationId = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_SALESFORCE_Copy_of_GetAllRequest_d) {

				try {

					int length = 0;

					this.Authorization = readString(dis);

					this.correlationId = readString(dis);

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
										+ ("\"i_stepSequence\"") + "}, {VALUE="
										+ ("JacquemusUtils.isBlank(header.correlationId) ? StringHandling.SUBSTR((java.util.UUID.randomUUID()).toString(), 10, 14) : header.correlationId")
										+ ", KEY=" + ("\"s_correlationId\"") + "}]");
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
						globalMap.put("s_correlationId",
								JacquemusUtils.isBlank(header.correlationId)
										? StringHandling.SUBSTR((java.util.UUID.randomUUID()).toString(), 10, 14)
										: header.correlationId);

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
							runStat.updateStatOnConnection("If3", 0, "true");
						}
						tDBInput_1Process(globalMap);
					}

					else {
						if (execStat) {
							runStat.updateStatOnConnection("If3", 0, "false");
						}
					}
					if (!(Boolean) globalMap.get("is_valid_token")) {

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
		final Copy_of_GetAllRequest_d Copy_of_GetAllRequest_dClass = new Copy_of_GetAllRequest_d();

		int exitCode = Copy_of_GetAllRequest_dClass.runJobInTOS(args);
		if (exitCode == 0) {
			log.info("TalendJob: 'Copy_of_GetAllRequest_d' - Done.");
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
		log.info("TalendJob: 'Copy_of_GetAllRequest_d' - Start.");

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
			java.io.InputStream inContext = Copy_of_GetAllRequest_d.class.getClassLoader().getResourceAsStream(
					"salesforce/copy_of_getallrequest_d_0_1/contexts/" + contextStr + ".properties");
			if (inContext == null) {
				inContext = Copy_of_GetAllRequest_d.class.getClassLoader()
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
			System.out.println((endUsedMemory - startUsedMemory)
					+ " bytes memory increase when running : Copy_of_GetAllRequest_d");
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
 * 193565 characters generated by Talend Open Studio for ESB on the 11 août 2024
 * à 12:43:19 PM CET
 ************************************************************************************************/