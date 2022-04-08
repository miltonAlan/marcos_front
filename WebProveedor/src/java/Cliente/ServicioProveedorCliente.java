/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;

import Entidades.Cliente;
import Sesiones.ClienteFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author mpaucar
 */
@WebService(serviceName = "ServicioProveedorCliente")
public class ServicioProveedorCliente {
    @EJB
    private ClienteFacadeLocal ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @WebMethod(operationName = "create")
    @Oneway
    public void create(@WebParam(name = "cliente") Cliente cliente) {
        ejbRef.create(cliente);
    }

    @WebMethod(operationName = "edit")
    @Oneway
    public void edit(@WebParam(name = "cliente") Cliente cliente) {
        ejbRef.edit(cliente);
    }

    @WebMethod(operationName = "remove")
    @Oneway
    public void remove(@WebParam(name = "cliente") Cliente cliente) {
        ejbRef.remove(cliente);
    }

    @WebMethod(operationName = "find")
    public Cliente find(@WebParam(name = "id") Object id) {
        return ejbRef.find(id);
    }

    @WebMethod(operationName = "findAll")
    public List<Cliente> findAll() {
        return ejbRef.findAll();
    }

    @WebMethod(operationName = "findRange")
    public List<Cliente> findRange(@WebParam(name = "range") int[] range) {
        return ejbRef.findRange(range);
    }

    @WebMethod(operationName = "count")
    public int count() {
        return ejbRef.count();
    }

    @WebMethod(operationName = "buscarPorCedula")
    public Cliente buscarPorCedula(@WebParam(name = "numCedula") String numCedula) {
        return ejbRef.buscarPorCedula(numCedula);
    }
    
}
