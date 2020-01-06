/**
 * Una clase simple de una cuenta de corriente
 *
 * @author Kevin Robles, Oscar Trejos
 * @version 06/01/2020
 */
package logicadenegocios;
import java.util.Calendar;

public class CuentaCorriente extends Cuenta {
  
  private static int sCantCuentas = 0;
  private int operacionesExentas;
  private double cuotaOperaciones;
  
  /**
   * Contructor para la clase CuentaCorriente con datos por omision
   * @param pDuenio propietario de la cuenta
   * @param pMonto monto inicial de la cuenta
   */
  public  CuentaCorriente(Cliente pDuenio, double pMonto) {
    super ("Cuenta Corriente ",++sCantCuentas, pDuenio,pMonto);
    setOperacionesExentas(30);
    setCuotaOperaciones(30);
  }
  
  /**
   * Constructor para la clase CunetaCorriente con datos ingresados por el cliente
   * @param pDueño propietario de la cuenta
   * @param pMonto monto inicial de la cuenta
   * @param pOperExentas valor de las operaciones exentas
   * @param pCuotaOper valor de la couta por operacion
   */
  public  CuentaCorriente(Cliente pDueño, double pMonto,
  int pOperExentas, double pCuotaOper) {
    super ("Cuenta Corriente ",++sCantCuentas, pDueño,pMonto);
    setOperacionesExentas(pOperExentas);
    setCuotaOperaciones(pCuotaOper);
  }

  public static void setsCantCuentas(int sCantCuentas) {
    CuentaCorriente.sCantCuentas = sCantCuentas;
  }
    
  public void setOperacionesExentas(int pOperacionesExentas){
    this.operacionesExentas = pOperacionesExentas;  
  }
  
  public void setCuotaOperaciones(double pCuotaOperaciones){
    this.cuotaOperaciones = pCuotaOperaciones;  
  }

  public static int getsCantCuentas() {
    return sCantCuentas;
  }
  
  public int getOperacionesExentas(){
    return this.operacionesExentas ;  
  }
  
  public double getCuotaOperaciones(){
    return this.cuotaOperaciones ;  
  }
  
  /**
   * Metodo para realizar el cobro de las comisiones
   * Se realiza solo si es el primer dia del mes
   * @return Mensaje de exito, de no aplicar se devuelve cadena de caracteres vacia
   */
  public String cobrarComisiones(){
    String msg = " ";
    double operacNoExentas;
    double monto;
    Calendar calendario = Calendar.getInstance();
    int dia = calendario.get(Calendar.DAY_OF_MONTH);
    
    if (dia == 1){
      operacNoExentas = numOperaciones - getOperacionesExentas();
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
  
