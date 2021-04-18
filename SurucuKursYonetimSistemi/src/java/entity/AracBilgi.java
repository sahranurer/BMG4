package entity;

public class AracBilgi {
    private int id;
    private String plaka;
    private String arac_tur;
    private int uretim_yil;
    private String sigorta_durum;

    public AracBilgi() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlaka() {
        return plaka;
    }

    public void setPlaka(String plaka) {
        this.plaka = plaka;
    }

    public String getArac_tur() {
        return arac_tur;
    }

    public void setArac_tur(String arac_tur) {
        this.arac_tur = arac_tur;
    }

    public int getUretim_yil() {
        return uretim_yil;
    }

    public void setUretim_yil(int uretim_yil) {
        this.uretim_yil = uretim_yil;
    }

    public String getSigorta_durum() {
        return sigorta_durum;
    }

    public void setSigorta_durum(String sigorta_durum) {
        this.sigorta_durum = sigorta_durum;
    }

    public AracBilgi(int id, String plaka, String arac_tur, int uretim_yil, String sigorta_durum) {
        this.id = id;
        this.plaka = plaka;
        this.arac_tur = arac_tur;
        this.uretim_yil = uretim_yil;
        this.sigorta_durum = sigorta_durum;
    }

    @Override
    public String toString() {
        return "AracBilgi{" + "id=" + id + ", plaka=" + plaka + ", arac_tur=" + arac_tur + ", uretim_yil=" + uretim_yil + ", sigorta_durum=" + sigorta_durum + '}';
    }

   
    
    
    
}
