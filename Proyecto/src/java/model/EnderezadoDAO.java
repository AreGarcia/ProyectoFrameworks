package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;




public class EnderezadoDAO
  extends AppConnection
{
  public EnderezadoDAO() {}
  
  public void insert(Enderezado enderezado)
    throws SQLException
  {
    connect();
    preparedStatement = connection.prepareStatement("insert into tipo_Enderezado (idTipo_Enderezado, nivel, precio) values (?,?,?)");
    preparedStatement.setInt(1, enderezado.getTipo());
    preparedStatement.setString(2, enderezado.getNivel());
    preparedStatement.setDouble(3, enderezado.getPrecio());
    preparedStatement.execute();
    
    close();
  }
  
  public List<Enderezado> findAll()
    throws SQLException
  {
    List<Enderezado> enderezadoList = new ArrayList();
    connect();
    preparedStatement = connection.prepareStatement("select idTipo_Enderezado, nivel, precio from tipo_Enderezado");
    resultSet = preparedStatement.executeQuery();
    while (resultSet.next()) {
      Enderezado enderezado = new Enderezado();
      enderezado.setTipo(resultSet.getInt(1));
      enderezado.setNivel(resultSet.getString(2));
      enderezado.setPrecio(resultSet.getDouble(3));
      enderezadoList.add(enderezado);
    }
    close();
    return enderezadoList;
  }
}