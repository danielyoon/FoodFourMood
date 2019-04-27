package com.danielyoon.foodfourmood;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class XMLReader {
    private static String[] array = new String[10];
    private static int index = 0;

    public XMLReader() {
        array[index] = "#FFFFFF";
    }

    public void editColors(String x) {
        try {
            File xmlFile = new File("gradient_background.xml");
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            updateElementValue(doc, x);

            doc.getDocumentElement().normalize();
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            System.out.println("-----------Modified File-----------");
            StreamResult result = new StreamResult(System.out);
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.transform(source, result);

        } catch (SAXException | ParserConfigurationException | IOException | TransformerException e1) {
            e1.printStackTrace();
        }
    }

    public static void updateElementValue(Document doc, String x) {
        int i = 0;
        if (index == 0) {
            NodeList center = doc.getElementsByTagName("centerColor");
            center.item(i).setTextContent("android:centerColor=" + x);
            index++;
            return;
        } else {
            String newColor = combineColors(array[index], x);
            NodeList start = doc.getElementsByTagName("startColor");
            start.item(i).setTextContent("android:startColor=" + x);
            NodeList center = doc.getElementsByTagName("centerColor");
            center.item(i).setTextContent("android:centerColor=" + newColor);
            NodeList end = doc.getElementsByTagName("endColor");
            end.item(i).setTextContent("android:endColor=" + array[index]);
            ++index;
            array[index] = newColor;
        }
    }

    public static String combineColors(String previousColor, String currentColor) {
        StringBuilder sb = new StringBuilder("#");
        for (int i = 0; i < 3; i++) {
            String sub1 = previousColor.substring(1 + 2 * i, 3 + 2 * i);
            String sub2 = currentColor.substring(1 + 2 * i, 3 + 2 * i);
            int v1 = Integer.parseInt(sub1, 16);
            int v2 = Integer.parseInt(sub2, 16);
            int v = (v1 + v2) / 2;
            String sub = String.format("%02X", v);
            sb.append(sub);
        }
        String result = sb.toString();
        return result;
    }

}