import java.util.Random;
import java.util.Scanner;

public class Cuenta {
    private String IBAN;
    private double dinero;

    public String getIBAN() {
        return IBAN;
    }

    public void setIBAN(String IBAN) {
        this.IBAN = IBAN;
    }

    public double getDinero() {
        return dinero;
    }

    public void setDinero(double dinero) {
        this.dinero = dinero;
    }

//  GENERADOR DE CUENTA - esto se puede utilizar para crear una cuenta en cualquier momento
//  aunque haría falta ciertos cambios en cuanto al texto que se despliega para ello
//  actualmente solo genera el usuario que se conecta en el banco teniendo en cuenta que
//  es el usuario que esta activo el unico que se va a registrar en esa sesion
    public Cuenta() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Se procederá a generar un Iban aleatorio");
        this.IBAN = generarIBAN();
        System.out.println("Tu IBAN es: " + this.IBAN);

        System.out.println("Cuanto dinero quieres introducir en tu cuenta?");
        this.dinero = sc.nextDouble();
    }


    public static String generarIBAN() {
        // Crear IBAN con "ES" (código de país)
        String iban = "ES";
        // Generar 20 dígitos aleatorios para el número de cuenta
        Random random = new Random();
        for (int i = 0; i < 22; i++) {
            iban += random.nextInt(10);
        }
        return iban;
    }


    @Override
    public String toString() {
        return "Cuenta{" +
                "IBAN='" + IBAN + '\'' +
                ", dinero=" + dinero +
                '}';
    }
}
