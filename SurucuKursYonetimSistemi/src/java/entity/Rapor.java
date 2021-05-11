package entity;

public class Rapor {

    private int rap_id;
    private String radsoyad;
    private String ehliyet;
    private String performans;
    private String egitmenad;

    public int getRap_id() {
        return rap_id;
    }

    public void setRap_id(int rap_id) {
        this.rap_id = rap_id;
    }

    public String getRadsoyad() {
        return radsoyad;
    }

    public void setRadsoyad(String radsoyad) {
        this.radsoyad = radsoyad;
    }

    public String getEhliyet() {
        return ehliyet;
    }

    public void setEhliyet(String ehliyet) {
        this.ehliyet = ehliyet;
    }

    public String getPerformans() {
        return performans;
    }

    public void setPerformans(String performans) {
        this.performans = performans;
    }

    public String getEgitmenad() {
        return egitmenad;
    }

    public void setEgitmenad(String egitmenad) {
        this.egitmenad = egitmenad;
    }

    public Rapor(int rap_id, String radsoyad, String ehliyet, String performans, String egitmenad) {
        this.rap_id = rap_id;
        this.radsoyad = radsoyad;
        this.ehliyet = ehliyet;
        this.performans = performans;
        this.egitmenad = egitmenad;
    }

    public Rapor() {
    }

    @Override
    public String toString() {
        return "Rapor{" + "rap_id=" + rap_id + ", radsoyad=" + radsoyad + ", ehliyet=" + ehliyet + ", performans=" + performans + ", egitmenad=" + egitmenad + '}';
    }
    
    
    
    
    
    
    

}
