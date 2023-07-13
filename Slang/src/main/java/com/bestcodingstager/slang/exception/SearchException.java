package com.bestcodingstager.slang.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="검색 결과가 없습니다.")
public class SearchException extends RuntimeException{

}
