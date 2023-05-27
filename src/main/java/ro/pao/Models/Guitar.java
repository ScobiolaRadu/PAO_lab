package ro.pao.Models;

import ro.pao.Models.Abstracts.AbstractInstrument;
import ro.pao.Models.Enums.EnumInstruments;

public class Guitar extends AbstractInstrument {
    
    private int id;
    private String body;

    public Guitar(int id, String brand, String name, int price, int quantity, String body) {
        super(brand, name, price, quantity);
        this.id = id;
        this.type = EnumInstruments.GUITAR;
        this.body = body;
    }

    public Guitar(String brand, String name, int price, int quantity, String body) {
        super(brand, name, price, quantity);
        this.type = EnumInstruments.GUITAR;
        this.body = body;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
    
    @Override
    public String toString() {
        return "Guitar [id= " + id + ", brand= " + brand + ", name= " + name + ", body= " + body + ", price= " + price
                + ", quantity= " + quantity + "]";
    }
}
