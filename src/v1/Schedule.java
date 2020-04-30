package v1;

import java.util.ArrayList;
import java.util.HashMap;
import java.io.Serializable;
import java.time.LocalTime;

/**
 * Keeps track of all scheduleable exercises for the user
 * @author Cyan
 *
 */
public class Schedule implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HashMap<Exercise, LocalTime[]> schedule;
	
	public Schedule() {
		this.schedule = new HashMap<Exercise, LocalTime[]>();
	}
	
	/**
	 * Adds the exercise to the schedule if it does not conflict with any of the other times
	 * @param newExercise
	 * @param times
	 */
	public void addToSchedule(Exercise newExercise, LocalTime[] times) {
		boolean fits = true;
		for(Exercise key: schedule.keySet()) {
			if(                                   
				(schedule.get(key)[0].isBefore(times[1]) && schedule.get(key)[1].isAfter(times[1]))
				|| (schedule.get(key)[0].isBefore(times[0]) && schedule.get(key)[1].isAfter(times[0]))
				|| schedule.get(key)[0].equals(times[0])
				|| schedule.get(key)[0].equals(times[1])
				|| schedule.get(key)[1].equals(times[0])
				|| schedule.get(key)[1].equals(times[1])
						) {
				fits = false;
			}

			
		}
		if(fits) {
			schedule.put(newExercise, times);
		}
		
	}
	
	/**
	 * removes an exercise with the specified name from the schedule
	 * @param name
	 */
	public void removeFromSchedule(String name) {
		Exercise ref = null;
		for(Exercise key: schedule.keySet()) {
			if(key.getName().equals(name)) {
				ref = key;
			}
		}
		
		if(ref!= null) {
			schedule.remove(ref);
		}
		
		
	}
	
	/**
	 * Changes the times of a current exercise in the schedule
	 * @param name
	 * @param newTimes
	 */
	public void changeExerciseTime(String name, LocalTime[] newTimes) {
		for(Exercise key: schedule.keySet()) {
			if(key.getName().equals(name)) {
				addToSchedule(key, newTimes);
			}
		}
		
	}
	
	/**
	 * Standard setter for the schedule field
	 * @param newSchedule
	 */
	public void setSchedule(HashMap<Exercise, LocalTime[]> newSchedule) {
		this.schedule = newSchedule;
	}
	
	/**
	 * Standard getter for the schedule field
	 * @return schedules
	 */
	public HashMap<Exercise, LocalTime[]> getSchedule(){
		return this.schedule;
	}
	
	public static LocalTime convertToMilitary(String time, String ampm) {
		String[] times = time.split(":");
		if(ampm.equals("AM")) {
			return LocalTime.of(Integer.parseInt(times[0])%24, Integer.parseInt(times[1])%60);
		}
		else {
			return LocalTime.of(Integer.parseInt(times[0])+ 12, Integer.parseInt(times[1]));
		}
	}
	
	public String toString() {
		String token = "";
		for(Exercise exercise: schedule.keySet()) {


			token += (exercise + "       " + schedule.get(exercise)[0] + "--" + schedule.get(exercise)[1] + "\n");
		}

		return token;
	}
	
	public String sortedSchedule() {
		ArrayList<Exercise> sorted = new ArrayList<Exercise>();
		Exercise min = null;
		for(int i = 0; i<schedule.size(); i++) {
		for(Exercise exercise: schedule.keySet()) {
			if(min == null) {
				min = exercise;
			}
			else if(schedule.get(exercise)[0].isBefore(schedule.get(min)[0]) && !(sorted.contains(exercise))){
				min = exercise;
			}
		}
		sorted.add(min);
		}
		String token = "";
		for(Exercise exercise: sorted) {
			token += exercise + "      " + schedule.get(exercise)[0] + "--"+ schedule.get(exercise)[1]+ "\n";
		}

			token += (exercise + "       " + schedule.get(exercise)[0] + "--" + schedule.get(exercise)[1] + "/n");
		}


		return token;
	}
	
	
	
}
