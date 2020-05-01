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
import View.createKTA;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author DivaPrasetya
 */
public class Handler_CreateKTA implements ActionListener{
    static createKTA ViewCreateTA;
    Application model;
    Dosen d;
    DosenPanel DP;
    HomeScreen HS;
    
    
    public Handler_CreateKTA(){
        this.model = Handler_Home.getModel();
        d = Handler_Login.d;
        HS = Handler_Home.ViewHome;
        DP = Handler_Dosen.ViewDosenPanel;
        ViewCreateTA = new createKTA();
        ViewCreateTA.addActionListener(this);
        ViewCreateTA.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if(source.equals(ViewCreateTA.getBtCreateTA())){
            String topik = ViewCreateTA.getTFTopik();
            model.createKelasTA(topik, d);
            JOptionPane.showMessageDialog(null, "Kelas berhasil dibuat", "Success", JOptionPane.WARNING_MESSAGE);
            ViewCreateTA.setVisible(false);
            DP.setBtnText("Lihat Daftar Kelas");
            HS.setListTA(model.getListKodeKelas());
        }
    }
    
}
