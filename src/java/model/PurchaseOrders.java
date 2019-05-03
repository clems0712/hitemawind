/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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
@Table(name = "purchase_orders")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PurchaseOrders.findAll", query = "SELECT p FROM PurchaseOrders p"),
    @NamedQuery(name = "PurchaseOrders.findById", query = "SELECT p FROM PurchaseOrders p WHERE p.id = :id"),
    @NamedQuery(name = "PurchaseOrders.findBySubmittedDate", query = "SELECT p FROM PurchaseOrders p WHERE p.submittedDate = :submittedDate"),
    @NamedQuery(name = "PurchaseOrders.findByCreationDate", query = "SELECT p FROM PurchaseOrders p WHERE p.creationDate = :creationDate"),
    @NamedQuery(name = "PurchaseOrders.findByExpectedDate", query = "SELECT p FROM PurchaseOrders p WHERE p.expectedDate = :expectedDate"),
    @NamedQuery(name = "PurchaseOrders.findByShippingFee", query = "SELECT p FROM PurchaseOrders p WHERE p.shippingFee = :shippingFee"),
    @NamedQuery(name = "PurchaseOrders.findByTaxes", query = "SELECT p FROM PurchaseOrders p WHERE p.taxes = :taxes"),
    @NamedQuery(name = "PurchaseOrders.findByPaymentDate", query = "SELECT p FROM PurchaseOrders p WHERE p.paymentDate = :paymentDate"),
    @NamedQuery(name = "PurchaseOrders.findByPaymentAmount", query = "SELECT p FROM PurchaseOrders p WHERE p.paymentAmount = :paymentAmount"),
    @NamedQuery(name = "PurchaseOrders.findByPaymentMethod", query = "SELECT p FROM PurchaseOrders p WHERE p.paymentMethod = :paymentMethod"),
    @NamedQuery(name = "PurchaseOrders.findByApprovedBy", query = "SELECT p FROM PurchaseOrders p WHERE p.approvedBy = :approvedBy"),
    @NamedQuery(name = "PurchaseOrders.findByApprovedDate", query = "SELECT p FROM PurchaseOrders p WHERE p.approvedDate = :approvedDate"),
    @NamedQuery(name = "PurchaseOrders.findBySubmittedBy", query = "SELECT p FROM PurchaseOrders p WHERE p.submittedBy = :submittedBy")})
public class PurchaseOrders implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "submitted_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date submittedDate;
    @Column(name = "creation_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;
    @Column(name = "expected_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date expectedDate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "shipping_fee")
    private BigDecimal shippingFee;
    @Basic(optional = false)
    @NotNull
    @Column(name = "taxes")
    private BigDecimal taxes;
    @Column(name = "payment_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date paymentDate;
    @Column(name = "payment_amount")
    private BigDecimal paymentAmount;
    @Size(max = 50)
    @Column(name = "payment_method")
    private String paymentMethod;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "notes")
    private String notes;
    @Column(name = "approved_by")
    private Integer approvedBy;
    @Column(name = "approved_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date approvedDate;
    @Column(name = "submitted_by")
    private Integer submittedBy;
    @JoinColumn(name = "created_by", referencedColumnName = "id")
    @ManyToOne
    private Employees createdBy;
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    @ManyToOne
    private PurchaseOrderStatus statusId;
    @JoinColumn(name = "supplier_id", referencedColumnName = "id")
    @ManyToOne
    private Suppliers supplierId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "purchaseOrderId")
    private Collection<PurchaseOrderDetails> purchaseOrderDetailsCollection;
    @OneToMany(mappedBy = "purchaseOrderId")
    private Collection<InventoryTransactions> inventoryTransactionsCollection;

    public PurchaseOrders() {
    }

    public PurchaseOrders(Integer id) {
        this.id = id;
    }

    public PurchaseOrders(Integer id, BigDecimal shippingFee, BigDecimal taxes) {
        this.id = id;
        this.shippingFee = shippingFee;
        this.taxes = taxes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getSubmittedDate() {
        return submittedDate;
    }

    public void setSubmittedDate(Date submittedDate) {
        this.submittedDate = submittedDate;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getExpectedDate() {
        return expectedDate;
    }

    public void setExpectedDate(Date expectedDate) {
        this.expectedDate = expectedDate;
    }

    public BigDecimal getShippingFee() {
        return shippingFee;
    }

    public void setShippingFee(BigDecimal shippingFee) {
        this.shippingFee = shippingFee;
    }

    public BigDecimal getTaxes() {
        return taxes;
    }

    public void setTaxes(BigDecimal taxes) {
        this.taxes = taxes;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public BigDecimal getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(BigDecimal paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Integer getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(Integer approvedBy) {
        this.approvedBy = approvedBy;
    }

    public Date getApprovedDate() {
        return approvedDate;
    }

    public void setApprovedDate(Date approvedDate) {
        this.approvedDate = approvedDate;
    }

    public Integer getSubmittedBy() {
        return submittedBy;
    }

    public void setSubmittedBy(Integer submittedBy) {
        this.submittedBy = submittedBy;
    }

    public Employees getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Employees createdBy) {
        this.createdBy = createdBy;
    }

    public PurchaseOrderStatus getStatusId() {
        return statusId;
    }

    public void setStatusId(PurchaseOrderStatus statusId) {
        this.statusId = statusId;
    }

    public Suppliers getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Suppliers supplierId) {
        this.supplierId = supplierId;
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
        if (!(object instanceof PurchaseOrders)) {
            return false;
        }
        PurchaseOrders other = (PurchaseOrders) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.PurchaseOrders[ id=" + id + " ]";
    }
    
}
