/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.SQLException;

/**
 *
 * @author kevin
 */
public class UsuarioDAO extends AppConnection {

    public Usuario login(String user, String password) throws SQLException {
        Usuario usuario = null;
        connect();

        preparedStatement = connection.prepareStatement("select * from usuarios where user = ? and password = ?");

        preparedStatement.setString(1, user);
        preparedStatement.setString(2, password);

        resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            usuario = new Usuario();

            usuario.setId(resultSet.getInt(1));
            usuario.setUser(resultSet.getString(2));
            usuario.setPassword(resultSet.getString(3));
            usuario.setRol(resultSet.getString(4));
        }
        close();

        return usuario;

    }

}
