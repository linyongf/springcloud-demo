package com.springcloud.api.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class Dept implements Serializable {
  private Long id;
  private String name;
  private String source;
}
