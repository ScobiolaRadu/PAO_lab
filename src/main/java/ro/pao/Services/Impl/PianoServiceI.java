package ro.pao.Services.Impl;

import java.util.ArrayList;
import java.util.List;

import ro.pao.Models.Piano;
import ro.pao.Services.PianoService;

public class PianoServiceI implements PianoService{
    
    private List<Piano> pianos = new ArrayList<>();

    @Override
    public List<Piano> getAllPianos() {
        return pianos;
    }

    @Override
    public void addPiano(Piano piano) {
        pianos.add(piano);
    }

    @Override
    public void updatePiano(Piano piano, Piano piano2) {
        for (int i = 0; i < pianos.size(); i++) {
            if (pianos.get(i).getName().equals(piano.getName())) {
                pianos.set(i, piano2);
            }
        }
    }

    @Override
    public void deletePiano(Piano piano) {
        for (int i = 0; i < pianos.size(); i++) {
            if (pianos.get(i).getName().equals(piano.getName())) {
                pianos.remove(i);
            }
        }
    }
}
