/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kevin
 */
public class reparacionClienteDAO extends AppConnection {

    public List<reparacionCliente> fyndAll(String user) throws SQLException {
        List<reparacionCliente> reparacionClienteList = new ArrayList();

        this.connect();
        preparedStatement = connection.prepareStatement("SELECT  Sp.idServicio_Pintura, Sv.Nombre_Servicio, Us.nombreCompleto, Au.marca, Au.modelo, Au.dui, Au.numPlaca, Te.nivel, \n"
                + "		Te.precio, Tp.nombre, Sp.color, Tp.precioPintura, Sp.manoDeObra, Sp.total, Sp.tecnico, Sp.estado\n"
                + "FROM usuarios as Us\n"
                + "INNER JOIN automoviles as Au ON Us.dui = Au.dui\n"
                + "INNER JOIN servicio_pintura as Sp ON Au.numChasis = Sp.numChasis\n"
                + "INNER JOIN servicios as Sv ON Sp.idServicio = Sv.idServicio\n"
                + "INNER JOIN tipo_enderezado as Te ON Sp.idTipo_Enderezado = Te.idTipo_Enderezado\n"
                + "INNER JOIN tipo_pintura as Tp ON Sp.idTipo_Pintura = Tp.idTipo_Pintura where US.user  = '" + user + "'");

        resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            reparacionCliente reparacion_cliente = null;
            reparacion_cliente = new reparacionCliente();

            reparacion_cliente.setIdServicio_Pintura(resultSet.getInt(1));
            reparacion_cliente.setNombre_Servicio(resultSet.getString(2));
            reparacion_cliente.setNombreCompleto(resultSet.getString(3));
            reparacion_cliente.setMarca(resultSet.getString(4));
            reparacion_cliente.setModelo(resultSet.getString(5));
            reparacion_cliente.setDui(resultSet.getString(6));
            reparacion_cliente.setNumPlaca(resultSet.getString(7));
            reparacion_cliente.setNivel(resultSet.getString(8));
            reparacion_cliente.setPrecioEnderezado(resultSet.getString(9));
            reparacion_cliente.setNombrePintura(resultSet.getString(10));
            reparacion_cliente.setColor(resultSet.getString(11));
            reparacion_cliente.setPrecioPintura(resultSet.getString(12));
            reparacion_cliente.setManoDeObra(resultSet.getString(13));
            reparacion_cliente.setTotal(resultSet.getString(14));
            reparacion_cliente.setTecnico(resultSet.getString(15));
            reparacion_cliente.setEstado(resultSet.getString(16));

            reparacionClienteList.add(reparacion_cliente);
        }
        this.close();
        return reparacionClienteList;
    }

    public List<reparacionCliente> fyndAllTecnico(String nombre) throws SQLException {
        List<reparacionCliente> reparacionClienteListTecnico = new ArrayList();

        this.connect();
        preparedStatement = connection.prepareStatement("SELECT  Sp.idServicio_Pintura, Sv.Nombre_Servicio, Us.nombreCompleto, Au.marca, Au.modelo, Au.dui, Au.numPlaca, Te.nivel, \n"
                + "		Te.precio, Tp.nombre, Sp.color, Tp.precioPintura, Sp.manoDeObra, Sp.total, Sp.tecnico, Sp.estado\n"
                + "FROM usuarios as Us\n"
                + "INNER JOIN automoviles as Au ON Us.dui = Au.dui\n"
                + "INNER JOIN servicio_pintura as Sp ON Au.numChasis = Sp.numChasis\n"
                + "INNER JOIN servicios as Sv ON Sp.idServicio = Sv.idServicio\n"
                + "INNER JOIN tipo_enderezado as Te ON Sp.idTipo_Enderezado = Te.idTipo_Enderezado\n"
                + "INNER JOIN tipo_pintura as Tp ON Sp.idTipo_Pintura = Tp.idTipo_Pintura where Sp.tecnico = '" + nombre + "'");

        resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            reparacionCliente reparacion_cliente = null;
            reparacion_cliente = new reparacionCliente();

            reparacion_cliente.setIdServicio_Pintura(resultSet.getInt(1));
            reparacion_cliente.setNombre_Servicio(resultSet.getString(2));
            reparacion_cliente.setNombreCompleto(resultSet.getString(3));
            reparacion_cliente.setMarca(resultSet.getString(4));
            reparacion_cliente.setModelo(resultSet.getString(5));
            reparacion_cliente.setDui(resultSet.getString(6));
            reparacion_cliente.setNumPlaca(resultSet.getString(7));
            reparacion_cliente.setNivel(resultSet.getString(8));
            reparacion_cliente.setPrecioEnderezado(resultSet.getString(9));
            reparacion_cliente.setNombrePintura(resultSet.getString(10));
            reparacion_cliente.setColor(resultSet.getString(11));
            reparacion_cliente.setPrecioPintura(resultSet.getString(12));
            reparacion_cliente.setManoDeObra(resultSet.getString(13));
            reparacion_cliente.setTotal(resultSet.getString(14));
            reparacion_cliente.setTecnico(resultSet.getString(15));
            reparacion_cliente.setEstado(resultSet.getString(16));

            reparacionClienteListTecnico.add(reparacion_cliente);
        }
        this.close();
        return reparacionClienteListTecnico;
    }

    public List<reparacionCliente> fyndAllBitacora(String user, int id) throws SQLException {
        List<reparacionCliente> reparacionClienteListBitacora = new ArrayList();

        this.connect();
        preparedStatement = connection.prepareStatement("SELECT  Sp.idServicio_Pintura, Sv.Nombre_Servicio, Us.nombreCompleto, Au.marca, Au.modelo, Au.dui, Au.numPlaca, Te.nivel, \n"
                + "		Te.precio, Tp.nombre, Sp.color, Tp.precioPintura, Sp.manoDeObra, Sp.total, Sp.tecnico, Sp.estado\n"
                + "FROM usuarios as Us\n"
                + "INNER JOIN automoviles as Au ON Us.dui = Au.dui\n"
                + "INNER JOIN servicio_pintura as Sp ON Au.numChasis = Sp.numChasis\n"
                + "INNER JOIN servicios as Sv ON Sp.idServicio = Sv.idServicio\n"
                + "INNER JOIN tipo_enderezado as Te ON Sp.idTipo_Enderezado = Te.idTipo_Enderezado\n"
                + "INNER JOIN tipo_pintura as Tp ON Sp.idTipo_Pintura = Tp.idTipo_Pintura \n"
                + "INNER JOIN bitacora as BT ON Sp.idServicio_Pintura = BT.idServicios where Sp.idServicio_Pintura = '"+id+"' and Sp.tecnico = '"+user+"'");

        resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            reparacionCliente reparacion_cliente_bitacora = null;
            reparacion_cliente_bitacora = new reparacionCliente();

            reparacion_cliente_bitacora.setIdServicio_Pintura(resultSet.getInt(1));
            reparacion_cliente_bitacora.setNombre_Servicio(resultSet.getString(2));
            reparacion_cliente_bitacora.setNombreCompleto(resultSet.getString(3));
            reparacion_cliente_bitacora.setMarca(resultSet.getString(4));
            reparacion_cliente_bitacora.setModelo(resultSet.getString(5));
            reparacion_cliente_bitacora.setDui(resultSet.getString(6));
            reparacion_cliente_bitacora.setNumPlaca(resultSet.getString(7));
            reparacion_cliente_bitacora.setTecnico(resultSet.getString(15));
            reparacion_cliente_bitacora.setEstado(resultSet.getString(16));

            reparacionClienteListBitacora.add(reparacion_cliente_bitacora);
        }
        this.close();
        return reparacionClienteListBitacora;
    }

    public void Aprobar(int Id) throws SQLException {
        connect();
        preparedStatement = connection.prepareStatement("UPDATE `tallerservicio`.`servicio_pintura` SET `estado` = 'Aprobado' WHERE (`idServicio_Pintura` = '" + Id + "')");
        preparedStatement.execute();
        close();
    }

    public void SinAprobacion(int Id) throws SQLException {
        connect();
        preparedStatement = connection.prepareStatement("UPDATE `tallerservicio`.`servicio_pintura` SET `estado` = 'Sin Aprobación' WHERE (`idServicio_Pintura` = '" + Id + "')");
        preparedStatement.execute();
        close();
    }

    public void Delete(int Id) throws SQLException {
        connect();
        preparedStatement = connection.prepareStatement("DELETE FROM `tallerservicio`.`servicio_pintura` WHERE (`idServicio_Pintura` = '" + Id + "')");
        preparedStatement.execute();
        close();
    }

//    public List<reparacionCliente> fyndAll(Type String) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
    public void Reparacion(int Id) throws SQLException {
        connect();
        preparedStatement = connection.prepareStatement("UPDATE `tallerservicio`.`servicio_pintura` SET `estado` = 'En Reparación' WHERE (`idServicio_Pintura` = '" + Id + "')");
        preparedStatement.execute();
        close();
    }

    public void Finalizado(int Id) throws SQLException {
        connect();
        preparedStatement = connection.prepareStatement("UPDATE `tallerservicio`.`servicio_pintura` SET `estado` = 'Finalizado' WHERE (`idServicio_Pintura` = '" + Id + "')");
        preparedStatement.execute();
        close();
    }

}
