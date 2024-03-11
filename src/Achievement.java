package src;

import java.util.UUID;

/**
 * class to represent an achievement for students
 * 
 * @author Jacob Robertson
 */
public class Achievement {
    private UUID achievementID;
    private String name;
    private String type;
    private String benefits;
    private String semester;
    private String description;
    private boolean scholarship;

    /**
     * Constructs a new Achievement object with the specified attributes.
     *
     * @param name        The name of the achievement.
     * @param type        The type of the achievement.
     * @param benefits    The benefits associated with the achievement.
     * @param semester    The semester in which the achievement was earned.
     * @param description A description of the achievement.
     * @param scholarship A boolean of whether or not this is a scholarship
     */
    public Achievement(String name, String type, String benefits, String semester, String description,
            Boolean scholarship) {
        this();
        this.name = name;
        this.type = type;
        this.benefits = benefits;
        this.semester = semester;
        this.description = description;
        this.scholarship = scholarship;
    }

    public Achievement() {
        this.achievementID = UUID.randomUUID();
    }

    /**
     * Returns the unique ID of the achievement.
     *
     * @return The unique ID of the achievement.
     */
    public UUID getAchievementID() {
        return achievementID;
    }

    /**
     * Sets the unique ID of the achievement.
     *
     * @param achievementID The unique ID to be set for the achievement.
     */
    public void setAchievementID(UUID achievementID) {
        this.achievementID = achievementID;
    }

    /**
     * Returns the name of the achievement.
     *
     * @return The name of the achievement.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the achievement.
     *
     * @param name The name to be set for the achievement.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the type of the achievement.
     *
     * @return The type of the achievement.
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the type of the achievement.
     *
     * @param type The type to be set for the achievement.
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Returns the benefits associated with the achievement.
     *
     * @return The benefits associated with the achievement.
     */
    public String getBenefits() {
        return benefits;
    }

    /**
     * Sets the benefits associated with the achievement.
     *
     * @param benefits The benefits to be set for the achievement.
     */
    public void setBenefits(String benefits) {
        this.benefits = benefits;
    }

    /**
     * Returns the semester in which the achievement was earned.
     *
     * @return The semester in which the achievement was earned.
     */
    public String getSemester() {
        return semester;
    }

    /**
     * Sets the semester in which the achievement was earned.
     *
     * @param semester The semester to be set for the achievement.
     */
    public void setSemester(String semester) {
        this.semester = semester;
    }

    /**
     * Returns the description of the achievement.
     *
     * @return The description of the achievement.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the achievement.
     *
     * @param description The description to be set for the achievement.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Checks if the achievement offers a scholarship.
     *
     * @return True if the achievement offers a scholarship, otherwise false.
     */
    public boolean hasScholarship() {
        return scholarship;
    }

    /**
     * Sets whether the achievement offers a scholarship.
     *
     * @param scholarship True if the achievement offers a scholarship, otherwise
     *                    false.
     */
    public void setScholarship(boolean scholarship) {
        this.scholarship = scholarship;
    }
}
