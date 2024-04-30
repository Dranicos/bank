import java.util.List;
import java.util.Scanner;

public class Menu {
    Banca banca = new Banca();

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
                System.out.println("OPCION INCORRECTA, SELECCIONE UNA OPCION VALIDA");
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
                        System.out.println("Tu IBAN es: " + cuenta.getIBAN());
                        System.out.println("Tu saldo total es de: " + cuenta.saldoTotal());
                        break;
                    case 2:
                        System.out.println("Introduce el IBAN de la cuenta a la que quieres enviar dinero");
                        String iban = sc.next();
                        System.out.println("Introduzca el monto que quiere transferir");
                        double monto = sc.nextDouble();
                        System.out.println(cuenta.getIBAN());
                        System.out.println(iban);
                        banca.transferirDinero(cuenta.getIBAN(), iban, monto);
                        break;
                    case 3:
                        //Este es el mismo caso que el iban, solo que con el numero de telefono, lo que
                        //habria que asignar serian las limitaciones de cuentas que puedan hacer bizum
                        break;
                    case 4:
                        menuHucha(cuenta);
                        break;
                    case 5:
                        menuInversion(cuenta);
                        break;
                    default:
                        System.out.println("Número no reconocido");
                        break;
                }
                System.out.println("\n");
            } catch (Exception e) {
                System.out.println("OPCION INCORRECTA, SELECCIONE UNA OPCION VALIDA");
            }
        }
    }

    public void menuHucha(Cuenta cuenta) {
        int select = -1;
        while (select != 0) {
            Scanner sc = new Scanner(System.in);
            try {
                System.out.println("""
                        1.- SALDO EN LAS HUCHAS
                        2.- CREAR NUEVA HUCHA
                        3.- SACAR DINERO DE LA HUCHA
                        0.- SALIR""");
                select = sc.nextInt();
                switch (select) {
                    case 0:
                        break;
                    case 1:
                        cuenta.mostrarSaldoHuchas(cuenta);
                        break;
                    case 2:
                        cuenta.crearHucha();
                        break;
                    case 3:
                        //no implementado
                        break;
                    default:
                        System.out.println("Número no reconocido");
                        break;
                }
                System.out.println();
            } catch (Exception e) {
                System.out.println("OPCION INCORRECTA, SELECCIONE UNA OPCION VALIDA");
            }
        }
    }

    public void menuInversion(Cuenta cuenta) {
        int select = -1;
        while (select != 0) {
            Scanner sc = new Scanner(System.in);
            try {
                System.out.println("""
                        1.- ESTADO INVERSIONES
                        2.- CREAR NUEVA INVERSION
                        3.- EXTRAER INVERSIONES
                        0.- SALIR""");
                select = sc.nextInt();
                switch (select) {
                    case 0:
                        break;
                    case 1:
                        cuenta.mostrarSaldoInversion(cuenta);
                        break;
                    case 2:
                        cuenta.crearInversion();
                        break;
                    case 3:
                        //no implementado
                        break;
                    default:
                        System.out.println("Número no reconocido");
                        break;
                }
                System.out.println();
            } catch (Exception e) {
                System.out.println("OPCION INCORRECTA, SELECCIONE UNA OPCION VALIDA");
            }
        }
    }

}
