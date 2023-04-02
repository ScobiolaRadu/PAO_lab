package src.main.java.ro.pao.Services;

import java.util.List;

import src.main.java.ro.pao.Models.Drums;

public interface DrumsService {
    
    public List<Drums> getAllDrums();

    public void addDrums(Drums drums);

    public void updateDrums(Drums drums, Drums drums2);

    public void deleteDrums(Drums drums);
}
