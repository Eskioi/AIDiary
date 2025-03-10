package com.projetecam.diary;

import com.projetecam.diary.core.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Iterator;

@Component
@RequiredArgsConstructor
public class DataFixtureElements implements CommandLineRunner {
    private final UserService userService;
    private final SocialService socialService;
    private final HelpRequestService helpRequestService;
    private final UserRepository userRepository;
    private final RewardRepository rewardRepository;

    @Override
    public void run(String... args) {
        userService.register(new RegisterRequestDTO("test-user-1", "test-user-1@floodaid.jku.at", "SuperSecretPassword!"));
        userService.register(new RegisterRequestDTO("test-user-2", "test-user-2@floodaid.jku.at", "SuperSecretPassword!"));
        userService.register(new RegisterRequestDTO("test-user-3", "test-user-3@floodaid.jku.at", "SuperSecretPassword!"));

        Iterator<User> userIterator = userRepository.findAll().iterator();
        SecurityContextHolder.getContext().setAuthentication(
                new JWTAuthentication(userIterator.next().getId(), true));

        HelpRequestDTO hr1 = helpRequestService.create(new CreateHelpRequestDTO("My house is under water",
                "My house is under water and I need people helping me.", "l.marin@gmail.com", "", 48.2950018, 14.2448966,
                HelpRequestSeverityDTO.CRITICAL));
        HelpRequestDTO hr2 = helpRequestService.create(new CreateHelpRequestDTO("My house is on fire",
                "My house is on fire, I need people helping me rescue my belongings.","carin.buchner@gmx.at", "0043 6702050381", 47.2950018, 15.2448966,
                HelpRequestSeverityDTO.URGENT));
        HelpRequestDTO hr3 = helpRequestService.create(new CreateHelpRequestDTO("Cat on tree",
                "My cat is stuck on a tree, I need someone to help me", "", "", 49.2950018, 13.2448966,
                HelpRequestSeverityDTO.STANDARD));


        TaskDTO hr1Task1 = helpRequestService.createTask(hr1.getId(), new CreateTaskDTO("Fill sandsacks", 3));
        helpRequestService.createTask(hr1.getId(), new CreateTaskDTO("Bring food", 1));
        helpRequestService.createTask(hr1.getId(), new CreateTaskDTO("Need dry clothes", 2));

        helpRequestService.createTask(hr2.getId(), new CreateTaskDTO("Bring fire extinguisher", 2));
        TaskDTO hr2Task2 = helpRequestService.createTask(hr2.getId(), new CreateTaskDTO("Call fire-brigade", 1));

        rewardRepository.save(new Reward(null, "Spar 10% discount", "Save up to 10% on your next Spar shopping tour", null, "9484jf7f64hgr7fhf", 100));
        rewardRepository.save(new Reward(null, "McDonalds Free HappyMeal", "Free HappyMeal at McDonalds", null, "kdjid8r74hfkjfö", 250));

        helpRequestService.assignToTask(hr1Task1.getId());
        helpRequestService.assignToTask(hr2Task2.getId());

        socialService.postMessage(hr3.getId(), new CreateSocialMessageDTO("Where is it exactly? I can't find the tree!"));
    }
}