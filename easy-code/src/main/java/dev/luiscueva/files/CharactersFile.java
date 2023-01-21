package dev.luiscueva.files;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CharactersFile {

	public static boolean writeCharactersFile(File file, String text) {

		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			bw.write(text);
			bw.flush();
			bw.close();
			return true;
		} catch (IOException e) {
			return false;
		}
		
	}
}
