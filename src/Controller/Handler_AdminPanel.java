/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Application;
import View.AdminPanel;
import View.HomeScreen;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author DivaPrasetya
 */
public class Handler_AdminPanel implements ActionListener {
    static AdminPanel ViewAdminPanel;
    Application model;
    HomeScreen HM;
    
    public Handler_AdminPanel(){
        this.model = Handler_Home.getModel();
        ViewAdminPanel = new AdminPanel();
        ViewAdminPanel.addActionListesner(this);
        ViewAdminPanel.setVisible(true);
        this.HM = Handler_Home.ViewHome;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        Object source = ae.getSource();
        if(source.equals(ViewAdminPanel.getBtnAddUser())){
            Handler_addUser HaU=new Handler_addUser();
        }else if(source.equals(ViewAdminPanel.getBtnSeeUser())){
            Handler_seeUser HsU = new Handler_seeUser();
            Handler_editUser HeU = new Handler_editUser();
        }else if(source.equals(ViewAdminPanel.getBtnOut())){
            ViewAdminPanel.setVisible(false);
            HM.setVisible(true);
        }
    }
}
