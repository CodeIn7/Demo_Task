import java.util.List;
import java.util.Scanner;

public class Input {

    public static void startInput(Database database) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            String[] inputField = input.split(" ");

            if(input.startsWith("read")) {
                try {
                    Check.checkRead(database, inputField);
                }
                catch (DatabaseException e) {
                    System.out.println(e.getMessage());
                    continue;
                }
                System.out.println(database.read(database, Integer.parseInt(inputField[1])));
            }
            else if (inputField[0].equals("create")) {
                try {
                    Check.checkCreate(database, inputField);
                }
                catch (DatabaseException e) {
                    System.out.println(e.getMessage());
                    continue;
                }
                System.out.println(database.create(database, Integer.parseInt(inputField[1]), inputField[2], inputField[3], Integer.parseInt(inputField[4])));
            }
            else if (inputField[0].startsWith("filter")) {
                if (inputField[0].startsWith("filter-grade")) {
                    try {
                        Check.checkFilterGrade(database, inputField);
                    }
                    catch (DatabaseException e) {
                        System.out.println(e.getMessage());
                        continue;
                    }
                   System.out.println(database.filterGrade(database, inputField[1], Integer.parseInt(inputField[2])));
                }
                else if (inputField[0].startsWith("filter-name")) {
                    boolean casing;
                    try {
                        casing = Check.checkFilterName(database, inputField);
                    }
                    catch (DatabaseException e) {
                        System.out.println(e.getMessage());
                        continue;
                    }
                    if (!casing) {
                        System.out.println(database.filterName(database, inputField[1], null));
                    }
                    else {
                        System.out.println(database.filterName(database, inputField[1], inputField[2]));
                    }
                }
                else {
                    System.out.println("Pogresno upisana naredba, mogucnosti -> filter-name | filter-grade");
                    continue;
                }
            }
            else if (input.equals("exit")) {
                return;
            }
            else {
                System.out.println("Greska! Naredba " + input + " ne postoji.");
            }
        }

    }


}
