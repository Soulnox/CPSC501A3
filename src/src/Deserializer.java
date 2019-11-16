import org.jdom.Element;

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
        return null;
    }
}
