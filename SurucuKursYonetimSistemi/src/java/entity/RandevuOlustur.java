package entity;

public class RandevuOlustur {
    private int rid;
    private String aday_adsoyad;
    private String egitmen_adsoyad;
    private String gun;
    private String saat;

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public String getAday_adsoyad() {
        return aday_adsoyad;
    }

    public void setAday_adsoyad(String aday_adsoyad) {
        this.aday_adsoyad = aday_adsoyad;
    }

    public String getEgitmen_adsoyad() {
        return egitmen_adsoyad;
    }

    public void setEgitmen_adsoyad(String egitmen_adsoyad) {
        this.egitmen_adsoyad = egitmen_adsoyad;
    }

    public String getGun() {
        return gun;
    }

    public void setGun(String gun) {
        this.gun = gun;
    }

    public String getSaat() {
        return saat;
    }

    public void setSaat(String saat) {
        this.saat = saat;
    }

    public RandevuOlustur(int rid, String aday_adsoyad, String egitmen_adsoyad, String gun, String saat) {
        this.rid = rid;
        this.aday_adsoyad = aday_adsoyad;
        this.egitmen_adsoyad = egitmen_adsoyad;
        this.gun = gun;
        this.saat = saat;
    }

    public RandevuOlustur() {
    }

    @Override
    public String toString() {
        return "RandevuOlustur{" + "rid=" + rid + ", aday_adsoyad=" + aday_adsoyad + ", egitmen_adsoyad=" + egitmen_adsoyad + ", gun=" + gun + ", saat=" + saat + '}';
    }
    
}
