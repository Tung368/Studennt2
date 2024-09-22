package student2;

import java.util.Date;

class Student extends Person implements IPerson {
    private float gpa;
    private String major;
    private double tuition;
    private boolean scholarship;

    private static final double BASE_TUITION = 10000000;

    public Student(String id, String fullName, Date dateOfBirth, float gpa, String major) {
        super(id, fullName, dateOfBirth);
        this.gpa = gpa;
        this.major = major;
        this.scholarship = gpa >= 9;
        this.tuition = calculateTuition();
    }

    public float getGpa() {
        return gpa;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
        this.scholarship = gpa >= 9;
        this.tuition = calculateTuition();
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public boolean isScholarship() {
        return scholarship;
    }

    public double getTuition() {
        return tuition;
    }

    public double calculateTuition() {
        if (scholarship) {
            return BASE_TUITION * 0.5;
        }
        return BASE_TUITION;
    }

    @Override
    public void displayInfo() {
        System.out.println("ID: " + getId());
        System.out.println("Full Name: " + getFullName());
        System.out.println("Date of Birth: " + getDateOfBirth());
        System.out.println("GPA: " + gpa);
        System.out.println("Major: " + major);
        System.out.println("Scholarship: " + (scholarship ? "Yes" : "No"));
        System.out.println("Tuition: " + tuition);
    }
}
