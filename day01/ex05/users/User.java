package users;

import transactions.TransactionsLinkedList;
import transactions.TransactionsList;

public class User {

    private final Integer identifier;


    private String name;
    private int balance = 0;
    private TransactionsList transactions = new TransactionsLinkedList();

    public User(String name, int balance) {
        this.name = name;
        this.balance = balance;
        this.identifier = UserIdsGenerator.getInstance().generateId();
        System.out.printf("User with id = %d is added\n", this.identifier);
    }

    public void setBalance(Integer balance) {
        if (balance > 0)
            this.balance = balance;
    }

    public TransactionsList getTransactions() {
        return transactions;
    }

    public Integer getIdentifier() {
        return identifier;
    }

    public String getName() {
        return name;
    }

    public Integer getBalance() {
        return balance;
    }
}