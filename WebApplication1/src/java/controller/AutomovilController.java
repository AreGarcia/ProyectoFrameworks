/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import model.Automovil;
import model.AutomovilDAO;
import model.Clientes;
import model.ClientesDAO;

/**
 *
 * @author usuario
 */
@ManagedBean
@RequestScoped
public class AutomovilController {


    private Automovil automovil;
    AutomovilDAO automovilDAO ;
    
    /**
     * Creates a new instance of AutomovilController
     */
    public AutomovilController() {
        automovil= new Automovil();
        automovilDAO= new AutomovilDAO();
    }
    
    public String insert() throws SQLException{
        automovilDAO.insert(automovil);
        
        return "/admin/automoviles/list";
    }
    
    
    public List<Automovil> getAutomovilList(){
        
        List<Automovil> result = null;
        
        
        try {
            result = automovilDAO.fyndAll();
        } catch (SQLException ex) {
            Logger.getLogger(AutomovilController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return result;
        
    }
    
    public List<Automovil> getServiciosList(){
        
        List<Automovil> result = null;
        
        
        try {
            result = automovilDAO.fyndAll2();
        } catch (SQLException ex) {
            Logger.getLogger(AutomovilController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return result;
        
    }
  
    public List<String> clientes(String query) throws SQLException{
        ClientesDAO clientesDAO = new ClientesDAO();
        List<String> duis = new ArrayList<>();
        
        for(Clientes c:clientesDAO.fyndClienteByDui(query)){
            duis.add(c.getDui());
        }
        
        return duis;
    }
    
        /**
     * @return the automovil
     */
    public Automovil getAutomovil() {
        return automovil;
    }

    /**
     * @param automovil the automovil to set
     */
    public void setAutomovil(Automovil automovil) {
        this.automovil = automovil;
    }

    
}
