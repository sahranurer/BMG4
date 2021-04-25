package bean;

import dao.RandevuOlusturDao;
import entity.RandevuOlustur;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named(value = "RandevuOlusturBean")
@SessionScoped
public class RandevuOlusturBean implements Serializable {

    private RandevuOlusturDao randevuDao;
    private RandevuOlustur randevuentity;

    
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
        this.pageCount = (int) Math.ceil(this.getRandevuDao().count() / (double) pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
    
    public String create() {
        this.getRandevuDao().create(randevuentity);
        this.randevuentity = new RandevuOlustur();
        return "/randevuolustur/list";
    }

    public List<RandevuOlustur> getRead() {
        return this.getRandevuDao().findAll(page, pageSize);

    }

    public String updatForm(RandevuOlustur ro) {
        this.randevuentity = ro;

        return "/randevuolustur/update";
    }

    public String update() {
        this.getRandevuDao().update(randevuentity);
        this.randevuentity = new RandevuOlustur();
        return "/randevuolustur/list";
    }

    public void delete(RandevuOlustur ro) {
        this.getRandevuDao().delete(ro);

    }

    public RandevuOlusturDao getRandevuDao() {
        if (randevuDao == null) {
            this.randevuDao = new RandevuOlusturDao();
        }
        return randevuDao;
    }

    public void setRandevuDao(RandevuOlusturDao randevuDao) {
        this.randevuDao = randevuDao;
    }

    public RandevuOlustur getRandevuentity() {
        if (randevuentity == null) {
            this.randevuentity = new RandevuOlustur();
        }
        return randevuentity;
    }

    public void setRandevuentity(RandevuOlustur randevuentity) {
        this.randevuentity = randevuentity;
    }

}
