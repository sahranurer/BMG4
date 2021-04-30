package entity;

public class Fatura {
    private int fid;
    private String adsoyad;
    private String il;
    private String ilce;
    private int vergino;
    private String aciklama;
    private String tutar; 

    public Fatura(int fid, String adsoyad, String il, String ilce, int vergino, String aciklama, String tutar) {
        this.fid = fid;
        this.adsoyad = adsoyad;
        this.il = il;
        this.ilce = ilce;
        this.vergino = vergino;
        this.aciklama = aciklama;
        this.tutar = tutar;
    }

    public Fatura() {
    }

    
    
    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    public String getAdsoyad() {
        return adsoyad;
    }

    public void setAdsoyad(String adsoyad) {
        this.adsoyad = adsoyad;
    }

    public String getIl() {
        return il;
    }

    public void setIl(String il) {
        this.il = il;
    }

    public String getIlce() {
        return ilce;
    }

    public void setIlce(String ilce) {
        this.ilce = ilce;
    }

    public int getVergino() {
        return vergino;
    }

    public void setVergino(int vergino) {
        this.vergino = vergino;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }

    public String getTutar() {
        return tutar;
    }

    public void setTutar(String tutar) {
        this.tutar = tutar;
    }

    @Override
    public String toString() {
        return "Fatura{" + "fid=" + fid + ", adsoyad=" + adsoyad + ", il=" + il + ", ilce=" + ilce + ", vergino=" + vergino + ", aciklama=" + aciklama + ", tutar=" + tutar + '}';
    }
    
    
    
    
}
