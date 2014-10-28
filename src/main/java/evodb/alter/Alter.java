package evodb.alter;

public interface Alter {

	public abstract String getOracleStatement();
	
	public abstract String getMSSQLStatement();
	
}
