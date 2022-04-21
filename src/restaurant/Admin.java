
package restaurant;

public class Admin {

    private String UserName;
    private String Password;
    
    public Admin() {
    }
    
    public Admin(String UserName, String Password) {
        this.UserName = UserName;
        this.Password = Password;
    }

    public String getUserName() {
        return UserName;
    }

    public String getPassword() {
        return Password;
    }
    
    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    @Override
    public String toString() {
        return "Admin{" + "UserName=" + UserName + ", Password=" + Password + '}';
    }
}
