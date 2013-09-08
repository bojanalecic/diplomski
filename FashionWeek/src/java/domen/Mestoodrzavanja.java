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
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "mestoodrzavanja")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mestoodrzavanja.findAll", query = "SELECT m FROM Mestoodrzavanja m"),
    @NamedQuery(name = "Mestoodrzavanja.findById", query = "SELECT m FROM Mestoodrzavanja m WHERE m.id = :id")})
public class Mestoodrzavanja implements Serializable {
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
    @Column(name = "adresa")
    private String adresa;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mesto")
    private List<Revija> revijaList;

    public Mestoodrzavanja() {
    }

    public Mestoodrzavanja(Integer id) {
        this.id = id;
    }

    public Mestoodrzavanja(Integer id, String naziv, String adresa) {
        this.id = id;
        this.naziv = naziv;
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

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mestoodrzavanja)) {
            return false;
        }
        Mestoodrzavanja other = (Mestoodrzavanja) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domen.Mestoodrzavanja[ id=" + id + " ]";
    }
    
}
