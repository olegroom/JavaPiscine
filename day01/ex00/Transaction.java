import java.util.UUID;

public class Transaction {
    private enum TransferCategory {
        DEBIT, CREDIT
    }

    public Transaction(UUID identifier, User recipient, User sender, Integer transferAmount) {
        if (sender.getBalance() < transferAmount) {
            System.out.println("Sender doesn't have money");
            System.exit(0);
        }
        this.identifier = identifier;
        this.recipient = recipient;
        this.sender = sender;
        this.transferAmount = transferAmount;
    }

    private UUID identifier;
    private User recipient;
    private User sender;
    private Integer transferAmount;
    private TransferCategory category;

    public void setTransferAmount(Integer transferAmount) {
        if (category == TransferCategory.CREDIT && transferAmount < 0)
            this.transferAmount = transferAmount;
        else if (category == TransferCategory.DEBIT && transferAmount > 0)
            this.transferAmount = transferAmount;
    }

    public UUID getIdentifier() {
        return identifier;
    }

    public User getRecipient() {
        return recipient;
    }

    public User getSender() {
        return sender;
    }

    public Integer getTransferAmount() {
        return transferAmount;
    }

    public TransferCategory getCategory() {
        return category;
    }
}
