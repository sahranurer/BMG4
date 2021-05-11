package bean;

import dao.RaporDao;
import entity.Rapor;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named(value = "RaporBean")
@SessionScoped
public class RaporBean implements Serializable {

    private RaporDao raporDao;
    private Rapor raporentity;

    
    private int page=1;
    private int pageSize=7;
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

    public int getPageCount() {
        this.pageCount = (int) Math.ceil(this.getRaporDao().count() / (double) pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
    
    public String create() {
        this.getRaporDao().create(raporentity);
        this.raporentity = new Rapor();
        return "/rapor/list";
    }

    public List<Rapor> getRead() {
        return this.getRaporDao().findAll(page, pageSize);

    }

    public String updatForm(Rapor ro) {
        this.raporentity = ro;

        return "/rapor/update";
    }

    public String update() {
        this.getRaporDao().update(raporentity);
        this.raporentity = new Rapor();
        return "/rapor/list";
    }

    public void delete(Rapor ro) {
        this.getRaporDao().delete(ro);

    }

    public RaporDao getRaporDao() {
        if (raporDao == null) {
            this.raporDao = new RaporDao();
        }
        return raporDao;
    }

    public void setRaporDao(RaporDao raporDao) {
        this.raporDao = raporDao;
    }

    public Rapor getRaporentity() {
        if (raporentity == null) {
            this.raporentity = new Rapor();
        }
        return raporentity;
    }

    public void setRaporentity(Rapor raporentity) {
        this.raporentity = raporentity;
    }

}

