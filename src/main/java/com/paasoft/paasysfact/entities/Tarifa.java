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
@Table(name = "tarifa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tarifa.findAll", query = "SELECT t FROM Tarifa t")
    , @NamedQuery(name = "Tarifa.findByIdtarifa", query = "SELECT t FROM Tarifa t WHERE t.idtarifa = :idtarifa")
    , @NamedQuery(name = "Tarifa.findByNombre", query = "SELECT t FROM Tarifa t WHERE t.nombre = :nombre")
    , @NamedQuery(name = "Tarifa.findByEstado", query = "SELECT t FROM Tarifa t WHERE t.estado = :estado")
    , @NamedQuery(name = "Tarifa.findByUsuarioins", query = "SELECT t FROM Tarifa t WHERE t.usuarioins = :usuarioins")
    , @NamedQuery(name = "Tarifa.findByFechains", query = "SELECT t FROM Tarifa t WHERE t.fechains = :fechains")
    , @NamedQuery(name = "Tarifa.findByUsuarioupd", query = "SELECT t FROM Tarifa t WHERE t.usuarioupd = :usuarioupd")
    , @NamedQuery(name = "Tarifa.findByFechaupd", query = "SELECT t FROM Tarifa t WHERE t.fechaupd = :fechaupd")})
public class Tarifa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtarifa")
    private Integer idtarifa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Lob
    @Size(max = 65535)
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "estado")
    private Boolean estado;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idtarifa")
    private List<VersionTarifa> versionTarifaList;

    public Tarifa() {
    }

    public Tarifa(Integer idtarifa) {
        this.idtarifa = idtarifa;
    }

    public Tarifa(Integer idtarifa, String nombre, String usuarioins, Date fechains) {
        this.idtarifa = idtarifa;
        this.nombre = nombre;
        this.usuarioins = usuarioins;
        this.fechains = fechains;
    }

    public Integer getIdtarifa() {
        return idtarifa;
    }

    public void setIdtarifa(Integer idtarifa) {
        this.idtarifa = idtarifa;
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

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
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
    public List<VersionTarifa> getVersionTarifaList() {
        return versionTarifaList;
    }

    public void setVersionTarifaList(List<VersionTarifa> versionTarifaList) {
        this.versionTarifaList = versionTarifaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtarifa != null ? idtarifa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tarifa)) {
            return false;
        }
        Tarifa other = (Tarifa) object;
        if ((this.idtarifa == null && other.idtarifa != null) || (this.idtarifa != null && !this.idtarifa.equals(other.idtarifa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.paasoft.paasysfact.entities.Tarifa[ idtarifa=" + idtarifa + " ]";
    }
    
}
