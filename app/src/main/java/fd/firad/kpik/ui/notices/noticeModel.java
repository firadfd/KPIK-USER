package fd.firad.kpik.ui.notices;

import java.util.ArrayList;

public class noticeModel {
    private String title, date, time, key;
    ArrayList<String> imgUrl = new ArrayList<>();

    public noticeModel(String title, String date, String time, String key, ArrayList<String> imgUrl) {
        this.title = title;
        this.date = date;
        this.time = time;
        this.key = key;
        this.imgUrl = imgUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public ArrayList<String> getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(ArrayList<String> imgUrl) {
        this.imgUrl = imgUrl;
    }

    public noticeModel() {
    }
}
