/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author andres
 */
@Entity
@Table(name = "permiso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Permiso.findAll", query = "SELECT p FROM Permiso p"),
    @NamedQuery(name = "Permiso.findByCodigopermiso", query = "SELECT p FROM Permiso p WHERE p.codigopermiso = :codigopermiso"),
    @NamedQuery(name = "Permiso.findByFechapermiso", query = "SELECT p FROM Permiso p WHERE p.fechapermiso = :fechapermiso"),
    @NamedQuery(name = "Permiso.findByHoradesdepermiso", query = "SELECT p FROM Permiso p WHERE p.horadesdepermiso = :horadesdepermiso"),
    @NamedQuery(name = "Permiso.findByHorahastapermiso", query = "SELECT p FROM Permiso p WHERE p.horahastapermiso = :horahastapermiso"),
    @NamedQuery(name = "Permiso.findByEstadopermiso", query = "SELECT p FROM Permiso p WHERE p.estadopermiso = :estadopermiso")})
public class Permiso implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigopermiso")
    private Integer codigopermiso;
    @Column(name = "fechapermiso")
    @Temporal(TemporalType.DATE)
    private Date fechapermiso;
    @Size(max = 50)
    @Column(name = "horadesdepermiso")
    private String horadesdepermiso;
    @Size(max = 50)
    @Column(name = "horahastapermiso")
    private String horahastapermiso;
    @Lob
    @Size(max = 65535)
    @Column(name = "motivopermiso")
    private String motivopermiso;
    @Size(max = 50)
    @Column(name = "estadopermiso")
    private String estadopermiso;
    @JoinColumn(name = "documentoaprendiz", referencedColumnName = "documentoaprendiz")
    @ManyToOne
    private Aprendiz documentoaprendiz;
    @JoinColumn(name = "documentocoordinador", referencedColumnName = "documentocoordinador")
    @ManyToOne
    private Coordinador documentocoordinador;
    @JoinColumn(name = "documentoinstructor", referencedColumnName = "documentoinstructor")
    @ManyToOne
    private Instructor documentoinstructor;

    public Permiso() {
    }

    public Permiso(Integer codigopermiso) {
        this.codigopermiso = codigopermiso;
    }

    public Integer getCodigopermiso() {
        return codigopermiso;
    }

    public void setCodigopermiso(Integer codigopermiso) {
        this.codigopermiso = codigopermiso;
    }

    public Date getFechapermiso() {
        return fechapermiso;
    }

    public void setFechapermiso(Date fechapermiso) {
        this.fechapermiso = fechapermiso;
    }

    public String getHoradesdepermiso() {
        return horadesdepermiso;
    }

    public void setHoradesdepermiso(String horadesdepermiso) {
        this.horadesdepermiso = horadesdepermiso;
    }

    public String getHorahastapermiso() {
        return horahastapermiso;
    }

    public void setHorahastapermiso(String horahastapermiso) {
        this.horahastapermiso = horahastapermiso;
    }

    public String getMotivopermiso() {
        return motivopermiso;
    }

    public void setMotivopermiso(String motivopermiso) {
        this.motivopermiso = motivopermiso;
    }

    public String getEstadopermiso() {
        return estadopermiso;
    }

    public void setEstadopermiso(String estadopermiso) {
        this.estadopermiso = estadopermiso;
    }

    public Aprendiz getDocumentoaprendiz() {
        return documentoaprendiz;
    }

    public void setDocumentoaprendiz(Aprendiz documentoaprendiz) {
        this.documentoaprendiz = documentoaprendiz;
    }

    public Coordinador getDocumentocoordinador() {
        return documentocoordinador;
    }

    public void setDocumentocoordinador(Coordinador documentocoordinador) {
        this.documentocoordinador = documentocoordinador;
    }

    public Instructor getDocumentoinstructor() {
        return documentoinstructor;
    }

    public void setDocumentoinstructor(Instructor documentoinstructor) {
        this.documentoinstructor = documentoinstructor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigopermiso != null ? codigopermiso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Permiso)) {
            return false;
        }
        Permiso other = (Permiso) object;
        if ((this.codigopermiso == null && other.codigopermiso != null) || (this.codigopermiso != null && !this.codigopermiso.equals(other.codigopermiso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Permiso[ codigopermiso=" + codigopermiso + " ]";
    }
    
}
