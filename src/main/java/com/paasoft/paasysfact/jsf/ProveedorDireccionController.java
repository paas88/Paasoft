package com.paasoft.paasysfact.jsf;

import com.paasoft.paasysfact.entities.ProveedorDireccion;
import com.paasoft.paasysfact.jsf.util.JsfUtil;
import com.paasoft.paasysfact.jsf.util.JsfUtil.PersistAction;
import com.paasoft.paasysfact.session.ProveedorDireccionFacade;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@Named("proveedorDireccionController")
@SessionScoped
public class ProveedorDireccionController implements Serializable {

    @EJB
    private com.paasoft.paasysfact.session.ProveedorDireccionFacade ejbFacade;
    private List<ProveedorDireccion> items = null;
    private ProveedorDireccion selected;

    public ProveedorDireccionController() {
    }

    public ProveedorDireccion getSelected() {
        return selected;
    }

    public void setSelected(ProveedorDireccion selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private ProveedorDireccionFacade getFacade() {
        return ejbFacade;
    }

    public ProveedorDireccion prepareCreate() {
        selected = new ProveedorDireccion();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("ProveedorDireccionCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("ProveedorDireccionUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("ProveedorDireccionDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<ProveedorDireccion> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public ProveedorDireccion getProveedorDireccion(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<ProveedorDireccion> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<ProveedorDireccion> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = ProveedorDireccion.class)
    public static class ProveedorDireccionControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ProveedorDireccionController controller = (ProveedorDireccionController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "proveedorDireccionController");
            return controller.getProveedorDireccion(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof ProveedorDireccion) {
                ProveedorDireccion o = (ProveedorDireccion) object;
                return getStringKey(o.getIdproveedorDireccion());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), ProveedorDireccion.class.getName()});
                return null;
            }
        }

    }

}
