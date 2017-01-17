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
import javax.persistence.Id;
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
 * @author andres
 */
@Entity
@Table(name = "empresa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empresa.findAll", query = "SELECT e FROM Empresa e"),
    @NamedQuery(name = "Empresa.findByNumeroempresa", query = "SELECT e FROM Empresa e WHERE e.numeroempresa = :numeroempresa"),
    @NamedQuery(name = "Empresa.findByNombreempresa", query = "SELECT e FROM Empresa e WHERE e.nombreempresa = :nombreempresa"),
    @NamedQuery(name = "Empresa.findByDireccionempresa", query = "SELECT e FROM Empresa e WHERE e.direccionempresa = :direccionempresa"),
    @NamedQuery(name = "Empresa.findByTelefonoempresa", query = "SELECT e FROM Empresa e WHERE e.telefonoempresa = :telefonoempresa")})
public class Empresa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "numeroempresa")
    private Long numeroempresa;
    @Size(max = 50)
    @Column(name = "nombreempresa")
    private String nombreempresa;
    @Size(max = 50)
    @Column(name = "direccionempresa")
    private String direccionempresa;
    @Size(max = 50)
    @Column(name = "telefonoempresa")
    private String telefonoempresa;
    @OneToMany(mappedBy = "numeroempresa")
    private List<Eproductiva> eproductivaList;
    @OneToMany(mappedBy = "numeroempresa")
    private List<Coformador> coformadorList;

    public Empresa() {
    }

    public Empresa(Long numeroempresa) {
        this.numeroempresa = numeroempresa;
    }

    public Long getNumeroempresa() {
        return numeroempresa;
    }

    public void setNumeroempresa(Long numeroempresa) {
        this.numeroempresa = numeroempresa;
    }

    public String getNombreempresa() {
        return nombreempresa;
    }

    public void setNombreempresa(String nombreempresa) {
        this.nombreempresa = nombreempresa;
    }

    public String getDireccionempresa() {
        return direccionempresa;
    }

    public void setDireccionempresa(String direccionempresa) {
        this.direccionempresa = direccionempresa;
    }

    public String getTelefonoempresa() {
        return telefonoempresa;
    }

    public void setTelefonoempresa(String telefonoempresa) {
        this.telefonoempresa = telefonoempresa;
    }

    @XmlTransient
    public List<Eproductiva> getEproductivaList() {
        return eproductivaList;
    }

    public void setEproductivaList(List<Eproductiva> eproductivaList) {
        this.eproductivaList = eproductivaList;
    }

    @XmlTransient
    public List<Coformador> getCoformadorList() {
        return coformadorList;
    }

    public void setCoformadorList(List<Coformador> coformadorList) {
        this.coformadorList = coformadorList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numeroempresa != null ? numeroempresa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empresa)) {
            return false;
        }
        Empresa other = (Empresa) object;
        if ((this.numeroempresa == null && other.numeroempresa != null) || (this.numeroempresa != null && !this.numeroempresa.equals(other.numeroempresa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Empresa[ numeroempresa=" + numeroempresa + " ]";
    }
    
}
