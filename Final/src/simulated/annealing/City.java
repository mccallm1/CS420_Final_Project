
/*
* City.java
* Models a city
*/

package simulated.annealing;

public class City {
    public int x;
    public int y;
    public int id;
    // public int prev_city = city index
	//sec_min_dist = city index

    //Constructor
    //creates a city given its name and (x,y) location
	public City(int id, int x, int y){
    	this.id = id;
        this.x = x;
        this.y = y;
    }            
        
    /**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * @return the id
	 */
	public int getid() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setid(int id) {
		this.id = id;
	}
	
}
