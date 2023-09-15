import java.util.Scanner;

public class UserInterface {
    private Controller controller;
    public void startProgram(){
        UserInterface ui = new UserInterface();
        Database database = new Database();
        ui.controller = new Controller(database);
        Scanner scanner = new Scanner(System.in);
        int opretEllerAfslut;
        do {
            ui.controller.printStartMessage();
            opretEllerAfslut = scanner.nextInt();
            scanner.nextLine();
            switch (opretEllerAfslut){
                case 1:
                    ui.controller.createSuperhero();
                    break;
                case 2:
                    ui.controller.showSuperheroes();
                    break;
                case 3:
                    System.out.println("Search for superhero:");
                    String search = scanner.nextLine();
                    System.out.println(ui.controller.findSuperhero(search));
                    break;
                case 4:
                    System.out.println("Search for superhero");
                    search = scanner.nextLine();
                    ui.controller.findAllSuperhero(search);
                    break;
                case 5:
                    ui.controller.editSuperheroDetails();
                    break;
                case 9:
                    System.out.println("Program ended");
                default:
                    break;
            }

        } while (opretEllerAfslut != 9);
        scanner.close();


    }

}
