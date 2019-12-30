package asupekar_ice4;

public class Problem1 implements NonNegativeIntegers, Comparable {

	private int v;

	public Problem1() {
		v = 0;

	}

	@Override
	public boolean equals(Object that) {
		if (this == that) {
			return true;
		}
		if (!(that instanceof Problem1)) {
			return false;
		}
		Problem1 prob = (Problem1) that;
		if (this.v == prob.v) {
			return true;
		}

		return false;
	}

	@Override
	public void set(int v) throws IllegalArgumentException {
		if (v >= 0) {
			this.v = v;
		} else {
			throw new IllegalArgumentException();
		}

	}

	@Override
	public int get() {
		return v;
	}

	@Override
	public int compareTo(Object o) throws IllegalArgumentException {

		if (o == null) {
			throw new IllegalArgumentException();
		}
		Problem1 prob = (Problem1) o;
		return Integer.compare(this.v, prob.v);

	}

}
