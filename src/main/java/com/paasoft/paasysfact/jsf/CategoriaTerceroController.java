package com.paasoft.paasysfact.jsf;

import com.paasoft.paasysfact.entities.CategoriaTercero;
import com.paasoft.paasysfact.jsf.util.JsfUtil;
import com.paasoft.paasysfact.jsf.util.JsfUtil.PersistAction;
import com.paasoft.paasysfact.session.CategoriaTerceroFacade;

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

@Named("categoriaTerceroController")
@SessionScoped
public class CategoriaTerceroController implements Serializable {

    @EJB
    private com.paasoft.paasysfact.session.CategoriaTerceroFacade ejbFacade;
    private List<CategoriaTercero> items = null;
    private CategoriaTercero selected;

    public CategoriaTerceroController() {
    }

    public CategoriaTercero getSelected() {
        return selected;
    }

    public void setSelected(CategoriaTercero selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private CategoriaTerceroFacade getFacade() {
        return ejbFacade;
    }

    public CategoriaTercero prepareCreate() {
        selected = new CategoriaTercero();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("CategoriaTerceroCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("CategoriaTerceroUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("CategoriaTerceroDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<CategoriaTercero> getItems() {
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

    public CategoriaTercero getCategoriaTercero(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<CategoriaTercero> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<CategoriaTercero> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = CategoriaTercero.class)
    public static class CategoriaTerceroControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            CategoriaTerceroController controller = (CategoriaTerceroController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "categoriaTerceroController");
            return controller.getCategoriaTercero(getKey(value));
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
            if (object instanceof CategoriaTercero) {
                CategoriaTercero o = (CategoriaTercero) object;
                return getStringKey(o.getIdCategoriaTercero());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), CategoriaTercero.class.getName()});
                return null;
            }
        }

    }

}
