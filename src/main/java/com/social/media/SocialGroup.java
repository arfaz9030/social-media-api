package com.social.media;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class SocialGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    // Many groups can contain many users.
//
// mappedBy = "groups" means:
// The relationship is controlled by the SocialUser entity.
// SocialGroup does NOT create the join table.
// It simply references the existing relationship.

    @ManyToMany(mappedBy = "groups")

// This set contains all users who joined this group.
// Example:
// Group: Java Developers
// Users: Arfaz, Ahmed, Rahul
    private Set<SocialUser> socialUser = new HashSet<>();


}
