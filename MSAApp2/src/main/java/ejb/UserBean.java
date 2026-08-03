/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB40/StatelessEjbClass.java to edit this template
 */
package ejb;

import entity.User;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class UserBean implements UserBeanLocal {
    
    @PersistenceContext(unitName = "mypu")
    EntityManager em;
    
    @Override
    public void addUser(User user) {
        em.persist(user);
    }

    @Override
    public void updateUser(User user) {
        em.merge(user);
    }

    @Override
    public List<User> getAllUsers() {   
        List<User> users = em.createQuery("SELECT u FROM User u", User.class).getResultList();
        return users;
    }

    @Override
    public void deleteUser(Integer userId) {
        User user = em.find(User.class, userId);
        em.remove(user);
    }
}
