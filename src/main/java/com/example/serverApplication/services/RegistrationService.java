package com.example.serverApplication.services;

import com.example.serverApplication.domain.User;
import com.example.serverApplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    public DataProcessingService getDataProcessingService() {
        return dataProcessingService;
    }

    @Autowired
    private DataProcessingService dataProcessingService;
    @Autowired
    UserService userService;
    @Autowired
    NotificationService notificationService;
    @Autowired
    UserRepository userRepository;

    public User processRegistration(String userName, int userAge, String email){
        User newUser = userService.createUser(userName, userAge, email);
        userRepository.save(newUser);
        notificationService.sendNotification("Пользователь сохранен в БД");
        return newUser;
    }
}
