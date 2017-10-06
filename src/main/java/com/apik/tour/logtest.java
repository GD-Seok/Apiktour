package com.apik.tour;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//logback을 설정하는 파일입니다.
/**
 * This is a Java console app that you can execute within your IDE for visual
 * confirmation that the SLF4J system is appending to console and/or file as
 * specified in the logging config (i.e. resources/logback.xml). It is also
 * useful for a quick visual test when you change the pattern of log statements
 * via.
 * 
 * <p>
 * In Eclipse or an Eclipse-based IDE, right-click SLF4JConsoleTest.java and
 * either select Run As > Java Application or press ALT+SHIFT+X,J.
 * </p>
 * 
 * <p>
 * As a result, you should typically see test messages from all log levels
 * (TRACE, DEBUG, INFO, WARN, ERROR) both on the console view of your IDE and in
 * any log files created by file appenders defined in the logging config.
 * </p>
 * 
 * @author Cody Burleson
 */

public class logtest {

	static final Logger LOG = LoggerFactory.getLogger(logtest.class);

	/**
	 * @param args
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		logtest console = new logtest();
		console.execute();
	}

	public logtest() {
	}

	public void execute() {

		if (LOG.isTraceEnabled()) {
			LOG.trace("Test: TRACE level message.");
		}
		if (LOG.isDebugEnabled()) {
			LOG.debug("Test: DEBUG level message.");
		}
		if (LOG.isInfoEnabled()) {
			LOG.info("Test: INFO level message.");
		}
		if (LOG.isWarnEnabled()) {
			LOG.warn("Test: WARN level message.");
		}
		if (LOG.isErrorEnabled()) {
			LOG.error("Test: ERROR level message.");
		}
	}

}
