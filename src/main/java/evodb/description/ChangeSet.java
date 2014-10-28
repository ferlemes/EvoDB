package evodb.description;

import java.util.List;

import evodb.alter.Alter;

public interface ChangeSet {

	List<Alter> getAlters();
	
}
