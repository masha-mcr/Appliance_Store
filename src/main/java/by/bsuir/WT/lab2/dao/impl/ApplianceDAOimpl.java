package main.java.by.bsuir.WT.lab2.dao.impl;
import main.java.by.bsuir.WT.lab2.dao.ApplianceDAO;
import main.java.by.bsuir.WT.lab2.entity.Appliance;
import main.java.by.bsuir.WT.lab2.entity.criteria.Criteria;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ApplianceDAOimpl implements ApplianceDAO {

    private static final String path = "src/main/resources/appliances.xml";
    @Override
    public List<Appliance> find(Criteria criteria) {
        List<Appliance> foundAppliances = new ArrayList<>();
        Appliance appliance;

        try (XMLDecoder decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(path)))) {
            do {
                appliance = (Appliance) decoder.readObject();
                if (fitsCriteria(appliance, criteria)) {
                    foundAppliances.add(appliance);
                }

            } while (appliance != null);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            // end of xml file
        }
        catch (FileNotFoundException | IllegalAccessException e) {
            System.out.println(e.getMessage());
        }

        return foundAppliances;
    }

    @Override
    public void save(List<Appliance> appliences) {
        try(XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(path)))){
            for(Appliance appliance : appliences){
                encoder.writeObject(appliance);
            }
        }
        catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Appliance> parseAll() {
        List<Appliance> appliances = new ArrayList<>();
        try(XMLDecoder decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(path)))){
            Appliance result;
            do{
                result = (Appliance)decoder.readObject();
                appliances.add(result);
            }
            while(result != null);
        }
        catch(FileNotFoundException e){
            System.out.println(e.getMessage());
        }
        catch (ArrayIndexOutOfBoundsException e){
            //end of xml file;
        }
        return appliances;
    }

    private boolean fitsCriteria(Appliance appliance, Criteria criteria) throws IllegalAccessException {
        if (!appliance.getClass().getSimpleName().equals(criteria.getGroupSearchName())){
            return false;
        }

        Set<String> properties = criteria.getCriteria().keySet();
        for (String property : properties) {
            try {
                Field field = appliance.getClass().getDeclaredField(property);
                field.setAccessible(true);
                Object fieldValue = field.get(appliance);
                if (!fieldValue.toString().equals(criteria.getCriteria().get(property).toString())) {
                    return false;
                }
            } catch (NoSuchFieldException e){
            }
        }
        for (String property : properties) {
            try {
                Field parentField = appliance.getClass().getSuperclass().getDeclaredField(property);
                parentField.setAccessible(true);
                Object parentFieldValue = parentField.get(appliance);
                if (!parentFieldValue.toString().equals(criteria.getCriteria().get(property).toString())) {
                    return false;
                }
            } catch (NoSuchFieldException e) {
            }
        }
        return true;
    }
}
