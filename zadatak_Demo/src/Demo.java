import javax.xml.crypto.Data;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) throws IOException {
        System.out.println("Dobrodosao dragi korisnice...");
        Database database;
        try {
            database = LoadData.loadData(args[0]);
        } catch (DatabaseException e) {
            System.out.println(e.getMessage());
            return;
        }
        System.out.println("Studenti su uspjesno ucitani!");
        Input.startInput(database);

    }
}
