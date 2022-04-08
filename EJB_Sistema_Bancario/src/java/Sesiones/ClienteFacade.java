/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Sesiones;

import Entidades.Cliente;
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
public class ClienteFacade extends AbstractFacade<Cliente> implements ClienteFacadeLocal {

    @PersistenceContext(unitName = "EJB_Sistema_BancarioPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClienteFacade() {
        super(Cliente.class);
    }

    @Override
    public Cliente buscarPorCedula(String numCedula) {
        List<Cliente> resultadoConsulta = null;
        try {
            Query sql = em.createNamedQuery("Cliente.findByNumCedula").setParameter("numCedula", numCedula);
            resultadoConsulta = sql.getResultList();
            if (resultadoConsulta != null) {
                return resultadoConsulta.get(0);
            }
        } catch (Exception e) {
        }
        return null;
    }
}
