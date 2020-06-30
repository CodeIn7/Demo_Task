import java.util.List;

public class Database implements ICommands {
    private List<Student> students;

    public Database(List<Student> students) {
        this.students = students;
    }


    @Override
    public String read(int jmbag) {
        StringBuilder stringBuilder = new StringBuilder();
        boolean exists = false;
        for(Student student : students) {
            if(jmbag == student.getJmbag()) {
                exists = true;
                stringBuilder.append(student.toString() + '\n');
            }
        }
        if(!exists) {
            stringBuilder.append("Student s jmbag-om " + jmbag + " ne postoji!");
        }
        return stringBuilder.toString();
    }

    @Override
    public String filterName(String pattern, String casing) {
        StringBuilder stringBuilder = new StringBuilder();
        for(Student student : students) {
            if (student.getName().toLowerCase().startsWith(pattern.toLowerCase())) {
                if(casing == null) {
                    stringBuilder.append(student.getName() + " " + student.getSurname() + '\n');
                }
                else if (casing.equals("-l")){
                    stringBuilder.append(student.getName().toLowerCase() + " " + student.getSurname().toLowerCase() + '\n');
                }
                else if (casing.equals("-u")) {
                    stringBuilder.append(student.getName().toUpperCase() + " " + student.getSurname().toUpperCase() + '\n');
                }
            }
        }
        return stringBuilder.toString();
    }

    @Override
    public String filterGrade(String comparator, int comparedGrade) {
        StringBuilder stringBuilder = new StringBuilder();
        if (comparator.equals("l")) {
            for(Student student : students) {
                if(student.getGrade() < comparedGrade) {
                    stringBuilder.append(student.toString() + '\n');
                }
            }
        }
        else if (comparator.equals("g")) {
            for(Student student : students) {
                if(student.getGrade() > comparedGrade) {
                    stringBuilder.append(student.toString() + '\n');
                }
            }
        }
        else if (comparator.equals("e")) {
            for (Student student : students) {
                if (student.getGrade() == comparedGrade) {
                    stringBuilder.append(student.toString() + '\n');
                }
            }
        }
        else {
            return "Greska! Komparator: " + comparator + " ne postoji. (Opcije: l/g/e)";
        }
        return stringBuilder.toString();
    }

    @Override
    public String create(int jmbag, String name, String surname, int grade) {
        Student student = new Student(jmbag, name, surname, grade);
        students.add(student);
        return "Added new student: " + student.toString();
    }
}
