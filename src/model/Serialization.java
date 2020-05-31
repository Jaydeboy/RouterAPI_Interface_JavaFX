package model;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class Serialization {



    public static List getHearingOfficeList() throws IOException, ParserConfigurationException, SAXException {

        List<Hearing_Office> list = new ArrayList<>();

        URL url = new URL("http://localhost:8080/hearing_Office/list");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setDoInput(true);
        connection.setReadTimeout(15*1000);
        connection.connect();

        DocumentBuilderFactory dbfacotry = DocumentBuilderFactory.newInstance();

        try (InputStream inputStream = connection.getInputStream()) {

            DocumentBuilder dBuilder = dbfacotry.newDocumentBuilder();
            Document doc = dBuilder.parse(inputStream);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("row");

            for(int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);

                if(nNode.getNodeType() == nNode.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;

                   String office_Name = eElement.getElementsByTagName("HEARING_OFFICE_NAME")
                            .item(0).getTextContent();
                   int ho_Code = eElement.getElementsByTagName("HO_CODE").item(0).getTextContent() == ""? 0:
                            Integer.parseInt(eElement.getElementsByTagName("HO_CODE").item(0).getTextContent());
                   int region = Integer.parseInt(eElement.getElementsByTagName("REGION")
                            .item(0).getTextContent());
                   double averageOfficeTimesInMonths = Double.parseDouble(eElement.
                            getElementsByTagName("HEARING_OFFICE_TIMES_IN_MONTHS")
                            .item(0).getTextContent());

                    Hearing_Office office = new Hearing_Office(ho_Code, office_Name, region, averageOfficeTimesInMonths);
                    list.add(office);
                }
            }
        }
        return list;
    }
}



