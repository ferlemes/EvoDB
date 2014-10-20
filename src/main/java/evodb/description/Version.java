package evodb.description;

import java.util.List;

public class Version {
	
	private String versionName;
	
	private Version previousVersion;
	
	private List<ChangeSet> changeSets;

	public Version(String versionName, Version previousVersion) {
		this.versionName = versionName;
		this.previousVersion = previousVersion;
	}

	public void addChangeSet(ChangeSet aChangeSet) {
		this.changeSets.add(aChangeSet);
	}

}
