/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.List;

/**
 *
 * @author DivaPrasetya
 */
public class Mahasiswa extends Person{
    private int nim;
    private TugasAkhir tugasAkhir;
    private static int sid = 0;
    private KelasTugasAkhir kelasTA;
    
    public Mahasiswa(String username,String password,String nama,String nohp,String ttl){
        super(username,password,nama,nohp,ttl);
        nim = 184220 + sid;
        sid++;
    }
    
    public void createTA(List pembimbing, String judul, String topik){
        tugasAkhir = new TugasAkhir(pembimbing,judul,topik);
    };

    public int getNim() {
        return nim;
    }
   
}
