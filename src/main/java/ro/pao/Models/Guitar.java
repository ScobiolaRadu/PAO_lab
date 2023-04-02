package ro.pao.Models;

import ro.pao.Models.Abstracts.AbstractInstrument;
import ro.pao.Models.Enums.EnumInstruments;

public class Guitar extends AbstractInstrument {
    
    private String body;

    public Guitar(String brand, String name, int price, int quantity, String body) {
        super(brand, name, price, quantity);
        this.type = EnumInstruments.GUITAR;
        this.body = body;
    }


    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
    
    @Override
    public String toString() {
        return "Guitar [brand= " + brand + ", name= " + name + ", body= " + body + ", price= " + price + ", quantity= "
                + quantity +"]";
    }
}
