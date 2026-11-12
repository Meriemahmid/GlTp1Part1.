
import java.util.List;
import java.util.ArrayList;

public class StudentAccount {

    // StudentAccount attributes
    private String id;
    private String fullName;
    private String email;
    private String phone;
    private String level;
    private String major;
    private boolean scholarship;
    private List<String> courses;

    // Private constructor
    private StudentAccount(Builder builder) {

        this.id = builder.id;
        this.fullName = builder.fullName;
        this.email = builder.email;
        this.phone = builder.phone;
        this.level = builder.level;
        this.major = builder.major;
        this.scholarship = builder.scholarship;
        this.courses = new ArrayList<>(builder.courses);

        validate();
    }

    // Validate mandatory attributes
    private void validate() {

        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("ID is required");
        }

        if (fullName == null || fullName.isEmpty()) {
            throw new IllegalArgumentException("Name is required");
        }

        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("Invalid email");
        }
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getLevel() {
        return level;
    }

    public String getMajor() {
        return major;
    }

    public boolean isScholarship() {
        return scholarship;
    }

    public List<String> getCourses() {
        return new ArrayList<>(courses);
    }

    // =========================
    // Builder Pattern
    // =========================
    public static class Builder {

        private String id;
        private String fullName;
        private String email;

        private String phone = null;
        private String level = "L1";
        private String major = null;
        private boolean scholarship = false;
        private List<String> courses = new ArrayList<>();

        // Required attributes
        public Builder(String id, String fullName, String email) {
            this.id = id;
            this.fullName = fullName;
            this.email = email;
        }

        // Optional attributes
        public Builder setPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder setLevel(String level) {

            if (!List.of("L1", "L2", "L3", "M1", "M2")
                      .contains(level)) {
                throw new IllegalArgumentException("Invalid level");
            }

            this.level = level;
            return this;
        }

        public Builder setMajor(String major) {
            this.major = major;
            return this;
        }

        public Builder setScholarship(boolean scholarship) {
            this.scholarship = scholarship;
            return this;
        }

        public Builder setCourses(List<String> courses) {
            this.courses = new ArrayList<>(courses);
            return this;
        }

        // Build the StudentAccount object
        public StudentAccount build() {
            return new StudentAccount(this);
        }
    }
}
