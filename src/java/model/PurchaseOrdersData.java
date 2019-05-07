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
 * @author max
 */
public class PurchaseOrdersData {
    EntityManager entityManager;
    EntityManagerFactory entityManagerFactory;
    
    public PurchaseOrdersData() {
        entityManagerFactory = Persistence.createEntityManagerFactory("TeamworkPU");
        entityManager = entityManagerFactory.createEntityManager();
    }
    
    public List<Products> getListPurchaseOrders(){
       List<Products> products = entityManager.createNamedQuery("PurchaseOrders.findAll").getResultList();
       return products;
    }
}
