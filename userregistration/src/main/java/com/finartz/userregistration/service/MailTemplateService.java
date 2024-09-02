package com.finartz.userregistration.service;

<<<<<<< HEAD
import com.finartz.userregistration.Result.Result;
import com.finartz.userregistration.request.CreateMailTemplateRequest;
import com.finartz.userregistration.request.DeleteMailTemplateRequest;
import com.finartz.userregistration.request.UpdateMailTemplateRequest;
import com.finartz.userregistration.response.MailTemplateResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface MailTemplateService {
    ResponseEntity<MailTemplateResponse> add(CreateMailTemplateRequest createTemplateMailRequest);
    Result delete(DeleteMailTemplateRequest deleteTempMailRequest);
    ResponseEntity<MailTemplateResponse> update(UpdateMailTemplateRequest updateTemplateMailRequest);
    ResponseEntity<MailTemplateResponse> getByid(Long id);
    ResponseEntity<List<MailTemplateResponse>> getAll();
}
=======
import com.finartz.userregistration.entity.MailTemplate;
import com.finartz.userregistration.request.CreateMailTemplateRequest;

public interface MailTemplateService {
    MailTemplate createMailTemplate(CreateMailTemplateRequest mailTemplateRequest);
}
>>>>>>> f1ecd8a24c78ec869c261e6f5d7c7de6f84ceec7
