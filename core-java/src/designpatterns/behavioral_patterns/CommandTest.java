package designpatterns.behavioral_patterns;

/*
 * mindset of this pattern we can consider the situation of action opening a doc file in system.
 * the system is having 2 types of editor, LibOffier and MsOffice - these two having role is like Receiver
 * the action double-clicking a file to open is like constructing a Command
 * */
public class CommandTest {

	public static void main(String[] args) {
		FileSystemReceiver receiver=new WindowsFileSystemReceiver();
		Command openFileCMD= new OpenFileCommand(receiver);
		openFileCMD.execute();
	}
}

interface Command {
	void execute();
}

class OpenFileCommand implements Command {

	FileSystemReceiver fileSystem;
	
	public OpenFileCommand(FileSystemReceiver fileSystem) {
		this.fileSystem = fileSystem;
	}

	@Override
	public void execute() {
		fileSystem.openFile();
	}
}

class WriteFileCommand implements Command {

	FileSystemReceiver fileSystem;
	
	public WriteFileCommand(FileSystemReceiver fileSystem) {
		this.fileSystem = fileSystem;
	}

	@Override
	public void execute() {
		fileSystem.writeFile();
	}
}

class CloseFileCommand implements Command {

	FileSystemReceiver fileSystem;
	
	public CloseFileCommand(FileSystemReceiver fileSystem) {
		this.fileSystem = fileSystem;
	}

	@Override
	public void execute() {
		fileSystem.closeFile();
	}
}

interface FileSystemReceiver {
	void openFile();
	void writeFile();
	void closeFile();
}

class UnixFileSystemReceiver implements FileSystemReceiver {

	@Override
	public void openFile() {
		System.out.println("Opening a file in Unix OS");
	}

	@Override
	public void writeFile() {
		System.out.println("Writing a file in Unix OS");
	}

	@Override
	public void closeFile() {
		System.out.println("Closing a file in Unix OS");
	}
	
}

class WindowsFileSystemReceiver implements FileSystemReceiver {

	@Override
	public void openFile() {
		System.out.println("Opening a file in Windows OS");
	}

	@Override
	public void writeFile() {
		System.out.println("Writing a file in Windows OS");
	}

	@Override
	public void closeFile() {
		System.out.println("Closing a file in Windows OS");
	}
}

