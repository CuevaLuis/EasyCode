package dev.luiscueva.files;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class BinaryFile {

	// PROBADO
	public static final <T extends Serializable> boolean writeObject(File file, T object) {

		try {
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos;

			oos = new ObjectOutputStream(fos);
			oos.writeObject(object);
			oos.flush();
			oos.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	// PROBADO
	public static final <T extends Serializable> T readObject(File file) {

		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));

			@SuppressWarnings("unchecked")
			T obj = (T) ois.readObject();
			ois.close();
			return obj;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// PROBADO
	@SuppressWarnings("resource")
	public static final <T extends Serializable> boolean writeObjects(File file, ArrayList<T> objects) {

		try {
			if (objects.size() == 0)
				return false;
			if (!file.exists())
				file.createNewFile();

			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			oos.writeObject(objects.get(0));
			if (objects.size() > 1) {
				fos = new FileOutputStream(file, true);
				oos = new NoHeaderOOS(fos);
			} else {
				fos.flush();
				fos.close();
				oos.close();
				return true;
			}

			for (int i = 1; i < objects.size(); i++) {
				oos.writeObject(objects.get(i));
			}

			fos.flush();
			fos.close();
			oos.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	// PROBADO
	@SuppressWarnings("unchecked")
	public static final <T extends Serializable> ArrayList<T> readObjects(File file) {

		ArrayList<T> ret = new ArrayList<T>();

		try {
			FileInputStream fis = new FileInputStream(file);
			try (ObjectInputStream ois = new ObjectInputStream(fis)) {

				T aux;

				while (true) {
					aux = (T) ois.readObject();
					ret.add(aux);
				}
			}
		} catch (IOException | ClassNotFoundException e) {
			return ret;
		}
	}

	// PROBADO
	public static final <T extends Serializable> boolean addObjectToFile(File file, T object) {

		try {
			FileOutputStream fos = new FileOutputStream(file, true);
			ObjectOutputStream oos;

			oos = new NoHeaderOOS(fos);
			oos.writeObject(object);
			oos.flush();
			oos.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	// PROBADO
	public static final <T extends Serializable> boolean removeObjectFromFile(File file, T object) {
		ArrayList<T> objs = readObjects(file);
		boolean next = true;
		while(next) {
			next = objs.remove(object);	
		}				
		return writeObjects(file, objs);
	}
}
