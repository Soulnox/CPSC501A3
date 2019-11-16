import org.jdom.Element;

import java.util.List;

public class Deserializer {
    public Object deserialize(org.jdom.Document document) {
        Element rootElement = document.getRootElement();
        Element element = rootElement.getChild("object");
        String objectClass = element.getAttributeValue("class");

        if (objectClass.equalsIgnoreCase("PrimitiveClass")) {
            System.out.println("Object class: " + element.getAttributeValue("class") + " ID: " + element.getAttributeValue("id"));
            List values = element.getChildren();
            Element current = (Element) values.get(0);
            int value = Integer.parseInt(current.getValue());
            current = (Element) values.get(1);
            float money = Float.parseFloat(current.getValue());
            current = (Element) values.get(2);
            boolean bool = Boolean.parseBoolean(current.getValue());
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
