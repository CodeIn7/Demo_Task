import java.util.List;

public interface ICommands {
    String read(Database database, int jmbag);
    String filterName(Database database, String pattern, String casing);
    String filterGrade(Database database, String comparator, int comparedGrade);
    String create(Database database, int jmbag, String name, String surname, int grade);
}
