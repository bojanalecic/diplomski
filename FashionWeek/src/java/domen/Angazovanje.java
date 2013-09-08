/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Lecic
 */
@Entity
@Table(name = "angazovanje")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Angazovanje.findAll", query = "SELECT a FROM Angazovanje a"),
    @NamedQuery(name = "Angazovanje.findById", query = "SELECT a FROM Angazovanje a WHERE a.id = :id"),
    @NamedQuery(name = "Angazovanje.findByIznos", query = "SELECT a FROM Angazovanje a WHERE a.iznos = :iznos")})
public class Angazovanje implements Serializable {
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
    @Column(name = "vidplacanja")
    private String vidplacanja;
    @Basic(optional = false)
    @NotNull
    @Column(name = "iznos")
    private int iznos;
    @JoinColumn(name = "model", referencedColumnName = "jmbg")
    @ManyToOne(optional = false)
    private Model model;
    @JoinColumn(name = "kreirao", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Korisnik kreirao;

    public Angazovanje() {
    }

    public Angazovanje(Integer id) {
        this.id = id;
    }

    public Angazovanje(Integer id, String vidplacanja, int iznos) {
        this.id = id;
        this.vidplacanja = vidplacanja;
        this.iznos = iznos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVidplacanja() {
        return vidplacanja;
    }

    public void setVidplacanja(String vidplacanja) {
        this.vidplacanja = vidplacanja;
    }

    public int getIznos() {
        return iznos;
    }

    public void setIznos(int iznos) {
        this.iznos = iznos;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public Korisnik getKreirao() {
        return kreirao;
    }

    public void setKreirao(Korisnik kreirao) {
        this.kreirao = kreirao;
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
        if (!(object instanceof Angazovanje)) {
            return false;
        }
        Angazovanje other = (Angazovanje) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domen.Angazovanje[ id=" + id + " ]";
    }
    
}
