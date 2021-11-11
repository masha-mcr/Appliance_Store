package main.java.by.bsuir.WT.lab2.main;

import main.java.by.bsuir.WT.lab2.dao.impl.ApplianceDAOimpl;
import main.java.by.bsuir.WT.lab2.entity.*;
import main.java.by.bsuir.WT.lab2.entity.criteria.Criteria;
import main.java.by.bsuir.WT.lab2.entity.criteria.SearchCriteria;
import main.java.by.bsuir.WT.lab2.service.ApplianceService;
import main.java.by.bsuir.WT.lab2.service.ServiceFactory;

import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ApplianceService service = ServiceFactory.getInstance().getApplianceService();

        Criteria kettleCriteria = new Criteria(SearchCriteria.Kettle.class.getSimpleName());
        List<Appliance> kettles = service.find(kettleCriteria);
        if (kettles !=null) {
            List<Appliance> kettlesOrderedByName = service.sort(Comparator.comparing(Appliance::getName), kettles);
            System.out.println("\nВсе чайники(в алфавитном порядке): ");
            PrintApplianceInfo.print(kettlesOrderedByName);
        }

        List<Appliance> minPriceAppliances = service.getMin(Comparator.comparing(Appliance::getPrice));
        if (minPriceAppliances != null) {
            System.out.println("\nСамый дешевый прибор: ");
            PrintApplianceInfo.print(minPriceAppliances);
        }

        Criteria ovenCriteria = new Criteria(SearchCriteria.Oven.class.getSimpleName());
        ovenCriteria.add("powerConsumption", 2000);
        List<Appliance> ovens = service.find(ovenCriteria);
        PrintApplianceInfo.print(ovens);
    }
}