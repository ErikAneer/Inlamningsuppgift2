
package inlamningsuppgift2;

import java.util.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import javax.swing.JOptionPane;

public class IOMethods {
    
         public static List<Customer> readFromFile(String fileToRead){
                  
                  String firstRow;
                  String secondRow ="";
                  Path filePath = Paths.get(fileToRead);
                  
                  List<Customer> gymCustomers = new ArrayList();
                  String [] firstRowPersonalData = new String[2];
                  
                  try (Scanner fileScan = new Scanner (filePath)){
                            
                          while(fileScan.hasNext()){
                                   firstRow = fileScan.nextLine();
                                   firstRowPersonalData = firstRow.split(",");
                                   if (fileScan.hasNext()){
                                             secondRow = fileScan.nextLine();
                                   }
                           
                          Customer c = new Customer(firstRowPersonalData[1].trim(), 
                                    firstRowPersonalData[0].trim(), secondRow.trim());
                           
                          gymCustomers.add(c);
                          } // end while
                  }
                  catch (FileNotFoundException e){
                           JOptionPane.showMessageDialog(null, "Målfilen att läsa ifrån kunde inte hittas.Vänligen kontrollera sökvägen");
                           e.printStackTrace();
                           System.exit(0);
                  }
                  catch (IOException e){
                           JOptionPane.showMessageDialog(null, "Något gick fel vid inläsningen av filen.");
                           e.printStackTrace();
                           System.exit(0);
                  }
                  catch (Exception e){
                           JOptionPane.showMessageDialog(null, "Ett oväntat fel inträffade.");
                           e.printStackTrace();
                           System.exit(0);
                  }
                  
                  return gymCustomers;
                  
         } // end method readFromFile
         
         public static String readCustomeInput(){
         
                  String input = JOptionPane.showInputDialog( "Mata in gymbesökarens för och efternamn eller personnummer (10siffror): ");
             
                  if (input == null || input.equals(""))
                                    System.exit(0);

                  input = input .trim();
                  
                  return input;      
                  
         } // end readCustomerFromInput
         
        public static void recordGymVisit(String fileToWrite, Customer c){
                  
                 Path pathFileToWrite = Paths.get(fileToWrite); 

                 try (BufferedWriter out = Files.newBufferedWriter(pathFileToWrite,StandardCharsets.UTF_8,
                                                            StandardOpenOption.APPEND)){ 
                          out.write(c.getName() + " " + c.getprsonalIdentityNumber() + " "+ LocalDate.now() + "\n");
                          out.flush();
                 }
                 catch (FileNotFoundException e){
                          JOptionPane.showMessageDialog(null, "Filen kunde inte hittas");
                          e.printStackTrace();
                          System.exit(0);
                 }
                 catch (IOException e) {
                          JOptionPane.showMessageDialog(null, "Något gick fel när det skulle skrivas till filen.");
                          e.printStackTrace();
                          System.exit(0);
                 } 
                 catch (Exception e){
                          JOptionPane.showMessageDialog(null, "Något gick fel");
                          e.printStackTrace();
                          System.exit(0);
                    }
             
         } // end recordGymVisit
         
}
