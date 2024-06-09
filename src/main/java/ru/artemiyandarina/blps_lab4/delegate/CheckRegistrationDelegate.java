package ru.artemiyandarina.blps_lab4.delegate;

import org.camunda.bpm.engine.delegate.BpmnError;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component
public class CheckRegistrationDelegate implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String email = (String) delegateExecution.getVariable("user_mail");
        String password = (String) delegateExecution.getVariable("user_password");
        if (email.isBlank() || password.isBlank()) {
            throw new BpmnError("Все поля формы должны быть заполнены.");
        }
    }
}
