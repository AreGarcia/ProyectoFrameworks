/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import model.Clientes;
import model.ClientesDAO;

/**
 *
 * @author Administrador
 */
@ManagedBean
@RequestScoped
public class ClienteController {
     private Clientes clientes;
    ClientesDAO clientesDAO ;
    
    String listClientes="clientes/list.xhtml";
    String listTecnicos="automoviles/listTecnicos.xhtml";
    
    String viewPropietario="automoviles/viewpropietario.xhtml";
    
    /**
     * Creates a new instance of ClienteController
     */
    public ClienteController() {
        clientes = new Clientes();
        clientesDAO = new ClientesDAO();
    }
    
   
    public void insert() throws SQLException, ServletException{
        
            clientesDAO.insert(getClientes());
            String retornar="";
            
            if(clientes.getRol().equals("Cliente")){
                try {
                    //retornar= listClientes;
                    FacesContext.getCurrentInstance().getExternalContext().redirect("list.xhtml");
                } catch (IOException ex) {
                    Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            } else if(clientes.getRol().equals("Tecnico")){
                try {
                    FacesContext.getCurrentInstance().getExternalContext().redirect("../automoviles/listTecnicos.xhtml");
                    //retornar= listTecnicos;
                } catch (IOException ex) {
                    Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
    }
    
    public List<Clientes> getClientesList(){
        
        List<Clientes> result = null;
        
        
        try {
            result = clientesDAO.fyndAll();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return result;
        
    }

    /**
     * @return the clientes
     */
    public Clientes getClientes() {
        return clientes;
    }

    /**
     * @param clientes the clientes to set
     */
    public void setClientes(Clientes clientes) {
        this.clientes = clientes;
    }
    
    
}
