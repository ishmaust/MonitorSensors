package com.example.monitorsensors.DTO;

import javax.validation.constraints.NotNull;

public class RangeDto {
  @NotNull
  private int from;

  @NotNull
  private int to;

  public int getFrom() {
    return from;
  }

  public void setFrom(int from) {
    this.from = from;
  }

  public int getTo() {
    return to;
  }

  public void setTo(int to) {
    this.to = to;
  }

  public boolean rangeValid() {
    return to > from;
  }
}
