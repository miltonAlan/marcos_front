/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Entidades.Cliente;
import Entidades.Cuenta;
import Entidades.Movimiento;
import Sesiones.MovimientoFacadeLocal;
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
@WebService(serviceName = "ServicioWebMovimientos")
public class ServicioWebMovimientos {
    @EJB
    private MovimientoFacadeLocal ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @WebMethod(operationName = "create")
    @Oneway
    public void create(@WebParam(name = "movimiento") Movimiento movimiento) {
        ejbRef.create(movimiento);
    }

    @WebMethod(operationName = "edit")
    @Oneway
    public void edit(@WebParam(name = "movimiento") Movimiento movimiento) {
        ejbRef.edit(movimiento);
    }

    @WebMethod(operationName = "remove")
    @Oneway
    public void remove(@WebParam(name = "movimiento") Movimiento movimiento) {
        ejbRef.remove(movimiento);
    }

    @WebMethod(operationName = "find")
    public Movimiento find(@WebParam(name = "id") Object id) {
        return ejbRef.find(id);
    }

    @WebMethod(operationName = "findAll")
    public List<Movimiento> findAll() {
        return ejbRef.findAll();
    }

    @WebMethod(operationName = "findRange")
    public List<Movimiento> findRange(@WebParam(name = "range") int[] range) {
        return ejbRef.findRange(range);
    }

    @WebMethod(operationName = "count")
    public int count() {
        return ejbRef.count();
    }

    @WebMethod(operationName = "retornarMovimientos")
    public List<Movimiento> retornarMovimientos(@WebParam(name = "numCedula") Cliente numCedula, @WebParam(name = "numCuenta") Cuenta numCuenta) {
        return ejbRef.retornarMovimientos(numCedula, numCuenta);
    }
    
}
