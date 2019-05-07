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
public class ProductsData {
    EntityManager entityManager;
    EntityManagerFactory entityManagerFactory;
    
    public ProductsData() {
        entityManagerFactory = Persistence.createEntityManagerFactory("TeamworkPU");
        entityManager = entityManagerFactory.createEntityManager();
    }
    
    public List<Products> getListProducts(){
       List<Products> products = entityManager.createNamedQuery("Products.findAll").getResultList();
       return products;
    }
}
