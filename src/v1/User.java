package v1;

import java.io.Serializable;
import java.time.LocalTime;

/**
 * Class to store user info and methods
 * @author Cyan
 *
 */
public class User implements Serializable{
	

	private static final long serialVersionUID = 3999007488314647320L;
	/**
	 * Name of user, Gender of user, Username of user
	 */
    private String name, gender, username;
    /**
     * Age of user, Height off user, Weight of user
     */
    private int age, height, weight;
    /**
     * A user's history which contains all previous dailylogs
     */
    private History history;
    /**
     * A user's' schedule of exercises
     */
    private Schedule schedule;
    /**
     * A user's foodlist
     */
    private FoodList foodlist;
    /**
     * A user's exerciselist
     */
    private ExerciseList exerciselist;

    
    /**
     * Constructs a user object from all the parameters passed to the constructor, initializes all of the fields
     * @param username
     * @param name
     * @param gender
     * @param age
     * @param height
     * @param weight
     * @param calorieLimit
     */
    public User(String username, String name, String gender, int age, int height, int weight, int calorieLimit) {
        this.username = username;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.height = height;
        this.weight = weight;
        history = new History(calorieLimit);
        schedule = new Schedule();
        foodlist = (FoodList)FileIO.deserialize("Admin//foodlist.ser");
        exerciselist = (ExerciseList)FileIO.deserialize("Admin//exerciselist.ser");

        
    }
    /**
     * Constructs a user object Initializes all fields with preset age, height, and weight.
     */
	public User() {
		this.username = "Unknown";
		this.name = "Unknown";
		this.gender = "Unknown";
		this.age = 18;
		this.height = 66;  //5ft 6in
		this.weight = 200; //200 lbs
	}
	
	/**
	 * Standard getter for the username field
	 * @return
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * standard setter for the username field
	 * @param username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * standard getter for the name field
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * Standard setter for the name field
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Standard getter for the gender field
	 * @return
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * Standard setter for the gender field
	 * @param gender
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * Standard getter for the age field
	 * @return
	 */
	public int getAge() {
		return age;
	}

	/**
	 * Standard setter for the age field
	 * @param age
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * Standard getter for the height field
	 * @return
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * Standard setter for the height field
	 * @param height
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * Standard getter for the weight field
	 * @return
	 */
	public int getWeight() {
		return weight;
	}

	/**
	 * Standard setter for the weight field
	 * @param weight
	 */
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	/**
	 * Standard getter for the history field
	 * @return
	 */
	public History getHistory() {
		return this.history;
	}
	
	/**
	 * Standard setter for the history field
	 * @param history
	 */
	public void setHistory(History history) {
		this.history = history;
	}
	
	/**
	 * Changes the day of the log. If the log is already on the current day then nothing happens
	 */
	public void changeday() {
		this.history.logDate();
		
	}
	
	/**
	 * Changes the calorieLimit for future DailyLogs
	 * @param calorieLimit
	 */
	public void setCalorieLimit(int calorieLimit) {
		this.history.setCalorieLimit(calorieLimit);
		
	}
	
	/**
	 * Add a new exercise to the schedule
	 * @param exercise Exercise to schedule
	 * @param times Times of activity
	 */
	public void addToSchedule(Exercise exercise, LocalTime[] times) {
		schedule.addToSchedule(exercise, times);
		
	}
	
	/**
	 * Generic getter
	 * @return foodlist
	 */
	public FoodList getFoodList() {
		return this.foodlist;
	}
	
	/**
	 * Generic setter
	 * @param newFoodList New food list
	 */
	public void setFoodList(FoodList newFoodList) {
		
	}
		
	/**
	 * Generic getter
	 * @return exerciselist
	 */
	public ExerciseList getExerciseList() {
		return this.exerciselist;
	}
	
	/**
	 * Generic setter
	 * @param newExerciseList
	 */
	public void setExerciseList(ExerciseList newExerciseList) {
		
	}
	
	/**
	 * Generic getter
	 * @return schedule
	 */
	public Schedule getSchedule() {
		return this.schedule;
	}
	
	/**
	 * Generic setter
	 * @param scheduleNew New schedule for user
	 */
	public void setSchedule(Schedule scheduleNew) {
		this.schedule = scheduleNew;
	}



}
