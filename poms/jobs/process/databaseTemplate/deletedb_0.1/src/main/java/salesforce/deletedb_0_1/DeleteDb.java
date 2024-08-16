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

package salesforce.deletedb_0_1;

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

//the import part of tJava_1
//import java.util.List;

@SuppressWarnings("unused")

/**
 * Job: DeleteDb Purpose: <br>
 * Description: <br>
 * 
 * @author user@talend.com
 * @version 8.0.1.20211109_1610
 * @status
 */
public class DeleteDb implements TalendJob {
	static {
		System.setProperty("TalendJob.log", "DeleteDb.log");
	}

	private static org.apache.logging.log4j.Logger log = org.apache.logging.log4j.LogManager.getLogger(DeleteDb.class);

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
	private final String jobName = "DeleteDb";
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
					DeleteDb.this.exception = e;
				}
			}
			if (!(e instanceof TalendException)) {
				try {
					for (java.lang.reflect.Method m : this.getClass().getEnclosingClass().getMethods()) {
						if (m.getName().compareTo(currentComponent + "_error") == 0) {
							m.invoke(DeleteDb.this, new Object[] { e, currentComponent, globalMap });
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

		status = "failure";

		tRESTRequest_1_Loop_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tFixedFlowInput_2_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFixedFlowInput_2_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDBOutput_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFixedFlowInput_2_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tFixedFlowInput_4_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFixedFlowInput_4_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tRESTResponse_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFixedFlowInput_4_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tSetGlobalVar_3_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tSetGlobalVar_3_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tJava_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tJava_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tFixedFlowInput_3_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFixedFlowInput_3_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tMap_4_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFixedFlowInput_3_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tMap_5_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFixedFlowInput_3_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tRESTResponse_4_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFixedFlowInput_3_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tFileInputDelimited_2_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFixedFlowInput_3_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tAdvancedHash_row8_error(Exception exception, String errorComponent,
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

	public void tFixedFlowInput_2_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public void tFixedFlowInput_4_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public void tSetGlobalVar_3_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public void tJava_1_onSubJobError(Exception exception, String errorComponent,
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

		private final DeleteDb job;

		public RestServiceProviderImpl4TalendJob(DeleteDb job) {
			this.job = job;
		}

		private void populateRequestWithJobContext(java.util.Map<String, Object> requestGlobalMap, DeleteDb job) {
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

		@javax.ws.rs.DELETE()

		@javax.ws.rs.Path("/product/{CD_PRODUIT}")
		@javax.ws.rs.Produces({ "application/xml", "text/xml", "application/json" })
		public javax.ws.rs.core.Response header(

				@javax.ws.rs.HeaderParam("Authorization") String Authorization,
				@javax.ws.rs.PathParam("CD_PRODUIT") String CD_PRODUIT

		) {
			java.util.Map<String, Object> request_tRESTRequest_1 = new java.util.HashMap<String, Object>();
			request_tRESTRequest_1.put("VERB", "DELETE");
			request_tRESTRequest_1.put("OPERATION", "header");
			request_tRESTRequest_1.put("PATTERN", "/product/{CD_PRODUIT}");

			populateRequestInfo(request_tRESTRequest_1, messageContext);

			java.util.Map<String, Object> parameters_tRESTRequest_1 = new java.util.HashMap<String, Object>();

			parameters_tRESTRequest_1.put("HEADER:Authorization:id_String", Authorization);

			parameters_tRESTRequest_1.put("PATH:CD_PRODUIT:id_String", CD_PRODUIT);

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

		private final DeleteDb job;

		private org.apache.cxf.endpoint.Server server;

		private org.apache.cxf.jaxrs.JAXRSServerFactoryBean sf;

		public Thread4RestServiceProviderEndpoint(DeleteDb job, String endpointUrl) {
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
			java.io.InputStream inContext = DeleteDb.class.getClassLoader()
					.getResourceAsStream("salesforce/deletedb_0_1/contexts/" + context + ".properties");
			if (inContext == null) {
				inContext = DeleteDb.class.getClassLoader()
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
		final static byte[] commonByteArrayLock_SALESFORCE_DeleteDb = new byte[0];
		static byte[] commonByteArray_SALESFORCE_DeleteDb = new byte[0];

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
				if (length > commonByteArray_SALESFORCE_DeleteDb.length) {
					if (length < 1024 && commonByteArray_SALESFORCE_DeleteDb.length == 0) {
						commonByteArray_SALESFORCE_DeleteDb = new byte[1024];
					} else {
						commonByteArray_SALESFORCE_DeleteDb = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_SALESFORCE_DeleteDb, 0, length);
				strReturn = new String(commonByteArray_SALESFORCE_DeleteDb, 0, length, utf8Charset);
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
				if (length > commonByteArray_SALESFORCE_DeleteDb.length) {
					if (length < 1024 && commonByteArray_SALESFORCE_DeleteDb.length == 0) {
						commonByteArray_SALESFORCE_DeleteDb = new byte[1024];
					} else {
						commonByteArray_SALESFORCE_DeleteDb = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_SALESFORCE_DeleteDb, 0, length);
				strReturn = new String(commonByteArray_SALESFORCE_DeleteDb, 0, length, utf8Charset);
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

			synchronized (commonByteArrayLock_SALESFORCE_DeleteDb) {

				try {

					int length = 0;

					this.body = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_SALESFORCE_DeleteDb) {

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
		final static byte[] commonByteArrayLock_SALESFORCE_DeleteDb = new byte[0];
		static byte[] commonByteArray_SALESFORCE_DeleteDb = new byte[0];

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
				if (length > commonByteArray_SALESFORCE_DeleteDb.length) {
					if (length < 1024 && commonByteArray_SALESFORCE_DeleteDb.length == 0) {
						commonByteArray_SALESFORCE_DeleteDb = new byte[1024];
					} else {
						commonByteArray_SALESFORCE_DeleteDb = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_SALESFORCE_DeleteDb, 0, length);
				strReturn = new String(commonByteArray_SALESFORCE_DeleteDb, 0, length, utf8Charset);
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
				if (length > commonByteArray_SALESFORCE_DeleteDb.length) {
					if (length < 1024 && commonByteArray_SALESFORCE_DeleteDb.length == 0) {
						commonByteArray_SALESFORCE_DeleteDb = new byte[1024];
					} else {
						commonByteArray_SALESFORCE_DeleteDb = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_SALESFORCE_DeleteDb, 0, length);
				strReturn = new String(commonByteArray_SALESFORCE_DeleteDb, 0, length, utf8Charset);
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

			synchronized (commonByteArrayLock_SALESFORCE_DeleteDb) {

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

			synchronized (commonByteArrayLock_SALESFORCE_DeleteDb) {

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
		final static byte[] commonByteArrayLock_SALESFORCE_DeleteDb = new byte[0];
		static byte[] commonByteArray_SALESFORCE_DeleteDb = new byte[0];

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
				if (length > commonByteArray_SALESFORCE_DeleteDb.length) {
					if (length < 1024 && commonByteArray_SALESFORCE_DeleteDb.length == 0) {
						commonByteArray_SALESFORCE_DeleteDb = new byte[1024];
					} else {
						commonByteArray_SALESFORCE_DeleteDb = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_SALESFORCE_DeleteDb, 0, length);
				strReturn = new String(commonByteArray_SALESFORCE_DeleteDb, 0, length, utf8Charset);
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
				if (length > commonByteArray_SALESFORCE_DeleteDb.length) {
					if (length < 1024 && commonByteArray_SALESFORCE_DeleteDb.length == 0) {
						commonByteArray_SALESFORCE_DeleteDb = new byte[1024];
					} else {
						commonByteArray_SALESFORCE_DeleteDb = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_SALESFORCE_DeleteDb, 0, length);
				strReturn = new String(commonByteArray_SALESFORCE_DeleteDb, 0, length, utf8Charset);
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

			synchronized (commonByteArrayLock_SALESFORCE_DeleteDb) {

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

			synchronized (commonByteArrayLock_SALESFORCE_DeleteDb) {

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
		final static byte[] commonByteArrayLock_SALESFORCE_DeleteDb = new byte[0];
		static byte[] commonByteArray_SALESFORCE_DeleteDb = new byte[0];

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
				if (length > commonByteArray_SALESFORCE_DeleteDb.length) {
					if (length < 1024 && commonByteArray_SALESFORCE_DeleteDb.length == 0) {
						commonByteArray_SALESFORCE_DeleteDb = new byte[1024];
					} else {
						commonByteArray_SALESFORCE_DeleteDb = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_SALESFORCE_DeleteDb, 0, length);
				strReturn = new String(commonByteArray_SALESFORCE_DeleteDb, 0, length, utf8Charset);
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
				if (length > commonByteArray_SALESFORCE_DeleteDb.length) {
					if (length < 1024 && commonByteArray_SALESFORCE_DeleteDb.length == 0) {
						commonByteArray_SALESFORCE_DeleteDb = new byte[1024];
					} else {
						commonByteArray_SALESFORCE_DeleteDb = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_SALESFORCE_DeleteDb, 0, length);
				strReturn = new String(commonByteArray_SALESFORCE_DeleteDb, 0, length, utf8Charset);
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

			synchronized (commonByteArrayLock_SALESFORCE_DeleteDb) {

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

			synchronized (commonByteArrayLock_SALESFORCE_DeleteDb) {

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

	public static class row2Struct implements routines.system.IPersistableRow<row2Struct> {
		final static byte[] commonByteArrayLock_SALESFORCE_DeleteDb = new byte[0];
		static byte[] commonByteArray_SALESFORCE_DeleteDb = new byte[0];

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
				if (length > commonByteArray_SALESFORCE_DeleteDb.length) {
					if (length < 1024 && commonByteArray_SALESFORCE_DeleteDb.length == 0) {
						commonByteArray_SALESFORCE_DeleteDb = new byte[1024];
					} else {
						commonByteArray_SALESFORCE_DeleteDb = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_SALESFORCE_DeleteDb, 0, length);
				strReturn = new String(commonByteArray_SALESFORCE_DeleteDb, 0, length, utf8Charset);
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
				if (length > commonByteArray_SALESFORCE_DeleteDb.length) {
					if (length < 1024 && commonByteArray_SALESFORCE_DeleteDb.length == 0) {
						commonByteArray_SALESFORCE_DeleteDb = new byte[1024];
					} else {
						commonByteArray_SALESFORCE_DeleteDb = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_SALESFORCE_DeleteDb, 0, length);
				strReturn = new String(commonByteArray_SALESFORCE_DeleteDb, 0, length, utf8Charset);
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

			synchronized (commonByteArrayLock_SALESFORCE_DeleteDb) {

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

			synchronized (commonByteArrayLock_SALESFORCE_DeleteDb) {

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

				row2Struct row2 = new row2Struct();
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
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "row2");
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
						row2.type = lcm.getType();
						row2.origin = (lcm.getOrigin() == null || lcm.getOrigin().length() < 1 ? null
								: lcm.getOrigin());
						row2.priority = lcm.getPriority();
						row2.message = lcm.getMessage();
						row2.code = lcm.getCode();

						row2.moment = java.util.Calendar.getInstance().getTime();

						row2.pid = pid;
						row2.root_pid = rootPid;
						row2.father_pid = fatherPid;

						row2.project = projectName;
						row2.job = jobName;
						row2.context = contextStr;

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

									, "row2"

							);
						}

						if (log.isTraceEnabled()) {
							log.trace("row2 - " + (row2 == null ? "" : row2.toLogString()));
						}

						// Get input from tLogCatcher
						row5.origin = row2.origin;
						row5.type = row2.type;
						String logMessage = row2.message;

//Declare the HTTP code variable
						Integer httpCode;

// These are standard responses, don't change them!
						if (logMessage != null && logMessage.contains("Invalid JWS")) {
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
					runStat.updateStat(resourceMap, iterateId, 2, 0, "row2");
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
									"enc:routine.encryption.key.v1:Q39Aa/ml7m7BUhLc4dSG4hvOlx48cX/kqr5h2cdvDwY=")
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
						.decryptPassword("enc:routine.encryption.key.v1:R0Fs/bEErJ6OVtiHVYPWpZ00kerGY6cMbncBA4Adlfg=");
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
		final static byte[] commonByteArrayLock_SALESFORCE_DeleteDb = new byte[0];
		static byte[] commonByteArray_SALESFORCE_DeleteDb = new byte[0];

		public String CD_PRODUIT;

		public String getCD_PRODUIT() {
			return this.CD_PRODUIT;
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_SALESFORCE_DeleteDb.length) {
					if (length < 1024 && commonByteArray_SALESFORCE_DeleteDb.length == 0) {
						commonByteArray_SALESFORCE_DeleteDb = new byte[1024];
					} else {
						commonByteArray_SALESFORCE_DeleteDb = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_SALESFORCE_DeleteDb, 0, length);
				strReturn = new String(commonByteArray_SALESFORCE_DeleteDb, 0, length, utf8Charset);
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
				if (length > commonByteArray_SALESFORCE_DeleteDb.length) {
					if (length < 1024 && commonByteArray_SALESFORCE_DeleteDb.length == 0) {
						commonByteArray_SALESFORCE_DeleteDb = new byte[1024];
					} else {
						commonByteArray_SALESFORCE_DeleteDb = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_SALESFORCE_DeleteDb, 0, length);
				strReturn = new String(commonByteArray_SALESFORCE_DeleteDb, 0, length, utf8Charset);
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

			synchronized (commonByteArrayLock_SALESFORCE_DeleteDb) {

				try {

					int length = 0;

					this.CD_PRODUIT = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_SALESFORCE_DeleteDb) {

				try {

					int length = 0;

					this.CD_PRODUIT = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.CD_PRODUIT, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.CD_PRODUIT, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("CD_PRODUIT=" + CD_PRODUIT);
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

				row1Struct row1 = new row1Struct();

				/**
				 * [tDBOutput_1 begin ] start
				 */

				ok_Hash.put("tDBOutput_1", false);
				start_Hash.put("tDBOutput_1", System.currentTimeMillis());

				currentComponent = "tDBOutput_1";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "row1");
				}

				int tos_count_tDBOutput_1 = 0;

				if (log.isDebugEnabled())
					log.debug("tDBOutput_1 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tDBOutput_1 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tDBOutput_1 = new StringBuilder();
							log4jParamters_tDBOutput_1.append("Parameters:");
							log4jParamters_tDBOutput_1.append("USE_EXISTING_CONNECTION" + " = " + "true");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1.append("CONNECTION" + " = " + "tDBConnection_1");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1.append("TABLE" + " = " + "\"Produit\"");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1.append("TABLE_ACTION" + " = " + "NONE");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1.append("DATA_ACTION" + " = " + "DELETE");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1.append("DIE_ON_ERROR" + " = " + "false");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1.append("USE_ALTERNATE_SCHEMA" + " = " + "false");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1.append("ADD_COLS" + " = " + "[]");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1.append("USE_FIELD_OPTIONS" + " = " + "false");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1.append("ENABLE_DEBUG_MODE" + " = " + "false");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1.append("SUPPORT_NULL_WHERE" + " = " + "false");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1.append("CONVERT_COLUMN_TABLE_TO_LOWERCASE" + " = " + "false");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1.append("USE_BATCH_SIZE" + " = " + "true");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1.append("BATCH_SIZE" + " = " + "10000");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1.append("UNIFIED_COMPONENTS" + " = " + "tPostgresqlOutput");
							log4jParamters_tDBOutput_1.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tDBOutput_1 - " + (log4jParamters_tDBOutput_1));
						}
					}
					new BytesLimit65535_tDBOutput_1().limitLog4jByte();
				}

				String dbschema_tDBOutput_1 = null;
				dbschema_tDBOutput_1 = (String) globalMap.get("schema_" + "tDBConnection_1");

				String tableName_tDBOutput_1 = null;
				if (dbschema_tDBOutput_1 == null || dbschema_tDBOutput_1.trim().length() == 0) {
					tableName_tDBOutput_1 = ("Produit");
				} else {
					tableName_tDBOutput_1 = dbschema_tDBOutput_1 + "\".\"" + ("Produit");
				}

				int deleteKeyCount_tDBOutput_1 = 1;
				if (deleteKeyCount_tDBOutput_1 < 1) {
					throw new RuntimeException("For delete, Schema must have a key");
				}

				int nb_line_tDBOutput_1 = 0;
				int nb_line_update_tDBOutput_1 = 0;
				int nb_line_inserted_tDBOutput_1 = 0;
				int nb_line_deleted_tDBOutput_1 = 0;
				int nb_line_rejected_tDBOutput_1 = 0;

				int deletedCount_tDBOutput_1 = 0;
				int updatedCount_tDBOutput_1 = 0;
				int insertedCount_tDBOutput_1 = 0;
				int rowsToCommitCount_tDBOutput_1 = 0;
				int rejectedCount_tDBOutput_1 = 0;

				boolean whetherReject_tDBOutput_1 = false;

				java.sql.Connection conn_tDBOutput_1 = null;
				String dbUser_tDBOutput_1 = null;

				conn_tDBOutput_1 = (java.sql.Connection) globalMap.get("conn_tDBConnection_1");

				if (log.isDebugEnabled())
					log.debug("tDBOutput_1 - " + ("Uses an existing connection with username '")
							+ (conn_tDBOutput_1.getMetaData().getUserName()) + ("'. Connection URL: ")
							+ (conn_tDBOutput_1.getMetaData().getURL()) + ("."));

				if (log.isDebugEnabled())
					log.debug("tDBOutput_1 - " + ("Connection is set auto commit to '")
							+ (conn_tDBOutput_1.getAutoCommit()) + ("'."));

				int batchSize_tDBOutput_1 = 10000;
				int batchSizeCounter_tDBOutput_1 = 0;

				int count_tDBOutput_1 = 0;
				String delete_tDBOutput_1 = "DELETE FROM \"" + tableName_tDBOutput_1 + "\" WHERE \"CD_PRODUIT\" = ?";
				java.sql.PreparedStatement pstmt_tDBOutput_1 = conn_tDBOutput_1.prepareStatement(delete_tDBOutput_1);
				resourceMap.put("pstmt_tDBOutput_1", pstmt_tDBOutput_1);

				/**
				 * [tDBOutput_1 begin ] stop
				 */

				/**
				 * [tFixedFlowInput_2 begin ] start
				 */

				ok_Hash.put("tFixedFlowInput_2", false);
				start_Hash.put("tFixedFlowInput_2", System.currentTimeMillis());

				currentComponent = "tFixedFlowInput_2";

				int tos_count_tFixedFlowInput_2 = 0;

				for (int i_tFixedFlowInput_2 = 0; i_tFixedFlowInput_2 < 1; i_tFixedFlowInput_2++) {

					row1.CD_PRODUIT = (String) globalMap.get("code");

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
					 * [tDBOutput_1 main ] start
					 */

					currentComponent = "tDBOutput_1";

					if (execStat) {
						runStat.updateStatOnConnection(iterateId, 1, 1

								, "row1"

						);
					}

					if (log.isTraceEnabled()) {
						log.trace("row1 - " + (row1 == null ? "" : row1.toLogString()));
					}

					whetherReject_tDBOutput_1 = false;

					if (row1.CD_PRODUIT == null) {
						pstmt_tDBOutput_1.setNull(1, java.sql.Types.VARCHAR);
					} else {
						pstmt_tDBOutput_1.setString(1, row1.CD_PRODUIT);
					}

					pstmt_tDBOutput_1.addBatch();
					nb_line_tDBOutput_1++;

					if (log.isDebugEnabled())
						log.debug("tDBOutput_1 - " + ("Adding the record ") + (nb_line_tDBOutput_1) + (" to the ")
								+ ("DELETE") + (" batch."));
					batchSizeCounter_tDBOutput_1++;

					if (!whetherReject_tDBOutput_1) {
					}
					if ((batchSize_tDBOutput_1 > 0) && (batchSize_tDBOutput_1 <= batchSizeCounter_tDBOutput_1)) {
						try {
							int countSum_tDBOutput_1 = 0;

							if (log.isDebugEnabled())
								log.debug("tDBOutput_1 - " + ("Executing the ") + ("DELETE") + (" batch."));
							for (int countEach_tDBOutput_1 : pstmt_tDBOutput_1.executeBatch()) {
								countSum_tDBOutput_1 += (countEach_tDBOutput_1 < 0 ? 0 : countEach_tDBOutput_1);
							}
							if (log.isDebugEnabled())
								log.debug(
										"tDBOutput_1 - " + ("The ") + ("DELETE") + (" batch execution has succeeded."));
							rowsToCommitCount_tDBOutput_1 += countSum_tDBOutput_1;

							deletedCount_tDBOutput_1 += countSum_tDBOutput_1;

							batchSizeCounter_tDBOutput_1 = 0;
						} catch (java.sql.BatchUpdateException e_tDBOutput_1) {
							globalMap.put("tDBOutput_1_ERROR_MESSAGE", e_tDBOutput_1.getMessage());
							java.sql.SQLException ne_tDBOutput_1 = e_tDBOutput_1.getNextException(),
									sqle_tDBOutput_1 = null;
							String errormessage_tDBOutput_1;
							if (ne_tDBOutput_1 != null) {
								// build new exception to provide the original cause
								sqle_tDBOutput_1 = new java.sql.SQLException(
										e_tDBOutput_1.getMessage() + "\ncaused by: " + ne_tDBOutput_1.getMessage(),
										ne_tDBOutput_1.getSQLState(), ne_tDBOutput_1.getErrorCode(), ne_tDBOutput_1);
								errormessage_tDBOutput_1 = sqle_tDBOutput_1.getMessage();
							} else {
								errormessage_tDBOutput_1 = e_tDBOutput_1.getMessage();
							}

							int countSum_tDBOutput_1 = 0;
							for (int countEach_tDBOutput_1 : e_tDBOutput_1.getUpdateCounts()) {
								countSum_tDBOutput_1 += (countEach_tDBOutput_1 < 0 ? 0 : countEach_tDBOutput_1);
							}
							rowsToCommitCount_tDBOutput_1 += countSum_tDBOutput_1;

							deletedCount_tDBOutput_1 += countSum_tDBOutput_1;

							log.error("tDBOutput_1 - " + (errormessage_tDBOutput_1));
							System.err.println(errormessage_tDBOutput_1);

						}
					}

					tos_count_tDBOutput_1++;

					/**
					 * [tDBOutput_1 main ] stop
					 */

					/**
					 * [tDBOutput_1 process_data_begin ] start
					 */

					currentComponent = "tDBOutput_1";

					/**
					 * [tDBOutput_1 process_data_begin ] stop
					 */

					/**
					 * [tDBOutput_1 process_data_end ] start
					 */

					currentComponent = "tDBOutput_1";

					/**
					 * [tDBOutput_1 process_data_end ] stop
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
				 * [tDBOutput_1 end ] start
				 */

				currentComponent = "tDBOutput_1";

				try {
					int countSum_tDBOutput_1 = 0;
					if (pstmt_tDBOutput_1 != null && batchSizeCounter_tDBOutput_1 > 0) {

						if (log.isDebugEnabled())
							log.debug("tDBOutput_1 - " + ("Executing the ") + ("DELETE") + (" batch."));
						for (int countEach_tDBOutput_1 : pstmt_tDBOutput_1.executeBatch()) {
							countSum_tDBOutput_1 += (countEach_tDBOutput_1 < 0 ? 0 : countEach_tDBOutput_1);
						}
						rowsToCommitCount_tDBOutput_1 += countSum_tDBOutput_1;

						if (log.isDebugEnabled())
							log.debug("tDBOutput_1 - " + ("The ") + ("DELETE") + (" batch execution has succeeded."));
					}

					deletedCount_tDBOutput_1 += countSum_tDBOutput_1;

				} catch (java.sql.BatchUpdateException e_tDBOutput_1) {
					globalMap.put("tDBOutput_1_ERROR_MESSAGE", e_tDBOutput_1.getMessage());
					java.sql.SQLException ne_tDBOutput_1 = e_tDBOutput_1.getNextException(), sqle_tDBOutput_1 = null;
					String errormessage_tDBOutput_1;
					if (ne_tDBOutput_1 != null) {
						// build new exception to provide the original cause
						sqle_tDBOutput_1 = new java.sql.SQLException(
								e_tDBOutput_1.getMessage() + "\ncaused by: " + ne_tDBOutput_1.getMessage(),
								ne_tDBOutput_1.getSQLState(), ne_tDBOutput_1.getErrorCode(), ne_tDBOutput_1);
						errormessage_tDBOutput_1 = sqle_tDBOutput_1.getMessage();
					} else {
						errormessage_tDBOutput_1 = e_tDBOutput_1.getMessage();
					}

					int countSum_tDBOutput_1 = 0;
					for (int countEach_tDBOutput_1 : e_tDBOutput_1.getUpdateCounts()) {
						countSum_tDBOutput_1 += (countEach_tDBOutput_1 < 0 ? 0 : countEach_tDBOutput_1);
					}
					rowsToCommitCount_tDBOutput_1 += countSum_tDBOutput_1;

					deletedCount_tDBOutput_1 += countSum_tDBOutput_1;

					log.error("tDBOutput_1 - " + (errormessage_tDBOutput_1));
					System.err.println(errormessage_tDBOutput_1);

				}

				if (pstmt_tDBOutput_1 != null) {

					pstmt_tDBOutput_1.close();
					resourceMap.remove("pstmt_tDBOutput_1");
				}
				resourceMap.put("statementClosed_tDBOutput_1", true);

				nb_line_deleted_tDBOutput_1 = nb_line_deleted_tDBOutput_1 + deletedCount_tDBOutput_1;
				nb_line_update_tDBOutput_1 = nb_line_update_tDBOutput_1 + updatedCount_tDBOutput_1;
				nb_line_inserted_tDBOutput_1 = nb_line_inserted_tDBOutput_1 + insertedCount_tDBOutput_1;
				nb_line_rejected_tDBOutput_1 = nb_line_rejected_tDBOutput_1 + rejectedCount_tDBOutput_1;

				globalMap.put("tDBOutput_1_NB_LINE", nb_line_tDBOutput_1);
				globalMap.put("tDBOutput_1_NB_LINE_UPDATED", nb_line_update_tDBOutput_1);
				globalMap.put("tDBOutput_1_NB_LINE_INSERTED", nb_line_inserted_tDBOutput_1);
				globalMap.put("tDBOutput_1_NB_LINE_DELETED", nb_line_deleted_tDBOutput_1);
				globalMap.put("tDBOutput_1_NB_LINE_REJECTED", nb_line_rejected_tDBOutput_1);

				if (log.isDebugEnabled())
					log.debug("tDBOutput_1 - " + ("Has ") + ("deleted") + (" ") + (nb_line_deleted_tDBOutput_1)
							+ (" record(s)."));

				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "row1");
				}

				if (log.isDebugEnabled())
					log.debug("tDBOutput_1 - " + ("Done."));

				ok_Hash.put("tDBOutput_1", true);
				end_Hash.put("tDBOutput_1", System.currentTimeMillis());

				if (((Integer) globalMap.get("tDBOutput_1_NB_LINE_DELETED")) > 0) {

					if (execStat) {
						runStat.updateStatOnConnection("If2", 0, "true");
					}
					tFixedFlowInput_4Process(globalMap);
				}

				else {
					if (execStat) {
						runStat.updateStatOnConnection("If2", 0, "false");
					}
				}
				if (((Integer) globalMap.get("tDBOutput_1_NB_LINE_DELETED")) == 0) {

					if (execStat) {
						runStat.updateStatOnConnection("If4", 0, "true");
					}
					tSetGlobalVar_3Process(globalMap);
				}

				else {
					if (execStat) {
						runStat.updateStatOnConnection("If4", 0, "false");
					}
				}

				/**
				 * [tDBOutput_1 end ] stop
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
				 * [tDBOutput_1 finally ] start
				 */

				currentComponent = "tDBOutput_1";

				if (resourceMap.get("statementClosed_tDBOutput_1") == null) {
					java.sql.PreparedStatement pstmtToClose_tDBOutput_1 = null;
					if ((pstmtToClose_tDBOutput_1 = (java.sql.PreparedStatement) resourceMap
							.remove("pstmt_tDBOutput_1")) != null) {
						pstmtToClose_tDBOutput_1.close();
					}
				}

				/**
				 * [tDBOutput_1 finally ] stop
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

	public static class row6Struct implements routines.system.IPersistableRow<row6Struct> {
		final static byte[] commonByteArrayLock_SALESFORCE_DeleteDb = new byte[0];
		static byte[] commonByteArray_SALESFORCE_DeleteDb = new byte[0];

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
				if (length > commonByteArray_SALESFORCE_DeleteDb.length) {
					if (length < 1024 && commonByteArray_SALESFORCE_DeleteDb.length == 0) {
						commonByteArray_SALESFORCE_DeleteDb = new byte[1024];
					} else {
						commonByteArray_SALESFORCE_DeleteDb = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_SALESFORCE_DeleteDb, 0, length);
				strReturn = new String(commonByteArray_SALESFORCE_DeleteDb, 0, length, utf8Charset);
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
				if (length > commonByteArray_SALESFORCE_DeleteDb.length) {
					if (length < 1024 && commonByteArray_SALESFORCE_DeleteDb.length == 0) {
						commonByteArray_SALESFORCE_DeleteDb = new byte[1024];
					} else {
						commonByteArray_SALESFORCE_DeleteDb = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_SALESFORCE_DeleteDb, 0, length);
				strReturn = new String(commonByteArray_SALESFORCE_DeleteDb, 0, length, utf8Charset);
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

			synchronized (commonByteArrayLock_SALESFORCE_DeleteDb) {

				try {

					int length = 0;

					this.body = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_SALESFORCE_DeleteDb) {

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

	public void tFixedFlowInput_4Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tFixedFlowInput_4_SUBPROCESS_STATE", 0);

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

				row6Struct row6 = new row6Struct();

				/**
				 * [tRESTResponse_1 begin ] start
				 */

				ok_Hash.put("tRESTResponse_1", false);
				start_Hash.put("tRESTResponse_1", System.currentTimeMillis());

				currentComponent = "tRESTResponse_1";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "row6");
				}

				int tos_count_tRESTResponse_1 = 0;

				/**
				 * [tRESTResponse_1 begin ] stop
				 */

				/**
				 * [tFixedFlowInput_4 begin ] start
				 */

				ok_Hash.put("tFixedFlowInput_4", false);
				start_Hash.put("tFixedFlowInput_4", System.currentTimeMillis());

				currentComponent = "tFixedFlowInput_4";

				int tos_count_tFixedFlowInput_4 = 0;

				for (int i_tFixedFlowInput_4 = 0; i_tFixedFlowInput_4 < 1; i_tFixedFlowInput_4++) {

					row6.body = "{\"deleted\": true}";

					/**
					 * [tFixedFlowInput_4 begin ] stop
					 */

					/**
					 * [tFixedFlowInput_4 main ] start
					 */

					currentComponent = "tFixedFlowInput_4";

					tos_count_tFixedFlowInput_4++;

					/**
					 * [tFixedFlowInput_4 main ] stop
					 */

					/**
					 * [tFixedFlowInput_4 process_data_begin ] start
					 */

					currentComponent = "tFixedFlowInput_4";

					/**
					 * [tFixedFlowInput_4 process_data_begin ] stop
					 */

					/**
					 * [tRESTResponse_1 main ] start
					 */

					currentComponent = "tRESTResponse_1";

					if (execStat) {
						runStat.updateStatOnConnection(iterateId, 1, 1

								, "row6"

						);
					}

					if (log.isTraceEnabled()) {
						log.trace("row6 - " + (row6 == null ? "" : row6.toLogString()));
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
						restProviderResponse_tRESTResponse_1 = row6.body;

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
							restResponse_tRESTResponse_1.put("HEADERS", restProviderResponseHeaders_tRESTResponse_1);
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
									responseMediaType_tRESTResponse_1 = messageContext_tRESTResponse_1.getHttpHeaders()
											.getAcceptableMediaTypes().get(0);
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

					/**
					 * [tFixedFlowInput_4 process_data_end ] start
					 */

					currentComponent = "tFixedFlowInput_4";

					/**
					 * [tFixedFlowInput_4 process_data_end ] stop
					 */

					/**
					 * [tFixedFlowInput_4 end ] start
					 */

					currentComponent = "tFixedFlowInput_4";

				}
				globalMap.put("tFixedFlowInput_4_NB_LINE", 1);

				ok_Hash.put("tFixedFlowInput_4", true);
				end_Hash.put("tFixedFlowInput_4", System.currentTimeMillis());

				/**
				 * [tFixedFlowInput_4 end ] stop
				 */

				/**
				 * [tRESTResponse_1 end ] start
				 */

				currentComponent = "tRESTResponse_1";

				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "row6");
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
				 * [tFixedFlowInput_4 finally ] start
				 */

				currentComponent = "tFixedFlowInput_4";

				/**
				 * [tFixedFlowInput_4 finally ] stop
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

		globalMap.put("tFixedFlowInput_4_SUBPROCESS_STATE", 1);
	}

	public void tSetGlobalVar_3Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tSetGlobalVar_3_SUBPROCESS_STATE", 0);

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
				 * [tSetGlobalVar_3 begin ] start
				 */

				ok_Hash.put("tSetGlobalVar_3", false);
				start_Hash.put("tSetGlobalVar_3", System.currentTimeMillis());

				currentComponent = "tSetGlobalVar_3";

				int tos_count_tSetGlobalVar_3 = 0;

				if (log.isDebugEnabled())
					log.debug("tSetGlobalVar_3 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tSetGlobalVar_3 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tSetGlobalVar_3 = new StringBuilder();
							log4jParamters_tSetGlobalVar_3.append("Parameters:");
							log4jParamters_tSetGlobalVar_3.append("VARIABLES" + " = " + "[{VALUE=" + ("404") + ", KEY="
									+ ("\"httpCode\"") + "}, {VALUE=" + ("\"Product not found \"") + ", KEY="
									+ ("\"cause_message\"") + "}]");
							log4jParamters_tSetGlobalVar_3.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tSetGlobalVar_3 - " + (log4jParamters_tSetGlobalVar_3));
						}
					}
					new BytesLimit65535_tSetGlobalVar_3().limitLog4jByte();
				}

				/**
				 * [tSetGlobalVar_3 begin ] stop
				 */

				/**
				 * [tSetGlobalVar_3 main ] start
				 */

				currentComponent = "tSetGlobalVar_3";

				globalMap.put("httpCode", 404);
				globalMap.put("cause_message", "Product not found ");

				tos_count_tSetGlobalVar_3++;

				/**
				 * [tSetGlobalVar_3 main ] stop
				 */

				/**
				 * [tSetGlobalVar_3 process_data_begin ] start
				 */

				currentComponent = "tSetGlobalVar_3";

				/**
				 * [tSetGlobalVar_3 process_data_begin ] stop
				 */

				/**
				 * [tSetGlobalVar_3 process_data_end ] start
				 */

				currentComponent = "tSetGlobalVar_3";

				/**
				 * [tSetGlobalVar_3 process_data_end ] stop
				 */

				/**
				 * [tSetGlobalVar_3 end ] start
				 */

				currentComponent = "tSetGlobalVar_3";

				if (log.isDebugEnabled())
					log.debug("tSetGlobalVar_3 - " + ("Done."));

				ok_Hash.put("tSetGlobalVar_3", true);
				end_Hash.put("tSetGlobalVar_3", System.currentTimeMillis());

				/**
				 * [tSetGlobalVar_3 end ] stop
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
				 * [tSetGlobalVar_3 finally ] start
				 */

				currentComponent = "tSetGlobalVar_3";

				/**
				 * [tSetGlobalVar_3 finally ] stop
				 */
			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tSetGlobalVar_3_SUBPROCESS_STATE", 1);
	}

	public void tJava_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tJava_1_SUBPROCESS_STATE", 0);

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
				 * [tJava_1 begin ] start
				 */

				ok_Hash.put("tJava_1", false);
				start_Hash.put("tJava_1", System.currentTimeMillis());

				currentComponent = "tJava_1";

				int tos_count_tJava_1 = 0;

				/**
				 * [tJava_1 begin ] stop
				 */

				/**
				 * [tJava_1 main ] start
				 */

				currentComponent = "tJava_1";

				tos_count_tJava_1++;

				/**
				 * [tJava_1 main ] stop
				 */

				/**
				 * [tJava_1 process_data_begin ] start
				 */

				currentComponent = "tJava_1";

				/**
				 * [tJava_1 process_data_begin ] stop
				 */

				/**
				 * [tJava_1 process_data_end ] start
				 */

				currentComponent = "tJava_1";

				/**
				 * [tJava_1 process_data_end ] stop
				 */

				/**
				 * [tJava_1 end ] start
				 */

				currentComponent = "tJava_1";

				ok_Hash.put("tJava_1", true);
				end_Hash.put("tJava_1", System.currentTimeMillis());

				if (globalMap.get("httpCode") != null && globalMap.get("httpCode") != "") {

					if (execStat) {
						runStat.updateStatOnConnection("If5", 0, "true");
					}
					tFixedFlowInput_3Process(globalMap);
				}

				else {
					if (execStat) {
						runStat.updateStatOnConnection("If5", 0, "false");
					}
				}

				/**
				 * [tJava_1 end ] stop
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
				 * [tJava_1 finally ] start
				 */

				currentComponent = "tJava_1";

				/**
				 * [tJava_1 finally ] stop
				 */
			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tJava_1_SUBPROCESS_STATE", 1);
	}

	public static class copyOfbodyStruct implements routines.system.IPersistableRow<copyOfbodyStruct> {
		final static byte[] commonByteArrayLock_SALESFORCE_DeleteDb = new byte[0];
		static byte[] commonByteArray_SALESFORCE_DeleteDb = new byte[0];

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
				if (length > commonByteArray_SALESFORCE_DeleteDb.length) {
					if (length < 1024 && commonByteArray_SALESFORCE_DeleteDb.length == 0) {
						commonByteArray_SALESFORCE_DeleteDb = new byte[1024];
					} else {
						commonByteArray_SALESFORCE_DeleteDb = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_SALESFORCE_DeleteDb, 0, length);
				strReturn = new String(commonByteArray_SALESFORCE_DeleteDb, 0, length, utf8Charset);
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
				if (length > commonByteArray_SALESFORCE_DeleteDb.length) {
					if (length < 1024 && commonByteArray_SALESFORCE_DeleteDb.length == 0) {
						commonByteArray_SALESFORCE_DeleteDb = new byte[1024];
					} else {
						commonByteArray_SALESFORCE_DeleteDb = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_SALESFORCE_DeleteDb, 0, length);
				strReturn = new String(commonByteArray_SALESFORCE_DeleteDb, 0, length, utf8Charset);
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

			synchronized (commonByteArrayLock_SALESFORCE_DeleteDb) {

				try {

					int length = 0;

					this.body = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_SALESFORCE_DeleteDb) {

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
		public int compareTo(copyOfbodyStruct other) {

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

	public static class copyOferror_map_outStruct
			implements routines.system.IPersistableRow<copyOferror_map_outStruct> {
		final static byte[] commonByteArrayLock_SALESFORCE_DeleteDb = new byte[0];
		static byte[] commonByteArray_SALESFORCE_DeleteDb = new byte[0];

		public Integer httpCode;

		public Integer getHttpCode() {
			return this.httpCode;
		}

		public String error_errorCode;

		public String getError_errorCode() {
			return this.error_errorCode;
		}

		public String error_message;

		public String getError_message() {
			return this.error_message;
		}

		public String error_informations;

		public String getError_informations() {
			return this.error_informations;
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
				if (length > commonByteArray_SALESFORCE_DeleteDb.length) {
					if (length < 1024 && commonByteArray_SALESFORCE_DeleteDb.length == 0) {
						commonByteArray_SALESFORCE_DeleteDb = new byte[1024];
					} else {
						commonByteArray_SALESFORCE_DeleteDb = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_SALESFORCE_DeleteDb, 0, length);
				strReturn = new String(commonByteArray_SALESFORCE_DeleteDb, 0, length, utf8Charset);
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
				if (length > commonByteArray_SALESFORCE_DeleteDb.length) {
					if (length < 1024 && commonByteArray_SALESFORCE_DeleteDb.length == 0) {
						commonByteArray_SALESFORCE_DeleteDb = new byte[1024];
					} else {
						commonByteArray_SALESFORCE_DeleteDb = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_SALESFORCE_DeleteDb, 0, length);
				strReturn = new String(commonByteArray_SALESFORCE_DeleteDb, 0, length, utf8Charset);
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

			synchronized (commonByteArrayLock_SALESFORCE_DeleteDb) {

				try {

					int length = 0;

					this.httpCode = readInteger(dis);

					this.error_errorCode = readString(dis);

					this.error_message = readString(dis);

					this.error_informations = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_SALESFORCE_DeleteDb) {

				try {

					int length = 0;

					this.httpCode = readInteger(dis);

					this.error_errorCode = readString(dis);

					this.error_message = readString(dis);

					this.error_informations = readString(dis);

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

				writeString(this.error_errorCode, dos);

				// String

				writeString(this.error_message, dos);

				// String

				writeString(this.error_informations, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// Integer

				writeInteger(this.httpCode, dos);

				// String

				writeString(this.error_errorCode, dos);

				// String

				writeString(this.error_message, dos);

				// String

				writeString(this.error_informations, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("httpCode=" + String.valueOf(httpCode));
			sb.append(",error_errorCode=" + error_errorCode);
			sb.append(",error_message=" + error_message);
			sb.append(",error_informations=" + error_informations);
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

			if (error_errorCode == null) {
				sb.append("<null>");
			} else {
				sb.append(error_errorCode);
			}

			sb.append("|");

			if (error_message == null) {
				sb.append("<null>");
			} else {
				sb.append(error_message);
			}

			sb.append("|");

			if (error_informations == null) {
				sb.append("<null>");
			} else {
				sb.append(error_informations);
			}

			sb.append("|");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(copyOferror_map_outStruct other) {

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
		final static byte[] commonByteArrayLock_SALESFORCE_DeleteDb = new byte[0];
		static byte[] commonByteArray_SALESFORCE_DeleteDb = new byte[0];

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
				if (length > commonByteArray_SALESFORCE_DeleteDb.length) {
					if (length < 1024 && commonByteArray_SALESFORCE_DeleteDb.length == 0) {
						commonByteArray_SALESFORCE_DeleteDb = new byte[1024];
					} else {
						commonByteArray_SALESFORCE_DeleteDb = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_SALESFORCE_DeleteDb, 0, length);
				strReturn = new String(commonByteArray_SALESFORCE_DeleteDb, 0, length, utf8Charset);
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
				if (length > commonByteArray_SALESFORCE_DeleteDb.length) {
					if (length < 1024 && commonByteArray_SALESFORCE_DeleteDb.length == 0) {
						commonByteArray_SALESFORCE_DeleteDb = new byte[1024];
					} else {
						commonByteArray_SALESFORCE_DeleteDb = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_SALESFORCE_DeleteDb, 0, length);
				strReturn = new String(commonByteArray_SALESFORCE_DeleteDb, 0, length, utf8Charset);
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

			synchronized (commonByteArrayLock_SALESFORCE_DeleteDb) {

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

			synchronized (commonByteArrayLock_SALESFORCE_DeleteDb) {

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

	public static class after_tFixedFlowInput_3Struct
			implements routines.system.IPersistableRow<after_tFixedFlowInput_3Struct> {
		final static byte[] commonByteArrayLock_SALESFORCE_DeleteDb = new byte[0];
		static byte[] commonByteArray_SALESFORCE_DeleteDb = new byte[0];

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
				if (length > commonByteArray_SALESFORCE_DeleteDb.length) {
					if (length < 1024 && commonByteArray_SALESFORCE_DeleteDb.length == 0) {
						commonByteArray_SALESFORCE_DeleteDb = new byte[1024];
					} else {
						commonByteArray_SALESFORCE_DeleteDb = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_SALESFORCE_DeleteDb, 0, length);
				strReturn = new String(commonByteArray_SALESFORCE_DeleteDb, 0, length, utf8Charset);
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
				if (length > commonByteArray_SALESFORCE_DeleteDb.length) {
					if (length < 1024 && commonByteArray_SALESFORCE_DeleteDb.length == 0) {
						commonByteArray_SALESFORCE_DeleteDb = new byte[1024];
					} else {
						commonByteArray_SALESFORCE_DeleteDb = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_SALESFORCE_DeleteDb, 0, length);
				strReturn = new String(commonByteArray_SALESFORCE_DeleteDb, 0, length, utf8Charset);
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

			synchronized (commonByteArrayLock_SALESFORCE_DeleteDb) {

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

			synchronized (commonByteArrayLock_SALESFORCE_DeleteDb) {

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
		public int compareTo(after_tFixedFlowInput_3Struct other) {

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

				tFileInputDelimited_2Process(globalMap);

				row4Struct row4 = new row4Struct();
				copyOferror_map_outStruct copyOferror_map_out = new copyOferror_map_outStruct();
				copyOfbodyStruct copyOfbody = new copyOfbodyStruct();

				/**
				 * [tRESTResponse_4 begin ] start
				 */

				ok_Hash.put("tRESTResponse_4", false);
				start_Hash.put("tRESTResponse_4", System.currentTimeMillis());

				currentComponent = "tRESTResponse_4";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "copyOfbody");
				}

				int tos_count_tRESTResponse_4 = 0;

				/**
				 * [tRESTResponse_4 begin ] stop
				 */

				/**
				 * [tMap_5 begin ] start
				 */

				ok_Hash.put("tMap_5", false);
				start_Hash.put("tMap_5", System.currentTimeMillis());

				currentComponent = "tMap_5";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "copyOferror_map_out");
				}

				int tos_count_tMap_5 = 0;

				if (log.isDebugEnabled())
					log.debug("tMap_5 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tMap_5 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tMap_5 = new StringBuilder();
							log4jParamters_tMap_5.append("Parameters:");
							log4jParamters_tMap_5.append("LINK_STYLE" + " = " + "AUTO");
							log4jParamters_tMap_5.append(" | ");
							log4jParamters_tMap_5.append("TEMPORARY_DATA_DIRECTORY" + " = " + "");
							log4jParamters_tMap_5.append(" | ");
							log4jParamters_tMap_5.append("ROWS_BUFFER_SIZE" + " = " + "2000000");
							log4jParamters_tMap_5.append(" | ");
							log4jParamters_tMap_5.append("CHANGE_HASH_AND_EQUALS_FOR_BIGDECIMAL" + " = " + "true");
							log4jParamters_tMap_5.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tMap_5 - " + (log4jParamters_tMap_5));
						}
					}
					new BytesLimit65535_tMap_5().limitLog4jByte();
				}

// ###############################
// # Lookup's keys initialization
				int count_copyOferror_map_out_tMap_5 = 0;

// ###############################        

// ###############################
// # Vars initialization
				class Var__tMap_5__Struct {
					String var1;
				}
				Var__tMap_5__Struct Var__tMap_5 = new Var__tMap_5__Struct();
// ###############################

// ###############################
// # Outputs initialization
				int count_copyOfbody_tMap_5 = 0;

				copyOfbodyStruct copyOfbody_tmp = new copyOfbodyStruct();
// ###############################

				/**
				 * [tMap_5 begin ] stop
				 */

				/**
				 * [tMap_4 begin ] start
				 */

				ok_Hash.put("tMap_4", false);
				start_Hash.put("tMap_4", System.currentTimeMillis());

				currentComponent = "tMap_4";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "row4");
				}

				int tos_count_tMap_4 = 0;

				if (log.isDebugEnabled())
					log.debug("tMap_4 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tMap_4 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tMap_4 = new StringBuilder();
							log4jParamters_tMap_4.append("Parameters:");
							log4jParamters_tMap_4.append("LINK_STYLE" + " = " + "AUTO");
							log4jParamters_tMap_4.append(" | ");
							log4jParamters_tMap_4.append("TEMPORARY_DATA_DIRECTORY" + " = " + "");
							log4jParamters_tMap_4.append(" | ");
							log4jParamters_tMap_4.append("ROWS_BUFFER_SIZE" + " = " + "2000000");
							log4jParamters_tMap_4.append(" | ");
							log4jParamters_tMap_4.append("CHANGE_HASH_AND_EQUALS_FOR_BIGDECIMAL" + " = " + "true");
							log4jParamters_tMap_4.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tMap_4 - " + (log4jParamters_tMap_4));
						}
					}
					new BytesLimit65535_tMap_4().limitLog4jByte();
				}

// ###############################
// # Lookup's keys initialization
				int count_row4_tMap_4 = 0;

				int count_row8_tMap_4 = 0;

				org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row8Struct> tHash_Lookup_row8 = (org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row8Struct>) ((org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row8Struct>) globalMap
						.get("tHash_Lookup_row8"));

				row8Struct row8HashKey = new row8Struct();
				row8Struct row8Default = new row8Struct();
// ###############################        

// ###############################
// # Vars initialization
				class Var__tMap_4__Struct {
				}
				Var__tMap_4__Struct Var__tMap_4 = new Var__tMap_4__Struct();
// ###############################

// ###############################
// # Outputs initialization
				int count_copyOferror_map_out_tMap_4 = 0;

				copyOferror_map_outStruct copyOferror_map_out_tmp = new copyOferror_map_outStruct();
// ###############################

				/**
				 * [tMap_4 begin ] stop
				 */

				/**
				 * [tFixedFlowInput_3 begin ] start
				 */

				ok_Hash.put("tFixedFlowInput_3", false);
				start_Hash.put("tFixedFlowInput_3", System.currentTimeMillis());

				currentComponent = "tFixedFlowInput_3";

				int tos_count_tFixedFlowInput_3 = 0;

				for (int i_tFixedFlowInput_3 = 0; i_tFixedFlowInput_3 < 1; i_tFixedFlowInput_3++) {

					row4.httpCode = ((Integer) globalMap.get("httpCode"));

					row4.error_message = ((String) globalMap.get("cause_message"));

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
					 * [tMap_4 main ] start
					 */

					currentComponent = "tMap_4";

					if (execStat) {
						runStat.updateStatOnConnection(iterateId, 1, 1

								, "row4"

						);
					}

					if (log.isTraceEnabled()) {
						log.trace("row4 - " + (row4 == null ? "" : row4.toLogString()));
					}

					boolean hasCasePrimitiveKeyWithNull_tMap_4 = false;

					// ###############################
					// # Input tables (lookups)
					boolean rejectedInnerJoin_tMap_4 = false;
					boolean mainRowRejected_tMap_4 = false;

					///////////////////////////////////////////////
					// Starting Lookup Table "row8"
					///////////////////////////////////////////////

					boolean forceLooprow8 = false;

					row8Struct row8ObjectFromLookup = null;

					if (!rejectedInnerJoin_tMap_4) { // G_TM_M_020

						hasCasePrimitiveKeyWithNull_tMap_4 = false;

						row8HashKey.HTTP = row4.httpCode;

						row8HashKey.hashCodeDirty = true;

						tHash_Lookup_row8.lookup(row8HashKey);

						if (!tHash_Lookup_row8.hasNext()) { // G_TM_M_090

							rejectedInnerJoin_tMap_4 = true;

						} // G_TM_M_090

					} // G_TM_M_020

					if (tHash_Lookup_row8 != null && tHash_Lookup_row8.getCount(row8HashKey) > 1) { // G 071

						// System.out.println("WARNING: UNIQUE MATCH is configured for the lookup 'row8'
						// and it contains more one result from keys : row8.HTTP = '" + row8HashKey.HTTP
						// + "'");
					} // G 071

					row8Struct row8 = null;

					row8Struct fromLookup_row8 = null;
					row8 = row8Default;

					if (tHash_Lookup_row8 != null && tHash_Lookup_row8.hasNext()) { // G 099

						fromLookup_row8 = tHash_Lookup_row8.next();

					} // G 099

					if (fromLookup_row8 != null) {
						row8 = fromLookup_row8;
					}

					// ###############################
					{ // start of Var scope

						// ###############################
						// # Vars tables

						Var__tMap_4__Struct Var = Var__tMap_4;// ###############################
						// ###############################
						// # Output tables

						copyOferror_map_out = null;

						if (!rejectedInnerJoin_tMap_4) {

// # Output table : 'copyOferror_map_out'
							count_copyOferror_map_out_tMap_4++;

							copyOferror_map_out_tmp.httpCode = row4.httpCode;
							copyOferror_map_out_tmp.error_errorCode = row8.CODE;
							copyOferror_map_out_tmp.error_message = row8.MESSAGE;
							copyOferror_map_out_tmp.error_informations = row8.INFORMATIONS;
							copyOferror_map_out = copyOferror_map_out_tmp;
							log.debug("tMap_4 - Outputting the record " + count_copyOferror_map_out_tMap_4
									+ " of the output table 'copyOferror_map_out'.");

						} // closing inner join bracket (2)
// ###############################

					} // end of Var scope

					rejectedInnerJoin_tMap_4 = false;

					tos_count_tMap_4++;

					/**
					 * [tMap_4 main ] stop
					 */

					/**
					 * [tMap_4 process_data_begin ] start
					 */

					currentComponent = "tMap_4";

					/**
					 * [tMap_4 process_data_begin ] stop
					 */
// Start of branch "copyOferror_map_out"
					if (copyOferror_map_out != null) {

						/**
						 * [tMap_5 main ] start
						 */

						currentComponent = "tMap_5";

						if (execStat) {
							runStat.updateStatOnConnection(iterateId, 1, 1

									, "copyOferror_map_out"

							);
						}

						if (log.isTraceEnabled()) {
							log.trace("copyOferror_map_out - "
									+ (copyOferror_map_out == null ? "" : copyOferror_map_out.toLogString()));
						}

						boolean hasCasePrimitiveKeyWithNull_tMap_5 = false;

						// ###############################
						// # Input tables (lookups)
						boolean rejectedInnerJoin_tMap_5 = false;
						boolean mainRowRejected_tMap_5 = false;

						// ###############################
						{ // start of Var scope

							// ###############################
							// # Vars tables

							Var__tMap_5__Struct Var = Var__tMap_5;
							Var.var1 = "{" + "\n\t\t\t\t\"errorCode\":\"" + copyOferror_map_out.error_errorCode + "\","
									+ "\n\t\t\t\t\"errorMessage\":\""
									+ copyOferror_map_out.error_message.replaceAll("\n", "") + "\","
									+ "\n\t\t\t\t\"errorInformation\":\"" + copyOferror_map_out.error_informations
									+ "\"" + "}";// ###############################
													// ###############################
													// # Output tables

							copyOfbody = null;

// # Output table : 'copyOfbody'
							count_copyOfbody_tMap_5++;

							copyOfbody_tmp.body = Var.var1;
							copyOfbody = copyOfbody_tmp;
							log.debug("tMap_5 - Outputting the record " + count_copyOfbody_tMap_5
									+ " of the output table 'copyOfbody'.");

// ###############################

						} // end of Var scope

						rejectedInnerJoin_tMap_5 = false;

						tos_count_tMap_5++;

						/**
						 * [tMap_5 main ] stop
						 */

						/**
						 * [tMap_5 process_data_begin ] start
						 */

						currentComponent = "tMap_5";

						/**
						 * [tMap_5 process_data_begin ] stop
						 */
// Start of branch "copyOfbody"
						if (copyOfbody != null) {

							/**
							 * [tRESTResponse_4 main ] start
							 */

							currentComponent = "tRESTResponse_4";

							if (execStat) {
								runStat.updateStatOnConnection(iterateId, 1, 1

										, "copyOfbody"

								);
							}

							if (log.isTraceEnabled()) {
								log.trace("copyOfbody - " + (copyOfbody == null ? "" : copyOfbody.toLogString()));
							}

							java.io.OutputStream outputStream_tRESTResponse_4 = (java.io.OutputStream) globalMap
									.get("restResponseStream");
							boolean responseAlreadySent_tRESTResponse_4 = globalMap.containsKey("restResponse");

							if (null == outputStream_tRESTResponse_4 && responseAlreadySent_tRESTResponse_4) {
								throw new RuntimeException("Rest response already sent.");
							} else if (!globalMap.containsKey("restRequest")) {
								throw new RuntimeException("Not received rest request yet.");
							} else {
								Integer restProviderStatusCode_tRESTResponse_4 = (Integer) globalMap.get("httpCode");

								Object restProviderResponse_tRESTResponse_4 = null;
								restProviderResponse_tRESTResponse_4 = copyOfbody.body;

								java.util.Map<String, String> restProviderResponseHeaders_tRESTResponse_4 = new java.util.TreeMap<String, String>(
										String.CASE_INSENSITIVE_ORDER);
								java.lang.StringBuilder restProviderResponseHeader_cookies_tRESTResponse_4 = new java.lang.StringBuilder();
								final String setCookieHeader = "Set-Cookie";

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
									restResponse_tRESTResponse_4.put("HEADERS",
											restProviderResponseHeaders_tRESTResponse_4);
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
											currentMessage.getExchange()
													.put(StreamingDOM4JProvider.SUPRESS_XML_DECLARATION, true);
										}

										messageContext_tRESTResponse_4.put(org.apache.cxf.message.Message.RESPONSE_CODE,
												restProviderStatusCode_tRESTResponse_4);
										javax.ws.rs.core.MultivaluedMap<String, String> headersMultivaluedMap_tRESTResponse_4 = new org.apache.cxf.jaxrs.impl.MetadataMap<String, String>();
										for (java.util.Map.Entry<String, String> multivaluedHeader : restProviderResponseHeaders_tRESTResponse_4
												.entrySet()) {
											headersMultivaluedMap_tRESTResponse_4.putSingle(multivaluedHeader.getKey(),
													multivaluedHeader.getValue());
										}
										messageContext_tRESTResponse_4.put(
												org.apache.cxf.message.Message.PROTOCOL_HEADERS,
												headersMultivaluedMap_tRESTResponse_4);

										String responseContentType_tRESTResponse_4 = null;

										if (currentMessage != null && currentMessage.getExchange() != null) {
											responseContentType_tRESTResponse_4 = (String) currentMessage.getExchange()
													.get(org.apache.cxf.message.Message.CONTENT_TYPE);
										}

										if (null == responseContentType_tRESTResponse_4) {
											// this should not be needed, just in case. set it to the first value in the
											// sorted list returned from HttpHeaders
											responseMediaType_tRESTResponse_4 = messageContext_tRESTResponse_4
													.getHttpHeaders().getAcceptableMediaTypes().get(0);
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
												new java.lang.annotation.Annotation[] {},
												responseMediaType_tRESTResponse_4, null, outputStream_tRESTResponse_4);
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

						} // End of branch "copyOfbody"

						/**
						 * [tMap_5 process_data_end ] start
						 */

						currentComponent = "tMap_5";

						/**
						 * [tMap_5 process_data_end ] stop
						 */

					} // End of branch "copyOferror_map_out"

					/**
					 * [tMap_4 process_data_end ] start
					 */

					currentComponent = "tMap_4";

					/**
					 * [tMap_4 process_data_end ] stop
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
				 * [tMap_4 end ] start
				 */

				currentComponent = "tMap_4";

// ###############################
// # Lookup hashes releasing
				if (tHash_Lookup_row8 != null) {
					tHash_Lookup_row8.endGet();
				}
				globalMap.remove("tHash_Lookup_row8");

// ###############################      
				log.debug("tMap_4 - Written records count in the table 'copyOferror_map_out': "
						+ count_copyOferror_map_out_tMap_4 + ".");

				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "row4");
				}

				if (log.isDebugEnabled())
					log.debug("tMap_4 - " + ("Done."));

				ok_Hash.put("tMap_4", true);
				end_Hash.put("tMap_4", System.currentTimeMillis());

				/**
				 * [tMap_4 end ] stop
				 */

				/**
				 * [tMap_5 end ] start
				 */

				currentComponent = "tMap_5";

// ###############################
// # Lookup hashes releasing
// ###############################      
				log.debug("tMap_5 - Written records count in the table 'copyOfbody': " + count_copyOfbody_tMap_5 + ".");

				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "copyOferror_map_out");
				}

				if (log.isDebugEnabled())
					log.debug("tMap_5 - " + ("Done."));

				ok_Hash.put("tMap_5", true);
				end_Hash.put("tMap_5", System.currentTimeMillis());

				/**
				 * [tMap_5 end ] stop
				 */

				/**
				 * [tRESTResponse_4 end ] start
				 */

				currentComponent = "tRESTResponse_4";

				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "copyOfbody");
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

			// free memory for "tMap_4"
			globalMap.remove("tHash_Lookup_row8");

			try {

				/**
				 * [tFixedFlowInput_3 finally ] start
				 */

				currentComponent = "tFixedFlowInput_3";

				/**
				 * [tFixedFlowInput_3 finally ] stop
				 */

				/**
				 * [tMap_4 finally ] start
				 */

				currentComponent = "tMap_4";

				/**
				 * [tMap_4 finally ] stop
				 */

				/**
				 * [tMap_5 finally ] start
				 */

				currentComponent = "tMap_5";

				/**
				 * [tMap_5 finally ] stop
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

		globalMap.put("tFixedFlowInput_3_SUBPROCESS_STATE", 1);
	}

	public static class row8Struct implements routines.system.IPersistableComparableLookupRow<row8Struct> {
		final static byte[] commonByteArrayLock_SALESFORCE_DeleteDb = new byte[0];
		static byte[] commonByteArray_SALESFORCE_DeleteDb = new byte[0];
		protected static final int DEFAULT_HASHCODE = 1;
		protected static final int PRIME = 31;
		protected int hashCode = DEFAULT_HASHCODE;
		public boolean hashCodeDirty = true;

		public String loopKey;

		public String CODE;

		public String getCODE() {
			return this.CODE;
		}

		public Integer HTTP;

		public Integer getHTTP() {
			return this.HTTP;
		}

		public String MESSAGE;

		public String getMESSAGE() {
			return this.MESSAGE;
		}

		public String INFORMATIONS;

		public String getINFORMATIONS() {
			return this.INFORMATIONS;
		}

		@Override
		public int hashCode() {
			if (this.hashCodeDirty) {
				final int prime = PRIME;
				int result = DEFAULT_HASHCODE;

				result = prime * result + ((this.HTTP == null) ? 0 : this.HTTP.hashCode());

				this.hashCode = result;
				this.hashCodeDirty = false;
			}
			return this.hashCode;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			final row8Struct other = (row8Struct) obj;

			if (this.HTTP == null) {
				if (other.HTTP != null)
					return false;

			} else if (!this.HTTP.equals(other.HTTP))

				return false;

			return true;
		}

		public void copyDataTo(row8Struct other) {

			other.CODE = this.CODE;
			other.HTTP = this.HTTP;
			other.MESSAGE = this.MESSAGE;
			other.INFORMATIONS = this.INFORMATIONS;

		}

		public void copyKeysDataTo(row8Struct other) {

			other.HTTP = this.HTTP;

		}

		private String readString(DataInputStream dis, ObjectInputStream ois) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				byte[] byteArray = new byte[length];
				dis.read(byteArray);
				strReturn = new String(byteArray, utf8Charset);
			}
			return strReturn;
		}

		private String readString(DataInputStream dis, org.jboss.marshalling.Unmarshaller unmarshaller)
				throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				byte[] byteArray = new byte[length];
				unmarshaller.read(byteArray);
				strReturn = new String(byteArray, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, DataOutputStream dos, org.jboss.marshalling.Marshaller marshaller)
				throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		private void writeString(String str, DataOutputStream dos, ObjectOutputStream oos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
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

		public void readKeysData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_SALESFORCE_DeleteDb) {

				try {

					int length = 0;

					this.HTTP = readInteger(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readKeysData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_SALESFORCE_DeleteDb) {

				try {

					int length = 0;

					this.HTTP = readInteger(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeKeysData(ObjectOutputStream dos) {
			try {

				// Integer

				writeInteger(this.HTTP, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeKeysData(org.jboss.marshalling.Marshaller dos) {
			try {

				// Integer

				writeInteger(this.HTTP, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		/**
		 * Fill Values data by reading ObjectInputStream.
		 */
		public void readValuesData(DataInputStream dis, ObjectInputStream ois) {
			try {

				int length = 0;

				this.CODE = readString(dis, ois);

				this.MESSAGE = readString(dis, ois);

				this.INFORMATIONS = readString(dis, ois);

			} catch (IOException e) {
				throw new RuntimeException(e);

			}

		}

		public void readValuesData(DataInputStream dis, org.jboss.marshalling.Unmarshaller objectIn) {
			try {
				int length = 0;

				this.CODE = readString(dis, objectIn);

				this.MESSAGE = readString(dis, objectIn);

				this.INFORMATIONS = readString(dis, objectIn);

			} catch (IOException e) {
				throw new RuntimeException(e);

			}

		}

		/**
		 * Return a byte array which represents Values data.
		 */
		public void writeValuesData(DataOutputStream dos, ObjectOutputStream oos) {
			try {

				writeString(this.CODE, dos, oos);

				writeString(this.MESSAGE, dos, oos);

				writeString(this.INFORMATIONS, dos, oos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeValuesData(DataOutputStream dos, org.jboss.marshalling.Marshaller objectOut) {
			try {

				writeString(this.CODE, dos, objectOut);

				writeString(this.MESSAGE, dos, objectOut);

				writeString(this.INFORMATIONS, dos, objectOut);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}

		public boolean supportMarshaller() {
			return true;
		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("CODE=" + CODE);
			sb.append(",HTTP=" + String.valueOf(HTTP));
			sb.append(",MESSAGE=" + MESSAGE);
			sb.append(",INFORMATIONS=" + INFORMATIONS);
			sb.append("]");

			return sb.toString();
		}

		public String toLogString() {
			StringBuilder sb = new StringBuilder();

			if (CODE == null) {
				sb.append("<null>");
			} else {
				sb.append(CODE);
			}

			sb.append("|");

			if (HTTP == null) {
				sb.append("<null>");
			} else {
				sb.append(HTTP);
			}

			sb.append("|");

			if (MESSAGE == null) {
				sb.append("<null>");
			} else {
				sb.append(MESSAGE);
			}

			sb.append("|");

			if (INFORMATIONS == null) {
				sb.append("<null>");
			} else {
				sb.append(INFORMATIONS);
			}

			sb.append("|");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(row8Struct other) {

			int returnValue = -1;

			returnValue = checkNullsAndCompare(this.HTTP, other.HTTP);
			if (returnValue != 0) {
				return returnValue;
			}

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

	public void tFileInputDelimited_2Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tFileInputDelimited_2_SUBPROCESS_STATE", 0);

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

				row8Struct row8 = new row8Struct();

				/**
				 * [tAdvancedHash_row8 begin ] start
				 */

				ok_Hash.put("tAdvancedHash_row8", false);
				start_Hash.put("tAdvancedHash_row8", System.currentTimeMillis());

				currentComponent = "tAdvancedHash_row8";

				if (execStat) {
					runStat.updateStatOnConnection(resourceMap, iterateId, 0, 0, "row8");
				}

				int tos_count_tAdvancedHash_row8 = 0;

				// connection name:row8
				// source node:tFileInputDelimited_2 - inputs:(after_tFixedFlowInput_3)
				// outputs:(row8,row8) | target node:tAdvancedHash_row8 - inputs:(row8)
				// outputs:()
				// linked node: tMap_4 - inputs:(row4,row8) outputs:(copyOferror_map_out)

				org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE matchingModeEnum_row8 = org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE.UNIQUE_MATCH;

				org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row8Struct> tHash_Lookup_row8 = org.talend.designer.components.lookup.memory.AdvancedMemoryLookup
						.<row8Struct>getLookup(matchingModeEnum_row8);

				globalMap.put("tHash_Lookup_row8", tHash_Lookup_row8);

				/**
				 * [tAdvancedHash_row8 begin ] stop
				 */

				/**
				 * [tFileInputDelimited_2 begin ] start
				 */

				ok_Hash.put("tFileInputDelimited_2", false);
				start_Hash.put("tFileInputDelimited_2", System.currentTimeMillis());

				currentComponent = "tFileInputDelimited_2";

				int tos_count_tFileInputDelimited_2 = 0;

				if (log.isDebugEnabled())
					log.debug("tFileInputDelimited_2 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tFileInputDelimited_2 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tFileInputDelimited_2 = new StringBuilder();
							log4jParamters_tFileInputDelimited_2.append("Parameters:");
							log4jParamters_tFileInputDelimited_2
									.append("FILENAME" + " = " + "context.csv_path+\"Error_Response_Handler.csv\"");
							log4jParamters_tFileInputDelimited_2.append(" | ");
							log4jParamters_tFileInputDelimited_2.append("CSV_OPTION" + " = " + "false");
							log4jParamters_tFileInputDelimited_2.append(" | ");
							log4jParamters_tFileInputDelimited_2.append("ROWSEPARATOR" + " = " + "\"\\n\"");
							log4jParamters_tFileInputDelimited_2.append(" | ");
							log4jParamters_tFileInputDelimited_2.append("FIELDSEPARATOR" + " = " + "\";\"");
							log4jParamters_tFileInputDelimited_2.append(" | ");
							log4jParamters_tFileInputDelimited_2.append("HEADER" + " = " + "1");
							log4jParamters_tFileInputDelimited_2.append(" | ");
							log4jParamters_tFileInputDelimited_2.append("FOOTER" + " = " + "0");
							log4jParamters_tFileInputDelimited_2.append(" | ");
							log4jParamters_tFileInputDelimited_2.append("LIMIT" + " = " + "");
							log4jParamters_tFileInputDelimited_2.append(" | ");
							log4jParamters_tFileInputDelimited_2.append("REMOVE_EMPTY_ROW" + " = " + "true");
							log4jParamters_tFileInputDelimited_2.append(" | ");
							log4jParamters_tFileInputDelimited_2.append("UNCOMPRESS" + " = " + "false");
							log4jParamters_tFileInputDelimited_2.append(" | ");
							log4jParamters_tFileInputDelimited_2.append("DIE_ON_ERROR" + " = " + "false");
							log4jParamters_tFileInputDelimited_2.append(" | ");
							log4jParamters_tFileInputDelimited_2.append("ADVANCED_SEPARATOR" + " = " + "false");
							log4jParamters_tFileInputDelimited_2.append(" | ");
							log4jParamters_tFileInputDelimited_2.append("RANDOM" + " = " + "false");
							log4jParamters_tFileInputDelimited_2.append(" | ");
							log4jParamters_tFileInputDelimited_2.append("TRIMALL" + " = " + "false");
							log4jParamters_tFileInputDelimited_2.append(" | ");
							log4jParamters_tFileInputDelimited_2.append("TRIMSELECT" + " = " + "[{TRIM=" + ("false")
									+ ", SCHEMA_COLUMN=" + ("CODE") + "}, {TRIM=" + ("false") + ", SCHEMA_COLUMN="
									+ ("HTTP") + "}, {TRIM=" + ("false") + ", SCHEMA_COLUMN=" + ("MESSAGE")
									+ "}, {TRIM=" + ("false") + ", SCHEMA_COLUMN=" + ("INFORMATIONS") + "}]");
							log4jParamters_tFileInputDelimited_2.append(" | ");
							log4jParamters_tFileInputDelimited_2.append("CHECK_FIELDS_NUM" + " = " + "false");
							log4jParamters_tFileInputDelimited_2.append(" | ");
							log4jParamters_tFileInputDelimited_2.append("CHECK_DATE" + " = " + "false");
							log4jParamters_tFileInputDelimited_2.append(" | ");
							log4jParamters_tFileInputDelimited_2.append("ENCODING" + " = " + "\"UTF-8\"");
							log4jParamters_tFileInputDelimited_2.append(" | ");
							log4jParamters_tFileInputDelimited_2.append("SPLITRECORD" + " = " + "false");
							log4jParamters_tFileInputDelimited_2.append(" | ");
							log4jParamters_tFileInputDelimited_2.append("ENABLE_DECODE" + " = " + "false");
							log4jParamters_tFileInputDelimited_2.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tFileInputDelimited_2 - " + (log4jParamters_tFileInputDelimited_2));
						}
					}
					new BytesLimit65535_tFileInputDelimited_2().limitLog4jByte();
				}

				final routines.system.RowState rowstate_tFileInputDelimited_2 = new routines.system.RowState();

				int nb_line_tFileInputDelimited_2 = 0;
				org.talend.fileprocess.FileInputDelimited fid_tFileInputDelimited_2 = null;
				int limit_tFileInputDelimited_2 = -1;
				try {

					Object filename_tFileInputDelimited_2 = context.csv_path + "Error_Response_Handler.csv";
					if (filename_tFileInputDelimited_2 instanceof java.io.InputStream) {

						int footer_value_tFileInputDelimited_2 = 0, random_value_tFileInputDelimited_2 = -1;
						if (footer_value_tFileInputDelimited_2 > 0 || random_value_tFileInputDelimited_2 > 0) {
							throw new java.lang.Exception(
									"When the input source is a stream,footer and random shouldn't be bigger than 0.");
						}

					}
					try {
						fid_tFileInputDelimited_2 = new org.talend.fileprocess.FileInputDelimited(
								context.csv_path + "Error_Response_Handler.csv", "UTF-8", ";", "\n", true, 1, 0,
								limit_tFileInputDelimited_2, -1, false);
					} catch (java.lang.Exception e) {
						globalMap.put("tFileInputDelimited_2_ERROR_MESSAGE", e.getMessage());

						log.error("tFileInputDelimited_2 - " + e.getMessage());

						System.err.println(e.getMessage());

					}

					log.info("tFileInputDelimited_2 - Retrieving records from the datasource.");

					while (fid_tFileInputDelimited_2 != null && fid_tFileInputDelimited_2.nextRecord()) {
						rowstate_tFileInputDelimited_2.reset();

						row8 = null;

						row8 = null;

						boolean whetherReject_tFileInputDelimited_2 = false;
						row8 = new row8Struct();
						try {

							int columnIndexWithD_tFileInputDelimited_2 = 0;

							String temp = "";

							columnIndexWithD_tFileInputDelimited_2 = 0;

							row8.CODE = fid_tFileInputDelimited_2.get(columnIndexWithD_tFileInputDelimited_2);

							columnIndexWithD_tFileInputDelimited_2 = 1;

							temp = fid_tFileInputDelimited_2.get(columnIndexWithD_tFileInputDelimited_2);
							if (temp.length() > 0) {

								try {

									row8.HTTP = ParserUtils.parseTo_Integer(temp);

								} catch (java.lang.Exception ex_tFileInputDelimited_2) {
									globalMap.put("tFileInputDelimited_2_ERROR_MESSAGE",
											ex_tFileInputDelimited_2.getMessage());
									rowstate_tFileInputDelimited_2.setException(new RuntimeException(String.format(
											"Couldn't parse value for column '%s' in '%s', value is '%s'. Details: %s",
											"HTTP", "row8", temp, ex_tFileInputDelimited_2), ex_tFileInputDelimited_2));
								}

							} else {

								row8.HTTP = null;

							}

							columnIndexWithD_tFileInputDelimited_2 = 2;

							row8.MESSAGE = fid_tFileInputDelimited_2.get(columnIndexWithD_tFileInputDelimited_2);

							columnIndexWithD_tFileInputDelimited_2 = 3;

							row8.INFORMATIONS = fid_tFileInputDelimited_2.get(columnIndexWithD_tFileInputDelimited_2);

							if (rowstate_tFileInputDelimited_2.getException() != null) {
								throw rowstate_tFileInputDelimited_2.getException();
							}

						} catch (java.lang.Exception e) {
							globalMap.put("tFileInputDelimited_2_ERROR_MESSAGE", e.getMessage());
							whetherReject_tFileInputDelimited_2 = true;

							log.error("tFileInputDelimited_2 - " + e.getMessage());

							System.err.println(e.getMessage());
							row8 = null;

						}

						log.debug("tFileInputDelimited_2 - Retrieving the record "
								+ fid_tFileInputDelimited_2.getRowNumber() + ".");

						/**
						 * [tFileInputDelimited_2 begin ] stop
						 */

						/**
						 * [tFileInputDelimited_2 main ] start
						 */

						currentComponent = "tFileInputDelimited_2";

						tos_count_tFileInputDelimited_2++;

						/**
						 * [tFileInputDelimited_2 main ] stop
						 */

						/**
						 * [tFileInputDelimited_2 process_data_begin ] start
						 */

						currentComponent = "tFileInputDelimited_2";

						/**
						 * [tFileInputDelimited_2 process_data_begin ] stop
						 */
// Start of branch "row8"
						if (row8 != null) {

							/**
							 * [tAdvancedHash_row8 main ] start
							 */

							currentComponent = "tAdvancedHash_row8";

							if (execStat) {
								runStat.updateStatOnConnection(iterateId, 1, 1

										, "row8"

								);
							}

							if (log.isTraceEnabled()) {
								log.trace("row8 - " + (row8 == null ? "" : row8.toLogString()));
							}

							row8Struct row8_HashRow = new row8Struct();

							row8_HashRow.CODE = row8.CODE;

							row8_HashRow.HTTP = row8.HTTP;

							row8_HashRow.MESSAGE = row8.MESSAGE;

							row8_HashRow.INFORMATIONS = row8.INFORMATIONS;

							tHash_Lookup_row8.put(row8_HashRow);

							tos_count_tAdvancedHash_row8++;

							/**
							 * [tAdvancedHash_row8 main ] stop
							 */

							/**
							 * [tAdvancedHash_row8 process_data_begin ] start
							 */

							currentComponent = "tAdvancedHash_row8";

							/**
							 * [tAdvancedHash_row8 process_data_begin ] stop
							 */

							/**
							 * [tAdvancedHash_row8 process_data_end ] start
							 */

							currentComponent = "tAdvancedHash_row8";

							/**
							 * [tAdvancedHash_row8 process_data_end ] stop
							 */

						} // End of branch "row8"

						/**
						 * [tFileInputDelimited_2 process_data_end ] start
						 */

						currentComponent = "tFileInputDelimited_2";

						/**
						 * [tFileInputDelimited_2 process_data_end ] stop
						 */

						/**
						 * [tFileInputDelimited_2 end ] start
						 */

						currentComponent = "tFileInputDelimited_2";

					}
				} finally {
					if (!((Object) (context.csv_path + "Error_Response_Handler.csv") instanceof java.io.InputStream)) {
						if (fid_tFileInputDelimited_2 != null) {
							fid_tFileInputDelimited_2.close();
						}
					}
					if (fid_tFileInputDelimited_2 != null) {
						globalMap.put("tFileInputDelimited_2_NB_LINE", fid_tFileInputDelimited_2.getRowNumber());

						log.info("tFileInputDelimited_2 - Retrieved records count: "
								+ fid_tFileInputDelimited_2.getRowNumber() + ".");

					}
				}

				if (log.isDebugEnabled())
					log.debug("tFileInputDelimited_2 - " + ("Done."));

				ok_Hash.put("tFileInputDelimited_2", true);
				end_Hash.put("tFileInputDelimited_2", System.currentTimeMillis());

				/**
				 * [tFileInputDelimited_2 end ] stop
				 */

				/**
				 * [tAdvancedHash_row8 end ] start
				 */

				currentComponent = "tAdvancedHash_row8";

				tHash_Lookup_row8.endPut();

				if (execStat) {
					runStat.updateStat(resourceMap, iterateId, 2, 0, "row8");
				}

				ok_Hash.put("tAdvancedHash_row8", true);
				end_Hash.put("tAdvancedHash_row8", System.currentTimeMillis());

				/**
				 * [tAdvancedHash_row8 end ] stop
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
				 * [tFileInputDelimited_2 finally ] start
				 */

				currentComponent = "tFileInputDelimited_2";

				/**
				 * [tFileInputDelimited_2 finally ] stop
				 */

				/**
				 * [tAdvancedHash_row8 finally ] start
				 */

				currentComponent = "tAdvancedHash_row8";

				/**
				 * [tAdvancedHash_row8 finally ] stop
				 */

			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tFileInputDelimited_2_SUBPROCESS_STATE", 1);
	}

	public static class headerStruct implements routines.system.IPersistableRow<headerStruct> {
		final static byte[] commonByteArrayLock_SALESFORCE_DeleteDb = new byte[0];
		static byte[] commonByteArray_SALESFORCE_DeleteDb = new byte[0];

		public String Authorization;

		public String getAuthorization() {
			return this.Authorization;
		}

		public String CD_PRODUIT;

		public String getCD_PRODUIT() {
			return this.CD_PRODUIT;
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
				if (length > commonByteArray_SALESFORCE_DeleteDb.length) {
					if (length < 1024 && commonByteArray_SALESFORCE_DeleteDb.length == 0) {
						commonByteArray_SALESFORCE_DeleteDb = new byte[1024];
					} else {
						commonByteArray_SALESFORCE_DeleteDb = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_SALESFORCE_DeleteDb, 0, length);
				strReturn = new String(commonByteArray_SALESFORCE_DeleteDb, 0, length, utf8Charset);
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
				if (length > commonByteArray_SALESFORCE_DeleteDb.length) {
					if (length < 1024 && commonByteArray_SALESFORCE_DeleteDb.length == 0) {
						commonByteArray_SALESFORCE_DeleteDb = new byte[1024];
					} else {
						commonByteArray_SALESFORCE_DeleteDb = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_SALESFORCE_DeleteDb, 0, length);
				strReturn = new String(commonByteArray_SALESFORCE_DeleteDb, 0, length, utf8Charset);
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

			synchronized (commonByteArrayLock_SALESFORCE_DeleteDb) {

				try {

					int length = 0;

					this.Authorization = readString(dis);

					this.CD_PRODUIT = readString(dis);

					this.correlationId = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_SALESFORCE_DeleteDb) {

				try {

					int length = 0;

					this.Authorization = readString(dis);

					this.CD_PRODUIT = readString(dis);

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

				writeString(this.CD_PRODUIT, dos);

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

				writeString(this.CD_PRODUIT, dos);

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
			sb.append(",CD_PRODUIT=" + CD_PRODUIT);
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

			if (CD_PRODUIT == null) {
				sb.append("<null>");
			} else {
				sb.append(CD_PRODUIT);
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
										+ ("((TokenException)globalMap.get(\"tokenException\")).validateToken(header.Authorization)")
										+ ", KEY=" + ("\"is_valid_token\"") + "}, {VALUE=" + ("0") + ", KEY="
										+ ("\"i_stepSequence\"") + "}, {VALUE="
										+ ("TokenException.isBlank(header.correlationId) ? StringHandling.SUBSTR((java.util.UUID.randomUUID()).toString(), 10, 14) : header.correlationId")
										+ ", KEY=" + ("\"s_correlationId\"") + "}, {VALUE=" + ("header.CD_PRODUIT")
										+ ", KEY=" + ("\"code\"") + "}]");
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
							if (params_tRESTRequest_1.containsKey("PATH:CD_PRODUIT:id_String")) {

								header.CD_PRODUIT = (String) params_tRESTRequest_1.get("PATH:CD_PRODUIT:id_String");

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

						globalMap.put("is_valid_token",
								((TokenException) globalMap.get("tokenException")).validateToken(header.Authorization));
						globalMap.put("i_stepSequence", 0);
						globalMap.put("s_correlationId",
								TokenException.isBlank(header.correlationId)
										? StringHandling.SUBSTR((java.util.UUID.randomUUID()).toString(), 10, 14)
										: header.correlationId);
						globalMap.put("code", header.CD_PRODUIT);

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
							runStat.updateStatOnConnection("If6", 0, "true");
						}
						tFixedFlowInput_2Process(globalMap);
					}

					else {
						if (execStat) {
							runStat.updateStatOnConnection("If6", 0, "false");
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

			if (resumeEntryMethodName == null || globalResumeTicket) {
				resumeUtil.addLog("CHECKPOINT", "CONNECTION:SUBJOB_OK:tRESTRequest_1_Loop:OnSubjobOk", "",
						Thread.currentThread().getId() + "", "", "", "", "", "");
			}

			if (execStat) {
				runStat.updateStatOnConnection("OnSubjobOk3", 0, "ok");
			}

			tJava_1Process(globalMap);

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
		final DeleteDb DeleteDbClass = new DeleteDb();

		int exitCode = DeleteDbClass.runJobInTOS(args);
		if (exitCode == 0) {
			log.info("TalendJob: 'DeleteDb' - Done.");
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
		log.info("TalendJob: 'DeleteDb' - Start.");

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
			java.io.InputStream inContext = DeleteDb.class.getClassLoader()
					.getResourceAsStream("salesforce/deletedb_0_1/contexts/" + contextStr + ".properties");
			if (inContext == null) {
				inContext = DeleteDb.class.getClassLoader()
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
			System.out.println((endUsedMemory - startUsedMemory) + " bytes memory increase when running : DeleteDb");
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
 * 297368 characters generated by Talend Open Studio for ESB on the 15 août 2024
 * à 2:10:11 PM CET
 ************************************************************************************************/