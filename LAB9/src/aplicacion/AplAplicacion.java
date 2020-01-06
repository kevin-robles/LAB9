/**
 * Clase que inicia la aplicacion
 *
 * @author Kevin Robles, Oscar Trejos
 * @version 06/01/2020
 */
package aplicacion;
import logicadenegocios.Cliente;
import logicadenegocios.Cuenta;
import logicadenegocios.CuentaAhorro;
import logicadenegocios.CuentaCorriente;

public class AplAplicacion {
  public static void main(String[] args){
    Cliente cliente1 = new Cliente("234","Clark","Kent");
    Cliente cliente2 = new Cliente("568","Bruce","Wayne");
    
    Cuenta cuenta1 = new CuentaAhorro(cliente1,3500);
    //Cuenta cuenta2 = new CuentaCorriente(cliente2,1700);
    
    cuenta1.depositar(1800);
    cuenta1.depositar(2200);
    cuenta1.retirar(350);
    
    //cuenta2.retirar(350);
    
    System.out.println(cuenta1.cobrarComisiones());
    //System.out.println(cuenta2.cobrarComisiones());
    System.out.println();
    System.out.println(cuenta1.toString());
    //System.out.println(cuenta2.toString());
  }
    
}
