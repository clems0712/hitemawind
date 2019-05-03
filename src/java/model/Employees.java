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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Darman
 */
@Entity
@Table(name = "employees")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Employees.findAll", query = "SELECT e FROM Employees e"),
    @NamedQuery(name = "Employees.findById", query = "SELECT e FROM Employees e WHERE e.id = :id"),
    @NamedQuery(name = "Employees.findByCompany", query = "SELECT e FROM Employees e WHERE e.company = :company"),
    @NamedQuery(name = "Employees.findByLastName", query = "SELECT e FROM Employees e WHERE e.lastName = :lastName"),
    @NamedQuery(name = "Employees.findByFirstName", query = "SELECT e FROM Employees e WHERE e.firstName = :firstName"),
    @NamedQuery(name = "Employees.findByEmailAddress", query = "SELECT e FROM Employees e WHERE e.emailAddress = :emailAddress"),
    @NamedQuery(name = "Employees.findByJobTitle", query = "SELECT e FROM Employees e WHERE e.jobTitle = :jobTitle"),
    @NamedQuery(name = "Employees.findByBusinessPhone", query = "SELECT e FROM Employees e WHERE e.businessPhone = :businessPhone"),
    @NamedQuery(name = "Employees.findByHomePhone", query = "SELECT e FROM Employees e WHERE e.homePhone = :homePhone"),
    @NamedQuery(name = "Employees.findByMobilePhone", query = "SELECT e FROM Employees e WHERE e.mobilePhone = :mobilePhone"),
    @NamedQuery(name = "Employees.findByFaxNumber", query = "SELECT e FROM Employees e WHERE e.faxNumber = :faxNumber"),
    @NamedQuery(name = "Employees.findByCity", query = "SELECT e FROM Employees e WHERE e.city = :city"),
    @NamedQuery(name = "Employees.findByStateProvince", query = "SELECT e FROM Employees e WHERE e.stateProvince = :stateProvince"),
    @NamedQuery(name = "Employees.findByZipPostalCode", query = "SELECT e FROM Employees e WHERE e.zipPostalCode = :zipPostalCode"),
    @NamedQuery(name = "Employees.findByCountryRegion", query = "SELECT e FROM Employees e WHERE e.countryRegion = :countryRegion")})
public class Employees implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 50)
    @Column(name = "company")
    private String company;
    @Size(max = 50)
    @Column(name = "last_name")
    private String lastName;
    @Size(max = 50)
    @Column(name = "first_name")
    private String firstName;
    @Size(max = 50)
    @Column(name = "email_address")
    private String emailAddress;
    @Size(max = 50)
    @Column(name = "job_title")
    private String jobTitle;
    @Size(max = 25)
    @Column(name = "business_phone")
    private String businessPhone;
    @Size(max = 25)
    @Column(name = "home_phone")
    private String homePhone;
    @Size(max = 25)
    @Column(name = "mobile_phone")
    private String mobilePhone;
    @Size(max = 25)
    @Column(name = "fax_number")
    private String faxNumber;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "address")
    private String address;
    @Size(max = 50)
    @Column(name = "city")
    private String city;
    @Size(max = 50)
    @Column(name = "state_province")
    private String stateProvince;
    @Size(max = 15)
    @Column(name = "zip_postal_code")
    private String zipPostalCode;
    @Size(max = 50)
    @Column(name = "country_region")
    private String countryRegion;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "web_page")
    private String webPage;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "notes")
    private String notes;
    @Lob
    @Column(name = "attachments")
    private byte[] attachments;
    @JoinTable(name = "employee_privileges", joinColumns = {
        @JoinColumn(name = "employee_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "privilege_id", referencedColumnName = "id")})
    @ManyToMany
    private Collection<Privileges> privilegesCollection;
    @OneToMany(mappedBy = "createdBy")
    private Collection<PurchaseOrders> purchaseOrdersCollection;
    @OneToMany(mappedBy = "employeeId")
    private Collection<Orders> ordersCollection;

    public Employees() {
    }

    public Employees(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getBusinessPhone() {
        return businessPhone;
    }

    public void setBusinessPhone(String businessPhone) {
        this.businessPhone = businessPhone;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getFaxNumber() {
        return faxNumber;
    }

    public void setFaxNumber(String faxNumber) {
        this.faxNumber = faxNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStateProvince() {
        return stateProvince;
    }

    public void setStateProvince(String stateProvince) {
        this.stateProvince = stateProvince;
    }

    public String getZipPostalCode() {
        return zipPostalCode;
    }

    public void setZipPostalCode(String zipPostalCode) {
        this.zipPostalCode = zipPostalCode;
    }

    public String getCountryRegion() {
        return countryRegion;
    }

    public void setCountryRegion(String countryRegion) {
        this.countryRegion = countryRegion;
    }

    public String getWebPage() {
        return webPage;
    }

    public void setWebPage(String webPage) {
        this.webPage = webPage;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public byte[] getAttachments() {
        return attachments;
    }

    public void setAttachments(byte[] attachments) {
        this.attachments = attachments;
    }

    @XmlTransient
    public Collection<Privileges> getPrivilegesCollection() {
        return privilegesCollection;
    }

    public void setPrivilegesCollection(Collection<Privileges> privilegesCollection) {
        this.privilegesCollection = privilegesCollection;
    }

    @XmlTransient
    public Collection<PurchaseOrders> getPurchaseOrdersCollection() {
        return purchaseOrdersCollection;
    }

    public void setPurchaseOrdersCollection(Collection<PurchaseOrders> purchaseOrdersCollection) {
        this.purchaseOrdersCollection = purchaseOrdersCollection;
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
        if (!(object instanceof Employees)) {
            return false;
        }
        Employees other = (Employees) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Employees[ id=" + id + " ]";
    }
    
}
