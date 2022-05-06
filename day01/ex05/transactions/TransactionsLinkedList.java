package transactions;

import exceptions.TransactionNotFoundException;
import java.util.UUID;

public class TransactionsLinkedList implements TransactionsList {

    private TransactionNode start = null;
    int num = 0;

    @Override
    public Transaction getTransactionByUUID(UUID id) {
        TransactionNode tmp = start;

        while (tmp.getData() != null) {
            if (tmp.getData().getIdentifier().equals(id))
                return tmp.getData();
            tmp = tmp.getNext();
        }
        throw new TransactionNotFoundException("wrong id");
    }

    @Override
    public void addTransaction(Transaction tr) {
        num++;
        start = new TransactionNode(start, tr);
    }

    public boolean haveTransById(UUID id) {
        System.out.println();
        TransactionNode tmp = start;
        while (tmp != null) {
            if (tmp.getData().getIdentifier().equals(id))
                return true;
            tmp = tmp.getNext();
        }
        return false;
    }


    @Override
    public void removeTransById(UUID id) {

        TransactionNode tmp = start;
        if (start.getData().getIdentifier().equals(id)) {
            start = start.getNext();
            num--;
            return;
        }
        else if (num > 1){
            while (tmp != null) {
                if (tmp.getNext().getData().getIdentifier().equals(id)) {
                    tmp.setNext(tmp.getNext().getNext());
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
