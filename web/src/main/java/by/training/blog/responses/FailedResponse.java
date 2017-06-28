package by.training.blog.responses;

/**
 * Created by Win on 26.06.2017.
 */
public class FailedResponse {
    private String massage;
    private String status;

    public FailedResponse(String massage, String status) {
        this.massage = massage;
        this.status = status;
    }

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
