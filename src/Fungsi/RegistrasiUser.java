
package Fungsi;

import sun.security.pkcs11.P11TlsKeyMaterialGenerator;


public class RegistrasiUser extends inti{
    public String nama, alamat, notelp,password;//idregistrasi;
    public Integer idregistrasi;
    Pembeli pel;

    public Pembeli getPel() {
        return pel;
    }

    public void setPel(Pembeli pel) {
        this.pel = pel;
    }
    public void set_Id_Reg(Integer Id_Reg){
        super.Id_Reg = Id_Reg;
    }
    
    public void set_nama(String nama){
        this.nama = nama;
    }
    
    public Integer getIdregistrasi() {
        return idregistrasi;
    }
    
    public void setIdregistrasi(Integer idregistrasi) {
        this.idregistrasi = idregistrasi;
    }
    
    public void set_alamat(String alamat){
        this.alamat = alamat;
    }
    
    public void set_notelp(String notelp){
        this.notelp = notelp;
    }
    
    public Integer get_Id_Reg(){
        return Id_Reg;
    }
    
    public String get_nama(){
        return nama;
    }
    
    public String get_notelp(){
        return notelp;
    }
    
    public String get_alamat(){
        return alamat;
    }
}
