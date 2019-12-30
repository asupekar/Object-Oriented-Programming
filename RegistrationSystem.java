package asupekar_hw4.system;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import asupekar_hw4.enums.Building;
import asupekar_hw4.enums.FacultyType;
import asupekar_hw4.enums.PersonStatus;
import asupekar_hw4.enums.Quarter;
import asupekar_hw4.enums.StudentProgram;
import asupekar_hw4.enums.StudentType;
import asupekar_hw4.enums.StudentYear;
import asupekar_hw4.enums.SubjectCode;
import asupekar_hw4.exception.CourseNotFoundException;
import asupekar_hw4.exception.DuplicateCourseException;
import asupekar_hw4.exception.DuplicatePersonException;
import asupekar_hw4.exception.DuplicateSectionException;
import asupekar_hw4.exception.DuplicateSubjectException;
import asupekar_hw4.exception.PersonNotFoundException;
import asupekar_hw4.person.Faculty;
import asupekar_hw4.person.PersonUtils;
import asupekar_hw4.person.Student;
import asupekar_hw4.registration.Course;
import asupekar_hw4.registration.Section;

/**
 * <p>
 * The <strong>RegistrationSystem</strong> class stores information about the
 * school, including the ability to add students, add faculty, add courses, and
 * add prerequisite(s).
 * </p>
 * 
 * @author Aishwarya
 */
public class RegistrationSystem {

	private Set<Student> students;
	private Set<Faculty> faculty;
	private Map<SubjectCode, String> subjects;
	private List<Course> courses;
	private Set<Section> sections;

	/**
	 * 
	 */
	public RegistrationSystem() {

		students = new HashSet<>();
		faculty = new HashSet<>();
		subjects = new HashMap<>();
		courses = new ArrayList<>();
		sections = new HashSet<>();
	}

	/**
	 * Add a student to the student list collection.
	 * 
	 * @param firstName The first name of the student
	 * @param lastName  The last name of the student
	 * @param type      The student type
	 * @param program   The student program
	 * @param quarter   The start quarter of the student
	 * @param year      The start year of the student
	 * @throws DuplicatePersonException The person is already in the system
	 */
	public void addStudent(String firstName, String lastName, StudentType type, StudentProgram program, Quarter quarter,
			int year) throws DuplicatePersonException {

		int suid = PersonUtils.getNextSuid();
		String email = PersonUtils.generateEmailAddress(firstName, lastName);

		int yearDiff = 0;
		StudentYear studentYear = null;
		if (type == StudentType.UNDERGRAD) {
			yearDiff = PersonUtils.getYearDifference(year);
			studentYear = StudentYear.values()[yearDiff];
		}

		Student student = new Student(firstName, lastName, suid, PersonStatus.ACTIVE, type, program, studentYear,
				quarter, year, null, email);

		if (students.contains(student)) {
			throw new DuplicatePersonException();
		}

		students.add(student);
	}

	/**
	 * Add a faculty to the faculty list collection.
	 * 
	 * @param firstName The first name of the faculty
	 * @param lastName  The last name of the faculty
	 * @param type      The faculty type
	 * @param bldg      The building of the faculty office
	 * @param room      The (building) room of the faculty office
	 * @param email     The email of the faculty
	 * @throws DuplicatePersonException The person is already in the system
	 */
	public void addFaculty(String firstName, String lastName, FacultyType type, Building bldg, int room, String email)
			throws DuplicatePersonException {
		int suid = PersonUtils.getNextSuid();

		Faculty faculty = new Faculty(firstName, lastName, suid, PersonStatus.ACTIVE, type, bldg, room, email);

		if (this.faculty.contains(faculty)) {
			throw new DuplicatePersonException();
		}

		this.faculty.add(faculty);
	}

	/**
	 * Adds a subject to the subject list collection. (hint: use a Map instead of
	 * creating a class)
	 * 
	 * @param code The subject code
	 * @param desc The subject description
	 * 
	 * @throws DuplicateSubjectException The subject is already in the system
	 */
	public void addSubject(SubjectCode code, String desc) throws DuplicateSubjectException {

		if (subjects.containsKey(code)) {
			throw new DuplicateSubjectException();
		}

		subjects.put(code, desc);
	}

	/**
	 * Adds a course to the course list collection.
	 * 
	 * @param code      The subject code of the course
	 * @param num       The course number of the course
	 * @param name      The course name
	 * @param creditNum The number of the credits of the course
	 * @throws DuplicateCourseException The course is already in the system
	 */
	public void addCourse(SubjectCode code, int num, String name, int creditNum) throws DuplicateCourseException {

		Course course = new Course(code, num, name, creditNum);

		if (courses.contains(course)) {
			throw new DuplicateCourseException();
		}
		courses.add(course);
	}

	/**
	 * Adds a prerequisite to an existing course in the course list collection.
	 * 
	 * @param code       The subject code of the course
	 * @param num        The course number of the course
	 * @param prereqCode The subject code of the prerequisite to add to the course
	 * @param prereqNum  The course number of the prerequisite to add to the course
	 * @throws CourseNotFoundException The course was not found in the system
	 */
	public void addPrerequisite(SubjectCode code, int num, SubjectCode prereqCode, int prereqNum)
			throws CourseNotFoundException {

		Course existingCourse = getCourse(code, num);
		if (existingCourse == null) {
			throw new CourseNotFoundException();
		}

		Course prereqCourse = getCourse(prereqCode, prereqNum);
		if (prereqCourse == null) {
			throw new CourseNotFoundException();
		}

		existingCourse.addPrerequisite(prereqCourse);
	}

	public Set<Student> getStudents() {
		return students;
	}

	public Set<Faculty> getFaculty() {
		return faculty;
	}

	public Map<SubjectCode, String> getSubjects() {
		return subjects;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public Set<Section> getSections() {
		return sections;
	}

	/**
	 * Adds a section to the section list collection.
	 * 
	 * @param code       The subject code of the course
	 * @param courseNum  The course number of the course
	 * @param sectionNum The section number for the course
	 * @param firstName  The first name for the faculty teaching the course
	 * @param lastName   The last name for the faculty teaching the course
	 * @param quarter    The quarter that the course section is held
	 * @param year       The year that the course section is held
	 * @param cap        The capacity of the course section
	 * @param bldg       The building that the course section is held
	 * @param room       The room that the course section is held
	 * @throws CourseNotFoundException   The course was not found in the system
	 * @throws PersonNotFoundException   The person was not found in the system
	 * @throws DuplicateSectionException The section is already in the system
	 */
	public void addSection(SubjectCode code, int courseNum, int sectionNum, String firstName, String lastName,
			Quarter quarter, int year, int cap, Building bldg, int room)
			throws CourseNotFoundException, PersonNotFoundException, DuplicateSectionException {
		Course course = getCourse(code, courseNum);
		if (course == null) {
			throw new CourseNotFoundException();
		}
		Faculty faculty = new Faculty(firstName, lastName);

		if (!this.faculty.contains(faculty)) {
			throw new PersonNotFoundException();
		}

		Section section = new Section(course, sectionNum, faculty, quarter, year, cap, bldg, room);

		if (sections.contains(section)) {
			throw new DuplicateSectionException();
		}

		sections.add(section);
	}

	private Course getCourse(SubjectCode code, int num) {
		for (Course c : courses) {
			if (c.equals(new Course(code, num))) {
				return c;
			}
		}

		return null;
	}
}
