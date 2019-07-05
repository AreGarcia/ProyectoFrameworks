/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author deysi
 */
public class Tecnico {
    
    private int idServicio_Pintura;
    private int idServicio;
    private String numChasis;
    private int idTipo_Pintura;
    private String color;
    private int idTipo_Enderezado;
    private double manoDeObra;
    private double total;
    private String estado;
    private String tecnico;

    /**
     * @return the idServicio_Pintura
     */
    public int getIdServicio_Pintura() {
        return idServicio_Pintura;
    }

    /**
     * @param idServicio_Pintura the idServicio_Pintura to set
     */
    public void setIdServicio_Pintura(int idServicio_Pintura) {
        this.idServicio_Pintura = idServicio_Pintura;
    }

    /**
     * @return the idServicio
     */
    public int getIdServicio() {
        return idServicio;
    }

    /**
     * @param idServicio the idServicio to set
     */
    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }

    /**
     * @return the numChasis
     */
    public String getNumChasis() {
        return numChasis;
    }

    /**
     * @param numChasis the numChasis to set
     */
    public void setNumChasis(String numChasis) {
        this.numChasis = numChasis;
    }

    /**
     * @return the idTipo_Pintura
     */
    public int getIdTipo_Pintura() {
        return idTipo_Pintura;
    }

    /**
     * @param idTipo_Pintura the idTipo_Pintura to set
     */
    public void setIdTipo_Pintura(int idTipo_Pintura) {
        this.idTipo_Pintura = idTipo_Pintura;
    }

    /**
     * @return the color
     */
    public String getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * @return the idTipo_Enderezado
     */
    public int getIdTipo_Enderezado() {
        return idTipo_Enderezado;
    }

    /**
     * @param idTipo_Enderezado the idTipo_Enderezado to set
     */
    public void setIdTipo_Enderezado(int idTipo_Enderezado) {
        this.idTipo_Enderezado = idTipo_Enderezado;
    }

    /**
     * @return the manoDeObra
     */
    public double getManoDeObra() {
        return manoDeObra;
    }

    /**
     * @param manoDeObra the manoDeObra to set
     */
    public void setManoDeObra(double manoDeObra) {
        this.manoDeObra = manoDeObra;
    }

    /**
     * @return the total
     */
    public double getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(double total) {
        this.total = total;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * @return the tecnico
     */
    public String getTecnico() {
        return tecnico;
    }

    /**
     * @param tecnico the tecnico to set
     */
    public void setTecnico(String tecnico) {
        this.tecnico = tecnico;
    }


    
}
