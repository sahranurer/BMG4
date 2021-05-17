
package util;

import entity.Kullanici;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;


@ManagedBean
@SessionScoped
public class LoginController implements Serializable {
    private Kullanici user;

    public String login() {
        if (this.user.getUsername().equals("kullanici")&& this.user.getPassword().equals("123")){
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("valid_user", this.user);
            return "/secret/secret?faces-redirect=true";
        }else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Hatalı kullanıcı adı veya şifre"));
        return "/login";
    }
    } 
    public Kullanici getKullanici() {
        if (this.user == null )
            this.user = new Kullanici();
        return user;
    }

    public void setKullanici(Kullanici user) {
        this.user = user;
    }
    
    
    
    
}
