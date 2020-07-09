
package Fungsi;

import java.util.Date;
import oracle.sql.DATE;


public class JadwalFilm extends inti{
    private film film;
    private String jamtayang,ruang;
    Date tanggaltayang;
    
    public void setKodeTayang(Integer kodejadwal){
        super.Kode_Tayang = Kode_Tayang;
    }
     public void setfilm(film film){
        this.film=film;
    }
    public void setjamtayang(String jamtayang){
        this.jamtayang = jamtayang;
    }
    public void settanggal(Date tanggaltayang){
        this.tanggaltayang = tanggaltayang;
    }
    public void setruang(String ruang){
        this.ruang = ruang;
    }
    public Integer getKodeTayang(){
        return Kode_Tayang;
    }
    public film getfilm(){
        return film;
    }
    public String getjam(){
        return jamtayang;
    }
    public Date gettgl(){
        return tanggaltayang;
    }
    public String getruang(){
        return ruang;
    }
}
