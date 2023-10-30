import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInterface {
    private Controller controller;

    public void startProgram() {
        UserInterface ui = new UserInterface();
        Database database = new Database();
        ui.controller = new Controller(database);
        Scanner scanner = new Scanner(System.in);
        int isRunning = -1;
        do {
            ui.controller.printStartMessage();
            try {
                isRunning = scanner.nextInt();
                scanner.nextLine();
                switch (isRunning) {
                    case 1 -> ui.controller.createSuperhero();
                    case 2 -> ui.controller.showSuperheroes();
                    case 3 -> {
                        System.out.println("Search for superhero:");
                        String search = scanner.nextLine();
                        System.out.println(ui.controller.findSuperhero(search));
                    }
                    case 4 -> {
                        System.out.println("Search for superhero");
                        String search2 = scanner.nextLine();
                        ui.controller.findAllSuperhero(search2);
                    }
                    case 5 -> ui.controller.editSuperheroDetails();
                    case 6 -> {
                        System.out.println("Select a superhero to remove:");
                        for (int i = 0; i < database.size(); i++) {
                            System.out.println(i + 1 + ". " + database.get(i).getName());
                        }
                        int searchIndex = scanner.nextInt() - 1;
                        ui.controller.removeSuperhero(searchIndex);
                    }
                    case 9 -> System.out.println("Program ended");
                    default -> System.out.println("Try again with the values stated under: ");
                }
            } catch (InputMismatchException e) {
                System.out.println("not possible input. Press ENTER to continue");
                scanner.nextLine();
            }

        } while (isRunning != 9);

        scanner.close();
    }

}
