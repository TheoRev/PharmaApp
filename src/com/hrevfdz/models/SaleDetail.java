/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hrevfdz.models;

import java.io.Serializable;
import java.math.BigInteger;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author theo
 */
@Entity
@Table(name = "sale_detail", catalog = "farmasur", schema = "pharmacy")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SaleDetail.findAll", query = "SELECT s FROM SaleDetail s")
    , @NamedQuery(name = "SaleDetail.findByCodDetail", query = "SELECT s FROM SaleDetail s WHERE s.codDetail = :codDetail")
    , @NamedQuery(name = "SaleDetail.findByCantidad", query = "SELECT s FROM SaleDetail s WHERE s.cantidad = :cantidad")
    , @NamedQuery(name = "SaleDetail.findBySubtotal", query = "SELECT s FROM SaleDetail s WHERE s.subtotal = :subtotal")})
public class SaleDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_detail")
    private Integer codDetail;
    @Basic(optional = false)
    @Column(name = "cantidad")
    private BigInteger cantidad;
    @Column(name = "subtotal")
    private BigInteger subtotal;
    @JoinColumn(name = "cod_sale", referencedColumnName = "codigo")
    @ManyToOne(optional = false)
    private Sale codSale;
    @JoinColumn(name = "cod_stock", referencedColumnName = "cod_stock")
    @ManyToOne(optional = false)
    private StockProducto codStock;

    public SaleDetail() {
    }

    public SaleDetail(Integer codDetail) {
        this.codDetail = codDetail;
    }

    public SaleDetail(Integer codDetail, BigInteger cantidad) {
        this.codDetail = codDetail;
        this.cantidad = cantidad;
    }

    public Integer getCodDetail() {
        return codDetail;
    }

    public void setCodDetail(Integer codDetail) {
        this.codDetail = codDetail;
    }

    public BigInteger getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigInteger cantidad) {
        this.cantidad = cantidad;
    }

    public BigInteger getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigInteger subtotal) {
        this.subtotal = subtotal;
    }

    public Sale getCodSale() {
        return codSale;
    }

    public void setCodSale(Sale codSale) {
        this.codSale = codSale;
    }

    public StockProducto getCodStock() {
        return codStock;
    }

    public void setCodStock(StockProducto codStock) {
        this.codStock = codStock;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codDetail != null ? codDetail.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SaleDetail)) {
            return false;
        }
        SaleDetail other = (SaleDetail) object;
        if ((this.codDetail == null && other.codDetail != null) || (this.codDetail != null && !this.codDetail.equals(other.codDetail))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.hrevfdz.models.SaleDetail[ codDetail=" + codDetail + " ]";
    }
    
}
