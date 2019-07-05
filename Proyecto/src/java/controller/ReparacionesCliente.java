/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import model.reparacionCliente;
import model.reparacionClienteDAO;

/**
 *
 * @author kevin
 */
@ManagedBean
@SessionScoped
public class ReparacionesCliente {


    private reparacionCliente ReparacionCliente;
    reparacionClienteDAO ReparacionClienteDAO;
    FacesContext context;
    HttpServletRequest origRequest;
    private String user;
    private int id;
    private String nombreCompleto;

    public ReparacionesCliente() {
  
        ReparacionCliente = new reparacionCliente();
        ReparacionClienteDAO = new reparacionClienteDAO();
        context = FacesContext.getCurrentInstance();
        origRequest = (HttpServletRequest) context.getExternalContext().getRequest();
    }

    public List<reparacionCliente> getReparacionClienteList() {
        List<reparacionCliente> result = null;
        try {
            result = ReparacionClienteDAO.fyndAll(getUser());
        } catch (SQLException ex) {
            Logger.getLogger(AutomovilController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return result;
    }

    public List<reparacionCliente> getReparacionClienteListTecnico() {
        List<reparacionCliente> result = null;
        try {
            result = ReparacionClienteDAO.fyndAllTecnico(getNombreCompleto());
        } catch (SQLException ex) {
            Logger.getLogger(AutomovilController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return result;

    }
    
    public List<reparacionCliente> getReparacionBitacoraList() {
        List<reparacionCliente> result = null;
        try {
            result = ReparacionClienteDAO.fyndAllBitacora(getUser(), getId());
        } catch (SQLException ex) {
            Logger.getLogger(AutomovilController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return result;
    }

    
    public String Aprobar(int id) {
        try {
            ReparacionClienteDAO.Aprobar(id);
        } catch (SQLException ex) {
            Logger.getLogger(ReparacionesCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "Home.xhtml?faces-redirect=true";
    }
    
    public String Delete(int id) throws SQLException {
        ReparacionClienteDAO.Delete(id);
        return "Home.xhtml?faces-redirect=true";
    }
    
    public String Reparacion(int id) throws SQLException {
        ReparacionClienteDAO.Reparacion(id);
        return "list.xhtml?faces-redirect=true";
    }
    
    public String Finalizado(int id) throws SQLException {
        ReparacionClienteDAO.Finalizado(id);
        return "list.xhtml?faces-redirect=true";
    }
    
    
    /**
     * @return the ReparacionCliente
     */
    public reparacionCliente getReparacionCliente() {
        return ReparacionCliente;
    }

    /**
     * @param ReparacionCliente the ReparacionCliente to set
     */
    public void setReparacionCliente(reparacionCliente ReparacionCliente) {
        this.ReparacionCliente = ReparacionCliente;
    }


    /**
     * @return the user
     */
    public String getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public String setId(int id) {
        this.id = id;
        return "bitacora.xhtml?faces-redirect=true";
    }

    /**
     * @return the nombreCompleto
     */
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    /**
     * @param nombreCompleto the nombreCompleto to set
     */
    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

}
