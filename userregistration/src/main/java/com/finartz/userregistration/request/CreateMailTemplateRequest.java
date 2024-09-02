package com.finartz.userregistration.request;

<<<<<<< HEAD
import jakarta.validation.constraints.NotEmpty;
=======
>>>>>>> f1ecd8a24c78ec869c261e6f5d7c7de6f84ceec7
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
<<<<<<< HEAD
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class CreateMailTemplateRequest
{
    @NotEmpty
    private String title;
    private String description;
    private boolean updateAllActiveEvaluations;


}


=======

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateMailTemplateRequest {
    private String title;
    private String description;
}
>>>>>>> f1ecd8a24c78ec869c261e6f5d7c7de6f84ceec7
