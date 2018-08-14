package designpatterns.structural_patterns;

public class ProxyTest {

	public static void main(String[] args) throws Exception {
		CommandExecutor exe=new CommandExecutorProxy("abcx", "123");
//		exe.runCommand("rm a from c");
		exe.runCommand("ls -s");

	}

}

interface CommandExecutor {
	void runCommand(String cmd) throws Exception;
}

class CommandExecutorImpl implements CommandExecutor {

	@Override
	public void runCommand(String cmd) {
		System.out.println(cmd +" command executed");
	}
}


class CommandExecutorProxy implements CommandExecutor {
	
	boolean isAdmin;
	CommandExecutor executor;
	
	public CommandExecutorProxy(String user,String password) {
		if("123".equalsIgnoreCase(password) && "abc".equals(user)){
			this.isAdmin=true;
		}
		executor=new CommandExecutorImpl();
	}



	@Override
	public void runCommand(String cmd) throws Exception {
		if(isAdmin){
			executor.runCommand(cmd);
		} else {
			if(cmd.contains("rm")){
				throw new Exception("rm is not allowed for non-admin users");
			} else {
				executor.runCommand(cmd);
			}
		}
	}
}