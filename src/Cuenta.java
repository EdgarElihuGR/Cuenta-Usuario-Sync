
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cuenta {

    private int limite, saldo;
    private int limiteInf = 0;
    private String nombre;

    public Cuenta(int limite, int saldo, String nombre) {
        this.limite = limite;
        this.saldo = saldo;
        this.nombre = nombre;
    }

    public synchronized int getLimite() {
        return limite;
    }

    public synchronized int getSaldo() {
        return saldo;
    }

    public synchronized String getNombre() {
        return nombre;
    }

    public synchronized void setLimite(int limite) {
        this.limite = limite;
    }

    public synchronized void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public synchronized void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Cuenta{" + "limite=" + limite + ", saldo=" + saldo + ", nombre=" + nombre + '}';
    }

    public synchronized void Retirar(int monto, String nombre) {
        int i = 0;

        try {
            System.out.println("_________________" + nombre + "__________________");
            System.out.println("Saldo actual: " + saldo + " Saldo a retirar: " + monto);
            int cambioRetiro = 0;

            if (monto > saldo) {
                cambioRetiro = monto - saldo;
                monto = monto - cambioRetiro;
                saldo -= monto;
                System.out.println("Saldo: " + saldo + " Retiro pendiente: " + cambioRetiro);
                System.out.println("______________________________________________");

                while (cambioRetiro > saldo && i <= 5) {
                    System.out.println(nombre + " no puede retirar = " + cambioRetiro);
                    System.out.println("Sin saldo en la cuenta, Saldo actual: " + saldo + "-" + nombre);
                    wait();

                    System.out.println("__________________________________________");
                    System.out.println(nombre + " despues de esperar");
                    System.out.println("Saldo Pendiente: " + cambioRetiro);
                    i++;
                }
                if (i > 5) {
                    System.out.println("__________________________________________");
                    System.out.println(nombre + " no pudo retirar: $" + cambioRetiro);
                    System.out.println("Se exedio el tiempo permitido");
                } else {
                    saldo -= monto;
                    System.out.println(nombre + " pudo retirar: $" + cambioRetiro);
                    System.out.println("Saldo final:" + saldo);
                    notify();
                }
            } else {
                saldo -= monto;
                System.out.println("Monto retirado: $" + monto);
                System.out.println("Saldo final:" + saldo);
                notify();
            }

        } catch (InterruptedException ex) {
            Logger.getLogger(Cuenta.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public synchronized void Depositar(int monto, String nombre) {
        int i = 0;

        try {
            System.out.println("_________________" + nombre + "__________________");
            System.out.println("Saldo actual: " + saldo + " Saldo a despositar: " + monto);
            int cambioDeposito = 0;

            if ((saldo + monto) > limite) {
                cambioDeposito = monto - (limite - saldo);
                monto = limite - saldo;
                saldo += monto;
                System.out.println("Saldo: " + saldo + "Saldo pendiente: " + cambioDeposito);
                System.out.println("______________________________________________");
                monto = cambioDeposito;
                while ((saldo + cambioDeposito) >= limite && i <= 5) {
                    System.out.println(nombre + " no puede depositar = " + cambioDeposito);
                    System.out.println("Saldo actual: " + saldo);
                    System.out.println("______________________________________________");
                    wait();
                    //System.out.println("_________________________________________");
                    System.out.println(nombre + " despues de esperar");
                    System.out.println("Saldo pendiente: " + cambioDeposito);
                    i++;
                }

                if (i > 5) {
                    System.out.println(nombre + " no pudo depositar: $" + cambioDeposito);
                    System.out.println("Se exedio el tiempo permitido");

                } else {
                    saldo += monto;
                    System.out.println(nombre + " pudo depositar: $" + cambioDeposito);
                    System.out.println("Saldo Final:" + saldo);
                    notify();
                }
            } else {
                saldo += monto;
                System.out.println("Monto depositado: $" + monto);
                System.out.println("Saldo Final:" + saldo);
                notify();
            }

        } catch (InterruptedException ex) {
            Logger.getLogger(Cuenta.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public synchronized void Consultar(String nombre) {
        System.out.println("_________________" + nombre + "__________________");
        System.out.println("Consulta de Saldo");
        System.out.println("" + toString());
    }
}
