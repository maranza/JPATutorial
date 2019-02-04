package com.coresystems;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.coresystems.models.Module;
import com.coresystems.models.Student;

/**
 * Hello world!
 *
 */
public class App 
{
	
	public static final EntityManagerFactory emFactory;
	static {
		emFactory = Persistence.createEntityManagerFactory("com.coresystems_JPATutorial_jar_1.0-SNAPSHOTPU");
	}
	
	private static EntityManager manager = null;
	
	// TODO: add the student to database	
	public static void addStudent(String firstName, String lastName) {
		
	}
	
	// TODO: assign a module to student, one student can have multiple modules
	public static void registerModule(Integer studentId, String moduleNam) {
		
	}
	
	//TODO: get all students
	public static void listStudents() {
		try {
			manager = emFactory.createEntityManager();	
			List<Student> students = manager.createNativeQuery("SELECT s FROM Student s", Student.class).getResultList();
			for (Student student : students) {
				System.out.println("fistName: " + student.getFirstName() + "lastName: " + student.getLastName());
				System.out.println("modules: ");
				for (Module module : student.getModules()) {
					System.out.println("Module name: " + module.getName());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			manager.close();
			emFactory.close();
		}
	}
	
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
//        listStudents();
    }
}
