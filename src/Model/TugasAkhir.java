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
public class TugasAkhir {
    private String judul;
    private String topik;
    private ArrayList<Dosen> pembimbing;
    private ArrayList<Dosen> pembimbingNonApproval;
    private ArrayList<Dosen> pembimbingReject;
    
    public TugasAkhir(String judul, String topik){
        this.judul = judul;
        this.topik=topik;
        pembimbing = new ArrayList();
        pembimbingNonApproval = new ArrayList();
        pembimbingNonApproval = pembimbing;
        pembimbingReject = new ArrayList();
    }

    public String getJudul() {
        return judul;
    }

    public String getTopik() {
        return topik;
    }

    public ArrayList<Dosen> getPembimbing() {
        return pembimbing;
    }

    public ArrayList<Dosen> getPembimbingNonApproval() {
        return pembimbingNonApproval;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public void setTopik(String topik) {
        this.topik = topik;
    }

    public ArrayList<Dosen> getPembimbingReject() {
        return pembimbingReject;
    }
    
    
   
}
