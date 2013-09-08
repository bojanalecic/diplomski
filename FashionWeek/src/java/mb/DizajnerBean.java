/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mb;

import domen.Dizajner;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import kontroler.Kontroler;

/**
 *
 * @author Lecic
 */
@ManagedBean(name="mbDizajnerBean")
@ViewScoped
public class DizajnerBean {

    Dizajner dizajner;
    @ManagedProperty(value = "#{mbJezikBean}")
    private JezikBean jezik;
    Dizajner selektovaniDizajner;
    ArrayList<Dizajner> filtriraniDizajneri;

    public Dizajner getDizajner() {
        return dizajner;
    }

    public void setDizajner(Dizajner dizajner) {
        this.dizajner = dizajner;
    }

    public JezikBean getJezik() {
        return jezik;
    }

    public void setJezik(JezikBean jezik) {
        this.jezik = jezik;
    }

    public Dizajner getSelektovaniDizajner() {
        return selektovaniDizajner;
    }

    public void setSelektovaniDizajner(Dizajner selektovaniDizajner) {
        this.selektovaniDizajner = selektovaniDizajner;
    }

    public ArrayList<Dizajner> getFiltriraniDizajneri() {
        return filtriraniDizajneri;
    }

    public void setFiltriraniDizajneri(ArrayList<Dizajner> filtriraniDizajneri) {
        this.filtriraniDizajneri = filtriraniDizajneri;
    }
    
    
    public DizajnerBean() {
        dizajner = new Dizajner();
    }
    
    public ArrayList<Dizajner> vratiSveDizajnere(){
        Dizajner d = new Dizajner();
        d.setIme("Prvi");
        d.setPrezime("Prvic");
        d.setJmbg(1111111111);
        ArrayList<Dizajner> lista = new ArrayList<Dizajner>();
        lista.add(d);
        return lista;
    }
}
