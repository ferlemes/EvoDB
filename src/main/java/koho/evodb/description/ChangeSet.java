package koho.evodb.description;

import java.util.List;

import koho.evodb.alter.Alter;

public interface ChangeSet {

	List<Alter> getAlters();
	
}
