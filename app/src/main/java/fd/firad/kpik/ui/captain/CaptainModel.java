package fd.firad.kpik.ui.captain;

public class CaptainModel {
    String name, number, department,semester,group,shift, key;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public CaptainModel(String name, String number, String department, String semester, String group, String shift, String key) {
        this.name = name;
        this.number = number;
        this.department = department;
        this.semester = semester;
        this.group = group;
        this.shift = shift;
        this.key = key;
    }

    public CaptainModel() {
    }
}
