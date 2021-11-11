package main.java.by.bsuir.WT.lab2.service;

import main.java.by.bsuir.WT.lab2.entity.Appliance;
import main.java.by.bsuir.WT.lab2.entity.criteria.Criteria;

import java.util.Comparator;
import java.util.List;

public interface ApplianceService {
    List<Appliance> find(Criteria criteria);
    List<Appliance> sort(Comparator<Appliance> comparator);
    List<Appliance> getMin(Comparator<Appliance> comparator);
    List<Appliance> getMax(Comparator<Appliance> comparator);
}
