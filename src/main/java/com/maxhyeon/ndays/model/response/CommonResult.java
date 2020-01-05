package com.maxhyeon.ndays.model.response;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommonResult {

    @Parameter(description =  "응답 성공여부 : true/false")
    private boolean success;

    @Parameter(description =  "응답 코드 번호 : >= 0 정상, < 0 비정상")
    private int code;

    @Parameter(description =  "응답 메시지")
    private String msg;
}