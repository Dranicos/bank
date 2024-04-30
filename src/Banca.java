import java.util.ArrayList;
import java.util.List;

public class Banca {
    private List<Usuario> usuarios;

    public Banca() {
        this.usuarios = new ArrayList<>();
    }

    public void addUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public void transferirDinero(String myIBAN, String destinyIBAN, double money) {
        Cuenta myAccount = null;
        Cuenta destinyAccount = null;
        System.out.println(usuarios.size());
        for (int i = 0; i < usuarios.size(); i++) {
            System.out.println(usuarios.get(i).getCuentas() + "pum");
            for (int j = 0; j < usuarios.get(i).getCuentas().size(); j++) {
                if (usuarios.get(i).getCuentas().get(j).getIBAN().equals((myIBAN))) {
                    myAccount = usuarios.get(i).getCuentas().get(j);
                } else if (usuarios.get(i).getCuentas().get(j).getIBAN().equals(destinyIBAN)) {
                    destinyAccount = usuarios.get(i).getCuentas().get(j);
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
    /*
    public void bizum(String myNumber, String destinyNumber, double money) {
        Cuenta myAccount = null;
        Cuenta destinyAccount = null;

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
    }*/

    @Override
    public String toString() {
        return "Banca{" +
                "usuarios=" + usuarios +
                '}';
    }

}
