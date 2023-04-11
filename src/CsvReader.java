import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import javafx.util.Pair;

/**
 * A class for parsing data from a CSV file
 * @version 1.0
 */
public class CsvReader {
    /**
     * The method searches for a department with the name elem in the list
     * @param departments - list of departments
     * @param elem - name of the department we want to find
     * @return reference to the department, otherwise null
     */
    private static Department findDepartmentInList(ArrayList<Department> departments, Character elem) {
        Department result = null;
        for (Department dep : departments) {
            if (dep.getName() == elem) {
                result = dep;
                break;
            }
        }
        return result;
    }
    /**
     * The method splits the string into words separated by ;
     * @param line - string
     * @return list of words
     */
    private static String[] parsing(String line) {
        // word Separator
        String splitBy = ";";
        return line.split(splitBy);
    }
    /**
     * The main method of file parsing
     * @param fileName - file name
     * @return returns an object of type Pair, the first object is a list of departments, the second is a list of people
     */
    public static Pair<ArrayList<Department>, ArrayList<Human>> reader(String fileName) {
        // result
        Pair<ArrayList<Department>, ArrayList<Human>> result = null;
        // list of departments
        ArrayList<Department> departments = new ArrayList<>();
        // list of people
        ArrayList<Human> humans = new ArrayList<>();
        // An object of the CSVReader class
        CSVReader reader = null;
        // open file
        try {
            String path = ".\\src\\resourse\\" + fileName;
            reader = new CSVReader(new FileReader(path));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        // read row
        String[] row;
        try {
            while((row = reader.readNext()) != null ) {
                String[] field = parsing(row[0]);
                if(field.length == 6 && !Objects.equals(field[0], "id")) {
                    //check ID
                    int ID = -1;
                    try {
                        ID = Integer.parseInt(field[0]);
                    }
                    catch (NumberFormatException e) {
                        throw new RuntimeException(e);
                    }

                    //check name
                    String name = field[1];
                    if(Objects.equals(name, "")) {
                        throw new RuntimeException("Name is empty");
                    }

                    //check gender
                    Gender gender = null;
                    if(Objects.equals(field[2], "Male")) {
                        gender = Gender.MALE;
                    }
                    else if(Objects.equals(field[2], "Female")){
                        gender = Gender.FEMALE;
                    }
                    else {
                        throw new RuntimeException("The gender is not specified correctly");
                    }

                    //check department
                    Department department= null;
                    Character nameDepartment = ' ';
                    try {
                        nameDepartment = field[4].toCharArray()[0];
                    }
                    catch (Exception e) {
                        throw new RuntimeException("The department is specified incorrectly");
                    }
                    if(Objects.equals(nameDepartment, ' ')){
                        throw new RuntimeException("The department is specified incorrectly");
                    }
                    if ((department = findDepartmentInList(departments, nameDepartment)) == null) {
                        department = new Department(nameDepartment);
                        departments.add(department);
                    }

                    //check salary
                    int salary = -1;
                    try {
                        salary = Integer.parseInt(field[5]);
                    }
                    catch (NumberFormatException e) {
                        throw new RuntimeException(e);
                    }

                    humans.add(new Human(ID, name, gender, field[3], salary, department));
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (CsvException e) {
            throw new RuntimeException(e);
        }

        //close file
        try {
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        result = new Pair<>(departments, humans);
        return result;
    }
}
