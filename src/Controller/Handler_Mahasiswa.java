/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Application;
import Model.Mahasiswa;
import View.HomeScreen;
import View.MahasiswaPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author DivaPrasetya
 */
public class Handler_Mahasiswa implements ActionListener {
    static MahasiswaPanel ViewMhsPanel;
    Application model;
    Mahasiswa m;
    HomeScreen HS;
    
    public Handler_Mahasiswa(){
        this.model = Handler_Home.getModel();
        m = Handler_Login.m;
        HS = Handler_Home.ViewHome;
        ViewMhsPanel = new MahasiswaPanel();
        ViewMhsPanel.setTextHeader("Selamat Datang, "+m.getNama());
        ViewMhsPanel.addActionListener(this);
        ViewMhsPanel.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if(source.equals(ViewMhsPanel.getBtProfilSaya())){
            String a = "Nama: "+m.getNama()+"\n"+"Nomor HP: "+m.getNohp()+"\n"+"Tempat, Tanggal Lahir: "+m.getTtl();
            ViewMhsPanel.setProfilSaya(a);
        }else if(source.equals(ViewMhsPanel.getBtOut())){
            ViewMhsPanel.setVisible(false);
            HS.setVisible(true);
        }else if(source.equals(ViewMhsPanel.getBtUploadTA())){
            if(m.getKelasTA() == null){
                Handler_CreateTA HCTA = new Handler_CreateTA();
            }else{
                Handler_EditTA HETA = new Handler_EditTA();
            }
        }
    }
}
