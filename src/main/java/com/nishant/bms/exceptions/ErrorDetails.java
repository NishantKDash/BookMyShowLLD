package com.nishant.bms.exceptions;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class ErrorDetails {
	
	private LocalDate timeStamp;
	private String messsage;

}
