package data;

import domain.Superhero;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {

    private File superheroDatabase = new File("superheroDatabase.csv");

    public void saveSuperheroes(ArrayList<Superhero> database) {
        ArrayList<Superhero> superheroes = database;
        PrintStream output;
        try {
            output = new PrintStream(superheroDatabase);
          for (Superhero superhero : superheroes) {
         output.println(superhero.toCSVString());
        }
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public  void  loadSuperheros(ArrayList<Superhero> database){
        Scanner scanner;
        try {
            scanner = new Scanner(superheroDatabase);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] values = line.split(";");
                if (values.length == 6) {
                    String name = values[0];
                    String realName = values[1];
                    String superPower = values[2];
                    int yearCreated = Integer.parseInt(values[3]);
                    boolean isHuman = Boolean.parseBoolean(values[4]);
                    int strength = Integer.parseInt(values[5]);

                    Superhero superhero = new Superhero(name, realName, superPower, yearCreated, isHuman, strength);
                    database.add(superhero);
                }
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}

