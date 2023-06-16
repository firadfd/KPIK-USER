package fd.firad.kpik.ui.departments;

public class DepartmentModel {
    String dptName, dptTeachers, dptSeats, dptLabs, key;

    public String getDptName() {
        return dptName;
    }

    public void setDptName(String dptName) {
        this.dptName = dptName;
    }

    public String getDptTeachers() {
        return dptTeachers;
    }

    public void setDptTeachers(String dptTeachers) {
        this.dptTeachers = dptTeachers;
    }

    public String getDptSeats() {
        return dptSeats;
    }

    public void setDptSeats(String dptSeats) {
        this.dptSeats = dptSeats;
    }

    public String getDptLabs() {
        return dptLabs;
    }

    public void setDptLabs(String dptLabs) {
        this.dptLabs = dptLabs;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public DepartmentModel(String dptName, String dptTeachers, String dptSeats, String dptLabs, String key) {
        this.dptName = dptName;
        this.dptTeachers = dptTeachers;
        this.dptSeats = dptSeats;
        this.dptLabs = dptLabs;
        this.key = key;
    }

    public DepartmentModel() {
    }
}
