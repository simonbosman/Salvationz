package com.simonbosman.salvationz.shared.exception;


/**
 * Thrown from the default clause of a switch statement to highlight unused
 * cases.
 * 
 * @author lowec
 */
public class UnhandledEnumCase extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructs a new unhandled enum case with descriptive message.
	 * 
	 * @param value
	 *            The unhandled enum value
	 */
	public UnhandledEnumCase(final Enum<?> value) {
		super("Unhandled enum case: class = " + value.getClass().getName() + ", value = " + value);
	}

}
