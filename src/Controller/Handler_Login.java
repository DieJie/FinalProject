/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import static Controller.Handler_Dosen.ViewDosenPanel;
import Model.Application;
import Model.Dosen;
import Model.Mahasiswa;
import Model.Person;
import View.AdminPanel;
import View.DosenPanel;
import View.HomeScreen;
import View.LoginScreen;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import javax.swing.JOptionPane;

/**
 *
 * @author DivaPrasetya
 */
public class Handler_Login implements ActionListener{
    LoginScreen ViewLogin;
    Application model;
    static Dosen d;
    static Mahasiswa m;
    DosenPanel DP;

    
    public Handler_Login(){
        this.model = Handler_Home.getModel();
        ViewLogin = new LoginScreen();
        ViewLogin.addActionListener(this);
        ViewLogin.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if(source.equals(ViewLogin.getLoginBtn())){
            String username = ViewLogin.getTFUsername();
            String password = ViewLogin.getTFPassword();
            System.out.println(username+" "+password);
            Person user = model.searchUser(username, password);
            if(user != null){
                if(user instanceof Dosen){
                    d = (Dosen)user;
                    ViewLogin.setVisible(false);
                    Handler_Dosen HDP = new Handler_Dosen();
                }else if(user instanceof Mahasiswa){
                    m = (Mahasiswa)user;
                    ViewLogin.setVisible(false);
                    Handler_Mahasiswa HMP = new Handler_Mahasiswa();
                }
            }else{
                if("root".equals(username) && "123".equals(password)){
                    ViewLogin.setVisible(false);
                    Handler_AdminPanel HAP = new Handler_AdminPanel();
                }else{
                    JOptionPane.showMessageDialog(null, "USERNAME & PASSWORD DIDN'T MATCH", "WARNING", JOptionPane.WARNING_MESSAGE);
                }
            }
        }
    }
}
