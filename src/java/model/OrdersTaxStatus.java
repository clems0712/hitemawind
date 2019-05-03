/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "orders_tax_status")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrdersTaxStatus.findAll", query = "SELECT o FROM OrdersTaxStatus o"),
    @NamedQuery(name = "OrdersTaxStatus.findById", query = "SELECT o FROM OrdersTaxStatus o WHERE o.id = :id"),
    @NamedQuery(name = "OrdersTaxStatus.findByTaxStatusName", query = "SELECT o FROM OrdersTaxStatus o WHERE o.taxStatusName = :taxStatusName")})
public class OrdersTaxStatus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Short id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "tax_status_name")
    private String taxStatusName;
    @OneToMany(mappedBy = "taxStatusId")
    private Collection<Orders> ordersCollection;

    public OrdersTaxStatus() {
    }

    public OrdersTaxStatus(Short id) {
        this.id = id;
    }

    public OrdersTaxStatus(Short id, String taxStatusName) {
        this.id = id;
        this.taxStatusName = taxStatusName;
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getTaxStatusName() {
        return taxStatusName;
    }

    public void setTaxStatusName(String taxStatusName) {
        this.taxStatusName = taxStatusName;
    }

    @XmlTransient
    public Collection<Orders> getOrdersCollection() {
        return ordersCollection;
    }

    public void setOrdersCollection(Collection<Orders> ordersCollection) {
        this.ordersCollection = ordersCollection;
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
        if (!(object instanceof OrdersTaxStatus)) {
            return false;
        }
        OrdersTaxStatus other = (OrdersTaxStatus) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.OrdersTaxStatus[ id=" + id + " ]";
    }
    
}
