package controller;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import model.Enderezado;
import model.EnderezadoDAO;










@ManagedBean
@RequestScoped
public class EnderezadoMB
{
  private Enderezado enderezado;
  EnderezadoDAO enderezadoDAO;
  
  public EnderezadoMB()
  {
    enderezado = new Enderezado();
    enderezadoDAO = new EnderezadoDAO();
  }
  
  public String insert() throws SQLException {
    enderezadoDAO.insert(enderezado);
    return "/usuario/servicio";
  }
  
  public List<Enderezado> getEnderezadoList()
  {
    List<Enderezado> result = null;
    try
    {
      result = enderezadoDAO.findAll();
    } catch (SQLException ex) {
      Logger.getLogger(EnderezadoMB.class.getName()).log(Level.SEVERE, null, ex);
    }
    return result;
  }
  



  public Enderezado getEnderezado()
  {
    return enderezado;
  }
  


  public void setEnderezado(Enderezado enderezado)
  {
    this.enderezado = enderezado;
  }
}