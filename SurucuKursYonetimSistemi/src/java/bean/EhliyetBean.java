package bean;

import dao.EhliyetDao;
import entity.Ehliyet;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named(value = "EhliyetBean")
@SessionScoped
public class EhliyetBean  implements Serializable {

    private EhliyetDao ehliyetDao;
    private Ehliyet entity;

     private int page=1;
    private int pageSize=10;
    private int pageCount;

    public void next(){
        if (this.page == this.getPageCount()) {
            this.page = 1 ;
        }
        else
          this.page++;
    }
    public void previous(){
         if (this.page == 1) {
            this.page = this.getPageCount() ;
        }
         else
           this.page--;
    }
    
     public int getPageCount() {
        this.pageCount = (int) Math.ceil(this.getEhliyetDao().count() / (double) pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
    
    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
    
    public String create() {
        this.getEhliyetDao().create(entity);
        this.entity = new Ehliyet();
        return "/ehliyet/list";
    }

    public List<Ehliyet> getRead() {
       return this.getEhliyetDao().findAll(page, pageSize);
    }

    public String updatForm(Ehliyet e) {
        this.entity = e;
        return "/ehliyet/update";
    }

    public String update() {
        this.getEhliyetDao().update(entity);
         this.entity = new Ehliyet();
        return "/ehliyet/list";
    }

    public void delete(Ehliyet c) {
        this.getEhliyetDao().delete(c);

    }

    public EhliyetDao getEhliyetDao() {
        if (this.ehliyetDao == null) {
            this.ehliyetDao = new EhliyetDao();
        }
        return ehliyetDao;
    }

    public void setEhliyetDao(EhliyetDao ehliyetDao) {
        this.ehliyetDao = ehliyetDao;
    }

    public Ehliyet getEntity() {
         if (this.entity == null) {
            this.entity = new Ehliyet();
        }
      
        return entity;
    }

    public void setEntity(Ehliyet entity) {
        this.entity = entity;
    }


}

