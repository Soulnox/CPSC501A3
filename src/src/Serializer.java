import org.jdom.*;

public class Serializer {


    public org.jdom.Document serialize(Object obj) {
        Document doc = new Document();
        doc.setRootElement(new Element("serialized"));
        String name = obj.getClass().getName();
        if (name.equalsIgnoreCase("PrimitiveClass")) {
            PrimitiveClass primi = new PrimitiveClass((PrimitiveClass) obj);
            //System.out.println("PrimitiveClass in Serializer");
            Element prim = new Element("object");
            prim.setAttribute("id", "0");
            prim.setAttribute("class", name);
            prim.addContent(new Element("value").setText(""+primi.getValue()));
            prim.addContent(new Element("money").setText(""+primi.getMoney()));
            prim.addContent(new Element("bool").setText(""+primi.getBool()));
            doc.getRootElement().addContent(prim);
        }

        if (name.equalsIgnoreCase(("PrimitiveArrayClass"))) {
            PrimitiveArrayClass primiA = new PrimitiveArrayClass((PrimitiveArrayClass) obj);
            int length = primiA.getLength();
            Element primA = new Element("object");
            primA.setAttribute("id", "0");
            primA.setAttribute("class", "[I");
            primA.setAttribute("length", "" + length);
            int[] integers = primiA.getIntegers();
            for (int i = 0; i < length; i++) {
                primA.addContent(new Element("value").setText("" + integers[i]));
            }
            doc.getRootElement().addContent(primA);
        }
        return doc;
    }
}
