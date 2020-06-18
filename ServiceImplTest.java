package tw.com.phctw.serviceTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;

import tw.com.phctw.bean.Student;
import tw.com.phctw.service.StudentServiceImpl;

class ServiceImplTest {

	public StudentServiceImpl test = new StudentServiceImpl();
	
	@Test
	void testSelect() {
		ArrayList<Student> list;
		list = test.selectStudent();
		assertTrue(list.size() == 0);
	}
	
	@Test
	void testInsert() {
		ArrayList<Student> list;
		Student s = new Student("a01", "一二三", 33, 1, "G254890657");
		test.insertStudent(s);
		list = test.selectStudent();
		printList(list);
		assertTrue(list.size() == 1);
	}
	
	@Test
	void testUpdateSuccess() {
		ArrayList<Student> list;
		list = test.selectStudent();
		list.get(0).setsName("五六七");
		list.get(0).setAge(13);
		list.get(0).setSex(0);
		list.get(0).setpId("B103545562");
		assertTrue(test.updateStudent(list.get(0)));
		list = test.selectStudent();
		assertTrue(list.get(0).getsName().equals("五六七"));
		assertTrue(list.get(0).getAge() == 13);
		assertTrue(list.get(0).getSex() == 0);
		assertTrue(list.get(0).getpId().equals("B103545562"));
		printList(list);
	}
	
	@Test
	void TestUpdateFailed() {
		Student s = new Student("a02", "八九十", 11, 0, "D222894543");
		assertFalse(test.updateStudent(s));
	}
	
	@Test
	void testDelete() {
		ArrayList<Student> list;
		test.deleteStudent("a01");
		list = test.selectStudent();
		printList(list);
		assertTrue(list.size() == 0);
	}
	
	@Test
	void testDeletes() {
		assertTrue(test.deleteAll());
	}
	
	private static void printList(ArrayList<Student> list) {
		System.out.println("Size: " + list.size());
		for(Student s : list) {
			System.out.println(s);
		}
		System.out.println();
	}
}
