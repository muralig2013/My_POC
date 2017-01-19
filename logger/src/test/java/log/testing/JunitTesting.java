package log.testing;

import static org.junit.Assert.*;

import org.apache.log4j.Logger;
import org.junit.Test;

import learning.basics.log.Sample;

public class JunitTesting {
    
    public static final Logger logger = Logger.getLogger(JunitTesting.class);

    @Test
    public void addTesting() {
        
        logger.info("Entered in to addTesting method");
        Sample tester = new Sample(2); 
        
        // assert statements
        assertEquals("Value must be 15", 15, tester.add(10, 5));
        
        logger.info("Test Case Passed");
        Sample s = new Sample(1);
    }
}
