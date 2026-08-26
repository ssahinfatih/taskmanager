package com.fatihsahin.taskmanager.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record TaskRequest (

        @NotBlank(message = "title is mandatory")
        @Size(min = 3, max = 100, message = "title must be between 3 and 100 characters")
        String title,

        @Size(min = 3, max = 500, message = "Description can be up to 500 characters ")
        String description,

        Boolean completed,

        Long categoryId

){

}
