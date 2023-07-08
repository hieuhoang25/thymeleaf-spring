package com.hicode.thymeleafspring.model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OStudent {
    @NotBlank(message = "Khong de trong ho va ten")
    @Email(message = "Email khong dung dinh dang")
    private String email;
    @NotBlank(message = "Khong de trong ho va ten")
    private String fullname;
    @NotNull(message = "Khong de trong diem")
    @PositiveOrZero(message = "Diem phai lon hon 0")
    @Max(message = "Diem lon hon hoac bang 10", value = 10)
    private Double marks;
    @NotNull(message = "chon gioi tinh")
    private Boolean gender;
    @NotBlank(message = "Chon quoc tich")
    private String country;
}
