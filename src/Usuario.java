import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Usuario {
    private String DNI;
    private String nombre;
    private String apellido;
    private int telefono;
    public List<Cuenta> cuentas;

    //func y construct
    public Usuario() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce tu nombre: ");
        this.nombre = sc.next();
        System.out.println("Introduce tu apellido: ");
        this.apellido = sc.next();
        this.DNI = checkDNI();
        System.out.println("Introduce tu numero de telefono: ");
        this.telefono = sc.nextInt();
        this.cuentas = new ArrayList<>();
    }

    public Usuario(int telefono, String apellido, String nombre, String DNI) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.DNI = DNI;
        this.cuentas = new ArrayList<>();
    }

    public String checkDNI() {
        Scanner scanner = new Scanner(System.in);
        String dniRef = "TRWAGMYFPDXBNJZSQVHLCKE";

        while (true) {
            System.out.println("Introduce tu número de DNI con la letra ");
            String inDNI = scanner.nextLine().trim();

            if (inDNI.length() != 9) {
                System.out.println("El número de DNI debe tener 8 dígitos seguidos de una letra.");
                continue;
            }

            //separamos los numeros de las letras
            String splitDNI = inDNI.substring(0, 8);
            //en caso de que introduzcas una letra minuscula, lo maneja y la hace mayuscula
            String letter = inDNI.substring(8).toUpperCase();

            try {
                int intDNI = Integer.parseInt(splitDNI); // Convertir la parte numérica del DNI a int
                int resto = intDNI % 23; // Calcula resto
                String calculatedLetter = dniRef.substring(resto, resto + 1);

                if (letter.equals(calculatedLetter)) {
                    System.out.println("DNI introducido correctamente");
                    return inDNI;// Devolver el número de DNI con la letra
                } else {
                    System.out.println("La letra introducida no coincide con " +
                            "la letra calculada para el número de DNI.");
                }
            } catch (NumberFormatException e) {
                System.out.println("El número de DNI debe contener solo dígitos en la parte numérica.");
            }
        }
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
                System.out.println((i + 1) + ". IBAN: " + cuentas.get(i).getIBAN() +
                        " saldo =  " + cuentas.get(i).getDinero() + "€");
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
