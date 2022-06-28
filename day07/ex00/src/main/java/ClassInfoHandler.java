import java.lang.reflect.*;
import java.util.*;

public class ClassInfoHandler {

    public Class<?> aClass;
    Object o;

    public ClassInfoHandler(Class<?> initialClass) {
        this.aClass = initialClass;
    }

    public Optional<Method> getMethodByName(String methodName) {
        Method[] methods = aClass.getDeclaredMethods();
        for (Method m : methods)
            if (m.getName().equals(methodName))
                return Optional.of(m);
        return Optional.empty();
    }

    public List<Object> getAndFillParams(Method method) {
        Class<?>[] parameterTypes = method.getParameterTypes();
        List<Object> filledParams = new ArrayList<>(parameterTypes.length);

        for (Class<?> typeOfParam : parameterTypes) {
            String inputFromUser = Program.getInputFromUser("Enter " + typeOfParam.getSimpleName() + " value:");
            if (typeOfParam.getSimpleName().equals("int"))
                filledParams.add(Integer.parseInt(inputFromUser));
            else
                filledParams.add(inputFromUser);
        }
        return filledParams;
    }

    public void invokeMethod(Method m, Object[] args) {
        try {
            Object invoke = m.invoke(o, args);
            System.out.println("Method returned :" + invoke);
        } catch (InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
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

    public void createAnObject() throws InstantiationException, IllegalAccessException, InvocationTargetException {
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
            int i = 0;
            for (Class<?> paramType : parameterTypes) {
                if (parameterTypes.length == i + 1)
                    builder.append(paramType.getSimpleName());
                else
                    builder.append(paramType.getSimpleName()).append(", ");
                i++;
            }
            builder.append(")");
            System.out.println(builder);
        }
    }



}
