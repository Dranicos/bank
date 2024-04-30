import java.util.ArrayList;
import java.util.List;

public class Banca {
    private final List<Usuario> usuarios;

    public Banca() {
        this.usuarios = new ArrayList<>();
    }

    public void addUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public void transferirDinero(String myIBAN, String destinyIBAN, double money) {
        Cuenta myAccount = null;
        Cuenta destinyAccount = null;

        System.out.println(usuarios);
        for (Usuario usuario : usuarios) {
            System.out.println(usuario + "pum");
            for (Cuenta cuenta : usuario.getCuentas()) {
                if (cuenta.getIBAN().equals(myIBAN)) {
                    myAccount = cuenta;
                } else if (cuenta.getIBAN().equals(destinyIBAN)) {
                    destinyAccount = cuenta;
                }
            }
        }

        if (myAccount == null || destinyAccount == null) {
            System.out.println("No se pudo completar la transferencia. " +
                    "Una o ambas cuentas no fueron encontradas.");
            return;
        }

        if (myAccount.getDinero() < money) {
            System.out.println("No se pudo completar la transferencia. " +
                    "Fondos insuficientes en la cuenta de origen.");
            return;
        }

        myAccount.setDinero(myAccount.getDinero() - money);
        destinyAccount.setDinero(destinyAccount.getDinero() + money);

        System.out.println("Transferencia completada. Se ha transferido " + money +
                " de la cuenta " + myIBAN + " a la cuenta " + destinyIBAN);
    }

    @Override
    public String toString() {
        return "Banca{" +
                "usuarios=" + usuarios +
                '}';
    }

}
