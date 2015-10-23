package indexer.debug;

import java.util.Arrays;

/**
 * Handy Debug Class
 * 
 * Used for commonly used debugging methods
 * 
 * @todo Support all the things (arrays, objects, etc, etc..)
 * @author Kris Nova <kris-nova@github.com>
 *
 */
public class Debug {

	/**
	 * Will pipe an array to STDOUT in a friendly manner
	 * 
	 * @param message
	 */
	static public void out(String[] message) {
		System.out.println(Arrays.toString(message));
	}

}
