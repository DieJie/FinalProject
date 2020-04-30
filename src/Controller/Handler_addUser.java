/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Application;
import Model.Dosen;
import Model.Person;
import View.AddUserPanel;
import View.AdminPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;


/**
 *
 * @author DivaPrasetya
 */
public class Handler_addUser  implements ActionListener{
    static AddUserPanel ViewAddUser;
    Application model;
    AdminPanel AP;
    
    public Handler_addUser(){
        AP = Handler_AdminPanel.ViewAdminPanel;
        model = Handler_Home.model;
        ViewAddUser = new AddUserPanel();
        ViewAddUser.addActionListener(this);
        ViewAddUser.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if(source.equals(ViewAddUser.getBtnRegister())){
            String x = ViewAddUser.getRoles();
            if("Dosen".equals(x)){
                model.addDosen(ViewAddUser.getTFUsername(),ViewAddUser.getTFPassword(),ViewAddUser.getTFName(),ViewAddUser.getTFNoHp(),ViewAddUser.getTFTTL());
                JOptionPane.showMessageDialog(null, "Dosen baru didaftarkan", "Success", JOptionPane.WARNING_MESSAGE);
                for(Person p: model.getDaftarUser()){
                    System.out.println(p.getNama());
                }
            }else{
                model.addMahasiswa(ViewAddUser.getTFUsername(),ViewAddUser.getTFPassword(),ViewAddUser.getTFName(),ViewAddUser.getTFNoHp(),ViewAddUser.getTFTTL());
                JOptionPane.showMessageDialog(null, "Mahasiswa baru didaftarkan", "Success", JOptionPane.WARNING_MESSAGE);
            }
            ViewAddUser.setVisible(false);
            AP.setVisible(true);
        }
    }
}
