import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Cuenta {
    private String IBAN;
    private double dinero;
    public List<Hucha> huchas;
    public List<Inversion> inversiones;
    //func y construct

    public Cuenta() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Se procederá a generar un Iban aleatorio");
        this.IBAN = generarIBAN();
        System.out.println("Tu IBAN es: " + this.IBAN);
        System.out.println("Cuanto dinero quieres introducir en tu cuenta?");
        this.dinero = sc.nextDouble();
        this.huchas = new ArrayList<>();
        this.inversiones = new ArrayList<>();
    }

    public Cuenta(String IBAN, double dinero) {
        this.IBAN = "ES1234567890123456789012";
        this.dinero = dinero;
    }

    public String generarIBAN() {
        // Crear IBAN con "ES" (código de país)
        StringBuilder iban = new StringBuilder("ES");
        // Generar 20 dígitos aleatorios para el número de cuenta
        Random random = new Random();
        for (int i = 0; i < 22; i++) {
            iban.append(random.nextInt(10));
        }
        return iban.toString();
    }

    public double saldoTotal() {
        double saldo = getDinero();

        return saldo;
    }

    public void mostrarSaldoHuchas(Cuenta cuenta) {
        List<Hucha> huchas = getHuchas();
        System.out.println("Saldo en las huchas:");
        for (Hucha hucha : huchas) {
            System.out.println("Saldo: " + hucha.getDinero());
        }
    }

    public void mostrarSaldoInversion(Cuenta cuenta) {
        List<Inversion> inversions = getInversiones();
        System.out.println("Dinero invertido :");
        for (Inversion inversion : inversiones) {
            System.out.println("Id" + inversion.getIdInv() + "Saldo: " +
                    inversion.getDinero() + "Nivel de riesgo" +
                    inversion.getNivelRiesgo());
        }
    }

    public void crearHucha() {
        Hucha hucha = new Hucha();
        huchas.add(hucha);
    }

    public void crearInversion() {
        Inversion inversion = new Inversion();
        inversiones.add(inversion);
    }

    //getters y setters
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

    public List<Hucha> getHuchas() {
        return huchas;
    }

    public void setHuchas(List<Hucha> huchas) {
        this.huchas = huchas;
    }

    public List<Inversion> getInversiones() {
        return inversiones;
    }

    public void setInversiones(List<Inversion> inversiones) {
        this.inversiones = inversiones;
    }

    @Override
    public String toString() {
        return "Cuenta{" +
                "IBAN='" + IBAN + '\'' +
                ", dinero=" + dinero +
                '}';
    }
}
