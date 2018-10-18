
package inlamningsuppgift2;

import java.util.List;
import junit.framework.TestCase;
import org.junit.Test;


public class UtilMethodsTest {
    
           UtilMethods u = new UtilMethods();
           IOMethods io = new IOMethods();
           String filePath = "src\\inlamningsuppgift2\\customers.txt";
           List<Customer>  gymCustomers = io.readFromFile(filePath);
           Customer c = new Customer("Test Testsson", "8008080165", "2018-01-15");
           Customer c2 = new Customer("Bear Belle", "8104021234", "2017-12-02");
           Customer c3 = new Customer("Ida Idylle", "2222222222", "2016-03-07");
           String extraMessage = "testing testing....";
         
          @Test
          public final void isRegisteredCustomerTest() {
                     TestCase.assertTrue(u.isRegisteredCustomer("Bear Belle",gymCustomers).getprsonalIdentityNumber().matches("8104021234"));
                     TestCase.assertFalse(u.isRegisteredCustomer("Bear Belle",gymCustomers).getprsonalIdentityNumber().matches("8008080165"));
                     TestCase.assertTrue(u.isRegisteredCustomer("8104021234",gymCustomers).getName().matches("Bear Belle"));
                     TestCase.assertFalse(u.isRegisteredCustomer("Bear Belle",gymCustomers).getName().matches("Test Testsson"));
          }
         
           @Test
           public final void isCurrentMemberTest() {
                    TestCase.assertTrue(u.checkIfCurrentMember(c));
                    TestCase.assertFalse(u.checkIfCurrentMember(c3));
         }
         
          @Test
           public final void checkIfAdditionalMesseageIsNeededTest() {
                     TestCase.assertTrue(u.extraMessageNeeded(c3, extraMessage).matches(extraMessage));
                     TestCase.assertFalse(u.extraMessageNeeded(c3, extraMessage).matches("this is not true"));
                     TestCase.assertFalse(u.extraMessageNeeded(c3, extraMessage).matches(""));
           }
         
          @Test public final void printMessageForNonMemberTest() {
                     String expectedOutputMessage = "Det namn eller personnummer som "
                                         + "har angetts matchar ingen tidigare registrerad kund."
                                         + "\nFörsök igen och kontrollera gärna att du skrev in rätt"
                                         + " personnummer eller namn genom att få se besökarens ID."
                                         + "\nEller se till att personen skriver in sig på gymmet om det är en ny kund.";
                  
                     TestCase.assertTrue(u.printMessageForNonMember().matches(expectedOutputMessage));
                     TestCase.assertFalse(u.printMessageForNonMember().matches("Testing")); 
           }
}
