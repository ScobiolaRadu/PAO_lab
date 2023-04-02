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
        int ok=0;
        for (int i = 0; i < pianos.size(); i++) {
            if (pianos.get(i).getName().equals(piano.getName())) {
                ok=1;
                pianos.set(i, piano2);
            }
        }

        if(ok==0)
            System.out.println("Piano not found");
    }

    @Override
    public void deletePiano(Piano piano) {
        int ok=0;
        for (int i = 0; i < pianos.size(); i++) {
            if (pianos.get(i).getName().equals(piano.getName())) {
                ok=1;
                pianos.remove(i);
            }
        }

        if(ok==0)
            System.out.println("Piano not found");
    }
}
