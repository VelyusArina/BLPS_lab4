package ru.artemiyandarina.blps_lab4.exceptions;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class NotFoundException extends Error {
    private Object entityId;
    private String entityName;
}

