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
import javax.persistence.Lob;
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
@Table(name = "unidad_medida")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UnidadMedida.findAll", query = "SELECT u FROM UnidadMedida u")
    , @NamedQuery(name = "UnidadMedida.findByIdunidadMedida", query = "SELECT u FROM UnidadMedida u WHERE u.idunidadMedida = :idunidadMedida")
    , @NamedQuery(name = "UnidadMedida.findByNombre", query = "SELECT u FROM UnidadMedida u WHERE u.nombre = :nombre")
    , @NamedQuery(name = "UnidadMedida.findByEstado", query = "SELECT u FROM UnidadMedida u WHERE u.estado = :estado")
    , @NamedQuery(name = "UnidadMedida.findByUsuarioins", query = "SELECT u FROM UnidadMedida u WHERE u.usuarioins = :usuarioins")
    , @NamedQuery(name = "UnidadMedida.findByFechains", query = "SELECT u FROM UnidadMedida u WHERE u.fechains = :fechains")
    , @NamedQuery(name = "UnidadMedida.findByUsuarioupd", query = "SELECT u FROM UnidadMedida u WHERE u.usuarioupd = :usuarioupd")
    , @NamedQuery(name = "UnidadMedida.findByFechaupd", query = "SELECT u FROM UnidadMedida u WHERE u.fechaupd = :fechaupd")})
public class UnidadMedida implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idunidad_medida")
    private Integer idunidadMedida;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idunidadMedida")
    private List<Producto> productoList;

    public UnidadMedida() {
    }

    public UnidadMedida(Integer idunidadMedida) {
        this.idunidadMedida = idunidadMedida;
    }

    public UnidadMedida(Integer idunidadMedida, String nombre, boolean estado, String usuarioins, Date fechains) {
        this.idunidadMedida = idunidadMedida;
        this.nombre = nombre;
        this.estado = estado;
        this.usuarioins = usuarioins;
        this.fechains = fechains;
    }

    public Integer getIdunidadMedida() {
        return idunidadMedida;
    }

    public void setIdunidadMedida(Integer idunidadMedida) {
        this.idunidadMedida = idunidadMedida;
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
    public List<Producto> getProductoList() {
        return productoList;
    }

    public void setProductoList(List<Producto> productoList) {
        this.productoList = productoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idunidadMedida != null ? idunidadMedida.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UnidadMedida)) {
            return false;
        }
        UnidadMedida other = (UnidadMedida) object;
        if ((this.idunidadMedida == null && other.idunidadMedida != null) || (this.idunidadMedida != null && !this.idunidadMedida.equals(other.idunidadMedida))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.paasoft.paasysfact.entities.UnidadMedida[ idunidadMedida=" + idunidadMedida + " ]";
    }
    
}
