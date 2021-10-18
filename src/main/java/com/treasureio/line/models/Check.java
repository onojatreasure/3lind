package com.treasureio.line.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "checks", schema = "public")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Check {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long checkId;
    private String student1 ;
    private String student1Text;
    private String student2;
    private String student2Text;
    private Long checkScore;
}

