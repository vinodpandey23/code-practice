package com.miscellaneous.programs;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

/**
 * 
 * MiceWallProblem Class for Mice/Wall problem solution
 * 
 * @author Vinod Pandey
 *
 */
class MiceWallProblem {

	public static void main(String[] args) {

		double widthOfWall = 0;

		/*
		 * read input from console
		 */
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.print("Enter width of wall (in meters): ");
			widthOfWall = scanner.nextDouble();
		}

		MiceWallProblem mainObj = new MiceWallProblem();
		Output output = mainObj.startProcessing(widthOfWall);
		System.out.println(output.toString());
	}

	/**
	 * Method containing main logic for calculation of required time and distances
	 * digged by big and small mice
	 * 
	 * @param width
	 *            - length of wall in meters
	 * @return
	 */
	public Output startProcessing(double width) {

		// validate input before starting actual processing
		validateInput(width);

		double widthInMM = width * 1000;

		int noOfDays = 0;
		int noOfHours = 0;
		int noOfMinutes = 0;
		int noOfSeconds = 0;

		double total = 0;
		double totalByB = 0;
		double totalbyS = 0;

		// outer most loop for day counter
		for (int d = 1;; d++) {

			// day wise digged distance by mice which is varied for each day
			double digByB = Math.pow(2, d - 1);
			double digByS = 1 / digByB;

			if ((total + digByB + digByS) <= widthInMM) {
				// in case digged distances for the whole day is less than length of wall
				total += digByB + digByS;
				totalByB += digByB;
				totalbyS += digByS;
				noOfDays++;
			} else {

				// hour wise digged distance by mice which is fixed for each hour on a day
				digByB = digByB / 24;
				digByS = digByS / 24;

				// loop for hour counter
				for (int h = 0; h < 24; h++) {

					if ((total + digByB + digByS) <= widthInMM) {
						// in case digged distances for the whole hour is less than length of wall
						total += digByB + digByS;
						totalByB += digByB;
						totalbyS += digByS;
						noOfHours++;
					} else {

						// minute wise digged distance by mice which is fixed for each minute on a day
						digByB = digByB / 60;
						digByS = digByS / 60;

						// loop for minute counter
						for (int m = 0; m < 60; m++) {

							if ((total + digByB + digByS) <= widthInMM) {
								// in case digged distances for the whole minute is less than length of wall
								total += digByB + digByS;
								totalByB += digByB;
								totalbyS += digByS;
								noOfMinutes++;
							} else {

								// second wise digged distance by mice which is fixed for each second on a day
								digByB = digByB / 60;
								digByS = digByS / 60;

								// loop for second counter
								for (int s = 0; s < 60; s++) {

									if ((total + digByB + digByS) <= widthInMM) {
										// in case digged distances for the whole second is less than length of wall
										total += digByB + digByS;
										totalByB += digByB;
										totalbyS += digByS;
										noOfSeconds++;
									}
									if (total == widthInMM) {
										break;
									}
								}
							}
							if (total == widthInMM) {
								break;
							}
						}
					}
					if (total == widthInMM) {
						break;
					}
				}
			}
			if (total == widthInMM) {
				break;
			}
		}

		/*
		 * prepare output data object with calculated values
		 */
		Output output = new Output();
		output.setDistDiggedByBigM(round(totalByB, 3));
		output.setDistDiggedBySmallM(round(totalbyS, 3));
		StringBuilder noOfDay = new StringBuilder().append(noOfDays).append(" days, ").append(noOfHours)
				.append(" hours, ").append(noOfMinutes).append(" minutes, ").append(noOfSeconds).append(" seconds");
		output.setNoOfDaysRequired(noOfDay.toString());

		return output;
	}

	/**
	 * 
	 * @param width
	 */
	private void validateInput(double width) {

		if (width <= 0) {
			throw new IllegalArgumentException("Invalid value for width of wall. Please enter width greater than 0.");
		}

	}

	/**
	 * 
	 * @param value
	 * @param places
	 * @return
	 */
	private double round(double value, int places) {

		BigDecimal bd = new BigDecimal(value);
		bd = bd.setScale(places, RoundingMode.HALF_UP);
		return bd.doubleValue();
	}
}

/**
 * 
 * @author Vinod Pandey
 *
 */
class Output {

	private String noOfDaysRequired;
	private double distDiggedByBigM;
	private double distDiggedBySmallM;

	/**
	 * @return the noOfDaysRequired
	 */
	public String getNoOfDaysRequired() {
		return noOfDaysRequired;
	}

	/**
	 * @param noOfDaysRequired
	 *            the noOfDaysRequired to set
	 */
	public void setNoOfDaysRequired(String noOfDaysRequired) {
		this.noOfDaysRequired = noOfDaysRequired;
	}

	/**
	 * @return the distDiggedByBigM
	 */
	public double getDistDiggedByBigM() {
		return distDiggedByBigM;
	}

	/**
	 * @param distDiggedByBigM
	 *            the distDiggedByBigM to set
	 */
	public void setDistDiggedByBigM(double distDiggedByBigM) {
		this.distDiggedByBigM = distDiggedByBigM;
	}

	/**
	 * @return the distDiggedBySmallM
	 */
	public double getDistDiggedBySmallM() {
		return distDiggedBySmallM;
	}

	/**
	 * @param distDiggedBySmallM
	 *            the distDiggedBySmallM to set
	 */
	public void setDistDiggedBySmallM(double distDiggedBySmallM) {
		this.distDiggedBySmallM = distDiggedBySmallM;
	}

	@Override
	public String toString() {

		StringBuilder result = new StringBuilder("Number of days required: ").append(noOfDaysRequired)
				.append("\nDistance digged by big mouse: ").append(distDiggedByBigM)
				.append("\nDistance digged by small mouse: ").append(distDiggedBySmallM);
		return result.toString();
	}

}
