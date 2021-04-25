package dao;

import entity.Egitmen;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

public class EgitmenDao {

    DBConnection db = new DBConnection();
    Connection c = db.connect();
    
     public void create(Egitmen e) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("insert into egitmen (ad,soyad,brans) values ('" + e.getAd() + "','" + e.getSoyad() + "','" + e.getBrans() + "')");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
     
      public Egitmen find(Long id) {
        Egitmen r = null;

        try {
             Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("select * from egitmen where id=" + id);
            rs.next();
            r = new Egitmen();
            r.setId(rs.getInt("id"));
            r.setAd(rs.getString("ad"));
            r.setSoyad(rs.getString("soyad"));
            r.setBrans(rs.getString("brans"));
           
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return r;
    }

    public List<Egitmen> findAll() {
        List<Egitmen> list = new ArrayList<>();
        try {
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("select * from egitmen order by id asc");
            while (rs.next()) {
                Egitmen tmp = new Egitmen(rs.getInt("id"), rs.getString("ad"), rs.getString("soyad"), rs.getString("brans"));
                list.add(tmp);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }

    public void update(Egitmen e) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("update egitmen set ad+'" + e.getAd() +"', soyad='"+e.getSoyad()+"', brans='"+e.getBrans()+"' where id+" + e.getId());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void delete(Egitmen e) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("delete from egitmen where id=" + e.getId());
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
