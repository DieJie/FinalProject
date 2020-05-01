/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import static Controller.Handler_Home.model;
import Model.Application;
import Model.Dosen;
import Model.Mahasiswa;
import View.EditTA;
import View.MahasiswaPanel;
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
    EditTA ViewEditTA;
    Application model;
    Mahasiswa m;
    MahasiswaPanel MP;
    Dosen d;
    DefaultTableModel tdmodel;
    
    public Handler_EditTA(){
        this.model = Handler_Home.model;
        m = Handler_Login.m;
        MP = Handler_Mahasiswa.ViewMhsPanel;
        ViewEditTA = new EditTA();
        ViewEditTA.addActionListener(this);
        ViewEditTA.addMouseAdapter(this);
        ViewEditTA.setVisible(true);
        ViewEditTA.getTFKodeKelas().setText(m.getKelasTA().getKodeKelas());
        ViewEditTA.getTFJudulTA().setText(m.getTugasAkhir().getJudul());
        ViewEditTA.getTFTopikTA().setText(m.getTugasAkhir().getTopik());
        ViewEditTA.setListDosen(m.getKelasTA().getListNamaDosen());
        tdmodel = (DefaultTableModel) ViewEditTA.getTableDosen().getModel();
        ArrayList<Dosen> listDosenA = m.getTugasAkhir().getPembimbing();
        Object rowDataDosen[] = new Object[3];
        for(int i = 0; i < listDosenA.size(); i++)
        {
            rowDataDosen[0] = listDosenA.get(i).getNama();
            rowDataDosen[1] = listDosenA.get(i).getNidn();
            rowDataDosen[2] = "Approve";
            tdmodel.addRow(rowDataDosen);
        }
        ArrayList<Dosen> listDosenAN = m.getTugasAkhir().getPembimbingNonApproval();
        for(int i = 0; i < listDosenA.size(); i++)
        {
            rowDataDosen[0] = listDosenAN.get(i).getNama();
            rowDataDosen[1] = listDosenAN.get(i).getNidn();
            rowDataDosen[2] = "Non Approve";
            tdmodel.addRow(rowDataDosen);
        }
        ArrayList<Dosen> listDosenR = m.getTugasAkhir().getPembimbingReject();
        for(int i = 0; i < listDosenR.size(); i++)
        {
            rowDataDosen[0] = listDosenR.get(i).getNama();
            rowDataDosen[1] = listDosenR.get(i).getNidn();
            rowDataDosen[2] = "Rejected";
            tdmodel.addRow(rowDataDosen);
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if(source.equals(ViewEditTA.getBtOut())){
            ViewEditTA.setVisible(false);
            MP.setVisible(true);
        }else if(source.equals(ViewEditTA.getBtAddDosen())){
            if(d!=null){
                m.addPembimbingTA(d);
                ArrayList<Dosen> listDosenA = m.getTugasAkhir().getPembimbing();
                Object rowDataDosen[] = new Object[3];
                for(int i = 0; i < listDosenA.size(); i++)
                {
                    rowDataDosen[0] = listDosenA.get(i).getNama();
                    rowDataDosen[1] = listDosenA.get(i).getNidn();
                    rowDataDosen[2] = "Approve";
                    tdmodel.addRow(rowDataDosen);
                }
                ArrayList<Dosen> listDosenAN = m.getTugasAkhir().getPembimbingNonApproval();
                for(int i = 0; i < listDosenA.size(); i++)
                {
                    rowDataDosen[0] = listDosenAN.get(i).getNama();
                    rowDataDosen[1] = listDosenAN.get(i).getNidn();
                    rowDataDosen[2] = "Non Approve";
                    tdmodel.addRow(rowDataDosen);
                }
                ArrayList<Dosen> listDosenR = m.getTugasAkhir().getPembimbingReject();
                for(int i = 0; i < listDosenR.size(); i++)
                {
                    rowDataDosen[0] = listDosenR.get(i).getNama();
                    rowDataDosen[1] = listDosenR.get(i).getNidn();
                    rowDataDosen[2] = "Rejected";
                    tdmodel.addRow(rowDataDosen);
                }
            }else{
                JOptionPane.showMessageDialog(null, "Silahkan pilih dosen terlebih dulu", "WARNING", JOptionPane.WARNING_MESSAGE);
            }
        }
    }
    
    @Override
    public void mousePressed(MouseEvent ae){
        Object source = ae.getSource();
        if(source.equals(ViewEditTA.getListDosen())){
            String nama = ViewEditTA.getSelectedID();
            d = m.getKelasTA().getDosen(nama);
        }
    }
}
