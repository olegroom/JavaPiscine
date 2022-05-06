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
        if (unpairedTrs.haveTransById(trId)) {
            unpairedTrs.removeTransById(trId);
        }
        else {
            unpairedTrs.addTransaction( usersList.getUserById(usrId).getTransactions().getTransactionByUUID(trId));
        }

        usersList.getUserById(usrId).getTransactions().removeTransById(trId);
    }

    public Transaction[] getUnpairedTransactions() {
        return unpairedTrs.toArray();
    }
}
