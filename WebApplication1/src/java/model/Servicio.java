package model;



public class Servicio
{
  private int idServicio;
  

  private String Nombre_Servicio;

  


  public Servicio() {}

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
     * @return the Nombre_Servicio
     */
    public String getNombre_Servicio() {
        return Nombre_Servicio;
    }

    /**
     * @param Nombre_Servicio the Nombre_Servicio to set
     */
    public void setNombre_Servicio(String Nombre_Servicio) {
        this.Nombre_Servicio = Nombre_Servicio;
    }
  

}