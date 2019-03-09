
import java.util.ArrayList;

public class Banco {

    private Cuenta cuenta;

    public Banco(String nombre, Cuenta cuenta) {
        this.cuenta = cuenta;
    }

//Arreglo de usuarios
    ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

    //Arreglo de cuentas o ArrayList
    ArrayList<Cuenta> cuentas = new ArrayList<Cuenta>();

    //Arreglo de bancos
    ArrayList<Banco> bancos = new ArrayList<Banco>();

    public synchronized void transferir(String nombreUsuario, Cuenta cuentaOrigen, int randomDestino, int monto) { //Cuenta origen, random, monto
        System.out.println("_________________" + nombreUsuario + "__________________");
        System.out.println("Transaccion de: " + monto + " para " + cuentas.get(randomDestino).getNombre());

        System.out.println("***********************INICIO***********************");
        
//        cuentaOrigen.Retirar(monto, nombreUsuario);
        int saldoOrigen = cuentaOrigen.getSaldo();
        saldoOrigen -= monto;
        cuentaOrigen.setSaldo(saldoOrigen);
        cuentas.get(randomDestino).Depositar(monto, nombreUsuario);

        System.out.println("Saldo cuenta origen:" + cuentaOrigen.getSaldo() + " Saldo cuenta destino: "+cuentas.get(randomDestino).getNombre()+ cuentas.get(randomDestino).getSaldo());

        System.out.println("**********************FINAL************************");

    }

    public synchronized void transferirOtro(String nombreUsuario, Cuenta cuenta) {//Banco, cuenta destino, monto

    }

}
