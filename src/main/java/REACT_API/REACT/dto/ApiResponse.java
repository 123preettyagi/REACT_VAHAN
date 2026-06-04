package REACT_API.REACT.dto;

public class ApiResponse {

    private boolean success;
    private String message;
    private Object data;

    // No-Args Constructor
    public ApiResponse() {
    }

    // All-Args Constructor
    public ApiResponse(boolean success, String message, Object data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    // Constructor with success and message
    public ApiResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    // Getter and Setter for success
    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    // Getter and Setter for message
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    // Getter and Setter for data
    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    // toString()
    @Override
    public String toString() {
        return "ApiResponse{" +
                "success=" + success +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}