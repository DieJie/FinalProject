/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Application;
import Model.Dosen;
import Model.KelasTugasAkhir;
import Model.Mahasiswa;
import View.ApproveMhs;
import View.DosenPanel;
import View.HomeScreen;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author DivaPrasetya
 */
public class Handler_ApproveMhs extends MouseAdapter implements ActionListener{
    ApproveMhs ViewApproveMhs;
    Application model;
    DosenPanel DP;
    HomeScreen HS;
    Dosen d;
    Mahasiswa m;
    KelasTugasAkhir KTA;
    
    public Handler_ApproveMhs(){
        this.model = Handler_Home.model;
        d = Handler_Login.d;
        HS = Handler_Home.ViewHome;
        DP = Handler_Dosen.ViewDosenPanel;
        ViewApproveMhs = new ApproveMhs();
        ViewApproveMhs.addActionListener(this);
        ViewApproveMhs.addMouseAdapter(this);
        ViewApproveMhs.setVisible(true);
        ViewApproveMhs.setListKodeKelas(d.getListKodeKelas());
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if(source.equals(ViewApproveMhs.getBtOut())){
            ViewApproveMhs.setVisible(false);
            DP.setVisible(true);
        }else if(source.equals(ViewApproveMhs.getBtReject())){
            m.rejectPembimbingTA(d.getNidn());
            ViewApproveMhs.setListKodeKelas(KTA.getListMahasiswa());
            ViewApproveMhs.setListMhs(KTA.getListMahasiswa());
        }else if(source.equals(ViewApproveMhs.getBtApprove())){
            m.convertPembimbingTA(d.getNidn());
            ViewApproveMhs.setListKodeKelas(KTA.getListMahasiswa());
            ViewApproveMhs.setListMhs(KTA.getListMahasiswa());
        }
    }
    
    @Override
    public void mousePressed(MouseEvent ae){
        Object source = ae.getSource();
        if(source.equals(ViewApproveMhs.getLisKodeKelas())){
            String KodeKelas = ViewApproveMhs.getSelectedKodeKelas();
            KTA = d.getKTA(KodeKelas);
            ViewApproveMhs.setListMhs(KTA.getListMahasiswa());
        }if(source.equals(ViewApproveMhs.getListMhs())){
            String nama = ViewApproveMhs.getSelectedMhs();
            m = KTA.getMhs(nama);
            ViewApproveMhs.setTFJudulTA(m.getTugasAkhir().getJudul());
        }
    }
}
