package com.endava;

import com.sun.xml.internal.bind.v2.runtime.JaxBeanInfo;
import generated.PurchaseOrder;
import generated.USAddress;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {

        Logger logger = LoggerFactory.getLogger("com.endava.Main");

        try {
            execute();
        } catch (JAXBException e) {
            logger.error("Cannot perform a JAXB operation");
        } catch (FileNotFoundException e) {
            logger.error("File not found");
        }

    }

    private static void execute() throws JAXBException, FileNotFoundException {
        JAXBContext context = JAXBContext.newInstance("generated");

        Unmarshaller unmarshaller = context.createUnmarshaller();

        PurchaseOrder po = (PurchaseOrder) unmarshaller.unmarshal(new FileInputStream("src/schemas/po.xml"));

        USAddress address = po.getBillTo();
        address.setName("John Bob");
        address.setStreet("242 Main Street");
        address.setCity("Beverly Hills");
        address.setState("CA");
        address.setZip(new BigDecimal("90210"));

        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(po, System.out);
    }
}
