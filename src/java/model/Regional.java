/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
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
@Table(name = "regional")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Regional.findAll", query = "SELECT r FROM Regional r"),
    @NamedQuery(name = "Regional.findByCodigoregional", query = "SELECT r FROM Regional r WHERE r.codigoregional = :codigoregional"),
    @NamedQuery(name = "Regional.findByNombreregional", query = "SELECT r FROM Regional r WHERE r.nombreregional = :nombreregional")})
public class Regional implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigoregional")
    private Integer codigoregional;
    @Size(max = 50)
    @Column(name = "nombreregional")
    private String nombreregional;
    @OneToMany(mappedBy = "codigoregionalcentro")
    private List<Centro> centroList;

    public Regional() {
    }

    public Regional(Integer codigoregional) {
        this.codigoregional = codigoregional;
    }

    public Integer getCodigoregional() {
        return codigoregional;
    }

    public void setCodigoregional(Integer codigoregional) {
        this.codigoregional = codigoregional;
    }

    public String getNombreregional() {
        return nombreregional;
    }

    public void setNombreregional(String nombreregional) {
        this.nombreregional = nombreregional;
    }

    @XmlTransient
    public List<Centro> getCentroList() {
        return centroList;
    }

    public void setCentroList(List<Centro> centroList) {
        this.centroList = centroList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoregional != null ? codigoregional.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Regional)) {
            return false;
        }
        Regional other = (Regional) object;
        if ((this.codigoregional == null && other.codigoregional != null) || (this.codigoregional != null && !this.codigoregional.equals(other.codigoregional))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Regional[ codigoregional=" + codigoregional + " ]";
    }
    
}
