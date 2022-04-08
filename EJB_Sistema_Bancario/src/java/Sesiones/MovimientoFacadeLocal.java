/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Sesiones;

import Entidades.Cliente;
import Entidades.Cuenta;
import Entidades.Movimiento;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author abedon
 */
@Local
public interface MovimientoFacadeLocal {

    void create(Movimiento movimiento);

    void edit(Movimiento movimiento);

    void remove(Movimiento movimiento);

    Movimiento find(Object id);

    List<Movimiento> findAll();

    List<Movimiento> findRange(int[] range);

    int count();

    public List<Movimiento> retornarMovimientos(Cliente numCedula,Cuenta numCuenta);
    
}
