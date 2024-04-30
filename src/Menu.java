import java.util.Scanner;

public class Menu {

    public static void crearUsuario() {
        Usuario usuario = new Usuario();
        System.out.println("Usuario creado correctamente");
        System.out.println("Nombre: " + usuario.getNombre());
        System.out.println("Apellido: " + usuario.getApellido());
        System.out.println("DNI: " + usuario.getDNI());
        System.out.println("Número de teléfono: " + usuario.getTelefono());
    }

    public void menuInicial(Usuario usuario) {
        int select = -1;
        while (select != 0) {
            Scanner sc = new Scanner(System.in);
            try {
                System.out.println("""
                        1.- ACCEDER A CUENTA
                        2.- CREAR CUENTA NUEVA
                        3.- CREAR USUARIO (SIN IMPLEMENTACION FUNCIONAL ACTUALMENTE)
                        0.- SALIR""");
                select = sc.nextInt();
                switch (select) {
                    case 0:
                        break;
                    case 1:
                        System.out.println("A cual cuenta deseas acceder?");
                        if (usuario.showCuentas()) {
                            int cuentaSelect = sc.nextInt();
                            if (cuentaSelect >= 1 && cuentaSelect <= usuario.getCuentas().size()) {
                                Cuenta cuenta = usuario.getCuentas().get(cuentaSelect - 1);
                                menuCuenta(cuenta);
                            } else {
                                System.out.println("Cuenta no válida.");
                            }
                        }
                        break;
                    case 2:
                        System.out.println("Procederemos a crear una nueva cuenta");
                        Cuenta cuenta = new Cuenta();
                        usuario.addCuenta(cuenta);
                        break;
                    case 3:
                    /*como ya hay un usuario creado, no implementamos esta funcion
                    ni creamos otro menu que nos de acceso a los diferentes posibles
                    usuarios, estamos dando por hecho que habra solo un usuario
                    que sera el que se registre al iniciar el programa
                    crearUsuario()
                    */
                        System.out.println("Ya hay un usuario registrado");
                        break;
                    default:
                        System.out.println("Número no reconocido");
                        break;
                }
                System.out.println();
            } catch (Exception e) {
                System.out.println("Uoop! Error!");
            }
        }
    }

    public void menuCuenta(Cuenta cuenta) {
        Scanner sc = new Scanner(System.in);
        int select = -1;
        while (select != 0) {
            try {
                System.out.println("""
                        1.- INFORMACION DE LA CUENTA 
                        2.- TRANSFERIR DINERO 
                        3.- HACER UN BIZUM 
                        4.- HUCHA
                        5.- INVERSIONES
                        0.- SALIR""");
                select = sc.nextInt();
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
