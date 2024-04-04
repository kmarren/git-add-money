package src;

import java.util.ArrayList;
import java.util.UUID;

/**
 * @author jacob robertson
 */
public class MajorList {
    private static MajorList majorList;
    private ArrayList<Major> majors;

    // Private constructor to restrict instantiation from outside
    private MajorList() {
        majors = new ArrayList<>();
        ArrayList<Major> mjr = DataLoader.loadMajors();
        majors.addAll(mjr);
    }

    // Method to get the instance of MajorList
    public static MajorList getInstance() {
        if (majorList == null) {
            majorList = new MajorList();
        }
        return majorList;
    }

    // returns the arraylist of majors
    public ArrayList<Major> getMajors() {
        return majors;
    }

    // returns the major with the given UUID using a string
    public Major getMajorID(String majorID) {
        if (majorID != null) {
            for (Major major : majors) {
                if (major.getMajorID().equals(majorID)) {
                    return major;
                }
            }
        }
        return null;
    }

    // returns the major with the given UUID
    public Major getMajorID(UUID majorID) {
        if (majorID != null && majorID instanceof UUID) {
            for (Major major : majors) {
                if (UUID.fromString(major.getMajorID()).equals(majorID)) {
                    return major;
                }
            }
        }
        return null;
    }

    // adds a major to the list
    public void addMajor(Major major) {
        if (major instanceof Major && major != null) {
            majors.add(major);
        }
    }

    // removes a major from the list based on a given UUID string
    public void removeMajor(String uuid) {
        if (uuid != null) {
            for (Major major : majors) {
                if (major.getMajorID().equals(uuid)) {
                    majors.remove(major);
                }
            }
        }
    }

    // removes a major based on the UUID object
    public void removeMajor(UUID uuid) {
        if (uuid != null && uuid instanceof UUID) {
            for (Major major : majors) {
                if (UUID.fromString(major.getMajorID()).equals(uuid)) {
                    majors.remove(major);
                }
            }
        }
    }

    // finishes and loads all the majors
    public void loadAll() {
        DataLoader.finishMajors(majors);
    }

    // clears the major list
    public void clear() {
        majors.clear();
    }

}
