package src.main.java.ro.pao.Models;

import src.main.java.ro.pao.Models.Abstracts.AbstractInstrument;
import src.main.java.ro.pao.Models.Enums.EnumInstruments;

public class Drums extends AbstractInstrument {
    
    private int nr_drums;

    public Drums(String brand, String name, int price, int quantity, int nr_drums) {
        super(brand, name, price, quantity);
        this.type = EnumInstruments.DRUMS;
        this.nr_drums = nr_drums;
    }

    public int getNr_drums() {
        return nr_drums;
    }

    public void setNr_drums(int nr_drums) {
        this.nr_drums = nr_drums;
    }

    @Override
    public String toString() {
        return "Guitar [brand= " + brand + ", name= " + name + ", number of drums= " + nr_drums + ", price= " + price + ", quantity= "
                + quantity +"]";
    }
}
