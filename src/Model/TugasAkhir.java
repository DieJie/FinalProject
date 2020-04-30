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
    private List<Dosen> pembimbing;
    private List<Dosen> pembimbingNonApproval;
    
    public TugasAkhir(List pembimbing, String judul, String topik){
        this.judul = judul;
        this.topik=topik;
        pembimbing = new ArrayList();
        pembimbingNonApproval = new ArrayList();
        pembimbingNonApproval = pembimbing;
    }
   
}
