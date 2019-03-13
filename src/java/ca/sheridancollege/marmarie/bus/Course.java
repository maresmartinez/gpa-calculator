/* Taken from https://pastebin.com/raw/qJyUptCn */

package ca.sheridancollege.marmarie.bus;

public class Course {

    private String code = "";
    private double credits = 3.0;
    private double grade = 50.0;

    /**
     * Constructs a default course with no name, 3 credits, and a grade of 50%.
     */
    public Course() {
    }

    /**
     * Constructs a course with a specific code, credit value, and final grade.
     * Credit value must be between 1 and 9 inclusive, and final grade must be
     * greater than 0.
     *
     * @param code the course code
     * @param credits the credit value
     * @param grade the final grade
     * @throws IllegalArgumentException if the credit value or grade is invalid
     */
    public Course(String code, double credits, double grade) {
        init(code, credits, grade);
    }

    // init this course object with specific values
    private void init(String code, double credits, double grade) {
        setCode(code);
        setCredits(credits);
        setGrade(grade);
    }

    /**
     * Places a valid course code into this course's code member. The course
     * code must start with 4 digits, followed by 5 letters.
     *
     * @param code the programmer-specified course code
     */
    public void setCode(String code) {

        // null object or empty string
        if (code == null || code.trim().isEmpty()) {
            throw new IllegalArgumentException("Course code can't be empty.");
        }

        // must match the pattern: 4 digits, 5 letters
        if (code.matches("^[a-zA-Z]{4}\\d{5}$")) {
            this.code = new String(code.toUpperCase());
        } else {  // invalid pattern for code
            throw new IllegalArgumentException("Course code must be "
                    + "4 letters followed by 9 digits");
        }
    }

    /**
     * Retrieves the course code for this course.
     *
     * @return this course's code
     */
    public String getCode() {
        return new String(code);
    }

    /**
     * Place a valid credit value into this course's credits member. Credit
     * value must be between 1 and 9 inclusive.
     *
     * @param credits the programmer-specified credit value
     * @throws IllegalArgumentException if the credit value is invalid
     */
    public void setCredits(double credits) {

        // must be valid to be set
        if (credits >= 1.0 && credits <= 9.0) {
            this.credits = credits;
        } else { // invalid
            throw new IllegalArgumentException("Credits must be between "
                    + "1 and 9.");
        }
    }

    /**
     * Retrieves this course's credit value.
     *
     * @return the credit value for this course
     */
    public double getCredits() {
        return credits;
    }

    /**
     * Places a valid final grade into this course's grade member. The final
     * grade must be greater than 0, otherwise an exception is thrown.
     *
     * @param grade the programmer-specified final grade
     * @throws IllegalArgumentException if the grade is invalid
     */
    public void setGrade(double grade) {
        if (grade >= 0) {
            this.grade = grade;
        } else {
            throw new IllegalArgumentException("Grade must be greater than 0.");
        }
    }

    /**
     * Retrieve the final grade for this course.
     *
     * @return this course's final grade
     */
    public double getGrade() {
        return grade;
    }

    /**
     * Retrieves the weight this course contributes to calculating the GPA.
     *
     * @return the weight for this course
     */
    public double getWeight() {
        return getGradePoints() * credits;
    }

    /**
     * Retrieves the grade points for this course.
     *
     * @return this course's earned grade points
     */
    public double getGradePoints() {

        if (grade >= 90) {
            return 4.0;
        } else if (grade >= 85) {
            return 3.8;
        } else if (grade >= 80) {
            return 3.6;
        } else if (grade >= 75) {
            return 3.3;
        } else if (grade >= 70) {
            return 3.0;
        } else if (grade >= 65) {
            return 2.5;
        } else if (grade >= 60) {
            return 2.0;
        } else if (grade >= 55) {
            return 1.5;
        } else if (grade >= 50) {
            return 1.0;
        } else {
            return 0;
        }

    }

    /**
     * Returns a String representation of this course object. This comes in the
     * format:
     * <pre>c.c courseCode gg.g</pre> Where c.c = the credit value<br>
     * courseCode = the course code<br>
     * gg. = the final grade
     */
    public String toString() {
        return String.format("%3.1f %s: %6.2f", credits, code, grade);
    }
}
