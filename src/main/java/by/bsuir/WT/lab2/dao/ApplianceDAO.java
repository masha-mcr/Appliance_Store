package main.java.by.bsuir.WT.lab2.dao;

import main.java.by.bsuir.WT.lab2.entity.Appliance;
import main.java.by.bsuir.WT.lab2.entity.criteria.Criteria;

import java.util.List;

public interface ApplianceDAO {

    List<Appliance> find(Criteria criteria); //Criteria criteria

    void save(List<Appliance> appliences);

    List<Appliance> parseAll();
}
