package entity;

public class Ehliyet {
    private int eh_id;
    private String sinif;
    private String kullanma_yetkisi;
    private String egitmen_alan;
     private String surucu_aday;

    public Ehliyet(int eh_id, String sinif, String kullanma_yetkisi, String egitmen_alan,String surucu_aday) {
        this.eh_id = eh_id;
        this.sinif = sinif;
        this.kullanma_yetkisi = kullanma_yetkisi;
        this.egitmen_alan = egitmen_alan;
        this.surucu_aday = surucu_aday;
    }

    public String getSurucu_aday() {
        return surucu_aday;
    }

    public void setSurucu_aday(String surucu_aday) {
        this.surucu_aday = surucu_aday;
    }

    

    public Ehliyet() {
    }

    public int getEh_id() {
        return eh_id;
    }

    public void setEh_id(int eh_id) {
        this.eh_id = eh_id;
    }

    public String getSinif() {
        return sinif;
    }

    public void setSinif(String sinif) {
        this.sinif = sinif;
    }

    public String getKullanma_yetkisi() {
        return kullanma_yetkisi;
    }

    public void setKullanma_yetkisi(String kullanma_yetkisi) {
        this.kullanma_yetkisi = kullanma_yetkisi;
    }

    public String getEgitmen_alan() {
        return egitmen_alan;
    }

    public void setEgitmen_alan(String egitmen_alan) {
        this.egitmen_alan = egitmen_alan;
    }

    @Override
    public String toString() {
        return "Ehliyet{" + "eh_id=" + eh_id + ", sinif=" + sinif + ", kullanma_yetkisi=" + kullanma_yetkisi + ", egitmen_alan=" + egitmen_alan + ", surucu_aday=" + surucu_aday + '}';
    }

   

   
    
}
