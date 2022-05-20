import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class<User> userClass = User.class;
        Class<Car> carClass = Car.class;

        System.out.println("Classes:");
        System.out.println(userClass.getSimpleName());
        System.out.println(carClass.getSimpleName());

        ClassInfoHandler infoHandler = null;
        String inputFromUser = getInputFromUser("Enter class name:");

        infoHandler = inputFromUser.equals("User") ? new ClassInfoHandler(User.class) : inputFromUser.equals("Car") ? new ClassInfoHandler(Car.class) : null;
        infoHandler.printFields();
        infoHandler.printMethods();
        System.out.println("--------------------------------");
        System.out.println("Let's create an object.");
        infoHandler.createAnObject();
        System.out.println("--------------------------------");
        String fieldToUpdate = getInputFromUser("Enter name of the field for changing:");
        infoHandler.changeField(fieldToUpdate);



    }

    public static String getInputFromUser(String msgToUser) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(msgToUser);
        System.out.print("-> ");
        return scanner.nextLine();
    }
}
