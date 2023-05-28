package ro.pao.Models;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private int id;
    private int clientId;
    private List<Guitar> guitars;
    private List<Piano> pianos;
    private List<Drums> drums;

    public Cart() {
        this.guitars = new ArrayList<>();
        this.pianos = new ArrayList<>();
        this.drums = new ArrayList<>();
    }

    public Cart(int id, int clientId, List<Guitar> guitars, List<Piano> pianos, List<Drums> drums) {
        this.id = id;
        this.clientId = clientId;
        this.guitars = guitars;
        this.pianos = pianos;
        this.drums = drums;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public List<Guitar> getGuitars() {
        return guitars;
    }

    public void setGuitars(List<Guitar> guitars) {
        this.guitars = guitars;
    }

    public List<Piano> getPianos() {
        return pianos;
    }

    public void setPianos(List<Piano> pianos) {
        this.pianos = pianos;
    }

    public List<Drums> getDrums() {
        return drums;
    }

    public void setDrums(List<Drums> drums) {
        this.drums = drums;
    }

    public void addGuitar(Guitar guitar) {
        this.guitars.add(guitar);
    }

    public void addPiano(Piano piano) {
        this.pianos.add(piano);
    }

    public void addDrums(Drums drums) {
        this.drums.add(drums);
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", clientId=" + clientId +
                ", guitars=" + guitars +
                ", pianos=" + pianos +
                ", drums=" + drums +
                '}';
    }
}
