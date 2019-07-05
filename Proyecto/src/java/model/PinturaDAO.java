package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class PinturaDAO
  extends AppConnection
{
  public PinturaDAO() {}
  
  public void insert(Pintura pintura)
    throws SQLException
  {
    connect();
    preparedStatement = connection.prepareStatement("insert into tipo_Pintura (idTipo_Pintura, nombre, precioPintura) values (?,?,?)");
    preparedStatement.setInt(1, pintura.getTipo());
    preparedStatement.setString(2, pintura.getNombre());
    preparedStatement.setDouble(3, pintura.getPrecio());
    preparedStatement.execute();
    
    close();
  }
  
  public List<Pintura> findAll()
    throws SQLException
  {
    List<Pintura> pinturaList = new ArrayList();
    connect();
    preparedStatement = connection.prepareStatement("select idTipo_Pintura, nombre, precioPintura from tipo_Pintura");
    resultSet = preparedStatement.executeQuery();
    while (resultSet.next()) {
      Pintura pintura = new Pintura();
      pintura.setTipo(resultSet.getInt(1));
      pintura.setNombre(resultSet.getString(2));
      pintura.setPrecio(resultSet.getDouble(3));
      pinturaList.add(pintura);
    }
    close();
    return pinturaList;
  }

  
}
