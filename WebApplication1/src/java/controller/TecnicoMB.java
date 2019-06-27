package controller;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import model.Tecnico;
import model.TecnicoDAO;

@ManagedBean
@RequestScoped
public class TecnicoMB {


    private Tecnico tecnico;
    TecnicoDAO tecnicoDAO ;
    
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

    
}