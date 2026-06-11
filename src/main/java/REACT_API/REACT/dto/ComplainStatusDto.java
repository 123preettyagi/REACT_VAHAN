package REACT_API.REACT.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class ComplainStatusDto {

    @NotBlank(message = "Request ID is required")
    @Pattern(
        regexp = "^[A-Za-z0-9/]+$",
        message = "Only alphabets, digits and / allowed"
    )
    private String requestId;

    public ComplainStatusDto() {
    }

    public ComplainStatusDto(String requestId) {
        this.requestId = requestId;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }
}