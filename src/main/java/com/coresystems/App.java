package com.coresystems;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.coresystems.models.Module;
import com.coresystems.models.Student;

/**
 * Hello world!
 *
 */
public class App {

	public static final EntityManagerFactory emFactory;
	static {
		emFactory = Persistence.createEntityManagerFactory("com.coresystems_JPATutorial_jar_1.0-SNAPSHOTPU");
	}

	private static EntityManager manager = null;

	// TODO: add the student to database
	public static void addStudent(String firstName, String lastName) {
		EntityTransaction tx = null;
		try {
			manager = emFactory.createEntityManager();
			tx = manager.getTransaction();
			tx.begin();
			Student student = new Student(firstName, lastName);
			manager.persist(student);
			manager.flush();
			tx.commit();
		} catch (Exception e) {
			if (tx.isActive()) {
				tx.rollback();
			}
		} finally {
			manager.close();
			emFactory.close();
		}
	}

	// TODO: assign a module to student, one student can have multiple modules
	public static void registerModule(Integer studentId, String moduleName) {
		EntityTransaction tx = null;

		try {
			manager = emFactory.createEntityManager();
			tx = manager.getTransaction();
			List<Module> modules = new ArrayList<>();
			tx.begin();
			Student student = manager.find(Student.class, studentId);
			Module module = new Module(moduleName);
			modules.add(module);
//			student.addModule(module);
			student.setModules(modules);
			manager.persist(student);
			manager.persist(module);
			manager.flush();
			tx.commit();

		} catch (Exception e) {
			if (tx.isActive()) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			manager.close();
			emFactory.close();
		}
	}

	// TODO: get all students
	public static void listStudents() {
		try {
			manager = emFactory.createEntityManager();
			List<Student> students = manager.createNativeQuery("SELECT s FROM Student s", Student.class)
					.getResultList();
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

	public static void main(String[] args) {
		System.out.println("Hello World!");
//        listStudents();
	}
}
