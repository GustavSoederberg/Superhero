import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private Controller controller;
    private Database database;

    public static void main(String[] args) {
        Main m = new Main();
        Database database = new Database();
        m.controller = new Controller(database);
        Scanner scanner = new Scanner(System.in);
        int opretEllerAfslut;
        do {
            System.out.println("Welcome to THE SUPERHERO UNIVERSE");
            System.out.println("Press 1 to create superhero");
            System.out.println("Press 2 to show superheroes");
            System.out.println("Press 3 to Find Superhero");
            System.out.println("Press 9 to end");
            opretEllerAfslut = scanner.nextInt();
            scanner.nextLine();
            if (opretEllerAfslut == 1) {
                System.out.println("Enter superhero details:");
                System.out.print("Superhero Name: ");
                String superheroName = scanner.nextLine();
                System.out.print("Real Name: ");
                String realName = scanner.nextLine();
                System.out.print("Superpower: ");
                String superpower = scanner.nextLine();
                System.out.print("Creation Year: ");
                int creationYear = scanner.nextInt();
                System.out.print("Is the superhero human? (true/false): ");
                boolean isHuman = scanner.nextBoolean();
                System.out.print("Strength (1-100): ");
                int strength = scanner.nextInt();

                // Add superhero data to the database
                m.controller.addSuperhero(superheroName, realName, superpower, creationYear, isHuman, strength);
            } else if (opretEllerAfslut == 2) {
                // Retrieve and print all superheros in the database
                ArrayList<Superhero> superheroes = m.controller.getDatabase();
                for (Superhero superhero : superheroes) {
                    System.out.println("Superhero Name: " + superhero.getName());
                    System.out.println("Real Name: " + superhero.getRealName());
                    System.out.println("Superpower: " + superhero.getSuperPower());
                    System.out.println("Creation Year: " + superhero.getYearCreated());
                    if (superhero.isHuman() == true) {
                        System.out.println("Is human: Yes");
                    } else if (superhero.isHuman() == false) {
                        System.out.println("Is human: No");
                    }
                    System.out.println("Strength: " + superhero.getStrength());
                    System.out.println();
                }


            } else if (opretEllerAfslut == 3) {
                System.out.println("Search for superhero:");
                String search = scanner.nextLine();
                System.out.println(m.controller.findSuperhero(search));
            }
        } while (opretEllerAfslut != 9);
        scanner.close();
    }
}