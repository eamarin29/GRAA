/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author andres
 */
@Entity
@Table(name = "seguimientoaprendiz")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Seguimientoaprendiz.findAll", query = "SELECT s FROM Seguimientoaprendiz s"),
    @NamedQuery(name = "Seguimientoaprendiz.findByDocumentoaprendiz", query = "SELECT s FROM Seguimientoaprendiz s WHERE s.seguimientoaprendizPK.documentoaprendiz = :documentoaprendiz"),
    @NamedQuery(name = "Seguimientoaprendiz.findByNumeroseguimiento", query = "SELECT s FROM Seguimientoaprendiz s WHERE s.seguimientoaprendizPK.numeroseguimiento = :numeroseguimiento")})
public class Seguimientoaprendiz implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SeguimientoaprendizPK seguimientoaprendizPK;
    @Lob
    @Size(max = 65535)
    @Column(name = "rendimientoseguimiento")
    private String rendimientoseguimiento;
    @Lob
    @Size(max = 65535)
    @Column(name = "estrategiaseguimiento")
    private String estrategiaseguimiento;
    @JoinColumn(name = "documentoaprendiz", referencedColumnName = "documentoaprendiz", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Aprendiz aprendiz;
    @JoinColumn(name = "numeronovedad", referencedColumnName = "numeronovedad")
    @ManyToOne
    private Novedad numeronovedad;
    @JoinColumn(name = "numeroseguimiento", referencedColumnName = "codigoseguimiento", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Seguimiento seguimiento;

    public Seguimientoaprendiz() {
    }

    public Seguimientoaprendiz(SeguimientoaprendizPK seguimientoaprendizPK) {
        this.seguimientoaprendizPK = seguimientoaprendizPK;
    }

    public Seguimientoaprendiz(long documentoaprendiz, int numeroseguimiento) {
        this.seguimientoaprendizPK = new SeguimientoaprendizPK(documentoaprendiz, numeroseguimiento);
    }

    public SeguimientoaprendizPK getSeguimientoaprendizPK() {
        return seguimientoaprendizPK;
    }

    public void setSeguimientoaprendizPK(SeguimientoaprendizPK seguimientoaprendizPK) {
        this.seguimientoaprendizPK = seguimientoaprendizPK;
    }

    public String getRendimientoseguimiento() {
        return rendimientoseguimiento;
    }

    public void setRendimientoseguimiento(String rendimientoseguimiento) {
        this.rendimientoseguimiento = rendimientoseguimiento;
    }

    public String getEstrategiaseguimiento() {
        return estrategiaseguimiento;
    }

    public void setEstrategiaseguimiento(String estrategiaseguimiento) {
        this.estrategiaseguimiento = estrategiaseguimiento;
    }

    public Aprendiz getAprendiz() {
        return aprendiz;
    }

    public void setAprendiz(Aprendiz aprendiz) {
        this.aprendiz = aprendiz;
    }

    public Novedad getNumeronovedad() {
        return numeronovedad;
    }

    public void setNumeronovedad(Novedad numeronovedad) {
        this.numeronovedad = numeronovedad;
    }

    public Seguimiento getSeguimiento() {
        return seguimiento;
    }

    public void setSeguimiento(Seguimiento seguimiento) {
        this.seguimiento = seguimiento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (seguimientoaprendizPK != null ? seguimientoaprendizPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Seguimientoaprendiz)) {
            return false;
        }
        Seguimientoaprendiz other = (Seguimientoaprendiz) object;
        if ((this.seguimientoaprendizPK == null && other.seguimientoaprendizPK != null) || (this.seguimientoaprendizPK != null && !this.seguimientoaprendizPK.equals(other.seguimientoaprendizPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Seguimientoaprendiz[ seguimientoaprendizPK=" + seguimientoaprendizPK + " ]";
    }
    
}
