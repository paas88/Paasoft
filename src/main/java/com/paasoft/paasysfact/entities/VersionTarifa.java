/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.paasoft.paasysfact.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
 * @author alejandro
 */
@Entity
@Table(name = "version_tarifa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VersionTarifa.findAll", query = "SELECT v FROM VersionTarifa v")
    , @NamedQuery(name = "VersionTarifa.findByIdVersionTarifa", query = "SELECT v FROM VersionTarifa v WHERE v.idVersionTarifa = :idVersionTarifa")
    , @NamedQuery(name = "VersionTarifa.findByNombre", query = "SELECT v FROM VersionTarifa v WHERE v.nombre = :nombre")
    , @NamedQuery(name = "VersionTarifa.findByEstado", query = "SELECT v FROM VersionTarifa v WHERE v.estado = :estado")
    , @NamedQuery(name = "VersionTarifa.findByValidodesde", query = "SELECT v FROM VersionTarifa v WHERE v.validodesde = :validodesde")
    , @NamedQuery(name = "VersionTarifa.findByValidohasta", query = "SELECT v FROM VersionTarifa v WHERE v.validohasta = :validohasta")
    , @NamedQuery(name = "VersionTarifa.findByUsuarioins", query = "SELECT v FROM VersionTarifa v WHERE v.usuarioins = :usuarioins")
    , @NamedQuery(name = "VersionTarifa.findByFechains", query = "SELECT v FROM VersionTarifa v WHERE v.fechains = :fechains")
    , @NamedQuery(name = "VersionTarifa.findByUsuarioupd", query = "SELECT v FROM VersionTarifa v WHERE v.usuarioupd = :usuarioupd")
    , @NamedQuery(name = "VersionTarifa.findByFechaupd", query = "SELECT v FROM VersionTarifa v WHERE v.fechaupd = :fechaupd")})
public class VersionTarifa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_version_tarifa")
    private Integer idVersionTarifa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Lob
    @Size(max = 65535)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado")
    private boolean estado;
    @Column(name = "validodesde")
    @Temporal(TemporalType.DATE)
    private Date validodesde;
    @Column(name = "validohasta")
    @Temporal(TemporalType.DATE)
    private Date validohasta;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idVersionTarifa")
    private List<ProductoPrecio> productoPrecioList;
    @JoinColumn(name = "tarifa_id_tarifa", referencedColumnName = "id_tarifa")
    @ManyToOne(optional = false)
    private Tarifa tarifaIdTarifa;

    public VersionTarifa() {
    }

    public VersionTarifa(Integer idVersionTarifa) {
        this.idVersionTarifa = idVersionTarifa;
    }

    public VersionTarifa(Integer idVersionTarifa, String nombre, boolean estado, String usuarioins, Date fechains) {
        this.idVersionTarifa = idVersionTarifa;
        this.nombre = nombre;
        this.estado = estado;
        this.usuarioins = usuarioins;
        this.fechains = fechains;
    }

    public Integer getIdVersionTarifa() {
        return idVersionTarifa;
    }

    public void setIdVersionTarifa(Integer idVersionTarifa) {
        this.idVersionTarifa = idVersionTarifa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Date getValidodesde() {
        return validodesde;
    }

    public void setValidodesde(Date validodesde) {
        this.validodesde = validodesde;
    }

    public Date getValidohasta() {
        return validohasta;
    }

    public void setValidohasta(Date validohasta) {
        this.validohasta = validohasta;
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

    @XmlTransient
    public List<ProductoPrecio> getProductoPrecioList() {
        return productoPrecioList;
    }

    public void setProductoPrecioList(List<ProductoPrecio> productoPrecioList) {
        this.productoPrecioList = productoPrecioList;
    }

    public Tarifa getTarifaIdTarifa() {
        return tarifaIdTarifa;
    }

    public void setTarifaIdTarifa(Tarifa tarifaIdTarifa) {
        this.tarifaIdTarifa = tarifaIdTarifa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVersionTarifa != null ? idVersionTarifa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VersionTarifa)) {
            return false;
        }
        VersionTarifa other = (VersionTarifa) object;
        if ((this.idVersionTarifa == null && other.idVersionTarifa != null) || (this.idVersionTarifa != null && !this.idVersionTarifa.equals(other.idVersionTarifa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.paasoft.paasysfact.entities.VersionTarifa[ idVersionTarifa=" + idVersionTarifa + " ]";
    }
    
}
