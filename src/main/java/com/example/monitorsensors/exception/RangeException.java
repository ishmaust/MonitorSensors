package com.example.monitorsensors.exception;

import com.example.monitorsensors.DTO.RangeDto;

public class RangeException extends RuntimeException{

  public RangeException(RangeDto rangeDto) {
    super(String.format("The value TO(%d) should be large then FROM(%d)", rangeDto.getTo(), rangeDto.getFrom()));
  }

}
