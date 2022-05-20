public class User {
    private String firstName;
    private String lastName;
    private int height;

    public User() {
        firstName = "default";
        lastName = "default last name";
        height = 0;
    }

    public User(String firstName, String lastName, int height) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.height = height;
    }


    public int grow(int x) {
        return x + 10;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", height=" + height +
                '}';
    }
}
