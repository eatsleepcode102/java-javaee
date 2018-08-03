package designpatterns.creational_patterns.builder;

public class BuilderTest {

	public static void main(String[] args) {
		WindowBuilder.createWinDow();
	}

}


class Menu {
}

class ToolBar {
}

class MainWindow {
	Menu menu;
	ToolBar toolBar;
	public Menu getMenu() {
		return menu;
	}
	public void setMenu(Menu menu) {
		System.out.println("menu is built");
		this.menu = menu;
	}
	public ToolBar getToolBar() {
		return toolBar;
	}
	public void setToolBar(ToolBar toolBar) {
		System.out.println("toolbar is built");
		this.toolBar = toolBar;
	}
}

class WindowBuilder {
	
	public static MainWindow createWinDow() {
		Menu menu=new Menu();
		ToolBar toolBar=new ToolBar();
		MainWindow main=new MainWindow();
		main.setMenu(menu);
		main.setToolBar(toolBar);
		System.out.println("window is built");
		System.out.println("loading window....");
		return main;
	}
}