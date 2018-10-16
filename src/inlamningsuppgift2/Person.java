
package inlamningsuppgift2;

abstract class Person {
    
          protected String name;
          protected String personalIdentityNumber;
            
          public Person (String name, String personalSecurityNumber){
                    this.name = name;
                    this.personalIdentityNumber = personalSecurityNumber;   
          }
          
          public Person(){} 
          
          public String getName(){
                    return name;
          }
          
          public String getprsonalIdentityNumber(){
                    return personalIdentityNumber;
          }
          
                  
}
