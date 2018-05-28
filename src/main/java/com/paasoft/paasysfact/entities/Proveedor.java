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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "proveedor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proveedor.findAll", query = "SELECT p FROM Proveedor p")
    , @NamedQuery(name = "Proveedor.findByIdproveedor", query = "SELECT p FROM Proveedor p WHERE p.idproveedor = :idproveedor")
    , @NamedQuery(name = "Proveedor.findByNombre", query = "SELECT p FROM Proveedor p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "Proveedor.findByNumeroDocumento", query = "SELECT p FROM Proveedor p WHERE p.numeroDocumento = :numeroDocumento")
    , @NamedQuery(name = "Proveedor.findByUrl", query = "SELECT p FROM Proveedor p WHERE p.url = :url")
    , @NamedQuery(name = "Proveedor.findByEmail", query = "SELECT p FROM Proveedor p WHERE p.email = :email")
    , @NamedQuery(name = "Proveedor.findByEstado", query = "SELECT p FROM Proveedor p WHERE p.estado = :estado")
    , @NamedQuery(name = "Proveedor.findByUsuarioins", query = "SELECT p FROM Proveedor p WHERE p.usuarioins = :usuarioins")
    , @NamedQuery(name = "Proveedor.findByFechains", query = "SELECT p FROM Proveedor p WHERE p.fechains = :fechains")
    , @NamedQuery(name = "Proveedor.findByUsuarioupd", query = "SELECT p FROM Proveedor p WHERE p.usuarioupd = :usuarioupd")
    , @NamedQuery(name = "Proveedor.findByFechaupd", query = "SELECT p FROM Proveedor p WHERE p.fechaupd = :fechaupd")})
public class Proveedor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idproveedor")
    private Integer idproveedor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "numero_documento")
    private String numeroDocumento;
    @Size(max = 45)
    @Column(name = "url")
    private String url;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 45)
    @Column(name = "email")
    private String email;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "proveedorProveedor")
    private List<ProveedorDireccion> proveedorDireccionList;
    @JoinColumn(name = "idclasificacion", referencedColumnName = "idclasificacion")
    @ManyToOne(optional = false)
    private Clasificacion idclasificacion;
    @JoinColumn(name = "idtipo_documento", referencedColumnName = "idtipo_documento")
    @ManyToOne(optional = false)
    private TipoDocumento idtipoDocumento;

    public Proveedor() {
    }

    public Proveedor(Integer idproveedor) {
        this.idproveedor = idproveedor;
    }

    public Proveedor(Integer idproveedor, String nombre, String numeroDocumento, boolean estado, String usuarioins, Date fechains) {
        this.idproveedor = idproveedor;
        this.nombre = nombre;
        this.numeroDocumento = numeroDocumento;
        this.estado = estado;
        this.usuarioins = usuarioins;
        this.fechains = fechains;
    }

    public Integer getIdproveedor() {
        return idproveedor;
    }

    public void setIdproveedor(Integer idproveedor) {
        this.idproveedor = idproveedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
    public List<ProveedorDireccion> getProveedorDireccionList() {
        return proveedorDireccionList;
    }

    public void setProveedorDireccionList(List<ProveedorDireccion> proveedorDireccionList) {
        this.proveedorDireccionList = proveedorDireccionList;
    }

    public Clasificacion getIdclasificacion() {
        return idclasificacion;
    }

    public void setIdclasificacion(Clasificacion idclasificacion) {
        this.idclasificacion = idclasificacion;
    }

    public TipoDocumento getIdtipoDocumento() {
        return idtipoDocumento;
    }

    public void setIdtipoDocumento(TipoDocumento idtipoDocumento) {
        this.idtipoDocumento = idtipoDocumento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idproveedor != null ? idproveedor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proveedor)) {
            return false;
        }
        Proveedor other = (Proveedor) object;
        if ((this.idproveedor == null && other.idproveedor != null) || (this.idproveedor != null && !this.idproveedor.equals(other.idproveedor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.paasoft.paasysfact.entities.Proveedor[ idproveedor=" + idproveedor + " ]";
    }
    
}
