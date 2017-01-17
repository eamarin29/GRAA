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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "coformador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Coformador.findAll", query = "SELECT c FROM Coformador c"),
    @NamedQuery(name = "Coformador.findByDocumentocoformador", query = "SELECT c FROM Coformador c WHERE c.documentocoformador = :documentocoformador"),
    @NamedQuery(name = "Coformador.findByNombrecoformador", query = "SELECT c FROM Coformador c WHERE c.nombrecoformador = :nombrecoformador"),
    @NamedQuery(name = "Coformador.findByCargocoformador", query = "SELECT c FROM Coformador c WHERE c.cargocoformador = :cargocoformador"),
    @NamedQuery(name = "Coformador.findByTelefonocoformador", query = "SELECT c FROM Coformador c WHERE c.telefonocoformador = :telefonocoformador")})
public class Coformador implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "documentocoformador")
    private Long documentocoformador;
    @Size(max = 50)
    @Column(name = "nombrecoformador")
    private String nombrecoformador;
    @Size(max = 50)
    @Column(name = "cargocoformador")
    private String cargocoformador;
    @Size(max = 50)
    @Column(name = "telefonocoformador")
    private String telefonocoformador;
    @OneToMany(mappedBy = "documentocoformador")
    private List<Eproductiva> eproductivaList;
    @JoinColumn(name = "numeroempresa", referencedColumnName = "numeroempresa")
    @ManyToOne
    private Empresa numeroempresa;

    public Coformador() {
    }

    public Coformador(Long documentocoformador) {
        this.documentocoformador = documentocoformador;
    }

    public Long getDocumentocoformador() {
        return documentocoformador;
    }

    public void setDocumentocoformador(Long documentocoformador) {
        this.documentocoformador = documentocoformador;
    }

    public String getNombrecoformador() {
        return nombrecoformador;
    }

    public void setNombrecoformador(String nombrecoformador) {
        this.nombrecoformador = nombrecoformador;
    }

    public String getCargocoformador() {
        return cargocoformador;
    }

    public void setCargocoformador(String cargocoformador) {
        this.cargocoformador = cargocoformador;
    }

    public String getTelefonocoformador() {
        return telefonocoformador;
    }

    public void setTelefonocoformador(String telefonocoformador) {
        this.telefonocoformador = telefonocoformador;
    }

    @XmlTransient
    public List<Eproductiva> getEproductivaList() {
        return eproductivaList;
    }

    public void setEproductivaList(List<Eproductiva> eproductivaList) {
        this.eproductivaList = eproductivaList;
    }

    public Empresa getNumeroempresa() {
        return numeroempresa;
    }

    public void setNumeroempresa(Empresa numeroempresa) {
        this.numeroempresa = numeroempresa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (documentocoformador != null ? documentocoformador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Coformador)) {
            return false;
        }
        Coformador other = (Coformador) object;
        if ((this.documentocoformador == null && other.documentocoformador != null) || (this.documentocoformador != null && !this.documentocoformador.equals(other.documentocoformador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Coformador[ documentocoformador=" + documentocoformador + " ]";
    }
    
}
