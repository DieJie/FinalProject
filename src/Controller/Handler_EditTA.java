/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Application;
import Model.Dosen;
import Model.Mahasiswa;
import Model.Person;
import View.DosenPanel;
import View.EditTAPanel;
import View.HomeScreen;
import View.createTA;
import View.seeTA;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DivaPrasetya
 */
public class Handler_EditTA extends MouseAdapter implements ActionListener{
    EditTAPanel ViewEditTA;
    Application model;
    Dosen d;
    HomeScreen HS;
    DefaultTableModel tmodel;
    seeTA sTA;
    Object rowData[];
    Person p;
    
    public Handler_EditTA(){
        p = null;
        this.model=Handler_Home.getModel();
        d = Handler_Login.d;
        HS = Handler_Home.ViewHome;
        sTA = Handler_SeeTA.ViewSeeTA;
        ViewEditTA = new EditTAPanel();
        ViewEditTA.addActionListener(this);
        ViewEditTA.addMouseAdapter(this);
        ViewEditTA.setVisible(true);
        ViewEditTA.setListDosen(d.getKelasTA().getListNamaDosen(), d.getKelasTA().getListNamaMahasiswa());
        tmodel = (DefaultTableModel) ViewEditTA.getTableUser().getModel();
        rowData = new Object[3];
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if(source.equals(ViewEditTA.getBtOut())){
            ViewEditTA.setVisible(false);
            sTA.setVisible(true);
        }else if(source.equals(ViewEditTA.getBtAddDosen())){
            Person name = model.searchUser(ViewEditTA.getTFAddDosen().getText());
            d.getKelasTA().addDosen((Dosen) name);
        }else if(source.equals(ViewEditTA.getBtDel())){
            if(p != null){
                if(p instanceof Dosen){
                    d.getKelasTA().delDosen((Dosen)p);
                    ViewEditTA.getListDosen().clearSelection();
                    ViewEditTA.setListDosen(d.getKelasTA().getListNamaDosen(), d.getKelasTA().getListNamaMahasiswa());
                }else{
                    d.getKelasTA().delMhs((Mahasiswa)p);
                    ViewEditTA.getListMhs().clearSelection();
                    ViewEditTA.setListDosen(d.getKelasTA().getListNamaDosen(), d.getKelasTA().getListNamaMahasiswa());
                }
            }else{
                JOptionPane.showMessageDialog(null, "Anda belum memilih apapun", "WARNING", JOptionPane.WARNING_MESSAGE);
            }
        }
        sTA.setListKodeKelas(d.getListKodeKelas());
    }
    
    @Override
    public void mousePressed(MouseEvent ae){
        Object source = ae.getSource();
        if(source.equals(ViewEditTA.getListDosen())){
            String nama = ViewEditTA.getSelectedDosen();
            p = model.searchUser(nama);
            Dosen dosen = (Dosen)p;
            ViewEditTA.getListMhs().clearSelection();
            tmodel.removeRow(0);
            rowData[0] = dosen.getNama();
            rowData[1] = dosen.getNidn();
            rowData[2] = dosen.getNohp();
            tmodel.addRow(rowData);
        }else if(source.equals(ViewEditTA.getListMhs())){
            String nama = ViewEditTA.getSelectedMhs();
            p = model.searchUser(nama);
            Mahasiswa mhs = (Mahasiswa)p;
            ViewEditTA.getListDosen().clearSelection();
            tmodel.removeRow(0);
            rowData[0] = mhs.getNama();
            rowData[1] = mhs.getNim();
            rowData[2] = mhs.getNohp();
            tmodel.addRow(rowData);
        }
    }
}
