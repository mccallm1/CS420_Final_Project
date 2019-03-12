package simulated.annealing;

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

public class NNTSP {

    private int numberOfNodes;
    public Stack<Integer> stack;
    public NNTSP()
    {
        stack = new Stack<Integer>();
    }
    public ArrayList<City> tsp() {
        ArrayList<City> inittour = new ArrayList<City>();
        numberOfNodes = TourManager.numberOfCities();
        int[] visited = new int[numberOfNodes];
        Random rand = new Random();
        int r = rand.nextInt(numberOfNodes);
        inittour.add (TourManager.getCity(r));
        visited[r] = 1;
        stack.push(r);
        int element, dst = r, i, dist;
        //int min = Integer.MAX_VALUE;
        boolean minFlag = false;
        System.out.print(1 + "\t");
        while (!stack.isEmpty()) {
            dst = stack.peek();
            i = 1;
            int min = Integer.MAX_VALUE;
            while (i <= numberOfNodes) {
                City fromCity = TourManager.getCity(dst);
                City destinationCity = TourManager.getCity(i);
                dist = Utility.distance(fromCity, destinationCity);
                if (dist > 1 && visited[i] == 0) {
                    if (min > dist) {
                        min = dist;
                        dst = i;
                        minFlag = true;
                    }
                }
                i++;
            }
            if (minFlag) {
                visited[dst] = 1;
                stack.push(dst);
                inittour.add (TourManager.getCity(dst));
                System.out.print(dst + "\t");
                minFlag = false;
                continue;
            }
            stack.pop();
        }
        return inittour;
    }
}
