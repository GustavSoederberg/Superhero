import java.util.ArrayList;
import java.util.Scanner;

public class Controller {
    private Database db = new Database();


    public Controller(Database db) {
        this.db = db;
    }

    public void addSuperhero(String superheroName, String realName, String superpower, int creationYear, boolean hasSuperpowers, int strength) {
        db.addSuperhero(superheroName, realName, superpower, creationYear, hasSuperpowers, strength);
        System.out.println("Superhero added to the database.");
    }

    public ArrayList<Superhero> getDatabase() {
        return db.getDatabase();
    }
    public ArrayList<Superhero> findAllSuperhero(String search) {
        return db.findAllSuperhero(search);
    }
    public Superhero findSuperhero(String search){
        return db.findSuperhero(search);
    }

    public void createSuperhero(){
        Scanner scanner = new Scanner(System.in);
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

        System.out.print("Strength: ");
        int strength = scanner.nextInt();

        db.addSuperhero(superheroName, realName, superpower, creationYear, isHuman, strength);
    }

    public void showSuperheroes(){
        ArrayList<Superhero> superheroes = db.getDatabase();
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

    }
    public void editSuperhero(Superhero s){
        db.editSuperhero(s);

    }
    public void editSuperheroDetails() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Select a superhero to edit:");
        for (int i = 0; i < db.size(); i++) {
            System.out.println(i + 1 + ". " + db.get(i).getName());
        }

        System.out.print("Enter the index of the superhero you want to edit: ");
        int choice = scanner.nextInt();

        if (choice > 0 && choice <= db.size()) {
            // Get the selected superhero
            Superhero selectedSuperhero = db.get(choice - 1);

            editSuperhero(selectedSuperhero);
        } else {
            System.out.println("Invalid choice. Please try again.");
        }

    }

    public void printStartMessage(){
        System.out.println("""
                    Press 1 to create superhero
                    Press 2 to show superheroes
                    Press 3 to find first Superhero
                    Press 4 to get list of superheroes of search criteria
                    Press 5 to edit superhero
                    Press 9 to end
                    """);
    }
}
