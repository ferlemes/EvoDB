package evodb.runner;

import java.util.Set;

import org.reflections.Reflections;

import evodb.annotation.ChangeSet;

public class AnnotatedClassesScanner {

	public static void main(String args[]) {
		Reflections reflections = new Reflections();

	     Set<Class<?>> annotated = 
	               reflections.getTypesAnnotatedWith(ChangeSet.class);
	     
	     System.out.println("ChangeSets detected:");
	     for (Class<?> anAnnotatedClass : annotated) {
	    	 System.out.println(anAnnotatedClass.getName());
	     }
	}
	
}
