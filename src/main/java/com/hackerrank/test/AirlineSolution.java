package com.hackerrank.test;

import java.util.Arrays;
import java.util.Scanner;

class AirlineSolution {

	class Route implements Comparable<Route> {
		Integer srcCity, destCity;
		Double cost;

		@Override
		public int compareTo(Route compareRoute) {
			return this.cost.compareTo(compareRoute.cost);
		}
	}

	class subset {
		int parent, rank;
	}

	int totalCities, totalRoutes;
	Route route[];

	AirlineSolution(int totalCities, int totalRoutes) {
		this.totalCities = totalCities;
		this.totalRoutes = totalRoutes;

		route = new Route[totalRoutes];

		for (int i = 0; i < totalRoutes; ++i) {
			route[i] = new Route();
		}
	}

	int find(subset subsets[], int i) {
		if (subsets[i].parent != i)
			subsets[i].parent = find(subsets, subsets[i].parent);

		return subsets[i].parent;
	}

	void Union(subset subsets[], int x, int y) {
		int xroot = find(subsets, x);
		int yroot = find(subsets, y);

		if (subsets[xroot].rank < subsets[yroot].rank)
			subsets[xroot].parent = yroot;
		else if (subsets[xroot].rank > subsets[yroot].rank)
			subsets[yroot].parent = xroot;
		else {
			subsets[yroot].parent = xroot;
			subsets[xroot].rank++;
		}
	}

	void findBestRoute() {
		Route result[] = new Route[totalCities];
		int e = 0;
		int i = 0;
		for (i = 0; i < totalCities; ++i)
			result[i] = new Route();

		Arrays.sort(route);

		subset subsets[] = new subset[totalCities];
		for (i = 0; i < totalCities; ++i)
			subsets[i] = new subset();

		for (int v = 0; v < totalCities; ++v) {
			subsets[v].parent = v;
			subsets[v].rank = 0;
		}

		i = 0;

		while (e < totalCities - 1) {
			Route next_route = new Route();
			next_route = route[i++];

			int x = find(subsets, next_route.srcCity);
			int y = find(subsets, next_route.destCity);

			if (x != y) {
				result[e++] = next_route;
				Union(subsets, x, y);
			}
		}

		double total = 0;
		for (i = 0; i < e; ++i) {
			System.out.println(result[i].srcCity + " " + result[i].destCity + " " + result[i].cost);
			total += result[i].cost;
		}
		System.out.println(total);
	}

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int totalCities = scanner.nextInt();
		int totalRoutes = scanner.nextInt();

		AirlineSolution solution = new AirlineSolution(totalCities, totalRoutes);

		for (int i = 0; i < totalRoutes; i++) {
			solution.route[i].srcCity = scanner.nextInt();
			solution.route[i].destCity = scanner.nextInt();
			solution.route[i].cost = scanner.nextDouble();
		}

		scanner.close();

		solution.findBestRoute();
	}
}
