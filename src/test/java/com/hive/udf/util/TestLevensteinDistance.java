package com.hive.udf.util;

import org.apache.lucene.search.spell.LevensteinDistance;
import org.apache.lucene.search.spell.StringDistance;
import org.junit.Assert;
import org.junit.Test;

public class TestLevensteinDistance {

	private StringDistance distance = new LevensteinDistance();

	@Test
	public void testEqual_0() {

		Assert.assertEquals(1.0, distance.getDistance("A", "A"), 0f);
		Assert.assertEquals(1.0, distance.getDistance("AA", "AA"), 0f);

	}

	@Test
	public void testDistance_05() {
		Assert.assertEquals(0.5, distance.getDistance("AA", "A"), 0f);
		Assert.assertEquals(0.5, distance.getDistance("A", "AA"), 0f);
		Assert.assertEquals(0.5, distance.getDistance("AB", "AA"), 0f);
		Assert.assertEquals(0.5, distance.getDistance("AA", "BA"), 0f);
	}

	@Test
	public void testDistance_1() {
		Assert.assertEquals(1.0, distance.getDistance("", ""), 0f);

	}

	@Test
	public void testDistance_00() {
		Assert.assertEquals(0.0, distance.getDistance("AA", ""), 0f);
		Assert.assertEquals(0.0, distance.getDistance("", "AA"), 0f);
		Assert.assertEquals(0.0, distance.getDistance("AB", "BA"), 0f);
		Assert.assertEquals(0.0, distance.getDistance("BA", "AB"), 0f);

		Assert.assertEquals(0.0, distance.getDistance("ab", "AB"), 0f);
		Assert.assertEquals(0.0, distance.getDistance("AB", "ab"), 0f);
		Assert.assertEquals(0.0, distance.getDistance("aB", "Ab"), 0f);
	}

}
