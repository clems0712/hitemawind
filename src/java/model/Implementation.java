/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author phili
 */
public class Implementation {
        EntityManager entityManager;
        EntityManagerFactory entityManagerFactory;

    public Implementation() {
            entityManagerFactory = Persistence.createEntityManagerFactory("TeamworkPU");
            entityManager = entityManagerFactory.createEntityManager();
    }
    
    public List<Orders> getListOrders(){
       List<Orders> orders = entityManager.createNamedQuery("Orders.findAll").getResultList();
       System.out.println("model.Implementation.getListOrders() : " + orders.toString());
       return orders;
    }
}
