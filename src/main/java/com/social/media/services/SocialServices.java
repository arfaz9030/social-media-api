package com.social.media.services;

import com.social.media.model.SocialUser;
import com.social.media.repositories.SocialUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SocialServices {

    @Autowired
    public SocialUserRepo socialUserRepo;
    public List<SocialUser> getUsers() {
        return socialUserRepo.findAll();

    }
    public SocialUser saveUser(SocialUser socialUse) {
        return socialUserRepo.save(socialUse);
    }
}
