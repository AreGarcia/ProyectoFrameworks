package controller;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import model.Clientes;
import model.Tecnico;
import model.TecnicoDAO;

@ManagedBean
@RequestScoped
public class TecnicoMB {

    private Tecnico tecnico;
    TecnicoDAO tecnicoDAO ;
    
    private int idServicio;
    
    /**
     * Creates a new instance of AutomovilController
     */
    public TecnicoMB() {
        tecnico= new Tecnico();
        tecnicoDAO= new TecnicoDAO();
    }
    
    public String insertTec() throws SQLException{
        tecnicoDAO.insertTec(tecnico);
        
        return "/usuario/list";
    }
    
    
    public List<Tecnico> getTecnicoList(){
        
        List<Tecnico> result = null;
        
        
        try {
            result = tecnicoDAO.fyndAll();
        } catch (SQLException ex) {
            Logger.getLogger(TecnicoMB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return result;
        
    }
     public List<Clientes> getTecnicosCompleteList(){
        
        List<Clientes> result = null;
        
        
        try {
            result = tecnicoDAO.fyndTecnicosComplete();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return result;
        
    }
    
    public void fillAsignarTec(int idServicio ){
        
        this.setIdServicio(idServicio);
        
        System.out.println("Si entra el id  es:"+idServicio);
    }
    
    public void AsignarTec(int idServicio){
        
        this.setIdServicio(idServicio);
        
    }
     
    public String AsignarTecnico(String duiTecnico) throws SQLException{
         
          
         tecnicoDAO.AsignarTecnico(duiTecnico, this.getIdServicio());
        
        return "list.xhtml?faces-redirect=true";
    }
    
    public void Deletetec(Tecnico tecnico) throws SQLException{
        tecnicoDAO.Delete(tecnico);
    }

    
    public Tecnico getTecnico() {
        return tecnico;
    }

    /**
     * @param tecnico the automovil to set
     */
    public void setTecnico(Tecnico tecnico) {
        this.tecnico = tecnico;
    }
    
    /**
     * @return the idServicio
     */
    public int getIdServicio() {
        return idServicio;
    }

    /**
     * @param idServicio the idServicio to set
     */
    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }



    
}