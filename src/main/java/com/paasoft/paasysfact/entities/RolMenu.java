/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.paasoft.paasysfact.entities;

import java.io.Serializable;
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
 * @author alejandro
 */
@Entity
@Table(name = "rol_menu")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RolMenu.findAll", query = "SELECT r FROM RolMenu r")
    , @NamedQuery(name = "RolMenu.findByIdRolMenu", query = "SELECT r FROM RolMenu r WHERE r.idRolMenu = :idRolMenu")})
public class RolMenu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_rol_menu")
    private Integer idRolMenu;
    @JoinColumn(name = "id_menu", referencedColumnName = "id_menu")
    @ManyToOne(optional = false)
    private Menu idMenu;
    @JoinColumn(name = "id_rol", referencedColumnName = "id_rol")
    @ManyToOne(optional = false)
    private Rol idRol;

    public RolMenu() {
    }

    public RolMenu(Integer idRolMenu) {
        this.idRolMenu = idRolMenu;
    }

    public Integer getIdRolMenu() {
        return idRolMenu;
    }

    public void setIdRolMenu(Integer idRolMenu) {
        this.idRolMenu = idRolMenu;
    }

    public Menu getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(Menu idMenu) {
        this.idMenu = idMenu;
    }

    public Rol getIdRol() {
        return idRol;
    }

    public void setIdRol(Rol idRol) {
        this.idRol = idRol;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRolMenu != null ? idRolMenu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RolMenu)) {
            return false;
        }
        RolMenu other = (RolMenu) object;
        if ((this.idRolMenu == null && other.idRolMenu != null) || (this.idRolMenu != null && !this.idRolMenu.equals(other.idRolMenu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.paasoft.paasysfact.entities.RolMenu[ idRolMenu=" + idRolMenu + " ]";
    }
    
}
