import java.util.UUID;

public class User {

    private Integer Identifier;
    private String Name;
    private Integer Balance = 0;

    public void setIdentifier(Integer identifier) {
        Identifier = identifier;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setBalance(Integer balance) {
        if (balance >= 0)
            Balance = balance;
    }

    public Integer getIdentifier() {
        return Identifier;
    }

    public String getName() {
        return Name;
    }

    public Integer getBalance() {
        return Balance;
    }
}