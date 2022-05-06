package users;

public class UserIdsGenerator {
    static public int id = 1;
    static private final UserIdsGenerator usGen = new UserIdsGenerator();

    public static UserIdsGenerator getInstance() {
        return usGen;
    }

    public int generateId() {
        return id++;
    }
}