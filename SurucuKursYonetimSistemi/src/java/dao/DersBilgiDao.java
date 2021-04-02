package dao;

import entity.DersBilgi;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

public class DersBilgiDao {
    DBConnection db = new DBConnection();
    Connection c = db.connect();
    /*
    public DersBilgi getById(int id){
        DersBilgi d = null;
        try {
           
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("select * from ders where id");
            rs.next();
            d = new DersBilgi(rs.getInt("id"),rs.getString("ders_ad"),rs.getString("ders_tur"),rs.getString("ders_kont"));

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return d;
    }
    */
    
     public void create(DersBilgi d) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("insert into ders (ders_ad,ders_tur,ders_kont) values ('" + d.getDers_ad() + "','" + d.getDers_tur() + "','" + d.getDers_kont() + "')");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

   public List<DersBilgi> findAll() {
        List<DersBilgi> dersbilgilist = new ArrayList<>();
        try {
           
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("select * from ders");
            while (rs.next()) {
                DersBilgi tmp = new DersBilgi();
                tmp.setId(rs.getInt("id"));
                tmp.setDers_ad(rs.getString("ders_ad"));
                tmp.setDers_tur(rs.getString("ders_tur"));
                tmp.setDers_kont(rs.getString("ders_kont"));
                
                
                dersbilgilist.add(tmp);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return dersbilgilist;
    }

    public void update(DersBilgi d) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("update ders set ders_ad='" + d.getDers_ad() +"', ders_tur='"+d.getDers_tur()+"', ders_kont='"+d.getDers_kont()+"' where id=" + d.getId());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
   
    public void delete(DersBilgi d) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("delete from ders where id=" + d.getId());
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
