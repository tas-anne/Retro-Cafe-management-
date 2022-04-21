
package restaurant;

import conpkg.concls;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.swing.JOptionPane;
import java.sql.Connection;

public class DBAction {
    void InsertEmployee(Employee employee) throws SQLException
    {
        concls connectionClass=new concls();
        Connection con=connectionClass.getConnection();
        Statement state = con.createStatement();
        
        //Query for insert Employee
        String query = "INSERT INTO employee(Employee_ID,Designation,Join_Date,Salary) VALUES("+employee.EmployeeID+",'"+employee.Designation+"','"+employee.JoinDate+"',"+employee.Salary+")";
        state.executeUpdate(query);
        con.close();
        state.close();
    }
    
    //Insert Employee Information for EmployeeInformaton table
    void InsertEmployeeInformation(Employee employee) throws SQLException
    {
        try{
        concls connectionClass=new concls();
        Connection con=connectionClass.getConnection();
        Statement state = con.createStatement();
        
        String query = "INSERT INTO personal_details(Employee_ID,First_Name,Last_Name,Phone,Gender,Country,Address,Passport_NID)"+"VALUES("+employee.EmployeeID+", '"+employee.FirstName+"', '"+employee.LastName+"',"+employee.Phone+", '"+employee.Gender+"','"+employee.Country+"','"+employee.Address+"','"+employee.Passport_NID+"')";
        state.executeUpdate(query);
        
        con.close();
        state.close();
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Please At First Insert Employee!", "Thank you", 0);
        }
       
        
    }
   
    
    
    //Create Method for get All Employe from employee table
    ObservableList<Employee> getAllEmployee() throws SQLException{
        
        
        ObservableList<Employee> employelist = FXCollections.observableArrayList();
        
        concls connectionClass=new concls();
        Connection con=connectionClass.getConnection();
        String query = "SELECT Employee_ID,Designation,Join_Date,Salary FROM employee";
        Statement statement = con.createStatement();
        ResultSet resultset = statement.executeQuery(query);
        
        while(resultset.next())
        {
            //Get data from Database
            int id = resultset.getInt("Employee_ID");
            String des = resultset.getString("Designation");
            Date date = resultset.getDate("Join_Date");
            double sal = resultset.getDouble("Salary");
            
            
            
            //Initialize data in Employee object
            Employee empoyee  = new Employee(id,des,date,sal);            
            
            employelist.add(empoyee);
            
        }   
        
        return employelist;        
        
        
    }
    
    
    //Create Mathod For get All Employee Details
    
     ObservableList<Employee> getAllEmployeeDetails() throws SQLException{
        
        
        ObservableList<Employee> employelist = FXCollections.observableArrayList();
        
        concls connectionClass=new concls();
        Connection con=connectionClass.getConnection();
        String query = "SELECT Employee_ID, First_Name,Last_Name,Phone,Gender,Country,Passport_NID,Address FROM personal_details;";
        Statement statement = con.createStatement();
        ResultSet resultset = statement.executeQuery(query);
        
        while(resultset.next())
        {
            //Get data from Database
            int id = resultset.getInt("Employee_ID");
            String FirstName = resultset.getString("First_Name");
            String LastName = resultset.getString("Last_Name");
            int Phone = resultset.getInt("Phone");
            String Gender = resultset.getString("Gender");
            String country = resultset.getString("Country");
            String Passport = resultset.getString("Passport_NID");
            String Address = resultset.getString("Address");
                      
            
            
            //Initialize data in Employee object
            Employee empoyee  = new Employee(id,FirstName,LastName,Phone,Gender,country,Address,Passport);            
            
            employelist.add(empoyee);
            
        }   
        
        return employelist;        
        
    }
     
     
     
     
     //Delete Employee
     
     void DeleteEmployes(ObservableList<Employee> SelectedEmployes) throws SQLException
     {
         concls connectionClass=new concls();
        Connection con=connectionClass.getConnection();
         Statement statement = con.createStatement();
         
         for(Employee employee : SelectedEmployes)
         {
            String Query = "DELETE FROM employee WHERE Employee_ID = "+employee.getEmployeeID();
            statement.executeUpdate(Query);
         }
         con.close();
         statement.close();
     }
     
     
     
     void DeleteEmployesDetails(ObservableList<Employee> SelectedEmployes) throws SQLException
     {
         concls connectionClass=new concls();
        Connection con=connectionClass.getConnection();
         Statement statement = con.createStatement();
         
         for(Employee employee : SelectedEmployes)
         {
            String Query = "DELETE FROM personal_details WHERE Employee_ID = "+employee.getEmployeeID();
            statement.executeUpdate(Query);
         }
         
         con.close();
         statement.close();
     }
     
     
     //Srach Method for Employee Table
     ObservableList<Employee> SearchEmployee(int EmployeeId) throws SQLException{
         
         
         ObservableList<Employee> list = FXCollections.observableArrayList();
         
         concls connectionClass=new concls();
        Connection con=connectionClass.getConnection();
         Statement statement = con.createStatement();
         String Query = "SELECT Employee_ID, Designation,Join_Date,Salary FROM employee WHERE Employee_ID = "+EmployeeId;
         
         ResultSet resultset = statement.executeQuery(Query);
         
         while(resultset.next())
         {
             int id = resultset.getInt("Employee_ID");
            String des = resultset.getString("Designation");
            Date date = resultset.getDate("Join_Date");
            double sal = resultset.getDouble("Salary");
            
            
            
            //Initialize data in Employee object
            Employee empoyee  = new Employee(id,des,date,sal);            
            
            list.add(empoyee);
             
         }
         return list;
     }
     
         
     
     
     
     //Search Option for Employee Details Table Table
     ObservableList<Employee> SearchEmployeeDetails(int EmployeeId) throws SQLException{
         
         
         ObservableList<Employee> list = FXCollections.observableArrayList();
         
        concls connectionClass=new concls();
        Connection con=connectionClass.getConnection();
         Statement statement = con.createStatement();
         String query = "SELECT Employee_ID, First_Name,Last_Name,Phone,Gender,Country,Passport_NID,Address FROM personal_details where Employee_ID = "+EmployeeId;
         
         ResultSet resultset = statement.executeQuery(query);
         
         while(resultset.next())
         {
             
            
            //Get data from Database
            int id = resultset.getInt("Employee_ID");
            String FirstName = resultset.getString("First_Name");
            String LastName = resultset.getString("Last_Name");
            int Phone = resultset.getInt("Phone");
            String Gender = resultset.getString("Gender");
            String country = resultset.getString("Country");
            String Passport = resultset.getString("Passport_NID");
            String Address = resultset.getString("Address");                    
            
            
            //Initialize data in Employee object
            Employee empoyee  = new Employee(id,FirstName,LastName,Phone,Gender,country,Address,Passport);
                             
            list.add(empoyee);
             
         }
         return list;
     }
     
     
     //This Method for Admin Access List
     ObservableList<AppUser> getAllUser() throws SQLException{
         
         
         ObservableList<AppUser> list = FXCollections.observableArrayList();
         
         
         concls connectionClass=new concls();
        Connection con=connectionClass.getConnection();
         Statement statement = con.createStatement();
         
         String Query = "SELECT Id,UserName,Password FROM admin";
         
         ResultSet resultset = statement.executeQuery(Query);
         
         while(resultset.next())
         {
             int id = resultset.getInt("Id");
             String username = resultset.getString("UserName");
             String password = resultset.getString("Password");
             
             AppUser appuser = new AppUser(id,username,password);
             list.add(appuser);             
         }
         return list;
     }
     
     //This Method for Multiple App User Access List
     ObservableList<AppUser> getAllAppUser() throws SQLException{
         
         
         ObservableList<AppUser> list = FXCollections.observableArrayList();
         
         
        concls connectionClass=new concls();
        Connection con=connectionClass.getConnection();
         Statement statement = con.createStatement();
         
         String Query = "SELECT Id, UserName,Password FROM app_user";
         
         ResultSet resultset = statement.executeQuery(Query);
         
         while(resultset.next())
         {
             int id = resultset.getInt("Id");
             String username = resultset.getString("UserName");
             String password = resultset.getString("Password");
             
             AppUser appuser = new AppUser(id,username,password);
             list.add(appuser);             
         }
         return list;
     }
     
     
     //This Method for Multiple App User Access List
     ObservableList<AppUser> getAllAppUser1() throws SQLException{
         
         
         ObservableList<AppUser> list = FXCollections.observableArrayList();
         
         
         concls connectionClass=new concls();
        Connection con=connectionClass.getConnection();
         Statement statement = con.createStatement();
         
         String Query = "SELECT Employee_ID, UserName,Password FROM app_user";
         
         ResultSet resultset = statement.executeQuery(Query);
         
         while(resultset.next())
         {
             int id = resultset.getInt("Employee_ID");
             String username = resultset.getString("UserName");
             String password = resultset.getString("Password");
             
             AppUser appuser = new AppUser(id,username,password);
             list.add(appuser);             
         }
         return list;
     }
     
     
     //This Method for Add User Panel
     //This Method for Multiple App User Access List
     ObservableList<AppUser> SearchAppUser(int Id) throws SQLException{
         
         ObservableList<AppUser> list = FXCollections.observableArrayList();
         
        concls connectionClass=new concls();
        Connection con=connectionClass.getConnection();
        Statement statement = con.createStatement();
        String Query = "SELECT Employee_ID, UserName,Password FROM app_user WHERE Employee_ID = "+Id;
         
        ResultSet resultset = statement.executeQuery(Query);
         
         while(resultset.next())
         {
            int id = resultset.getInt("Employee_ID");
            String user = resultset.getString("UserName");
            String pass = resultset.getString("Password");
            
           AppUser appuser = new AppUser(id, user,pass);
            list.add(appuser);             
         }
         return list;
     }
     
     
     
    
     
     
     
      //List For Country
     ObservableList<Floor> getAllTable() throws SQLException{
         
         
         ObservableList<Floor> list = FXCollections.observableArrayList();         
         
         concls connectionClass=new concls();
        Connection con=connectionClass.getConnection();
         Statement statement = con.createStatement();
         
         String Query = "SELECT Table_Id, Status FROM floor1 WHERE Status = 'UnBooked'";
         
         ResultSet resultset = statement.executeQuery(Query);
         
         while(resultset.next())
         {
             int id = resultset.getInt("Table_Id");
             String status = resultset.getString("Status");
             
             Floor floor = new Floor(id,status);
             list.add(floor);             
         }
         return list;
     }
}
