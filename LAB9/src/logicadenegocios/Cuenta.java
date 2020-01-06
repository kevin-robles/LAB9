/**
 * Una clase simple de una cuenta bancaria
 *
 * @author Kevin Robles
 * @version 16/12/2019
 */
package logicadenegocios;
import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Cuenta{
    
  private int numCuenta = 0;
  private Cliente duenio = null;
  private double saldo = 0;
  private static int cantCuentas = 0;
  private Date fechaCreacion;
  private ArrayList<Operacion> operaciones;
  private int numOperaciones = 0;
  
  /**
   * Constructor para objetos de tipo cuenta
   * 
   * @param pNombre nombre del dueño de la cuenta
   */
  public Cuenta(Cliente pDuenio, double pMonto){
    operaciones = new ArrayList<Operacion>();
    cantCuentas++;
    setNumCuenta(cantCuentas);
    depositar(pMonto);
    setDuenio(pDuenio);
    setFechaCreacion();
  }
  
  
  public int getNumCuenta(){
    return numCuenta;
  }
  
  public void setNumCuenta(int pNumCuenta){
    numCuenta = pNumCuenta;
  }
  
  public Cliente getDuenio(){
    return duenio;
  }
  
  public void setDuenio(Cliente pCliente){
    duenio = pCliente;
  }
  
  public double getSaldo(){
    return saldo;
  }
  
  
  public String getFechaCreacion(){
    SimpleDateFormat mascara = new SimpleDateFormat("dd/MM/yy");
    return mascara.format(fechaCreacion);
  }
  
  public void setFechaCreacion(){
    Calendar calendario;
    calendario = Calendar.getInstance();
    fechaCreacion = calendario.getTime();
  }
  
  
  private boolean validarDeposito(double pMonto){
    return pMonto > 0;
  }
    
  /**
   * Metodo para depositar dinero en la cuenta
   * 
   * @param pMonto monto del deposito
   * @return mensaje con el nuevo monto de poder realizarse el deposito
   */
  public String depositar(double pMonto){
    if(validarDeposito(pMonto)){
      saldo+= pMonto;
      Operacion nuevaOperacion = new Operacion(++numOperaciones,"deposito",pMonto);
      operaciones.add(nuevaOperacion);
      return "El saldo actual después del depósito es : "+saldo;
    }else{
      return "Monto ingresado inválido";
    }
  }
  
  
  private boolean validarRetiro(double pMonto){
    return pMonto <= saldo;  
  }
  
  /**
   * Metodo para retirar dinero
   * 
   * @param pMonto el monto de retiro
   * @return mensaje con nuevo saldo, si se puede aplicar el retiro
   */
  public String retirar(double pMonto){
    if(validarRetiro(pMonto)){
      saldo-=pMonto;
      Operacion nuevaOperacion = new Operacion(++numOperaciones,"retiro\t",pMonto);
      operaciones.add(nuevaOperacion);
      return "El saldo actual después del retiro es : "+saldo;
    }else{
      return "No tiene suficiente dinero";
    }  
  }
  
  /**
   * Metodo para convertir el objeto en una cadena de caracteres
   * 
   * @return el objeto en cadena de caracteres
   */
  public String toString(){
    String msg;
    msg = "Cuenta Número: "+getNumCuenta()+"\n";
    msg+= "Fecha Creación: "+getFechaCreacion()+"\n";
    msg+= "Dueño: "+duenio.toString()+"\n";
    msg+= "Saldo: "+getSaldo()+"\n";
    msg+= "Registro de Operaciones\n";
    msg+= "Numero\tFecha\t\tOperacion\tMonto"+"\n";
    for(int i = 0;i<operaciones.size();i++){
        Operacion unaOp = (Operacion) operaciones.get(i);
        msg+= unaOp.toString();
    }
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
    
    Cuenta cuenta = (Cuenta) o;
    return numCuenta == cuenta.getNumCuenta();
  }
  
}
