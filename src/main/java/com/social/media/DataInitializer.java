package com.social.media;

import com.social.media.model.Post;
import com.social.media.model.SocialGroup;
import com.social.media.model.SocialUser;
import com.social.media.repositories.PostRepo;
import com.social.media.repositories.SocialGroupRepo;
import com.social.media.repositories.SocialProfileRepo;
import com.social.media.repositories.SocialUserRepo;
import org.springframework.boot.CommandLineRunner;
import com.social.media.model.SocialProfile;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    private final SocialUserRepo userRepository;
    private final SocialGroupRepo groupRepository;
    private final SocialProfileRepo SocialProfileRepo;
    private final PostRepo PostRepo;

    public DataInitializer(SocialUserRepo userRepository, SocialGroupRepo groupRepository, SocialProfileRepo SocialProfileRepo, PostRepo PostRepo) {
        this.userRepository = userRepository;
        this.groupRepository = groupRepository;
        this.SocialProfileRepo = SocialProfileRepo;
        this.PostRepo = PostRepo;
    }

    @Bean
    public CommandLineRunner initializeData() {
        return args -> {
            // Create some users
            SocialUser user1 = new SocialUser();
            SocialUser user2 = new SocialUser();
            SocialUser user3 = new SocialUser();

            // Save users to the database
            userRepository.save(user1);
            userRepository.save(user2);
            userRepository.save(user3);

            // Create some groups
            SocialGroup group1 = new SocialGroup();
            SocialGroup group2 = new SocialGroup();

            // Add users to groups
            group1.getSocialUsers().add(user1);
            group1.getSocialUsers().add(user2);

            group2.getSocialUsers().add(user2);
            group2.getSocialUsers().add(user3);

            // Save groups to the database
            groupRepository.save(group1);
            groupRepository.save(group2);

            // Associate users with groups
            user1.getGroups().add(group1);
            user2.getGroups().add(group1);
            user2.getGroups().add(group2);
            user3.getGroups().add(group2);

            // Save users back to database to update associations
            userRepository.save(user1);
            userRepository.save(user2);
            userRepository.save(user3);


            // Create some posts
            Post post1 = new Post();
            Post post2 = new Post();
            Post post3 = new Post();

            // Associate posts with users
            post1.setSocialUser(user1);
            post2.setSocialUser(user2);
            post3.setSocialUser(user3);

            // Save posts to the database (assuming you have a PostRepo)
            PostRepo.save(post1);
            PostRepo.save(post2);
            PostRepo.save(post3);

            // Create some social profiles
            SocialProfile profile1 = new SocialProfile();
            SocialProfile profile2 = new SocialProfile();
            SocialProfile profile3 = new SocialProfile();

            // Associate profiles with users
            profile1.setUser(user1);
            profile2.setUser(user2);
            profile3.setUser(user3);

            // Save profiles to the database (assuming you have a SocialProfileRepo)
            SocialProfileRepo.save(profile1);
            SocialProfileRepo.save(profile2);
            SocialProfileRepo.save(profile3);
        };
    }
}
