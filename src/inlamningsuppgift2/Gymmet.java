
package inlamningsuppgift2;

import java.util.*;
import javax.swing.JOptionPane;
public class Gymmet {

         public static void main(String[] args) {
               
                 String filePathToRead = "src\\inlamningsuppgift2\\customers.txt";
                 String filePathToWrite = "src\\inlamningsuppgift2\\gymVisits.txt";
                 List<Customer>  gymCustomers = IOMethods.readFromFile(filePathToRead);
               
                  Customer temp = new Customer();

                  boolean loop = true;
                  boolean isCurrrentMember = false;
                  while (loop){
                             
                          temp = temp.isRegisteredCustomer(IOMethods.readCustomeInput(), gymCustomers);
                          
                          if (temp != null){
                                   isCurrrentMember = temp.checkIfCurrentMember();
                                   if (isCurrrentMember == true){
                                           IOMethods.recordGymVisit(filePathToWrite, temp);
                                           temp.welcomeCurrentMember();
                                   }
                                   else temp.remindCustomerToRenewMemberShip();
                                       
                          }
                          else {
                                  JOptionPane.showMessageDialog(null,  "Det namn eller personnummer som har angetts matchar ingen tidigare registrerad kund."
                                           + "\nFörsök igen och kontrollera att du skrev in rätt eller testa ange personnummer eller namn istället.");
                          }              
                 }
               
    }
    
}
