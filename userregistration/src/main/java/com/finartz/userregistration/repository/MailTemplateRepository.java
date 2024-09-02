package com.finartz.userregistration.repository;

<<<<<<< HEAD
import com.finartz.userregistration.entity.MailTemplate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MailTemplateRepository extends JpaRepository<MailTemplate,Long> {
    MailTemplate findByid(Long id);
    MailTemplate getByTitle(String title);
    MailTemplate getBydescription(String description);
=======
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.finartz.userregistration.entity.MailTemplate;

@Repository
public interface MailTemplateRepository extends JpaRepository<MailTemplate, Long>{
    
>>>>>>> f1ecd8a24c78ec869c261e6f5d7c7de6f84ceec7
}
