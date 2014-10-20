package evodb.execution;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import evodb.description.ChangeSet;
import evodb.description.Project;

@RunWith(JUnit4.class)
public class SampleScenario {
	
	private static ChangeSet firstChangeSet = new ChangeSet();
	
	@Test
	public void basicProject() {
		Project basicOne = new Project("A Basic Project");
		basicOne.createNewVersion("1.00");
		basicOne.addChangeSet(firstChangeSet);
	}
	
	
}
