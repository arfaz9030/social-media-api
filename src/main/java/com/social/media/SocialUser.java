package com.social.media;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class SocialUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


// ---------------- ONE TO ONE RELATIONSHIP ----------------

// One SocialUser has exactly one SocialProfile.
// Example:
// User: Arfaz → Profile: "Java Developer, Hyderabad"

    // mappedBy = "user" means:
// The SocialProfile entity owns the relationship.
// The foreign key column exists in SocialProfile table.
//
// So this side (SocialUser) is the INVERSE SIDE.
// It only references the relationship but does not control it.
//
// Database idea:
// social_profile table contains the column "user_id".
    @OneToOne(mappedBy = "user")
    private SocialProfile socialProfile;


// ---------------- ONE TO MANY RELATIONSHIP ----------------

// One user can create many posts.
// Example:
// User: Arfaz
// Posts: "My first Java post", "Spring Boot Tips", "Microservices Guide"

// mappedBy = "socialUser" means:
// The Post entity owns the relationship
// and contains the foreign key column (social_user_id).

// This side (SocialUser) just represents the collection of posts
// that belong to this user.

    @OneToMany(mappedBy = "socialUser")

// List is used because a user can have multiple posts.
// new ArrayList<>() prevents NullPointerException
// when adding posts before loading from database.
    private List<Post> userPost = new ArrayList<>();

    // ---------------- MANY TO MANY RELATIONSHIP ----------------

// Many users can belong to many groups.
// Example:
// User: Arfaz → Groups: Java, SpringBoot
// User: Ahmed → Groups: Java, DevOps
//
// So both users share some groups.

    @ManyToMany

// @JoinTable creates a third table (junction table)
// which stores the relationship between users and groups.
//
// Table name: user_group
// This table contains two foreign keys:
// user_id  -> refers to SocialUser.id
// group_id -> refers to SocialGroup.id
//
// Example user_group table:
//
// user_id | group_id
// -------------------
//   1     |   10
//   1     |   20
//   2     |   10
//
// Meaning:
// User 1 joined groups 10 and 20.
// User 2 joined group 10.

    @JoinTable(
            name = "user_group",

            // joinColumns represents the foreign key
            // referencing THIS entity (SocialUser).
            joinColumns = @JoinColumn(name = "user_id"),

            // inverseJoinColumns represents the foreign key
            // referencing the OTHER entity (SocialGroup).
            inverseJoinColumns = @JoinColumn(name = "group_id")
    )

// Set is used because duplicates should not exist.
// Example: A user should not join the same group twice.
    private Set<SocialGroup> groups = new HashSet<>();
}
