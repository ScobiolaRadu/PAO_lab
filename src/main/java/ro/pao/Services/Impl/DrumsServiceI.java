package src.main.java.ro.pao.Services.Impl;

import java.util.ArrayList;
import java.util.List;

import src.main.java.ro.pao.Models.Drums;
import src.main.java.ro.pao.Services.DrumsService;

public class DrumsServiceI implements DrumsService{

    private List<Drums> drumsList = new ArrayList<>();

    @Override
    public List<Drums> getAllDrums() {
        return drumsList;
    }

    @Override
    public void addDrums(Drums drums) {
        drumsList.add(drums);
    }

    @Override
    public void updateDrums(Drums drums, Drums drums2) {
        for (int i = 0; i < drumsList.size(); i++) {
            if (drumsList.get(i).getName().equals(drums.getName())) {
                drumsList.set(i, drums2);
            }
        }
    }

    @Override
    public void deleteDrums(Drums drums) {
        for (int i = 0; i < drumsList.size(); i++) {
            if (drumsList.get(i).getName().equals(drums.getName())) {
                drumsList.remove(i);
            }
        }
    }
    

    
}