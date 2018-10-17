
package inlamningsuppgift2;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import javax.swing.JOptionPane;

public class Customer extends Person implements ICustomerInterface {
         
         UtilMethods u = new UtilMethods();
         
         protected String lastMemberShipDate;
          
         public Customer(){}
            
         public Customer(String name, String personalSecurityNumber, String lastMemberShipDate) {
                   super(name, personalSecurityNumber);
                   this.lastMemberShipDate = lastMemberShipDate;
         }
         
         public String getLastMemberShipDate(){
                   return lastMemberShipDate;
          }
          
         public boolean needToCheckPersonalIdentityNumber(){
                  int birthYear = Integer.parseInt(getprsonalIdentityNumber().substring(0, 2));
                  int month = Integer.parseInt(getprsonalIdentityNumber().substring(2, 4));
                  
                  if (birthYear < 15 || month > 12) {
                           return true;
                  }
                  else {
                          return false;
                  }
         }
          
         @Override
         public String getDateofMembershipExpiration(){
	return LocalDate.parse(this.getLastMemberShipDate()).plus(12, ChronoUnit.MONTHS).minus(1, ChronoUnit.DAYS).toString();      
          }     
          
         @Override     
         public void welcomeCurrentMember(){
                  StringBuilder sb = new StringBuilder( this.getName() + " är välkommen att träna. "
                        + "Nuvarande årsavgift är giltig till och med " + this.getDateofMembershipExpiration());
                  
                  String extramessage = "\nMEN kontrollera ID på kunden för att se personnummer eftersom det i vårt register ser konstigt ut! " +
                          "\nNotera personnumret så vi kan registrera det riktiga.";
                  
                  sb.append(u.extraMessageNeeded(this, extramessage));
                  JOptionPane.showMessageDialog(null,sb);
         }
          
         public void remindCustomerToRenewMemberShip(){
                  StringBuilder sb = new StringBuilder( "Medlemsskapet för " + this.getName() + " gick ut " 
                           + this.getDateofMembershipExpiration() + ". Påminn om att det är dags att förnya för att fortsätta träna.");
                  
                  String extramessage = "\nMEN kontrollera ID på kunden om hen förnyar för att se personnummer eftersom det i vårt register inte är korrekt! ";
                  
                  sb.append(u.extraMessageNeeded(this, extramessage));
                  JOptionPane.showMessageDialog(null,sb);          
         }                 
}      
