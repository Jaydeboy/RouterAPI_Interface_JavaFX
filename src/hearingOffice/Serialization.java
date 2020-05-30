package hearingOffice;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;


public class Serialization {



    public static void Hearing_wait_Time_XML_To_Object() throws IOException, ParserConfigurationException
                                                                , SAXException {

        DocumentBuilderFactory dbfacotry = DocumentBuilderFactory.newInstance();

        String office_Name ="";
        String site_Code ="";
        int ho_Code =0;
        int region = 0;
        Double averageOfficeTimesInMonths = 0.0d;


            try (FileInputStream inputStream = new FileInputStream( new File("office.xml"))) {

                DocumentBuilder dBuilder = dbfacotry.newDocumentBuilder();
                Document doc = dBuilder.parse(inputStream);
                doc.getDocumentElement().normalize();
                NodeList nList = doc.getElementsByTagName("row");

                for (int temp = 0; temp < nList.getLength(); temp++) {
                    Node nNode = nList.item(temp);

                    if(nNode.getNodeType() == nNode.ELEMENT_NODE) {
                        Element eElement = (Element) nNode;

                            office_Name = eElement.getElementsByTagName("HEARING_OFFICE_NAME")
                                    .item(0).getTextContent();
                            ho_Code = eElement.getElementsByTagName("HO_CODE").item(0).getTextContent() == ""? ho_Code++: //need a better implementation here
                                Integer.parseInt(eElement.getElementsByTagName("HO_CODE").item(0).getTextContent());
                            region = Integer.parseInt(eElement.getElementsByTagName("REGION")
                                    .item(0).getTextContent());
                            averageOfficeTimesInMonths = Double.parseDouble(eElement.
                                    getElementsByTagName("HEARING_OFFICE_TIMES_IN_MONTHS")
                                    .item(0).getTextContent());

                        Hearing_Office office = new Hearing_Office(office_Name,
                                            ho_Code,region,averageOfficeTimesInMonths);
                        

                        HearingList.hearingOfficeList.put(ho_Code, office);
                    }
                }
            }
        }
    }



