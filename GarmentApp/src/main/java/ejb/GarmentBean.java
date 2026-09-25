/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB40/StatelessEjbClass.java to edit this template
 */
package ejb;

import entity.Garmentmaster;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

/**
 *
 * @author root
 */
@Stateless
public class GarmentBean implements GarmentBeanLocal {

    @PersistenceContext(unitName = "mypu")
    private EntityManager em;

    // CREATE
    @Override
    public void addGarment(Garmentmaster garment) {
        em.persist(garment);
    }

    // READ ALL
    @Override
    public List<Garmentmaster> getAllGarments() {
        return em.createNamedQuery(
                "Garmentmaster.findAll",
                Garmentmaster.class
        ).getResultList();
    }

    // READ BY ID
    @Override
    public Garmentmaster getGarmentById(Integer id) {
        return em.find(Garmentmaster.class, id);
    }

    // UPDATE
    @Override
    public void updateGarment(Garmentmaster garment) {
        em.merge(garment);
    }

    // DELETE
    @Override
    public void deleteGarment(Integer id) {

        Garmentmaster garment = em.find(Garmentmaster.class, id);

        if (garment != null) {
            em.remove(garment);
        }
    }
}
