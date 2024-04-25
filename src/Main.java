public class Main {
    public static void main(String[] args) {

        System.out.println("BIENVENIDO A BANCO TORRE LA VEGA");
        System.out.println("NO HAY USUARIOS REGISTRADOS");
        Usuario usuario = new Usuario();

        System.out.println("USUARIO GENERADO CON EXITO");
        System.out.println("Crea una cuenta");
        Cuenta cuenta = new Cuenta();

        usuario.agregarCuenta(cuenta);

        String string = usuario.toString();
        System.out.println(string);

        int select = -1;
        while (select != 0) {
            try {
                System.out.println("1.- INFORMACION DE LA CUENTA"
                + "2.- TRANSFERIR DINERO"
                + "3.- HACER UN BIZUM"
                + "4.- HUCHA"
                + "5.- INVERSIONES"
                + "6.- CREAR OTRA CUENTA"
                + "0.- SALIR");
                switch (select) {
                    case 0:
                        break;
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    case 6:
                        break;
                    default:
                        System.out.println("Número no reconocido");
                        break;
                }
                System.out.println("\n");
            } catch (Exception e) {
                System.out.println("Uoop! Error!");
            }

        }
    }
}