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
public class KelasTugasAkhir {
    private Dosen PemilikKTA;
    private List<Dosen> timDosen;
    private List<Mahasiswa> daftarMhsTA;
    String TopikTA;
    String KodeKelas;
    
    public KelasTugasAkhir(String topik, Dosen d){
        KodeKelas = "142"+Integer.toString(d.getNidn());
        PemilikKTA = d;
        setTopik(topik);
        timDosen = new ArrayList();
        daftarMhsTA = new ArrayList();
    }
    
    public void setTopik(String topik){
        TopikTA = topik;
    }
    
    public void addMahasiswa(Mahasiswa m){
        daftarMhsTA.add(m);
    }
    
    public void addDosen(Dosen d){
        timDosen.add(d);
    }
    
    public void delMhs(Mahasiswa m){
        daftarMhsTA.remove(m);
    }
    
    public void delDosen(Dosen d){
        timDosen.add(d);
    }
    
    public String getKodeKelas(){
        return KodeKelas;
    }

    public List<Dosen> getTimDosen() {
        return timDosen;
    }

    public List<Mahasiswa> getDaftarMhsTA() {
        return daftarMhsTA;
    }

    public Dosen getPemilikKTA() {
        return PemilikKTA;
    }

    public String getTopikTA() {
        return TopikTA;
    }
    
    public String[] getListNamaDosen(){
        String[] listNamaDosen=new String[timDosen.size()];
        int i = 0;
        for (Dosen d: timDosen){
                listNamaDosen[i] = d.getNama();
                i++;
        }
        return listNamaDosen;
    }
       
    public String[] getListNamaMahasiswa(){
        String[] listNamaMahasiswa=new String[daftarMhsTA.size()];
        int i = 0;
        for (Mahasiswa m: daftarMhsTA){
                listNamaMahasiswa[i] = m.getNama();
                i++;
        }
        return listNamaMahasiswa;
    }
    
    public Dosen getDosen(String nama){
        for(Dosen d: timDosen){
            if(d.getNama().equals(nama)){
                return d;
            }
        }
        return null;
    }
    
    public Mahasiswa getMhs(String nama){
        for(Mahasiswa m: daftarMhsTA){
            if(m.getNama().equals(nama)){
                return m;
            }
        }
        return null;
    }
    
    public String[] getListMahasiswa(){
        String[] listMhs=new String[daftarMhsTA.size()];
        int i = 0;
        for (Mahasiswa m: daftarMhsTA){
                listMhs[i] = m.getNama();
                i++;
        }
        return listMhs;
    }
}
