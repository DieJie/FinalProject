/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Application;
import Model.Dosen;
import View.HomeScreen;
import View.LoginScreen;
import Model.KelasTugasAkhir;
import Model.Mahasiswa;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author DivaPrasetya
 */
public class Handler_Home extends MouseAdapter implements ActionListener{
    static Application  model;
    static HomeScreen ViewHome;
    LoginScreen ViewLogin;
    DefaultTableModel tdmodel;
    DefaultTableModel tmmodel;
    
    public Handler_Home(){
        model = new Application();
        ViewHome = new HomeScreen();
        ViewHome.addActionListener(this);
        ViewHome.addMouseAdapter(this);
        ViewHome.setVisible(true);
        ViewHome.setListTA(model.getListKodeKelas());
        tdmodel = (DefaultTableModel) ViewHome.getTableDosen().getModel();
        tmmodel = (DefaultTableModel) ViewHome.getTableMahasiswa().getModel();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if(source.equals(ViewHome.getMasukBtn())){
            ViewHome.setVisible(false);
            Handler_Login HandlerLogin = new Handler_Login();
            for(int i = 0; i < tdmodel.getRowCount();i++){
                tdmodel.removeRow(i);
            }
            for(int i = 0; i < tmmodel.getRowCount();i++){
                tmmodel.removeRow(i);
            }
        }
    }
    
    @Override
    public void mousePressed(MouseEvent ae){
        try{
            Object source = ae.getSource();
            if (source.equals(ViewHome.getListKelasTA())){
                for(int i = 0; i < tdmodel.getRowCount();i++){
                    tdmodel.removeRow(i);
                }
                for(int i = 0; i < tmmodel.getRowCount();i++){
                    tmmodel.removeRow(i);
                }
                String idKelas=ViewHome.getSelectedID();
                ArrayList<Dosen> listDosen = model.SearchListDosen(idKelas);
                Object rowDataDosen[] = new Object[3];
                for(int i = 0; i < listDosen.size(); i++)
                {
                    rowDataDosen[0] = idKelas;
                    rowDataDosen[1] = listDosen.get(i).getNidn();
                    rowDataDosen[2] = listDosen.get(i).getNama();
                    tdmodel.addRow(rowDataDosen);
                }
                ArrayList<Mahasiswa> listMahasiswa = model.SearchListMahasiswa(idKelas);
                if(!listMahasiswa.isEmpty()){
                    Object rowDataMhs[] = new Object[3];
                    for(int i = 0; i < listDosen.size(); i++)
                    {
                        rowDataMhs[0] = idKelas;
                        rowDataMhs[1] = listMahasiswa.get(i).getNim();
                        rowDataMhs[2] = listMahasiswa.get(i).getNama();
                        tmmodel.addRow(rowDataMhs);
                    }
                }
            }
        }catch(NullPointerException npe){
            System.out.println("Something went wrong");
        }
    }
    
    public static Application getModel(){
        return model;
    }

    
}
