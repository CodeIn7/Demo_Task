import javax.xml.crypto.Data;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LoadData {

    public static Database loadData(String studentsCSV) throws IOException {
        String line = "";
        boolean success = false;

        List<Student> students = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(studentsCSV))) {
            while ((line = bufferedReader.readLine()) != null) {
                String[] studentInfo = line.split(",");
                Student student = new Student(Integer.parseInt(studentInfo[0]), studentInfo[1], studentInfo[2], Integer.parseInt(studentInfo[3]));
                boolean add = students.add(student);
                if(add) success = true;
            }
        }
        if(success == false) {
            throw new DatabaseException("Studenti neuspjesno ucitani!");
        }
        return new Database(students);
}
}
