
package dao;

import entity.AracBilgi;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

public class AracBilgiDao {
    DBConnection db = new DBConnection();
    Connection c = db.connect();
    
     public void create(AracBilgi a) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("insert into arac (plaka,arac_tur,uretim_yil,sigorta_durum) values ('" +a.getPlaka() + "','" + a.getArac_tur() + "','" + a.getUretim_yil() + "','" + a.getSigorta_durum() + "')");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

   public List<AracBilgi> findAll(int page,int pageSize) {
        List<AracBilgi> araclist = new ArrayList<>();
        int start = (page-1)*pageSize;
        try {
           
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("select * from arac order by id asc limit " + start + "," + pageSize);
            while (rs.next()) {
                AracBilgi tmp = new AracBilgi();
                tmp.setId(rs.getInt("id"));
                tmp.setPlaka(rs.getString("plaka"));
                tmp.setArac_tur(rs.getString("arac_tur"));
                tmp.setUretim_yil(rs.getInt("uretim_yil"));
                tmp.setSigorta_durum(rs.getString("sigorta_durum"));
                
                
                araclist.add(tmp);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return araclist;
    }
    public int count() {
      int count = 0;
        try {
           
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("select count(id) as arac_count from arac");
            rs.next();
            count = rs.getInt("arac_count");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return count;
    }

    public void update(AracBilgi a) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("update arac set plaka='" + a.getPlaka() +"', arac_tur='"+a.getArac_tur()+"', uretim_yil='"+a.getUretim_yil()+"', sigorta_durum='"+a.getSigorta_durum()+"' where id=" + a.getId());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
   
    public void delete(AracBilgi a) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("delete from arac where id=" + a.getId());
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
