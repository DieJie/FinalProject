/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author DivaPrasetya
 */
public abstract class Person {
    private String username;
    private String password;
    private String nama;
    private String nohp;
    private String ttl;
    
    public Person(String username,String password,String nama,String nohp,String ttl){
        this.username = username;
        this.password = password;
        this.nama = nama;
        this.nohp = nohp;
        this.ttl = ttl;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getNama() {
        return nama;
    }

    public String getNohp() {
        return nohp;
    }

    public String getTtl() {
        return ttl;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setNohp(String nohp) {
        this.nohp = nohp;
    }

    public void setTtl(String ttl) {
        this.ttl = ttl;
    }
    
    
}
