package asupekar_hw5;
/**
 * @author Aishwarya
 * @version 1.0
 */

/**
 * Immutable Data Class for video objects. Comprises a triple: title, year,
 * director.
 *
 * <p>
 * <b>Class Type:</b> Immutable Data Class
 * </p>
 * <p>
 * <b>Object Invariant:</b>
 * </p>
 * Title is non-null, no leading or final spaces, not empty string.
 * <p>
 * <b>Object Invariant:</b>
 * </p>
 * Year is greater than 1800, less than 5000.
 * <p>
 * <b>Object Invariant:</b>
 * </p>
 * Director is non-null, no leading or final spaces, not empty string.
 */
final class VideoObj implements Comparable<VideoObj> {

	/**
	 * <p>
	 * <b>Invariant:</b> non-null, no leading or final spaces, not empty string
	 * </p>
	 */
	private final String title;

	/**
	 * <p>
	 * <b>Invariant:</b> greater than 1800, less than 5000
	 * </p>
	 */
	private final int year;

	/**
	 * <p>
	 * <b>Invariant:</b> non-null, no leading or final spaces, not empty string
	 * </p>
	 */
	private final String director;

	/**
	 * Initialize all object attributes. Title and director are "trimmed" to remove
	 * leading and final space.
	 * 
	 * @throws IllegalArgumentException if any object invariant is violated.
	 */
	public VideoObj(String title, int year, String director) throws IllegalArgumentException {
		if (title == null || title.trim().length() == 0 || year < 1801 || year > 4999 || director == null
				|| director.trim().length() == 0) {
			throw new IllegalArgumentException();
		}

		this.year = year;
		this.director = director.trim();
		this.title = title.trim();
	}

	/**
	 * Return the value of the attribute.
	 */
	public String director() {

		return this.director;
	}

	/**
	 * Return the value of the attribute.
	 */
	public String title() {
		return this.title;
	}

	/**
	 * Return the value of the attribute.
	 */
	public int year() {

		return this.year;
	}

	/**
	 * Compare the attributes of this object with those of thatObject.
	 * 
	 * @param thatObject the Object to be compared.
	 * @return deep equality test between this and thatObject.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VideoObj other = (VideoObj) obj;
		if (director == null) {
			if (other.director != null)
				return false;
		} else if (!director.equals(other.director))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (year != other.year)
			return false;
		return true;
	}

	/**
	 * Return a hash code value for this object using the algorithm from Bloch:
	 * fields are added in the following order: title, year, director.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((director == null) ? 0 : director.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + year;
		return result;
	}

	/**
	 * Compares the attributes of this object with those of thatObject, in the
	 * following order: title, year, director.
	 * 
	 * @param that the VideoObj to be compared.
	 * @return a negative integer, zero, or a positive integer as this object is
	 *         less than, equal to, or greater than that object.
	 */
	@Override
	public int compareTo(VideoObj thatObject) {
		VideoObj video = (VideoObj) thatObject;
		if ((this.title.compareTo(video.title) < 0)) {
			return 1;
		} else if (this.title.compareTo(video.title) > 0) {
			return -1;
		}
		int compareYear = Integer.compare(this.year, video.year);
		if (compareYear == 0) {
			return (this.director.compareTo(video.director));
		}
		return compareYear;
	}

	/**
	 * Return a string representation of the object in the following format:
	 * <code>"title (year) : director"</code>.
	 */
	@Override
	public String toString() {
		StringBuilder sBuilder = new StringBuilder();
		sBuilder.append(title);
		sBuilder.append(" (" + year + ") : ");
		sBuilder.append(director);
		return sBuilder.toString();
	}

}