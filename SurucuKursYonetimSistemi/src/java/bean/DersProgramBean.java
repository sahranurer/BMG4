package bean;

import dao.DersProgramDao;
import entity.DersProgram;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named(value = "DersProgramBean")
@SessionScoped
public class DersProgramBean implements Serializable {

    private DersProgramDao dersprogramDao;
    private DersProgram dersprogramentity;

    public String create() {
        this.getDersprogramDao().create(dersprogramentity);
        this.dersprogramentity = new DersProgram();
        return "/dersprogram/list";
    }

    public List<DersProgram> getRead() {
        return this.getDersprogramDao().findAll();

    }

    public String updatForm(DersProgram dp) {
        this.dersprogramentity = dp;

        return "/dersprogram/update";
    }

    public String update() {
        this.getDersprogramDao().update(dersprogramentity);
        this.dersprogramentity = new DersProgram();
        return "/dersprogram/list";
    }

    public void delete(DersProgram dp) {
        this.getDersprogramDao().delete(dp);

    }

    public DersProgramDao getDersprogramDao() {
        if (this.dersprogramDao == null) {
            this.dersprogramDao = new DersProgramDao();
        }
        return dersprogramDao;
    }

    public void setDersprogramDao(DersProgramDao dersprogramDao) {
        this.dersprogramDao = dersprogramDao;
    }

    public DersProgram getDersprogramentity() {
        if (this.dersprogramentity == null) {
            this.dersprogramentity = new DersProgram();
        }
        return dersprogramentity;
    }

    public void setDersprogramentity(DersProgram dersprogramentity) {
        this.dersprogramentity = dersprogramentity;
    }

}