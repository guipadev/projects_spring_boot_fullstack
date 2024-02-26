package com.babydevcode.entitys;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "types")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Type {

    @Id
    @Column(name = "value_id")
    private Long value;

    @Column(name = "meaning")
    private String meaning;

    @Column(name = "type")
    private String type;
}
