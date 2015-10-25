package com.soundeavor.indexer;

import com.soundeavor.indexer.config.Config;

/**
 * This is the indexer that will handle syncing data from Cassandra into
 * ElasticSearch
 * 
 * This is the main entry point for the class
 * 
 * Should parse the config file Should handle any runtime options/flags/commands
 * Should report Should log Should fork! (Thread?)
 * 
 * 
 * @author Kris Nova <kris-nova@github.com>
 *
 */
public class Indexer {

	public static int mode;

	/**
	 * Tell me something good!
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		com.soundeavor.indexer.config.Options.loadArgs(args);
		Indexer.mode = com.soundeavor.indexer.config.Options.getMode();
		switch (Indexer.mode) {
		case com.soundeavor.indexer.config.Options.START:
			Indexer.start();
			break;
		case com.soundeavor.indexer.config.Options.STOP:
			Indexer.stop();
			break;
		case com.soundeavor.indexer.config.Options.RESTART:
			Indexer.restart();
			break;
		case com.soundeavor.indexer.config.Options.RELOAD:
			Indexer.reload();
			break;
		case com.soundeavor.indexer.config.Options.STATUS:
			Indexer.status();
			break;
		}
	}

	/**
	 * Called on <start>
	 */
	protected static void start() {
		System.out.println("STARTING SERVICE");
	}

	/**
	 * Called on <stop>
	 */
	protected static void stop() {
		System.out.println("STOPPING SERVICE");
	}

	/**
	 * Called on <restart>
	 */
	protected static void restart() {
		System.out.println("RESTARTING SERVICE");
	}

	/**
	 * Called on <reload>
	 */
	protected static void reload() {
		System.out.println("RELOADING SERVICE");
	}

	/**
	 * Called on <status>
	 */
	protected static void status() {
		System.out.println("STATUS OF SERVICE");
	}
}
