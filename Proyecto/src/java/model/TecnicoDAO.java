
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author deysi
 */
public class TecnicoDAO extends AppConnection {
    
        public void insertTec(Tecnico tecnico) throws SQLException {
        connect();
        preparedStatement = connection.prepareStatement("insert into Servicio_Pintura (idServicio,numChasis,idTipo_Pintura,color,idTipo_Enderezado,manoDeObra,total,estado,tecnico) "
                + " values (?,?,?,?,?,?,?,?,?);");
        preparedStatement.setInt(1,tecnico.getIdServicio());
        preparedStatement.setString(2, tecnico.getNumChasis());
        preparedStatement.setInt(3, tecnico.getIdTipo_Pintura());
        preparedStatement.setString(4, tecnico.getColor());
        preparedStatement.setInt(5, tecnico.getIdTipo_Enderezado());
        preparedStatement.setDouble(6, tecnico.getManoDeObra());
        preparedStatement.setDouble(7, tecnico.getTotal());
        preparedStatement.setString(8, tecnico.getEstado());
        preparedStatement.setString(9, tecnico.getTecnico());
        preparedStatement.execute();

        close();

    }
        
    public List<Tecnico> fyndAll() throws SQLException {
        List<Tecnico> tecnicoList = new ArrayList();

        this.connect();
        preparedStatement = connection.prepareStatement("select idServicio_pintura,idServicio,numChasis,idTipo_Pintura,color,idTipo_Enderezado,manoDeObra,total,estado,tecnico from Servicio_Pintura");
        resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Tecnico tecnico = new Tecnico();
            tecnico.setIdServicio_Pintura(resultSet.getInt("idServicio_pintura"));
            tecnico.setIdServicio(resultSet.getInt("idServicio"));
            tecnico.setNumChasis(resultSet.getString("numChasis"));
            tecnico.setIdTipo_Pintura(resultSet.getInt("idTipo_Pintura"));
            tecnico.setColor(resultSet.getString("color"));
            tecnico.setIdTipo_Enderezado(resultSet.getInt("idTipo_Enderezado"));
            tecnico.setManoDeObra(resultSet.getDouble("manoDeObra"));
            tecnico.setEstado(resultSet.getString("estado"));
            tecnico.setTotal(resultSet.getDouble("total"));
            tecnico.setTecnico(resultSet.getString("tecnico"));
            tecnicoList.add(tecnico);
        }
        this.close();
        return tecnicoList;
    }
    
    
    public List<Tecnico> fyndAllTecnicos() throws SQLException {
        List<Tecnico> tecnicoListEdit = new ArrayList();

        this.connect();
        preparedStatement = connection.prepareStatement("select servicio_pintura.idServicio_pintura, servicio_pintura.idServicio, servicio_pintura.numChasis, servicio_pintura.idTipo_Pintura, servicio_pintura.color, servicio_pintura.idTipo_Enderezado, servicio_pintura.manoDeObra, servicio_pintura.total, servicio_pintura.estado, servicio_pintura.tecnico, nombreCompleto from Servicio_Pintura INNER JOIN automoviles ON servicio_pintura.numChasis= automoviles.numChasis INNER JOIN usuarios ON usuarios.dui= automoviles.dui WHERE usuarios.rol='Tecnico' AND servicio_pintura.tecnico='Sin Asignar';");
        resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Tecnico tecnico = new Tecnico();
            tecnico.setIdServicio_Pintura(resultSet.getInt("servicio_pintura.idServicio_pintura"));
            tecnico.setIdServicio(resultSet.getInt("servicio_pintura.idServicio"));
            tecnico.setNumChasis(resultSet.getString("servicio_pintura.numChasis"));
            tecnico.setIdTipo_Pintura(resultSet.getInt("servicio_pintura.idTipo_Pintura"));
            tecnico.setColor(resultSet.getString("servicio_pintura.color"));
            tecnico.setIdTipo_Enderezado(resultSet.getInt("servicio_pintura.idTipo_Enderezado"));
            tecnico.setManoDeObra(resultSet.getDouble("servicio_pintura.manoDeObra"));
            tecnico.setEstado(resultSet.getString("servicio_pintura.estado"));
            tecnico.setTotal(resultSet.getDouble("servicio_pintura.total"));
            tecnico.setTecnico(resultSet.getString("servicio_pintura.tecnico"));
            tecnicoListEdit.add(tecnico);
        }
        this.close();
        return tecnicoListEdit;
    }
    
    public List<Clientes> fyndTecnicosComplete() throws SQLException {
        List<Clientes> tecnicosCompleteList = new ArrayList();
        this.connect();
        preparedStatement = connection.prepareStatement("select dui, user, password, rol, nombreCompleto, telefono, correo, celular, estado from usuarios where rol=\"Tecnico\"");
        resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Clientes tecnico = new Clientes();
            tecnico.setDui(resultSet.getString("dui"));
            tecnico.setUser(resultSet.getString("user"));
            tecnico.setPassword(resultSet.getString("password"));
            tecnico.setRol(resultSet.getString("rol"));
            tecnico.setNombreCom(resultSet.getString("nombreCompleto"));
            tecnico.setTelefono(resultSet.getString("telefono"));
            tecnico.setCorreo(resultSet.getString("correo"));
            tecnico.setCelular(resultSet.getString("celular"));
            tecnico.setEstado(resultSet.getString("estado"));
            tecnicosCompleteList.add(tecnico);
        }
        this.close();
        return tecnicosCompleteList;
    }
    
    
      public void Delete(Tecnico tecnico) throws SQLException{
        this.connect();
        preparedStatement = connection.prepareStatement("delete from Servicio_Pintura where idServicio_pintura = ?");        
        resultSet = preparedStatement.executeQuery();
        preparedStatement.setInt(1, tecnico.getIdServicio_Pintura());      
        preparedStatement.execute();
        this.close();
    }
      
    public void AsignarTecnico(String duiTec, int idServicio) throws SQLException{
      
        connect();
        String sql = "UPDATE `servicio_pintura` SET `tecnico` = \""+duiTec+"\" WHERE `servicio_pintura`.`idServicio_Pintura` ="+idServicio+";";
        System.out.println(sql);
        preparedStatement =connection.prepareStatement(sql);
        preparedStatement.execute();
        close();
        
    }    
    
}
