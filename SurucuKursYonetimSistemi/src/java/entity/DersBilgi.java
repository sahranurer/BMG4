package entity;

public class DersBilgi {
    private int id;
    private String ders_ad;
    private String ders_tur;
    private String ders_kont;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDers_ad() {
        return ders_ad;
    }

    public void setDers_ad(String ders_ad) {
        this.ders_ad = ders_ad;
    }

    public String getDers_tur() {
        return ders_tur;
    }

    public void setDers_tur(String ders_tur) {
        this.ders_tur = ders_tur;
    }

    public String getDers_kont() {
        return ders_kont;
    }

    public void setDers_kont(String ders_kont) {
        this.ders_kont = ders_kont;
    }

    @Override
    public String toString() {
        return "DersBilgi{" + "id=" + id + ", ders_ad=" + ders_ad + ", ders_tur=" + ders_tur + ", ders_kont=" + ders_kont + '}';
    }

    public DersBilgi(int id, String ders_ad, String ders_tur, String ders_kont) {
        this.id = id;
        this.ders_ad = ders_ad;
        this.ders_tur = ders_tur;
        this.ders_kont = ders_kont;
    }

    public DersBilgi() {
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DersBilgi other = (DersBilgi) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    
    
    
    
}
