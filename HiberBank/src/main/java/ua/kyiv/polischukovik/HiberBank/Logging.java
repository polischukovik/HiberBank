package ua.kyiv.polischukovik.HiberBank;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Logging {
	static Logger log = null;
	
	private Logging(){
	}
	
	public static void initialize(){
		log = LogManager.getLogger(Logging.class);
	}
	
	public static Logger getInstance(){
		return log;
	}
}
