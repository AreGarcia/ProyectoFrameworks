/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import com.sun.management.VMOption;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.HttpServletRequest;
import javax.faces.context.FacesContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import model.Clientes;
import model.ClientesDAO;

/**
 *
 * @author Administrador
 */
@ManagedBean
@SessionScoped
public class adminController {
    private Clientes clientes;
    ClientesDAO clientesDAO ;
    
    String listClientes="clientes/list.xhtml";
    String listTecnicos="automoviles/listTecnicos.xhtml";
    
    String viewPropietario="automoviles/viewpropietario.xhtml";
    
    String duiDelete;
    FacesContext context;
    private String dui;

    HttpServletRequest origRequest;
    
    
    /**
     * Creates a new instance of ClienteController
     */
    public adminController() {
        clientes = new Clientes();
        clientesDAO = new ClientesDAO();
        context =FacesContext.getCurrentInstance();
        origRequest =(HttpServletRequest) context.getExternalContext().getRequest();
        
    }
    
    public String agregarAuto(Clientes cliente){
         setDui(cliente.getDui());
        return "/admin/automoviles/form?faces-redirect=true";
     }
    
    public void insert() throws SQLException, ServletException{
        
            clientesDAO.insert(getClientes());
            String retornar="";
            
            if(clientes.getRol().equals("Cliente")){
                try {
                    //retornar= listClientes;
                    FacesContext.getCurrentInstance().getExternalContext().redirect("list.xhtml");
                } catch (IOException ex) {
                    Logger.getLogger(adminController.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            } else if(clientes.getRol().equals("Tecnico")){
                try {
                    FacesContext.getCurrentInstance().getExternalContext().redirect("../automoviles/listTecnicos.xhtml?faces-redirect=true");
                    //retornar= listTecnicos;
                } catch (IOException ex) {
                    Logger.getLogger(adminController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
    }
    
       public void edit(Clientes cliente){
           
        this.clientes = cliente;
        
    }
       public void editTec(Clientes tecnicos){
       this.clientes= tecnicos;
       }
       
       public String editarTec(String dui)throws SQLException{
           clientesDAO.editar(clientes);
       return "/admin/automoviles/listTecnicos.xhtml";
       }
     
    public String editar(String dui) throws SQLException{
        
        clientesDAO.editar(clientes);
    return "list.xhtml?faces-redirect=true";
    }
     
     public String delete()throws SQLException{
        clientesDAO.delete(this.duiDelete);
        return "list.xhtml?faces-redirect=true";
        
    }
     public String deleteTec()throws SQLException{
         System.out.println(clientes.getDui());
         clientesDAO.delete(this.duiDelete);
     return "listTecnicos.xhtml";
     }
     
    
     public void fillDeleteForm(String dui){
        
        this.duiDelete = dui;
        
        System.out.println(duiDelete);
    }
     
    public List<Clientes> getClientesList(){
        
        List<Clientes> result = null;
        
        
        try {
            result = clientesDAO.fyndClientes();
        } catch (SQLException ex) {
            Logger.getLogger(adminController.class.getName()).log(Level.SEVERE, null, ex);
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
    
     public String getDuiDelete() {
        return duiDelete;
    }

    public void setDuiDelete(String duiDelete) {
        this.duiDelete = duiDelete;
    }
    
     public String getDui() {
        return dui;
    }

    public String setDui(String dui) {
        
        this.dui = dui;
        return "/admin/automoviles/form.xhtml?faces-redirect=true";
    }
    
}
