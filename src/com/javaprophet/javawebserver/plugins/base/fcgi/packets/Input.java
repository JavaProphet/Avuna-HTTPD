package com.javaprophet.javawebserver.plugins.base.fcgi.packets;

import java.io.DataInputStream;
import java.io.IOException;
import com.javaprophet.javawebserver.plugins.base.fcgi.Type;

public class Input extends Stream {
	
	public Input(DataInputStream in, int l) throws IOException {
		readContent(in, l);
	}
	
	public Input(int id) {
		super(Type.FCGI_STDIN, id);
	}
	
}
