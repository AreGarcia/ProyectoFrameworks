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
import model.Pintura;
import model.PinturaDAO;

/**
 *
 * @author deysi
 */
@ManagedBean
@RequestScoped
public class PinturaMB
{
  private Pintura pintura;
  PinturaDAO pinturaDAO;
  
  public PinturaMB()
  {
    pintura = new Pintura();
    pinturaDAO = new PinturaDAO();
  }
  
  public String insert() throws SQLException {
    pinturaDAO.insert(pintura);
    return "/usuario/servicio";
  }
  
  public List<Pintura> getPinturaList()
  {
    List<Pintura> result = null;
    try
    {
      result = pinturaDAO.findAll();
    } catch (SQLException ex) {
      Logger.getLogger(PinturaMB.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    return result;
  }
  




  public Pintura getPintura()
  {
    return pintura;
  }
  


  public void setPintura(Pintura pintura)
  {
    this.pintura = pintura;
  }
}