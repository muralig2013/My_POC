package learning.basics.log;
import org.apache.log4j.Logger;

public class Sample {
    
    public static final Logger logger = Logger.getLogger(Sample.class);
    
    int id ;
    
    public Sample(int id){
       this.id = id; 
    }

    public static void main(String[] args) {
        
        logger.info("Entered in to main method");
        
        add(5, 10);
        
        logger.info("end of main method");
        
    }
    
    public static int add(int a, int b){
        logger.info("add method invoked");
        
        logger.info("Sum : " +(a + b));
        
        logger.info("end of add method");
        
        return (a + b);
        
    }

}
