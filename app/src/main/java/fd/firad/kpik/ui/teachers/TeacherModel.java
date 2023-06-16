package fd.firad.kpik.ui.teachers;

public class TeacherModel {
    String name, number, post, department,shift, key, tecImgUrl;

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

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

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getTecImgUrl() {
        return tecImgUrl;
    }

    public void setTecImgUrl(String tecImgUrl) {
        this.tecImgUrl = tecImgUrl;
    }

    public TeacherModel(String name, String number, String post, String department, String shift, String key, String tecImgUrl) {
        this.name = name;
        this.number = number;
        this.post = post;
        this.department = department;
        this.shift = shift;
        this.key = key;
        this.tecImgUrl = tecImgUrl;
    }

    public TeacherModel() {
    }
}
