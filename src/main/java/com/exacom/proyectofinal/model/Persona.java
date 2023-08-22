package com.exacom.proyectofinal.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "personas")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "nombres", length = 64, nullable = false)
    private String nombres;
    @Column(name = "apellidos", length = 64, nullable = false)
    private String apellidos;
    @Column(name = "email", length = 128, nullable = false)
    private String email;

    @ManyToMany
    @JoinTable(name = "personas_roles",
            joinColumns = @JoinColumn(name = "id_persona", referencedColumnName = "id",
                    foreignKey = @ForeignKey(name = "FK_personas_roles_persona_id")),
            inverseJoinColumns = @JoinColumn(name = "id_rol", referencedColumnName = "id"),
    foreignKey = @ForeignKey(name = "FK_persona_roles_roles_id"))
    @ToString.Exclude
    private List<Rol> roles;
}
