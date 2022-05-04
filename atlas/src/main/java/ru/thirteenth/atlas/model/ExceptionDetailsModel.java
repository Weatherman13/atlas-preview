package ru.thirteenth.atlas.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ExceptionDetailsModel {
    public String timestamp;
    public String message;
    public Integer status;


}
