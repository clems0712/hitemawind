/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Darman
 */
@Entity
@Table(name = "products")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Products.findAll", query = "SELECT p FROM Products p"),
    @NamedQuery(name = "Products.findById", query = "SELECT p FROM Products p WHERE p.id = :id"),
    @NamedQuery(name = "Products.findByProductCode", query = "SELECT p FROM Products p WHERE p.productCode = :productCode"),
    @NamedQuery(name = "Products.findByProductName", query = "SELECT p FROM Products p WHERE p.productName = :productName"),
    @NamedQuery(name = "Products.findByStandardCost", query = "SELECT p FROM Products p WHERE p.standardCost = :standardCost"),
    @NamedQuery(name = "Products.findByListPrice", query = "SELECT p FROM Products p WHERE p.listPrice = :listPrice"),
    @NamedQuery(name = "Products.findByReorderLevel", query = "SELECT p FROM Products p WHERE p.reorderLevel = :reorderLevel"),
    @NamedQuery(name = "Products.findByTargetLevel", query = "SELECT p FROM Products p WHERE p.targetLevel = :targetLevel"),
    @NamedQuery(name = "Products.findByQuantityPerUnit", query = "SELECT p FROM Products p WHERE p.quantityPerUnit = :quantityPerUnit"),
    @NamedQuery(name = "Products.findByDiscontinued", query = "SELECT p FROM Products p WHERE p.discontinued = :discontinued"),
    @NamedQuery(name = "Products.findByMinimumReorderQuantity", query = "SELECT p FROM Products p WHERE p.minimumReorderQuantity = :minimumReorderQuantity"),
    @NamedQuery(name = "Products.findByCategory", query = "SELECT p FROM Products p WHERE p.category = :category")})
public class Products implements Serializable {

    private static final long serialVersionUID = 1L;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "supplier_ids")
    private String supplierIds;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 25)
    @Column(name = "product_code")
    private String productCode;
    @Size(max = 50)
    @Column(name = "product_name")
    private String productName;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "description")
    private String description;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "standard_cost")
    private BigDecimal standardCost;
    @Basic(optional = false)
    @NotNull
    @Column(name = "list_price")
    private BigDecimal listPrice;
    @Column(name = "reorder_level")
    private Integer reorderLevel;
    @Column(name = "target_level")
    private Integer targetLevel;
    @Size(max = 50)
    @Column(name = "quantity_per_unit")
    private String quantityPerUnit;
    @Basic(optional = false)
    @NotNull
    @Column(name = "discontinued")
    private boolean discontinued;
    @Column(name = "minimum_reorder_quantity")
    private Integer minimumReorderQuantity;
    @Size(max = 50)
    @Column(name = "category")
    private String category;
    @Lob
    @Column(name = "attachments")
    private byte[] attachments;
    @OneToMany(mappedBy = "productId")
    private Collection<OrderDetails> orderDetailsCollection;
    @OneToMany(mappedBy = "productId")
    private Collection<PurchaseOrderDetails> purchaseOrderDetailsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productId")
    private Collection<InventoryTransactions> inventoryTransactionsCollection;

    public Products() {
    }

    public Products(Integer id) {
        this.id = id;
    }

    public Products(Integer id, BigDecimal listPrice, boolean discontinued) {
        this.id = id;
        this.listPrice = listPrice;
        this.discontinued = discontinued;
    }

    public String getSupplierIds() {
        return supplierIds;
    }

    public void setSupplierIds(String supplierIds) {
        this.supplierIds = supplierIds;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getStandardCost() {
        return standardCost;
    }

    public void setStandardCost(BigDecimal standardCost) {
        this.standardCost = standardCost;
    }

    public BigDecimal getListPrice() {
        return listPrice;
    }

    public void setListPrice(BigDecimal listPrice) {
        this.listPrice = listPrice;
    }

    public Integer getReorderLevel() {
        return reorderLevel;
    }

    public void setReorderLevel(Integer reorderLevel) {
        this.reorderLevel = reorderLevel;
    }

    public Integer getTargetLevel() {
        return targetLevel;
    }

    public void setTargetLevel(Integer targetLevel) {
        this.targetLevel = targetLevel;
    }

    public String getQuantityPerUnit() {
        return quantityPerUnit;
    }

    public void setQuantityPerUnit(String quantityPerUnit) {
        this.quantityPerUnit = quantityPerUnit;
    }

    public boolean getDiscontinued() {
        return discontinued;
    }

    public void setDiscontinued(boolean discontinued) {
        this.discontinued = discontinued;
    }

    public Integer getMinimumReorderQuantity() {
        return minimumReorderQuantity;
    }

    public void setMinimumReorderQuantity(Integer minimumReorderQuantity) {
        this.minimumReorderQuantity = minimumReorderQuantity;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public byte[] getAttachments() {
        return attachments;
    }

    public void setAttachments(byte[] attachments) {
        this.attachments = attachments;
    }

    @XmlTransient
    public Collection<OrderDetails> getOrderDetailsCollection() {
        return orderDetailsCollection;
    }

    public void setOrderDetailsCollection(Collection<OrderDetails> orderDetailsCollection) {
        this.orderDetailsCollection = orderDetailsCollection;
    }

    @XmlTransient
    public Collection<PurchaseOrderDetails> getPurchaseOrderDetailsCollection() {
        return purchaseOrderDetailsCollection;
    }

    public void setPurchaseOrderDetailsCollection(Collection<PurchaseOrderDetails> purchaseOrderDetailsCollection) {
        this.purchaseOrderDetailsCollection = purchaseOrderDetailsCollection;
    }

    @XmlTransient
    public Collection<InventoryTransactions> getInventoryTransactionsCollection() {
        return inventoryTransactionsCollection;
    }

    public void setInventoryTransactionsCollection(Collection<InventoryTransactions> inventoryTransactionsCollection) {
        this.inventoryTransactionsCollection = inventoryTransactionsCollection;
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
        if (!(object instanceof Products)) {
            return false;
        }
        Products other = (Products) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Products[ id=" + id + " ]";
    }
    
}
