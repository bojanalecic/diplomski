/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mb;

import domen.Sponzor;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import kontroler.Kontroler;

/**
 *
 * @author BojLec
 */
@ManagedBean(name = "mbSponzorBean")
@ViewScoped
public class SponzorBean {
    
    private Sponzor sponzor;
    @ManagedProperty(value = "#{mbJezikBean}")
    private JezikBean jezik;
    private Sponzor trenutniSponzor;
    private ArrayList<Sponzor> filtriraniSponzori;

    public Sponzor getSponzor() {
        return sponzor;
    }

    public void setSponzor(Sponzor sponzor) {
        this.sponzor = sponzor;
    }

    public JezikBean getJezik() {
        return jezik;
    }

    public void setJezik(JezikBean jezik) {
        this.jezik = jezik;
    }

    public Sponzor getTrenutniSponzor() {
        return trenutniSponzor;
    }

    public void setTrenutniSponzor(Sponzor trenutniSponzor) {
        this.trenutniSponzor = trenutniSponzor;
    }

    public ArrayList<Sponzor> getFiltriraniSponzori() {
        return filtriraniSponzori;
    }

    public void setFiltriraniSponzori(ArrayList<Sponzor> filtriraniSponzori) {
        this.filtriraniSponzori = filtriraniSponzori;
    }

    public SponzorBean() {
        this.sponzor = new Sponzor();
        this.trenutniSponzor = new Sponzor();
    }
    
    public ArrayList<Sponzor> vratiSveSponzore(){
        return Kontroler.vratiObjekat().vratiSveSponzore();
//        Sponzor s = new Sponzor();
//        s.setId(23);
//        s.setNaziv("Emric");
//        s.setPib("1234556");
//        s.setAdresa("Cirila i Metodija 8");
//        s.setLogo("emric.jpg");
//        ArrayList<Sponzor> lista = new ArrayList<Sponzor>();
//        lista.add(s);
//        return lista;
    }
}
