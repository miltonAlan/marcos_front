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
 * @author abedon
 */
@Entity
@Table(name = "tipo_cuenta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoCuenta.findAll", query = "SELECT t FROM TipoCuenta t"),
    @NamedQuery(name = "TipoCuenta.findByCodCuenta", query = "SELECT t FROM TipoCuenta t WHERE t.codCuenta = :codCuenta"),
    @NamedQuery(name = "TipoCuenta.findByNomCuenta", query = "SELECT t FROM TipoCuenta t WHERE t.nomCuenta = :nomCuenta")})
public class TipoCuenta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_cuenta")
    private Character codCuenta;
    @Size(max = 255)
    @Column(name = "nom_cuenta")
    private String nomCuenta;
    @OneToMany(mappedBy = "codCuenta")
    private Collection<Cuenta> cuentaCollection;

    public TipoCuenta() {
    }

    public TipoCuenta(Character codCuenta) {
        this.codCuenta = codCuenta;
    }

    public Character getCodCuenta() {
        return codCuenta;
    }

    public void setCodCuenta(Character codCuenta) {
        this.codCuenta = codCuenta;
    }

    public String getNomCuenta() {
        return nomCuenta;
    }

    public void setNomCuenta(String nomCuenta) {
        this.nomCuenta = nomCuenta;
    }

    @XmlTransient
    public Collection<Cuenta> getCuentaCollection() {
        return cuentaCollection;
    }

    public void setCuentaCollection(Collection<Cuenta> cuentaCollection) {
        this.cuentaCollection = cuentaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codCuenta != null ? codCuenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoCuenta)) {
            return false;
        }
        TipoCuenta other = (TipoCuenta) object;
        if ((this.codCuenta == null && other.codCuenta != null) || (this.codCuenta != null && !this.codCuenta.equals(other.codCuenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.TipoCuenta[ codCuenta=" + codCuenta + " ]";
    }
    
}
