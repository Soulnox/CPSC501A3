public class PrimitiveClass {
    public int value;
    public float money;
    public boolean bool;

    public PrimitiveClass(int value, float money, boolean bool) {
        this.value = value;
        this.money = money;
        this.bool = bool;
    }

    public PrimitiveClass (PrimitiveClass obj) {
        this.value = obj.getValue();
        this.money = obj.getMoney();
        this.bool = obj.getBool();
    }

    public int getValue() {
        return value;
    }

    public float getMoney() {
        return money;
    }

    public boolean getBool() {
        return bool;
    }


 /*   public Node toElement(Document document) {
        Element element = document.createElement("MyClass");
        element.setAttribute("name", name);
        //element.addContent(new Element("value").setTextContent(getValue());
        return element;
    }

  */



/*    public static PrimitiveClass createObject(Node node) {
        PrimitiveClass ob = new PrimitiveClass(node.getAttributes().getNamedItem("name").getNodeValue());
        return ob;
    }

 */
}
