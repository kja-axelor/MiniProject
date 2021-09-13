package Modules;

import com.google.inject.AbstractModule;

import Resources.bookResoure;
import Resources.studentResource;

public class MyModule extends AbstractModule {
	@Override
	protected void configure() {
		bind(studentResource.class);
		bind(bookResoure.class);
	}
}
