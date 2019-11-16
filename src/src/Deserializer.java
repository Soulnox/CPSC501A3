import org.jdom.Element;

import java.util.List;

public class Deserializer {
    public Object deserialize(org.jdom.Document document) {
        Element rootElement = document.getRootElement();
        Element element = rootElement.getChild("object");
        String objectClass = element.getAttributeValue("class");

        if (objectClass.equalsIgnoreCase("PrimitiveClass")) {
            System.out.println("Object class: " + element.getAttributeValue("class") + " ID: " + element.getAttributeValue("id"));
            int value = Integer.parseInt(element.getChildText("value"));
            float money = Float.parseFloat(element.getChildText("money"));
            boolean bool = Boolean.parseBoolean(element.getChildText("bool"));
            PrimitiveClass prim = new PrimitiveClass(value, money, bool);
            return prim;
        }

        if (objectClass.equalsIgnoreCase("[I")) {
            int length = Integer.parseInt(element.getAttributeValue("length"));
            System.out.println("Object class: " + element.getAttributeValue("class")
                    + " ID: " + element.getAttributeValue("id")
                    + " Length: " + length);
            int[] integers = new int[length];
            List values = element.getChildren();
            int count = 0;
            for (int i = 0; i < length; i++) {
                Element current = (Element) values.get(i);
                integers[i] = Integer.parseInt(current.getValue());
            }
            PrimitiveArrayClass primA = new PrimitiveArrayClass(integers);
            return primA;
        }
        return null;
    }
}
