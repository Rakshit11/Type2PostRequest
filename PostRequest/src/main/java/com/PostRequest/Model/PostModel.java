package com.PostRequest.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.PostRequest.Enum.TransferType;

import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@Data
@NoArgsConstructor
public class PostModel {

		@Id
	private String id;
	private TransferType stateCode;
	private String vin;
	private TransferType Enum;
	public PostModel(String stateCode, String vin, TransferType Enum) {
		this.Enum=Enum;
		this.stateCode=TransferType.FLEET_SALVAGE;
		this.vin=vin;
	}
}
