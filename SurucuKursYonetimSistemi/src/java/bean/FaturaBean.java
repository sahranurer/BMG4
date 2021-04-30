package bean;

import dao.FaturaDao;
import entity.Fatura;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named(value = "FaturaBean")
@SessionScoped
public class FaturaBean implements Serializable{
     private FaturaDao faturaDao;
    private Fatura entity;
    
    
     public String create() {
        this.getFaturaDao().create(entity);
        this.entity = new Fatura();
        return "/fatura/list";
    }

    public List<Fatura> getRead() {
       return this.getFaturaDao().findAll();
    }

    public String updatForm(Fatura e) {
        this.entity = e;
        return "/fatura/update";
    }

    public String update() {
        this.getFaturaDao().update(entity);
         this.entity = new Fatura();
        return "/fatura/list";
    }

    public void delete(Fatura c) {
        this.getFaturaDao().delete(c);

    }

    public FaturaDao getFaturaDao() {
        if (this.faturaDao == null) {
            this.faturaDao = new FaturaDao();
        }
        return faturaDao;
    }

    public void setFaturaDao(FaturaDao faturaDao) {
        this.faturaDao = faturaDao;
    }

    public Fatura getEntity() {
         if (this.entity == null) {
            this.entity = new Fatura();
        }
      
        return entity;
    }

    public void setEntity(Fatura entity) {
        this.entity = entity;
    }

}
