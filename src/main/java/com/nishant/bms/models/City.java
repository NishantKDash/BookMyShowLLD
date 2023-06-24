package com.nishant.bms.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class City extends BaseModel{
   private String name;
   @OneToMany(fetch = FetchType.EAGER)
   private List<Theatre> theatres;
}
