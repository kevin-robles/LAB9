/**
 * Una clase simple de una cuenta de corriente
 *
 * @author Kevin Robles, Oscar Trejos
 * @version 06/01/2020
 */
package logicadenegocios;

import java.util.Calendar;

public class CuentaCorriente extends Cuenta {
  
  private static int scantCuentas = 0;
  private int operacionesExentas;
  private double cuotaOperaciones;
  
  
  /**
   * Contructor para la clase CuentaCorriente
   * @param pDueño
   * @param pMonto 
   */
  public  CuentaCorriente(Cliente pDueño, double pMonto) {
    super ("Cuenta Corriente ",++scantCuentas, pDueño,pMonto);
    setOperacionesExentas(30);
    setCuotaOperaciones(30);
  }
  
  
  /**
   * Constructor para la clase CunetaCorriente.
   * @param pDueño
   * @param pMonto
   * @param pOperExentas
   * @param pCuotaOper 
   */
  public  CuentaCorriente(Cliente pDueño, double pMonto,
  int pOperExentas, double pCuotaOper) {
    super ("Cuenta Corriente ",++scantCuentas, pDueño,pMonto);
    setOperacionesExentas(pOperExentas);
    setCuotaOperaciones(pCuotaOper);
  }
  
  
  public void setOperacionesExentas(int pOperacionesExentas){
    this.operacionesExentas = pOperacionesExentas;  
  }
  
  public int getOperacionesExentas(){
    return this.operacionesExentas ;  
  }
  
  public void setCuotaOperaciones(double pCuotaOperaciones){
    this.cuotaOperaciones = pCuotaOperaciones;  
  } 
  
  public double getCuotaOperaciones(){
    return this.cuotaOperaciones ;  
  }
  
  /**
   * 
   * @return El monto que se cobró en el mes.
   */
  public String cobrarComisiones(){
    String msg = " ";
    double operacNoExentas;
    double monto;
    Calendar calendario = Calendar.getInstance();
    int dia = calendario.get(Calendar.DAY_OF_MONTH);
    if (dia == 1){
      operacNoExentas = numOperaciones - getCuotaOperaciones();
      if(operacNoExentas > 0){
        monto = getCuotaOperaciones() * operacNoExentas;
        retirar(monto);
        msg = "Se cobró por comisión: "+ monto;
      }
      numOperaciones = 0;
      
    }
    return msg;
  }
    
    
}
  
