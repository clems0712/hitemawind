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
 * @author mikha
 */
public class InventoryTransactionsData {
    EntityManager entityManager;
    EntityManagerFactory entityManagerFactory;
    
    public InventoryTransactionsData() {
            entityManagerFactory = Persistence.createEntityManagerFactory("HitemaWind");
            entityManager = entityManagerFactory.createEntityManager();
    }
    
    public List<InventoryTransactions> getListTransaction(){
       List<InventoryTransactions> transaction = entityManager.createNamedQuery("InventoryTransactions.findAll").getResultList();
       return transaction;
    }
}
