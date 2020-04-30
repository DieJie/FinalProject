/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import static Controller.Handler_Home.ViewHome;
import Model.Application;
import Model.Dosen;
import Model.KelasTugasAkhir;
import Model.Mahasiswa;
import View.DosenPanel;
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
public class Handler_SeeTA extends MouseAdapter implements ActionListener {
    static seeTA ViewSeeTA;
    Application model;
    Dosen d;
    DosenPanel DP;
    KelasTugasAkhir mKTA;
    DefaultTableModel tdmodel;
    DefaultTableModel tmmodel;
    
    public Handler_SeeTA(){
        this.model = Handler_Home.model;
        d = Handler_Login.d;
        DP = Handler_Dosen.ViewDosenPanel;
        ViewSeeTA = new seeTA();
        ViewSeeTA.addActionListener(this);
        ViewSeeTA.addMouseAdapter(this);
        ViewSeeTA.setVisible(true);
        ViewSeeTA.setListKodeKelas(d.getListKodeKelas());
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if(source.equals(ViewSeeTA.getBtOut())){
            ViewSeeTA.setVisible(false);
            DP.setVisible(true);
        }else if(source.equals(ViewSeeTA.getBtDel())){
            model.deleteKTA(d.getKelasTA().getKodeKelas(), d);
            int x = tdmodel.getRowCount();
            for(int i = 0;i < x;i++){
                tdmodel.removeRow(i);
            }
            x = tmmodel.getRowCount();
            for(int i = 0; i<x;i++){
                tmmodel.removeRow(i);
            }
            ViewSeeTA.setTFKodeKelas("");
            ViewSeeTA.setTFTopik("");
            ViewSeeTA.setListKodeKelas(d.getListKodeKelas());
        }else if(source.equals(ViewSeeTA.getBtEdit())){
            boolean owner = mKTA == d.getKelasTA();
            if(owner){
                Handler_EditTA HETA = new Handler_EditTA(); 
            }else{
                JOptionPane.showMessageDialog(null, "Maaf anda bukan pemilik kelas ini", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        }
    }
    
    @Override
    public void mousePressed(MouseEvent ae){
        Object source = ae.getSource();
        if (source.equals(ViewSeeTA.getListKodeKelas())){
            String idKelas=ViewSeeTA.getSelectedID();
            mKTA = model.SearchKTA(idKelas);
            ViewSeeTA.setTFKodeKelas(idKelas);
            ViewSeeTA.setTFTopik(mKTA.getTopikTA());
            tdmodel = (DefaultTableModel) ViewSeeTA.getTableDosen().getModel();
            ArrayList<Dosen> listDosen = model.SearchListDosen(idKelas);
            Object rowDataDosen[] = new Object[3];
            for(int i = 0; i < listDosen.size(); i++)
            {
                rowDataDosen[0] = listDosen.get(i).getNama();
                rowDataDosen[1] = listDosen.get(i).getNidn();
                rowDataDosen[2] = listDosen.get(i).getNohp();
                tdmodel.addRow(rowDataDosen);
            }
            
            tmmodel = (DefaultTableModel) ViewSeeTA.getTableMhs().getModel();
            ArrayList<Mahasiswa> listMahasiswa = model.SearchListMahasiswa(idKelas);
            Object rowDataMhs[] = new Object[3];
            for(int i = 0; i < listDosen.size(); i++)
            {
                rowDataMhs[0] = listMahasiswa.get(i).getNama();
                rowDataMhs[1] = listMahasiswa.get(i).getNim();
                rowDataMhs[2] = listMahasiswa.get(i).getNohp();
                tmmodel.addRow(rowDataMhs);
            }           
        }
    }
}
