package dao;

import entity.Ehliyet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

public class EhliyetDao {

    DBConnection db = new DBConnection();
    Connection c = db.connect();
    
     public void create(Ehliyet e) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("insert into ehliyet (sinif,kullanma_yetkisi,egitmen_alan,surucu_aday) values ('" + e.getSinif() + "','" + e.getKullanma_yetkisi()+ "','" + e.getEgitmen_alan()+ "','" + e.getSurucu_aday()+ "')");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
     
      public List<Ehliyet> findAll(int page,int pageSize) {
        List<Ehliyet> ehliyetlist = new ArrayList<>();
         int start = (page-1)*pageSize;
        try {

            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("select * from ehliyet order by eh_id asc limit " + start + "," + pageSize);
            while (rs.next()) {
                Ehliyet tmp = new Ehliyet();
                tmp.setEh_id(rs.getInt("eh_id"));
                tmp.setSinif(rs.getString("sinif"));
                tmp.setKullanma_yetkisi(rs.getString("kullanma_yetkisi"));
                tmp.setEgitmen_alan(rs.getString("egitmen_alan"));
                tmp.setSurucu_aday(rs.getString("surucu_aday"));
                

                ehliyetlist.add(tmp);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return ehliyetlist;
    }
     
    

    public void update(Ehliyet e) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("update ehliyet set sinif='" + e.getSinif() +"', kullanma_yetkisi'"+e.getKullanma_yetkisi()+"',egitmen_alan'"+e.getEgitmen_alan()+"',surucu_aday'"+e.getSurucu_aday()+"' where eh_id+" + e.getEh_id());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void delete(Ehliyet e) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("delete from ehliyet where eh_id=" + e.getEh_id());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
     public int count() {
      int count = 0;
        try {
           
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("select count(eh_id) as ehliyet_count from ehliyet");
            rs.next();
            count = rs.getInt("ehliyet_count");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return count;
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
