package indexer.config;

import indexer.debug.Debug;
import java.util.HashMap;

/**
 * Used to interpret and hold any command line options
 * 
 * @author Kris Nova <kris-nova@github.com>
 *
 */
public class Options {

	public static final int START = 1;
	public static final int STOP = 2;
	public static final int RESTART = 3;
	public static final int RELOAD = 4;
	public static final int STATUS = 5;

	protected int mode;

	protected int command;

	static public Options instance;

	/**
	 * Will load an array of String args
	 * 
	 * @param args
	 */
	static public void loadArgs(String[] args) {
		Options.instance = new Options();
		Options.instance.parseArgs(args);
	}

	/**
	 * Will parse the args, and handle storing accordingly
	 * 
	 * @todo Need to support flags and options
	 * @param args
	 */
	protected void parseArgs(String[] args) {
		for (int i = 0; i < args.length; i++) {
			String current = args[i];
			String next = null;
			try {
				next = args[i + 1];
			} catch (ArrayIndexOutOfBoundsException ae) {

			}
			/* Flag */
			if (current.startsWith("--")) {

			}
			/* Option */
			else if (current.startsWith("-")) {

			}
			/* START */
			else if (current.equals("start")) {
				this.mode = Options.START;
			}
			/* STOP */
			else if (current.equals("stop")) {
				this.mode = Options.STOP;
			}
			/* RESTART */
			else if (current.equals("restart")) {
				this.mode = Options.RESTART;
			}
			/* RELOAD */
			else if (current.equals("reload")) {
				this.mode = Options.RELOAD;
			}
			/* STATUS */
			else if (current.equals("status")) {
				this.mode = Options.STATUS;
			}

		}
	}

	/**
	 * Will return the int value of the mode we are running in. There are final
	 * constants in this class to deduce accordingly.
	 * 
	 * @return int
	 */
	static public int getMode() {
		return Options.instance.mode;
	}
}
