package bean;

import dao.DersBilgiDao;
import entity.DersBilgi;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named(value = "DersBilgiBean")
@SessionScoped
public class DersBilgiBean implements Serializable{
    private DersBilgiDao dersDao;
    private DersBilgi dersentity;
    /*
    public DersBilgi getById(int id){
        return this.getDersDao().getById(id);
    }
    */
    public String create() {
        this.getDersDao().create(dersentity);
        this.dersentity = new DersBilgi();
      
        return "/dersbilgi/list";
    }

    public List<DersBilgi> getRead() {
        return this.getDersDao().findAll();
    }

    public String updatForm(DersBilgi d) {
        this.dersentity = d;

        return "/dersbilgi/update";
    }

    public String update() {
        this.getDersDao().update(dersentity);
        this.dersentity = new DersBilgi();
        return "/dersbilgi/list";
    }

    public void delete(DersBilgi d) {
        this.getDersDao().delete(d);

    }
    

    public DersBilgiDao getDersDao() {
        if (this.dersDao == null) {
            this.dersDao = new DersBilgiDao();
        }
        return dersDao;
    }

    public void setDersDao(DersBilgiDao dersDao) {
        this.dersDao = dersDao;
    }

    public DersBilgi getDersentity() {
         if (this.dersentity == null) {
            this.dersentity = new DersBilgi();
        }
        return dersentity;
    }

    public void setDersentity(DersBilgi dersentity) {
        this.dersentity = dersentity;
    }
    
    
}
