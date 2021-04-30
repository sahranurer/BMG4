package dao;

import entity.Fatura;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

public class FaturaDao {
    DBConnection db = new DBConnection();
    Connection c = db.connect();
    
     public void create(Fatura f) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("insert into fatura (adsoyad,il,ilce,vergino,aciklama,tutar) values ('" + f.getAdsoyad() + "'"
                    + ",'" + f.getIl() + "','" + f.getIlce() + "'"
                    + ",'" + f.getVergino() + "','" + f.getAciklama() + "','" + f.getTutar() + "')");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public List<Fatura> findAll() {
        List<Fatura> list = new ArrayList<>();
        try {
            Statement st = this.connect().createStatement();
            ResultSet rs = st.executeQuery("select * from fatura order by fid asc");
            while (rs.next()) {
                Fatura tmp = new Fatura(rs.getInt("fid"), rs.getString("adsoyad"), rs.getString("il"), rs.getString("ilce"),rs.getInt("vergino"), rs.getString("aciklama"), rs.getString("tutar"));
                list.add(tmp);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }

    public void update(Fatura e) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("update fatura set adsoyad='" + e.getAdsoyad() +"', il='"+e.getIl()+"', ilce='"+e.getIlce()+"', vergino='"+e.getVergino()+"'"
                    + ", aciklama='"+e.getAciklama()+"',tutar='"+e.getTutar()+"' where fid+" + e.getFid());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void delete(Fatura e) {
        try {
            Statement st = this.connect().createStatement();
            st.executeUpdate("delete from fatura where fid=" + e.getFid());
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
