package testing;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

// import src.DataLoader;
import src.Major;
import src.MajorList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.After;
import org.junit.Before;

public class MajorListTest {

    private String realMajorID = "570e08ee-787a-4e2d-bba8-6ebfe74555e6";
    private Major realMajor = MajorList.getInstance().getMajorID(realMajorID);

    @BeforeClass
    public static void oneTimeSetup() {
        // one-time initialization code
    }

    @AfterClass
    public static void oneTimeTearDown() {
        // one-time cleanup code
    }

    @Before
    public void setUp() {
        // initialization code; invoked for each test method
    }

    @After
    public void tearDown() {
        // cleanup code; invoked for each test method
    }

    @Test
    public void testValidInput() {
        assertEquals(realMajor, MajorList.getInstance().getMajorID(realMajorID));
    }

    @Test
    public void testInvalidInput() {
        String testID = "570e08ee-787a-4e2d-bba8";
        Major badMajor = MajorList.getInstance().getMajorID(testID);
        assertEquals(badMajor, null);
    }

    @Test
    public void testEmptyInput() {
        String testID = "";
        Major badMajor = MajorList.getInstance().getMajorID(testID);
        assertEquals(badMajor, null);
    }

    @Test
    public void testNullInput() {
        Major badMajor = MajorList.getInstance().getMajorID(null);
        assertEquals(badMajor, null);
    }

    @Test
    public void testInvalidInput2() {
        String testID = "570e08ee-787a-4e2d-bba8-6ebfe74555e";
        Major badMajor = MajorList.getInstance().getMajorID(testID);
        assertEquals(badMajor, null);
    }

    @Test
    public void testInvalidCaseSensitivty() {
        String testID = "570E08ee-787a-4e2d-bba8-6ebfe74555e6";
        Major badMajor = MajorList.getInstance().getMajorID(testID);
        assertEquals(badMajor, null);
    }

    @Test
    public void testGoodAdd() {
        Major testMake = new Major();
        String thisMajorID = testMake.getMajorID();
        MajorList.getInstance().addMajor(testMake);
        assertEquals(testMake, MajorList.getInstance().getMajorID(thisMajorID));
    }

    @Test
    public void testBadAdd() {
        Major testMake = new Major();
        testMake.setMajorID(UUID.fromString(realMajorID));
        MajorList.getInstance().addMajor(testMake);
        assertEquals(testMake, MajorList.getInstance().getMajorID(realMajorID));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddNullMajor() {
        MajorList.getInstance().addMajor(null);
    }

    @Test
    public void testGetMajors() {
        MajorList.getInstance().clear(); // Clearing the list before testing
        Major testMajor1 = new Major();
        Major testMajor2 = new Major();
        MajorList.getInstance().addMajor(testMajor1);
        MajorList.getInstance().addMajor(testMajor2);
        ArrayList<Major> allMajors = MajorList.getInstance().getMajors();
        assertEquals(2, allMajors.size());
        assertTrue(allMajors.contains(testMajor1));
        assertTrue(allMajors.contains(testMajor2));
    }

    @Test
    public void testRemoveMajor() {
        int sizeMajors = MajorList.getInstance().getMajors().size();
        MajorList.getInstance().removeMajor("notarealid");
        assertEquals(sizeMajors, MajorList.getInstance().getMajors().size());
    }

    @Test
    public void testRemoveNullMajor() {
        int sizeMajors = MajorList.getInstance().getMajors().size();
        MajorList.getInstance().removeMajor(null);
        assertEquals(sizeMajors, MajorList.getInstance().getMajors().size());
    }

    @Test
    public void testRemoveFromEmptyList() {
        MajorList.getInstance().clear();
        MajorList.getInstance().removeMajor(realMajorID);
        assertEquals(0, MajorList.getInstance().getMajors().size());
    }

    @Test
    public void testRemoveMajorReal() {
        int sizeMajors = MajorList.getInstance().getMajors().size();
        MajorList.getInstance().removeMajor(realMajorID);
        assertEquals(sizeMajors - 1, MajorList.getInstance().getMajors().size());
    }
}
