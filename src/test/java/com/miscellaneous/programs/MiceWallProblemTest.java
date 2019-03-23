package com.miscellaneous.programs;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MiceWallProblemTest {

	private static MiceWallProblem miceWallProblem = null;
	private static double widthOfWall = 0;

	public MiceWallProblemTest() {
	}
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		miceWallProblem = new MiceWallProblem();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		miceWallProblem = null;
	}

	@Before
	public void setUp() throws Exception {
		widthOfWall = 1.465;
	}

	@After
	public void tearDown() throws Exception {
		widthOfWall = 0;
	}

	@Test(expected = IllegalArgumentException.class)
	public void checkInvalidWallLength() {

		widthOfWall = -1.45;
		miceWallProblem.startProcessing(widthOfWall);

	}

	@Test
	public void checkDiggedDistSum() {

		Output output = miceWallProblem.startProcessing(widthOfWall);

		if (output.getDistDiggedByBigM() + output.getDistDiggedBySmallM() != widthOfWall * 1000) {
			fail("Digged distances by both mice is not equal to width of wall.");
		}

	}

	@Test
	public void checkOutputFormat() {

		Output output = miceWallProblem.startProcessing(widthOfWall);

		String[] resultArr = output.getNoOfDaysRequired().split(" ");

		if (resultArr.length != 8 || !resultArr[1].equals("days,") || !resultArr[3].equals("hours,")
				|| !resultArr[5].equals("minutes,") || !resultArr[7].equals("seconds")) {
			fail("Output format for number of days is not correct.");
		}

	}

}
