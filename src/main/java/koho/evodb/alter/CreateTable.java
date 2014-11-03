package koho.evodb.alter;

import koho.evodb.representation.Column;
import koho.evodb.representation.Table;

public class CreateTable extends AbstractAlter {

	private Table table;

	public CreateTable(Table table) {
		this.table = table; 
	}
	
	@Override
	public String getOracleStatement() {
		StringBuilder statementBuilder = new StringBuilder();
		statementBuilder.append("CREATE TABLE '"+ this.table.getName() + "' (");
		for (Column eachColumn : this.table.getColumns()) {
			statementBuilder.append(eachColumn.getName() + " AS " + eachColumn.getType().getOracleName() + ",");
		}
		statementBuilder.deleteCharAt(statementBuilder.length() - 1);
		statementBuilder.append(");\n");
		return statementBuilder.toString();
	}

	@Override
	public String getMSSQLStatement() {
		StringBuilder statementBuilder = new StringBuilder();
		statementBuilder.append("CREATE TABLE '"+ this.table.getName() + "' (");
		for (Column eachColumn : this.table.getColumns()) {
			statementBuilder.append(eachColumn.getName() + " AS " + eachColumn.getType().getMsSqlName() + ",");
		}
		statementBuilder.deleteCharAt(statementBuilder.length() - 1);
		statementBuilder.append(");\n");
		return statementBuilder.toString();
	}

	
}
