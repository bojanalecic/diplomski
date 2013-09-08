/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mb;

import domen.Dizajner;
import domen.Mestoodrzavanja;
import domen.Revija;
import java.util.ArrayList;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import kontroler.Kontroler;

/**
 *
 * @author Lecic
 */
@ManagedBean(name = "mbRevijaBean")
@ViewScoped
public class RevijaBean {

    @ManagedProperty(value = "#{mbJezikBean}")
    private JezikBean jezik;
    private Revija revija;
    private Revija selektovanaRevija;
    private ArrayList<Revija> filtriraneRevije;
    
    public RevijaBean() {
        revija = new Revija();
        selektovanaRevija = new Revija();
    }

    public JezikBean getJezik() {
        return jezik;
    }

    public void setJezik(JezikBean jezik) {
        this.jezik = jezik;
    }

    public Revija getRevija() {
        return revija;
    }

    public void setRevija(Revija revija) {
        this.revija = revija;
    }

    public Revija getSelektovanaRevija() {
        return selektovanaRevija;
    }

    public void setSelektovanaRevija(Revija selektovanaRevija) {
        this.selektovanaRevija = selektovanaRevija;
    }

    public ArrayList<Revija> getFiltriraneRevije() {
        return filtriraneRevije;
    }

    public void setFiltriraneRevije(ArrayList<Revija> filtriraneRevije) {
        this.filtriraneRevije = filtriraneRevije;
    }
    
    public ArrayList<Revija> vratiSveRevije(){
      //  return Kontroler.vratiObjekat().vratiSveRevije();
        Revija r = new Revija();
        r.setDatum(new Date());
        r.setDizajner(new Dizajner(123456));
        r.setMesto(new Mestoodrzavanja(23));
        
        ArrayList<Revija> lista = new ArrayList<Revija>();
        lista.add(r);
        return lista;
    }
}
