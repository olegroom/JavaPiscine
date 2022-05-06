import java.lang.*;
import java.util.UUID;

public class Program {
    public static void main(String[] args) {
        User us1 = new User();
        User us2 = new User();

        Transaction tr1 = new Transaction(us1, us2, 100, new UUID(444, 222));
        Transaction tr2 = new Transaction(us1, us2, 100, new UUID(444, 111));
        Transaction tr3 = new Transaction(us1, us2, 100, new UUID(444, 22));
        Transaction tr4 = new Transaction(us1, us2, 100, new UUID(1, 2));

        TransactionsLinkedList trlist = new TransactionsLinkedList();
        System.out.println("empty list size is : " + trlist.num);
        UUID idToFind = new UUID(1, 2);

        trlist.addTransaction(tr1);
        trlist.addTransaction(tr2);
        trlist.addTransaction(tr3);
        trlist.addTransaction(tr4);

        System.out.println("full(after add trs) list size is : " + trlist.num);
        trlist.removeTransById(idToFind);

        Transaction[] arr = trlist.toArray();
        for (int i = 0; i < trlist.num; i++)
            System.out.println(arr[i].getIdentifier());

        System.out.println("(after delete one tr) list size is : " + trlist.num);

    }


}