package com.reward.api.dataprovider.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Builder
@Data
@Entity
@Table(name = "CUSTOMER")
@NoArgsConstructor
@AllArgsConstructor
public class CustomerEntity {

    @Id
    private UUID id;
    private String name;
    private String cpf;
    private String email;
    private String dateBirth;
    private Integer currentScore;

}
