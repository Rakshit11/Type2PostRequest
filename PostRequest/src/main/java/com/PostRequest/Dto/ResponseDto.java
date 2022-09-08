package com.PostRequest.Dto;

import com.PostRequest.Enum.TransferType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDto {
    private String id;
    private String stateCode;
    private String vin;
    private TransferType Enum;
}