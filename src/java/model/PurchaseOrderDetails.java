/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Darman
 */
@Entity
@Table(name = "purchase_order_details")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PurchaseOrderDetails.findAll", query = "SELECT p FROM PurchaseOrderDetails p"),
    @NamedQuery(name = "PurchaseOrderDetails.findById", query = "SELECT p FROM PurchaseOrderDetails p WHERE p.id = :id"),
    @NamedQuery(name = "PurchaseOrderDetails.findByQuantity", query = "SELECT p FROM PurchaseOrderDetails p WHERE p.quantity = :quantity"),
    @NamedQuery(name = "PurchaseOrderDetails.findByUnitCost", query = "SELECT p FROM PurchaseOrderDetails p WHERE p.unitCost = :unitCost"),
    @NamedQuery(name = "PurchaseOrderDetails.findByDateReceived", query = "SELECT p FROM PurchaseOrderDetails p WHERE p.dateReceived = :dateReceived"),
    @NamedQuery(name = "PurchaseOrderDetails.findByPostedToInventory", query = "SELECT p FROM PurchaseOrderDetails p WHERE p.postedToInventory = :postedToInventory")})
public class PurchaseOrderDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantity")
    private BigDecimal quantity;
    @Basic(optional = false)
    @NotNull
    @Column(name = "unit_cost")
    private BigDecimal unitCost;
    @Column(name = "date_received")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateReceived;
    @Basic(optional = false)
    @NotNull
    @Column(name = "posted_to_inventory")
    private boolean postedToInventory;
    @JoinColumn(name = "inventory_id", referencedColumnName = "id")
    @ManyToOne
    private InventoryTransactions inventoryId;
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    @ManyToOne
    private Products productId;
    @JoinColumn(name = "purchase_order_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private PurchaseOrders purchaseOrderId;

    public PurchaseOrderDetails() {
    }

    public PurchaseOrderDetails(Integer id) {
        this.id = id;
    }

    public PurchaseOrderDetails(Integer id, BigDecimal quantity, BigDecimal unitCost, boolean postedToInventory) {
        this.id = id;
        this.quantity = quantity;
        this.unitCost = unitCost;
        this.postedToInventory = postedToInventory;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(BigDecimal unitCost) {
        this.unitCost = unitCost;
    }

    public Date getDateReceived() {
        return dateReceived;
    }

    public void setDateReceived(Date dateReceived) {
        this.dateReceived = dateReceived;
    }

    public boolean getPostedToInventory() {
        return postedToInventory;
    }

    public void setPostedToInventory(boolean postedToInventory) {
        this.postedToInventory = postedToInventory;
    }

    public InventoryTransactions getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(InventoryTransactions inventoryId) {
        this.inventoryId = inventoryId;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PurchaseOrderDetails)) {
            return false;
        }
        PurchaseOrderDetails other = (PurchaseOrderDetails) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.PurchaseOrderDetails[ id=" + id + " ]";
    }
    
}
