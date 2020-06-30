public class Student {
    private int jmbag;
    private String name;
    private String surname;
    private int grade;

    public Student(int jmbag, String name, String surname, int grade) {
        this.jmbag = jmbag;
        this.name = name;
        this.surname = surname;
        this.grade = grade;
    }

    public Student() {

    }

    public int getJmbag() {
        return jmbag;
    }

    public void setJmbag(int jmbag) {
        this.jmbag = jmbag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Podaci o studentu: " +
                "jmbag=" + jmbag +
                ", ime='" + name + '\'' +
                ", prezime='" + surname + '\'' +
                ", ocjena=" + grade + "."
                ;
    }
}
