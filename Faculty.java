package asupekar_hw4.person;

import asupekar_hw4.enums.Building;
import asupekar_hw4.enums.FacultyType;
import asupekar_hw4.enums.PersonStatus;

/**
 * <p>The <strong>Faculty</strong> class holds information about a faculty member.</p>
 * <ul>
 * <li><strong>first name:</strong> first name of the faculty</li>
 * <li><strong>last name:</strong> last name of the faculty</li>
 * <li><strong>suid:</strong> SeattleU identification number</li>
 * <li><strong>status:</strong> the status of the faculty (see PersonStatus enum)</li>
 * <li><strong>faculty type:</strong> the type of faculty (see FacultyType enum)</li>
 * <li><strong>office:</strong> includes building (i.e. ENGR) and room number (i.e 504)</li>
 * <li><strong>email:</strong> the school (i.e. SU) email address</li>
 * </ul>
 * <p>For example, faculty <strong>Sheila Oh</strong></p>
 * <ul>
 * <li><strong>first name:</strong> Sheila</li>
 * <li><strong>last name:</strong> Oh</li>
 * <li><strong>suid:</strong> 100013</li>
 * <li><strong>status:</strong> ACTIVE</li>
 * <li><strong>faculty type:</strong> SEN_INSTRUCT</li>
 * <li><strong>office (building/room):</strong> ENGR 504</li>
 * <li><strong>email:</strong> ohsh@seattleu.edu</li>
 * </ul>
 * 
 * @author 
 */
public class Faculty extends Person {
	
	private FacultyType facultyType;
	private Building bldg; 
	private int room; 
	
    /**
     * 
     * @param firstName The first name of the faculty
     * @param lastName The last name of the faculty
     * @param suid The school identification number
     * @param status The status of the facility
     * @param facultyType The type of faculty
     * @param office The building and the room number
     * @param email The school email address
     */
    public Faculty(String firstName, String lastName, int suid, PersonStatus status, FacultyType facultyType, Building bldg, int room, String email) {
        super(firstName, lastName, suid, status, email);
        this.facultyType = facultyType;
        this.bldg = bldg;
		this.room = room;
    }

	public Faculty(String firstName, String lastName) {
		super(firstName, lastName);
	}

	@Override
	public String toString() {
		return "Faculty: Name="+ firstName + " " + lastName + ", SUID=" + suid + ", Email=" + email + ", Status=" + status + ", Type=" + facultyType + ", Office=" + bldg + " " + room;
	}

	public FacultyType getFacultyType() {
		return facultyType;
	}

	public Building getBldg() {
		return bldg;
	}

	public int getRoom() {
		return room;
	}	
}
