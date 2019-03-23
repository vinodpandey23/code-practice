package com.hackerrank.test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class FindCommonManager {

	static HashMap<String, String> adjacencyList = new HashMap<String, String>();

	public static void addToAdjacencyList(String a, String b) {

		if (adjacencyList.isEmpty()) {
			adjacencyList.put(a, null); // top employee ceo is managed by nobody
		}

		// A to B is A manager B . A manages multiple people
		// But we will create directional Adjacency list B to A i.e B is managed by A
		// B is always managed by directly one person only i.e A
		// Add B to A
		adjacencyList.put(b, a);
	}

	public static void buildParentChain(String employee, LinkedList<String> list) {
		if (employee == null) { // parent of ceo reached
			return;
		}
		String manager = adjacencyList.get(employee);
		list.add(manager);
		buildParentChain(manager, list); // call for manager to current employee to build chain upto top i.e ceo
	}

	public static void findCommonManger(String personA, String personB) {

		if (adjacencyList.containsKey(personA) && adjacencyList.get(personA).equals(personB)) {
			System.out.println(" Result = " + personB);
			return;
		} else if (adjacencyList.containsKey(personB) && adjacencyList.get(personB).equals(personA)) {
			System.out.println(" Result = " + personA);
			return;
		}

		LinkedList<String> personAParentChain = new LinkedList<String>();
		LinkedList<String> personBParentChain = new LinkedList<String>();

		buildParentChain(personA, personAParentChain);

		if (personAParentChain.contains(personB)) {
			System.out.println(personB);
			return;
		}

		buildParentChain(personB, personBParentChain);

		if (personBParentChain.contains(personA)) {
			System.out.println(personA);
			return;
		}

		personAParentChain.retainAll(personBParentChain);

		System.out.println(" Result = " + personAParentChain.peek());

	}

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		scanner.nextInt();
		scanner.nextLine();
		String personA = scanner.nextLine();
		String personB = scanner.nextLine();
		while (scanner.hasNextLine()) {
			String str = scanner.nextLine();
			if (str.length() > 0) {
				String a = str.split(" ")[0];
				String b = str.split(" ")[1];
				addToAdjacencyList(a, b);
			} else {
				break;
			}
		}
		findCommonManger(personA, personB);
		scanner.close();
	}
}
