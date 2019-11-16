import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class Visualizer {
    public static void visualize(Object obj) {
        System.out.println("Visualizer");
        Class c = obj.getClass();
        String className = c.getName();
        System.out.println("Class Name: " + className);

        // Get and print fields
        Field[] classFields = c.getDeclaredFields();
        String classFieldName;
        for(Field classField: classFields) {
            classFieldName = classField.getName();
            classField.setAccessible(true);
            System.out.println("Field Name: " + classFieldName);
            System.out.println(classFieldName + " Field Type: " + classField.getType().getTypeName());
            System.out.println(classFieldName + " Modifier: " + Modifier.toString(classField.getModifiers()));

            try {
                Object value = classField.get(obj);
                System.out.println(classFieldName + " Field Value: " + value);
            } catch (IllegalArgumentException | IllegalAccessException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
