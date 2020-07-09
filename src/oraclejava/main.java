
package oraclejava;
import form.*;
import koneksi.koneksi;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import Fungsi.film;

public class main {

    public static void main(String[] args) throws SQLException, ParseException{
        // TODO code application logic here
        new awal().show();
        new koneksi();
        
    }
    
}
