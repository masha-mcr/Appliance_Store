package main.java.by.bsuir.WT.lab2.main;

import main.java.by.bsuir.WT.lab2.dao.impl.ApplianceDAOimpl;
import main.java.by.bsuir.WT.lab2.entity.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ApplianceDAOimpl applianceDAOimpl = new ApplianceDAOimpl();
        List<Appliance> appliances = applianceDAOimpl.parseAll();
        for (Appliance app: appliances) {
            System.out.println(app.toString());
        }
       }
}