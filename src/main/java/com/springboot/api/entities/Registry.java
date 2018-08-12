/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springboot.api.entities;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author andres
 */
@Entity
@Table(name = "REGISTRY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Registry.findAll", query = "SELECT r FROM Registry r")
    , @NamedQuery(name = "Registry.findById", query = "SELECT r FROM Registry r WHERE r.id = :id")
    , @NamedQuery(name = "Registry.findByDolar", query = "SELECT r FROM Registry r WHERE r.dolar = :dolar")
    , @NamedQuery(name = "Registry.findByEuro", query = "SELECT r FROM Registry r WHERE r.euro = :euro")
    , @NamedQuery(name = "Registry.findByFormat", query = "SELECT r FROM Registry r WHERE r.format = :format")})
public class Registry implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @GeneratedValue(strategy=GenerationType.TABLE)
    @Column(name = "ID")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "DOLAR")
    private Double dolar;
    @Column(name = "EURO")
    private Double euro;
    @Size(max = 20)
    @Column(name = "FORMAT")
    private String format;

    public Registry() {
    }
    
    public Registry(double dolar, double euro, String format) {
        this.dolar = dolar;
        this.euro = euro;
        this.format = format;
    }

    public Registry(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getDolar() {
        return dolar;
    }

    public void setDolar(Double dolar) {
        this.dolar = dolar;
    }

    public Double getEuro() {
        return euro;
    }

    public void setEuro(Double euro) {
        this.euro = euro;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
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
        if (!(object instanceof Registry)) {
            return false;
        }
        Registry other = (Registry) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.prueba.belatrix.entities.Registry[ id=" + id + " ]";
    }
    
}
