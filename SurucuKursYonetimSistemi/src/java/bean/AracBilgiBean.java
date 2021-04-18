package bean;

import dao.AracBilgiDao;
import entity.AracBilgi;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named(value = "AracBilgiBean")
@SessionScoped
public class AracBilgiBean implements Serializable{
    private AracBilgiDao aracbilgiDao;
    private AracBilgi aracentity;

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
        this.pageCount = (int) Math.ceil(this.getAracbilgiDao().count() / (double) pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
    
    
    public String create() {
        this.getAracbilgiDao().create(aracentity);
        this.aracentity = new AracBilgi();
       
        return "/aracbilgi/list";
    }

    public List<AracBilgi> getRead() {
        return this.getAracbilgiDao().findAll(page,pageSize);

    }

    public String updatForm(AracBilgi a) {
        this.aracentity = a;

        return "/aracbilgi/update";
    }

    public String update() {
        this.getAracbilgiDao().update(aracentity);
        this.aracentity = new AracBilgi();
        return "/aracbilgi/list";
    }
    
    public void delete(AracBilgi a){
        this.getAracbilgiDao().delete(a);
    }
    
    public AracBilgiDao getAracbilgiDao() {
         if (this.aracbilgiDao == null) {
            this.aracbilgiDao = new AracBilgiDao();
        }
        return aracbilgiDao;
    }

    public void setAracbilgiDao(AracBilgiDao aracbilgiDao) {
        this.aracbilgiDao = aracbilgiDao;
    }

    public AracBilgi getAracentity() {
         if (this.aracentity == null) {
            this.aracentity = new AracBilgi();
        }
        return aracentity;
    }

    public void setAracentity(AracBilgi aracentity) {
        this.aracentity = aracentity;
    }
    
    
    
    
}
