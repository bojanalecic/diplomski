/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Lecic
 */
@Entity
@Table(name = "sponzor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sponzor.findAll", query = "SELECT s FROM Sponzor s"),
    @NamedQuery(name = "Sponzor.findById", query = "SELECT s FROM Sponzor s WHERE s.id = :id")})
public class Sponzor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "naziv")
    private String naziv;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "pib")
    private String pib;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "adresa")
    private String adresa;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "sponzor")
    private Dizajner dizajner;

    public Sponzor() {
    }

    public Sponzor(Integer id) {
        this.id = id;
    }

    public Sponzor(Integer id, String naziv, String pib, String adresa) {
        this.id = id;
        this.naziv = naziv;
        this.pib = pib;
        this.adresa = adresa;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getPib() {
        return pib;
    }

    public void setPib(String pib) {
        this.pib = pib;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public Dizajner getDizajner() {
        return dizajner;
    }

    public void setDizajner(Dizajner dizajner) {
        this.dizajner = dizajner;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sponzor)) {
            return false;
        }
        Sponzor other = (Sponzor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domen.Sponzor[ id=" + id + " ]";
    }
    
}
