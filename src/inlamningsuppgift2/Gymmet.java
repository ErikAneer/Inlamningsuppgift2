
package inlamningsuppgift2;

import java.util.*;
import javax.swing.JOptionPane;
public class Gymmet {

          public static void main(String[] args) {
                    
                    UtilMethods u = new UtilMethods();
                    IOMethods io = new IOMethods();
                     
                    String filePathToRead = "src\\inlamningsuppgift2\\customers.txt";
                    String filePathToWrite = "src\\inlamningsuppgift2\\gymVisits.txt";
                    List<Customer>  gymCustomers = io.readFromFile(filePathToRead);

                    Customer temp;

                    while (true){
                              temp = u.isRegisteredCustomer(io.readCustomeInput(), gymCustomers);

                              if (temp != null){

                                        if (u.checkIfCurrentMember(temp)){
                                                    temp.welcomeCurrentMember();
                                                    io.recordGymVisit(filePathToWrite, temp);
                                        }
                                        else temp.remindCustomerToRenewMemberShip();
                              }
                              else {
                                          u.printMessageForNonMember();
                              }              
                     }
          }
}
