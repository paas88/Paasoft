/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.paasoft.paasysfact.entities;

import java.io.Serializable;
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
@Table(name = "tercero_direccion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TerceroDireccion.findAll", query = "SELECT t FROM TerceroDireccion t")
    , @NamedQuery(name = "TerceroDireccion.findByIdTerceroDireccion", query = "SELECT t FROM TerceroDireccion t WHERE t.idTerceroDireccion = :idTerceroDireccion")
    , @NamedQuery(name = "TerceroDireccion.findByNombre", query = "SELECT t FROM TerceroDireccion t WHERE t.nombre = :nombre")
    , @NamedQuery(name = "TerceroDireccion.findByTelefono", query = "SELECT t FROM TerceroDireccion t WHERE t.telefono = :telefono")
    , @NamedQuery(name = "TerceroDireccion.findByCelular", query = "SELECT t FROM TerceroDireccion t WHERE t.celular = :celular")
    , @NamedQuery(name = "TerceroDireccion.findByEstado", query = "SELECT t FROM TerceroDireccion t WHERE t.estado = :estado")
    , @NamedQuery(name = "TerceroDireccion.findByUsuarioins", query = "SELECT t FROM TerceroDireccion t WHERE t.usuarioins = :usuarioins")
    , @NamedQuery(name = "TerceroDireccion.findByFechains", query = "SELECT t FROM TerceroDireccion t WHERE t.fechains = :fechains")
    , @NamedQuery(name = "TerceroDireccion.findByUsuarioupd", query = "SELECT t FROM TerceroDireccion t WHERE t.usuarioupd = :usuarioupd")
    , @NamedQuery(name = "TerceroDireccion.findByFechaupd", query = "SELECT t FROM TerceroDireccion t WHERE t.fechaupd = :fechaupd")})
public class TerceroDireccion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tercero_direccion")
    private Integer idTerceroDireccion;
    @Size(max = 60)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 30)
    @Column(name = "telefono")
    private String telefono;
    @Size(max = 30)
    @Column(name = "celular")
    private String celular;
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
    @Size(max = 45)
    @Column(name = "fechaupd")
    private String fechaupd;
    @JoinColumn(name = "idciudad", referencedColumnName = "id_ciudad")
    @ManyToOne(optional = false)
    private Ciudad idciudad;
    @JoinColumn(name = "id_tercero", referencedColumnName = "id_tercero")
    @ManyToOne(optional = false)
    private Tercero idTercero;

    public TerceroDireccion() {
    }

    public TerceroDireccion(Integer idTerceroDireccion) {
        this.idTerceroDireccion = idTerceroDireccion;
    }

    public TerceroDireccion(Integer idTerceroDireccion, boolean estado, String usuarioins, Date fechains) {
        this.idTerceroDireccion = idTerceroDireccion;
        this.estado = estado;
        this.usuarioins = usuarioins;
        this.fechains = fechains;
    }

    public Integer getIdTerceroDireccion() {
        return idTerceroDireccion;
    }

    public void setIdTerceroDireccion(Integer idTerceroDireccion) {
        this.idTerceroDireccion = idTerceroDireccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
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

    public String getFechaupd() {
        return fechaupd;
    }

    public void setFechaupd(String fechaupd) {
        this.fechaupd = fechaupd;
    }

    public Ciudad getIdciudad() {
        return idciudad;
    }

    public void setIdciudad(Ciudad idciudad) {
        this.idciudad = idciudad;
    }

    public Tercero getIdTercero() {
        return idTercero;
    }

    public void setIdTercero(Tercero idTercero) {
        this.idTercero = idTercero;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTerceroDireccion != null ? idTerceroDireccion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TerceroDireccion)) {
            return false;
        }
        TerceroDireccion other = (TerceroDireccion) object;
        if ((this.idTerceroDireccion == null && other.idTerceroDireccion != null) || (this.idTerceroDireccion != null && !this.idTerceroDireccion.equals(other.idTerceroDireccion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.paasoft.paasysfact.entities.TerceroDireccion[ idTerceroDireccion=" + idTerceroDireccion + " ]";
    }
    
}
