/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Consumidor;


import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.xml.ws.WebServiceRef;

/**
 *
 * @author abedon
 */
@ManagedBean(name = "JSFManagedBeanMovimientos")
@SessionScoped
public class JSFManagedBeanMovimientos {
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/WebProveedor/ServicioWebMovimientos.wsdl")
    private ServicioWebMovimientos_Service service;

    /**
     * Creates a new instance of JSFManagedBeanMovimientos
     */
    public JSFManagedBeanMovimientos() {
    }

    private java.util.List<Consumidor.Movimiento> listaMovimientos;
    
    private java.util.List<Consumidor.Movimiento> findAll() {
        Consumidor.ServicioWebMovimientos port = service.getServicioWebMovimientosPort();
        return port.findAll();
    }

    public java.util.List<Consumidor.Movimiento> getListaMovimientos() {
        return listaMovimientos;
    }

    public void setListaMovimientos(java.util.List<Consumidor.Movimiento> listaMovimientos) {
        this.listaMovimientos = listaMovimientos;
    }
  
    @PostConstruct
    private void inicio(){
        setListaMovimientos(this.findAll());
    }
    
}
