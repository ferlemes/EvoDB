package koho.evodb.representation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.swing.event.ListSelectionEvent;

public class Table {
	
	private String name;
	
	private List<Column> columns;
	
	public Table(String name, List<Column> columns) {
		this.name = name;
		this.columns = columns;
	}
	
	public Table(String name, Column[] columns) {
		this(name, Arrays.asList(columns));
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public List<Column> getColumns() {
		return columns;
	}
	
	public void setColumns(List<Column> columns) {
		this.columns = columns;
	}
	
}
