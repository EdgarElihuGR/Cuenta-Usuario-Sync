
import java.util.Random;

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
            int opc = ran.nextInt(3) + 1;
            int depositar = ran.nextInt(200) + 1;
            int retirar = ran.nextInt(100) + 1;
            int transferir = ran.nextInt(100) + 1;
            int randomDestino = ran.nextInt(4) + 1;

            switch (opc) {
//                case 1:
//                    cuenta.Depositar((depositar),"Usuario: "+nombreUsuario);
//                    
//                    break;
//                case 2:
//                    cuenta.Retirar((retirar),"Usuario: "+nombreUsuario);
//                    break;
//                 
                case 1:

                    cuenta.Consultar(nombreUsuario);
                    break;
                case 2:

                    banco.transferir(nombreUsuario, cuenta, randomDestino, transferir);
                    break;
                case 3:

                    banco.transferirOtro(nombreUsuario ,banco, cuenta ,randomDestino, transferir);
                    break;
            }

        }
        System.out.println("Terminado " + nombreUsuario);

    }

}
