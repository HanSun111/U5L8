public class Employee {
    private static int id;
    private int finalId;
    private String firstName;
    private String lastName;
    private static int numOfEmployee;

    public Employee(String first, String last){
        firstName = first;
        lastName = last;
        numOfEmployee ++;
        finalId = 100 + numOfEmployee;
        id = finalId;
    }

    public int getNumOfEmployee() {
        return numOfEmployee;
    }

    public int getId() {
        return finalId;
    }

    public int getFinalId() {
        return id;
    }

    public String fullName(){
        return firstName + ", " + lastName;
    }
}