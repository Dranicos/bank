import java.util.Random;
import java.util.Scanner;
import java.util.UUID;

public class Hucha {
    private String idHucha;
    private double dinero;

    public Hucha() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Indica el dinero a introducir en la hucha");
        this.dinero = sc.nextDouble();
        this.idHucha = UUID.randomUUID().toString();
    }

    public String getIdHucha() {
        return idHucha;
    }

    public void setIdHucha(String idHucha) {
        this.idHucha = idHucha;
    }

    public double getDinero() {
        return dinero;
    }

    public void setDinero(double dinero) {
        this.dinero = dinero;
    }


}
