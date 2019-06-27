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
import javax.faces.bean.RequestScoped;
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
    /**
     * Creates a new instance of ClienteController
     */
    public ClienteController() {
        clientes = new Clientes();
        clientesDAO = new ClientesDAO();
    }
    public String insert() throws SQLException{
        clientesDAO.insert(getClientes());
        
        return "/admin/clientes/list";
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
