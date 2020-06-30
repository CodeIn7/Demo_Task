import java.util.List;

public interface ICommands {
    String read(int jmbag);
    String filterName(String pattern, String casing);
    String filterGrade(String comparator, int comparedGrade);
    String create(int jmbag, String name, String surname, int grade);
}
