package tw.com.phctw.service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import tw.com.phctw.bean.Student;
import tw.com.phctw.dao.StudentDao;
import tw.com.phctw.utils.IdGenerator;
import tw.com.phctw.utils.NameGenerator;

public class StudentServiceImpl implements StudentService{

	private StudentDao dao = new StudentDao();
	
	public StudentServiceImpl() {
	}
	
	public HashMap<String, Integer> generate(int num) {
		HashMap<String, Integer> result = new HashMap<String, Integer>();
	    Random random = new Random();
		NameGenerator nameGenerator = new NameGenerator();
		IdGenerator idGenerator = new IdGenerator();
		int success = 0;
		int failed = 0;
		
		for(int i = 0; i < num; i++) {
			Student s = new Student();
			s.setSno(String.format("a%02d",i+1));
			s.setsName(nameGenerator.getName());
			s.setAge(random.nextInt(100)+1);
			s.setSex(random.nextInt(2));
			s.setpId(idGenerator.getId());
			if(insertStudent(s)) {
				success++;
			}else {
				failed++;
			}
		}
		result.put("success", success);
		result.put("fialed", failed);
		return result;
	}
	
	public ArrayList<Student> selectStudent() {
		return dao.selectStudent();
	}

	public boolean insertStudent(Student student) {
		return dao.insertStudent(student);
	}

	public boolean updateStudent(Student student) {
		return dao.updateStudent(student);
	}

	public boolean deleteStudent(String sno) {
		return dao.deleteStudent(sno);
	}
	
	public boolean deleteAll() {
		return dao.deleteAll();
	}
}
