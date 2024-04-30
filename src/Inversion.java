import java.util.Scanner;
import java.util.UUID;

public class Inversion {

    private String idInv;
    private double dinero;
    private int nivelRiesgo;

    public Inversion() {
        this.idInv = UUID.randomUUID().toString();
        Scanner sc = new Scanner(System.in);
        System.out.println("Escoja el nivel de riesgo del 1-7");
        this.nivelRiesgo = sc.nextInt();
        System.out.println("Cuanto dinero desea invertir");
        this.dinero = sc.nextDouble();
    }

    public String getIdInv() {
        return idInv;
    }

    public void setIdInv(String idInv) {
        this.idInv = idInv;
    }

    public double getDinero() {
        return dinero;
    }

    public void setDinero(double dinero) {
        this.dinero = dinero;
    }

    public int getNivelRiesgo() {
        return nivelRiesgo;
    }

    public void setNivelRiesgo(int nivelRiesgo) {
        this.nivelRiesgo = nivelRiesgo;
    }
}
