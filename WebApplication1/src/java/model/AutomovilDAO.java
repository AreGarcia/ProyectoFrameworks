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
 * @author usuario
 */
public class AutomovilDAO extends AppConnection {

    public void insert(Automovil automovil) throws SQLException {
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

    public List<Automovil> fyndAll() throws SQLException {
        List<Automovil> automovilList = new ArrayList();

        this.connect();
        preparedStatement = connection.prepareStatement("select numChasis, marca, modelo, color, ano, dui, numPlaca, clase, numMotor, tipoCarro from automoviles ");
        resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Automovil automovil = new Automovil();
            automovil.setNumChasis(resultSet.getString("numChasis"));
            automovil.setMarca(resultSet.getString("marca"));
            automovil.setModelo(resultSet.getString("modelo"));
            automovil.setColor(resultSet.getString("color"));
            automovil.setAno(resultSet.getString("ano"));
            automovil.setDuiUsuario(resultSet.getString("dui"));
            automovil.setNumPlaca(resultSet.getString("numPlaca"));
            automovil.setClase(resultSet.getString("clase"));
            automovil.setNumMotor(resultSet.getString("numMotor"));
            automovil.setTipoCarro(resultSet.getString("tipoCarro"));
            automovilList.add(automovil);
        }
        this.close();
        return automovilList;
    }

}
