
/******************************************************************************************
  *File Name: Person
  *Purpose: Write, read the file to store information. You can edit the file like add, delete 
            and store student information.  
  * 
  *Programmer: Sanjay Gurung
  *Last Updated Date: Dec 4,2016
  *****************************************************************************************/




public class Person
{
private String fName;
private String lName;
private String dateOfBirth;
private String gender;

//Default Constructor
   public Person(){
      this.fName = "Sanjay";
      this.lName = "Gurung";
      this.dateOfBirth = "12-01-1980";
      this.gender = "Male";
   }
   //Constructor
   public Person(String fName,String lName,String dateOfBirth,String gender)
   {
    this.fName=fName;
    this.lName=lName;
    this.dateOfBirth=dateOfBirth;
    this.gender=gender;
 
   }
     //Setter and Getter
   
   public void setfName(String fName)
   {
    this.fName=fName;
   }
   public String getfName()
   {
    return this.fName;
   }
   
    public void setlName(String lName)
   {
    this.lName=lName;
   }
   public String getlName()
   {
    return this.lName;
   }
   
    public void setdateOfBirth(String dateOfBirth)
   {
    this.dateOfBirth=dateOfBirth;
   }
   public String getdateOfBirth()
   {
    return this.dateOfBirth;
   }
   
    public void setgender(String gender)
   {
    this.gender=gender;
   }
   public String getgender()
   {
    return this.gender;
   }
/*
 * This method return the String.
 * @ return toString()
 */

 public String toString()
  {
   return " first name: "+this.fName+"\n last name:"+this.lName+"\n date of birth:"+this.dateOfBirth;
  
  }

   
   
   
}