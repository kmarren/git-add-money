package testing;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import src.Achievement;
import src.AchievementList;
import java.util.ArrayList;
import java.util.UUID;

import static org.junit.Assert.*;

public class AchievementListTest {
    private AchievementList achievementList;
    private Achievement achievement1;

    @Before
    public void setUp() {
        achievementList = AchievementList.getInstance();
        achievement1 = achievementList.getAchievement(UUID.fromString("ee7308d8-18d9-4a39-8b79-eb6a12345678"));
    }

    @After
    public void tearDown() {
        achievementList.clear();
    }

    @Test
    public void testGetInstance() {
        AchievementList newInstance = AchievementList.getInstance();
        assertSame(achievementList, newInstance);
    }

    @Test
    public void testGetAchievements() {
        ArrayList<Achievement> achievements = achievementList.getAchievements();
        assertFalse(achievements.isEmpty());
    }

    @Test
    public void testGetAchievementByUUID() {
        assertNotNull(achievementList.getAchievement(achievement1.getAchievementID()));
    }

    @Test
    public void testGetAchievementByUUIDWithNonExistingUUID() {
        assertNull(achievementList.getAchievement(UUID.randomUUID()));
    }

    @Test
    public void testGetAchievementByUUIDWithNullUUID() {
        assertNull(achievementList.getAchievement(null));
    }

    @Test
    public void testAddAchievement() {
        int sizeBefore = achievementList.getAchievements().size();
        Achievement newAchievement = new Achievement();
        achievementList.addAchievement(newAchievement);
        int sizeAfter = achievementList.getAchievements().size();
        assertEquals(sizeBefore + 1, sizeAfter);
        assertTrue(achievementList.getAchievements().contains(newAchievement));
    }

    @Test
    public void testRemoveAchievement() {
        int sizeBefore = achievementList.getAchievements().size();
        achievementList.removeAchievement(achievement1.getAchievementID());
        int sizeAfter = achievementList.getAchievements().size();
        assertEquals(sizeBefore - 1, sizeAfter);
        assertNull(achievementList.getAchievement(achievement1.getAchievementID()));
    }

    @Test
    public void testRemoveNonExistingAchievement() {
        int sizeBefore = achievementList.getAchievements().size();
        achievementList.removeAchievement(UUID.randomUUID());
        int sizeAfter = achievementList.getAchievements().size();
        assertEquals(sizeBefore, sizeAfter);
    }

    @Test
    public void testClear() {
        achievementList.clear();
        assertTrue(achievementList.getAchievements().isEmpty());
    }

    // known issue
    @Test
    public void testAddNullAchievement() {
        int sizeBefore = achievementList.getAchievements().size();
        achievementList.addAchievement(null);
        int sizeAfter = achievementList.getAchievements().size();
        assertEquals(sizeBefore, sizeAfter);
    }

    @Test
    public void testRemoveNullAchievement() {
        int sizeBefore = achievementList.getAchievements().size();
        achievementList.removeAchievement(null);
        int sizeAfter = achievementList.getAchievements().size();
        assertEquals(sizeBefore, sizeAfter);
    }

    @Test
    public void testGetAchievementWithEmptyList() {
        achievementList.clear();
        assertNull(achievementList.getAchievement(UUID.randomUUID()));
    }

    @Test
    public void testGetAchievementsWithEmptyList() {
        achievementList.clear();
        assertTrue(achievementList.getAchievements().isEmpty());
    }

    @Test
    public void testClearEmptyList() {
        achievementList.clear();
        assertTrue(achievementList.getAchievements().isEmpty());
    }

}
