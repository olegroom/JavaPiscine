package users;

import transactions.TransactionsLinkedList;
import transactions.TransactionsList;

public class User {

    private final Integer identifier;


    private String name;
    private Integer balance = 0;
    private TransactionsList transactions = new TransactionsLinkedList();

    public User(String name, Integer balance) {
        this.name = name;
        this.balance = balance;
        this.identifier = UserIdsGenerator.getInstance().generateId();
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