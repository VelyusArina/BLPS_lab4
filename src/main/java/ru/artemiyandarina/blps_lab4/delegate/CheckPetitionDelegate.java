package ru.artemiyandarina.blps_lab4.delegate;

import org.camunda.bpm.engine.delegate.BpmnError;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component
public class CheckPetitionDelegate implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String country = (String) delegateExecution.getVariable("create_petition_country");
        String title = (String) delegateExecution.getVariable("create_petition_title");
        String description = (String) delegateExecution.getVariable("create_petition_description");

        if (country.isBlank() || title.isBlank() || description.isBlank()) {
            throw new BpmnError("Все поля формы должны быть заполнены");
        }
    }
}
