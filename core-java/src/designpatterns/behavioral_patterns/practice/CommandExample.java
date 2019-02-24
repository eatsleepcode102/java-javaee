package designpatterns.behavioral_patterns.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * In a classic implementation, the command pattern requires implementing four
 * components: the Command, the Receiver, the Invoker, and the Client.
 * 
 * To understand how the pattern works and the role that each component plays,
 * let’s create a basic example.
 * 
 * Let’s suppose that we want to develop a text file application. In such a
 * case, we should implement all functionality required for performing some
 * text-file related operations, such as opening, writing, saving a text file,
 * and so forth.
 * 
 * So, we should break down the application into the four components mentioned
 * above.
 */

public class CommandExample {
	public static void main(String[] args) {
		TextFileOperation openTextFileOperation = new OpenTextFileOperation(
				new TextFile("file1.txt"));
		TextFileOperation saveTextFileOperation = new SaveTextFileOperation(
				new TextFile("file2.txt"));

		TextFileOperationExecutor textFileOperationExecutor = new TextFileOperationExecutor();
		System.out.println(textFileOperationExecutor
				.executeOperation(openTextFileOperation));
		System.out.println(textFileOperationExecutor
				.executeOperation(saveTextFileOperation));
		
		//Using Lambda Expressions
		TextFileOperationExecutor textFileOperationExecutor1
		 = new TextFileOperationExecutor();
		textFileOperationExecutor1.executeOperation(() -> "Opening file file1.txt");
		textFileOperationExecutor1.executeOperation(() -> "Saving file file1.txt");
		
		//Using Method References
		TextFileOperationExecutor textFileOperationExecutor2
		 = new TextFileOperationExecutor();
		TextFile textFile = new TextFile("file1.txt");
		textFileOperationExecutor2.executeOperation(textFile::open);
		textFileOperationExecutor2.executeOperation(textFile::save);
	}
}

/*
 * A command is an object whose role is to store all the information required
 * for executing an action, including the method to call, the method arguments,
 * and the object (known as the receiver) that implements the method.
 * 
 * To get a more accurate idea of how command objects work, let’s start
 * developing a simple command layer which includes just one single interface
 * and two implementations:
 */
//command
@FunctionalInterface
interface TextFileOperation {
	String execute();
}

/*
 * In this case, the TextFileOperation interface defines the command objects’
 * API, and the two implementations, OpenTextFileOperation and
 * SaveTextFileOperation, perform the concrete actions. The former opens a text
 * file, while the latter saves a text file.
 * 
 * It’s clear to see the functionality of a command object: the
 * TextFileOperation commands encapsulate all the information required for
 * opening and saving a text file, including the receiver object, the methods to
 * call, and the arguments (in this case, no arguments are required, but they
 * could be).
 * 
 * It’s worth stressing that the component that performs the file operations is
 * the receiver (the TextFile instance).
 */
class OpenTextFileOperation implements TextFileOperation {

	private final TextFile textFile;

	public OpenTextFileOperation(TextFile textFile) {
		super();
		this.textFile = textFile;
	}

	@Override
	public String execute() {
		return textFile.open();
	}
}

class SaveTextFileOperation implements TextFileOperation {
	private final TextFile textFile;

	public SaveTextFileOperation(TextFile textFile) {
		super();
		this.textFile = textFile;
	}

	@Override
	public String execute() {
		return textFile.save();
	}
}

// involker
class TextFileOperationExecutor {
	private final List<TextFileOperation> textFileOperations = new ArrayList<>();

	public String executeOperation(TextFileOperation textFileOperation) {
		textFileOperations.add(textFileOperation);
		return textFileOperation.execute();
	}
}

/*
 * A receiver is an object that performs a set of cohesive actions. It’s the
 * component that performs the actual action when the command’s execute() method
 * is called.
 * 
 * In this case, we need to define a receiver class, whose role is to model
 * TextFile objects:
 */

// receiver
class TextFile {
	private final String name;

	public TextFile(String name) {
		this.name = name;
	}

	public String open() {
		return "Openng file " + name;
	}

	public String read() {
		return "Reading file " + name;
	}

	public String write() {
		return "Writing to file " + name;
	}

	public String save() {
		return "Saving file " + name;
	}

	public String copy() {
		return "Copying file " + name;
	}

	public String paste() {
		return "Pasting file " + name;
	}
}