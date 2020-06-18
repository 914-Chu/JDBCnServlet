package tw.com.phctw.service;
import java.util.List;

import tw.com.phctw.bean.Student;

public interface StudentService {
	public List<Student> selectStudent();

	public boolean insertStudent(Student student);

	public boolean updateStudent(Student student);

	public boolean deleteStudent(String sno);
}
