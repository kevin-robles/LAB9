/**
 * Una clase simple de una cuenta bancaria
 *
 * @author Kevin Robles, Oscar Trejos
 * @version 06/01/2020
 */
package logicadenegocios;
import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public abstract class Cuenta{
    
  protected int numCuenta = 0;
  protected Cliente duenio = null;
  protected double saldo = 0;
  protected Date fechaCreacion;
  protected ArrayList<Operacion> operaciones;
  protected int numOperaciones = 0;
  protected String tipoCuenta;
  
  /**
   * Constructor para objetos de tipo cuenta
   * 
   * @param pTipo tipo de cuenta
   * @param pNumero numero de cuenta
   * @param pDuenio objeto del propietario
   * @param pMonto monto inicial de la cuenta
   */
  public Cuenta(String pTipo,int pNumero,Cliente pDuenio, double pMonto){
    setTipoCuenta(pTipo);
    setNumCuenta(pNumero);
    operaciones = new ArrayList<Operacion>();
    depositar(pMonto);
    setDuenio(pDuenio);
    setFechaCreacion();
  }
  
  public void setNumCuenta(int pNumCuenta){
    numCuenta = pNumCuenta;
  }
  
  public void setDuenio(Cliente pCliente){
    duenio = pCliente;
  }
  
  public void setFechaCreacion(){
    Calendar calendario;
    calendario = Calendar.getInstance();
    fechaCreacion = calendario.getTime();
  }
  
  public void setTipoCuenta(String pTipoCuenta){
    this.tipoCuenta = pTipoCuenta;
  }
  
  public int getNumCuenta(){
    return numCuenta;
  }
  
  public Cliente getDuenio(){
    return duenio;
  }
  
  public double getSaldo(){
    return saldo;
  }
  
  public String getFechaCreacion(){
    SimpleDateFormat mascara = new SimpleDateFormat("dd/MM/yy");
    return mascara.format(fechaCreacion);
  }
  
  public String getTipoCuenta(){
    return this.tipoCuenta; 
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
   * Metodo abstracto para el cobro de comisiones
   * @return mensaje de error, o exito
   */
  public abstract String cobrarComisiones();
  
  /**
   * Metodo para convertir el objeto en una cadena de caracteres
   * 
   * @return el objeto en cadena de caracteres
   */
  public String toString(){
    String msg;
    msg = "Cuenta Número: "+getNumCuenta()+"\n";
    msg+= "Tipo: "+ getTipoCuenta()+"\n";
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
