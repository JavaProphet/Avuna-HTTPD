package org.avuna.httpd;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Platform;

public class CLib {
	private static final int OK = 0;
	private static final int ERROR = -1;
	
	private interface CLibrary extends Library {
		CLibrary INSTANCE = (CLibrary)Native.loadLibrary((Platform.isWindows() ? "msvcrt" : "c"), CLibrary.class);
		
		int umask(int umask);
		
		int setuid(int uid);
		
		int setgid(int gid);
		
		int getuid();
		
		int geteuid();
	}
	
	public static int setumask(int umask) {
		if (Platform.isWindows()) return OK;
		return CLibrary.INSTANCE.umask(umask);
	}
	
	public static int setuid(int uid) {
		if (Platform.isWindows()) return OK;
		return CLibrary.INSTANCE.setuid(uid);
	}
	
	public static int setgid(int gid) {
		if (Platform.isWindows()) return OK;
		return CLibrary.INSTANCE.setgid(gid);
	}
	
	public static int getuid() {
		if (Platform.isWindows()) return -1;
		return CLibrary.INSTANCE.getuid();
	}
}