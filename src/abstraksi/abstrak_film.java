/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abstraksi;


public abstract class abstrak_film {
    public abstract void insert(int kode_film,String nama,String genre,String rating,int harga);
     public abstract void del(int kode_film);
     public abstract void update(int update,int kode_film,String nama,String genre,int harga);
}
