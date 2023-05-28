package ro.pao;

import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.sql.Connection;
import java.util.List;

import ro.pao.Models.Guitar;
import ro.pao.Repositories.impl.GuitarRepositoryI;
import ro.pao.Services.GuitarService;
import ro.pao.Services.Impl.GuitarServiceI;

import java.util.ArrayList;

public class Export {

    private GuitarService guitarService;
    public void guitarsCSVFile(Connection connection){
        guitarService = new GuitarServiceI(new GuitarRepositoryI(connection) {
        });        
        List<Guitar> guitarsList = guitarService.getAllGuitars();
        String fileName = "Guitars.csv";
    
        try{
            CSVWriter writer = new CSVWriter(new FileWriter(fileName));
            List<String[]> data = new ArrayList<>();
            String[] header = {"Id", "Brand", "Name", "Price", "Quantity", "Body"};
            data.add(header);
    
            for(Guitar guitar: guitarsList){
                String[] row = {Integer.toString(guitar.getId()) , guitar.getBrand(), guitar.getName(), Integer.toString(guitar.getPrice()), Integer.toString(guitar.getQuantity()), guitar.getBody()};
                data.add(row);
            }
    
            System.out.println("the CSV file was succesfully created!");
            writer.writeAll(data);
            writer.close();
    
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    
}
