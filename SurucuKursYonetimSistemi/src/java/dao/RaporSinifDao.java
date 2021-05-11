
package dao;

import entity.RaporSinif;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

public class RaporSinifDao {
    DBConnection db = new DBConnection();
    Connection c = db.connect();

    public void create(RaporSinif ro) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("insert into sinif_perfs (sinif_ad,performans) values ('" + ro.getSinif_ad() + "','" + ro.getPerformans() + "')");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    

    public List<RaporSinif> findAll(int page,int pageSize) {
        List<RaporSinif> raporegitlist = new ArrayList<>();
         int start = (page-1)*pageSize;
        try {

            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("select * from sinif_perfs order by s_id asc limit " + start + "," + pageSize);
            while (rs.next()) {
                RaporSinif tmp = new RaporSinif();
                tmp.setS_id(rs.getInt("s_id"));
                tmp.setSinif_ad(rs.getString("sinif_ad"));
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
            ResultSet rs = st.executeQuery("select count(rid) as raporsinif_count from sinif_perfs");
            rs.next();
            count = rs.getInt("raporsinif_count");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return count;
    }

    public void update(RaporSinif ro) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("update sinif_perfs set sinif_ad='" + ro.getSinif_ad() + "', performans='" + ro.getPerformans() + "' where s_id=" + ro.getS_id());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void delete(RaporSinif ro) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("delete from rapor where s_id=" + ro.getS_id());
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
