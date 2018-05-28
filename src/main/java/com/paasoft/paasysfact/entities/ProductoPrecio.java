/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.paasoft.paasysfact.entities;

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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author alejandro
 */
@Entity
@Table(name = "producto_precio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductoPrecio.findAll", query = "SELECT p FROM ProductoPrecio p")
    , @NamedQuery(name = "ProductoPrecio.findByProductoPrecioId", query = "SELECT p FROM ProductoPrecio p WHERE p.productoPrecioId = :productoPrecioId")
    , @NamedQuery(name = "ProductoPrecio.findByPrecioLista", query = "SELECT p FROM ProductoPrecio p WHERE p.precioLista = :precioLista")
    , @NamedQuery(name = "ProductoPrecio.findByPrecioGeneral", query = "SELECT p FROM ProductoPrecio p WHERE p.precioGeneral = :precioGeneral")
    , @NamedQuery(name = "ProductoPrecio.findByUsuarioins", query = "SELECT p FROM ProductoPrecio p WHERE p.usuarioins = :usuarioins")
    , @NamedQuery(name = "ProductoPrecio.findByFechains", query = "SELECT p FROM ProductoPrecio p WHERE p.fechains = :fechains")
    , @NamedQuery(name = "ProductoPrecio.findByUsuarioupd", query = "SELECT p FROM ProductoPrecio p WHERE p.usuarioupd = :usuarioupd")
    , @NamedQuery(name = "ProductoPrecio.findByFechaupd", query = "SELECT p FROM ProductoPrecio p WHERE p.fechaupd = :fechaupd")})
public class ProductoPrecio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "producto_precio_id")
    private Integer productoPrecioId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "precio_lista")
    private BigDecimal precioLista;
    @Column(name = "precio_general")
    private BigDecimal precioGeneral;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "usuarioins")
    private String usuarioins;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechains")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechains;
    @Size(max = 30)
    @Column(name = "usuarioupd")
    private String usuarioupd;
    @Column(name = "fechaupd")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaupd;
    @JoinColumn(name = "idproducto", referencedColumnName = "idproducto")
    @ManyToOne(optional = false)
    private Producto idproducto;
    @JoinColumn(name = "idversion_tarifa", referencedColumnName = "idversion_tarifa")
    @ManyToOne(optional = false)
    private VersionTarifa idversionTarifa;

    public ProductoPrecio() {
    }

    public ProductoPrecio(Integer productoPrecioId) {
        this.productoPrecioId = productoPrecioId;
    }

    public ProductoPrecio(Integer productoPrecioId, String usuarioins, Date fechains) {
        this.productoPrecioId = productoPrecioId;
        this.usuarioins = usuarioins;
        this.fechains = fechains;
    }

    public Integer getProductoPrecioId() {
        return productoPrecioId;
    }

    public void setProductoPrecioId(Integer productoPrecioId) {
        this.productoPrecioId = productoPrecioId;
    }

    public BigDecimal getPrecioLista() {
        return precioLista;
    }

    public void setPrecioLista(BigDecimal precioLista) {
        this.precioLista = precioLista;
    }

    public BigDecimal getPrecioGeneral() {
        return precioGeneral;
    }

    public void setPrecioGeneral(BigDecimal precioGeneral) {
        this.precioGeneral = precioGeneral;
    }

    public String getUsuarioins() {
        return usuarioins;
    }

    public void setUsuarioins(String usuarioins) {
        this.usuarioins = usuarioins;
    }

    public Date getFechains() {
        return fechains;
    }

    public void setFechains(Date fechains) {
        this.fechains = fechains;
    }

    public String getUsuarioupd() {
        return usuarioupd;
    }

    public void setUsuarioupd(String usuarioupd) {
        this.usuarioupd = usuarioupd;
    }

    public Date getFechaupd() {
        return fechaupd;
    }

    public void setFechaupd(Date fechaupd) {
        this.fechaupd = fechaupd;
    }

    public Producto getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(Producto idproducto) {
        this.idproducto = idproducto;
    }

    public VersionTarifa getIdversionTarifa() {
        return idversionTarifa;
    }

    public void setIdversionTarifa(VersionTarifa idversionTarifa) {
        this.idversionTarifa = idversionTarifa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productoPrecioId != null ? productoPrecioId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductoPrecio)) {
            return false;
        }
        ProductoPrecio other = (ProductoPrecio) object;
        if ((this.productoPrecioId == null && other.productoPrecioId != null) || (this.productoPrecioId != null && !this.productoPrecioId.equals(other.productoPrecioId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.paasoft.paasysfact.entities.ProductoPrecio[ productoPrecioId=" + productoPrecioId + " ]";
    }
    
}
