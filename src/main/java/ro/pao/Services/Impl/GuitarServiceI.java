package src.main.java.ro.pao.Services.Impl;

import java.util.List;

import src.main.java.ro.pao.Models.Guitar;
import src.main.java.ro.pao.Services.GuitarService;

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
        for (int i = 0; i < guitars.size(); i++) {
            if (guitars.get(i).getName().equals(guitar.getName())) {
                guitars.set(i, guitar2);
            }
        }
    }

    @Override
    public void deleteGuitar(Guitar guitar) {
        for (int i = 0; i < guitars.size(); i++) {
            if (guitars.get(i).getName().equals(guitar.getName())) {
                guitars.remove(i);
            }
        }
    }
}

