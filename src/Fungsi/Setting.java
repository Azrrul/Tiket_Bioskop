
package Fungsi;


public class Setting {
    private JadwalFilm jdwl;
    Integer tiket;String kodejadwal;
    public JadwalFilm getjdwl(){
        return jdwl;
    }
    public void setjdwl(JadwalFilm jdwl){
        this.jdwl=jdwl;
    }

    public Integer getTiket() {
        return tiket;
    }

    public void setTiket(Integer tiket) {
        this.tiket = tiket;
    }

    public String getKodejadwal() {
        return kodejadwal;
    }

    public void setKodejadwal(String kodejadwal) {
        this.kodejadwal = kodejadwal;
    }
    
}
