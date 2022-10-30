

package businesslayer;

import dataaccesslayer.StudentDao;
import dataaccesslayer.StudentDaoImpl;
import java.util.List;
import transferobjects.StudentDto;

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
public class StudentBusinessLogic {
    private StudentDao studentDao = null;

    public StudentBusinessLogic() {
        studentDao = new StudentDaoImpl();
    }
    public List<StudentDto>  getAll (){
        return studentDao.getAll();
    }
    public void add(StudentDto dto) {
        studentDao.add(dto);
    }
    public void update(StudentDto dto) {
        studentDao.update(dto);
    }
    public void delete(StudentDto dto) {
        studentDao.delete(dto);
    }
    public StudentDto getById(int id) {
        return studentDao.getById(id);
    }
            
            
}
