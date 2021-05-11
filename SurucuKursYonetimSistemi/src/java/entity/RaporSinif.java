
package entity;

public class RaporSinif {
    private int s_id;
    private String sinif_ad;
    private String performans;

    public RaporSinif(int s_id, String sinif_ad, String performans) {
        this.s_id = s_id;
        this.sinif_ad = sinif_ad;
        this.performans = performans;
    }

    public int getS_id() {
        return s_id;
    }

    public void setS_id(int s_id) {
        this.s_id = s_id;
    }

    public String getSinif_ad() {
        return sinif_ad;
    }

    public void setSinif_ad(String sinif_ad) {
        this.sinif_ad = sinif_ad;
    }

    public String getPerformans() {
        return performans;
    }

    public void setPerformans(String performans) {
        this.performans = performans;
    }

    public RaporSinif() {
    }

    @Override
    public String toString() {
        return "RaporSinif{" + "s_id=" + s_id + ", sinif_ad=" + sinif_ad + ", performans=" + performans + '}';
    }
    
    
    
}
