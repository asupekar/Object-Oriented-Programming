package asupekar_hw4.person;
/**
 * 
 */
import asupekar_hw4.enums.PersonStatus;
import asupekar_hw4.enums.Quarter;
import asupekar_hw4.enums.StudentProgram;
import asupekar_hw4.enums.StudentType;
import asupekar_hw4.enums.StudentYear;

/**
 * <p>The <strong>Student</strong> class holds information about a student.</p>
 * <ul>
 * <li><strong>first name:</strong> first name of the student</li>
 * <li><strong>last name:</strong> last name of the student</li>
 * <li><strong>suid:</strong> Seattle U identification number</li>
 * <li><strong>status:</strong> the status of the student (see PersonStatus enum)</li>
 * <li><strong>student type:</strong> a student can only be assigned a single student type
 *   (see StudentType enum)</li>
 * <li><strong>student program:</strong> a student can only be assigned to a single program at 
 *   a point of time, but can switch from one program to another (i.e. when 
 *   they've graduated from a program (see StudentProgram enum)</li>
 * <li><strong>student year:</strong> only relevant for undergraduates (see StudentYear enum)</li>
 * <li><strong>start term:</strong> associated with the quarter and year a student starts a
 *   particular program; for example, a single student may start the CERT in 
 *   RQ17 and then continue the MSCS in FQ18 (see Quarter enum)</li>
 * <li><strong>faculty advisor:</strong> students are assigned a faculty advisor, but may switch 
 *   advisors (i.e. faculty leaves or on sabbatical); may not be assigned an
 *   advisor for a period of time when first enrolled as a student</li>
 * <li><strong>email:</strong> the school (i.e. SU) email address</li>
 * </ul>
 * <p>For example, student <strong>Ada Lovelace</strong></p>
 * <ul>
 * <li><strong>first name:</strong> Ada</li>
 * <li><strong>last name:</strong> Lovelace</li>
 * <li><strong>suid:</strong> 100027</li>
 * <li><strong>status:</strong> ACTIVE</li>
 * <li><strong>student type:</strong> GRAD</li>
 * <li><strong>student program:</strong> CERT</li>
 * <li><strong>student year:</strong> </li>
 * <li><strong>start term:</strong> FQ 2018</li>
 * <li><strong>faculty advisor:</strong> Lin Li</li>
 * <li><strong>email:</strong> adalovelace@seattleu.edu</li>
 * </ul>
 * <p>And student <strong>Buster Bluth</strong></p>
 * <ul>
 * <li><strong>first name:</strong> Buster</li>
 * <li><strong>last name:</strong> Bluth</li>
 * <li><strong>suid:</strong> 100020</li>
 * <li><strong>status:</strong> ACTIVE</li>
 * <li><strong>student type:</strong> UNDERGRAD</li>
 * <li><strong>student program:</strong> BSCS</li>
 * <li><strong>student year:</strong> SOPHOMORE</li>
 * <li><strong>start term:</strong> WQ 2018</li>
 * <li><strong>faculty advisor:</strong> Roshanak Roshandel</li>
 * <li><strong>email:</strong> busterbluth@seattleu.edu</li>
 * </ul>
 * 
 * @author 
 */
public class Student extends Person{
	
	private StudentType studentType;
	private StudentProgram studentProgram; 
	private StudentYear studentYear; 
	private Quarter quarter;
	private int startYear;
	private Faculty advisor;
	

    /**
     * 
     * @param firstName   The first name of the student
     * @param lastName    The last name of the student
     */
    public Student(String firstName, String lastName, int suid, 
    		PersonStatus status, StudentType studentType, 
    		StudentProgram studentProgram, StudentYear studentYear, Quarter quarter, int startYear, Faculty advisor, String email) {
        
        super(firstName, lastName, suid, status, email);
        this.studentType = studentType;
        this.studentProgram = studentProgram;
        this.studentYear = studentYear;
        this.quarter = quarter;
        this.startYear = startYear;
        this.advisor = new Faculty("Richard","LeBlanc");
    }
    
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder("Student: Name="+ firstName + " " + lastName + ", SUID=" + suid + ", Email=" + email + ", Status=" + status + ", Type=" + studentType + ", Program=" + studentProgram + ", Term=" + quarter + " " + startYear + ", Advisor=" + advisor.getFirstName() + " " + advisor.getLastName());
		
		if(studentYear != null) {
			sb.append(", Year=" + studentYear);
		}
		
		return sb.toString();
	}
}
