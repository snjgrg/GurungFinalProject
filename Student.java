public class Student extends Person
{
//Student ID
 private int studId;
 
  public Student(String fName,String lName,String dateOfBirth,String gender,int studId)
  {
  super(fName,lName,dateOfBirth,gender);
  this.studId=studId;
  
  }
  //setter
  public void setstudId(int studId)
  {
    this.studId=studId;
  
  }
 //getter 
  public int getstudId()
  {
   return this.studId;
  }
 /*
 This method is to display the information.
  @return  String toString()
  */
  public String toString()
  {
  return super.toString()+"\n student Id:"+studId;
   }

 
 }