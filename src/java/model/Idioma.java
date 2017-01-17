/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author andres
 */
@Entity
@Table(name = "idioma")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Idioma.findAll", query = "SELECT i FROM Idioma i"),
    @NamedQuery(name = "Idioma.findByCodigoidioma", query = "SELECT i FROM Idioma i WHERE i.codigoidioma = :codigoidioma"),
    @NamedQuery(name = "Idioma.findByNombreidioma", query = "SELECT i FROM Idioma i WHERE i.nombreidioma = :nombreidioma")})
public class Idioma implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigoidioma")
    private Integer codigoidioma;
    @Size(max = 50)
    @Column(name = "nombreidioma")
    private String nombreidioma;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idioma")
    private List<Hablaidioma> hablaidiomaList;

    public Idioma() {
    }

    public Idioma(Integer codigoidioma) {
        this.codigoidioma = codigoidioma;
    }

    public Integer getCodigoidioma() {
        return codigoidioma;
    }

    public void setCodigoidioma(Integer codigoidioma) {
        this.codigoidioma = codigoidioma;
    }

    public String getNombreidioma() {
        return nombreidioma;
    }

    public void setNombreidioma(String nombreidioma) {
        this.nombreidioma = nombreidioma;
    }

    @XmlTransient
    public List<Hablaidioma> getHablaidiomaList() {
        return hablaidiomaList;
    }

    public void setHablaidiomaList(List<Hablaidioma> hablaidiomaList) {
        this.hablaidiomaList = hablaidiomaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoidioma != null ? codigoidioma.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Idioma)) {
            return false;
        }
        Idioma other = (Idioma) object;
        if ((this.codigoidioma == null && other.codigoidioma != null) || (this.codigoidioma != null && !this.codigoidioma.equals(other.codigoidioma))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Idioma[ codigoidioma=" + codigoidioma + " ]";
    }
    
}
