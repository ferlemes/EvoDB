package evodb.description;

import java.util.Date;

import koho.evodb.description.DatabaseUpdate;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class DatabaseUpdateTest {

	@Test
	public void basicTest() {
		
		DatabaseUpdate update = new DatabaseUpdate();
		update.setDate(new Date(2014, 10, 17));
		Assert.assertEquals(new Date(2014, 10, 17), update.getDate());
		
	}
	
}
