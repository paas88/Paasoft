package com.paasoft.paasysfact.jsf;

import com.paasoft.paasysfact.entities.CategoriaProducto;
import com.paasoft.paasysfact.jsf.util.JsfUtil;
import com.paasoft.paasysfact.jsf.util.JsfUtil.PersistAction;
import com.paasoft.paasysfact.session.CategoriaProductoFacade;

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

@Named("categoriaProductoController")
@SessionScoped
public class CategoriaProductoController implements Serializable {

    @EJB
    private com.paasoft.paasysfact.session.CategoriaProductoFacade ejbFacade;
    private List<CategoriaProducto> items = null;
    private CategoriaProducto selected;

    public CategoriaProductoController() {
    }

    public CategoriaProducto getSelected() {
        return selected;
    }

    public void setSelected(CategoriaProducto selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private CategoriaProductoFacade getFacade() {
        return ejbFacade;
    }

    public CategoriaProducto prepareCreate() {
        selected = new CategoriaProducto();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("CategoriaProductoCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("CategoriaProductoUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("CategoriaProductoDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<CategoriaProducto> getItems() {
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

    public CategoriaProducto getCategoriaProducto(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<CategoriaProducto> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<CategoriaProducto> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = CategoriaProducto.class)
    public static class CategoriaProductoControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            CategoriaProductoController controller = (CategoriaProductoController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "categoriaProductoController");
            return controller.getCategoriaProducto(getKey(value));
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
            if (object instanceof CategoriaProducto) {
                CategoriaProducto o = (CategoriaProducto) object;
                return getStringKey(o.getIdCategoriaProducto());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), CategoriaProducto.class.getName()});
                return null;
            }
        }

    }

}
