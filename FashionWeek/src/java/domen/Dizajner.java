/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Lecic
 */
@Entity
@Table(name = "dizajner")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dizajner.findAll", query = "SELECT d FROM Dizajner d"),
    @NamedQuery(name = "Dizajner.findByJmbg", query = "SELECT d FROM Dizajner d WHERE d.jmbg = :jmbg")})
public class Dizajner implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "jmbg")
    private Integer jmbg;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "ime")
    private String ime;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "prezime")
    private String prezime;
    @JoinColumn(name = "sponzor", referencedColumnName = "id")
    @OneToOne(optional = false)
    private Sponzor sponzor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dizajner")
    private List<Revija> revijaList;

    public Dizajner() {
    }

    public Dizajner(Integer jmbg) {
        this.jmbg = jmbg;
    }

    public Dizajner(Integer jmbg, String ime, String prezime) {
        this.jmbg = jmbg;
        this.ime = ime;
        this.prezime = prezime;
    }

    public Integer getJmbg() {
        return jmbg;
    }

    public void setJmbg(Integer jmbg) {
        this.jmbg = jmbg;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public Sponzor getSponzor() {
        return sponzor;
    }

    public void setSponzor(Sponzor sponzor) {
        this.sponzor = sponzor;
    }

    @XmlTransient
    public List<Revija> getRevijaList() {
        return revijaList;
    }

    public void setRevijaList(List<Revija> revijaList) {
        this.revijaList = revijaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (jmbg != null ? jmbg.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dizajner)) {
            return false;
        }
        Dizajner other = (Dizajner) object;
        if ((this.jmbg == null && other.jmbg != null) || (this.jmbg != null && !this.jmbg.equals(other.jmbg))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domen.Dizajner[ jmbg=" + jmbg + " ]";
    }
    
}
