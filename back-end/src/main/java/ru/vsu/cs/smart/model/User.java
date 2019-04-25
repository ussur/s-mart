package ru.vsu.cs.smart.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Set;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_sequence")
    private Long id;
    @Column
    private String email;
    @OneToOne(mappedBy = "user", fetch= FetchType.EAGER)
    private Preferences preferences;
    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private Set<Filters> savedFilters;
}
