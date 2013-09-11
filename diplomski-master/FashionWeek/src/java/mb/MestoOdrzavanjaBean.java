/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mb;

import domen.Mestoodrzavanja;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import kontroler.Kontroler;

/**
 *
 * @author BojLec
 */
@ManagedBean(name="mbMestoOdrzavanjaBean")
@ViewScoped
public class MestoOdrzavanjaBean {
    Mestoodrzavanja mestoOdrzavanja;
    Mestoodrzavanja selektovanoMesto;
    ArrayList<Mestoodrzavanja> filtriranaMesta;
@ManagedProperty(value="#{mbJezikBean}")
private JezikBean jezik;
    /**
     * Creates a new instance of MestoOdrzavanjaBean
     */
    public MestoOdrzavanjaBean() {
        mestoOdrzavanja = new Mestoodrzavanja();
        selektovanoMesto = new Mestoodrzavanja();
    }

    public JezikBean getJezik() {
        return jezik;
    }

    public void setJezik(JezikBean jezik) {
        this.jezik = jezik;
    }
    
     public Mestoodrzavanja getMestoOdrzavanja() {
        return mestoOdrzavanja;
    }

    public void setMestoOdrzavanja(Mestoodrzavanja mestoOdrzavanja) {
        this.mestoOdrzavanja = mestoOdrzavanja;
    }

    public Mestoodrzavanja getSelektovanoMesto() {
        return selektovanoMesto;
    }

    public void setSelektovanoMesto(Mestoodrzavanja selektovanoMesto) {
        this.selektovanoMesto = selektovanoMesto;
    }

    public ArrayList<Mestoodrzavanja> getFiltriranaMesta() {
        return filtriranaMesta;
    }

    public void setFiltriranaMesta(ArrayList<Mestoodrzavanja> filtriranaMesta) {
        this.filtriranaMesta = filtriranaMesta;
    }
    
    public ArrayList<Mestoodrzavanja> vratiSvaMesta(){
        return Kontroler.vratiObjekat().vratiSvaMesta();
    }
    public void obrisiMesto(){
        if (selektovanoMesto != null) {
            try {
                Kontroler.vratiObjekat().obrisiMesto(selektovanoMesto);
                filtriranaMesta = null;
                selektovanoMesto = new Mestoodrzavanja();
                if (jezik.getLocale().getCountry().equals("RS")) {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Mesto je uspesno obrisano", ""));
                } else {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Place successfully deleted", ""));
                }
            } catch (Exception e) {
                if (jezik.getLocale().getCountry().equals("GB")) {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Brisanje mesta neuspesno", ""));
                } else {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Operation unsuccessful", ""));
                }
            }
        } else {
            if (jezik.getLocale().getCountry().equals("RS")) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Niste selektovali mesto", ""));
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "No selected place", ""));
            }
        }
    }
}
