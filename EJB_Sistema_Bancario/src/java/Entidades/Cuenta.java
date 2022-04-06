/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.Collection;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author abedon
 */
@Entity
@Table(name = "cuenta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cuenta.findAll", query = "SELECT c FROM Cuenta c"),
    @NamedQuery(name = "Cuenta.findByNumCuenta", query = "SELECT c FROM Cuenta c WHERE c.numCuenta = :numCuenta"),
    @NamedQuery(name = "Cuenta.findByValSaldo", query = "SELECT c FROM Cuenta c WHERE c.valSaldo = :valSaldo")})
public class Cuenta implements Serializable {
    @OneToMany(mappedBy = "numCuenta")
    private Collection<Movimiento> movimientoCollection;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "num_cuenta")
    private Long numCuenta;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "val_saldo")
    private Double valSaldo;
    @JoinColumn(name = "cod_cuenta", referencedColumnName = "cod_cuenta")
    @ManyToOne
    private TipoCuenta codCuenta;
    @JoinColumn(name = "num_cedula", referencedColumnName = "num_cedula")
    @ManyToOne
    private Cliente numCedula;

    public Cuenta() {
    }

    public Cuenta(Long numCuenta) {
        this.numCuenta = numCuenta;
    }

    public Long getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(Long numCuenta) {
        this.numCuenta = numCuenta;
    }

    public Double getValSaldo() {
        return valSaldo;
    }

    public void setValSaldo(Double valSaldo) {
        this.valSaldo = valSaldo;
    }

    public TipoCuenta getCodCuenta() {
        return codCuenta;
    }

    public void setCodCuenta(TipoCuenta codCuenta) {
        this.codCuenta = codCuenta;
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
        hash += (numCuenta != null ? numCuenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cuenta)) {
            return false;
        }
        Cuenta other = (Cuenta) object;
        if ((this.numCuenta == null && other.numCuenta != null) || (this.numCuenta != null && !this.numCuenta.equals(other.numCuenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Cuenta[ numCuenta=" + numCuenta + " ]";
    }

    @XmlTransient
    public Collection<Movimiento> getMovimientoCollection() {
        return movimientoCollection;
    }

    public void setMovimientoCollection(Collection<Movimiento> movimientoCollection) {
        this.movimientoCollection = movimientoCollection;
    }
    
}
