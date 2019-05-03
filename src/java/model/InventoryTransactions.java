/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Darman
 */
@Entity
@Table(name = "inventory_transactions")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InventoryTransactions.findAll", query = "SELECT i FROM InventoryTransactions i"),
    @NamedQuery(name = "InventoryTransactions.findById", query = "SELECT i FROM InventoryTransactions i WHERE i.id = :id"),
    @NamedQuery(name = "InventoryTransactions.findByTransactionCreatedDate", query = "SELECT i FROM InventoryTransactions i WHERE i.transactionCreatedDate = :transactionCreatedDate"),
    @NamedQuery(name = "InventoryTransactions.findByTransactionModifiedDate", query = "SELECT i FROM InventoryTransactions i WHERE i.transactionModifiedDate = :transactionModifiedDate"),
    @NamedQuery(name = "InventoryTransactions.findByQuantity", query = "SELECT i FROM InventoryTransactions i WHERE i.quantity = :quantity"),
    @NamedQuery(name = "InventoryTransactions.findByComments", query = "SELECT i FROM InventoryTransactions i WHERE i.comments = :comments")})
public class InventoryTransactions implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "transaction_created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date transactionCreatedDate;
    @Column(name = "transaction_modified_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date transactionModifiedDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantity")
    private int quantity;
    @Size(max = 255)
    @Column(name = "comments")
    private String comments;
    @OneToMany(mappedBy = "inventoryId")
    private Collection<PurchaseOrderDetails> purchaseOrderDetailsCollection;
    @JoinColumn(name = "customer_order_id", referencedColumnName = "id")
    @ManyToOne
    private Orders customerOrderId;
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Products productId;
    @JoinColumn(name = "purchase_order_id", referencedColumnName = "id")
    @ManyToOne
    private PurchaseOrders purchaseOrderId;
    @JoinColumn(name = "transaction_type", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private InventoryTransactionTypes transactionType;

    public InventoryTransactions() {
    }

    public InventoryTransactions(Integer id) {
        this.id = id;
    }

    public InventoryTransactions(Integer id, int quantity) {
        this.id = id;
        this.quantity = quantity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getTransactionCreatedDate() {
        return transactionCreatedDate;
    }

    public void setTransactionCreatedDate(Date transactionCreatedDate) {
        this.transactionCreatedDate = transactionCreatedDate;
    }

    public Date getTransactionModifiedDate() {
        return transactionModifiedDate;
    }

    public void setTransactionModifiedDate(Date transactionModifiedDate) {
        this.transactionModifiedDate = transactionModifiedDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @XmlTransient
    public Collection<PurchaseOrderDetails> getPurchaseOrderDetailsCollection() {
        return purchaseOrderDetailsCollection;
    }

    public void setPurchaseOrderDetailsCollection(Collection<PurchaseOrderDetails> purchaseOrderDetailsCollection) {
        this.purchaseOrderDetailsCollection = purchaseOrderDetailsCollection;
    }

    public Orders getCustomerOrderId() {
        return customerOrderId;
    }

    public void setCustomerOrderId(Orders customerOrderId) {
        this.customerOrderId = customerOrderId;
    }

    public Products getProductId() {
        return productId;
    }

    public void setProductId(Products productId) {
        this.productId = productId;
    }

    public PurchaseOrders getPurchaseOrderId() {
        return purchaseOrderId;
    }

    public void setPurchaseOrderId(PurchaseOrders purchaseOrderId) {
        this.purchaseOrderId = purchaseOrderId;
    }

    public InventoryTransactionTypes getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(InventoryTransactionTypes transactionType) {
        this.transactionType = transactionType;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InventoryTransactions)) {
            return false;
        }
        InventoryTransactions other = (InventoryTransactions) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.InventoryTransactions[ id=" + id + " ]";
    }
    
}
