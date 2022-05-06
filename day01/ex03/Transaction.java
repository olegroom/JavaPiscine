import java.util.UUID;

public class Transaction {
    private enum TransferCategory {
        DEBIT, CREDIT
    }

    private UUID identifier;
    private User recipient;
    private User sender;
    private Integer transferAmount;
    private TransferCategory category;

    public Transaction(User recipient, User sender, Integer transferAmount, UUID id) {
        this.recipient = recipient;
        this.sender = sender;
        this.transferAmount = transferAmount;
        this.identifier = id;

        if (transferAmount > 0)
            setCategory(TransferCategory.DEBIT);
        else
            setCategory(TransferCategory.CREDIT);
    }

    public UUID getIdentifier() {
        return identifier;
    }

    public void setIdentifier(UUID identifier) {
        this.identifier = identifier;
    }

    public User getRecipient() {
        return recipient;
    }

    public void setRecipient(User recipient) {
        this.recipient = recipient;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public Integer getTransferAmount() {
        return transferAmount;
    }

    public void setTransferAmount(Integer transferAmount) {
        this.transferAmount = transferAmount;
    }

    public TransferCategory getCategory() {
        return category;
    }

    public void setCategory(TransferCategory category) {
        this.category = category;
    }
}