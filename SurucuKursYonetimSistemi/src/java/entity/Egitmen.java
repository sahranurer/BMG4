
package entity;

public class Egitmen {
    
    private int id;
    private String ad;
    private String soyad;
    private String brans;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public String getBrans() {
        return brans;
    }

    public void setBrans(String brans) {
        this.brans = brans;
    }

    public Egitmen(int id, String ad, String soyad, String brans) {
        this.id = id;
        this.ad = ad;
        this.soyad = soyad;
        this.brans = brans;
    }

    public Egitmen() {
    }

    @Override
    public String toString() {
        return "Egitmen{" + "id=" + id + ", ad=" + ad + ", soyad=" + soyad + ", brans=" + brans + '}';
    }
    
    
    
}
