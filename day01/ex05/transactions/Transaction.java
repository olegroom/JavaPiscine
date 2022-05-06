package transactions;

import users.User;
import java.util.UUID;

public class Transaction {
    @Override
    public String toString() {
        String result = "";
        if (category == TransferCategory.CREDIT)
            result += "To " + sender.getName() + "(id = " + sender.getIdentifier() + ") " + transferAmount + " with id = " + identifier;
        else
            result += "From " + sender.getName() + "(id = " + sender.getIdentifier() + ") " + transferAmount + " with id = " + identifier;
        return result;
    }

    enum TransferCategory {
        DEBIT, CREDIT
    }

    public String toUnpairedString() {
        String result = "";

        if (category == TransferCategory.CREDIT) {
            result += sender.getName() + "(id = " + sender.getIdentifier() + ") has an unacknowledged transfer id = " + getIdentifier()
                    + " from " + recipient.getName() + "(id = " + recipient.getIdentifier() + ") for " + (getTransferAmount() * -1);
        }
        else
            result += recipient.getName() + "(id = " + recipient.getIdentifier() + ") has an unacknowledged transfer id = " + getIdentifier()
                    + " from " + sender.getName() + "(id = " + sender.getIdentifier() + ") for " + getTransferAmount();

        return result;
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