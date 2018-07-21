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
@Table(name = "categoria_tercero")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CategoriaTercero.findAll", query = "SELECT c FROM CategoriaTercero c")
    , @NamedQuery(name = "CategoriaTercero.findByIdCategoriaTercero", query = "SELECT c FROM CategoriaTercero c WHERE c.idCategoriaTercero = :idCategoriaTercero")
    , @NamedQuery(name = "CategoriaTercero.findByNombre", query = "SELECT c FROM CategoriaTercero c WHERE c.nombre = :nombre")
    , @NamedQuery(name = "CategoriaTercero.findByEstado", query = "SELECT c FROM CategoriaTercero c WHERE c.estado = :estado")
    , @NamedQuery(name = "CategoriaTercero.findByUsuarioins", query = "SELECT c FROM CategoriaTercero c WHERE c.usuarioins = :usuarioins")
    , @NamedQuery(name = "CategoriaTercero.findByFechains", query = "SELECT c FROM CategoriaTercero c WHERE c.fechains = :fechains")
    , @NamedQuery(name = "CategoriaTercero.findByUsuarioupd", query = "SELECT c FROM CategoriaTercero c WHERE c.usuarioupd = :usuarioupd")
    , @NamedQuery(name = "CategoriaTercero.findByFechaupd", query = "SELECT c FROM CategoriaTercero c WHERE c.fechaupd = :fechaupd")})
public class CategoriaTercero implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_categoria_tercero")
    private Integer idCategoriaTercero;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCategoriaTercero")
    private List<Tercero> terceroList;

    public CategoriaTercero() {
    }

    public CategoriaTercero(Integer idCategoriaTercero) {
        this.idCategoriaTercero = idCategoriaTercero;
    }

    public CategoriaTercero(Integer idCategoriaTercero, String nombre, boolean estado, String usuarioins, Date fechains) {
        this.idCategoriaTercero = idCategoriaTercero;
        this.nombre = nombre;
        this.estado = estado;
        this.usuarioins = usuarioins;
        this.fechains = fechains;
    }

    public Integer getIdCategoriaTercero() {
        return idCategoriaTercero;
    }

    public void setIdCategoriaTercero(Integer idCategoriaTercero) {
        this.idCategoriaTercero = idCategoriaTercero;
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
    public List<Tercero> getTerceroList() {
        return terceroList;
    }

    public void setTerceroList(List<Tercero> terceroList) {
        this.terceroList = terceroList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCategoriaTercero != null ? idCategoriaTercero.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CategoriaTercero)) {
            return false;
        }
        CategoriaTercero other = (CategoriaTercero) object;
        if ((this.idCategoriaTercero == null && other.idCategoriaTercero != null) || (this.idCategoriaTercero != null && !this.idCategoriaTercero.equals(other.idCategoriaTercero))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.paasoft.paasysfact.entities.CategoriaTercero[ idCategoriaTercero=" + idCategoriaTercero + " ]";
    }
    
}
