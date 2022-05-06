import java.lang.*;
import java.util.UUID;

public class Program {
    public static void main(String[] args) {
        User us1 = new User();
        User us2 = new User();

        us1.setBalance(500);
        us1.setName("Oleg");
        us1.setIdentifier(5);

        System.out.println("us1 name: " + us1.getName());

        us2.setIdentifier(10);
        us2.setBalance(1000);
        us2.setName("Lena");

        System.out.println("us2 name: " + us2.getName());

        Transaction tr = new Transaction(UUID.randomUUID(), us1, us2, 400);
        System.out.println(tr.getTransferAmount());
    }
}