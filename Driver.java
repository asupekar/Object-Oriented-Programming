package asupekar_hw4.driver;

import java.util.Collection;
import java.util.Map;

import asupekar_hw4.enums.Building;
import asupekar_hw4.enums.FacultyType;
import asupekar_hw4.enums.Quarter;
import asupekar_hw4.enums.StudentProgram;
import asupekar_hw4.enums.StudentType;
import asupekar_hw4.enums.SubjectCode;
import asupekar_hw4.exception.CourseNotFoundException;
import asupekar_hw4.exception.DuplicateCourseException;
import asupekar_hw4.exception.DuplicatePersonException;
import asupekar_hw4.exception.DuplicateSectionException;
import asupekar_hw4.exception.DuplicateSubjectException;
import asupekar_hw4.exception.PersonNotFoundException;
import asupekar_hw4.exception.SectionNotFoundException;
import asupekar_hw4.system.RegistrationSystem;

/**
 * <p>
 * The <strong>Driver</strong> interfaces with the registration system and
 * populates faculty, students, subjects, courses, their prerequisites, and
 * course sections.
 * </p>
 * 
 * @author Aishwarya
 */
public class Driver {

	public static void main(String[] args) {
		RegistrationSystem system = new RegistrationSystem();
		populateSystem(system);

		// Print the results of the RegistrationSystem collections
		// this includes all the contents of: faculty, students, subjects,
		// courses (and their prerequisites), and course section; additional
		// functions may be added to the System to complete this task
		printSystem(system);
	}

	private static void populateSystem(RegistrationSystem system) {
		try {
			populateFaculty(system);
			populateStudents(system);
			populateSubjects(system);
			populateCourses(system);
			populatePrerequisites(system);
			populateSections(system);
		} catch (DuplicatePersonException e) {
			System.out.println(e.getMessage());
		} catch (DuplicateSubjectException e) {
			System.out.println(e.getMessage());
		} catch (DuplicateCourseException e) {
			System.out.println(e.getMessage());
		} catch (CourseNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (PersonNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (DuplicateSectionException e) {
			System.out.println(e.getMessage());
		} catch (SectionNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void populateStudents(RegistrationSystem system) throws DuplicatePersonException {
		system.addStudent("Michael", "Bluth", StudentType.UNDERGRAD, StudentProgram.BSCS, Quarter.FQ, 2018);
		system.addStudent("Gob", "Bluth", StudentType.UNDERGRAD, StudentProgram.BACS, Quarter.SQ, 2018);
		system.addStudent("Buster", "Bluth", StudentType.UNDERGRAD, StudentProgram.BSCS, Quarter.WQ, 2018);
		system.addStudent("Lucille", "Bluth", StudentType.UNDERGRAD, StudentProgram.BSCS, Quarter.WQ, 2017);
		system.addStudent("Lindsay", "Funke", StudentType.UNDERGRAD, StudentProgram.BACS, Quarter.FQ, 2018);
		system.addStudent("Tobias", "Funke", StudentType.UNDERGRAD, StudentProgram.BACS, Quarter.FQ, 2017);
		system.addStudent("Maeby", "Funke", StudentType.UNDERGRAD, StudentProgram.BSCS, Quarter.SQ, 2017);
		system.addStudent("Kitty", "Sanchez", StudentType.UNDERGRAD, StudentProgram.UNDECIDED, Quarter.FQ, 2018);
		system.addStudent("Edsger", "Dijkstra", StudentType.GRAD, StudentProgram.CERT, Quarter.RQ, 2018);
		system.addStudent("Ada", "Lovelace", StudentType.GRAD, StudentProgram.CERT, Quarter.FQ, 2018);
		system.addStudent("Grace", "Hopper", StudentType.GRAD, StudentProgram.MSCS, Quarter.WQ, 2017);
		system.addStudent("Marie", "Curie", StudentType.GRAD, StudentProgram.CERT, Quarter.FQ, 2017);
		system.addStudent("Alan", "Turing", StudentType.GRAD, StudentProgram.CERT, Quarter.RQ, 2017);
		system.addStudent("Katherine", "Johnson", StudentType.GRAD, StudentProgram.MSCS, Quarter.FQ, 2018);
	}

	private static void populateFaculty(RegistrationSystem system) throws DuplicatePersonException {
		system.addFaculty("Adair", "Dingle", FacultyType.PROF, Building.ENGR, 531, "dingle@seattleu.edu");
		system.addFaculty("Steven", "Hanks", FacultyType.LECTURE, Building.ENGR, 511, "hankssteven@seattleu.edu");
		system.addFaculty("Pejman", "Khadivi", FacultyType.ASSTPROF, Building.ENGR, 521, "khadivip@seattleu.edu");
		system.addFaculty("Michael", "Koenig", FacultyType.LECTURE, Building.ENGR, 520, "koenigm@seattleu.edu");
		system.addFaculty("Eric", "Larson", FacultyType.PROF, Building.ENGR, 528, "elarson@seattleu.edu");
		system.addFaculty("Richard", "LeBlanc", FacultyType.PROF, Building.ENGR, 527, "leblanc@seattleu.edu");
		system.addFaculty("Lin", "Li", FacultyType.ASSTPROF, Building.ENGR, 529, "lil@seattleu.edu");
		system.addFaculty("David", "Lillethun", FacultyType.ASSTPROF, Building.ENGR, 506, "lillethd@seattleu.edu");
		system.addFaculty("Kevin", "Lundeen", FacultyType.INSTRUCT, Building.ENGR, 519, "lundeenk@seattleu.edu");
		system.addFaculty("Michael", "McKee", FacultyType.LECTURE, Building.ENGR, 519, "mckeem@seattleu.edu");
		system.addFaculty("Aditya", "Mishra", FacultyType.ASSTPROF, Building.ENGR, 507, "mishraa@seattleu.edu");
		system.addFaculty("James", "Obare", FacultyType.INSTRUCT, Building.ENGR, 502, "obarej@seattleu.edu");
		system.addFaculty("Sheila", "Oh", FacultyType.SEN_INSTRUCT, Building.ENGR, 504, "ohsh@seattleu.edu");
		system.addFaculty("Susan", "Reeder", FacultyType.SEN_INSTRUCT, Building.ENGR, 505, "sreeder@seattleu.edu");
		system.addFaculty("Roshanak", "Roshandel", FacultyType.ASSOCPROF, Building.ENGR, 508, "roshanak@seattleu.edu");
		system.addFaculty("Jason", "Wong", FacultyType.INSTRUCT, Building.ENGR, 526, "wongja@seattleu.edu");
		system.addFaculty("Yingwu", "Zhu", FacultyType.ASSOCPROF, Building.ENGR, 530, "zhuy@seattleu.edu");
	}

	private static void populateSubjects(RegistrationSystem system) throws DuplicateSubjectException {
		system.addSubject(SubjectCode.BIOL, "Biology");
		system.addSubject(SubjectCode.CHEM, "Chemistry");
		system.addSubject(SubjectCode.CPSC, "Computer Science");
		system.addSubject(SubjectCode.MATH, "Mathematics");
	}

	private static void populateCourses(RegistrationSystem system) throws DuplicateCourseException {
		system.addCourse(SubjectCode.CPSC, 1420, "Programming and Problem Solving I", 5);
		system.addCourse(SubjectCode.CPSC, 1430, "Programming and Problem Solving II", 5);
		system.addCourse(SubjectCode.CPSC, 2430, "Data Structures", 5);
		system.addCourse(SubjectCode.CPSC, 2500, "Computer Organization", 5);
		system.addCourse(SubjectCode.CPSC, 2600, "Foundations of Computer Science", 5);
		system.addCourse(SubjectCode.CPSC, 3200, "Object-Oriented Development", 5);
		system.addCourse(SubjectCode.CPSC, 3300, "Fundamentals of Databases", 5);
		system.addCourse(SubjectCode.CPSC, 3400, "Languages and Computation", 5);
		system.addCourse(SubjectCode.CPSC, 3500, "Computing Systems", 5);
		system.addCourse(SubjectCode.CPSC, 4100, "Design and Analysis of Algorithms", 5);
		system.addCourse(SubjectCode.CPSC, 5001, "Programming Boot Camp I", 3);
		system.addCourse(SubjectCode.CPSC, 5002, "Programming Boot Camp II", 3);
		system.addCourse(SubjectCode.CPSC, 5003, "Programming Boot Camp III", 3);
		system.addCourse(SubjectCode.CPSC, 5011, "Object-Oriented Concepts", 3);
		system.addCourse(SubjectCode.CPSC, 5021, "Database Systems", 3);
		system.addCourse(SubjectCode.CPSC, 5031, "Data Structures and Algorithms", 3);
		system.addCourse(SubjectCode.CPSC, 5041, "Computing Systems Principles I", 3);
		system.addCourse(SubjectCode.CPSC, 5042, "Computing Systems Principles II", 3);
		system.addCourse(SubjectCode.CPSC, 5051, "Fundamentals of Software Engineering", 3);
		system.addCourse(SubjectCode.CPSC, 5200, "Software Architecture and Design", 5);
		system.addCourse(SubjectCode.CPSC, 5800, "Ethics and Professional Issues in Computing", 2);
		system.addCourse(SubjectCode.CPSC, 5600, "Parallel Computing", 5);
		system.addCourse(SubjectCode.CPSC, 5610, "Artificial Intelligence", 5);
		system.addCourse(SubjectCode.CPSC, 5510, "Computer Networks", 5);
		system.addCourse(SubjectCode.CPSC, 5520, "Distributed Systems", 5);
		system.addCourse(SubjectCode.CPSC, 5240, "Software as a Service", 5);
		system.addCourse(SubjectCode.CPSC, 5250, "Mobile Software Development", 5);
		system.addCourse(SubjectCode.CPSC, 5300, "Physical Database Design & Optimization", 5);
		system.addCourse(SubjectCode.CPSC, 5400, "Complier Principles and Techniques", 5);
		system.addCourse(SubjectCode.CPSC, 5700, "Computer Graphics", 5);
	}

	private static void populatePrerequisites(RegistrationSystem system) throws CourseNotFoundException {
		system.addPrerequisite(SubjectCode.CPSC, 1430, SubjectCode.CPSC, 1420);
		system.addPrerequisite(SubjectCode.CPSC, 2430, SubjectCode.CPSC, 1430);
		system.addPrerequisite(SubjectCode.CPSC, 2500, SubjectCode.CPSC, 1430);
		system.addPrerequisite(SubjectCode.CPSC, 2600, SubjectCode.CPSC, 1430);
		system.addPrerequisite(SubjectCode.CPSC, 3200, SubjectCode.CPSC, 2430);
		system.addPrerequisite(SubjectCode.CPSC, 3300, SubjectCode.CPSC, 2430);
		system.addPrerequisite(SubjectCode.CPSC, 3400, SubjectCode.CPSC, 2430);
		system.addPrerequisite(SubjectCode.CPSC, 3400, SubjectCode.CPSC, 2600);
		system.addPrerequisite(SubjectCode.CPSC, 3500, SubjectCode.CPSC, 2430);
		system.addPrerequisite(SubjectCode.CPSC, 3500, SubjectCode.CPSC, 2500);
		system.addPrerequisite(SubjectCode.CPSC, 4100, SubjectCode.CPSC, 2430);
		system.addPrerequisite(SubjectCode.CPSC, 4100, SubjectCode.CPSC, 2600);
		system.addPrerequisite(SubjectCode.CPSC, 5002, SubjectCode.CPSC, 5001);
		system.addPrerequisite(SubjectCode.CPSC, 5003, SubjectCode.CPSC, 5002);
		system.addPrerequisite(SubjectCode.CPSC, 5011, SubjectCode.CPSC, 5003);
		system.addPrerequisite(SubjectCode.CPSC, 5021, SubjectCode.CPSC, 5003);
		system.addPrerequisite(SubjectCode.CPSC, 5042, SubjectCode.CPSC, 5041);
		system.addPrerequisite(SubjectCode.CPSC, 5200, SubjectCode.CPSC, 5011);
		system.addPrerequisite(SubjectCode.CPSC, 5200, SubjectCode.CPSC, 5051);
		system.addPrerequisite(SubjectCode.CPSC, 5600, SubjectCode.CPSC, 5031);
		system.addPrerequisite(SubjectCode.CPSC, 5600, SubjectCode.CPSC, 5042);
		system.addPrerequisite(SubjectCode.CPSC, 5610, SubjectCode.CPSC, 5031);
		system.addPrerequisite(SubjectCode.CPSC, 5510, SubjectCode.CPSC, 5042);
		system.addPrerequisite(SubjectCode.CPSC, 5520, SubjectCode.CPSC, 5042);
		system.addPrerequisite(SubjectCode.CPSC, 5240, SubjectCode.CPSC, 5042);
		system.addPrerequisite(SubjectCode.CPSC, 5250, SubjectCode.CPSC, 5011);
		system.addPrerequisite(SubjectCode.CPSC, 5300, SubjectCode.CPSC, 5021);
		system.addPrerequisite(SubjectCode.CPSC, 5700, SubjectCode.CPSC, 5031);
	}

	private static void populateSections(RegistrationSystem system) throws CourseNotFoundException,
			PersonNotFoundException, DuplicateSectionException, SectionNotFoundException {
		system.addSection(SubjectCode.CPSC, 2430, 1, "Susan", "Reeder", Quarter.FQ, 2018, 15, Building.PIGT, 207);
		system.addSection(SubjectCode.CPSC, 2430, 2, "Adair", "Dingle", Quarter.FQ, 2018, 30, Building.PIGT, 207);
		system.addSection(SubjectCode.CPSC, 2600, 1, "Sheila", "Oh", Quarter.FQ, 2018, 30, Building.LEML, 122);
		system.addSection(SubjectCode.CPSC, 4100, 1, "Yingwu", "Zhu", Quarter.FQ, 2018, 34, Building.PIGT, 102);
		system.addSection(SubjectCode.CPSC, 5011, 1, "Steven", "Hanks", Quarter.FQ, 2018, 20, Building.ADMN, 203);
		system.addSection(SubjectCode.CPSC, 5011, 2, "Sheila", "Oh", Quarter.FQ, 2018, 30, Building.LEML, 122);
		system.addSection(SubjectCode.CPSC, 5021, 1, "Michael", "McKee", Quarter.FQ, 2018, 36, Building.BANN, 401);
		system.addSection(SubjectCode.CPSC, 5021, 2, "Michael", "McKee", Quarter.FQ, 2018, 30, Building.LEML, 122);
		system.addSection(SubjectCode.CPSC, 5510, 1, "David", "Lillethun", Quarter.FQ, 2018, 30, Building.ENGR, 304);
		system.addSection(SubjectCode.CPSC, 5600, 2, "Kevin", "Lundeen", Quarter.FQ, 2018, 20, Building.BANN, 402);
	}

	private static void printSystem(RegistrationSystem system) {
		System.out.println("-- FACULTY LIST --");
		printHelper(system.getFaculty());
		System.out.println("\n\n-- STUDENT LIST --");
		printHelper(system.getStudents());
		System.out.println("\n\n-- SUBJECT LIST --");
		printSubjects(system.getSubjects()); 
		System.out.println("\n\n-- COURSE LIST --");
		printHelper(system.getCourses());
		System.out.println("\n\n-- SECTION LIST --");
		printHelper(system.getSections());
		
		/**
		 * printCourses(system); printPrerequisites(system);
		 * printSections(system);
		 **/
	}

	private static void printHelper(Collection<? extends Object> set) {
		for (Object o : set) {
			System.out.println(o);
		}
	}
	
	private static void printSubjects(Map<SubjectCode, String> subjects) {
		for(SubjectCode code: subjects.keySet()) {
			System.out.println("Subject: " + subjects.get(code) + " (" + code + ")");
		}
	}

}
