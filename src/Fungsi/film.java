
package Fungsi;


public class film extends inti{
   private String Kode_Film,Genre,Rating,Nama_Film;
   private Integer harga;
   
   
    public void setNama_Film(String Nama_Film){
       this.Nama_Film = Nama_Film;
    }
    public String getNama_Film(){
        return Nama_Film;
    }
   
    public void setRating(String Rating){
       this.Rating = Rating;
    }
    
     public void setGenre(String Genre){
       this.Genre = Genre;
   }
     
    public String getGenre(){
        return Genre;
    }
    public String getRating(){
        return Rating;
    }
    public void setHarga(Integer harga){
       this.harga = harga;
   }
    public Integer getHarga(){
        return harga;
    }
     public void setKode_Film(String Kode_Film){
       this.Kode_Film = Kode_Film;
    }
    public String getKode_Film(){
        return Kode_Film;
    }
}
