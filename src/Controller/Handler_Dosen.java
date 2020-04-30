/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Application;
import Model.Dosen;
import View.DosenPanel;
import View.HomeScreen;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author DivaPrasetya
 */
public class Handler_Dosen implements ActionListener{
    static DosenPanel ViewDosenPanel;
    Application model;
    Dosen d;
    HomeScreen HS;
    
    public Handler_Dosen(){
        this.model = Handler_Home.getModel();
        d = Handler_Login.d;
        HS = Handler_Home.ViewHome;
        ViewDosenPanel = new DosenPanel();
        if(d.getKelasTA() != null){
            ViewDosenPanel.setBtnText("Lihat Daftar Kelas");
        }
        ViewDosenPanel.setTextHeader("Selamat Datang, "+d.getNama());
        ViewDosenPanel.addActionListener(this);
        ViewDosenPanel.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if(source.equals(ViewDosenPanel.getBtProfilSaya())){
            String a = "Nama: "+d.getNama()+"\n"+"Nomor HP: "+d.getNohp()+"\n"+"Tempat, Tanggal Lahir: "+d.getTtl();
            ViewDosenPanel.setProfilSaya(a);
        }else if(source.equals(ViewDosenPanel.getBtOut())){
            ViewDosenPanel.setVisible(false);
            HS.setVisible(true);
        }else if(source.equals(ViewDosenPanel.getBtCreateTA())){
            if(d.getKelasTA()==null){
                Handler_CreateTA HCTA = new Handler_CreateTA();
            }else{
                Handler_SeeTA HETA = new Handler_SeeTA();
            }
        }
    }
}
