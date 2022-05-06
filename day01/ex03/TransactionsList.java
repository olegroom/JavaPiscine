import java.util.UUID;

public interface TransactionsList {
    void addTransaction(Transaction tr);
    void removeTransById(UUID id);
    Transaction[] toArray();
}
