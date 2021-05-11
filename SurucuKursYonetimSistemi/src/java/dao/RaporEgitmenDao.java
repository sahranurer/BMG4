
package dao;

import entity.RaporEgitmen;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

public class RaporEgitmenDao {
    DBConnection db = new DBConnection();
    Connection c = db.connect();

    public void create(RaporEgitmen ro) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("insert into egitmen_perfs (adsoyad,performans) values ('" + ro.getAdsoyad() + "','" + ro.getPerformans() + "')");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    

    public List<RaporEgitmen> findAll(int page,int pageSize) {
        List<RaporEgitmen> raporegitlist = new ArrayList<>();
         int start = (page-1)*pageSize;
        try {

            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("select * from egitmen_perfs order by per_id asc limit " + start + "," + pageSize);
            while (rs.next()) {
                RaporEgitmen tmp = new RaporEgitmen();
                tmp.setPerf_id(rs.getInt("per_id"));
                tmp.setAdsoyad(rs.getString("adsoyad"));
                tmp.setPerformans(rs.getString("performans"));
                

                raporegitlist.add(tmp);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return raporegitlist;
    }
    
      public int count() {
      int count = 0;
        try {
           
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("select count(rid) as raporegit_count from egitmen_perfs");
            rs.next();
            count = rs.getInt("raporegit_count");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return count;
    }

    public void update(RaporEgitmen ro) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("update egitmen_perfs set adsoyad='" + ro.getAdsoyad() + "', performans='" + ro.getPerformans() + "' where per_id=" + ro.getPerf_id());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void delete(RaporEgitmen ro) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("delete from rapor where per_id=" + ro.getPerf_id());
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

