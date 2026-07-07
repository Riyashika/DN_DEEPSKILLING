package com.cognizant.springlearn.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="country")
@Data
public class CountryModel {
    @Id
    private String code;
    private String name;
}