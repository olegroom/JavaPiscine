package transactions;

import exceptions.IllegalTransactionException;
import users.User;
import users.UsersArrayList;
import users.UsersList;

import java.util.UUID;

public class TransactionsService {
    public int num = 0;
    TransactionsList unpairedTrs = new TransactionsLinkedList();
    UsersList usersList = new UsersArrayList();

    public void addUser(User usr) {
        usersList.addUser(usr);
    }

    public Integer retrieveUsrBalance(Integer userID) {
        return usersList.getUserById(userID).getBalance();
    }

    public UsersList getUsersList() {
        return usersList;
    }

    public void performTheTransaction(User send, User rec, Integer amount) {
        if (amount <= 0 || amount > send.getBalance())
            throw new IllegalTransactionException();
        int tmp = num++;
        Transaction trCredit = new Transaction(send, rec, (amount * -1), new UUID(tmp, 1));
        Transaction trDebit = new Transaction(rec, send, amount, new UUID(tmp, 1));

        send.setBalance(send.getBalance() - amount);
        rec.setBalance(rec.getBalance() + amount);

        send.getTransactions().addTransaction(trCredit);
        rec.getTransactions().addTransaction(trDebit);
    }

    public Transaction[] getTransfersOfUser(User usr) {
        return usr.getTransactions().toArray();
    }

    public void removeTransactionById(Integer usrId, UUID trId) {
        String name = "";
        if (usersList.getUserById(usrId).getTransactions().getTransactionByUUID(trId).getCategory() == Transaction.TransferCategory.CREDIT) {
            name = usersList.getUserById(usrId).getTransactions().getTransactionByUUID(trId).getSender().getName();
        }
        else {
            name = usersList.getUserById(usrId).getTransactions().getTransactionByUUID(trId).getRecipient().getName();
        }

        if (unpairedTrs.haveTransById(trId)) {
            unpairedTrs.removeTransById(trId);
        }
        else {
            unpairedTrs.addTransaction( usersList.getUserById(usrId).getTransactions().getTransactionByUUID(trId));
        }
        if (usersList.getUserById(usrId).getTransactions().getTransactionByUUID(trId).getCategory() == Transaction.TransferCategory.DEBIT) {
            System.out.println("Transfer From " + name + "(id = " + usersList.getUserById(usrId).getTransactions().getTransactionByUUID(trId).getRecipient().getIdentifier() + ") "
                    + usersList.getUserById(usrId).getTransactions().getTransactionByUUID(trId).getTransferAmount() + " removed");
        }
        else {
            System.out.println("Transfer To " + name + "(id = " + usersList.getUserById(usrId).getTransactions().getTransactionByUUID(trId).getSender().getIdentifier() + ") "
                    + (usersList.getUserById(usrId).getTransactions().getTransactionByUUID(trId).getTransferAmount() * -1) + " removed");
        }
        usersList.getUserById(usrId).getTransactions().removeTransById(trId);
    }

    public Transaction[] getUnpairedTransactions() {
        return unpairedTrs.toArray();
    }
}
