package dao;

import entity.Egitmen;
import entity.SurucuAday;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

public class SurucuAdayDao {
    DBConnection db = new DBConnection();
    Connection c = db.connect();
    
     public void create(SurucuAday s) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("insert into aday (ad,soyad,yas,egitim_durumu,adres) values ('" + s.getAd() + "','" + s.getSoyad() + "','" + s.getYas() + "','"+s.getEgitim_durumu()+"','"+s.getAdres()+"')");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

   public List<SurucuAday> findAll() {
        List<SurucuAday> surucuadaylist = new ArrayList<>();
        try {
           
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("select * from aday");
            while (rs.next()) {
                SurucuAday tmp = new SurucuAday();
                tmp.setId(rs.getInt("id"));
                tmp.setAd(rs.getString("ad"));
                tmp.setSoyad(rs.getString("soyad"));
                tmp.setYas(rs.getInt("yas"));
                tmp.setEgitim_durumu(rs.getString("egitim_durumu"));
                tmp.setAdres(rs.getString("adres"));
                
                surucuadaylist.add(tmp);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return surucuadaylist;
    }

    public void update(SurucuAday s) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("update aday set ad='" + s.getAd() +"', soyad='"+s.getSoyad()+"', yas='"+s.getYas()+"', egitim_durumu='"+s.getEgitim_durumu()+"', adres='"+s.getAdres()+"' where id=" + s.getId());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
   
    public void delete(SurucuAday s) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("delete from aday where id=" + s.getId());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public DBConnection getDb() {
        if (db == null) {
            this.db = new DBConnection();
        }
        return db;
    }

    public void setDb(DBConnection db) {
        this.db = db;
    }

    public Connection connect() {
         if (this.c == null) {
            this.c = this.getDb().connect();
        }
        return c;
    }

    public void setC(Connection c) {
        this.c = c;
    }

  
}
