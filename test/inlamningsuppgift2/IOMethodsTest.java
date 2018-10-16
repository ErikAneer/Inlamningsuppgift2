
package inlamningsuppgift2;

import org.junit.Test;
import junit.framework.TestCase;
import java.util.*;

public class IOMethodsTest {
    
    Customer c = new Customer("Test Testsson", "8008080165", "2018-01-15");
    String filePath = "src\\inlamningsuppgift2\\customers.txt";
    List<Customer>  gymCustomers = IOMethods.readFromFile(filePath);
    String writeFilePath = "src\\inlamningsuppgift2\\gymVisits.txt";
    
//    @Test
//    public final void readFromFileandCreateCustomerListTest(){
//                TestCase.assertTrue(IOMethods.readFromFile(filePath) == gymCustomers);
//
//    }
    
    // Fråga Sigrun, hur kan man testa ngt för att se att inläsning är korrekt som detta? 
    
//    @Test
//    public final void recordGymVisitTest(){
//            TestCase.assertTrue(IOMethods.recordGymVisit(writeFilePath, c) == true);
//    
//    }
       @Test
       public final void readCustomeInputtest(){
                    
       
       
       }
        
}
