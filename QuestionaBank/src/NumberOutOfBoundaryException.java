/**
 * When this class is threw, the user is informed that the number is not in the
 * specified bounds.
 * 
 * @author wanhrust
 * 
 */
public class NumberOutOfBoundaryException extends RuntimeException {
	/**
	 * Informs the user that the number is not in the specified bounds.
	 * 
	 * @param minInt
	 * int minInt lower bound of range.
	 * @param maxInt
	 * int maxInt upper bound of range.
	 */
	NumberOutOfBoundaryException(int minInt, int maxInt) {
		System.out.println("Number should be between " + minInt + " and "
				+ maxInt);
	}

}
