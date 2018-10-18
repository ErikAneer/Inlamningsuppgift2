
package inlamningsuppgift2;

import java.util.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import javax.swing.JOptionPane;

public class IOMethods {
    
         public List<Customer> readFromFile(String fileToRead) {
                  
                  String firstRow;
                  String secondRow ="";
                  Path filePath = Paths.get(fileToRead);
                  List<Customer> gymCustomers = new ArrayList();
                  String [] firstRowPersonalData = new String[2];
                  
                  try (Scanner fileScan = new Scanner (filePath)) {
                            
                          while(fileScan.hasNext()){
                                   firstRow = fileScan.nextLine();
                                   firstRowPersonalData = firstRow.split(",");
                                   if (fileScan.hasNext()){
                                             secondRow = fileScan.nextLine();
                                   }
                           
                          Customer c = new Customer(firstRowPersonalData[1].trim(), 
                                   firstRowPersonalData[0].trim(), secondRow.trim());
                           
                          gymCustomers.add(c);
                          } 
                  }
                  catch (FileNotFoundException e) {
                           JOptionPane.showMessageDialog(null, "Målfilen att läsa ifrån kunde inte hittas.Vänligen kontrollera sökvägen");
                           e.printStackTrace();
                           System.exit(0);
                  }
                  catch (IOException e) {
                           JOptionPane.showMessageDialog(null, "Något gick fel vid inläsningen av filen.");
                           e.printStackTrace();
                           System.exit(0);
                  }
                  catch (Exception e) {
                           JOptionPane.showMessageDialog(null, "Ett oväntat fel inträffade.");
                           e.printStackTrace();
                           System.exit(0);
                  }
                  return gymCustomers;
         } 
         
         public String readCustomeInput() {
                  String input = JOptionPane.showInputDialog( 
                          "Mata in gymbesökarens för och efternamn (med blanksteg emellan)\neller personnummer (10siffror enligt modellen ÅÅMMDDXXXX): ");
             
                  if (input == null || input.equals(""))
                          System.exit(0);

                  input = input .trim();
                  return input;      
         }
         
         public String recordGymVisit(String fileToWrite, Customer c) {  
                  Path pathFileToWrite = Paths.get(fileToWrite); 
                  String returnStringOnlyForTest =""; 

                  try (BufferedWriter out = Files.newBufferedWriter(pathFileToWrite,StandardCharsets.UTF_8,
                                                            StandardOpenOption.APPEND)) { 
                          out.write(c.getName() + " " + c.getprsonalIdentityNumber() + " "+ LocalDate.now() + "\n");
                          out.flush();
                          returnStringOnlyForTest = c.getName() + " " + c.getprsonalIdentityNumber() + " "+ LocalDate.now() + "\n";
                  }
                  catch (FileNotFoundException e) {
                          JOptionPane.showMessageDialog(null, "Filen att skriva gymbesöket kunde inte hittas.");
                          e.printStackTrace();
                          System.exit(0);
                  }
                  catch (IOException e) {
                          JOptionPane.showMessageDialog(null, "Något gick fel när det skulle skrivas till filen.");
                          e.printStackTrace();
                          System.exit(0);
                  } 
                  catch (Exception e) {
                          JOptionPane.showMessageDialog(null, "Något gick fe vid försök att registrera gymbesöket.");
                          e.printStackTrace();
                          System.exit(0);
                  }
                  return returnStringOnlyForTest;
         }     
}
