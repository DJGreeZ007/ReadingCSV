/**
 * Enumeration with two genders <b>MALE</b> и <b>FEMALE</b>.
 */
enum Gender {
    MALE,
    FEMALE
}
/**
 * Human class with properties <b>ID</b>, <b>name</b>, <b>gender</b>,
 * <b>birtDate</b>, <b>salary</b>, <b>department</b>.
 * @version 1.1
 */
public class Human {
    /** ID field */
    private int ID;
    /** name field */
    private String name;
    /** gender field */
    private Gender gender;
    /** birtDate field */
    private String birtDate;
    /** salary field */
    private int salary;
    /** department field {@link Department}*/
    private Department department;
    /**
     * Constructor - creating a new object
     * @param ID - human ID
     * @param name - human name
     * @param gender - human gender
     * @param birtDate - human birtDate
     * @param salary - human salary
     * @param department - human department
     */
    Human (int ID, String name, Gender gender, String birtDate, int salary, Department department) {
        this.ID = ID;
        this.name = name;
        this.birtDate = birtDate;
        this.salary = salary;
        this.department = department;
    }
}