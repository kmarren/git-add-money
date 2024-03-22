package src;

import java.util.ArrayList;
import java.util.UUID;

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

    public ArrayList<Major> getMajors() {
        return majors;
    }

    public Major getMajorID(String majorID) {
        for (Major major : majors) {
            if (major.getMajorID().equals(majorID)) {
                return major;
            }
        }
        return null;
    }

    public void addMajor(Major major) {
        majors.add(major);
    }

    public void removeMajor(String UUID) {
        for (Major major : majors) {
            if (major.getMajorID().equals(UUID)) {
                majors.remove(major);
            }
        }
    }

    public void loadAll() {
        DataLoader.finishMajors(majors);
    }

    public void clear() {
        majors.clear();
    }

}
