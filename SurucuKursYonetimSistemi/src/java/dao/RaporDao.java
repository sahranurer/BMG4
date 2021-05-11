package dao;

import entity.Rapor;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

public class RaporDao {
    DBConnection db = new DBConnection();
    Connection c = db.connect();

    public void create(Rapor ro) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("insert into rapor (radsoyad,ehliyet,performans,egitmenad) values ('" + ro.getRadsoyad() + "','" + ro.getEhliyet() + "','" + ro.getPerformans() + "','" + ro.getEgitmenad() + "')");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    

    public List<Rapor> findAll(int page,int pageSize) {
        List<Rapor> raporlist = new ArrayList<>();
         int start = (page-1)*pageSize;
        try {

            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("select * from rapor order by rap_id asc limit " + start + "," + pageSize);
            while (rs.next()) {
                Rapor tmp = new Rapor();
                tmp.setRap_id(rs.getInt("rap_id"));
                tmp.setRadsoyad(rs.getString("radsoyad"));
                tmp.setEhliyet(rs.getString("ehliyet"));
                tmp.setPerformans(rs.getString("performans"));
                tmp.setEgitmenad(rs.getString("egitmenad"));
                

                raporlist.add(tmp);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return raporlist;
    }
    
      public int count() {
      int count = 0;
        try {
           
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("select count(rid) as rapor_count from rapor");
            rs.next();
            count = rs.getInt("rapor_count");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return count;
    }

    public void update(Rapor ro) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("update rapor set radsoyad='" + ro.getRadsoyad() + "', ehliyet='" + ro.getEhliyet() + "', performans='" + ro.getPerformans() + "', egitmenad='" + ro.getEgitmenad() + "' where rap_id=" + ro.getRap_id());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void delete(Rapor ro) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("delete from rapor where rap_id=" + ro.getRap_id());
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
