/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author abedon
 */
@Entity
@Table(name = "movimiento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Movimiento.findAll", query = "SELECT m FROM Movimiento m"),
    @NamedQuery(name = "Movimiento.findByCedula", query = "SELECT m FROM Movimiento m WHERE m.numCedula = :numCedula"),
    @NamedQuery(name = "Movimiento.findByNumMovimiento", query = "SELECT m FROM Movimiento m WHERE m.numMovimiento = :numMovimiento"),
    @NamedQuery(name = "Movimiento.findByFechaMov", query = "SELECT m FROM Movimiento m WHERE m.fechaMov = :fechaMov"),
    @NamedQuery(name = "Movimiento.findByValCredito", query = "SELECT m FROM Movimiento m WHERE m.valCredito = :valCredito"),
    @NamedQuery(name = "Movimiento.findByValDebito", query = "SELECT m FROM Movimiento m WHERE m.valDebito = :valDebito")})
public class Movimiento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "num_movimiento")
    private Long numMovimiento;
    @Column(name = "fecha_mov")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaMov;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "val_credito")
    private Double valCredito;
    @Column(name = "val_debito")
    private Double valDebito;
    @JoinColumn(name = "num_cuenta", referencedColumnName = "num_cuenta")
    @ManyToOne
    private Cuenta numCuenta;
    @JoinColumn(name = "num_cedula", referencedColumnName = "num_cedula")
    @ManyToOne
    private Cliente numCedula;

    public Movimiento() {
    }

    public Movimiento(Long numMovimiento) {
        this.numMovimiento = numMovimiento;
    }

    public Long getNumMovimiento() {
        return numMovimiento;
    }

    public void setNumMovimiento(Long numMovimiento) {
        this.numMovimiento = numMovimiento;
    }

    public Date getFechaMov() {
        return fechaMov;
    }

    public void setFechaMov(Date fechaMov) {
        this.fechaMov = fechaMov;
    }

    public Double getValCredito() {
        return valCredito;
    }

    public void setValCredito(Double valCredito) {
        this.valCredito = valCredito;
    }

    public Double getValDebito() {
        return valDebito;
    }

    public void setValDebito(Double valDebito) {
        this.valDebito = valDebito;
    }

    public Cuenta getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(Cuenta numCuenta) {
        this.numCuenta = numCuenta;
    }

    public Cliente getNumCedula() {
        return numCedula;
    }

    public void setNumCedula(Cliente numCedula) {
        this.numCedula = numCedula;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numMovimiento != null ? numMovimiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Movimiento)) {
            return false;
        }
        Movimiento other = (Movimiento) object;
        if ((this.numMovimiento == null && other.numMovimiento != null) || (this.numMovimiento != null && !this.numMovimiento.equals(other.numMovimiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Movimiento[ numMovimiento=" + numMovimiento + " ]";
    }
    
}
