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
@Table(name = "orders_status")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrdersStatus.findAll", query = "SELECT o FROM OrdersStatus o"),
    @NamedQuery(name = "OrdersStatus.findById", query = "SELECT o FROM OrdersStatus o WHERE o.id = :id"),
    @NamedQuery(name = "OrdersStatus.findByStatusName", query = "SELECT o FROM OrdersStatus o WHERE o.statusName = :statusName")})
public class OrdersStatus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Short id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "status_name")
    private String statusName;
    @OneToMany(mappedBy = "statusId")
    private Collection<Orders> ordersCollection;

    public OrdersStatus() {
    }

    public OrdersStatus(Short id) {
        this.id = id;
    }

    public OrdersStatus(Short id, String statusName) {
        this.id = id;
        this.statusName = statusName;
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
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
        if (!(object instanceof OrdersStatus)) {
            return false;
        }
        OrdersStatus other = (OrdersStatus) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.OrdersStatus[ id=" + id + " ]";
    }
    
}
