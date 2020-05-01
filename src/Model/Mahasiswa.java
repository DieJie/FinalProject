/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Controller.Handler_Home;
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
    Application model;
    
    public Mahasiswa(String username,String password,String nama,String nohp,String ttl){
        super(username,password,nama,nohp,ttl);
        nim = 184220 + sid;
        sid++;
        model = Handler_Home.getModel();
    }
    
    public void createTA(String KodeKelas, String judul, String topik){
        kelasTA = model.SearchKTA(KodeKelas);
        tugasAkhir = new TugasAkhir(judul,topik);
    };
    
    public void addPembimbingTA(Dosen d){
        tugasAkhir.getPembimbingNonApproval().add(d);
    }
    
    public void convertPembimbingTA(int nidn){
        Dosen d = tugasAkhir.getPembimbingNonApproval().get(nidn);
        tugasAkhir.getPembimbing().add(d);
    }
    
    public void rejectPembimbingTA(int nidn){
        int i = -1;
        try{
            for(Dosen d: tugasAkhir.getPembimbingNonApproval()){
                i++;
                if(nidn == tugasAkhir.getPembimbingNonApproval().get(nidn).getNidn()){
                    break;
                }
            }
            Dosen d = tugasAkhir.getPembimbingNonApproval().get(nidn);
            tugasAkhir.getPembimbingReject().add(d);
            tugasAkhir.getPembimbingNonApproval().remove(i);
        }catch(ArrayIndexOutOfBoundsException a){
            i = -1;
        }
    }

    public TugasAkhir getTugasAkhir() {
        return tugasAkhir;
    }

    public KelasTugasAkhir getKelasTA() {
        return kelasTA;
    }
    
    

    public int getNim() {
        return nim;
    }
    
    
   
}
