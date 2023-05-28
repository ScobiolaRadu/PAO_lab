package ro.pao.Services;

import ro.pao.Models.Piano;

import java.util.List;

public interface PianoService {

    List<Piano> getAllPianos();

    void addPiano(Piano piano);

    void updatePiano(int id, Piano piano);

    void deletePiano(int id);

    Piano getPianoById(int id);

}
