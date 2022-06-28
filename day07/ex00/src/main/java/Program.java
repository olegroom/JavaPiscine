import car.Car;
import user.User;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class<User> userClass = User.class;
        Class<Car> carClass = Car.class;

        System.out.println("Classes:");
        System.out.println(userClass.getSimpleName());
        System.out.println(carClass.getSimpleName());

        ClassInfoHandler infoHandler = null;
        System.out.println("--------------------------------");

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

        String methodToInvoke = getInputFromUser("Enter name of the method for call");
        Optional<Method> methodByName = infoHandler.getMethodByName(methodToInvoke);
        if (methodByName.isPresent()) {
            List<Object> filledParams = infoHandler.getAndFillParams(methodByName.get());
            infoHandler.invokeMethod(methodByName.get(), filledParams.toArray());
        }
    }

    public static String getInputFromUser(String msgToUser) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(msgToUser);
        System.out.print("-> ");
        return scanner.nextLine();
    }
}
