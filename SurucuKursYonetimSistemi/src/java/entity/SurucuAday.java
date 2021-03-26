package entity;

public class SurucuAday {
    private int id;
    private String ad;
    private String soyad;
    private int yas;
    private String egitim_durumu;
    private String adres;
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

    public int getYas() {
        return yas;
    }

    public void setYas(int yas) {
        this.yas = yas;
    }

    public String getEgitim_durumu() {
        return egitim_durumu;
    }

    public void setEgitim_durumu(String egitim_durumu) {
        this.egitim_durumu = egitim_durumu;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    @Override
    public String toString() {
        return "SurucuAday{" + "id=" + id + ", ad=" + ad + ", soyad=" + soyad + ", yas=" + yas + ", egitim_durumu=" + egitim_durumu + ", adres=" + adres + '}';
    }

   
    
    
}
