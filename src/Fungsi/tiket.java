
package Fungsi;

import java.util.ArrayList;


public class tiket {
    private Integer Kode_Tiket;
    private RegistrasiUser reg;
    private Pembeli pel;
    private Integer Banyak;
    private ArrayList<Setting>arrset;
    private Integer total;
    private String duduk;

    public String getDuduk() {
        return duduk;
    }

    public void setDuduk(String duduk) {
        this.duduk = duduk;
    }
    public Integer getKode_Tiket(){
        return Kode_Tiket;
    }
    public void setKode_Tiket(Integer Kode_Tiket){
        this.Kode_Tiket=Kode_Tiket;
    }

    public Pembeli getPel() {
        return pel;
    }

    public void setPel(Pembeli pel) {
        this.pel = pel;
    }
    public RegistrasiUser getreg(){
        return reg;
    }
    public void setreg(RegistrasiUser reg){
        this.reg=reg;
    }
    public Integer getBanyak(){
        return Banyak;
    }
    public void setBanyak(Integer Banyak){
        this.Banyak=Banyak;
    }
    public void setarrHave(ArrayList<Setting>arrset){
        this.arrset=arrset;
    }
    public ArrayList<Setting>getarrHave(){
        return arrset;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
