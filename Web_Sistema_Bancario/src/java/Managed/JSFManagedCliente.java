/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Managed;

import Entidades.Cliente;
import Entidades.Cuenta;
import Entidades.Movimiento;
import Entidades.TipoCuenta;
import Sesiones.ClienteFacadeLocal;
import Sesiones.CuentaFacadeLocal;
import Sesiones.MovimientoFacadeLocal;
import Sesiones.TipoCuentaFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author abedon
 */
@ManagedBean(name = "JSFManagedCliente")
@SessionScoped

public class JSFManagedCliente implements Serializable {

    @EJB
    private ClienteFacadeLocal manejadorCliente;
    private Cliente cliente;
    private List<Cliente> listaClientes;
    
    @EJB
    private TipoCuentaFacadeLocal manejadorTipocuenta;
    private TipoCuenta tipoCuenta;

    @EJB
    private CuentaFacadeLocal manejadorCuenta;
    private Cuenta cuenta;
    private String numCedula;
    private Character codCuenta;
    
    @EJB 
    private MovimientoFacadeLocal manejadorMovimiento;
    private List<Movimiento> listaMovimientos;
    
    public JSFManagedCliente() {
    }

    public void grabarCliente() {
        manejadorCliente.create(cliente);
    }

    public void grabarTipoCuenta(){
        manejadorTipocuenta.create(tipoCuenta);
    }
    
    public void grabarCuenta() {
        this.cuenta.setCodCuenta(manejadorTipocuenta.find(codCuenta));
        this.cuenta.setNumCedula(manejadorCliente.find(numCedula));
        manejadorCuenta.create(cuenta);
    }
    
    public void listarClientes() {
        setListaClientes(manejadorCliente.findAll());
    }
/*manejadorCliente.find("1717739088")*/
    public void listarMovimientos() {
        setListaMovimientos(manejadorMovimiento.retornarMovimientos(manejadorCliente.find("1717739088")));
    }
    
    @PostConstruct
    private void inicio() {
        cliente = new Cliente();
        tipoCuenta = new TipoCuenta();
        cuenta = new Cuenta();
        listarClientes();
        listarMovimientos();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public TipoCuenta getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(TipoCuenta tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public String getNumCedula() {
        return numCedula;
    }

    public void setNumCedula(String numCedula) {
        this.numCedula = numCedula;
    }

    public Character getCodCuenta() {
        return codCuenta;
    }

    public void setCodCuenta(Character codCuenta) {
        this.codCuenta = codCuenta;
    }

    public List<Movimiento> getListaMovimientos() {
        return listaMovimientos;
    }

    public void setListaMovimientos(List<Movimiento> listaMovimientos) {
        this.listaMovimientos = listaMovimientos;
    }

   
    
}
