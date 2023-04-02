package ro.pao;

import ro.pao.Models.Admin;
import ro.pao.Models.Client;
import ro.pao.Models.Drums;
import ro.pao.Models.Guitar;
import ro.pao.Models.Piano;
import ro.pao.Services.GuitarService;
import ro.pao.Services.Impl.GuitarServiceI;
import ro.pao.Services.Impl.PianoServiceI;
import ro.pao.Services.Impl.DrumsServiceI;
import ro.pao.Services.Impl.ClientServiceI;
import ro.pao.Services.PianoService;
import ro.pao.Services.DrumsService;
import ro.pao.Services.ClientService;
import ro.pao.Application.Menu;

import java.util.Scanner;


public class Main {
 
    public static void main(String[] args) {

        Menu menu = new Menu();
        menu.showMenu();

    }   
}
