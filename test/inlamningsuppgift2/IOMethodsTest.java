
package inlamningsuppgift2;

import java.time.LocalDate;
import org.junit.Test;
import junit.framework.TestCase;
import java.util.*;

public class IOMethodsTest {
    
          Customer c = new Customer("Test Testsson", "8008080165", "2018-01-15");
          String filePath = "src\\inlamningsuppgift2\\customers.txt";
          IOMethods io = new IOMethods();
          List<Customer>  gymCustomers = io.readFromFile(filePath);
          String writeFilePath = "src\\inlamningsuppgift2\\gymVisits.txt";
         
          @Test
          public final void recordGymVisitTest(){
                     TestCase.assertTrue(io.recordGymVisit(writeFilePath, c).matches(
                             "Test Testsson 8008080165 " + LocalDate.now() + "\n"));
                     TestCase.assertFalse(io.recordGymVisit(writeFilePath, c).matches(
                             "This will not make green!"));
          }
        
}
