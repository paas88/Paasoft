package com.paasoft.paasysfact.jsf;

import com.paasoft.paasysfact.entities.VersionTarifa;
import com.paasoft.paasysfact.jsf.util.JsfUtil;
import com.paasoft.paasysfact.jsf.util.JsfUtil.PersistAction;
import com.paasoft.paasysfact.session.VersionTarifaFacade;

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

@Named("versionTarifaController")
@SessionScoped
public class VersionTarifaController implements Serializable {

    @EJB
    private com.paasoft.paasysfact.session.VersionTarifaFacade ejbFacade;
    private List<VersionTarifa> items = null;
    private VersionTarifa selected;

    public VersionTarifaController() {
    }

    public VersionTarifa getSelected() {
        return selected;
    }

    public void setSelected(VersionTarifa selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private VersionTarifaFacade getFacade() {
        return ejbFacade;
    }

    public VersionTarifa prepareCreate() {
        selected = new VersionTarifa();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("VersionTarifaCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("VersionTarifaUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("VersionTarifaDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<VersionTarifa> getItems() {
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

    public VersionTarifa getVersionTarifa(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<VersionTarifa> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<VersionTarifa> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = VersionTarifa.class)
    public static class VersionTarifaControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            VersionTarifaController controller = (VersionTarifaController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "versionTarifaController");
            return controller.getVersionTarifa(getKey(value));
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
            if (object instanceof VersionTarifa) {
                VersionTarifa o = (VersionTarifa) object;
                return getStringKey(o.getIdVersionTarifa());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), VersionTarifa.class.getName()});
                return null;
            }
        }

    }

}
