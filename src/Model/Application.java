/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DivaPrasetya
 */
public class Application{
    private ArrayList<Person> daftarUser;
    private ArrayList<KelasTugasAkhir> daftarKTA;
    
    public Application(){
        daftarUser = new ArrayList();
        daftarKTA = new ArrayList();
    }
    
    public void addMahasiswa(String username,String password,String nama,String nohp,String ttl){
        Mahasiswa m = new Mahasiswa(username,password,nama,nohp,ttl);
        daftarUser.add(m);
    }
    
    public Mahasiswa getMahasiswa(int nim){
        for(Person p : daftarUser){
            if(p instanceof Mahasiswa){
                if(((Mahasiswa) p).getNim() == nim){
                    return (Mahasiswa)p;
                }
            }
        }
        return null;
    }
    
    public void deleteMahasiswa(int nim){
        try{
            daftarUser.remove(getMahasiswa(nim));
        }catch(NullPointerException npe){
            throw npe;
        }
    }
    
    public void addDosen(String username,String password,String nama,String nohp,String ttl){
        Dosen d = new Dosen(username,password,nama,nohp,ttl);
        daftarUser.add(d);
    }
    
    public Dosen getDosen(int nidn){
        for(Person p : daftarUser){
            if(p instanceof Dosen){
                if(((Dosen) p).getNidn() == nidn){
                    return (Dosen)p;
                }
            }
        }
        return null;
    }
  
    public void deleteDosen(int nidn){
        try{
            daftarUser.remove(getDosen(nidn));
        }catch(NullPointerException npe){
            throw npe;
        }
     }
    
    public String[] getListKodeKelas(){
        String[] listKodeKelas=new String[daftarKTA.size()];
        int i = 0;
        for (KelasTugasAkhir b: daftarKTA){
                listKodeKelas[i] = b.KodeKelas;
                i++;
        }
        return listKodeKelas;
    }
    
    public void createKelasTA(String topik, Dosen d){
        d.createKelompokTA(topik, d);
        daftarKTA.add(d.getKelasTA());
        d.getKelasTA().addDosen(d);
    }

    public List<Person> getDaftarUser() {
        return daftarUser;
    }

    public List<KelasTugasAkhir> getDaftarKTA() {
        return daftarKTA;
    }
    
   public ArrayList<Dosen> SearchListDosen(String KodeKelas){
        for (KelasTugasAkhir KTA: daftarKTA){
            if (KTA.getKodeKelas() == KodeKelas){
                 return (ArrayList<Dosen>) (KTA.getTimDosen());
            }
        }
        return null;
    }
   
      public KelasTugasAkhir SearchKTA(String KodeKelas){
        for (KelasTugasAkhir KTA: daftarKTA){
            if (KTA.getKodeKelas() == KodeKelas){
                 return KTA;
            }
        }
        return null;
    }
      
   public ArrayList<Mahasiswa> SearchListMahasiswa(String KodeKelas){
        for (KelasTugasAkhir KTA: daftarKTA){
            if (KTA.getKodeKelas().equals(KodeKelas)){
                 return (ArrayList<Mahasiswa>) (KTA.getDaftarMhsTA());
            }
        }
        return null;
    }
   
   public Person searchUser(String username, String password){
        for(Person User: daftarUser){
            if(User.getUsername().equals(username) && User.getPassword().equals(password)){
                return User;
            }
        }
        return null;
    }
   
      public Person searchUser(String nama){
        for(Person User: daftarUser){
            if(User.getNama().equals(nama)){
                return User;
            }
        }
        return null;
    }
      
    public int searchUserNum(String nama){
        int i = 0;
        for(Person User: daftarUser){
            if(User.getNama().equals(nama)){
                return i;
            }
            i++;
        }
        return -1;
    }
    
    public void updateMahasiswa(String username,String password,String nama,String nohp,String ttl,int i){
        Mahasiswa m = new Mahasiswa(username,password,nama,nohp,ttl);
        daftarUser.set(i, m);
    }
    
    public void updateDosen(String username,String password,String nama,String nohp,String ttl,int i){
        Dosen d = new Dosen(username,password,nama,nohp,ttl);
        daftarUser.set(i, d);
    }
    
    public void deleteKTA(String KodeKelas, Dosen d){
        d.delKTA();
        KelasTugasAkhir KTA = SearchKTA(KodeKelas);
        int i = -1;
        for(KelasTugasAkhir kta: daftarKTA){
            i++;
            if(kta.KodeKelas == KTA.KodeKelas){
                break;
            }
        }
        daftarKTA.remove(i);
    }
}
