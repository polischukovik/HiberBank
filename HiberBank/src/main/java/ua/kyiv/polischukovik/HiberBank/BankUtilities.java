package ua.kyiv.polischukovik.HiberBank;

import java.util.Date;
import java.util.prefs.Preferences;

public class BankUtilities {
	Preferences prefs = Preferences.userNodeForPackage(BankUtilities.class);
	
	final String PREF_NAME = "name_of_preference";
//	final String PREF_NAME = "name_of_preference";
//	final String PREF_NAME = "name_of_preference";
//	final String PREF_NAME = "name_of_preference";
//	final String PREF_NAME = "name_of_preference";
//	final String PREF_NAME = "name_of_preference";
	
	final String USER_ERROR = "name_of_preference";
	public static long dateToEpoch(Date date){
		return date.getTime();
	}
	
	public static Date epochToDate(long date){
		return new Date(date);
	}
}
