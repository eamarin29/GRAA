/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author andres
 */
@Embeddable
public class SeguimientoaprendizPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "documentoaprendiz")
    private long documentoaprendiz;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numeroseguimiento")
    private int numeroseguimiento;

    public SeguimientoaprendizPK() {
    }

    public SeguimientoaprendizPK(long documentoaprendiz, int numeroseguimiento) {
        this.documentoaprendiz = documentoaprendiz;
        this.numeroseguimiento = numeroseguimiento;
    }

    public long getDocumentoaprendiz() {
        return documentoaprendiz;
    }

    public void setDocumentoaprendiz(long documentoaprendiz) {
        this.documentoaprendiz = documentoaprendiz;
    }

    public int getNumeroseguimiento() {
        return numeroseguimiento;
    }

    public void setNumeroseguimiento(int numeroseguimiento) {
        this.numeroseguimiento = numeroseguimiento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) documentoaprendiz;
        hash += (int) numeroseguimiento;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SeguimientoaprendizPK)) {
            return false;
        }
        SeguimientoaprendizPK other = (SeguimientoaprendizPK) object;
        if (this.documentoaprendiz != other.documentoaprendiz) {
            return false;
        }
        if (this.numeroseguimiento != other.numeroseguimiento) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.SeguimientoaprendizPK[ documentoaprendiz=" + documentoaprendiz + ", numeroseguimiento=" + numeroseguimiento + " ]";
    }
    
}
