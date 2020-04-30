/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Application;
import Model.Dosen;
import Model.Person;
import View.EditUserPanel;
import View.AdminPanel;
import View.seeUserPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;


/**
 *
 * @author DivaPrasetya
 */
public class Handler_editUser  implements ActionListener{
    static EditUserPanel ViewEditUser;
    Application model;
    seeUserPanel sUP;
    
    public Handler_editUser(){
        sUP = Handler_seeUser.ViewSeeUser;
        model = Handler_Home.model;
        ViewEditUser = new EditUserPanel();
        ViewEditUser.addActionListener(this);
        ViewEditUser.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if(source.equals(ViewEditUser.getBtnRegister())){
            String x = ViewEditUser.getRoles();
            if("Dosen".equals(x)){
                model.addDosen(ViewEditUser.getTFUsername(),ViewEditUser.getTFPassword(),ViewEditUser.getTFName(),ViewEditUser.getTFNoHp(),ViewEditUser.getTFTTL());
                JOptionPane.showMessageDialog(null, "Dosen baru diubah", "Success", JOptionPane.WARNING_MESSAGE);
                for(Person p: model.getDaftarUser()){
                    System.out.println(p.getNama());
                }
            }else{
                model.addMahasiswa(ViewEditUser.getTFUsername(),ViewEditUser.getTFPassword(),ViewEditUser.getTFName(),ViewEditUser.getTFNoHp(),ViewEditUser.getTFTTL());
                JOptionPane.showMessageDialog(null, "Mahasiswa baru diubah", "Success", JOptionPane.WARNING_MESSAGE);
            }
            ViewEditUser.setVisible(false);
            sUP.setVisible(true);
        }
    }
}
