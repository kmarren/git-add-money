package src;

public abstract class DataConstants {

    // major data constants
    protected static final String MAJOR_FILE_NAME = "data/majors.json";
    protected static final String MAJOR_ID = "majorID";
    protected static final String MAJOR_TITLE = "title";
    protected static final String MAJOR_REQUIRED_COURSES = "requiredCourses";
    protected static final String MAJOR_COURSE_ID = "courseID";
    protected static final String MAJOR_COMPLETED_COURSES = "completedCourses";
    protected static final String MAJOR_HOURS_REQUIRED = "hoursRequired";
    protected static final String MAJOR_HOURS_COMPLETED = "hoursCompleted";
    protected static final String MAJOR_PROGRESSION = "progression";

    // course data constants
    protected static final String COURSE_FILE_NAME = "data/course.json";
    protected static final String COURSE_COMMENTS = "courseComments";
    protected static final String COURSE_NUMBER = "courseNumber";
    protected static final String COURSE_ID = "courseID";
    protected static final String COURSE_CODE = "courseCode";
    protected static final String COURSE_NAME = "courseName";
    protected static final String COURSE_INSTRUCTOR = "instructor";
    protected static final String COURSE_PREREQUISITES = "prerequisites";
    protected static final String COURSE_DESCRIPTION = "description";
    protected static final String COURSE_TOTAL_SEATS = "totalSeats";
    protected static final String COURSE_CREDIT_WORTH = "creditWorth";
    protected static final String COURSE_COREQUISITES = "corequisites";
    protected static final String COURSE_APPLICATION_AREA = "applicationArea";
    protected static final String COURSE_CAROLINA_CORE = "carolinaCore";
    protected static final String COURSE_ELECTIVE = "elective";
    protected static final String COURSE_GRADE = "grade";
    protected static final String COURSE_COMPLETED = "completed";
    protected static final String COURSE_ENROLLED = "enrolled";

    // user data constants
    protected static final String USER_FILE_NAME = "data/user.json";
    protected static final String USER_TYPE = "type";
    protected static final String USER_FIRST_NAME = "firstName";
    protected static final String USER_LAST_NAME = "lastName";
    protected static final String USER_ID = "userID";
    protected static final String USER_EMAIL = "email";
    protected static final String USER_USERNAME = "username";
    protected static final String USER_PASSWORD = "password";

    // faculty data constants
    protected static final String FACULTY_FILE_NAME = "data/faculty.json";
    protected static final String FACULTY_OFFICE_HOURS = "officeHours";
    protected static final String FACULTY_STUDENT_LIST = "studentList";
    protected static final String FACULTY_FIRST_NAME = "firstName";
    protected static final String FACULTY_LAST_NAME = "lastName";
    protected static final String FACULTY_EMAIL = "email";
    protected static final String FACULTY_USERNAME = "username";
    protected static final String FACULTY_PASSWORD = "password";

    // Advisor data constants
    protected static final String ADVISORS_FILE_NAME = "data/advisors.json";
    protected static final String ADVISOR_OFFICE = "office";
    protected static final String ADVISOR_OFFICE_HOURS = "officeHours";
    protected static final String ADVISOR_PHONE_NUMBER = "phoneNumber";
    protected static final String ADVISOR_ADVISEE_LIST = "adviseeList";
    protected static final String ADVISOR_SCHOOL_OF_FOCUS = "schoolOfFocus";
    protected static final String ADVISOR_APPOINTMENTS = "appointments";
    protected static final String ADVISOR_FIRST_NAME = "firstName";
    protected static final String ADVISOR_LAST_NAME = "lastName";
    protected static final String ADVISOR_EMAIL = "email";
    protected static final String ADVISOR_USERNAME = "username";
    protected static final String ADVISOR_PASSWORD = "password";

    // student data constants
    protected static final String STUDENT_FILE_NAME = "data/students.json";
    protected static final String STUDENT_FIRST_NAME = "firstName";
    protected static final String STUDENT_LAST_NAME = "lastName";
    protected static final String STUDENT_EMAIL = "email";
    protected static final String STUDENT_USERNAME = "username";
    protected static final String STUDENT_PASSWORD = "password";
    protected static final String STUDENT_MAJOR = "majorID";
    protected static final String STUDENT_MINOR = "minor";
    protected static final String STUDENT_COMMENTS = "studentComments";
    protected static final String STUDENT_ACHIEVEMENTS = "achievements";
    protected static final String STUDENT_GPA = "gpa";
    protected static final String STUDENT_ENROLLED_COURSES = "enrolledCourses";
    protected static final String STUDENT_ADVISOR = "advisorID";
    protected static final String STUDENT_RISK_FAILING = "riskFailing";
    protected static final String STUDENT_HOURS_COMPLETED = "hoursCompleted";

    // Achievement data constants
    protected static final String ACHIEVEMENT_FILE_NAME = "data/achievement.json";
    protected static final String ACHIEVEMENT_ID = "achievementID";
    protected static final String ACHIEVEMENT_NAME = "name";
    protected static final String ACHIEVEMENT_TYPE = "type";
    protected static final String ACHIEVEMENT_BENEFITS = "benefits";
    protected static final String ACHIEVEMENT_SEMESTER = "semester";
    protected static final String ACHIEVEMENT_DESCRIPTION = "description";
    protected static final String ACHIEVEMENT_SCHOLARSHIP = "scholarship";
}
