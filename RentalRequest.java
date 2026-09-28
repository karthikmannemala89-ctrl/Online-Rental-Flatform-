package com.karthik.rental.dto;

import jakarta.validation.constraints.*;
import java.time.LocalDate;

public class RentalRequest {
    @NotNull
    private Long productId;

    @NotBlank
    private String customerName;

    @Email
    @NotBlank
    private String customerEmail;

    @NotNull
    private LocalDate startDate;

    @NotNull
    private LocalDate endDate;

    public Long getProductId() { return productId; }
    public String getCustomerName() { return customerName; }
    public String getCustomerEmail() { return customerEmail; }
    public LocalDate getStartDate() { return startDate; }
    public LocalDate getEndDate() { return endDate; }

    public void setProductId(Long productId) { this.productId = productId; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }
    public void setCustomerEmail(String customerEmail) { this.customerEmail = customerEmail; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }
    public void setEndDate(LocalDate endDate) { this.endDate = endDate; }
}
