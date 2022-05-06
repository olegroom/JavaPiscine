import transactions.Transaction;
import transactions.TransactionsService;
import users.User;

import java.lang.*;
import java.util.UUID;


public class Program {
    public static void showBalance(TransactionsService service) {
        System.out.println("\nBALANCE:");
        System.out.println("Oleg's initial balance = " + service.retrieveUsrBalance(0));
        System.out.println("Vasya's initial balance = " + service.retrieveUsrBalance(1));
    }


    public static void main(String[] args) {
        TransactionsService service = new TransactionsService();

        User us1 = new User("Oleg", 1000);
        User us2 = new User("Vasya", 400);

        service.addUser(us1);
        service.addUser(us2);

        showBalance(service);

        service.performTheTransaction(us1, us2, 500);
        service.performTheTransaction(us1, us2, 400);
        service.performTheTransaction(us2, us1, 200);

        System.out.println("\nUser 1 transactions:");
        for (Transaction tr : service.getTransfersOfUser(us1)) {
            System.out.println(tr);
        }

        System.out.println("\nUser 2 transactions:");
        for (Transaction tr : service.getTransfersOfUser(us2)) {
            System.out.println(tr);
        }

        service.removeTransactionById(1,  new UUID(1, 1));
        service.removeTransactionById(1, new UUID(0, 1));

        service.removeTransactionById(0, new UUID(1, 1));
        service.removeTransactionById(0, new UUID(0, 1));

        System.out.println("\nUnpaired transactions:");
        for (Transaction tr : service.getUnpairedTransactions()) {
            System.out.println(tr);
        }
        showBalance(service);

    }
}