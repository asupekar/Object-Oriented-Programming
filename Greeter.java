package asupekar_hw1;

import java.io.FileNotFoundException;
import java.util.Map;

public class Greeter {
   
    private Template template;
    
    /**
     * Constructor to instantiate template
     * 
     * @param s String to be instantiate in template
     * @throws FileNotFoundException
     */
    public Greeter(String s) throws FileNotFoundException {
        template = new Template(s);
    }
    
    /**
     * To instantiate template
     * 
     * @param vars Hash map
     * @param isRandom Boolean flag
     * @return Instantiated template string
     * @throws Exception
     */
    public String getGreeting(Map<String, String> vars, boolean isRandom) throws Exception {
        return template.instantiate(vars, isRandom);
    }
    
}