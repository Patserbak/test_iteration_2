package Model;

/**
 * A message acting as a result to an invocation message.
 */
public class ResultMessage extends Message {
	
	/**
	 * Constructor.
	 * @param lab 		The name of the new result message's label.
	 */
	public ResultMessage(String lab) {
		super(lab);
	}

}
