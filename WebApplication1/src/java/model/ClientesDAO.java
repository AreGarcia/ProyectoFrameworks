/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrador
 */
public class ClientesDAO extends AppConnection{
    
    public void insert(Clientes cliente) throws SQLException{
    connect();
    preparedStatement = connection.prepareStatement("insert into usuarios (dui,user,password,rol,nombreCompleto,telefono,correo,celular,estado) "
    + " values (?,?,?,?,?,?,?,?,?); ");
    preparedStatement.setString(1, cliente.getDui());
    preparedStatement.setString(2, cliente.getUser());
    preparedStatement.setString(3, cliente.getPasswor());
    preparedStatement.setString(4, cliente.getRol());
    preparedStatement.setString(5, cliente.getNombreCom());
    preparedStatement.setString(6, cliente.getTelefono());
    preparedStatement.setString(7, cliente.getCorreo());
    preparedStatement.setString(8, cliente.getCelular());
    preparedStatement.setString(9, cliente.getEstado());
    preparedStatement.execute();
    
    close();
    }
    public List<Clientes> fyndAll() throws SQLException {
        List<Clientes> clientesList = new ArrayList();
        this.connect();
        preparedStatement = connection.prepareStatement("select dui, user, password, rol, nombreCompleto, telefono, correo, celular, estado from usuarios ");
        resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Clientes clientes = new Clientes();
            clientes.setDui(resultSet.getString("dui"));
            clientes.setUser(resultSet.getString("user"));
            clientes.setPasswor(resultSet.getString("password"));
            clientes.setRol(resultSet.getString("rol"));
            clientes.setNombreCom(resultSet.getString("nombreCompleto"));
            clientes.setTelefono(resultSet.getString("telefono"));
            clientes.setCorreo(resultSet.getString("correo"));
            clientes.setCelular(resultSet.getString("celular"));
            clientes.setEstado(resultSet.getString("estado"));
            clientesList.add(clientes);
        }
        this.close();
        return clientesList;
    }
    
        public List<Clientes> fyndClienteByDui(String duis) throws SQLException {
        List<Clientes> usuariosList = new ArrayList();

        this.connect();
        preparedStatement = connection.prepareStatement("select dui,user,rol,nombrecompleto,telefono,correo,celular,estado from usuarios where dui like  ?");
        preparedStatement.setString(1, "%" + duis + "%");
        resultSet = preparedStatement.executeQuery();
        
        while (resultSet.next()) {
            Clientes cliente = new Clientes();
            cliente.setDui(resultSet.getString("dui"));
            cliente.setUser(resultSet.getString("user"));
            cliente.setRol(resultSet.getString("rol"));
            cliente.setNombreCom(resultSet.getString("nombrecompleto"));
            cliente.setTelefono(resultSet.getString("telefono"));
            cliente.setCorreo(resultSet.getString("correo"));
            cliente.setCelular(resultSet.getString("celular"));
            cliente.setEstado(resultSet.getString("estado"));
            usuariosList.add(cliente);
        }
        this.close();
        return usuariosList;
    }
    
        
}
