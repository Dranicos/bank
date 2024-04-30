import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        Banca banca = new Banca();

        System.out.println("BIENVENIDO A BANCO TORRE LA VEGA");
        System.out.println("NO HAY USUARIOS REGISTRADOS");

        //creacion de usuario y cuenta por defecto
        Usuario usuarioDefault = new Usuario(123456789 ,"Antonio", "Lopez", "02308928G");
        banca.addUsuario(usuarioDefault);
        Cuenta cuentaDefault = new Cuenta("ES12345678901234567890", 2000);
        usuarioDefault.addCuenta(cuentaDefault);


        Usuario usuario = new Usuario();
        banca.addUsuario(usuario);
        System.out.println(banca);
        System.out.println("Bienvenido : " + usuario.getNombre());

        menu.menuInicial(usuario);

    }
}
