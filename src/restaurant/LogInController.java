package restaurant;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;


public class LogInController implements Initializable {

    @FXML
    private TextField UserId;
    @FXML
    private TextField UserPassword;

    DBAction dbaction = new DBAction();
    
    Stage stage = new Stage();
    Stage stage2 = new Stage();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
               
    }    

    @FXML
    private void adminlogin(ActionEvent event) throws SQLException, IOException {

        String username = UserId.getText();
        String password = UserPassword.getText();
  
        int i=0;
            
            if(username.equalsIgnoreCase("admin") && password.equalsIgnoreCase("admin"))
            {
                Parent root = FXMLLoader.load(getClass().getResource("AdminPanel.fxml"));
                Scene scene = new Scene(root);

                stage.setTitle("Admin Panel");
                stage.setScene(scene);              
                
                Restaurant.stage.close();
                stage.show();
                i = 1;                
            }else{
                i =0;
            }

        if(i==1){
            JOptionPane.showMessageDialog(null, "Welcome to Admin Panel","Welcome",1);
        }else{
            JOptionPane.showMessageDialog(null, "Your id or password Wrong!","Wrong Information",0);
        }
        
    }

    @FXML
    private void managerlogin(ActionEvent event) throws SQLException, IOException {
        
        String username = UserId.getText();
        String password = UserPassword.getText();
       
        
        int i=0;
            if(username.equalsIgnoreCase("manager") && password.equalsIgnoreCase("manager"))
            {
                Parent root = FXMLLoader.load(getClass().getResource("UserPanel.fxml"));
                Scene scene = new Scene(root);
                stage.setTitle("Manager Panel");
                stage.setScene(scene);                
                
                Restaurant.stage.close();
                stage.show();
                i = 1;
                
            }else{
                i =0;
            }
         
        if(i==1){
            JOptionPane.showMessageDialog(null, "Welcome to Manager Panel","Welcome",1);
        }else{
            JOptionPane.showMessageDialog(null, "Your id or password Wrong!","Wrong Information",0);
        }  
        
        
        
    }
    
    @FXML
    private void kitchenlogin(ActionEvent event) throws SQLException, IOException {
        
        String username = UserId.getText();
        String password = UserPassword.getText();
       
        
        int i=0;
        
            if(username.equalsIgnoreCase("kitchen") && password.equalsIgnoreCase("kitchen"))
            {
                Parent root = FXMLLoader.load(getClass().getResource("kitchen.fxml"));
                Scene scene = new Scene(root);
                //stage.getIcons().add(image);
                stage.setTitle("Kitchen Panel");
                stage.setScene(scene);                
                
                Restaurant.stage.close();
                stage.show();
                i = 1;
             
            }else{
                i =0;
            }
        if(i==1){
            JOptionPane.showMessageDialog(null, "Welcome to Kitchen Panel","Welcome",1);
        }else{
            JOptionPane.showMessageDialog(null, "Login Unsuccessful! Wrong username/password!","Wrong Information",0);
        }  

    }
    
}
    
