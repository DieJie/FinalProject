/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Application;
import Model.Dosen;
import Model.Mahasiswa;
import View.DosenPanel;
import View.HomeScreen;
import View.LoginScreen;
import View.MahasiswaPanel;
import View.createTA;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author DivaPrasetya
 */
public class Handler_CreateTA implements ActionListener{
    
    static createTA ViewCreateTA;
    Application model;
    Mahasiswa m;
    MahasiswaPanel MP;
    HomeScreen HS;
    LoginScreen LS;
    
    public Handler_CreateTA(){
        this.model = Handler_Home.getModel();
        m = Handler_Login.m;
        MP = Handler_Mahasiswa.ViewMhsPanel;
        ViewCreateTA = new createTA();
        ViewCreateTA.addActionListener(this);
        ViewCreateTA.setVisible(true);
        for(String a: model.getListKodeKelas()){
            ViewCreateTA.getCbKodeKelas().addItem(a);
        }
        
}
    
    @Override
        public void actionPerformed(ActionEvent ae){
            Object source = ae.getSource();
            if(source.equals(ViewCreateTA.getBtOut())){
                ViewCreateTA.setVisible(false);
                MP.setVisible(true);
            }else if(source.equals(ViewCreateTA.getBtCreateTA())){
                String JudulTA = ViewCreateTA.getTFJudulTA();
                String TopikTA = ViewCreateTA.getTFTopikTA();
                String KodeKelas = ViewCreateTA.getCbKodeKelas().getItemAt(ViewCreateTA.getCbKodeKelas().getSelectedIndex());
                m.createTA(KodeKelas, JudulTA, TopikTA);
                MP.getBtUploadTA().setText("Edit Tugas Akhir");
            }
        }
}
