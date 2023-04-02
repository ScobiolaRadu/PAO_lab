package ro.pao.Services;

import java.util.List;

import ro.pao.Models.Guitar;

public interface GuitarService {

    public List<Guitar> getAllGuitars();

    public void addGuitar(Guitar guitar);

    public void updateGuitar(Guitar guitar, Guitar guitar2);

    public void deleteGuitar(Guitar guitar);

}

    