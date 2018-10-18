
package inlamningsuppgift2;

import org.junit.Test;
import junit.framework.TestCase;

public class CustomerTest {
    
          Customer c = new Customer("Test Testsson", "801020", "2018-01-15");
          Customer c2 = new Customer("Testarn Felnummer", "1115111234", "2017-12-02");
          Customer c3 = new Customer("Testarn Felnummer", "1115351234", "2017-12-02");
          Customer c4 = new Customer("Testarn Felnummer", "1115351234", "2017-12-02");

          @Test
          public final void whenExpiresCurrentMembershipTest() { 
                    TestCase.assertTrue(c.getDateofMembershipExpiration().matches("2019-01-14"));
                    TestCase.assertFalse(c.getDateofMembershipExpiration().matches("2018-03-20"));
          }
         
          @Test
          public final void needToCheckPersonalIdentityNumberTest()  {
                    TestCase.assertTrue(c2.needToCheckPersonalIdentityNumber());
                    TestCase.assertFalse(c.needToCheckPersonalIdentityNumber());
                    TestCase.assertTrue(c3.needToCheckPersonalIdentityNumber());
                    TestCase.assertTrue(c4.needToCheckPersonalIdentityNumber());
          }    
          
          @Test
          public final void welcomeCurrentMemberTest() {
                    TestCase.assertTrue(c.welcomeCurrentMember().matches(c.getName() + " är välkommen att träna. "
                              + "Nuvarande årsavgift är giltig till och med " + c.getDateofMembershipExpiration()));
                    TestCase.assertFalse(c.welcomeCurrentMember().matches("This will not make green!"));
          }
}
