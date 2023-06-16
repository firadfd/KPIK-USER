package fd.firad.kpik.ui.pdfnotice;

public class PdfModel {
    String pdfTitle, downLoadUrl,time,date,uniqueKey;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public PdfModel(String pdfTitle, String downLoadUrl, String time, String date, String uniqueKey) {
        this.pdfTitle = pdfTitle;
        this.downLoadUrl = downLoadUrl;
        this.time = time;
        this.date = date;
        this.uniqueKey = uniqueKey;
    }

    public String getUniqueKey() {
        return uniqueKey;
    }

    public void setUniqueKey(String uniqueKey) {
        this.uniqueKey = uniqueKey;
    }

    public String getPdfTitle() {
        return pdfTitle;
    }

    public void setPdfTitle(String pdfTitle) {
        this.pdfTitle = pdfTitle;
    }

    public String getDownLoadUrl() {
        return downLoadUrl;
    }

    public void setDownLoadUrl(String downLoadUrl) {
        this.downLoadUrl = downLoadUrl;
    }



    public PdfModel() {
    }
}
