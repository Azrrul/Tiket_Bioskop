
package Fungsi;

import javax.swing.table.DefaultTableModel;
import koneksi.koneksi;
import abstraksi.abstrak_film;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class EditFilm extends abstrak_film { 
    film[] film = new film[100];
    int dx=0;

    @Override
    public void insert(int kode_film, String nama, String genre,String rating, int harga) {
      
    }

    @Override
    public void del(int kode_film) {

    }

    @Override
    public void update(int update, int kode_film, String nama, String genre, int harga) {
        
    }

}
