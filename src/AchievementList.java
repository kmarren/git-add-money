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

    public void addAchievement(Achievement achievement) {
        achievements.add(achievement);
    }

    public void removeAchievement(UUID uuid) {
        for (Achievement achievement : achievements) {
            if (achievement.getAchievementID().equals(uuid)) {
                achievements.remove(achievement);
            }
        }
    }

    public Achievement getAchievement(UUID uuid) {
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
