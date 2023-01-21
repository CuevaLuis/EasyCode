package dev.luiscueva.files;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

class NoHeaderOOS extends ObjectOutputStream{

	public NoHeaderOOS(OutputStream out) throws IOException {
		super(out);		
	}

	protected void writeStreamHeader() throws IOException {
		// Do nothing
	}
}
