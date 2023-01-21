package dev.luiscueva.files;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


public class BinaryFile {

	public static final boolean writeObject(File file, Serializable object) {

		try {
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos;

			oos = new ObjectOutputStream(fos);
			oos.writeObject(object);
			oos.flush();
			oos.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static final <T extends Serializable> T readObject(File file, Class<T> clase) {

		try {			
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));

			@SuppressWarnings("unchecked")
			T obj = (T) ois.readObject();
			ois.close();
			return obj;			
		} catch (Exception e) {						
			return null;
		}
	}
}
