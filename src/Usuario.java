import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Usuario {
    private String DNI;
    private String nombre;
    private String apellido;
    private int telefono;
    private List<Cuenta> cuentas;

    //func y construct
    public Usuario() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce tu nombre: ");
        this.nombre = sc.next();
        System.out.println("Introduce tu apellido: ");
        this.apellido = sc.next();
        this.DNI = checkdni();
        System.out.println("Introduce tu numero de telefono: ");
        this.telefono = sc.nextInt();
        this.cuentas = new ArrayList<>();
    }

    public static String checkdni() {
        Scanner sc = new Scanner(System.in);
        String dni_ref = "TRWAGMYFPDXBNJZSQVHLCKE";

        System.out.print("Dime tu dni sin la letra: ");
        int dni_actual = sc.nextInt();

        System.out.println("dame la letra");
        String letra = sc.next();
        int resto = dni_actual % 23;

        String letra_nueva = dni_ref.substring(resto, resto + 1);
        if (letra.equals(letra_nueva)) {
            System.out.println("El dni es correcto.");
            return dni_actual + letra;
        } else {
            return checkdni();
        }
    }

    public Cuenta findByIBAN(String IBAN) {
        for (Cuenta cuenta : cuentas) {
            if (cuenta.getIBAN().equals(IBAN)) {
                return cuenta;
            }
        }
        return null; // Si no se encuentra la cuenta con el IBAN especificado
    }

    /*esta funcion muestra las cuentas que tenga el usuario, si no tiene, mostrara un mensaje de no
      tener cuentas asociadas*/

    public boolean showCuentas() {
        if (cuentas.isEmpty()) {
            System.out.println("El usuario " + nombre + " no tiene cuentas asociadas.");
            return false;
        } else {
            System.out.println("Cuentas del usuario " + nombre + ":");
            for (int i = 0; i < cuentas.size(); i++) {
                System.out.println((i + 1) + ". IBAN: " + cuentas.get(i).getIBAN() + " saldo =  " + cuentas.get(i).getDinero() + "€");
            }
            return true;
        }
    }

    public void addCuenta(Cuenta cuenta) {
        cuentas.add(cuenta);
    }

    //getters y setters

    public List<Cuenta> getCuentas() {
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
