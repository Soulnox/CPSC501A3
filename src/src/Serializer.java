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
        return doc;
    }
}
