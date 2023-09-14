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
            System.out.println("""
                    Press 1 to create superhero
                    Press 2 to show superheroes
                    Press 3 to find first Superhero
                    Press 4 to get list of superheroes of search criteria
                    Press 9 to end
                    """);
            opretEllerAfslut = scanner.nextInt();
            scanner.nextLine();
            if (opretEllerAfslut == 1) {
                m.controller.createSuperhero();
            } else if (opretEllerAfslut == 2) {
                m.controller.showSuperheroes();
            } else if (opretEllerAfslut == 3) {
                System.out.println("Search for superhero:");
                String search = scanner.nextLine();
                System.out.println(m.controller.findSuperhero(search));
            } else if (opretEllerAfslut == 4) {
                System.out.println("Search for superhero");
                String search = scanner.nextLine();
                m.controller.findAllSuperhero(search);

            }
        } while (opretEllerAfslut != 9);
        scanner.close();
    }
}
