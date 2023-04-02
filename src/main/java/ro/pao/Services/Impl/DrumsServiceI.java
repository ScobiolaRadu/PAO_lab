package ro.pao.Services.Impl;

import java.util.ArrayList;
import java.util.List;

import ro.pao.Models.Drums;
import ro.pao.Services.DrumsService;

public class DrumsServiceI implements DrumsService{

    private List<Drums> drumsList =  new ArrayList<>();

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
        int ok=0;
        for (int i = 0; i < drumsList.size(); i++) {
            if (drumsList.get(i).getName().equals(drums.getName())) {
                ok=1;
                drumsList.set(i, drums2);
            }
        }

        if(ok==0)
            System.out.println("Drums not found");
    }

    @Override
    public void deleteDrums(Drums drums) {
        int ok=0;
        for (int i = 0; i < drumsList.size(); i++) {
            if (drumsList.get(i).getName().equals(drums.getName())) {
                ok=1;
                drumsList.remove(i);
            }
        }

        if(ok==0)
            System.out.println("Drums not found");
    }
    

    
}