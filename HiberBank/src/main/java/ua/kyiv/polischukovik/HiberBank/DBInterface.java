package ua.kyiv.polischukovik.HiberBank;

import java.util.List;

public interface DBInterface {
	public void writeObject(Object o);
	public void deleteObject(int id);
	public <T> T findObjectById(int id, Class<T> clazz);
	public <T> List<T> findObjectsByName(String namePart, String string, Class<T> class1);
	
}
