
import businesslayer.*;
import java.util.List;
import transferobjects.StudentDto;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

 /*
Student Name: Jian Zhou
Student Number: 040954761
Course & Section #: 22F_CST8288_023 
Declaration:
This is my own original work and is free from Plagiarism.
 */
/**
 * @author Jian Zhou (zhou0124@algonquinlive.com)
 */
public class Launcher {

    public static void main(String[] args) {
        try {
            StudentBusinessLogic logic = new StudentBusinessLogic();
            List<StudentDto> list = null;
            StudentDto student = null;
            
            System.out.println("Get all student:");
            list = logic.getAll();
            printAll(list);
            
            System.out.println("Get by id: 9016001:");
            print(logic.getById(9016001));
            System.out.println();
                    
            System.out.println("Insert a student:");
            student = new StudentDto();
            student.setStudentID(9016010);
            student.setFirstName("Jian");
            student.setLastName("Zhou");
            student.setEmail("jianzhou@algonquin.com");
            student.setPhoneNumber("123-456-7890");
            logic.add(student);
            list = logic.getAll();
            printAll(list);
            
            System.out.println("Update phone number of student:");
            student.setPhoneNumber("987-654-3210");
            logic.update(student);
            list = logic.getAll();
            printAll(list);
            
            System.out.println("Delete student");
            logic.delete(student);
            list = logic.getAll();
            printAll(list);
            
            
        }catch(Exception ex) {
            ex.printStackTrace();
        }
        
    }
    private static void print(StudentDto student) {
        String output = String.format("%s, %15s, %15s, %25s, %s",
                student.getStudentID(),
                student.getFirstName(),
                student.getLastName(),
                student.getEmail(),
                student.getPhoneNumber());
        System.out.println(output);
        
    }
    
    private static void printAll(List<StudentDto> lists) {
        for (StudentDto student: lists ) {
            print(student);
        }
        System.out.println();
    }
}
