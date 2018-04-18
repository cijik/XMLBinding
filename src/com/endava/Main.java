package com.endava;

import schemas.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws JAXBException, FileNotFoundException {

        JAXBContext context = JAXBContext.newInstance("schemas");

        Unmarshaller unmarshaller = context.createUnmarshaller();

        Routes po = (Routes) unmarshaller.unmarshal(new FileInputStream("routes.xml"));

        Route route = po.


    }
}
