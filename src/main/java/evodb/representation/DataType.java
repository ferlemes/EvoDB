package evodb.representation;

public enum DataType {

	VARCHAR("VARCHAR", "VARCHAR2"),
	
	NUMBER("NUMBER", "NUMBER");
	
	private String oracleName;
	
	private String msSqlName;
	
	private DataType(String oracleName, String msSqlName) {
		this.oracleName = oracleName;
		this.msSqlName = msSqlName;
	}
	
	public String getOracleName() {
		return oracleName;
	}
	
	public String getMsSqlName() {
		return msSqlName;
	}
	
}
