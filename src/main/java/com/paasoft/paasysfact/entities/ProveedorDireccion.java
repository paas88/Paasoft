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
@Table(name = "proveedor_direccion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProveedorDireccion.findAll", query = "SELECT p FROM ProveedorDireccion p")
    , @NamedQuery(name = "ProveedorDireccion.findByIdproveedorDireccion", query = "SELECT p FROM ProveedorDireccion p WHERE p.idproveedorDireccion = :idproveedorDireccion")
    , @NamedQuery(name = "ProveedorDireccion.findByNombre", query = "SELECT p FROM ProveedorDireccion p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "ProveedorDireccion.findByTelefono", query = "SELECT p FROM ProveedorDireccion p WHERE p.telefono = :telefono")
    , @NamedQuery(name = "ProveedorDireccion.findByCelular", query = "SELECT p FROM ProveedorDireccion p WHERE p.celular = :celular")
    , @NamedQuery(name = "ProveedorDireccion.findByEstado", query = "SELECT p FROM ProveedorDireccion p WHERE p.estado = :estado")
    , @NamedQuery(name = "ProveedorDireccion.findByUsuarioins", query = "SELECT p FROM ProveedorDireccion p WHERE p.usuarioins = :usuarioins")
    , @NamedQuery(name = "ProveedorDireccion.findByFechains", query = "SELECT p FROM ProveedorDireccion p WHERE p.fechains = :fechains")
    , @NamedQuery(name = "ProveedorDireccion.findByUsuarioupd", query = "SELECT p FROM ProveedorDireccion p WHERE p.usuarioupd = :usuarioupd")
    , @NamedQuery(name = "ProveedorDireccion.findByFechaupd", query = "SELECT p FROM ProveedorDireccion p WHERE p.fechaupd = :fechaupd")})
public class ProveedorDireccion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idproveedor_direccion")
    private Integer idproveedorDireccion;
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
    @JoinColumn(name = "idciudad", referencedColumnName = "idciudad")
    @ManyToOne(optional = false)
    private Ciudad idciudad;
    @JoinColumn(name = "proveedor_proveedor", referencedColumnName = "idproveedor")
    @ManyToOne(optional = false)
    private Proveedor proveedorProveedor;

    public ProveedorDireccion() {
    }

    public ProveedorDireccion(Integer idproveedorDireccion) {
        this.idproveedorDireccion = idproveedorDireccion;
    }

    public ProveedorDireccion(Integer idproveedorDireccion, boolean estado, String usuarioins, Date fechains) {
        this.idproveedorDireccion = idproveedorDireccion;
        this.estado = estado;
        this.usuarioins = usuarioins;
        this.fechains = fechains;
    }

    public Integer getIdproveedorDireccion() {
        return idproveedorDireccion;
    }

    public void setIdproveedorDireccion(Integer idproveedorDireccion) {
        this.idproveedorDireccion = idproveedorDireccion;
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

    public Proveedor getProveedorProveedor() {
        return proveedorProveedor;
    }

    public void setProveedorProveedor(Proveedor proveedorProveedor) {
        this.proveedorProveedor = proveedorProveedor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idproveedorDireccion != null ? idproveedorDireccion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProveedorDireccion)) {
            return false;
        }
        ProveedorDireccion other = (ProveedorDireccion) object;
        if ((this.idproveedorDireccion == null && other.idproveedorDireccion != null) || (this.idproveedorDireccion != null && !this.idproveedorDireccion.equals(other.idproveedorDireccion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.paasoft.paasysfact.entities.ProveedorDireccion[ idproveedorDireccion=" + idproveedorDireccion + " ]";
    }
    
}
