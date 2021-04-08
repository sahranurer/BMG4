package entity;

/**
 *
 * @author lenovo
 */
public class DersProgram {
    private int pid;
    private String gunler;
    private String saatler;
    private int ders;

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

   

    public String getGunler() {
        return gunler;
    }

    public void setGunler(String gunler) {
        this.gunler = gunler;
    }

    public String getSaatler() {
        return saatler;
    }

    public void setSaatler(String saatler) {
        this.saatler = saatler;
    }

    public int getDers() {
        return ders;
    }

    public void setDers(int ders) {
        this.ders = ders;
    }

    public DersProgram(int pid, String gunler, String saatler, int ders) {
        this.pid = pid;
        this.gunler = gunler;
        this.saatler = saatler;
        this.ders = ders;
    }

  

    public DersProgram() {
    }

    @Override
    public String toString() {
        return "DersProgram{" + "pid=" + pid + ", gunler=" + gunler + ", saatler=" + saatler + ", ders=" + ders + '}';
    }

   

   
   

}
