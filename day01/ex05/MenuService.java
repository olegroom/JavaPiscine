import users.*;
import transactions.*;

import java.util.UUID;

public class MenuService {
    TransactionsService service = new TransactionsService();

    public void showMenu() {
        System.out.println("1. Add a user\n" +
                "2. View user balances\n" +
                "3. Perform a transfer\n" +
                "4. View all transactions for a specific user\n" +
                "5. DEV – remove a transfer by ID\n" +
                "6. DEV – check transfer validity\n" +
                "7. Finish execution");
    }

    public void addUser(String line) {
        String[] splitted = line.split("\\s+");
        service.addUser(new User(splitted[0], Integer.parseInt(splitted[1])));
    }

    public void showBalance(String line) {
        int id = Integer.parseInt(line);
        System.out.print(service.getUsersList().getUserById(id).getName() + " - ");
        System.out.println(service.retrieveUsrBalance(id));
    }

    public void performTransfer(String line) {
        String[] splitted = line.split("\\s+");
        service.performTheTransaction(service.getUsersList().getUserById(Integer.parseInt(splitted[0])), service.getUsersList().getUserById(Integer.parseInt(splitted[1])), Integer.parseInt(splitted[2]));
        System.out.println("The transfer is completed");
    }

    public void viewAllTransForUser(String line) {
        int id = Integer.parseInt(line);
        for (Transaction tr : service.getTransfersOfUser(service.getUsersList().getUserById(id)))
            System.out.println(tr);
    }

    public void removeTransferByID(String line) {
        String[] splitted = line.split("\\s+");
        service.removeTransactionById(Integer.parseInt(splitted[0]), UUID.fromString(splitted[1]));
    }

    public void showUnpairedTransfer() {
        service.getUnpairedTransactions();
        for (Transaction tr : service.getUnpairedTransactions()) {
            System.out.println(tr.toUnpairedString());
        }
    }
}
