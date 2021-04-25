package dao;

import entity.RandevuOlustur;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

public class RandevuOlusturDao {

    DBConnection db = new DBConnection();
    Connection c = db.connect();

    public void create(RandevuOlustur ro) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("insert into randevu (aday_adsoyad,egitmen_adsoyad,gun,saat) values ('" + ro.getAday_adsoyad() + "','" + ro.getEgitmen_adsoyad() + "','" + ro.getGun() + "','" + ro.getSaat() + "')");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
     public RandevuOlustur getById(int rid){
        RandevuOlustur r = null;
        try {
           
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("select * from randevu where rid="+rid);
            rs.next();
            r = new RandevuOlustur(rs.getInt("rid"),rs.getString("aday_adsoyad"),rs.getString("egitmen_adsoyad"),rs.getString("gun"),rs.getString("saat"));

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return r;
    }

    public List<RandevuOlustur> findAll(int page,int pageSize) {
        List<RandevuOlustur> randevulist = new ArrayList<>();
         int start = (page-1)*pageSize;
        try {

            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("select * from randevu order by rid asc limit " + start + "," + pageSize);
            while (rs.next()) {
                RandevuOlustur tmp = new RandevuOlustur();
                tmp.setRid(rs.getInt("rid"));
                tmp.setAday_adsoyad(rs.getString("aday_adsoyad"));
                tmp.setEgitmen_adsoyad(rs.getString("egitmen_adsoyad"));
                tmp.setGun(rs.getString("gun"));
                tmp.setSaat(rs.getString("saat"));

                randevulist.add(tmp);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return randevulist;
    }
    
      public int count() {
      int count = 0;
        try {
           
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("select count(rid) as randevu_count from randevu");
            rs.next();
            count = rs.getInt("randevu_count");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return count;
    }

    public void update(RandevuOlustur ro) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("update randevu set aday_adsoyad='" + ro.getAday_adsoyad() + "', egitmen_adsoyad='" + ro.getEgitmen_adsoyad() + "', gun='" + ro.getGun() + "', saat='" + ro.getSaat() + "' where rid=" + ro.getRid());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void delete(RandevuOlustur ro) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("delete from randevu where rid=" + ro.getRid());
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
