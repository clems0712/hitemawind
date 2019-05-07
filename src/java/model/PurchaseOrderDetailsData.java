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
 * @author Ghost
 */
public class PurchaseOrderDetailsData {
        EntityManager entityManager;
        EntityManagerFactory entityManagerFactory;

    public PurchaseOrderDetailsData() {
            entityManagerFactory = Persistence.createEntityManagerFactory("TeamworkPU");
            entityManager = entityManagerFactory.createEntityManager();
    }
    
    public List<PurchaseOrderDetails> getListPurchaseOrderDetails(){
       List<PurchaseOrderDetails> PurchaseOrderDetails = entityManager.createNamedQuery("PurchaseOrderDetails.findAll").getResultList();
       return PurchaseOrderDetails;
    }
    
    
}
