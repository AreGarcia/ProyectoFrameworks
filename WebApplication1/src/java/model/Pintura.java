package model;



public class Pintura
{
  private int tipo;
  

  private String nombre;
  

  private double precio;
  


  public Pintura() {}
  


  public String getNombre()
  {
    return nombre;
  }
  


  public void setNombre(String nombre)
  {
    this.nombre = nombre;
  }
  



  public int getTipo()
  {
    return tipo;
  }
  


  public void setTipo(int tipo)
  {
    this.tipo = tipo;
  }
  



  public double getPrecio()
  {
    return precio;
  }
  


  public void setPrecio(double precio)
  {
    this.precio = precio;
  }
}