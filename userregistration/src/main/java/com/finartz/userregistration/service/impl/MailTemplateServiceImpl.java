package com.finartz.userregistration.service.impl;

<<<<<<< HEAD
import com.finartz.userregistration.Message.Messages;
import com.finartz.userregistration.Result.Result;
import com.finartz.userregistration.Result.SuccessResult;
import com.finartz.userregistration.entity.MailTemplate;
import com.finartz.userregistration.exception.BusinessException;
import com.finartz.userregistration.repository.MailTemplateRepository;
import com.finartz.userregistration.request.CreateMailTemplateRequest;
import com.finartz.userregistration.request.DeleteMailTemplateRequest;
import com.finartz.userregistration.request.UpdateMailTemplateRequest;
import com.finartz.userregistration.response.MailTemplateResponse;
import com.finartz.userregistration.service.MailTemplateService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MailTemplateServiceImpl implements MailTemplateService {

    @Autowired
    MailTemplateRepository tempMailRepository;


    @Override
    public ResponseEntity<MailTemplateResponse> add(CreateMailTemplateRequest createTemplateMailRequest) {
        checkIfTitle(createTemplateMailRequest.getTitle());
        MailTemplate mailTemplate=MailTemplate.builder()
                .title(createTemplateMailRequest.getTitle())
                .description(createTemplateMailRequest.getDescription())
                .updateAllActiveEvaluations(createTemplateMailRequest.isUpdateAllActiveEvaluations())
                .build();

        this.tempMailRepository.save(mailTemplate);

        MailTemplateResponse tempMailResponse= MailTemplateResponse.builder()
                .id(mailTemplate.getId())
                .title(mailTemplate.getTitle())
                .description(mailTemplate.getDescription())
                .updateAllActiveEvaluations(mailTemplate.isUpdateAllActiveEvaluations())
                .build();

        return ResponseEntity.status(HttpStatus.CREATED).body(tempMailResponse);
    }





    @Override
    public Result delete(DeleteMailTemplateRequest deleteTempMailRequest) {
        checkid(deleteTempMailRequest.getId());
        //exceptionlardan sorna buraya id kontol eklenecek
        MailTemplate mailTemplate=MailTemplate.builder()
                .id(deleteTempMailRequest.getId())
                .build();
        tempMailRepository.delete(mailTemplate);

        return new SuccessResult(Messages.MailTamplateDeleted);
    }

    @Override
    public ResponseEntity<MailTemplateResponse> update(UpdateMailTemplateRequest updateTemplateMailRequest) {
        checkid(updateTemplateMailRequest.getId());
        checkIfTitle(updateTemplateMailRequest.getTitle());

        MailTemplate mailTemplate=MailTemplate.builder()
                .id(updateTemplateMailRequest.getId())
                .title(updateTemplateMailRequest.getTitle())
                .updateAllActiveEvaluations(updateTemplateMailRequest.isUpdateAllActiveEvaluations())
                .description(updateTemplateMailRequest.getDescription())
                .build();


        this.tempMailRepository.save(mailTemplate);
        MailTemplateResponse tempMailResponse= MailTemplateResponse.builder()
                .id(mailTemplate.getId())
                .title(mailTemplate.getTitle())
                .description(mailTemplate.getDescription())
                .updateAllActiveEvaluations(mailTemplate.isUpdateAllActiveEvaluations())
                .build();

        return  ResponseEntity.status(HttpStatus.OK).body(tempMailResponse);
    }

    @Override
    public ResponseEntity<MailTemplateResponse> getByid(Long id) {
        checkid(id);
        MailTemplate mailTemplate=this.tempMailRepository.findByid(id);
        MailTemplateResponse tempMailResponse= MailTemplateResponse.builder()
                .id(mailTemplate.getId())
                .title(mailTemplate.getTitle())
                .description(mailTemplate.getDescription())
                .updateAllActiveEvaluations(mailTemplate.isUpdateAllActiveEvaluations())
                .build();

        return  ResponseEntity.status(HttpStatus.OK).body(tempMailResponse);
    }

    @Override
    public ResponseEntity<List<MailTemplateResponse>> getAll() {
        List<MailTemplate> mailTemplate=tempMailRepository.findAll();
        List<MailTemplateResponse> allTempMailResponse =mailTemplate.stream()
                .map(tempmail-> MailTemplateResponse.builder()
                        .id(tempmail.getId())
                        .description(tempmail.getDescription())
                        .title(tempmail.getTitle())
                        .updateAllActiveEvaluations(tempmail.isUpdateAllActiveEvaluations())
                        .build()).toList();


        return ResponseEntity.status(HttpStatus.OK).body(allTempMailResponse);
    }


    private void checkid(Long id){
        MailTemplate mailTemplate=tempMailRepository.findByid(id);
        if (mailTemplate == null) {
            throw   new BusinessException(Messages.MailTamplateIdNotFound); // burasya bakılacak sonra
        }
    }
    private void checkIfTitle(String Title){
        MailTemplate mailTemplate=this.tempMailRepository.getByTitle(Title);
        if (mailTemplate!=null){
            throw   new BusinessException(Messages.MailTamplateTitleexists);
        }

    }






=======
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finartz.userregistration.entity.MailTemplate;
import com.finartz.userregistration.repository.MailTemplateRepository;
import com.finartz.userregistration.request.CreateMailTemplateRequest;
import com.finartz.userregistration.service.MailTemplateService;

@Service
public class MailTemplateServiceImpl implements MailTemplateService{
    @Autowired
    private MailTemplateRepository mailTemplateRepository;

    @Override
    public MailTemplate createMailTemplate(CreateMailTemplateRequest mailTemplateRequest) {
        var template = MailTemplate.builder()
        .title(mailTemplateRequest.getTitle())
        .description(mailTemplateRequest.getDescription())
        .build();

        mailTemplateRepository.save(template);
        return template;
    }
>>>>>>> f1ecd8a24c78ec869c261e6f5d7c7de6f84ceec7
}
