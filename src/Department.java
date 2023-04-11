/**
 * Department class with properties: <b>curId</b>,<b>ID</b> and <b>name</b>.
 * @version 1.0
 */
public class Department {
    /** The field of the number of the object being created */
    private static int curId = 0;
    /** Field of the object number */
    private int ID;
    /** Department name field */
    private Character name;
    /**
     * Constructor - creating a new object
     * @param name - department name
     */
    Department (Character name) {
        this.name = name;
        this.ID = curId;
        curId++;
    }
    /**
     * Method of getting the department name {@link Department#name}
     * @return department name
     */
    public Character getName() {
        return name;
    }
}
