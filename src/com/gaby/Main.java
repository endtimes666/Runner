/*You are a runner, and you are in training for a race. 
You'd like to keep track of all of your times for your training runs. 
You only like to run around lakes. Here's some example data,

Calhoun, 45.15
Calhoun, 43.32
Harriet,  49.34
Harriet, 44.43
Harriet, 46.22
Como, 32.11
Como, 28.14
Please write a program which enables you to enter the names of lakes and times, 
and store it all of this data in data structure(s). 
Don't store it in individual variables. 
Your program should still work if you started running around another lake too (e.g. Cedar or Phalen).
Your program should be able to analyze the data that you have stored, 
and print your fastest time for each lake you ran around. So, for this data, your program will display
Calhoun, 43.32
Harriet, 44.43
Como, 32.11*/

//Modify this program to use objects to store the data. What class(es) will you create?  
//Again, your classes should improve your program's organization, conciseness, clarity and structure. 

package com.gaby;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// do everything in main
		Scanner sc = new Scanner(System.in);
		HashMap<String, Double> lakesAndTimes = new HashMap<String, Double>();
		HashMap<String, Double> singleLakeTime = new HashMap<String, Double>();
		String greeting = "Welcome to the Runner App. Please enter your last run:\r\n";
		printToConsole(greeting);
		singleLakeTime = getNamesAndTimes(sc);
		String lakeName;
		Double lengthOfRun;
		Iterator it = singleLakeTime.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry entry = (Map.Entry) it.next();
			lakeName = (String) entry.getKey();
			lengthOfRun = (Double) entry.getValue();
			lakesAndTimes.put(lakeName, lengthOfRun);
		}

		String anotherLakeQuery = "Do you want to enter another run? Y/N";
		printToConsole(anotherLakeQuery);
		if (sc.hasNext("Y") == true) {
			singleLakeTime = getNamesAndTimes(sc);
			while (it.hasNext()) {
				Map.Entry entry = (Map.Entry) it.next();
				lakeName = (String) entry.getKey();
				lengthOfRun = (Double) entry.getValue();
				lakesAndTimes.put(lakeName, lengthOfRun);
			}

		} else {
			// write a method for getting the fastest times
			String findFastestTimes = "Here are your fastest times:";
			printToConsole(findFastestTimes(lakesAndTimes).toString());
		}
	}

	public static HashMap<String, Double> findFastestTimes(
			HashMap<String, Double> map) {

		HashMap<String, Double> fastestMap = null;
		HashMap<String, Double> sameLakesMap = null;

		Map.Entry firstLake;
		Iterator it = map.entrySet().iterator();
		while (it.hasNext()) {
			firstLake = (Map.Entry) it.next();
			sameLakesMap.put(firstLake.getKey().toString(),
					(Double) firstLake.getValue());
			Map.Entry nextLake = (Map.Entry) it.next();
			if (nextLake.getKey() == firstLake.getKey())
				sameLakesMap.put(nextLake.getKey().toString(),
						(Double) nextLake.getValue());
		}

		Iterator it2 = sameLakesMap.entrySet().iterator();
		while (it2.hasNext()) {
			Map.Entry fastest = (Map.Entry) it2.next();
			Double fastestTime = (Double) fastest.getValue();
			fastest = (Map.Entry) it2.next();
			if ((Double) fastest.getValue() < fastestTime)
				fastestTime = (Double) fastest.getValue();
		}
		return fastestMap;
	}

	public static HashMap<String, Double> getNamesAndTimes(Scanner sc) {

		HashMap<String, Double> lakeAndTime = new HashMap<String, Double>();

		String where = "Where did you run?";
		String howLong = "How long was the run? (please enter this in this format: Minutes.Seconds, as in 34.22)";

		printToConsole(where);
		String lakeName = sc.nextLine();
		sc.reset();
		printToConsole(howLong);
		String lengthOfRun = sc.nextLine();
		sc.reset();

		return lakeAndTime;

	}

	public static void printToConsole(String whatToPrint) {
		System.out.println(whatToPrint);
	}

}
