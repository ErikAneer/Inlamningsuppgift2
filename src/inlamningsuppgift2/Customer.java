
package inlamningsuppgift2;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import javax.swing.JOptionPane;

public class Customer extends Person implements ICustomerInterface {
         
         UtilMethods u = new UtilMethods();
         
         protected String lastMemberShipDate;
          
         public Customer() {}
            
         public Customer(String name, String personalSecurityNumber, String lastMemberShipDate) {
                   super(name, personalSecurityNumber);
                   this.lastMemberShipDate = lastMemberShipDate;
         }
         
         public String getLastMemberShipDate() {
                   return lastMemberShipDate;
         }
          
         public boolean needToCheckPersonalIdentityNumber() { 
                 /*
                 Obs! Denna metod är skapad för att försöka fånga upp de personer som i customer.txt har ett personnummer som inte verkar riktigt och för 
                 att få en chans att korrigera dem kunddatan. Metoden behövs egentligen inte för programmet i uppgiften. 
                 Jag tolkade personnumren 111111111111, 2222222222 och 1212121212 som att de kan vara personnummer som förlorats vid datakraschen
                 och bör kontrolleras.
                 Metoden är bara till för att fånga upp personnummer som inte verkar ok i filen, den ska inte räkna ut exakt ålder.  
                 Jag har antagit att omyndiga inte får teckna årskort på gymmet och att det inte är sannolikt att någon som är älrde än 110 år går på gym.
                 Metoden är inte 100% komplett så den fångar inte upp folk som fyller 18 under året och inte heller inte upp att februari, april, juni, 
                 september och november har mindre än 31 dagar och fel i personnummer kan finnas där. Jag har heller inte tagit hänsyn till om någon
                 exempelvis pga skyddad identitet fått ett annrolunda personnummer på gymmet enligt de avikande numren ovan. Såsom metoden är 
                 skapad ska den fungera fram till 2027. 
                 */
                 
                 Calendar now = Calendar.getInstance();
                 int year = (now.get(Calendar.YEAR)-1900) - Integer.parseInt(getprsonalIdentityNumber().substring(0, 2));
                      if (getprsonalIdentityNumber().substring(0, 1).matches("0"))
                              year = year - 100;
                 int month = Integer.parseInt(getprsonalIdentityNumber().substring(2, 4));
                 int day = Integer.parseInt(getprsonalIdentityNumber().substring(4, 6));
                 
                 System.out.println(year);
                 return year <= 17 || year > 110 || month > 12 || day >31;
                 
         }
          
         @Override
         public String getDateofMembershipExpiration() {
	return LocalDate.parse(this.getLastMemberShipDate()).plus(12, ChronoUnit.MONTHS).minus(1, ChronoUnit.DAYS).toString();      
          }     
          
         @Override     
         public String welcomeCurrentMember() {
                  StringBuilder sb = new StringBuilder( this.getName() + " är välkommen att träna. "
                        + "Nuvarande årsavgift är giltig till och med " + this.getDateofMembershipExpiration());
                  String returnStringForTestOnly = sb.toString();
                  String extramessage = "\nMEN kontrollera ID på kunden för att se personnummer eftersom det i vårt register inte verkar stämma! " +
                          "\nNotera personnumret så vi kan registrera det riktiga.";
                  
                  sb.append(u.extraMessageNeeded(this, extramessage));
                  JOptionPane.showMessageDialog(null,sb);
                  return returnStringForTestOnly; 
         }
          
         public void remindCustomerToRenewMemberShip() {
                  StringBuilder sb = new StringBuilder( "Medlemsskapet för " + this.getName() + " gick ut " 
                           + this.getDateofMembershipExpiration() + ". Påminn om att det är dags att förnya för att fortsätta träna.");
                  
                  String extramessage = "\nMEN kontrollera ID på kunden om hen förnyar sitt medlemsskap "
                          + "för att se personnummer eftersom det  i vårt register inte verkar stämma! ";
                  
                  sb.append(u.extraMessageNeeded(this, extramessage));
                  JOptionPane.showMessageDialog(null,sb);          
         }                 
}      
