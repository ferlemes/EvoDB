package evodb.description;

import java.util.ArrayList;
import java.util.List;

public class Project {

	private String name;
	
	private List<Version> projectVersions;
	
	public Project(String name) {
		this.name = name;
		this.projectVersions = new ArrayList<Version>();
	}
	
	public void createNewVersion(String versionName) {
		this.projectVersions.add(new Version(versionName, this.getLastVersion()));
	}
	
	public Version getLastVersion() {
		if (this.projectVersions.isEmpty()) {
			return null;
		}
		return this.projectVersions.get(this.projectVersions.size() - 1);
	}

	public void addChangeSet(ChangeSet aChangeSet) {
		this.getLastVersion().addChangeSet(aChangeSet);
	}
}
