import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Database database = new Database();
        int opretEllerAfslut;
        do {

            System.out.println("Welcome to THE SUPERHERO UNIVERSE");
            System.out.println("Press 1 to create superhero");
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
                database.addSuperhero(superheroName, realName, superpower, creationYear, isHuman, strength);
            } else if (opretEllerAfslut == 9) {
                // Retrieve and print all superheros in the database
                ArrayList<Superhero> superheroes = database.getDatabase();
                for (Superhero superhero : superheroes) {
                    System.out.println("Superhero Name: " + superhero.getName());
                    System.out.println("Real Name: " + superhero.getRealName());
                    System.out.println("Superpower: " + superhero.getSuperPower());
                    System.out.println("Creation Year: " + superhero.getYearCreated());
                    System.out.println("Is Human: " + superhero.isHuman());
                    System.out.println("Strength: " + superhero.getStrength());
                    System.out.println();
                }
            }
        } while(opretEllerAfslut != 9);
        scanner.close();
    }
}