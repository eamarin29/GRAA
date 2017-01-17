/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author andres
 */
@Entity
@Table(name = "ingreso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ingreso.findAll", query = "SELECT i FROM Ingreso i"),
    @NamedQuery(name = "Ingreso.findByNumeroingreso", query = "SELECT i FROM Ingreso i WHERE i.numeroingreso = :numeroingreso"),
    @NamedQuery(name = "Ingreso.findByFechaingreso", query = "SELECT i FROM Ingreso i WHERE i.fechaingreso = :fechaingreso"),
    @NamedQuery(name = "Ingreso.findByHoraingreso", query = "SELECT i FROM Ingreso i WHERE i.horaingreso = :horaingreso"),
    @NamedQuery(name = "Ingreso.findByHorasalida", query = "SELECT i FROM Ingreso i WHERE i.horasalida = :horasalida")})
public class Ingreso implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "numeroingreso")
    private Integer numeroingreso;
    @Column(name = "fechaingreso")
    @Temporal(TemporalType.DATE)
    private Date fechaingreso;
    @Size(max = 50)
    @Column(name = "horaingreso")
    private String horaingreso;
    @Size(max = 50)
    @Column(name = "horasalida")
    private String horasalida;
    @Lob
    @Size(max = 65535)
    @Column(name = "motivoingreso")
    private String motivoingreso;
    @ManyToMany(mappedBy = "ingresoList")
    private List<Elementoparticular> elementoparticularList;
    @JoinColumn(name = "documentopersonal", referencedColumnName = "documentopersonal")
    @ManyToOne
    private Personal documentopersonal;

    public Ingreso() {
    }

    public Ingreso(Integer numeroingreso) {
        this.numeroingreso = numeroingreso;
    }

    public Integer getNumeroingreso() {
        return numeroingreso;
    }

    public void setNumeroingreso(Integer numeroingreso) {
        this.numeroingreso = numeroingreso;
    }

    public Date getFechaingreso() {
        return fechaingreso;
    }

    public void setFechaingreso(Date fechaingreso) {
        this.fechaingreso = fechaingreso;
    }

    public String getHoraingreso() {
        return horaingreso;
    }

    public void setHoraingreso(String horaingreso) {
        this.horaingreso = horaingreso;
    }

    public String getHorasalida() {
        return horasalida;
    }

    public void setHorasalida(String horasalida) {
        this.horasalida = horasalida;
    }

    public String getMotivoingreso() {
        return motivoingreso;
    }

    public void setMotivoingreso(String motivoingreso) {
        this.motivoingreso = motivoingreso;
    }

    @XmlTransient
    public List<Elementoparticular> getElementoparticularList() {
        return elementoparticularList;
    }

    public void setElementoparticularList(List<Elementoparticular> elementoparticularList) {
        this.elementoparticularList = elementoparticularList;
    }

    public Personal getDocumentopersonal() {
        return documentopersonal;
    }

    public void setDocumentopersonal(Personal documentopersonal) {
        this.documentopersonal = documentopersonal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numeroingreso != null ? numeroingreso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ingreso)) {
            return false;
        }
        Ingreso other = (Ingreso) object;
        if ((this.numeroingreso == null && other.numeroingreso != null) || (this.numeroingreso != null && !this.numeroingreso.equals(other.numeroingreso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Ingreso[ numeroingreso=" + numeroingreso + " ]";
    }
    
}
