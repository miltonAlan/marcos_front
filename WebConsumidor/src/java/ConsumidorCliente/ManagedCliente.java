/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ConsumidorCliente;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.xml.ws.WebServiceRef;

/**
 *
 * @author mpaucar
 */
@ManagedBean(name = "ManagedCliente")
@SessionScoped
public class ManagedCliente {

    private String numCedula;
    private List<Cliente> clientes;

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public String getNumCedula() {
        return numCedula;
    }

    public void setNumCedula(String numCedula) {
        this.numCedula = numCedula;
    }
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/WebProveedor/ServicioProveedorCliente.wsdl")
    private ServicioProveedorCliente_Service service;

    private Cliente buscarPorCedula(java.lang.String numCedula) {
        ConsumidorCliente.ServicioProveedorCliente port = service.getServicioProveedorClientePort();
        return port.buscarPorCedula(numCedula);
    }

    public void consumirServicio() {
        clientes = new ArrayList<Cliente>();
        clientes.add(buscarPorCedula(numCedula));
    }
}
