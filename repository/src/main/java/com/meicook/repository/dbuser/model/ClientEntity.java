package com.meicook.repository.dbuser.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Client")
public class ClientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "first_name")
    @NotBlank(message = "First name is mandatory")
    @Pattern(regexp = "^[a-zA-Z]*$", message = "invalid name only characters")
    private String fName;

    @Column(name = "last_name")
    @NotBlank(message = "Last Name is mandatory")
    @Pattern(regexp = "^[a-zA-Z]*$", message = "invalid name only characters")
    private String lName;

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<AccountEntity> account;
}
