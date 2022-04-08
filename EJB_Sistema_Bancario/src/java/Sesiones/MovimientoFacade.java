/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Sesiones;

import Entidades.Cliente;
import Entidades.Cuenta;
import Entidades.Movimiento;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author abedon
 */
@Stateless
public class MovimientoFacade extends AbstractFacade<Movimiento> implements MovimientoFacadeLocal {

    @PersistenceContext(unitName = "EJB_Sistema_BancarioPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MovimientoFacade() {
        super(Movimiento.class);
    }

    @Override
    public List<Movimiento> retornarMovimientos(Cliente numCedula, Cuenta numCuenta) {


        /*
         listaMovimientos = this.findAll();
         return listaMovimientos;
         }
         */
        String consmov = null;
        List<Movimiento> listaMovimientos = null;

        try {
            Query sql = em.createNamedQuery("Movimiento.findByCedulaCuenta")
                    .setParameter("numCedula", numCedula)
                    .setParameter("numCuenta", numCuenta);

            listaMovimientos = sql.getResultList();

        } catch (Exception e) {
//            throw e;
        }
        return listaMovimientos;
    }
}
/*       
 consmov = "select m.numMovimiento,m.fechaMov,m.valCredito,m.valDebito,m.numCuenta from Movimiento m where m.numCedula =:numCedula";

 try {
 Query sql = em.createQuery(consmov);
 sql.setParameter("numCedula", numCedula);
 listaMovimientos = sql.getResultList();

 } catch (Exception e) {
 throw e;
 }
 return listaMovimientos;
 }
 */
