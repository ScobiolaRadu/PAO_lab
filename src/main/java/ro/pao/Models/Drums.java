package ro.pao.Models;

import ro.pao.Models.Abstracts.AbstractInstrument;
import ro.pao.Models.Enums.EnumInstruments;

public class Drums extends AbstractInstrument {

    private int id;
    private int nr_drums;

    public Drums(int id, String brand, String name, int price, int quantity, int nr_drums) {
        super(brand, name, price, quantity);
        this.id = id;
        this.type = EnumInstruments.DRUMS;
        this.nr_drums = nr_drums;
    }

    public Drums(String brand, String name, int price, int quantity, int nr_drums) {
        super(brand, name, price, quantity);
        this.type = EnumInstruments.DRUMS;
        this.nr_drums = nr_drums;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNr_drums() {
        return nr_drums;
    }

    public void setNr_drums(int nr_drums) {
        this.nr_drums = nr_drums;
    }

    @Override
    public String toString() {
        return "Drums [id= " + id + ", brand= " + brand + ", name= " + name + ", number of drums= " + nr_drums
                + ", price= " + price + ", quantity= "
                + quantity + "]";
    }
}
