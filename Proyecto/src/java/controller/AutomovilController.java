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
import javax.faces.bean.SessionScoped;
import model.Automovil;
import model.AutomovilDAO;
import model.Clientes;
import model.ClientesDAO;

/**
 *
 * @author usuario
 */
@ManagedBean
@SessionScoped
public class AutomovilController {


    private Automovil automovil;
    AutomovilDAO automovilDAO ;
    private Clientes cliente;
    ClientesDAO clientesDAO = new ClientesDAO();
    
    private String chasisDelete;
    
    /**
     * Creates a new instance of AutomovilController
     */
    public AutomovilController() {
        automovil= new Automovil();
        automovilDAO= new AutomovilDAO();
        cliente = new Clientes();
    }
    
    public String loadDui(String dui){
    this.automovil.setDuiUsuario(dui);
    return "/admin/automoviles/form.xhtml?faces-redirect=true";
    }
    public String insert() throws SQLException{
        automovilDAO.insert(automovil);
        
        return "/admin/automoviles/list";
    }
    
     public void viewPropietario(Automovil automovil) throws SQLException{
       
        this.setCliente(clientesDAO.fyndClientePropietarioByDui(automovil.getDuiUsuario()));
        
        System.out.println(getCliente().getNombreCom());
    }
    
    public void EditarAutomovil(Automovil automovil) throws SQLException{
       
        this.setAutomovil(automovilDAO.fyndEditarByNumChasis(automovil.getNumChasis()));
        
        System.out.println(getAutomovil().getNumChasis());
    }
    
    
    /**
     * Elimina por String de numero de chasis
     * @param numChasis
     * @return
     * @throws SQLException 
     */
    public String DeleteAutomovilString()throws SQLException{
        System.out.println(this.getChasisDelete());
        automovilDAO.deleteAuto(this.getChasisDelete());
        return "list.xhtml?faces-redirect=true";
        
    }
    
    public String edit(Automovil automovil){
        this.automovil = automovil;
        
        return "update.xhtml";
    }
     
     public String editar() throws SQLException{
         System.out.println(this.automovil.getNumPlaca());
        automovilDAO.editarAutomovil(automovil);
        return "list.xhtml?faces-redirect=true";
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
    
    public void fillDeleteForm(String chasis){
        
        this.chasisDelete = chasis;
        
        System.out.println(chasisDelete);
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
    
    public Clientes getCliente() {
        return cliente;
    }


    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }
    
     /**
     * @return the chasisDelete
     */
    public String getChasisDelete() {
        return chasisDelete;
    }

    /**
     * @param chasisDelete the chasisDelete to set
     */
    public void setChasisDelete(String chasisDelete) {
        this.chasisDelete = chasisDelete;
    }

    
}
