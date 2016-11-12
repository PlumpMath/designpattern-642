package designpattern.behavior.chainofresponsability;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ChainOfResponsabilityTest  {
	
	private PrintStream old = System.out;
	private ByteArrayOutputStream baos = new ByteArrayOutputStream();
	private PrintStream ps = new PrintStream(baos);
	
	@Before
	public void beforeTests() {
	    System.setOut(ps);
	}
	
	@After
	public void afterTest() {
		System.setOut(old);
	}	
	
	private static AbstractLogger getChainOfLoggers() {
		AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);
		AbstractLogger fileLogger = new FileLogger(AbstractLogger.DEBUG);
		AbstractLogger consoleLogger = new ConsoleLogger(AbstractLogger.INFO);
		
		errorLogger.setNextLogger(fileLogger);
		fileLogger.setNextLogger(consoleLogger);
		
		return errorLogger;
	}
	
	@Test
	public void testChainOfResponsability() {
		AbstractLogger loggerChain = getChainOfLoggers();
		
		loggerChain.logMessage(AbstractLogger.INFO, "This is an information.");
		loggerChain.logMessage(AbstractLogger.DEBUG, "This is an debug level information.");
		loggerChain.logMessage(AbstractLogger.ERROR, "This is an error information.");
		
		String message = "Standard Console::Logger: This is an information.\r\n" + 
							"File::Logger: This is an debug level information.\r\n" +
							"Standard Console::Logger: This is an debug level information.\r\n" +
							"Error Console::Logger: This is an error information.\r\n" +
							"File::Logger: This is an error information.\r\n" +
							"Standard Console::Logger: This is an error information.\r\n";
		assertEquals(message, baos.toString());
	}

}
