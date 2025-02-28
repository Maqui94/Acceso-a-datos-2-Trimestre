import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class Entrada {
    public static void main(String[] args) {
        //Gestor
        DocumentBuilderFactory builderFactory=DocumentBuilderFactory.newInstance();
        //lector
        try {
            DocumentBuilder lector = builderFactory.newDocumentBuilder();
            Document document=lector.parse(new File("src/main/java/peliculas.xml"));
            Node nodoRaiz=document.getDocumentElement();
            //System.out.println(nodoRaiz.getTextContent());
            NodeList lista=nodoRaiz.getChildNodes();
            for(int i=0; i<lista.getLength();i++){
                Node node=lista.item(i);
              //  System.out.println(node.getTextContent());
                if(node.getNodeType() ==Node.ELEMENT_NODE){
                    System.out.println("nodo");
                    Node nodoTitulo=node.getAttributes().getNamedItem("titulo");
                    System.out.println(nodoTitulo.getTextContent());
                    Node nodoPuntuacion=node.getAttributes().getNamedItem("puntuacion");
                    System.out.println(nodoTitulo.getTextContent()+nodoPuntuacion.getTextContent());
                }
            }
        }catch (ParserConfigurationException e){
            System.out.println("Error en el parseo del dpcumento");
        } catch (IOException | SAXException e) {
            System.out.println("error en el parseo del fichero");
        }
    }
}
