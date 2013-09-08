/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mb;

import domen.Korisnik;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import kontroler.Kontroler;

/**
 *
 * @author BojLec
 */
@ManagedBean(name = "mbLoginBean")
@SessionScoped
public class LoginBean implements Serializable {
    
    private boolean ulogovan = false;
    private Korisnik korisnik;
    @ManagedProperty(value = "#{mbJezikBean}")
    private JezikBean jezik;
    
    public LoginBean() {        
        korisnik = new Korisnik();
    }

    public boolean isUlogovan() {
        return ulogovan;
    }

    public void setUlogovan(boolean ulogovan) {
        this.ulogovan = ulogovan;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

    public JezikBean getJezik() {
        return jezik;
    }

    public void setJezik(JezikBean jezik) {
        this.jezik = jezik;
    }
    public void login() {
        if (!ulogovan) {
            FacesMessage msg = null;
            try {
                Korisnik k = Kontroler.vratiObjekat().pronadjiKorisnika(korisnik);
                if (k != null) {
                    ulogovan= true;
                    k.setId(k.getId());
                    k.setIme(k.getIme());
                    k.setEmail(k.getEmail());
                    if (jezik.getLocale().getCountry().equals("RS")) {
                        msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Dobrodosli, " + k.getIme(), ".");
                    } else {
                        msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome, " + k.getIme(), ".");
                    }
                } else {
                    if (jezik.getLocale().getVariant().equals("Latin")) {
                        msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Uneli ste pogrešno korisničko ime ili lozinku!", null);
                    } else {
                        msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Incorrect username or password!", null);
                    }

                }
                FacesContext.getCurrentInstance().addMessage(null, msg);
            } catch (Exception ex) {
                if (jezik.getLocale().getCountry().equals("RS")) {
                    msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Greška prilikom logovanja", "");
                } else {
                    msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Error...", "");
                }

                FacesContext.getCurrentInstance().addMessage(null, msg);
            }

        }
    }

    public String izlogujSe() {
        korisnik = new Korisnik();
        ulogovan = false;
        return "index.xhtml?faces-redirect=true";
    }

    /**
     * Creates a new instance of LoginBean
     */
    
}
