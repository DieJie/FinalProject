/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DivaPrasetya
 */
public class Dosen extends Person{
    int nidn ;
    private KelasTugasAkhir kelasTA;
    int indexTA=-1;
    private ArrayList<KelasTugasAkhir> listKelasTA;
    private String topik;
    private static int  sid = 0 ;
    
    public Dosen(String username,String password,String nama,String nohp,String ttl){
        super(username,password,nama,nohp,ttl);
        nidn = 184220 + sid;
        sid++;
        listKelasTA = new ArrayList<KelasTugasAkhir>();
    }
    
    public void createKelompokTA(String topik,Dosen d){
        this.topik = topik;
        KelasTugasAkhir KTA = new KelasTugasAkhir(topik,d);
        listKelasTA.add(KTA);
        indexTA++;
        for(KelasTugasAkhir kta: listKelasTA){
            if(kta == KTA){
                break;
            }
        }
        kelasTA = KTA;
    }

    public int getNidn() {
        return nidn;
    }

    public KelasTugasAkhir getKelasTA(){
        return kelasTA;
    }

    public ArrayList<KelasTugasAkhir> getListKelasTA() {
        return listKelasTA;
    }
    
    public String[] getListKodeKelas(){
        String[] listKodeKelas=new String[listKelasTA.size()];
        int i = 0;
        for (KelasTugasAkhir b: listKelasTA){
                listKodeKelas[i] = b.KodeKelas;
                i++;
        }
        return listKodeKelas;
    }
    
    public KelasTugasAkhir SearchKTA(String KodeKelas){
        for (KelasTugasAkhir KTA: listKelasTA){
            if (KTA.getKodeKelas() == KodeKelas){
                 return KTA;
            }
        }
        return null;
    }
    
    public void delKTA(){
        getListKelasTA().remove(indexTA);
        kelasTA = null;
    }
}
