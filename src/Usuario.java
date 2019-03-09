
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Lhorenzo
 */
public class Usuario extends Thread {

    private String nombreUsuario;
    private Cuenta cuenta;
    private Banco banco;

    public Usuario(String nombreUsuario, Cuenta cuenta, Banco banco) {
        this.nombreUsuario = nombreUsuario;
        this.cuenta = cuenta;
        this.banco = banco;
    }

    @Override
    public void run() {
        System.out.println("Iniciado " + nombreUsuario);
        Random ran = new Random();

        for (int i = 0; i < 5; i++) {
            int opc = ran.nextInt(5) + 1;
            int depositar = ran.nextInt(200) + 1;
            int retirar = ran.nextInt(100) + 1;
            int transferir = ran.nextInt(100) + 1;
            int randomDestino = ran.nextInt(4) + 1;

            switch (opc) {
                case 1:
                    cuenta.Depositar((depositar),"Usuario: "+nombreUsuario);
                    
                    break;
                case 2:
                    cuenta.Retirar((retirar),"Usuario: "+nombreUsuario);
                    break;
                 
                case 3:

                    cuenta.Consultar(nombreUsuario);
                    break;
                case 4:

                    banco.transferir(nombreUsuario, cuenta, randomDestino, transferir);
                    break;
                case 5:

                    banco.transferirOtro(nombreUsuario, cuenta);
                    break;
            }

        }
        System.out.println("Terminado " + nombreUsuario);

    }

}
