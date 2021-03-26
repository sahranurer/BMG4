package bean;

import dao.SurucuAdayDao;
import entity.SurucuAday;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named(value = "SurucuAdayBean")
@SessionScoped
public class SurucuAdayBean implements Serializable{
    private SurucuAdayDao adayDao;
    private SurucuAday adayentity;
    
     public String create() {
        this.getAdayDao().create(adayentity);
        this.adayentity = new SurucuAday();
        return "/surucuaday/list";
    }

    public List<SurucuAday> getRead() {
        return this.getAdayDao().findAll();
    }

    public String updatForm(SurucuAday s) {
        this.adayentity = s;
        return "/surucuaday/update";
    }

    public String update() {
        this.getAdayDao().update(adayentity);
         this.adayentity = new SurucuAday();
        return "/surucuaday/list";
    }

    public void delete(SurucuAday s) {
        this.getAdayDao().delete(s);

    }

    public SurucuAdayDao getAdayDao() {
         if (this.adayDao == null) {
            this.adayDao = new SurucuAdayDao();
        }
        return adayDao;
    }

    public void setAdayDao(SurucuAdayDao adayDao) {
        this.adayDao = adayDao;
    }

    public SurucuAday getAdayentity() {
         if (this.adayentity == null) {
            this.adayentity = new SurucuAday();
        }
        return adayentity;
    }

    public void setAdayentity(SurucuAday adayentity) {
        this.adayentity = adayentity;
    }



}
