import java.util.UUID;

public class TransactionsLinkedList implements TransactionsList {

    private TransactionNode start = null;
    int num = 0;

    @Override
    public void addTransaction(Transaction tr) {
        num++;
        TransactionNode newNode = new TransactionNode(start, tr);
        start = newNode;
    }

    @Override
    public void removeTransById(UUID id) {
        TransactionNode tmp = start;
        if (start.getData().getIdentifier().equals(id)) {
            start = start.getNext();
            System.out.println("first element successfully deleted");
            num--;
            return;
        }
        else if (num > 1){
            while (tmp.getNext().getNext() != null) {
                if (tmp.getNext().getData().getIdentifier().equals(id)) {
                    tmp.setNext(tmp.getNext().getNext());
                    System.out.println("element successfully deleted");
                    num--;
                    return;
                }
                tmp = tmp.getNext();
            }
        }
        throw new TransactionNotFoundException("transaction not found");
    }

    @Override
    public Transaction[] toArray() {

        Transaction[] resultList = new Transaction[num];
        TransactionNode tmp = start;

        for (int i = 0; i < num; i++, tmp = tmp.getNext()) {
            resultList[i] = tmp.getData();
        }
        return resultList;
    }


}

class TransactionNode {
    private Transaction data;
    private TransactionNode next;

    public TransactionNode(TransactionNode next, Transaction data) {
        this.next = next;
        this.data = data;
    }

    public Transaction getData() {
        return data;
    }

    public void setData(Transaction data) {
        this.data = data;
    }

    public TransactionNode getNext() {
        return next;
    }

    public void setNext(TransactionNode next) {
        this.next = next;
    }

}
