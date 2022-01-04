package ru.mysait.dto;

import lombok.*;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
public class UserWithAllDto {

  private Long idUserProjectCard;
  private String nameProject;
  private String nameCustomer;
  private String firstTypeName;



}