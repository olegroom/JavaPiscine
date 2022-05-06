public class User {

    private Integer identifier;
    private String name;
    private Integer balance = 0;

    public User() {
        this.identifier = UserIdsGenerator.getInstance().generateId();
    }

    public void setBalance(Integer balance) {
        if (balance > 0)
            this.balance = balance;
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