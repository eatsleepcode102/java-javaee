package config;

import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import test.MyResource;

@ApplicationPath("ws")
public class MyApplication extends Application {

	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> resources = new java.util.HashSet<>();
		// register services
		resources.add(MyResource.class);

		return resources;
	}

}
