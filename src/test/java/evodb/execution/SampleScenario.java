package evodb.execution;

import java.util.ArrayList;
import java.util.List;

import koho.evodb.alter.Alter;
import koho.evodb.alter.CreateTable;
import koho.evodb.description.ChangeSet;
import koho.evodb.description.Project;
import koho.evodb.representation.Column;
import koho.evodb.representation.DataType;
import koho.evodb.representation.Table;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class SampleScenario {
	
	
	@Test
	public void basicProject() {
		Project basicOne = new Project("A Basic Project");
		basicOne.createNewVersion("1.00");
		basicOne.addChangeSet(new InitialDatabaseProject());
		basicOne.createNewVersion("1.01");
		basicOne.addChangeSet(new UpdatingDatabase());
		System.out.println(basicOne.generateAlters());
	}
	
	
	private class InitialDatabaseProject implements ChangeSet {

		@Override
		public List<Alter> getAlters() {
			
			List<Alter> alters = new ArrayList<Alter>();
			
			Table users = new Table("user", new Column[] {
				new Column("id", DataType.NUMBER),
				new Column("name", DataType.VARCHAR)
			});
			alters.add(new CreateTable(users));
			
			return alters;
			
		}
	
	}
	
	private class UpdatingDatabase implements ChangeSet {

		@Override
		public List<Alter> getAlters() {
			
			List<Alter> alters = new ArrayList<Alter>();
			
			Table password = new Table("password", new Column[] {
				new Column("user_id", DataType.NUMBER),
				new Column("password_hash", DataType.VARCHAR),
				new Column("password_salt", DataType.VARCHAR)
			});
			alters.add(new CreateTable(password));
			
			return alters;
			
		}
		
	}
	
}
