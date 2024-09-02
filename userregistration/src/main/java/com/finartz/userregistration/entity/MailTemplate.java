package com.finartz.userregistration.entity;

<<<<<<< HEAD

import jakarta.persistence.*;
=======
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
>>>>>>> f1ecd8a24c78ec869c261e6f5d7c7de6f84ceec7
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

<<<<<<< HEAD
=======

>>>>>>> f1ecd8a24c78ec869c261e6f5d7c7de6f84ceec7
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "mail_template")
public class MailTemplate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
<<<<<<< HEAD
    @Column(name = "Tıtle")
    private String title;

    @NotBlank
    @Column(name = "Description")
    private String description;

    private boolean  updateAllActiveEvaluations;
=======
    private String title;

    @NotBlank
    private String description;  
>>>>>>> f1ecd8a24c78ec869c261e6f5d7c7de6f84ceec7
}
