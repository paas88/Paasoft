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
@Table(name = "tercero")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tercero.findAll", query = "SELECT t FROM Tercero t")
    , @NamedQuery(name = "Tercero.findByIdTercero", query = "SELECT t FROM Tercero t WHERE t.idTercero = :idTercero")
    , @NamedQuery(name = "Tercero.findByNombre", query = "SELECT t FROM Tercero t WHERE t.nombre = :nombre")
    , @NamedQuery(name = "Tercero.findByNumeroDocumento", query = "SELECT t FROM Tercero t WHERE t.numeroDocumento = :numeroDocumento")
    , @NamedQuery(name = "Tercero.findByUrl", query = "SELECT t FROM Tercero t WHERE t.url = :url")
    , @NamedQuery(name = "Tercero.findByEmail", query = "SELECT t FROM Tercero t WHERE t.email = :email")
    , @NamedQuery(name = "Tercero.findByEstado", query = "SELECT t FROM Tercero t WHERE t.estado = :estado")
    , @NamedQuery(name = "Tercero.findByUsuarioins", query = "SELECT t FROM Tercero t WHERE t.usuarioins = :usuarioins")
    , @NamedQuery(name = "Tercero.findByFechains", query = "SELECT t FROM Tercero t WHERE t.fechains = :fechains")
    , @NamedQuery(name = "Tercero.findByUsuarioupd", query = "SELECT t FROM Tercero t WHERE t.usuarioupd = :usuarioupd")
    , @NamedQuery(name = "Tercero.findByFechaupd", query = "SELECT t FROM Tercero t WHERE t.fechaupd = :fechaupd")
    , @NamedQuery(name = "Tercero.findByCliente", query = "SELECT t FROM Tercero t WHERE t.cliente = :cliente")
    , @NamedQuery(name = "Tercero.findByProveedor", query = "SELECT t FROM Tercero t WHERE t.proveedor = :proveedor")
    , @NamedQuery(name = "Tercero.findByFuncionario", query = "SELECT t FROM Tercero t WHERE t.funcionario = :funcionario")})
public class Tercero implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_tercero")
    private Integer idTercero;
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
    @Column(name = "cliente")
    private Boolean cliente;
    @Column(name = "proveedor")
    private Boolean proveedor;
    @Column(name = "funcionario")
    private Boolean funcionario;
    @JoinColumn(name = "id_categoria_tercero", referencedColumnName = "id_categoria_tercero")
    @ManyToOne(optional = false)
    private CategoriaTercero idCategoriaTercero;
    @JoinColumn(name = "id_tipo_documento", referencedColumnName = "id_tipo_documento")
    @ManyToOne(optional = false)
    private TipoDocumento idTipoDocumento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTercero")
    private List<TerceroDireccion> terceroDireccionList;

    public Tercero() {
    }

    public Tercero(Integer idTercero) {
        this.idTercero = idTercero;
    }

    public Tercero(Integer idTercero, String nombre, String numeroDocumento, boolean estado, String usuarioins, Date fechains) {
        this.idTercero = idTercero;
        this.nombre = nombre;
        this.numeroDocumento = numeroDocumento;
        this.estado = estado;
        this.usuarioins = usuarioins;
        this.fechains = fechains;
    }

    public Integer getIdTercero() {
        return idTercero;
    }

    public void setIdTercero(Integer idTercero) {
        this.idTercero = idTercero;
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

    public Boolean getCliente() {
        return cliente;
    }

    public void setCliente(Boolean cliente) {
        this.cliente = cliente;
    }

    public Boolean getProveedor() {
        return proveedor;
    }

    public void setProveedor(Boolean proveedor) {
        this.proveedor = proveedor;
    }

    public Boolean getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Boolean funcionario) {
        this.funcionario = funcionario;
    }

    public CategoriaTercero getIdCategoriaTercero() {
        return idCategoriaTercero;
    }

    public void setIdCategoriaTercero(CategoriaTercero idCategoriaTercero) {
        this.idCategoriaTercero = idCategoriaTercero;
    }

    public TipoDocumento getIdTipoDocumento() {
        return idTipoDocumento;
    }

    public void setIdTipoDocumento(TipoDocumento idTipoDocumento) {
        this.idTipoDocumento = idTipoDocumento;
    }

    @XmlTransient
    public List<TerceroDireccion> getTerceroDireccionList() {
        return terceroDireccionList;
    }

    public void setTerceroDireccionList(List<TerceroDireccion> terceroDireccionList) {
        this.terceroDireccionList = terceroDireccionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTercero != null ? idTercero.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tercero)) {
            return false;
        }
        Tercero other = (Tercero) object;
        if ((this.idTercero == null && other.idTercero != null) || (this.idTercero != null && !this.idTercero.equals(other.idTercero))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.paasoft.paasysfact.entities.Tercero[ idTercero=" + idTercero + " ]";
    }
    
}
