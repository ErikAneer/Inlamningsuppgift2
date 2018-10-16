
package inlamningsuppgift2;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import org.junit.Test;
import junit.framework.TestCase;

public class CustomerTest {
    
    Customer c = new Customer("Test Testsson", "8008080165", "2018-01-15");
    Customer c2 = new Customer("Bear Belle", "8104021234", "2017-12-02");
    String filePath = "src\\inlamningsuppgift2\\customers.txt";
    String filePathToWrite = "src\\inlamningsuppgift2\\gymVisits.txt";
    List<Customer>  gymCustomers = IOMethods.readFromFile(filePath);
    

         @Test
         public final void isRegisteredCustomerTest(){
                   TestCase.assertTrue(c.isRegisteredCustomer("Bear Belle",gymCustomers).getprsonalIdentityNumber().matches("8104021234"));
                   TestCase.assertFalse(c.isRegisteredCustomer("Bear Belle",gymCustomers).getprsonalIdentityNumber().matches("8008080165"));
                   TestCase.assertTrue(c.isRegisteredCustomer("8104021234",gymCustomers).getName().matches("Bear Belle"));
                   TestCase.assertFalse(c.isRegisteredCustomer("Bear Belle",gymCustomers).getName().matches("Test Testsson"));

         }
         @Test
         public final void isCurrentMemberTest(){
                    TestCase.assertTrue(c.checkIfCurrentMember() == true);
                    TestCase.assertFalse(c.checkIfCurrentMember() == false);
         }
         @Test
         public final void whenExpiresCurrentMembershipTest(){ 
                    TestCase.assertTrue(c.getDateofMembershipExpiration().matches("2019-01-15") == true);
                    TestCase.assertFalse(c.getDateofMembershipExpiration().matches("2018-03-20") == true);
         
         
         }
}
