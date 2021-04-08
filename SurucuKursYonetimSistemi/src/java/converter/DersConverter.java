package converter;

import dao.DersBilgiDao;
import entity.DersBilgi;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value="dersConverter")
public class DersConverter implements Converter{

    private DersBilgiDao dersbilgiDao;
    
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uıc, String string) {
        //nesneye dönüştüren
        
        return this.getDersbilgiDao().getById(Integer.valueOf(string));
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uıc, Object o) {
      DersBilgi d = (DersBilgi)o;
      
      return d.getDers_ad();      
    }

    public DersBilgiDao getDersbilgiDao() {
        if (dersbilgiDao == null) {
            this.dersbilgiDao = new DersBilgiDao();
        }
        return dersbilgiDao;
    }

    public void setDersbilgiDao(DersBilgiDao dersbilgiDao) {
        this.dersbilgiDao = dersbilgiDao;
    }
    
}
