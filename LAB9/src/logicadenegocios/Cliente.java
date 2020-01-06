/**
 * Una clase simple de un Cliente
 *
 * @author Kevin Robles, Oscar Trejos
 * @version 06/01/2020
 */
package logicadenegocios;

public class Cliente{
  private String cedula;
  private String nombre;
  private String apellido;
  
  /**
   * Constructor para objetos de tipo Cliente
   * 
   * @param pCedula identificador del cliente, pNombre nombre del cliente, 
   *     pApellido apellido del cliente
   */
  public Cliente(String pCedula,String pNombre, String pApellido){
    setCedula(pCedula);
    setNombre(pNombre);
    setApellido(pApellido);
  }
  
  
  public void setCedula(String pCedula){
    this.cedula = pCedula;  
  }
  
  
  public void setNombre(String pNombre){
    this.nombre = pNombre;  
  }
  
  
  public void setApellido(String pApellido){
    this.apellido = pApellido;  
  }
  
  
  public String getCedula(){
    return this.cedula;
  }
  
  
  public String getNombre(){
    return this.nombre;
  }
  
  
  public String getApellido(){
    return this.apellido;
  }
  
  
  /**
   * Metodo para convertir el objeto en una cadena de caracteres
   * 
   * @return el objeto en cadena de caracteres
   */
  public String toString(){
    String msg = "";
    msg = "Cédula:\t"+getCedula()+"\n";
    msg+= "Nombre:\t"+getNombre()+" "+getApellido();
    return msg;
  }
  
  
  /**
   * Metodo para saber si dos objetos son iguales
   * 
   * @param o cualquier tipo de obajeto
   * @return booleano que indica si los objetos son iguales
   */
  public boolean equals(Object o){
    if (this == o){
      return true;
    }
    if(o == null){
      return false ;
    }
    if(getClass() != o.getClass()){
      return false;
    }
    
    Cliente cliente = (Cliente) o;
    return this.cedula.equals(cliente.getCedula()) && this.nombre.equals(cliente.getNombre()) 
        && this.apellido.equals(cliente.getApellido());
  }

}
