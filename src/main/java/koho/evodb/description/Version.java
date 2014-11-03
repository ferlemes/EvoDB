package koho.evodb.description;

import java.util.ArrayList;
import java.util.List;

import koho.evodb.alter.Alter;

public class Version {
	
	private String versionName;
	
	private Version previousVersion;
	
	private List<ChangeSet> changeSets = new ArrayList<ChangeSet>();

	public Version(String versionName, Version previousVersion) {
		this.versionName = versionName;
		this.previousVersion = previousVersion;
	}

	public void addChangeSet(ChangeSet aChangeSet) {
		this.changeSets.add(aChangeSet);
	}

	public String generateAlters() {
		StringBuilder versionAlters = new StringBuilder();
		versionAlters.append("// Alters for version:" + this.versionName + "\n");
		for (ChangeSet eachChangeSet : this.changeSets) {
			for (Alter eachAlter : eachChangeSet.getAlters()) {
				versionAlters.append(eachAlter.getOracleStatement());
			}
		}
		return versionAlters.toString();
	}

}
