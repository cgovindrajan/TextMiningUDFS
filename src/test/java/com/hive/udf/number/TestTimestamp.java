package com.hive.udf.number;

import org.junit.Assert;
import org.junit.Test;

public class TestTimestamp {

	@Test
	public void testTimestamp() {
		Timestamp timestamp = new Timestamp();
		Assert.assertNotNull(timestamp.evaluate());
	}

}
