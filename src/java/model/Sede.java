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
@Table(name = "sede")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sede.findAll", query = "SELECT s FROM Sede s"),
    @NamedQuery(name = "Sede.findByNumerosede", query = "SELECT s FROM Sede s WHERE s.numerosede = :numerosede"),
    @NamedQuery(name = "Sede.findByNombresede", query = "SELECT s FROM Sede s WHERE s.nombresede = :nombresede"),
    @NamedQuery(name = "Sede.findByDireccionsede", query = "SELECT s FROM Sede s WHERE s.direccionsede = :direccionsede"),
    @NamedQuery(name = "Sede.findByEstadosede", query = "SELECT s FROM Sede s WHERE s.estadosede = :estadosede")})
public class Sede implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "numerosede")
    private Integer numerosede;
    @Size(max = 50)
    @Column(name = "nombresede")
    private String nombresede;
    @Size(max = 50)
    @Column(name = "direccionsede")
    private String direccionsede;
    @Size(max = 50)
    @Column(name = "estadosede")
    private String estadosede;
    @OneToMany(mappedBy = "numerosedeambiente")
    private List<Ambientedeaprendizaje> ambientedeaprendizajeList;
    @OneToMany(mappedBy = "numerosede")
    private List<Fichatitulacion> fichatitulacionList;
    @JoinColumn(name = "documentofuncionario", referencedColumnName = "documentofuncionario")
    @ManyToOne
    private Funcionario documentofuncionario;

    public Sede() {
    }

    public Sede(Integer numerosede) {
        this.numerosede = numerosede;
    }

    public Integer getNumerosede() {
        return numerosede;
    }

    public void setNumerosede(Integer numerosede) {
        this.numerosede = numerosede;
    }

    public String getNombresede() {
        return nombresede;
    }

    public void setNombresede(String nombresede) {
        this.nombresede = nombresede;
    }

    public String getDireccionsede() {
        return direccionsede;
    }

    public void setDireccionsede(String direccionsede) {
        this.direccionsede = direccionsede;
    }

    public String getEstadosede() {
        return estadosede;
    }

    public void setEstadosede(String estadosede) {
        this.estadosede = estadosede;
    }

    @XmlTransient
    public List<Ambientedeaprendizaje> getAmbientedeaprendizajeList() {
        return ambientedeaprendizajeList;
    }

    public void setAmbientedeaprendizajeList(List<Ambientedeaprendizaje> ambientedeaprendizajeList) {
        this.ambientedeaprendizajeList = ambientedeaprendizajeList;
    }

    @XmlTransient
    public List<Fichatitulacion> getFichatitulacionList() {
        return fichatitulacionList;
    }

    public void setFichatitulacionList(List<Fichatitulacion> fichatitulacionList) {
        this.fichatitulacionList = fichatitulacionList;
    }

    public Funcionario getDocumentofuncionario() {
        return documentofuncionario;
    }

    public void setDocumentofuncionario(Funcionario documentofuncionario) {
        this.documentofuncionario = documentofuncionario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numerosede != null ? numerosede.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sede)) {
            return false;
        }
        Sede other = (Sede) object;
        if ((this.numerosede == null && other.numerosede != null) || (this.numerosede != null && !this.numerosede.equals(other.numerosede))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Sede[ numerosede=" + numerosede + " ]";
    }
    
}
