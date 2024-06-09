package ru.artemiyandarina.blps_lab4.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.artemiyandarina.blps_lab4.entity.Petition;
import ru.artemiyandarina.blps_lab4.exceptions.NotFoundException;
import ru.artemiyandarina.blps_lab4.repository.PetitionRepository;
import ru.artemiyandarina.blps_lab4.repository.UserRepository;

@Component
public class CreatePetitionDelegate implements JavaDelegate {

    @Autowired
    PetitionRepository petitionRepository;
    @Autowired
    UserRepository userRepository;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String country = (String) delegateExecution.getVariable("create_petition_country");
        String title = (String) delegateExecution.getVariable("create_petition_title");
        String description = (String) delegateExecution.getVariable("create_petition_description");
        Long owner_id = (Long) delegateExecution.getVariable("id");
        Petition newPetition = new Petition();
        newPetition.setCountry(country);
        newPetition.setTitle(title);
        newPetition.setDescription(description);
        newPetition.setOwner(userRepository.findUserById(owner_id).orElseThrow(() -> new NotFoundException(owner_id, "Ошибка :(")));
    }
}
