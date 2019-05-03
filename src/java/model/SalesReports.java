/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Darman
 */
@Entity
@Table(name = "sales_reports")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SalesReports.findAll", query = "SELECT s FROM SalesReports s"),
    @NamedQuery(name = "SalesReports.findByGroupBy", query = "SELECT s FROM SalesReports s WHERE s.groupBy = :groupBy"),
    @NamedQuery(name = "SalesReports.findByDisplay", query = "SELECT s FROM SalesReports s WHERE s.display = :display"),
    @NamedQuery(name = "SalesReports.findByTitle", query = "SELECT s FROM SalesReports s WHERE s.title = :title"),
    @NamedQuery(name = "SalesReports.findByDefault1", query = "SELECT s FROM SalesReports s WHERE s.default1 = :default1")})
public class SalesReports implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "group_by")
    private String groupBy;
    @Size(max = 50)
    @Column(name = "display")
    private String display;
    @Size(max = 50)
    @Column(name = "title")
    private String title;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "filter_row_source")
    private String filterRowSource;
    @Basic(optional = false)
    @NotNull
    @Column(name = "default")
    private boolean default1;

    public SalesReports() {
    }

    public SalesReports(String groupBy) {
        this.groupBy = groupBy;
    }

    public SalesReports(String groupBy, boolean default1) {
        this.groupBy = groupBy;
        this.default1 = default1;
    }

    public String getGroupBy() {
        return groupBy;
    }

    public void setGroupBy(String groupBy) {
        this.groupBy = groupBy;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFilterRowSource() {
        return filterRowSource;
    }

    public void setFilterRowSource(String filterRowSource) {
        this.filterRowSource = filterRowSource;
    }

    public boolean getDefault1() {
        return default1;
    }

    public void setDefault1(boolean default1) {
        this.default1 = default1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (groupBy != null ? groupBy.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SalesReports)) {
            return false;
        }
        SalesReports other = (SalesReports) object;
        if ((this.groupBy == null && other.groupBy != null) || (this.groupBy != null && !this.groupBy.equals(other.groupBy))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.SalesReports[ groupBy=" + groupBy + " ]";
    }
    
}
