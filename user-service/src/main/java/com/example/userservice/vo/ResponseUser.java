package com.example.userservice.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)

public class ResponseUser {
    private String id;
    private String email;
    private String name;
    private String pwd;

    private List<ResponseOrder> orders;
}
