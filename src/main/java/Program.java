import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Program {
    public static void main(String[] args) throws IllegalAccessException {
        Animal[] animals = {
                new Cat("Персик", 1, true),
                new Cat("Саймон", 10, false),
                new Dog("Гектор", 5, true)
        };

        for (Animal animal : animals) {
            System.out.println("Класс: " + animal.getClass().getSimpleName());
            printFieldsAndMethods(animal);
            try {
                System.out.println("Попытка вызова метода makeSound...");
                Method makeSoundMethod = animal.getClass().getMethod("makeSound");
                System.out.println("Успешно!");
                makeSoundMethod.invoke(animal);
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException ignored) {
                System.out.println("Нет метода makeSound для класса " + animal.getClass().getSimpleName());
            }
            System.out.println("=".repeat(10));
        }



    }

    private static <T> void printFieldsAndMethods (T obj) throws IllegalAccessException {
        Class<?> objClass = obj.getClass();


        Field[] superFields = objClass.getSuperclass().getDeclaredFields();
        for (Field field : superFields){
            field.setAccessible(true);
            System.out.printf("%s: %s\n", field.getName(), field.get(obj));
        }
        Field[] fields = objClass.getDeclaredFields();
        for (Field field : fields){
            field.setAccessible(true);
            System.out.printf("%s: %s\n", field.getName(), field.get(obj));
        }

        Method[] superMethods = objClass.getSuperclass().getDeclaredMethods();
        for (Method method : superMethods){
            method.setAccessible(true);
            System.out.printf(method.getName() + "\n");
        }
        Method[] methods = objClass.getDeclaredMethods();
        for (Method method : methods){
            method.setAccessible(true);
            System.out.printf(method.getName() + "\n");
        }

    }
}
