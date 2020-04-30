package v1;

import java.io.Serializable;

/**
 * Rep Exercise specific code
 * @author Cyan
 *
 */
public class RepExercise extends Exercise implements Serializable {

	/**
	 * Number of reps
	 */
	private int reps;
	/**
	 * Level of intensity
	 */
	private int intensity;

	/**
	 * Basic Constructor
	 * @param name Name of exercise
	 * @param reps Number of reps
	 * @param intensity Level of intensity
	 * @param caloriesBurned Number of calories burned
	 */
	public RepExercise(String name, int reps, int intensity, int caloriesBurned) {
		super(name, caloriesBurned);
		this.reps = reps;
		this.intensity = intensity;
	}
	
	/**
	 * Generic getter
	 * @return reps
	 */
	public int getReps() {
		return this.reps;
	}
	
	/**
	 * Generic setter
	 * @param reps New amount of reps
	 */
	public void setReps(int reps) {
		this.reps = reps;
	}

	/**
	 * Generic getter
	 * @return intensity
	 */
	public int getIntensity() {
		return this.intensity;
	}

	/**
	 * Generic setter
	 * @param intensity Level of intensity
	 */
	public void setIntensity(int intensity) {
		this.intensity = intensity;
	}
	
	/**
	 * Overriden toString method to display info about the exercise
	 */
	public String toString() {
		return(super.getName() + " Reps: "+ this.reps + ", intensity: " + this.intensity + ", Calories Burned: "
				      + getCaloriesBurned());
		
	}

}
