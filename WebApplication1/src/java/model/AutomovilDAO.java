/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.SQLException;

/**
 *
 * @author usuario
 */
public class AutomovilDAO extends AppConnection {
    
    public void insert(Automovil automovil) throws SQLException{
        connect();
        preparedStatement = connection.prepareStatement("insert into automoviles (numChasis,marca,modelo,color,ano,dui,numPlaca,clase,numMotor,tipoCarro) "
                + " values (?,?,?,?,?,?,?,?,?,?);");
        preparedStatement.setString(1, automovil.getNumChasis());
        preparedStatement.setString(2, automovil.getMarca());
        preparedStatement.setString(3, automovil.getModelo());
        preparedStatement.setString(4, automovil.getColor());
        preparedStatement.setString(5, automovil.getAno());
        preparedStatement.setString(6, automovil.getDuiUsuario());
        preparedStatement.setString(7, automovil.getNumPlaca());
        preparedStatement.setString(8, automovil.getClase());
        preparedStatement.setString(9, automovil.getNumMotor());
        preparedStatement.setString(10, automovil.getTipoCarro());
        preparedStatement.execute();
        
        close();
    
    
    }
    
}
