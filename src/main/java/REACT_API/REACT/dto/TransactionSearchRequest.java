package REACT_API.REACT.dto;


public class TransactionSearchRequest {

    private String transactionId;
    private String paymentId;
    private String bankRefNo;
    private String gsnNo;
    private String registrationNo;

    // Default Constructor
    public TransactionSearchRequest() {
    }

    // Getters and Setters

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getBankRefNo() {
        return bankRefNo;
    }

    public void setBankRefNo(String bankRefNo) {
        this.bankRefNo = bankRefNo;
    }

    public String getGsnNo() {
        return gsnNo;
    }

    public void setGsnNo(String gsnNo) {
        this.gsnNo = gsnNo;
    }

    public String getRegistrationNo() {
        return registrationNo;
    }

    public void setRegistrationNo(String registrationNo) {
        this.registrationNo = registrationNo;
    }

    @Override
    public String toString() {
        return "TransactionSearchRequest{" +
                "transactionId='" + transactionId + '\'' +
                ", paymentId='" + paymentId + '\'' +
                ", bankRefNo='" + bankRefNo + '\'' +
                ", gsnNo='" + gsnNo + '\'' +
                ", registrationNo='" + registrationNo + '\'' +
                '}';
    }
}