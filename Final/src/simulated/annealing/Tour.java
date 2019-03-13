/**


/*
* Class Tour.java
* This class represents a tour (a candidate solution) through all cities
*/

package simulated.annealing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Stack;

/*
* Tour.java
* Models a traveling salesman tour
* Stores a candidate tour through all cities
*/

public class Tour{

    //to hold a tour of cities
    private ArrayList<City> tour = new ArrayList<>();
    
    //we assume initial value of distance is 0 
    private int distance = 0;
    
    //Constructor
    //starts an empty tour
    public Tour(){
        for (int i = 0; i < TourManager.numberOfCities(); i++) {
            tour.add(null);
        }
    }
    
    //another Constructor
    //starts a tour from another tour
    @SuppressWarnings("unchecked")
	public Tour(ArrayList<City> tour){
        this.tour = (ArrayList<City>) tour.clone();
    }
    
    /**
      Returns tour information
      @return currenttour
     */
    public ArrayList<City> getTour(){
        return tour;
    }
     
    /**
     * Creates a random tour (i.e. individual or candidate solution)
     */
    public void generateIndividual() {
        // Loop through all our destination cities and add them to our tour
        for (int cityIndex = 0; cityIndex < TourManager.numberOfCities(); cityIndex++) {
          setCity(cityIndex, TourManager.getCity(cityIndex));
        }
        // Randomly reorder the tour
        Collections.shuffle(tour);
    }

    public ArrayList<City>   tsp() {
        Stack<Integer> stack;
        stack = new Stack<Integer>();
        ArrayList<City> inittour = new ArrayList<City>();
        int numberOfNodes = TourManager.numberOfCities();
        int[][] arr_dis = new int[numberOfNodes][numberOfNodes];
        int[] visited = new int[numberOfNodes];
        Random rand = new Random();
        int r = rand.nextInt(numberOfNodes);
        int indx = 0;
        setCity(indx, TourManager.getCity(r));
        inittour.add (TourManager.getCity(r));
        visited[r] = 1;
        stack.push(r);
        int element, dst=r , i, dist, totaldist = 0;
        //int min = Integer.MAX_VALUE;
        boolean minFlag = false;
        System.out.print(r + "\t");
        while (!stack.isEmpty()) {
            int current = stack.peek();
            i =0;
            int min = Integer.MAX_VALUE;
            while (i < numberOfNodes) {
                City fromCity = TourManager.getCity(current);
                City destinationCity = TourManager.getCity(i);
                dist = Utility.distance(fromCity, destinationCity);
                arr_dis[current][i] = dist;
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
                totaldist = totaldist + min;
                visited[dst] = 1;
                stack.push(dst);
                indx = indx + 1;
                setCity(indx, TourManager.getCity(dst));
                inittour.add (TourManager.getCity(dst));
                //System.out.print(dst + "\t");
                minFlag = false;
                continue;
            }
            stack.pop();
        }
        return inittour;
    }

    /**
     * Returns a city from the tour given the city's index
     * @param index
     * @return City at that index
     */
    public City getCity(int index) {
        return tour.get(index);
    }

    /**
     * Sets a city in a certain position within a tour
     * @param index
     * @param city
     */
    public void setCity(int index, City city) {
        tour.set(index, city);
        // If the tour has been altered we need to reset the fitness and distance
        distance = 0;
    }
    
    /**
     * Computes and returns the total distance of the tour
     * @return distance total distance of the tour
     */
    public int getTotalDistance(){
    	if (distance == 0) {
            int tourDistance = 0;
            // Loop through our tour's cities
            for (int cityIndex=0; cityIndex < tourSize(); cityIndex++) {
                // Get city we're traveling from
                City fromCity = getCity(cityIndex);
                // City we're traveling to
                City destinationCity;
                // Check we're not on our tour's last city, if we are set our
                // tour's final destination city to our starting city
                if(cityIndex+1 < tourSize()){
                    destinationCity = getCity(cityIndex+1);
                }
                else{
                    destinationCity = getCity(0);
                }                
                // Get the distance between the two cities
                tourDistance += Utility.distance(fromCity, destinationCity); 
            }
            distance = tourDistance;
        }
        return distance;
    }

    /**
     * Get number of cities on our tour
     * @return number how many cities there are in the tour!
     */
    public int tourSize() {
        return tour.size();
    }
    
    //@Override
    /**
     * To print out a list of all the cities in the tour
     */

/*   public String toString() {
        String s = getCity(0).getCityName();
        for (int i = 1; i < tourSize(); i++) {
            s += " -> " + getCity(i).getCityName();
        }
        return s;
    }*/
}
    
