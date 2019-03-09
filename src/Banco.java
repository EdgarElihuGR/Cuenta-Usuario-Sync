
import java.util.ArrayList;

public class Banco {

    private Cuenta cuenta;
    private String nombre;
    private boolean esBanco1 = false;

    public Banco(String nombre, Cuenta cuenta) {
        this.cuenta = cuenta;
        this.nombre = nombre;
    }

//Arreglo de usuarios
    ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

    //Arreglo de cuentas o ArrayList
    ArrayList<Cuenta> cuentas = new ArrayList<Cuenta>();

    //Arreglo de bancos
    ArrayList<Banco> bancos = new ArrayList<Banco>();

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public synchronized void transferir(String nombreUsuario, Cuenta cuentaOrigen, int randomDestino, int monto) {
        Cuenta cuentaDestino = cuentas.get(randomDestino);
        System.out.println("_________________ Inicio " + nombreUsuario + "__________________");
        System.out.println("Transaccion por: " + nombreUsuario + " de: " + monto + " para " + cuentaDestino.getNombre());

        cuentaOrigen.Retirar(monto, nombreUsuario);
        cuentaDestino.Depositar(monto, cuentaDestino.getNombre());

        System.out.println("Saldo de " + cuentaOrigen.getNombre() + ": " + cuentaOrigen.getSaldo() + " Saldo de " + cuentaDestino.getNombre() + ": " + cuentaDestino.getSaldo());

    }

    public synchronized void transferirOtro(String nombreUsuario, Banco bancoOrigen, Cuenta cuentaOrigen, int randomDestino, int monto) {

        String nombreBancoDestino = (this.bancos.indexOf(this) == 0) ? bancos.get(1).getNombre() : bancos.get(0).getNombre();
        String nombreCuentaDestino = (this.bancos.indexOf(this) == 0) ? bancos.get(1).cuentas.get(randomDestino).getNombre() : bancos.get(0).cuentas.get(randomDestino).getNombre();

        System.out.println("_________________ Inicio " + nombreUsuario + " Banco: " + bancoOrigen.getNombre() + "__________________");
        System.out.println("Transaccion por: " + nombreUsuario + " Banco: " + bancoOrigen.getNombre() + " de: " + monto + " para " + nombreCuentaDestino + " Banco: " + nombreBancoDestino);

        cuentaOrigen.Retirar(monto, nombreUsuario);

        if (this.bancos.indexOf(this) == 0) {

            esBanco1 = true;
            bancos.get(1).cuentas.get(randomDestino).Depositar(monto, bancos.get(1).cuentas.get(randomDestino).getNombre());
            System.out.println("Saldo de " + cuentaOrigen.getNombre() + ": " + cuentaOrigen.getSaldo() + " Banco: " + bancoOrigen.getNombre() + " Saldo de " + nombreCuentaDestino + ": " + bancos.get(1).cuentas.get(randomDestino).getSaldo() + " Banco: " +nombreBancoDestino);

        } else {
            esBanco1 = false;
            bancos.get(0).cuentas.get(randomDestino).Depositar(monto, bancos.get(0).cuentas.get(randomDestino).getNombre());
            System.out.println("Saldo de " + cuentaOrigen.getNombre() + ": " + cuentaOrigen.getSaldo() + " Banco: " + bancoOrigen.getNombre() + " Saldo de " + nombreCuentaDestino + ": " + bancos.get(0).cuentas.get(randomDestino).getSaldo()+ " Banco: " +nombreBancoDestino);

        }

    }

}
