package Modules;

import com.google.inject.AbstractModule;

import Resources.MyResource;

public class MyModule extends AbstractModule {
	@Override
	protected void configure() {
		bind(MyResource.class);
	}
}
