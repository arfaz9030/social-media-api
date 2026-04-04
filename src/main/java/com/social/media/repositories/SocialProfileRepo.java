package com.social.media.repositories;

import com.social.media.model.SocialProfile;
import com.social.media.model.SocialUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SocialProfileRepo extends JpaRepository<SocialProfile,Long> {

}
