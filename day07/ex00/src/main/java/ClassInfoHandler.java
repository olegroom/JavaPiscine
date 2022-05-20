import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClassInfoHandler {

    public Class<?> aClass;
    Object o;

    public ClassInfoHandler(Class<?> initialClass) {
        this.aClass = initialClass;
    }


    public void changeField(String fieldToChange) throws IllegalAccessException {
        Field[] declaredFields = o.getClass().getDeclaredFields();

        for (Field field : declaredFields) {
            if (field.getName().equals(fieldToChange)) {
                field.setAccessible(true);
                String newValue = Program.getInputFromUser("Enter " + field.getType().getSimpleName() + " value:");
                Class<?> type = field.getType();

                if (type.getName().equals("int"))
                    field.setInt(o, Integer.parseInt(newValue));
                else
                    field.set(o, type.cast(newValue));

                System.out.print("Object updated: ");
                System.out.println(o);
            }
        }
    }

    public void createAnObject() throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Field[] declaredFields = aClass.getDeclaredFields();
        List<Object> list = new ArrayList<>();
        int i = 1;
        for (Field f : declaredFields) {
            String inputFromUser = Program.getInputFromUser(f.getName());
            if (f.getType().getName().equals("int"))
                list.add(Integer.parseInt(inputFromUser));
            else
                list.add(inputFromUser);
            i++;
        }

        Constructor<?>[] constructors = aClass.getConstructors();
        for (Constructor<?> constructor : constructors) {
            if (constructor.getParameterTypes().length == aClass.getDeclaredFields().length) {

                System.out.println("Constructor argument types:");
                Class<?>[] parameterTypes = constructor.getParameterTypes();
                for (Class<?> type : parameterTypes) {
                    System.out.println(type.getSimpleName());
                }
                Object[] objects = list.toArray();
                o = constructor.newInstance(objects);

                System.out.print("Object created: ");
                System.out.println(o);
                return;
            }
        }
    }


    public void printFields() {
        Field[] declaredFields = aClass.getDeclaredFields();

        System.out.println("fields :");
        for(Field f : declaredFields) {
            System.out.println("\t" + f.getName());
        }
    }

    public void printMethods() {
        Method[] declaredMethods = aClass.getDeclaredMethods();
        System.out.println("methods:");
        for (Method m : declaredMethods) {
            if (m.getName().equals("toString"))
                continue;
            StringBuilder builder = new StringBuilder();
            builder.append("\t")
                    .append(m.getReturnType().getName())
                    .append(" ")
                    .append(m.getName())
                    .append("(");

            Class<?>[] parameterTypes = m.getParameterTypes();
            for (Class<?> paramType : parameterTypes)
                builder.append(paramType.getName()).append(" ");
            builder.append(")");
            System.out.println(builder);
        }
    }



}
