package src.main.java.ro.pao.Services;

import java.util.List;

import src.main.java.ro.pao.Models.Piano;

public interface PianoService {
    
    public List<Piano> getAllPianos();

    public void addPiano(Piano piano);

    public void updatePiano(Piano piano, Piano piano2);

    public void deletePiano(Piano piano);

}
