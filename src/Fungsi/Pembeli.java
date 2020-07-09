
package Fungsi;

import sun.security.util.Password;

public class Pembeli extends inti{
    private String password;
    private Integer ID;
    RegistrasiUser regis;

    public RegistrasiUser getRegi() {
        return regis;
    }

    public void setRegi(RegistrasiUser regis) {
        this.regis = regis;
    }
    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
}
