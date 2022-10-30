

package transferobjects;

/*
StudentDto Name: Jian Zhou
StudentDto Number: 040954761
Course & Section #: 22F_CST8288_023 
Declaration:
This is my own original work and is free from Plagiarism.
*/
/**
 * @author Jian Zhou (zhou0124@algonquinlive.com)
 */
public class StudentDto {
    private int studentID;
    private String lastName;
    private String firstName;
    private String email;
    private String phoneNumber;

    public StudentDto() {
    }
    
    public int getStudentID() {
        return studentID;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    
    

}
