/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import static Controller.Handler_addUser.ViewAddUser;
import Model.Application;
import Model.Dosen;
import Model.Person;
import View.AddUserPanel;
import View.AdminPanel;
import View.EditUserPanel;
import View.seeUserPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DivaPrasetya
 */
public class Handler_seeUser  implements ActionListener{
    static seeUserPanel ViewSeeUser;
    Application model;
    AdminPanel AP;
    EditUserPanel AUP;
    
    public Handler_seeUser(){
        Handler_editUser HeU = new Handler_editUser();
        AUP = Handler_editUser.ViewEditUser;
        AP = Handler_AdminPanel.ViewAdminPanel;
        this.model = Handler_Home.model;
        ViewSeeUser = new seeUserPanel();
        ViewSeeUser.ActionListener(this);
        ViewSeeUser.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if(source.equals(ViewSeeUser.getBtnOut())){
            ViewSeeUser.setVisible(false);
            AP.setVisible(true);
        }else if(source.equals(ViewSeeUser.getBtnSee())){
            String search = ViewSeeUser.getTextTFName();
            if(search.equals("")){
                JOptionPane.showMessageDialog(null, "Maaf anda belum menulis apapun", "Warning", JOptionPane.WARNING_MESSAGE);
            }else{
                Person p = model.searchUser(search);
                DefaultTableModel tdmodel = (DefaultTableModel) ViewSeeUser.getTbUser().getModel();
                Object rowData[] = new Object[6];
                if(null != p){
                    rowData[0] = p.getUsername();
                    rowData[1] = p.getPassword();
                    rowData[2] = p.getNama();
                    if(p instanceof Dosen){
                        rowData[3] = "Dosen";
                    }else{
                        rowData[3] = "Mahasiswa";
                    }
                    rowData[4] = p.getNohp();
                    rowData[5] = p.getTtl();
                    tdmodel.addRow(rowData);
                }else{
                    rowData[0] = "";
                    rowData[1] = "";
                    rowData[2] = "";
                    rowData[3] = "";
                    rowData[4] = "";
                    rowData[5] = "";
                    tdmodel.addRow(rowData);
                    JOptionPane.showMessageDialog(null, "Maaf data yang anda cari tidak ada", "Warning", JOptionPane.WARNING_MESSAGE);
                }
            }
        }else if(source.equals(ViewSeeUser.getBtnEdit())){
            try{
                String search = ViewSeeUser.getTextTFName();
                if(search.equals("")){
                    JOptionPane.showMessageDialog(null, "Maaf anda belum menulis apapun", "Warning", JOptionPane.WARNING_MESSAGE);
                }else{
                    Person p = model.searchUser(search);
                    if(null != p){
                        AUP.setVisible(true);
                        AUP.setTFName(p.getNama());
                        AUP.setTFNoHp(p.getNohp());
                        AUP.setTFPassword(p.getPassword());
                        AUP.setTFTTL(p.getTtl());
                        AUP.setTFUsername(p.getUsername());
                    }else{
                        JOptionPane.showMessageDialog(null, "Maaf data yang anda cari tidak ada", "Warning", JOptionPane.WARNING_MESSAGE);
                    }
                }
            }catch(NullPointerException e){
                System.out.println("Something Went Wrong");
            }
        }else if(source.equals(ViewSeeUser.getBtnDel())){
            String search = ViewSeeUser.getTextTFName();
            if(search.equals("")){
                JOptionPane.showMessageDialog(null, "Maaf anda belum menulis apapun", "Warning", JOptionPane.WARNING_MESSAGE);
            }else{
                Person p = model.searchUser(search);
                DefaultTableModel tdmodel = (DefaultTableModel) ViewSeeUser.getTbUser().getModel();
                Object rowData[] = new Object[6];
                if(null != p){
                    model.getDaftarUser().remove(p);
                    JOptionPane.showMessageDialog(null, "Data Berhasil dihapus", "Success", JOptionPane.WARNING_MESSAGE);
                    tdmodel.removeRow(0);
                }else{
                    JOptionPane.showMessageDialog(null, "Maaf data yang anda cari tidak ada", "Warning", JOptionPane.WARNING_MESSAGE);
                }
            }
        }
    }
}
