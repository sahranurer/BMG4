package converter;

import dao.EgitmenDao;
import dao.RandevuOlusturDao;
import entity.RandevuOlustur;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value="egitmenConverter")
public class EgitmenConverter implements Converter{

    private EgitmenDao egitimDao;
    
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uıc, String string) {
         //nesneye dönüştüren
        return this.getEgitimDao().find(Long.valueOf(string));
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uıc, Object o) {
         RandevuOlustur r = (RandevuOlustur)o;
      
      return r.getEgitmen_adsoyad();   
    }

    public EgitmenDao getEgitimDao() {
         if(this.egitimDao==null)
            this.egitimDao = new EgitmenDao();
        return egitimDao;
    }

    public void setEgitimDao(EgitmenDao egitimDao) {
        this.egitimDao = egitimDao;
    }

    
    
    
}
