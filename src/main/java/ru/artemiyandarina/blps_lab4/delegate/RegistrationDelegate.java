package ru.artemiyandarina.blps_lab4.delegate;

import org.camunda.bpm.engine.delegate.BpmnError;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.artemiyandarina.blps_lab4.entity.User;
import ru.artemiyandarina.blps_lab4.repository.UserRepository;

@Component
public class RegistrationDelegate implements JavaDelegate {
    @Autowired
    UserRepository userRepository;

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        String email = (String) execution.getVariable("user_email");
        String password = (String) execution.getVariable("user_password");
        if (userRepository.existsUserByEmail(email)) {
            throw new BpmnError("email_already_in_use", "Пользователь с email %s уже существует".formatted(email));
        }
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        userRepository.save(user);
    }
}
