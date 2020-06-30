
public class Check {

    public static void checkRead(String[] inputField) {
        if (inputField.length != 2) {
            throw new DatabaseException("Netocan broj argumenata naredbe read (pr. read arg1)");
        } else if (!inputField[1].matches("^\\d+$")) {
            throw new DatabaseException("Greska! Uneseni podatak nije broj! (unijeti 8 znamenki jmbaga)");
        } else if (inputField[1].length() != 8) {
            throw new DatabaseException("Greska! Jmbag sadrzava 8 brojki, a ne " + inputField[1].length() + ".");
        }
    }

    public static void checkCreate(String[] inputField) {
        if (inputField.length != 5) {
            throw new DatabaseException("Greska! Nedostaje relacija!");
        } else if (!inputField[1].matches("^\\d+$") || !inputField[4].matches("^\\d$") || !inputField[2].matches("[a-zA-Z]+") || !inputField[3].matches("[a-zA-Z]+")) {
            throw new DatabaseException("Greska! Uneseni tip podatka netocan! (arg1 -> jmbag 8 znamenki, arg2 i arg3 -> ime i prezime string, arg4 -> ocjena 1 znamenka)");
        } else if (inputField[1].length() != 8 || inputField[4].length() != 1) {
            throw new DatabaseException("Greska! Jmbag mora sadrzavati 8 znamenki, a ocjena jednu (1-5)");
        }
    }

    public static void checkFilterGrade(String[] inputField) {
        if (inputField.length != 3) {
            throw new DatabaseException("Greska! Filter-grade naredba zahtjeva 2 argumenta (arg1 -> g/l/e tj. lower/greater/equal)");
        } else if (!inputField[1].matches("g|l|e")) {
            throw new DatabaseException("Greska! Prvi argument mora biti g/l/e");
        } else if (!inputField[2].matches("^\\d$")) {
            throw new DatabaseException("Greska! Drugi argument mora biti ocjena od 1-5.");
        }
    }

    public static boolean checkFilterName(String[] inputField) {
        boolean casing = false;
        if (inputField.length != 3 && inputField.length != 2) {
            throw new DatabaseException("Greska! Netocan broj argumenata, arg1 -> ime, arg2 -> casing (opcionalan argument).");
        } else {
            if (!inputField[1].matches("[a-zA-Z]+")) {
                throw new DatabaseException("Greska! Ime mora sadrzavati samo slova (a-z|A-Z).");
            }
            if (inputField.length == 3) {
                casing = true;
                if(!inputField[2].matches("-u|-l")) {
                    throw new DatabaseException("Greska! Drugi argument moze biti -u (uppercase) ili -l (lowercase).");
                }
            }
        }
        return casing;
    }
}
