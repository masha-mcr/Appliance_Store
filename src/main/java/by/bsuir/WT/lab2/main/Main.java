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
        List<Appliance> kettlesOrderedByName = service.sort(Comparator.comparing(Appliance::getName),service.find(kettleCriteria));

    }
}