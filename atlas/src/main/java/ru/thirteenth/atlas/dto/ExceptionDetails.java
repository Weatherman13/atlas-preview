package ru.thirteenth.atlas.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ExceptionDetails {
    public String timestamp;
    public String message;
    public Integer status;


}
