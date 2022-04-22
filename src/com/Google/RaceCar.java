package com.Google;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class RaceCar {

	public static class Car {
		int pos;
		int speed;

		public Car(int pos, int speed) {
			this.pos = pos;
			this.speed = speed;
		}

	}

	public static int racecar(int target) {
		Queue<Car> q = new LinkedList<Car>();

		q.add(new Car(0, 1));
		int minInstr = 0;
		HashSet<String> set = new HashSet<String>();
		set.add("0" + ";" + "1");
		while (!q.isEmpty()) {
			int size = q.size();
			while (size-- > 0) {
				Car curCar = q.poll();

				if (curCar.pos == target)
					return minInstr;

				int nextPos = curCar.pos + curCar.speed;
				int nextSpeed = curCar.speed * 2;

				if (!set.contains(nextPos + ";" + nextSpeed) && Math.abs(nextPos - target) < target) {
					q.add(new Car(nextPos, nextSpeed));
					set.add(nextPos + ";" + nextSpeed);
				}

				nextPos = curCar.pos;
				nextSpeed = curCar.speed > 0 ? -1 : 1;

				if (!set.contains(nextPos + ";" + nextSpeed) && Math.abs(nextPos - target) < target) {
					q.add(new Car(nextPos, nextSpeed));
					set.add(nextPos + ";" + nextSpeed);
				}
			}
			minInstr++;
		}
		return -1;

	}

	public static void main(String[] args) {
		System.out.println(racecar(3));

	}

}
