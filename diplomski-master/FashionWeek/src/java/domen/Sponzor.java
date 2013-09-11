/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author BojLec
 */
@Entity
@Table(name = "sponzor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sponzor.findAll", query = "SELECT s FROM Sponzor s"),
    @NamedQuery(name = "Sponzor.findByPib", query = "SELECT s FROM Sponzor s WHERE s.pib = :pib"),
    @NamedQuery(name = "Sponzor.findByNaziv", query = "SELECT s FROM Sponzor s WHERE s.naziv = :naziv"),
    @NamedQuery(name = "Sponzor.findByAdresa", query = "SELECT s FROM Sponzor s WHERE s.adresa = :adresa"),
    @NamedQuery(name = "Sponzor.findByLogo", query = "SELECT s FROM Sponzor s WHERE s.logo = :logo")})
public class Sponzor implements Serializable, OpstiDomenskiObjekat {
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "sponzor")
    private Dizajner dizajner;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "pib")
    private String pib;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "naziv")
    private String naziv;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "adresa")
    private String adresa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "logo")
    private String logo;

    public Sponzor() {
    }

    public Sponzor(String pib) {
        this.pib = pib;
    }

    public Sponzor(String pib, String naziv, String adresa, String logo) {
        this.pib = pib;
        this.naziv = naziv;
        this.adresa = adresa;
        this.logo = logo;
    }

    public String getPib() {
        return pib;
    }

    public void setPib(String pib) {
        this.pib = pib;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pib != null ? pib.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sponzor)) {
            return false;
        }
        Sponzor other = (Sponzor) object;
        if ((this.pib == null && other.pib != null) || (this.pib != null && !this.pib.equals(other.pib))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domen.Sponzor[ pib=" + pib + " ]";
    }

    @Override
    public String vratiNazivKlase() {
        return "Sponzor";
    }

    @Override
    public String vratiSveAtribute() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiUpdateAtribute() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<OpstiDomenskiObjekat> vratiListuObjekata(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public OpstiDomenskiObjekat vratiJedanObjekat(long sifra, ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiKljuc() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiVrednostKljuca() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String sqlUpitVratiJedan() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String sqlUpitVratiSve() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String sqlUpitVratiSveSlozene() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String sqlUpitVratiJedanSlozeni() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiSpoljniKljuc() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiVrednostSpoljnogKljuca() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Dizajner getDizajner() {
        return dizajner;
    }

    public void setDizajner(Dizajner dizajner) {
        this.dizajner = dizajner;
    }
    
}
