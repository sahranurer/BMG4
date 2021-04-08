package dao;

import entity.DersProgram;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

public class DersProgramDao {
    DBConnection db = new DBConnection();
    Connection c = db.connect();
    
     public void create(DersProgram dp) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("insert into dersprogram (gunler,saatler,ders) values ('" + dp.getGunler() + "','" + dp.getSaatler() + "','" + dp.getDers() + "')");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

   public List<DersProgram> findAll() {
        List<DersProgram> dersprogramlist = new ArrayList<>();
        try {
           
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("select * from dersprogram");
            while (rs.next()) {
                DersProgram tmp = new DersProgram();
                tmp.setPid(rs.getInt("pid"));
                tmp.setGunler(rs.getString("gunler"));
                tmp.setSaatler(rs.getString("saatler"));
                tmp.setDers(rs.getInt("ders"));
                
                
                dersprogramlist.add(tmp);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return dersprogramlist;
    }

    public void update(DersProgram dp) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("update dersprogram set gunler='" + dp.getGunler() +"', saatler='"+dp.getSaatler()+"', ders='"+dp.getDers()+"' where pid=" + dp.getPid());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
   
    public void delete(DersProgram dp) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("delete from dersprogram where pid=" +dp.getPid());
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

