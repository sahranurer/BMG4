package bean;

import dao.RaporEgitmenDao;
import entity.RaporEgitmen;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named(value = "RaporEgitmenBean")
@SessionScoped
public class RaporEgitmenBean implements Serializable {

    private RaporEgitmenDao raporegitmenDao;
    private RaporEgitmen raporegitmenentity;

    
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
        this.pageCount = (int) Math.ceil(this.getRaporEgitmenDao().count() / (double) pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
    
    public String create() {
        this.getRaporEgitmenDao().create(raporegitmenentity);
        this.raporegitmenentity = new RaporEgitmen();
        return "/raporegitmen/list";
    }

    public List<RaporEgitmen> getRead() {
        return this.getRaporEgitmenDao().findAll(page, pageSize);

    }

    public String updatForm(RaporEgitmen ro) {
        this.raporegitmenentity = ro;

        return "/raporegitmen/update";
    }

    public String update() {
        this.getRaporEgitmenDao().update(raporegitmenentity);
        this.raporegitmenentity = new RaporEgitmen();
        return "/raporegitmen/list";
    }

    public void delete(RaporEgitmen ro) {
        this.getRaporEgitmenDao().delete(ro);

    }

    public RaporEgitmenDao getRaporEgitmenDao() {
        if (raporegitmenDao == null) {
            this.raporegitmenDao = new RaporEgitmenDao();
        }
        return raporegitmenDao;
    }

    public void setRaporEgitmenDao(RaporEgitmenDao raporegitmenDao) {
        this.raporegitmenDao = raporegitmenDao;
    }

    public RaporEgitmen getRaporEgitmenentity() {
        if (raporegitmenentity == null) {
            this.raporegitmenentity = new RaporEgitmen();
        }
        return raporegitmenentity;
    }

    public void setRaporEgitmenentity(RaporEgitmen raporegitmenentity) {
        this.raporegitmenentity = raporegitmenentity;
    }

}


