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

package salesforce.tzygg_0_1;

import routines.Numeric;
import routines.DataOperation;
import routines.TalendDataGenerator;
import routines.TalendStringUtil;
import routines.TalendString;
import routines.StringHandling;
import routines.Relational;
import routines.TalendDate;
import routines.Mathematical;
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
 * Job: tzygg Purpose: <br>
 * Description: <br>
 * 
 * @author user@talend.com
 * @version 8.0.1.20211109_1610
 * @status
 */
public class tzygg implements TalendJob {
	static {
		System.setProperty("TalendJob.log", "tzygg.log");
	}

	private static org.apache.logging.log4j.Logger log = org.apache.logging.log4j.LogManager.getLogger(tzygg.class);

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

		}

		// if the stored or passed value is "<TALEND_NULL>" string, it mean null
		public String getStringValue(String key) {
			String origin_value = this.getProperty(key);
			if (NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY.equals(origin_value)) {
				return null;
			}
			return origin_value;
		}

	}

	protected ContextProperties context = new ContextProperties(); // will be instanciated by MS.

	public ContextProperties getContext() {
		return this.context;
	}

	private final String jobVersion = "0.1";
	private final String jobName = "tzygg";
	private final String projectName = "SALESFORCE";
	public Integer errorCode = null;
	private String currentComponent = "";

	private final java.util.Map<String, Object> globalMap = java.util.Collections
			.synchronizedMap(new java.util.HashMap<String, Object>());

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
					tzygg.this.exception = e;
				}
			}
			if (!(e instanceof TalendException)) {
				try {
					for (java.lang.reflect.Method m : this.getClass().getEnclosingClass().getMethods()) {
						if (m.getName().compareTo(currentComponent + "_error") == 0) {
							m.invoke(tzygg.this, new Object[] { e, currentComponent, globalMap });
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

	public void tRowGenerator_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tRowGenerator_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tLogRow_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tRowGenerator_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tWriteJSONField_1_Out_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		tWriteJSONField_1_In_error(exception, errorComponent, globalMap);

	}

	public void tWriteJSONField_1_In_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tRowGenerator_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tRowGenerator_1_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public void tWriteJSONField_1_In_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public static class ContextBean {
		static String evaluate(String context, String contextExpression)
				throws IOException, javax.script.ScriptException {
			boolean isExpression = contextExpression.contains("+") || contextExpression.contains("(");
			final String prefix = isExpression ? "\"" : "";
			java.util.Properties defaultProps = new java.util.Properties();
			java.io.InputStream inContext = tzygg.class.getClassLoader()
					.getResourceAsStream("salesforce/tzygg_0_1/contexts/" + context + ".properties");
			if (inContext == null) {
				inContext = tzygg.class.getClassLoader()
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

	public static class row1Struct implements routines.system.IPersistableRow<row1Struct> {
		final static byte[] commonByteArrayLock_SALESFORCE_tzygg = new byte[0];
		static byte[] commonByteArray_SALESFORCE_tzygg = new byte[0];

		public String first;

		public String getFirst() {
			return this.first;
		}

		public String last;

		public String getLast() {
			return this.last;
		}

		public Integer code;

		public Integer getCode() {
			return this.code;
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_SALESFORCE_tzygg.length) {
					if (length < 1024 && commonByteArray_SALESFORCE_tzygg.length == 0) {
						commonByteArray_SALESFORCE_tzygg = new byte[1024];
					} else {
						commonByteArray_SALESFORCE_tzygg = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_SALESFORCE_tzygg, 0, length);
				strReturn = new String(commonByteArray_SALESFORCE_tzygg, 0, length, utf8Charset);
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
				if (length > commonByteArray_SALESFORCE_tzygg.length) {
					if (length < 1024 && commonByteArray_SALESFORCE_tzygg.length == 0) {
						commonByteArray_SALESFORCE_tzygg = new byte[1024];
					} else {
						commonByteArray_SALESFORCE_tzygg = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_SALESFORCE_tzygg, 0, length);
				strReturn = new String(commonByteArray_SALESFORCE_tzygg, 0, length, utf8Charset);
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

			synchronized (commonByteArrayLock_SALESFORCE_tzygg) {

				try {

					int length = 0;

					this.first = readString(dis);

					this.last = readString(dis);

					this.code = readInteger(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_SALESFORCE_tzygg) {

				try {

					int length = 0;

					this.first = readString(dis);

					this.last = readString(dis);

					this.code = readInteger(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.first, dos);

				// String

				writeString(this.last, dos);

				// Integer

				writeInteger(this.code, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.first, dos);

				// String

				writeString(this.last, dos);

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
			sb.append("first=" + first);
			sb.append(",last=" + last);
			sb.append(",code=" + String.valueOf(code));
			sb.append("]");

			return sb.toString();
		}

		public String toLogString() {
			StringBuilder sb = new StringBuilder();

			if (first == null) {
				sb.append("<null>");
			} else {
				sb.append(first);
			}

			sb.append("|");

			if (last == null) {
				sb.append("<null>");
			} else {
				sb.append(last);
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

public void tRowGenerator_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tRowGenerator_1_SUBPROCESS_STATE", 0);

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
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;



		row1Struct row1 = new row1Struct();




	
	/**
	 * [tWriteJSONField_1_Out begin ] start
	 */

	

	
		
		ok_Hash.put("tWriteJSONField_1_Out", false);
		start_Hash.put("tWriteJSONField_1_Out", System.currentTimeMillis());
		
	
		currentVirtualComponent = "tWriteJSONField_1";
	
	currentComponent="tWriteJSONField_1_Out";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"row1");
					}
				
		int tos_count_tWriteJSONField_1_Out = 0;
		
                if(log.isDebugEnabled())
            log.debug("tWriteJSONField_1_Out - "  + ("Start to work.") );
            if (log.isDebugEnabled()) {
                class BytesLimit65535_tWriteJSONField_1_Out{
                    public void limitLog4jByte() throws Exception{
                    StringBuilder log4jParamters_tWriteJSONField_1_Out = new StringBuilder();
                    log4jParamters_tWriteJSONField_1_Out.append("Parameters:");
                            log4jParamters_tWriteJSONField_1_Out.append("GROUPBYS" + " = " + "[]");
                        log4jParamters_tWriteJSONField_1_Out.append(" | ");
                            log4jParamters_tWriteJSONField_1_Out.append("REMOVE_HEADER" + " = " + "false");
                        log4jParamters_tWriteJSONField_1_Out.append(" | ");
                            log4jParamters_tWriteJSONField_1_Out.append("CREATE" + " = " + "true");
                        log4jParamters_tWriteJSONField_1_Out.append(" | ");
                            log4jParamters_tWriteJSONField_1_Out.append("CREATE_EMPTY_ELEMENT" + " = " + "true");
                        log4jParamters_tWriteJSONField_1_Out.append(" | ");
                            log4jParamters_tWriteJSONField_1_Out.append("EXPAND_EMPTY_ELM" + " = " + "false");
                        log4jParamters_tWriteJSONField_1_Out.append(" | ");
                            log4jParamters_tWriteJSONField_1_Out.append("ALLOW_EMPTY_STRINGS" + " = " + "false");
                        log4jParamters_tWriteJSONField_1_Out.append(" | ");
                            log4jParamters_tWriteJSONField_1_Out.append("OUTPUT_AS_XSD" + " = " + "false");
                        log4jParamters_tWriteJSONField_1_Out.append(" | ");
                            log4jParamters_tWriteJSONField_1_Out.append("ADVANCED_SEPARATOR" + " = " + "false");
                        log4jParamters_tWriteJSONField_1_Out.append(" | ");
                            log4jParamters_tWriteJSONField_1_Out.append("COMPACT_FORMAT" + " = " + "true");
                        log4jParamters_tWriteJSONField_1_Out.append(" | ");
                            log4jParamters_tWriteJSONField_1_Out.append("GENERATION_MODE" + " = " + "Dom4j");
                        log4jParamters_tWriteJSONField_1_Out.append(" | ");
                            log4jParamters_tWriteJSONField_1_Out.append("ENCODING" + " = " + "\"ISO-8859-15\"");
                        log4jParamters_tWriteJSONField_1_Out.append(" | ");
                            log4jParamters_tWriteJSONField_1_Out.append("DESTINATION" + " = " + "tWriteJSONField_1");
                        log4jParamters_tWriteJSONField_1_Out.append(" | ");
                if(log.isDebugEnabled())
            log.debug("tWriteJSONField_1_Out - "  + (log4jParamters_tWriteJSONField_1_Out) );
                    } 
                } 
            new BytesLimit65535_tWriteJSONField_1_Out().limitLog4jByte();
            }
//tWriteXMLFieldOut_begin
				int nb_line_tWriteJSONField_1_Out = 0;
				boolean needRoot_tWriteJSONField_1_Out  = true;
				
				String  strCompCache_tWriteJSONField_1_Out= null;		
				
						        java.util.Queue<row2Struct> listGroupby_tWriteJSONField_1_Out = new java.util.concurrent.ConcurrentLinkedQueue<row2Struct>();
							
	
					class ThreadXMLField_tWriteJSONField_1_Out extends Thread {
						
									    java.util.Queue<row2Struct> queue;
									
						java.util.List<java.util.Map<String,String>> flows;
						java.lang.Exception lastException;
						java.lang.Error lastError;
						String currentComponent;
						
						ThreadXMLField_tWriteJSONField_1_Out(java.util.Queue q) {
							this.queue = q;
							globalMap.put("queue_tWriteJSONField_1_In", queue);
							lastException = null;
						}
						
						ThreadXMLField_tWriteJSONField_1_Out(java.util.Queue q, java.util.List<java.util.Map<String,String>> l) {
							this.queue = q;
							this.flows = l;
							lastException = null;
							globalMap.put("queue_tWriteJSONField_1_In", queue);
							globalMap.put("flows_tWriteJSONField_1_In", flows);
						}
						
						public java.lang.Exception getLastException() {
							return this.lastException;
						}
						
						public java.lang.Error getLastError() {
							return this.lastError;
						}
						
						public String getCurrentComponent() {
							return this.currentComponent;
						}
	
						@Override
						public void run() {
							try {
								tWriteJSONField_1_InProcess(globalMap);
							} catch (TalendException te) {
globalMap.put("tWriteJSONField_1_Out_ERROR_MESSAGE",te.getMessage());
								this.lastException = te.getException();
								this.currentComponent = te.getCurrentComponent();
							} catch (java.lang.Error error) {
								this.lastError = error;
							}
						}
					}
					
						ThreadXMLField_tWriteJSONField_1_Out txf_tWriteJSONField_1_Out = new ThreadXMLField_tWriteJSONField_1_Out(listGroupby_tWriteJSONField_1_Out);
					
					globalMap.put("wrtXMLFieldIn_tWriteJSONField_1_Out", txf_tWriteJSONField_1_Out);
					txf_tWriteJSONField_1_Out.start();
				

java.util.List<java.util.List<String>> groupbyList_tWriteJSONField_1_Out = new java.util.ArrayList<java.util.List<String>>();
java.util.Map<String,String> valueMap_tWriteJSONField_1_Out = new java.util.HashMap<String,String>();
java.util.Map<String,String> arraysValueMap_tWriteJSONField_1_Out = new java.util.HashMap<String,String>();

class NestXMLTool_tWriteJSONField_1_Out{
	public void parseAndAdd(org.dom4j.Element nestRoot, String value){
		try {
            org.dom4j.Document doc4Str = org.dom4j.DocumentHelper.parseText("<root>"+ value + "</root>");
    		nestRoot.setContent(doc4Str.getRootElement().content());
    	} catch (java.lang.Exception e) {
globalMap.put("tWriteJSONField_1_Out_ERROR_MESSAGE",e.getMessage());
    		e.printStackTrace();
    		nestRoot.setText(value);
        }
	}
	
	public void setText(org.dom4j.Element element, String value){
		if (value.startsWith("<![CDATA[") && value.endsWith("]]>")) {
			String text = value.substring(9, value.length()-3);
			element.addCDATA(text);
		}else{
			element.setText(value);
		}
	}
	
	public void replaceDefaultNameSpace(org.dom4j.Element nestRoot){
		if (nestRoot!=null) {
			for (org.dom4j.Element tmp: (java.util.List<org.dom4j.Element>) nestRoot.elements()) {
        		if (("").equals(tmp.getQName().getNamespace().getURI()) && ("").equals(tmp.getQName().getNamespace().getPrefix())){
        			tmp.setQName(org.dom4j.DocumentHelper.createQName(tmp.getName(), nestRoot.getQName().getNamespace()));
	        	}
    	    	replaceDefaultNameSpace(tmp);
       		}
       	}
	}
	
	public void removeEmptyElement(org.dom4j.Element root){
		if (root!=null) {
			for (org.dom4j.Element tmp: (java.util.List<org.dom4j.Element>) root.elements()) {
				removeEmptyElement(tmp);
			}

            boolean noSignificantDataAnnotationsExist = root.attributes().isEmpty() ;
            if (root.content().isEmpty()
                && noSignificantDataAnnotationsExist && root.declaredNamespaces().isEmpty()) {
                if(root.getParent()!=null){
                    root.getParent().remove(root);
                }
            }
        }
    }
	public String objectToString(Object value){
		if(value.getClass().isArray()){
			StringBuilder sb = new StringBuilder();

			int length = java.lang.reflect.Array.getLength(value);
			for (int i = 0; i < length; i++) {
				Object obj = java.lang.reflect.Array.get(value, i);
				sb.append("<element>");
				sb.append(obj);
				sb.append("</element>");
			}
			return sb.toString();
		}else{
			return value.toString();
		}
	}
}
NestXMLTool_tWriteJSONField_1_Out nestXMLTool_tWriteJSONField_1_Out = new NestXMLTool_tWriteJSONField_1_Out();

row1Struct  rowStructOutput_tWriteJSONField_1_Out = new row1Struct();
// sort group root element for judgement of group
java.util.List<org.dom4j.Element> groupElementList_tWriteJSONField_1_Out = new java.util.ArrayList<org.dom4j.Element>();
org.dom4j.Element root4Group_tWriteJSONField_1_Out = null;
org.dom4j.Document doc_tWriteJSONField_1_Out  = org.dom4j.DocumentHelper.createDocument();
org.dom4j.io.OutputFormat format_tWriteJSONField_1_Out = org.dom4j.io.OutputFormat.createCompactFormat();
format_tWriteJSONField_1_Out.setNewLineAfterDeclaration(false);
format_tWriteJSONField_1_Out.setTrimText(false);
format_tWriteJSONField_1_Out.setEncoding("ISO-8859-15");
int[] orders_tWriteJSONField_1_Out = new int[1];

 



/**
 * [tWriteJSONField_1_Out begin ] stop
 */



	
	/**
	 * [tRowGenerator_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tRowGenerator_1", false);
		start_Hash.put("tRowGenerator_1", System.currentTimeMillis());
		
	
	currentComponent="tRowGenerator_1";

	
		int tos_count_tRowGenerator_1 = 0;
		
                if(log.isDebugEnabled())
            log.debug("tRowGenerator_1 - "  + ("Start to work.") );
            if (log.isDebugEnabled()) {
                class BytesLimit65535_tRowGenerator_1{
                    public void limitLog4jByte() throws Exception{
                    StringBuilder log4jParamters_tRowGenerator_1 = new StringBuilder();
                    log4jParamters_tRowGenerator_1.append("Parameters:");
                if(log.isDebugEnabled())
            log.debug("tRowGenerator_1 - "  + (log4jParamters_tRowGenerator_1) );
                    } 
                } 
            new BytesLimit65535_tRowGenerator_1().limitLog4jByte();
            }


int nb_line_tRowGenerator_1 = 0;
int nb_max_row_tRowGenerator_1 = 3;


class tRowGenerator_1Randomizer {
	public String getRandomfirst() {
		
		return TalendDataGenerator.getFirstName();
		
	}
	public String getRandomlast() {
		
		return TalendDataGenerator.getLastName();
		
	}
	public Integer getRandomcode() {
		
		return Numeric.random(0 ,100 );
		
	}
}
	tRowGenerator_1Randomizer randtRowGenerator_1 = new tRowGenerator_1Randomizer();
	
    	log.info("tRowGenerator_1 - Generating records.");
	for (int itRowGenerator_1=0; itRowGenerator_1<nb_max_row_tRowGenerator_1 ;itRowGenerator_1++) {
		row1.first = randtRowGenerator_1.getRandomfirst();
		row1.last = randtRowGenerator_1.getRandomlast();
		row1.code = randtRowGenerator_1.getRandomcode();
		nb_line_tRowGenerator_1++;
		
			log.debug("tRowGenerator_1 - Retrieving the record " + nb_line_tRowGenerator_1 + ".");
		

 



/**
 * [tRowGenerator_1 begin ] stop
 */
	
	/**
	 * [tRowGenerator_1 main ] start
	 */

	

	
	
	currentComponent="tRowGenerator_1";

	

 


	tos_count_tRowGenerator_1++;

/**
 * [tRowGenerator_1 main ] stop
 */
	
	/**
	 * [tRowGenerator_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tRowGenerator_1";

	

 



/**
 * [tRowGenerator_1 process_data_begin ] stop
 */

	
	/**
	 * [tWriteJSONField_1_Out main ] start
	 */

	

	
	
		currentVirtualComponent = "tWriteJSONField_1";
	
	currentComponent="tWriteJSONField_1_Out";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row1"
						
						);
					}
					
    			if(log.isTraceEnabled()){
    				log.trace("row1 - " + (row1==null? "": row1.toLogString()));
    			}
    		

	if(txf_tWriteJSONField_1_Out.getLastException()!=null) {
		currentComponent = txf_tWriteJSONField_1_Out.getCurrentComponent();
		throw txf_tWriteJSONField_1_Out.getLastException();
	}
	
	if(txf_tWriteJSONField_1_Out.getLastError()!=null) {
		throw txf_tWriteJSONField_1_Out.getLastError();
	}
	nb_line_tWriteJSONField_1_Out++;
				log.debug("tWriteJSONField_1_Out - Processing the record " + nb_line_tWriteJSONField_1_Out + ".");
			
	class ToStringHelper_tWriteJSONField_1_Out {
	    public String toString(final Object value) {
	        return value != null ? value.toString() : null;
	    }
	}
	final ToStringHelper_tWriteJSONField_1_Out helper_tWriteJSONField_1_Out = new ToStringHelper_tWriteJSONField_1_Out();

	valueMap_tWriteJSONField_1_Out.clear();
	arraysValueMap_tWriteJSONField_1_Out.clear();
	valueMap_tWriteJSONField_1_Out.put("first", helper_tWriteJSONField_1_Out.toString(
	(
		row1.first != null?
            row1.first.toString():null
		)));
	arraysValueMap_tWriteJSONField_1_Out.put("first", helper_tWriteJSONField_1_Out.toString(
	(
		row1.first != null?
            row1.first.toString():null
		)));
	valueMap_tWriteJSONField_1_Out.put("last", helper_tWriteJSONField_1_Out.toString(
	(
		row1.last != null?
            row1.last.toString():null
		)));
	arraysValueMap_tWriteJSONField_1_Out.put("last", helper_tWriteJSONField_1_Out.toString(
	(
		row1.last != null?
            row1.last.toString():null
		)));
	valueMap_tWriteJSONField_1_Out.put("code", helper_tWriteJSONField_1_Out.toString(
	(
		row1.code != null?
            row1.code.toString():null
		)));
	arraysValueMap_tWriteJSONField_1_Out.put("code", helper_tWriteJSONField_1_Out.toString(
	(
		row1.code != null?
            row1.code.toString():null
		)));
		String strTemp_tWriteJSONField_1_Out = "";
	if(strCompCache_tWriteJSONField_1_Out==null){
		strCompCache_tWriteJSONField_1_Out=strTemp_tWriteJSONField_1_Out;
		
	}else{  
    		nestXMLTool_tWriteJSONField_1_Out.replaceDefaultNameSpace(doc_tWriteJSONField_1_Out.getRootElement());			
			java.io.StringWriter strWriter_tWriteJSONField_1_Out = new java.io.StringWriter();	
			org.dom4j.io.XMLWriter output_tWriteJSONField_1_Out = new org.dom4j.io.XMLWriter(strWriter_tWriteJSONField_1_Out, format_tWriteJSONField_1_Out);
			output_tWriteJSONField_1_Out.write(doc_tWriteJSONField_1_Out);
		    output_tWriteJSONField_1_Out.close();
			
				  		  row2Struct row_tWriteJSONField_1_Out = new row2Struct();
						  
					     		row_tWriteJSONField_1_Out. = strWriter_tWriteJSONField_1_Out.toString();
					     		listGroupby_tWriteJSONField_1_Out.add(row_tWriteJSONField_1_Out);
					
		    doc_tWriteJSONField_1_Out.clearContent();
			needRoot_tWriteJSONField_1_Out = true;
			for(int i_tWriteJSONField_1_Out=0;i_tWriteJSONField_1_Out<orders_tWriteJSONField_1_Out.length;i_tWriteJSONField_1_Out++){
				orders_tWriteJSONField_1_Out[i_tWriteJSONField_1_Out] = 0;
			}
			
			if(groupbyList_tWriteJSONField_1_Out != null && groupbyList_tWriteJSONField_1_Out.size() >= 0){
				groupbyList_tWriteJSONField_1_Out.clear();
			}
			strCompCache_tWriteJSONField_1_Out=strTemp_tWriteJSONField_1_Out;
	}

	org.dom4j.Element subTreeRootParent_tWriteJSONField_1_Out = null;
	
	// build root xml tree 
	if (needRoot_tWriteJSONField_1_Out) {
		needRoot_tWriteJSONField_1_Out=false;
		org.dom4j.Element root_tWriteJSONField_1_Out = doc_tWriteJSONField_1_Out.addElement("root");
		subTreeRootParent_tWriteJSONField_1_Out = root_tWriteJSONField_1_Out;
		org.dom4j.Element root_0_tWriteJSONField_1_Out = root_tWriteJSONField_1_Out.addElement("first");
		if(
		valueMap_tWriteJSONField_1_Out.get("first")!=null){
			nestXMLTool_tWriteJSONField_1_Out .setText(root_0_tWriteJSONField_1_Out,
		valueMap_tWriteJSONField_1_Out.get("first"));
		}
		org.dom4j.Element root_1_tWriteJSONField_1_Out = root_tWriteJSONField_1_Out.addElement("last");
		if(
		valueMap_tWriteJSONField_1_Out.get("last")!=null){
			nestXMLTool_tWriteJSONField_1_Out .setText(root_1_tWriteJSONField_1_Out,
		valueMap_tWriteJSONField_1_Out.get("last"));
		}
		root4Group_tWriteJSONField_1_Out = subTreeRootParent_tWriteJSONField_1_Out;
	}else{
		subTreeRootParent_tWriteJSONField_1_Out=root4Group_tWriteJSONField_1_Out;
	}
	// build group xml tree 
	// build loop xml tree
		org.dom4j.Element loop_tWriteJSONField_1_Out = org.dom4j.DocumentHelper.createElement("code");
        if(orders_tWriteJSONField_1_Out[0]==0){
        	orders_tWriteJSONField_1_Out[0] = 2;
        }
        if(1 < orders_tWriteJSONField_1_Out.length){
        		orders_tWriteJSONField_1_Out[1] = 0;
        }
        subTreeRootParent_tWriteJSONField_1_Out.elements().add(orders_tWriteJSONField_1_Out[0]++,loop_tWriteJSONField_1_Out);
		if(
		valueMap_tWriteJSONField_1_Out.get("code")!=null){
			nestXMLTool_tWriteJSONField_1_Out .setText(loop_tWriteJSONField_1_Out,
		valueMap_tWriteJSONField_1_Out.get("code"));
            loop_tWriteJSONField_1_Out.addAttribute("type", "number");
		}

 


	tos_count_tWriteJSONField_1_Out++;

/**
 * [tWriteJSONField_1_Out main ] stop
 */
	
	/**
	 * [tWriteJSONField_1_Out process_data_begin ] start
	 */

	

	
	
		currentVirtualComponent = "tWriteJSONField_1";
	
	currentComponent="tWriteJSONField_1_Out";

	

 



/**
 * [tWriteJSONField_1_Out process_data_begin ] stop
 */
	
	/**
	 * [tWriteJSONField_1_Out process_data_end ] start
	 */

	

	
	
		currentVirtualComponent = "tWriteJSONField_1";
	
	currentComponent="tWriteJSONField_1_Out";

	

 



/**
 * [tWriteJSONField_1_Out process_data_end ] stop
 */



	
	/**
	 * [tRowGenerator_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tRowGenerator_1";

	

 



/**
 * [tRowGenerator_1 process_data_end ] stop
 */
	
	/**
	 * [tRowGenerator_1 end ] start
	 */

	

	
	
	currentComponent="tRowGenerator_1";

	

}
globalMap.put("tRowGenerator_1_NB_LINE",nb_line_tRowGenerator_1);
	log.info("tRowGenerator_1 - Generated records count:" + nb_line_tRowGenerator_1 + " .");

 
                if(log.isDebugEnabled())
            log.debug("tRowGenerator_1 - "  + ("Done.") );

ok_Hash.put("tRowGenerator_1", true);
end_Hash.put("tRowGenerator_1", System.currentTimeMillis());




/**
 * [tRowGenerator_1 end ] stop
 */

	
	/**
	 * [tWriteJSONField_1_Out end ] start
	 */

	

	
	
		currentVirtualComponent = "tWriteJSONField_1";
	
	currentComponent="tWriteJSONField_1_Out";

	

if(nb_line_tWriteJSONField_1_Out > 0){  
    nestXMLTool_tWriteJSONField_1_Out.replaceDefaultNameSpace(doc_tWriteJSONField_1_Out.getRootElement());
	java.io.StringWriter strWriter_tWriteJSONField_1_Out = new java.io.StringWriter();
	org.dom4j.io.XMLWriter output_tWriteJSONField_1_Out = new org.dom4j.io.XMLWriter(strWriter_tWriteJSONField_1_Out, format_tWriteJSONField_1_Out);
	output_tWriteJSONField_1_Out.write(doc_tWriteJSONField_1_Out);
    output_tWriteJSONField_1_Out.close();
					row2Struct row_tWriteJSONField_1_Out = new row2Struct();
						  
					     		row_tWriteJSONField_1_Out. = strWriter_tWriteJSONField_1_Out.toString();
					     		listGroupby_tWriteJSONField_1_Out.add(row_tWriteJSONField_1_Out);
		    		

}
globalMap.put("tWriteJSONField_1_Out_NB_LINE",nb_line_tWriteJSONField_1_Out);
globalMap.put("tWriteJSONField_1_In_FINISH" + (listGroupby_tWriteJSONField_1_Out==null?"":listGroupby_tWriteJSONField_1_Out.hashCode()), "true");
	
		txf_tWriteJSONField_1_Out.join();
		
		if(txf_tWriteJSONField_1_Out.getLastException()!=null) {
			currentComponent = txf_tWriteJSONField_1_Out.getCurrentComponent();
			throw txf_tWriteJSONField_1_Out.getLastException();
		}
		
		if(txf_tWriteJSONField_1_Out.getLastError()!=null) {
			throw txf_tWriteJSONField_1_Out.getLastError();
		}
	
resourceMap.put("finish_tWriteJSONField_1_Out", true);
				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"row1");
			  	}
			  	
 
                if(log.isDebugEnabled())
            log.debug("tWriteJSONField_1_Out - "  + ("Done.") );

ok_Hash.put("tWriteJSONField_1_Out", true);
end_Hash.put("tWriteJSONField_1_Out", System.currentTimeMillis());

				if(execStat){   
   	 				runStat.updateStatOnConnection("OnComponentOk", 0, "ok");
				}



/**
 * [tWriteJSONField_1_Out end ] stop
 */



				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				    if(!(e instanceof TalendException)){
					   log.fatal(currentComponent + " " + e.getMessage(),e);
					}
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
					te.setVirtualComponentName(currentVirtualComponent);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tRowGenerator_1 finally ] start
	 */

	

	
	
	currentComponent="tRowGenerator_1";

	

 



/**
 * [tRowGenerator_1 finally ] stop
 */

	
	/**
	 * [tWriteJSONField_1_Out finally ] start
	 */

	

	
	
		currentVirtualComponent = "tWriteJSONField_1";
	
	currentComponent="tWriteJSONField_1_Out";

	

		java.util.Queue listGroupby_tWriteJSONField_1_Out = (java.util.Queue)globalMap.get("queue_tWriteJSONField_1_In");
		if(resourceMap.get("finish_tWriteJSONField_1_Out") == null){
			globalMap.put("tWriteJSONField_1_In_FINISH_WITH_EXCEPTION" + (listGroupby_tWriteJSONField_1_Out==null?"":listGroupby_tWriteJSONField_1_Out.hashCode()), "true");
		}
	
	if (listGroupby_tWriteJSONField_1_Out != null) {
		globalMap.put("tWriteJSONField_1_In_FINISH" + (listGroupby_tWriteJSONField_1_Out==null?"":listGroupby_tWriteJSONField_1_Out.hashCode()), "true");
	}
	// workaround for 37349 - in case of normal execution it will pass normally
	// in case it fails and handle by catch - it will wait for child thread finish
	Thread txf_tWriteJSONField_1_Out = (Thread) globalMap.get("wrtXMLFieldIn_tWriteJSONField_1_Out");
	if ( txf_tWriteJSONField_1_Out != null) {
		txf_tWriteJSONField_1_Out.join();
	}

 



/**
 * [tWriteJSONField_1_Out finally ] stop
 */



				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tRowGenerator_1_SUBPROCESS_STATE", 1);
	}

	public static class row2Struct implements routines.system.IPersistableRow<row2Struct> {
		final static byte[] commonByteArrayLock_SALESFORCE_tzygg = new byte[0];
		static byte[] commonByteArray_SALESFORCE_tzygg = new byte[0];

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_SALESFORCE_tzygg) {

				try {

					int length = 0;

				}

				finally {
				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_SALESFORCE_tzygg) {

				try {

					int length = 0;

				}

				finally {
				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

			}

			finally {
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

			}

			finally {
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("]");

			return sb.toString();
		}

		public String toLogString() {
			StringBuilder sb = new StringBuilder();

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

public void tWriteJSONField_1_InProcess(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tWriteJSONField_1_In_SUBPROCESS_STATE", 0);

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
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;



		row2Struct row2 = new row2Struct();




	
	/**
	 * [tLogRow_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tLogRow_1", false);
		start_Hash.put("tLogRow_1", System.currentTimeMillis());
		
	
	currentComponent="tLogRow_1";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"row2");
					}
				
		int tos_count_tLogRow_1 = 0;
		
                if(log.isDebugEnabled())
            log.debug("tLogRow_1 - "  + ("Start to work.") );
            if (log.isDebugEnabled()) {
                class BytesLimit65535_tLogRow_1{
                    public void limitLog4jByte() throws Exception{
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
                if(log.isDebugEnabled())
            log.debug("tLogRow_1 - "  + (log4jParamters_tLogRow_1) );
                    } 
                } 
            new BytesLimit65535_tLogRow_1().limitLog4jByte();
            }

	///////////////////////
	
         class Util_tLogRow_1 {

        String[] des_top = { ".", ".", "-", "+" };

        String[] des_head = { "|=", "=|", "-", "+" };

        String[] des_bottom = { "'", "'", "-", "+" };

        String name="";

        java.util.List<String[]> list = new java.util.ArrayList<String[]>();

        int[] colLengths = new int[0];

        public void addRow(String[] row) {

            for (int i = 0; i < 0; i++) {
                if (row[i]!=null) {
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
                
                return sb;
            }
            
            public boolean isTableEmpty(){
            	if (list.size() > 1)
            		return false;
            	return true;
            }
        }
        Util_tLogRow_1 util_tLogRow_1 = new Util_tLogRow_1();
        util_tLogRow_1.setTableName("tLogRow_1");
        util_tLogRow_1.addRow(new String[]{});        
 		StringBuilder strBuffer_tLogRow_1 = null;
		int nb_line_tLogRow_1 = 0;
///////////////////////    			



 



/**
 * [tLogRow_1 begin ] stop
 */



	
	/**
	 * [tWriteJSONField_1_In begin ] start
	 */

	

	
		
		ok_Hash.put("tWriteJSONField_1_In", false);
		start_Hash.put("tWriteJSONField_1_In", System.currentTimeMillis());
		
	
		currentVirtualComponent = "tWriteJSONField_1";
	
	currentComponent="tWriteJSONField_1_In";

	
		int tos_count_tWriteJSONField_1_In = 0;
		
                if(log.isDebugEnabled())
            log.debug("tWriteJSONField_1_In - "  + ("Start to work.") );
            if (log.isDebugEnabled()) {
                class BytesLimit65535_tWriteJSONField_1_In{
                    public void limitLog4jByte() throws Exception{
                    StringBuilder log4jParamters_tWriteJSONField_1_In = new StringBuilder();
                    log4jParamters_tWriteJSONField_1_In.append("Parameters:");
                            log4jParamters_tWriteJSONField_1_In.append("JSONFIELD" + " = " + "");
                        log4jParamters_tWriteJSONField_1_In.append(" | ");
                            log4jParamters_tWriteJSONField_1_In.append("DESTINATION" + " = " + "tWriteJSONField_1");
                        log4jParamters_tWriteJSONField_1_In.append(" | ");
                            log4jParamters_tWriteJSONField_1_In.append("REMOVE_ROOT" + " = " + "false");
                        log4jParamters_tWriteJSONField_1_In.append(" | ");
                            log4jParamters_tWriteJSONField_1_In.append("GROUPBYS" + " = " + "[]");
                        log4jParamters_tWriteJSONField_1_In.append(" | ");
                            log4jParamters_tWriteJSONField_1_In.append("QUOTE_ALL_VALUES" + " = " + "false");
                        log4jParamters_tWriteJSONField_1_In.append(" | ");
                            log4jParamters_tWriteJSONField_1_In.append("ALLOW_EMPTY_STRINGS" + " = " + "false");
                        log4jParamters_tWriteJSONField_1_In.append(" | ");
                if(log.isDebugEnabled())
            log.debug("tWriteJSONField_1_In - "  + (log4jParamters_tWriteJSONField_1_In) );
                    } 
                } 
            new BytesLimit65535_tWriteJSONField_1_In().limitLog4jByte();
            }

				int nb_line_tWriteJSONField_1_In = 0;
				net.sf.json.xml.XMLSerializer xmlSerializer_tWriteJSONField_1_In = new net.sf.json.xml.XMLSerializer(); 
			    xmlSerializer_tWriteJSONField_1_In.clearNamespaces();
			    xmlSerializer_tWriteJSONField_1_In.setSkipNamespaces(true);
			    xmlSerializer_tWriteJSONField_1_In.setForceTopLevelObject(true);
				xmlSerializer_tWriteJSONField_1_In.setUseEmptyStrings(false);
				
					   java.util.Queue<row2Struct> queue_tWriteJSONField_1_In = (java.util.Queue<row2Struct>) globalMap.get("queue_tWriteJSONField_1_In");
					
				String readFinishMarkWithPipeId_tWriteJSONField_1_In = "tWriteJSONField_1_In_FINISH"+(queue_tWriteJSONField_1_In==null?"":queue_tWriteJSONField_1_In.hashCode());
				String str_tWriteJSONField_1_In = null;
				
				while(!globalMap.containsKey(readFinishMarkWithPipeId_tWriteJSONField_1_In) || !queue_tWriteJSONField_1_In.isEmpty()) {
					if (!queue_tWriteJSONField_1_In.isEmpty()) {
			

 



/**
 * [tWriteJSONField_1_In begin ] stop
 */
	
	/**
	 * [tWriteJSONField_1_In main ] start
	 */

	

	
	
		currentVirtualComponent = "tWriteJSONField_1";
	
	currentComponent="tWriteJSONField_1_In";

	

                    row2Struct result_tWriteJSONField_1_In = queue_tWriteJSONField_1_In.poll();
                    str_tWriteJSONField_1_In = result_tWriteJSONField_1_In.;
        //Convert XML to JSON
        net.sf.json.JsonStandard jsonStandard_tWriteJSONField_1_In =  net.sf.json.JsonStandard.LEGACY  ;
        xmlSerializer_tWriteJSONField_1_In.setJsonStandard(jsonStandard_tWriteJSONField_1_In);
        net.sf.json.JSON json_tWriteJSONField_1_In = xmlSerializer_tWriteJSONField_1_In.read(str_tWriteJSONField_1_In);
        row2. = net.sf.json.util.JSONUtils.jsonToStandardizedString(json_tWriteJSONField_1_In, jsonStandard_tWriteJSONField_1_In);
    
        nb_line_tWriteJSONField_1_In++;

 


	tos_count_tWriteJSONField_1_In++;

/**
 * [tWriteJSONField_1_In main ] stop
 */
	
	/**
	 * [tWriteJSONField_1_In process_data_begin ] start
	 */

	

	
	
		currentVirtualComponent = "tWriteJSONField_1";
	
	currentComponent="tWriteJSONField_1_In";

	

 



/**
 * [tWriteJSONField_1_In process_data_begin ] stop
 */

	
	/**
	 * [tLogRow_1 main ] start
	 */

	

	
	
	currentComponent="tLogRow_1";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row2"
						
						);
					}
					
    			if(log.isTraceEnabled()){
    				log.trace("row2 - " + (row2==null? "": row2.toLogString()));
    			}
    		
///////////////////////		
						

				
				String[] row_tLogRow_1 = new String[0];
 

				util_tLogRow_1.addRow(row_tLogRow_1);	
				nb_line_tLogRow_1++;
                	log.info("tLogRow_1 - Content of row "+nb_line_tLogRow_1+": " + TalendString.unionString("|",row_tLogRow_1));
//////

//////                    
                    
///////////////////////    			

 


	tos_count_tLogRow_1++;

/**
 * [tLogRow_1 main ] stop
 */
	
	/**
	 * [tLogRow_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tLogRow_1";

	

 



/**
 * [tLogRow_1 process_data_begin ] stop
 */
	
	/**
	 * [tLogRow_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tLogRow_1";

	

 



/**
 * [tLogRow_1 process_data_end ] stop
 */



	
	/**
	 * [tWriteJSONField_1_In process_data_end ] start
	 */

	

	
	
		currentVirtualComponent = "tWriteJSONField_1";
	
	currentComponent="tWriteJSONField_1_In";

	

 



/**
 * [tWriteJSONField_1_In process_data_end ] stop
 */
	
	/**
	 * [tWriteJSONField_1_In end ] start
	 */

	

	
	
		currentVirtualComponent = "tWriteJSONField_1";
	
	currentComponent="tWriteJSONField_1_In";

	

					}
				}
				
					String readFinishWithExceptionMarkWithPipeId_tWriteJSONField_1_In = "tWriteJSONField_1_In_FINISH_WITH_EXCEPTION"+(queue_tWriteJSONField_1_In==null?"":queue_tWriteJSONField_1_In.hashCode());
					if(globalMap.containsKey(readFinishWithExceptionMarkWithPipeId_tWriteJSONField_1_In)){
						if(!(globalMap instanceof java.util.concurrent.ConcurrentHashMap)) {
							globalMap.put(readFinishWithExceptionMarkWithPipeId_tWriteJSONField_1_In, null);// syn
						}
						globalMap.remove(readFinishWithExceptionMarkWithPipeId_tWriteJSONField_1_In);
						return;
					}
					globalMap.remove("queue_tWriteJSONField_1_In");
    			
				if(!(globalMap instanceof java.util.concurrent.ConcurrentHashMap)) {
					globalMap.put(readFinishMarkWithPipeId_tWriteJSONField_1_In,null);//syn
				}
				globalMap.remove(readFinishMarkWithPipeId_tWriteJSONField_1_In);
			
globalMap.put("tWriteJSONField_1_NB_LINE",nb_line_tWriteJSONField_1_In);
				log.debug("tWriteJSONField_1_In - Processed records count: " + nb_line_tWriteJSONField_1_In + " .");
			
 
                if(log.isDebugEnabled())
            log.debug("tWriteJSONField_1_In - "  + ("Done.") );

ok_Hash.put("tWriteJSONField_1_In", true);
end_Hash.put("tWriteJSONField_1_In", System.currentTimeMillis());




/**
 * [tWriteJSONField_1_In end ] stop
 */

	
	/**
	 * [tLogRow_1 end ] start
	 */

	

	
	
	currentComponent="tLogRow_1";

	


//////

                    
                    java.io.PrintStream consoleOut_tLogRow_1 = null;
                    if (globalMap.get("tLogRow_CONSOLE")!=null)
                    {
                    	consoleOut_tLogRow_1 = (java.io.PrintStream) globalMap.get("tLogRow_CONSOLE");
                    }
                    else
                    {
                    	consoleOut_tLogRow_1 = new java.io.PrintStream(new java.io.BufferedOutputStream(System.out));
                    	globalMap.put("tLogRow_CONSOLE",consoleOut_tLogRow_1);
                    }
                    
                    consoleOut_tLogRow_1.println(util_tLogRow_1.format().toString());
                    consoleOut_tLogRow_1.flush();
//////
globalMap.put("tLogRow_1_NB_LINE",nb_line_tLogRow_1);
                if(log.isInfoEnabled())
            log.info("tLogRow_1 - "  + ("Printed row count: ")  + (nb_line_tLogRow_1)  + (".") );

///////////////////////    			

				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"row2");
			  	}
			  	
 
                if(log.isDebugEnabled())
            log.debug("tLogRow_1 - "  + ("Done.") );

ok_Hash.put("tLogRow_1", true);
end_Hash.put("tLogRow_1", System.currentTimeMillis());




/**
 * [tLogRow_1 end ] stop
 */



				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				    if(!(e instanceof TalendException)){
					   log.fatal(currentComponent + " " + e.getMessage(),e);
					}
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
					te.setVirtualComponentName(currentVirtualComponent);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tWriteJSONField_1_In finally ] start
	 */

	

	
	
		currentVirtualComponent = "tWriteJSONField_1";
	
	currentComponent="tWriteJSONField_1_In";

	

 



/**
 * [tWriteJSONField_1_In finally ] stop
 */

	
	/**
	 * [tLogRow_1 finally ] start
	 */

	

	
	
	currentComponent="tLogRow_1";

	

 



/**
 * [tLogRow_1 finally ] stop
 */



				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tWriteJSONField_1_In_SUBPROCESS_STATE", 1);
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
	public String contextStr = "Default";
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
		final tzygg tzyggClass = new tzygg();

		int exitCode = tzyggClass.runJobInTOS(args);
		if (exitCode == 0) {
			log.info("TalendJob: 'tzygg' - Done.");
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
		log.info("TalendJob: 'tzygg' - Start.");

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
			java.io.InputStream inContext = tzygg.class.getClassLoader()
					.getResourceAsStream("salesforce/tzygg_0_1/contexts/" + contextStr + ".properties");
			if (inContext == null) {
				inContext = tzygg.class.getClassLoader()
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

		this.globalResumeTicket = false;// to run others jobs

		try {
			errorCode = null;
			tRowGenerator_1Process(globalMap);
			if (!"failure".equals(status)) {
				status = "end";
			}
		} catch (TalendException e_tRowGenerator_1) {
			globalMap.put("tRowGenerator_1_SUBPROCESS_STATE", -1);

			e_tRowGenerator_1.printStackTrace();

		}

		this.globalResumeTicket = true;// to run tPostJob

		end = System.currentTimeMillis();

		if (watch) {
			System.out.println((end - startTime) + " milliseconds");
		}

		endUsedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		if (false) {
			System.out.println((endUsedMemory - startUsedMemory) + " bytes memory increase when running : tzygg");
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
 * 75811 characters generated by Talend Open Studio for ESB on the 13 août 2024
 * à 9:30:45 AM CET
 ************************************************************************************************/