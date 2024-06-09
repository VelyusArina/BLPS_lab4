package ru.artemiyandarina.blps_lab4.delegate;

import org.camunda.bpm.engine.delegate.BpmnError;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.artemiyandarina.blps_lab4.entity.User;
import ru.artemiyandarina.blps_lab4.repository.UserRepository;

@Component
public class LoginDelegate implements JavaDelegate {
    @Autowired
    UserRepository userRepository;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String email = (String) delegateExecution.getVariable("email");
        String password = (String) delegateExecution.getVariable("password");
        User user = userRepository.findByEmailAndPasswordHash(email, password).orElseThrow(() -> new BpmnError("Неправильный email или пароль"));
        delegateExecution.setVariable("id", user.getId());
    }
}
