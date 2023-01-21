package dev.luiscueva.files;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CharactersFile {

	public static boolean writeCharactersFile(File file, String text, boolean append) {

		try {
			FileWriter bw = new FileWriter(file.getAbsoluteFile(), append);
			bw.write(text);
			bw.flush();
			bw.close();
			return true;
		} catch (IOException e) {
			return false;
		}
	}
	
	
}
