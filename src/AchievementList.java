package src;

import java.util.ArrayList;
import java.util.UUID;

public class AchievementList {
    private static AchievementList instance;
    private ArrayList<Achievement> achievements;

    private AchievementList() {
        achievements = new ArrayList<>();
        ArrayList<Achievement> ach = DataLoader.loadAchievements();
        achievements.addAll(ach);

    }

    public static AchievementList getInstance() {
        if (instance == null) {
            instance = new AchievementList();
        }
        return instance;
    }

    // adds an achievement to the list
    public void addAchievement(Achievement achievement) {
        if (achievement != null && achievement instanceof Achievement) {
            achievements.add(achievement);
        }
    }

    public void removeAchievement(UUID uuid) {
        if (uuid != null && uuid instanceof UUID) {
            for (Achievement achievement : achievements) {
                if (achievement.getAchievementID().equals(uuid)) {
                    achievements.remove(achievement);
                }
            }
        }
    }

    public void removeAchievement(String uuid) {
        if (uuid != null) {
            for (Achievement achievement : achievements) {
                if (achievement.getAchievementID().equals(UUID.fromString(uuid))) {
                    achievements.remove(achievement);
                }
            }
        }
    }

    public Achievement getAchievement(UUID uuid) {
        if (uuid != null && uuid instanceof UUID)
            for (Achievement achievement : achievements) {
                if (achievement.getAchievementID().equals(uuid)) {
                    return achievement;
                }
            }
        return null;
    }

    public Achievement getAchievement(String uuid) {
        for (Achievement achievement : achievements) {
            if (achievement.getAchievementID().equals(uuid)) {
                return achievement;
            }
        }
        return null;
    }

    public ArrayList<Achievement> getAchievements() {
        return achievements;
    }

    public void clear() {
        achievements.clear();
    }
}
