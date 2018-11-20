import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;




public class studentHouse extends JFrame{
	
	//Arraylist to hold data in myStudents 
   ArrayList<Student> myStudents = new ArrayList<>();
   JPanel panel;
   JPanel panel1;
   JPanel panel2;
   JPanel panel3;
   JPanel panel4;
   JPanel panel5;
   JTextField fName;
   JTextField lName;
   JTextField DateOfBirth;
   JTextField gender;

   JTextField studId;
   JRadioButton male;
   JRadioButton female;
   String currentGender;
   int currentID;
   ButtonGroup group=new ButtonGroup();
   JTable viewTable;
   DefaultTableModel viewModel;
   
   
   public static void main(String[]args){
      studentHouse myStudent = new studentHouse();
      myStudent.LoadStudents();
      myStudent.MainView();
      
      
   }
   
    //This method is to load program.
    
   public void LoadStudents(){
      
      BufferedReader br;
      try{
         br = new BufferedReader(new FileReader("studentinfo.txt"));
         
         try {
            String line;
            while( (line = br.readLine()) != null ) {
               String tempArr[] = line.split(",");
               Student stud=new Student(tempArr[0],tempArr[1],tempArr[2],tempArr[3],Integer.parseInt(tempArr[4]));    	 
               myStudents.add(stud);		   
            }
            
         }
         catch (Exception e) {
            e.printStackTrace();
         }
            
      }
      catch (Exception e) {
         e.printStackTrace();
         System.out.print(e);
      }
      currentID = studentID();
      
   }
   
 // This method is main View method.
   public void MainView(){
   
      System.out.println("MainView");
      getContentPane().removeAll();// It remove all contents in panel
      getContentPane().repaint();// It repaint the panel with blank
   
      JButton newStudentBtn; // add information button
      
      JButton ViewStudentInfoBtn;// View Button
   
      setTitle("Data house");
      setSize(800,800);
      setResizable(false);
    
      panel=new JPanel();
      panel.setBackground(Color.WHITE);
    
      newStudentBtn=new JButton("add information");
      ViewStudentInfoBtn=new JButton("View information");
      newStudentBtn.setPreferredSize(new Dimension(200,100));
      ViewStudentInfoBtn.setPreferredSize(new Dimension(200,100));
    
    
      panel.add(newStudentBtn);
      panel.add(ViewStudentInfoBtn);    
    
      add(panel);
   // setLocationRelativeTo(null);
      setVisible(true);
    
      setDefaultCloseOperation(EXIT_ON_CLOSE);
    
      //Action listener
      newStudentBtn.addActionListener(
            e->{
               
               addStudent(); //call method
            });
            
      ViewStudentInfoBtn.addActionListener(
            e->{
               viewStudent(); //call method 
            });
   
   }
   /*
   this is method that can help me to add information on file
   getContentPane().removeAll(), This  clear the panel.
   getContentPane().repaint(), It help us to repaint the new panel again.
  
   */
   public  void addStudent(){
      getContentPane().removeAll();
      getContentPane().repaint();
       
          
      setTitle("Information Sheet");
      setSize(800,800);
      setResizable(true);
      panel=new JPanel();
    
      panel1=new JPanel();
   
      panel2=new JPanel();
    
      panel3=new JPanel();
      
      panel.setLayout(new BorderLayout());
   
      male=new JRadioButton();
      female=new JRadioButton();
      JLabel male1=new JLabel("Male");
      
    
      male.addActionListener(
            e->{
            	
               currentGender = "Male";
            
            });
     
      JLabel female1=new JLabel("female");
     
      female.addActionListener(
            e->{
            
               currentGender = "Female";
            
            
            }); 
   
      
         
      group.add(male);
      group.add(female);
      JButton back=new JButton("Back");
      JButton exit=new JButton("exit");
      JButton add=new JButton("add");
      JButton cancel=new JButton("Cancel");
      back.setPreferredSize(new Dimension(50,20));
      exit.setPreferredSize(new Dimension(50,20));
      add.setPreferredSize(new Dimension(50,20));
      cancel.setPreferredSize(new Dimension(50,20));
   
      exit.addActionListener(
            e->{
               try{
                  writeToFile();
               }
               catch(Exception ex){
               	
               }
            	
            	
               System.exit(0);
            
            });
      
      back.addActionListener(
            e->{
            
               MainView(); //call MainView method
            
            
            }); 
     
      cancel.addActionListener(
            e->{
               cancelMethod(); //call cancelMethod()
               
            
            });     
            
      add.addActionListener(
            e->{
               AddView(fName.getText(), lName.getText(), DateOfBirth.getText(),currentGender);
               cancelMethod(); 
            });
      
      
              
      fName=new JTextField(20);
      
      lName=new JTextField(20);
      DateOfBirth=new JTextField(10);
      gender=new JTextField(10);
      studId=new JTextField(10);
      
      fName.addActionListener(
            e->{
            
            });
      JLabel firstname=new JLabel("First name:");
      
      lName.addActionListener(
            e->{
            
            });
      JLabel lastname=new JLabel("Last name:");
     
      DateOfBirth.addActionListener(
            e->{
            
            });
      JLabel DOB=new JLabel("Date of Birth");
      
      gender.addActionListener(
            e->{
            
            });
      JLabel gen=new JLabel("Gender:");
      
      studId.addActionListener(
            e->{
            
            });
      JLabel Id=new JLabel("Student ID:");
      GridLayout gridlayout = new GridLayout(0, 2);
        
      panel3.setLayout(gridlayout);
      panel3.setPreferredSize(new Dimension(200, 200));
      panel3.setVisible(true);
      
   
      panel3.add(firstname);
      panel3.add(fName);
      panel3.add(lastname);
      panel3.add(lName);
      panel3.add(DOB);
      panel3.add(DateOfBirth);
      panel3.add(gen);
      
   
      JPanel panelGender = new JPanel();
      
      panelGender.add(male1);
      panelGender.add(male);
      panelGender.add(female1);
      panelGender.add(female);
     
      panel3.add(panelGender);
      panel1.add(back);
      panel1.add(exit);
      add(panel1,BorderLayout.NORTH);
      
      panel2.add(add);
      panel2.add(cancel);
      add(panel2,BorderLayout.SOUTH);
      add(panel3,BorderLayout.CENTER);
   
      
      //change size to adjust textbox height
      setSize(800,300);
      setVisible(true);
    
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      
   }
  

   
   
 
   /*
    * This method is to return the student id number by adding 1
    */
   public int studentID()
   {
      int studID=100;
     
      for(int i=0;i<myStudents.size();i++)
      {
       
         if(myStudents.get(i).getstudId()>studID) 
         {
         
            studID=myStudents.get(i).getstudId();
         }
      }
      return  studID;
     
   }
   
   public  void AddView(String fname, String lName, String dob, String gender) {
   
      currentID+=1;
      Student myStu = new Student(fname, lName, dob, gender, currentID);
      myStudents.add(myStu);
      
   }
   
   /*
   This method help to write and  save the file while you exit.
   */
   
   public void writeToFile() throws IOException{
      
      PrintWriter outputFile=new PrintWriter("studentinfo.txt");
      if(myStudents.size()>0){
        
         for(int i=0; i<myStudents.size(); i++){
            Student information= myStudents.get(i);
            outputFile.println( information.getfName()+","+information.getlName()+","+information.getdateOfBirth()+","+information.getgender()+","+information.getstudId());
         
         }
      }
       
      outputFile.close();
      System.exit(0);
      
    
      
   }
   //This help to view infomormation in JTable i.e table format sheet
   
   public void viewStudent(){
      getContentPane().removeAll();
      getContentPane().repaint();
      
      panel4=new JPanel();
      panel5=new JPanel();
      JButton back1=new JButton("Back");
      JButton exit1=new JButton("exit");
      JButton delete1=new JButton("Delete");
      viewTable = new JTable();
      exit1.addActionListener(
            e->{
               try{
                  writeToFile();
               }
               catch(Exception ex){
               		
               }
               	
            
            
               System.exit(0);
               
            });
         
      back1.addActionListener(
            e->{
               
               MainView();
               
               
            }); 
      delete1.addActionListener(
            e->{
               deleteMethod(viewTable.getSelectedRow());
            	  
            })
         	  ;
         
      
      String[] columns= {"Student ID", "First Name", "Last Name", "Date Of Birth", "Gender"};
      
      
      Action action=
         new AbstractAction() {
         
            @Override
            public void actionPerformed(ActionEvent e) {
               TableCellListener tcl = (TableCellListener)e.getSource();
            
               if(tcl.getColumn() ==0 ){
                  myStudents.get(tcl.getRow()).setstudId(Integer.parseInt(tcl.getNewValue().toString()));
               }
               else if(tcl.getColumn() ==1 ){
                  myStudents.get(tcl.getRow()).setfName(tcl.getNewValue().toString());
               }
               else if(tcl.getColumn() ==2 ){
                  myStudents.get(tcl.getRow()).setlName(tcl.getNewValue().toString());
               }
               else if(tcl.getColumn() ==3 ){
                  myStudents.get(tcl.getRow()).setdateOfBirth(tcl.getNewValue().toString());
               }
               else if(tcl.getColumn() ==4 ){
                  myStudents.get(tcl.getRow()).setgender(tcl.getNewValue().toString());
               }
            }
         };
      TableCellListener tcl = new TableCellListener(viewTable, action);
      viewModel = new DefaultTableModel();
      viewModel.setColumnIdentifiers(columns);
      
      viewTable.setModel(viewModel);
     //viewTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
      for(int i = 0; i<myStudents.size(); i++){
         
         Student currentStu = myStudents.get(i);
         viewModel.addRow(new Object[]{currentStu.getstudId(), currentStu.getfName(), currentStu.getlName(), currentStu.getdateOfBirth(), currentStu.getgender()});
         
      }
      JPanel viewPanel = new JPanel();
      
      JScrollPane paaan = new JScrollPane(viewTable);
      panel4.add(back1);
      panel4.add(exit1);
      panel5.add(delete1);
      add(panel4,BorderLayout.NORTH);
      add(panel5,BorderLayout.SOUTH);
      
      add(paaan);
      
      setSize(800,400);
      setVisible(true);
       
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      
      
      System.out.println("view successful");
   }
   //This method is to display null
   public void cancelMethod(){
      fName.setText("");
      lName.setText("");
      DateOfBirth.setText("");
      gender.setText("");
      male.setSelected(false);
      group.clearSelection();
   
      studId.setText("");
   }
   /*
    * This method is to delete the row of information of student
    * @param rowId , row number
    */
   
   public void deleteMethod(int rowId)
   	
   {
      myStudents.remove(rowId);
      viewModel.removeRow(rowId);
      viewTable.repaint();
   }

}
   





