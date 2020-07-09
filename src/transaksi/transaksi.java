
package transaksi;
import Fungsi.JadwalFilm;
import Fungsi.tiket;
import Fungsi.Pembeli;
import Fungsi.Setting;
import Fungsi.film;
import Fungsi.RegistrasiUser;
import koneksi.koneksi;
import form.*;
import javax.swing.table.DefaultTableModel;
import koneksi.koneksi;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class transaksi {
    koneksi koneksi;
    ArrayList<film>arrfilm;
    ArrayList<Pembeli>arrreg;
    ArrayList<JadwalFilm>arrjdwl;
     ArrayList<tiket>arrtkt;
    public transaksi() throws SQLException{
        this.koneksi = new koneksi();
        this.arrfilm = new ArrayList<>();
        this.arrjdwl = new ArrayList<>();
        this.arrreg = new ArrayList<>();
        this.arrtkt = new ArrayList<>();
    }
    public ArrayList<film>get_film()throws SQLException{
        this.arrfilm.clear();
        ResultSet result = this.koneksi.GetData("SELECT * FROM FILM_07074");
        while (result.next()) {            
            film film = new film();
            film.setKode_Film(result.getString("KODE_FILM"));
            film.setNama_Film(result.getString("NAMA_FILM"));
            film.setGenre(result.getString("GENRE"));
            film.setRating(result.getString("RATING"));
            film.setHarga(result.getInt("HARGA"));
            this.arrfilm.add(film);
        }
        return this.arrfilm;
    }
    public ArrayList<JadwalFilm> getDataJadwal() throws SQLException {
        this.arrjdwl.clear();
        ResultSet rs = this.koneksi.GetData("SELECT * FROM JADWAL_07074 JOIN FILM_07074 ON JADWAL_07074.KODE_FILM = FILM_07074.KODE_FILM");
        while (rs.next()) {
            film film = new film();
            film.setKode_Film(rs.getString("KODE_FILM"));
            film.setNama_Film(rs.getString("NAMA_FILM"));
            film.setGenre(rs.getString("GENRE"));
            film.setRating(rs.getString("RATING"));
            film.setHarga(rs.getInt("HARGA"));

            JadwalFilm jadwal = new JadwalFilm();
            jadwal.setKodeTayang(rs.getInt("KODE_TAYANG"));
            jadwal.setfilm(film);
            jadwal.settanggal(new Date(rs.getString("TANGGAL_TAYANG")));
            jadwal.setjamtayang(rs.getString("JAM_TAYANG"));
            jadwal.setruang(rs.getString("RUANG"));

            this.arrjdwl.add(jadwal);
        }
        return this.arrjdwl;
    }
    public ArrayList<Pembeli>get_regis()throws SQLException{
        this.arrreg.clear();
        ResultSet result = this.koneksi.GetData("SELECT * FROM PEMBELI_07074 JOIN REGISTER_07074 ON PEMBELI_07074.ID = REGISTER_07074.ID ORDER BY PEMBELI_07074.ID_REG");
        while (result.next()) {            
            RegistrasiUser reg = new RegistrasiUser();
            reg.set_Id_Reg(result.getInt("ID_REG"));
            reg.set_nama(result.getString("NAMA"));
            reg.set_alamat(result.getString("ALAMAT"));
            reg.set_notelp(result.getString("NO_TELP"));
            Pembeli pem = new Pembeli();
            pem.setID(result.getInt("ID"));
            pem.setPassword("PASSWORD");
            reg.setPel(pem);
            pem.setRegi(reg);
            
            this.arrreg.add(pem);
        }
        return this.arrreg;
    }
   
    public void insert_film(film film)throws SQLException{
        this.koneksi.ManipulasiData("INSERT INTO FILM_07074 VALUES("+"'"+film.getKode_Film()+"'"+","+"'"+film.getNama_Film()+"'"+","+"'"+film.getGenre()+"'"+","+"'"+film.getRating()+"'"+","+film.getHarga()+")");
    }
    public void delete_film(String i) throws SQLException{
        this.koneksi.ManipulasiData("DELETE FROM FILM_07074 WHERE KODE_FILM = '"+i+"'");
    }
    public void update(String kode, Integer harga) throws SQLException{
        this.koneksi.ManipulasiData("UPDATE FILM_07074 SET HARGA ="+harga.toString()+" WHERE KODE_FILM = "+"'"+kode+"'");
    }
    public void input_jadwal(JadwalFilm jdwl) throws SQLException{
        String tgl = new SimpleDateFormat("dd/MM/yyyy").format(jdwl.gettgl());
        this.koneksi.ManipulasiData("INSERT INTO JADWAL_07074 VALUES("+jdwl.getKodeTayang()+","+"'"+jdwl.getfilm().getKode_Film()+"'"+",TO_DATE('" + tgl + "','dd/MM/yyyy'),"+"'"+jdwl.getjam()+"'"+","+"'"+jdwl.getruang()+"'"+")");
    }
    public void delete_jadwal(Integer i) throws SQLException{
        this.koneksi.ManipulasiData("DELETE FROM jadwal_07074 WHERE KODE_TAYANG = "+i);
    }
    public void update_jadwal(Integer kode, String ruang, String jam) throws SQLException{
        this.koneksi.ManipulasiData("UPDATE JADWAL_07074 SET JAM_TAYANG ='"+jam+"',"+"RUANG = '"+ruang+"' WHERE KODE_TAYANG = "+kode);
    }
    public void registrasi(RegistrasiUser reg)throws SQLException{
        this.koneksi.ManipulasiData("INSERT INTO REGISTER_07074 values ("+reg.get_Id_Reg()+","+"'"+reg.get_nama()+"'"+","+"'"+reg.get_alamat()+"'"+","+"'"+reg.get_notelp().toString()+"'"+","+reg.getIdregistrasi()+")");
    }

    //---------------------------------------------------PEMBELI-----------------------------------------------------------------------------------
     public void insertuser(RegistrasiUser reg, String nama) throws SQLException {
                this.koneksi.ManipulasiData("INSERT INTO REGISTER_07074 VALUES ("+reg.get_Id_Reg()+","+"'"+
                        reg.get_nama()+"'"+","+"'"+reg.get_alamat()+"'"+","
                        +"'"+reg.get_notelp().toString()+"'"+","+null+")");
    
                this.koneksi.ManipulasiData("INSERT INTO PEMBELI_07074 VALUES (" + 
                        reg.getPel().getID()+ 
                        ",'"  + reg.get_Id_Reg()+ 
                        "'," + "'" + reg.getPel().getPassword() + "'" + ")");
                this.koneksi.ManipulasiData("UPDATE register_07074 SET ID = " + 
                        reg.getPel().getID()+ " WHERE NAMA='"+ nama+"'");
    }
    public void login(Integer user, String pass)
    {
        try {
        ResultSet rs0 = this.koneksi.GetData("CREATE VIEW LOGIN AS"
                + " SELECT a.ID, b.NAMA, a.PASSWORD, b.NO_TELP, b.ALAMAT, b.ID_REG"
                + " FROM REGISTER_07074 b JOIN PEMBELI_07074 a"
                + " ON b.ID_REG = a.ID_REG");
        
        ResultSet rs = this.koneksi.GetData("SELECT * FROM LOGIN"
                + " WHERE ID = " + user + " AND PASSWORD = '" + pass + "'");
        int baris = 0;
     
            while (rs.next()) {
                baris = rs.getRow();
           
            if (baris ==1) {
                RegistrasiUser pem = new RegistrasiUser();
                pem.setIdregistrasi(rs.getInt("ID"));
                pem.set_nama(rs.getString("NAMA"));
                pem.set_notelp(rs.getString("NO_TELP"));
                pem.set_Id_Reg(rs.getInt("ID_REG"));
                pem.set_alamat(rs.getString("ALAMAT"));
           
                Pembeli reg = new Pembeli();
                //reg.setIdreg(rs.getInt("ID"));
                reg.setPassword(rs.getString("PASSWORD"));

                pem.setPel(reg);
                reg.setRegi(pem);
                new BeliTiket(rs.getString("NAMA"), rs.getInt("ID")).setVisible(true);
                
            }else {
                
            }
            }
        } catch (SQLException ex) {
            Logger.getLogger(transaksi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//----------------------------------------PEMBELIAN TIKET------------------------------------
    public ArrayList<tiket> getDataTransaksi() throws SQLException {
        this.arrtkt.clear();
        ResultSet rs = this.koneksi.GetData("SELECT * FROM PEMBELI_07074 JOIN REGISTER_07074"
                + " ON PEMBELI_07074.ID_REG = REGISTER_07074.ID_REG"
                + " JOIN TIKET_07074"
                + " ON TIKET_07074.ID = PEMBELI_07074.ID ORDER BY TIKET_07074.KODE_TIKET");
        while (rs.next()) {
            RegistrasiUser reg = new RegistrasiUser();
            reg.setIdregistrasi(rs.getInt("ID"));
            reg.set_nama(rs.getString("NAMA"));
            reg.set_alamat(rs.getString("ALAMAT"));
            reg.set_notelp(rs.getString("NO_TELP"));
            reg.set_Id_Reg(rs.getInt("ID_REG"));

            Pembeli pem = new Pembeli();
            pem.setID(rs.getInt("ID"));
            pem.setRegi(reg);
            pem.setPassword(rs.getString("PASSWORD"));
            
            reg.setPel(pem);
            
            tiket transaksi = new tiket();
            transaksi.setreg(reg);
            transaksi.setKode_Tiket(rs.getInt("KODE_TIKET"));
            transaksi.setDuduk(rs.getString("BANGKU"));
            transaksi.setBanyak(rs.getInt("JUMLAH"));
            transaksi.setTotal(rs.getInt("NPM07074_TOTAL"));
            
            ResultSet rsHave = this.koneksi.GetData("SELECT * FROM SET_07074 JOIN JADWAL_07074 "
                    + "ON SET_07074.KODE_TAYANG = JADWAL_07074.KODE_TAYANG "
                    + "JOIN FILM_07074 "
                    + "ON JADWAL_07074.KODE_FILM = FILM_07074.KODE_FILM "
                    + "WHERE SET_07074.KODE_TIKET = '" + rs.getString("KODE_TIKET")+"' ORDER BY SET_07074.KODE_TIKET");
            ArrayList<Setting> set = new ArrayList<>();
            
            while (rsHave.next()) {
                film film = new film();
                film.setKode_Film(rsHave.getString("KODE_FILM"));
                film.setNama_Film(rsHave.getString("NAMA_FILM"));
                film.setGenre(rsHave.getString("GENRE"));
                film.setRating(rs.getString("RATING"));
                film.setHarga(rsHave.getInt("HARGA"));

                JadwalFilm jdwl = new JadwalFilm();
                jdwl.setKodeTayang(rsHave.getInt("KODE_TAYANG"));
                jdwl.setfilm(film);
                jdwl.settanggal(new Date(rsHave.getString("TANGGAL_TAYANG")));
                jdwl.setjamtayang(rsHave.getString("JAM_TAYANG"));
                jdwl.setruang(rsHave.getString("RUANG"));

                Setting sert = new Setting();
                sert.setjdwl(jdwl);
//                sert.setTkt(transaksi);
                set.add(sert);
            }
            transaksi.setarrHave(set);

            this.arrtkt.add(transaksi);
        }
        return this.arrtkt;
    }
    public void inserttrans(tiket trans) throws SQLException {
        this.koneksi.ManipulasiData("INSERT INTO TIKET_07074 VALUES (" + trans.getKode_Tiket() + 
                ",'" + trans.getDuduk()+  
                "'," + "'" + trans.getBanyak() + "'" +",'"+trans.getPel().getID()+"','"+trans.getTotal()+ "')");
                    
        for (Setting seet : trans.getarrHave()) {
                this.koneksi.ManipulasiData("INSERT INTO SET_07074 VALUES ("+"'"+trans.getKode_Tiket()+"'"+","+"'"+seet.getjdwl().getKodeTayang()+"'"+")");
            }
    }    

}
