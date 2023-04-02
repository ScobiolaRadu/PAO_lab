package ro.pao.Services.Impl;

import java.util.List;

import ro.pao.Models.Guitar;
import ro.pao.Services.GuitarService;

import java.util.ArrayList;

public class GuitarServiceI implements GuitarService {

    private List<Guitar> guitars = new ArrayList<>();

    @Override
    public List<Guitar> getAllGuitars() {
        return guitars;
    }

    @Override
    public void addGuitar(Guitar guitar) {
        guitars.add(guitar);
    }

    @Override
    public void updateGuitar(Guitar guitar, Guitar guitar2) {
        int ok=0;
        for (int i = 0; i < guitars.size(); i++) {
            if (guitars.get(i).getName().equals(guitar.getName())) {
                ok=1;
                guitars.set(i, guitar2);
            }
        }

        if(ok==0)
            System.out.println("Guitar not found");
    }

    @Override
    public void deleteGuitar(Guitar guitar) {
        int ok=0;
        for (int i = 0; i < guitars.size(); i++) {
            if (guitars.get(i).getName().equals(guitar.getName())) {
                ok=1;
                guitars.remove(i);
            }
        }

        if(ok==0)
            System.out.println("Guitar not found");
    }
}

