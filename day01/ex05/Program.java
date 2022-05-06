import transactions.Transaction;
import transactions.TransactionsService;
import users.User;

import java.lang.*;
import java.util.Scanner;
import java.util.UUID;


public class Program {
    public static void main(String[] args) {
        boolean isDev = false;

        if (args[0].equals("--profile=production"))
            isDev = false;
        else if (args[0].equals("--profile=dev"))
            isDev = true;

        MenuService menu = new MenuService();
        Scanner scan = new Scanner(System.in);
        while (true) {
            menu.showMenu();
            String number = scan.nextLine();
            try {
                switch (Integer.parseInt(number)) {
                    case (1):
                        System.out.println("Enter a user name and a balance");
                        menu.addUser(scan.nextLine());
                        break;
                    case (2):
                        System.out.println("Enter a user ID");
                        menu.showBalance(scan.nextLine());
                        break;
                    case (3):
                        System.out.println("Enter a sender ID, a recipient ID, and a transfer amount");
                        menu.performTransfer(scan.nextLine());
                        break;
                    case (4):
                        System.out.println("Enter a user ID");
                        menu.viewAllTransForUser(scan.nextLine());
                        break;
                    case (5):
                        if (isDev) {
                            System.out.println("Enter a user ID and a transfer ID");
                            menu.removeTransferByID(scan.nextLine());
                            break;
                        }
                        else {
                            System.out.println("Operation isn't allowed");
                            break;
                        }
                    case (6):
                        if (isDev) {

                            System.out.println("Check results:");
                            menu.showUnpairedTransfer();
                            break;
                        }
                        else {
                            System.out.println("Operation isn't allowed");
                            break;
                        }
                    case (7):
                        System.exit(0);
                }
            }
            catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
            System.out.println("---------------------------------------------------------");
        }


    }
}