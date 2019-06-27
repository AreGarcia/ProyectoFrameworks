package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class ServicioDAO
  extends AppConnection
{
  public ServicioDAO() {}
  
  public void insert(Servicio servicio)
    throws SQLException
  {
    connect();
    preparedStatement = connection.prepareStatement("insert into servicios ( idServicio,Nombre_Servicio) values (?,?)");
    preparedStatement.setInt(1, servicio.getIdServicio());
    preparedStatement.setString(2, servicio.getNombre_Servicio());
    preparedStatement.execute();
    
    close();
  }
  
  public List<Servicio> findAll()
    throws SQLException
  {
    List<Servicio> ServicioList = new ArrayList();
    connect();
    preparedStatement = connection.prepareStatement("select idServicio,Nombre_Servicio from servicios");
    resultSet = preparedStatement.executeQuery();
    while (resultSet.next()) {
      Servicio servicio = new Servicio();
      servicio.setIdServicio(resultSet.getInt(1));
      servicio.setNombre_Servicio(resultSet.getString(2));
      ServicioList.add(servicio);
    }
    close();
    return ServicioList;
  }
}
