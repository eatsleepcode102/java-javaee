package corejava.security;

import java.awt.AWTPermission;
import java.io.FilePermission;
import java.security.AccessController;

public class AccessControllerTest {

	public static void main(String[] args) {
//		AWTPermission ap = new AWTPermission("accessClipboard");
//		AccessController.checkPermission(ap);
		
		FilePermission fp = new FilePermission("autoexec.txt", "read");
	    AccessController.checkPermission(fp);
	}

}
