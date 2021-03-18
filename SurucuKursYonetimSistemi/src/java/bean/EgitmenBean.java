package bean;

import dao.EgitmenDao;
import entity.Egitmen;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;

import javax.inject.Named;



@Named(value = "EgitmenBean")
@SessionScoped
public class EgitmenBean implements Serializable {

    private EgitmenDao egitmenDao;
    private Egitmen entity;

    public String create() {
        this.getEgitmenDao().create(entity);
        this.entity = new Egitmen();
        return "/egitmen/list";
    }

    public List<Egitmen> getRead() {
       return this.getEgitmenDao().findAll();
    }

    public String updatForm(Egitmen e) {
        this.entity = e;
        return "/egitmen/update";
    }

    public String update() {
        this.getEgitmenDao().update(entity);
         this.entity = new Egitmen();
        return "/egitmen/list";
    }

    public void delete(Egitmen c) {
        this.getEgitmenDao().delete(c);

    }

    public EgitmenDao getEgitmenDao() {
        if (this.egitmenDao == null) {
            this.egitmenDao = new EgitmenDao();
        }
        return egitmenDao;
    }

    public void setEgitmenDao(EgitmenDao egitmenDao) {
        this.egitmenDao = egitmenDao;
    }

    public Egitmen getEntity() {
         if (this.entity == null) {
            this.entity = new Egitmen();
        }
      
        return entity;
    }

    public void setEntity(Egitmen entity) {
        this.entity = entity;
    }


}
