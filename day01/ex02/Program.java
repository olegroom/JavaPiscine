import java.lang.*;

public class Program {

    private static void addUsersToUserList(UsersList usrs) {
        User us1 = new User();
        User us2 = new User();
        User us3 = new User();
        User us4 = new User();
        User us5 = new User();
        User us6 = new User();
        User us7 = new User();
        User us8 = new User();
        User us9 = new User();
        User us10 = new User();
        User us11 = new User();
        User us12 = new User();
        usrs.addUser(us1);
        usrs.addUser(us2);
        usrs.addUser(us3);
        usrs.addUser(us4);
        usrs.addUser(us5);
        usrs.addUser(us6);
        usrs.addUser(us7);
        usrs.addUser(us8);
        usrs.addUser(us9);
        usrs.addUser(us10);
        usrs.addUser(us11);
        usrs.addUser(us12);
    }

    public static void main(String[] args) {
        UsersList usrs = new UsersArrayList();
        addUsersToUserList(usrs);

        try {
            System.out.println(usrs.getUserByIndex(11));
            System.out.println(usrs.getUserById(5));
        } catch (UserNotFoundException e) {
            System.out.println(e.getMessage());
            System.exit(-1);
        }

        System.out.println("Size of array: " + usrs.getSizeOfArray());
    }


}