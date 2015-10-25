package com.soundeavor.indexer.config;

import java.util.Properties;
import java.io.OutputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Static class to parse configuration values
 * 
 * @author Kris Nova <kris-nova@github.com>
 *
 */
public class Config {

	static protected Boolean init;
	static protected Properties properties;
	static protected FileInputStream file;

	/**
	 * Will attempt to get a configuration value by directive
	 * 
	 * @param key
	 * @return String value
	 */
	static public String getConfig(String key) {
		Config.init();
		return Config.properties.getProperty(key);
	}

	/**
	 * Will set up the static class
	 */
	static protected void init() {
		if (Config.init == null) {
			Config.properties = new Properties();
			try {
				Config.file = new FileInputStream("../cfg/config");
				Config.properties.load(Config.file);
			} catch (IOException io) {
				io.printStackTrace();
			} finally {
				Config.init = true;
			}
		}
	}
}
