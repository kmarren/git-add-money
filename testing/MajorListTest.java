package testing;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

// import src.DataLoader;
import src.Major;
import src.MajorList;

import static org.junit.Assert.assertEquals;

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

}
