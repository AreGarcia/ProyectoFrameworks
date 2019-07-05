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
import model.Servicio;
import model.ServicioDAO;

/**
 *
 * @author deysi
 */
@ManagedBean
@RequestScoped
public class ServicioMB
{
  private Servicio servicio;
  private ServicioDAO servicioDAO;
  
  public ServicioMB()
  {
    servicio = new Servicio();
    servicioDAO = new ServicioDAO();
  }
  
  public String insertser() throws SQLException {
        getServicioDAO().insert(getServicio());
    return "/usuario/servicio";
  }
  
  public List<Servicio> getServicioList()
  {
    List<Servicio> result = null;
    try
    {
      result = servicioDAO.findAll();
    } catch (SQLException ex) {
      Logger.getLogger(ServicioMB.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    return result;
  }

    /**
     * @return the servicio
     */
    public Servicio getServicio() {
        return servicio;
    }

    /**
     * @return the servicioDAO
     */
    public ServicioDAO getServicioDAO() {
        return servicioDAO;
    }
  





}