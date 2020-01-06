/**
 * Pequeña clase de operaciones para una cuenta bancaria
 *
 * @author Kevin Robles, Oscar Trejos
 * @version 06/01/2020
 */
package logicadenegocios;
import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;

public class Operacion{
  private int numero;
  private String tipo;
  private double monto;
  private Date fechaOperacion;
    
  /**
   * Constructor para objetos de tipo Operacion
   * 
   * @param pNumero numero de operacion, pTipo tipo de operacion,
   *     pMonto monto de la operacion
   */
  public Operacion(int pNumero,String pTipo,double pMonto){
    setNumero(pNumero);
    setTipo(pTipo);
    setMonto(pMonto);
    setFechaOperacion();
  }
    
    
  public void setNumero(int pNumero){
    this.numero = pNumero;
  }
  
  
  public void setTipo(String pTipo){
    this.tipo = pTipo;
  }
  
  
  public void setMonto(double pMonto){
    this.monto = pMonto;
  }
  
  
  private void setFechaOperacion(){
    Calendar calendario;
    calendario = Calendar.getInstance();
    fechaOperacion = (Date)calendario.getTime();
  }
  
  
  public int getNumero(){
    return this.numero;
  }
  
  
  public String getTipo(){
    return this.tipo;  
  }
  
 
  public double getMonto(){
    return this.monto;
  }
  
  
  public String getFechaOperacion(){
    SimpleDateFormat mascara = new SimpleDateFormat("dd/MM/yy");
    return mascara.format(fechaOperacion);
  }
  
  
  /**
   * Metodo para convertir el objeto en una cadena de caracteres
   * 
   * @return el objeto en cadena de caracteres
   */
  public String toString(){
    String msg = "";
    msg = getNumero()+"\t"+getFechaOperacion()+"\t"+getTipo()+
        "\t"+getMonto()+"\n";
    return msg;
  }
    
}
