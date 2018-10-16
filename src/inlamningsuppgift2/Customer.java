
package inlamningsuppgift2;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import javax.swing.JOptionPane;

public class Customer extends Person implements ICustomerInterface {
         
         protected String lastMemberShipDate;
          
         public Customer(){}
            
         public Customer(String name, String personalSecurityNumber, String lastMemberShipDate) {
                   super(name, personalSecurityNumber);
                   this.lastMemberShipDate = lastMemberShipDate;
          }
         
          public String getLastMemberShipDate(){
                   return lastMemberShipDate;
          }
          @Override
          public String getDateofMembershipExpiration(){
	return LocalDate.parse(this.getLastMemberShipDate()).plus(12, ChronoUnit.MONTHS).minus(1, ChronoUnit.DAYS).toString();      
          }     
          
          @Override     
          public void welcomeCurrentMember(){
                   JOptionPane.showMessageDialog(null, this.getName() + " är välkommen att träna. "
                        + "Nuvarande årsavgift är giltig till och med " + this.getDateofMembershipExpiration());
          }
          
          public void remindCustomerToRenewMemberShip(){
                   JOptionPane.showMessageDialog(null, "Medlemsskapet för " + this.getName() + " gick ut " 
                           + this.getDateofMembershipExpiration() + ". Påminn om att det är dags att förnya för att fortsätta träna.");
          }

          public Customer isRegisteredCustomer(String nameOrPersonalSecurityNumber, 
                   List<Customer> gymCustomers) {
                             Customer temp = null;
                                     for (Customer c : gymCustomers){
                                               if(c.getName().equalsIgnoreCase(nameOrPersonalSecurityNumber) || 
                                                  c.getprsonalIdentityNumber().matches(nameOrPersonalSecurityNumber)){
                                                                   return temp =c;
                                               }
                                     }
                   return temp;                  
         } // end isRegisteredCustomer
        
          //@Override
          public boolean checkIfCurrentMember(){
                   if (LocalDate.now().minus(12, ChronoUnit.MONTHS)
                             .isBefore(LocalDate.parse(this.getLastMemberShipDate()))) {
                             return true;
                   }
                   else {
                            return false;
                   }  
          } // end isCurrentlyMember            
} // end class      
