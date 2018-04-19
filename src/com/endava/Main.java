package com.endava;

import generated.PurchaseOrder;
import generated.USAddress;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) throws JAXBException, FileNotFoundException {

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
