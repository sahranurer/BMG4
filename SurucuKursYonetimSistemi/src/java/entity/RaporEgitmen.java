package entity;

public class RaporEgitmen {
    private int perf_id;
    private String adsoyad;
    private String performans;

    public int getPerf_id() {
        return perf_id;
    }

    public void setPerf_id(int perf_id) {
        this.perf_id = perf_id;
    }

    public String getAdsoyad() {
        return adsoyad;
    }

    public void setAdsoyad(String adsoyad) {
        this.adsoyad = adsoyad;
    }

    public String getPerformans() {
        return performans;
    }

    public void setPerformans(String performans) {
        this.performans = performans;
    }

    public RaporEgitmen(int perf_id, String adsoyad, String performans) {
        this.perf_id = perf_id;
        this.adsoyad = adsoyad;
        this.performans = performans;
    }

    public RaporEgitmen() {
    }

    @Override
    public String toString() {
        return "RaporEgitmen{" + "perf_id=" + perf_id + ", adsoyad=" + adsoyad + ", performans=" + performans + '}';
    }
    
    
    
    
}
