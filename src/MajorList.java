package src;

import java.util.ArrayList;

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

}
