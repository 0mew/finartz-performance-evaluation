package com.finartz.userregistration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finartz.userregistration.entity.MailTemplate;
import com.finartz.userregistration.request.CreateMailTemplateRequest;
import com.finartz.userregistration.service.MailTemplateService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/mail-template")
public class MailTemplateController {
    @Autowired
    private MailTemplateService mailTemplateService;

    @PostMapping
    public ResponseEntity<MailTemplate> createMailTemplate(@RequestBody CreateMailTemplateRequest request) {
        return ResponseEntity.ok(mailTemplateService.createMailTemplate(request));
    }
}
