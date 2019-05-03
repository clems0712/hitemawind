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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Darman
 */
@Entity
@Table(name = "strings")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Strings.findAll", query = "SELECT s FROM Strings s"),
    @NamedQuery(name = "Strings.findByStringId", query = "SELECT s FROM Strings s WHERE s.stringId = :stringId"),
    @NamedQuery(name = "Strings.findByStringData", query = "SELECT s FROM Strings s WHERE s.stringData = :stringData")})
public class Strings implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "string_id")
    private Integer stringId;
    @Size(max = 255)
    @Column(name = "string_data")
    private String stringData;

    public Strings() {
    }

    public Strings(Integer stringId) {
        this.stringId = stringId;
    }

    public Integer getStringId() {
        return stringId;
    }

    public void setStringId(Integer stringId) {
        this.stringId = stringId;
    }

    public String getStringData() {
        return stringData;
    }

    public void setStringData(String stringData) {
        this.stringData = stringData;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stringId != null ? stringId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Strings)) {
            return false;
        }
        Strings other = (Strings) object;
        if ((this.stringId == null && other.stringId != null) || (this.stringId != null && !this.stringId.equals(other.stringId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Strings[ stringId=" + stringId + " ]";
    }
    
}
