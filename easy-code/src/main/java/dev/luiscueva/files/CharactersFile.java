package dev.luiscueva.files;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CharactersFile {

	// PROBADO
	public static final boolean write(File file, String text, boolean append) {

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

	// PROBADO
	public static final String read(File file) {
		
		String ret = "";
		int aux;
		
		try {
			FileReader br = new FileReader(file);
			aux = br.read();
			while(aux != -1) {
				ret += (char) aux;
				aux = br.read();
			}
			
			if(br != null) {
				br.close();	
			}
						
			return ret;
		} catch (IOException e) {
			return null;
		}
	}
	
	// PROBADO
	public static final String[] split (File file, String symbol) {
		return read(file).split(symbol);
	}
}
