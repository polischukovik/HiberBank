package ua.kyiv.polischukovik.HiberBank;

import java.util.List;

public interface DBInterface {
	public void writeObject(Object o);
	public void deleteObject(int id);
	public Object findObjectById(int id, Class<?> clazz);
	public <T> List<T> findObjectsByName(String namePart, String string, T class1);
	
}
