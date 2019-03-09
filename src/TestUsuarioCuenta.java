
import java.util.ArrayList;

public class TestUsuarioCuenta {

    public static void main(String[] args) {

        //Declaracion e inicializacion de cuentas
        //Cuentas bancos
        Cuenta cuentaBancomer = new Cuenta(10000, 0, "Bancomer");
        Cuenta cuentaSantander = new Cuenta(10000, 0, "Santander");

        //Cuentas usuarios
        Cuenta cuenta1 = new Cuenta(200, 100, "Edgar");
        Cuenta cuenta2 = new Cuenta(200, 100, "Uriel");
        Cuenta cuenta3 = new Cuenta(200, 100, "Maria");
        Cuenta cuenta4 = new Cuenta(200, 100, "Daniela");
        Cuenta cuenta5 = new Cuenta(200, 100, "Jose");
        Cuenta cuenta6 = new Cuenta(200, 100, "Manuel");
        Cuenta cuenta7 = new Cuenta(200, 100, "Citlali");
        Cuenta cuenta8 = new Cuenta(200, 100, "Jorge");
        Cuenta cuenta9 = new Cuenta(200, 100, "Yousef");
        Cuenta cuenta10 = new Cuenta(200, 100, "Sofia");

        //Declaracion e inicializacion de bancos
        Banco bancomer = new Banco("Bancomer", cuentaBancomer);
        Banco santander = new Banco("Santander", cuentaSantander);

        //Declaracion e inicializacion de usuarios
        Usuario usuario1 = new Usuario("Edgar", cuenta1, bancomer);
        Usuario usuario2 = new Usuario("Uriel", cuenta2, bancomer);
        Usuario usuario3 = new Usuario("Maria", cuenta3, bancomer);
        Usuario usuario4 = new Usuario("Daniela", cuenta4, bancomer);
        Usuario usuario5 = new Usuario("Jose", cuenta5, bancomer);
        
        Usuario usuario6 = new Usuario("Manuel", cuenta6, santander);
        Usuario usuario7 = new Usuario("Citlali", cuenta7, santander);
        Usuario usuario8 = new Usuario("Jorge", cuenta8, santander);
        Usuario usuario9 = new Usuario("Yousef", cuenta9, santander);
        Usuario usuario10 = new Usuario("Sofia", cuenta10, santander);

        //Arreglo de bancos
        bancomer.bancos.add(bancomer);
        bancomer.bancos.add(santander);
        
        santander.bancos.add(bancomer);
        santander.bancos.add(santander);

        //Bancos se le agregan las cuentas de los usuarios
        bancomer.cuentas.add(cuenta1);
        bancomer.cuentas.add(cuenta2);
        bancomer.cuentas.add(cuenta3);
        bancomer.cuentas.add(cuenta4);
        bancomer.cuentas.add(cuenta5);

        santander.cuentas.add(cuenta6);
        santander.cuentas.add(cuenta7);
        santander.cuentas.add(cuenta8);
        santander.cuentas.add(cuenta9);
        santander.cuentas.add(cuenta10);

        /*Usuario[] usuariosBan = new Usuario[5];
        Cuenta[] cuentas = new Cuenta[5];
         */
        //bancomer.start();
        usuario1.start();
        usuario2.start();
        usuario3.start();
        usuario4.start();
        usuario5.start();
        /*
        usuario6.start();
        usuario7.start();
        usuario8.start();
        usuario9.start();
        usuario10.start();
        */

    }

}
