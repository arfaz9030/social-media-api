package com.social.media.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SocialGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
    private Set<SocialUser> socialUsers = new HashSet<>();

}
