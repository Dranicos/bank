import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Usuario {
    private String DNI;
    private String nombre;
    private String apellido;
    private int telefono;
    private Cuenta[] cuentas;

    public Usuario() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce tu nombre: \n");
        this.nombre = sc.next();
        System.out.println("Introduce tu apellido: \n");
        this.apellido = sc.next();
        this.DNI = checkdni();
        System.out.println("Introduce tu numero de telefono: \n");
        this.telefono = sc.nextInt();
        this.cuentas = new Cuenta[];
    }

    public static String checkdni() {
        Scanner scanner = new Scanner(System.in);
        String dni_ref = "TRWAGMYFPDXBNJZSQVHLCKE";

        System.out.print("Dime tu dni sin la letra: ");
        int dni_actual = scanner.nextInt();

        System.out.println("dame la letra");
        String letra = scanner.next();
        int resto = dni_actual % 23;

        String letra_nueva = dni_ref.substring(resto, resto + 1);
        if (letra.equals(letra_nueva)) {
            System.out.println("El dni es correcto.");
            return dni_actual + letra;
        } else {
            return checkdni();
        }

    }

    public void agregarCuenta(Cuenta cuenta) {
        cuentas += Cuenta(cuenta);
    }

    public void findByIBAN(Cuenta iban){

    }

    public List<Cuenta> getCuentasBancarias() {
        return cuentas;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "DNI='" + DNI + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", telefono=" + telefono +
                ", cuentas=" + cuentas +
                '}';
    }
}
