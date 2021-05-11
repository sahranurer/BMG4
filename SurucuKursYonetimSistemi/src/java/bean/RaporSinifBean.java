package bean;

import dao.RaporSinifDao;
import entity.RaporSinif;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named(value = "RaporSinifBean")
@SessionScoped
public class RaporSinifBean implements Serializable {

    private RaporSinifDao raporsinifDao;
    private RaporSinif raporsinifentity;

    
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
        this.pageCount = (int) Math.ceil(this.getRaporSinifDao().count() / (double) pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
    
    public String create() {
        this.getRaporSinifDao().create(raporsinifentity);
        this.raporsinifentity = new RaporSinif();
        return "/raporsinif/list";
    }

    public List<RaporSinif> getRead() {
        return this.getRaporSinifDao().findAll(page, pageSize);

    }

    public String updatForm(RaporSinif ro) {
        this.raporsinifentity = ro;

        return "/raporsinif/update";
    }

    public String update() {
        this.getRaporSinifDao().update(raporsinifentity);
        this.raporsinifentity = new RaporSinif();
        return "/raporsinif/list";
    }

    public void delete(RaporSinif ro) {
        this.getRaporSinifDao().delete(ro);

    }

    public RaporSinifDao getRaporSinifDao() {
        if (raporsinifDao == null) {
            this.raporsinifDao = new RaporSinifDao();
        }
        return raporsinifDao;
    }

    public void setRaporSinifDao(RaporSinifDao raporsinifDao) {
        this.raporsinifDao = raporsinifDao;
    }

    public RaporSinif getRaporSinifentity() {
        if (raporsinifentity == null) {
            this.raporsinifentity = new RaporSinif();
        }
        return raporsinifentity;
    }

    public void setRaporSinifentity(RaporSinif raporsinifentity) {
        this.raporsinifentity = raporsinifentity;
    }

}



