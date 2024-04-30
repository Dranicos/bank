import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Menu menu = new Menu();

        System.out.println("BIENVENIDO A BANCO TORRE LA VEGA");
        System.out.println("NO HAY USUARIOS REGISTRADOS");

        Usuario usuario = new Usuario();

        System.out.println("Bienvenido : " + usuario.getNombre());

        menu.menuInicial(usuario);

    }
}
