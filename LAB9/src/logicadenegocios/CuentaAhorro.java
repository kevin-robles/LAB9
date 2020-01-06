/**
 * Una clase simple de una cuenta de ahorro
 *
 * @author Kevin Robles, Oscar Trejos
 * @version 06/01/2020
 */
package logicadenegocios;
import java.util.Calendar;

public class CuentaAhorro extends Cuenta{
    
  private static int sCantCuentas = 0;
  private double cuotaMantenimiento;
  
  /**
   * Metodo constructor para cuenta de ahorro con cuota de mantenimiento por omision
   * @param pDuenio objeto propietario de la cuenta
   * @param pMonto monto inicial de la cuenta
   */
  public CuentaAhorro(Cliente pDuenio,double pMonto){
    super("Cuenta de Ahorro",++sCantCuentas,pDuenio,pMonto);
    setCuotaMantenimiento(300);//couta de mantenimiento por omision
  }
  
  /**
   * Metodo constructor para cuenta de ahorro con cuota de mantenimiento definida por el usuario
   * @param pDuenio objeto propietario de la cuenta
   * @param pMonto monto inicial de la cuenta
   * @param pCuota couta de mantenimiento de la cuenta
   */
  public CuentaAhorro(Cliente pDueño,double pMonto,double pCuota){
    super("Cuenta de Ahorro",++sCantCuentas,pDueño,pMonto);
    setCuotaMantenimiento(pCuota);
  }

  public static void setCantCuentas(int sCantCuentas) {
    CuentaAhorro.sCantCuentas = sCantCuentas;
  }
  
  public void setCuotaMantenimiento(double pCoutaMantenimiento) {
    this.cuotaMantenimiento = pCoutaMantenimiento;
  }
  
  public static int getCantCuentas() {
    return sCantCuentas;
  }

  public double getCuotaMantenimiento() {
    return cuotaMantenimiento;
  }
  
  /**
   * Metodo para realizar el cobro de las comisiones
   * Se realiza solo si es el primer dia del mes
   * @return Mensaje de exito, de no aplicar se devuelve cadena de caracteres vacia
   */
  public String cobrarComisiones(){
    String msg = "";
    Calendar calendario;
    calendario =  Calendar.getInstance();
    
    int dia = calendario.get(Calendar.DAY_OF_MONTH);
    if(dia == 1){
      retirar(cuotaMantenimiento);
      numOperaciones = 0;//se reinicia para el mes siguiente
      msg += "Se cobró por comisión : "+cuotaMantenimiento;
    }
    return msg;
  }
  
}
