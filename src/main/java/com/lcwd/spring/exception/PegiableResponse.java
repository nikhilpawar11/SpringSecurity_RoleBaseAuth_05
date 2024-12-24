package com.lcwd.spring.exception;

import java.util.List;

import com.lcwd.spring.dto.UserDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PegiableResponse {
	
	private List<UserDto> content;
	
	private long totalElements;
	
	private int totalPages;
	
	private int pageNumber;
	
	private int pageSize;
	
	private Boolean isFirst;
	
	private Boolean isLast;
	
	

}
