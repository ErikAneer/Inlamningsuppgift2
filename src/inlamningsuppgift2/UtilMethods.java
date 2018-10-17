
package inlamningsuppgift2;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import javax.swing.JOptionPane;

public class UtilMethods {
            
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
         } 
         
         public boolean checkIfCurrentMember(Customer c){
                  return LocalDate.now().minus(12, ChronoUnit.MONTHS)
                           .isBefore(LocalDate.parse(c.getLastMemberShipDate()));  
          } 
         
         public String printMessageForNonMember() {
                  StringBuilder sb = new StringBuilder( "Det namn eller personnummer "
                                             + "som har angetts matchar ingen tidigare registrerad kund."
                                             + "\nFörsök igen och kontrollera gärna att du skrev in rätt"
                                             + " personnummer eller namn genom att få se besökarens ID."
                                             + "\nEller se till att personen skriver in sig på gymmet om det är en ny kund.");
                  JOptionPane.showMessageDialog(null,  sb);
                  return sb.toString();
         } 
         
         public String extraMessageNeeded (Customer c, String message){ 
                  if (c.needToCheckPersonalIdentityNumber()) {
                          return message;
                  }
                  else return "";
         }
} 
