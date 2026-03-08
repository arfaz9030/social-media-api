package com.social.media;

import jakarta.persistence.*;

@Entity
// @Entity tells JPA/Hibernate that this class represents
// a database table. By default the table name will be "post".
public class Post {

    // Primary Key of the Post table.
    // Each post will have a unique id.
    @Id

    // IDENTITY means the database automatically generates
    // the id value using AUTO_INCREMENT (common in MySQL).
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    // ---------------- MANY TO ONE RELATIONSHIP ----------------

    // Many posts can belong to ONE user.
    // Example:
    // User: Arfaz
    // Posts:
    //   - "Learning Java Streams"
    //   - "Spring Boot Tips"
    //   - "Microservices Guide"
    //
    // So many Post records point to the same SocialUser.
    @ManyToOne


    // @JoinColumn defines the foreign key column in the Post table.
    // "social_user_id" will store the id of the user who created the post.
    //
    // Database Example:
    // post table
    // --------------------------
    // id | content | social_user_id
    // 1  | Hello   | 10
    // 2  | Spring  | 10
    //
    // Here user with id=10 created multiple posts.
    //
    // IMPORTANT INTERVIEW POINT:
    // The entity that contains @JoinColumn is the OWNING SIDE
    // of the relationship because it maintains the foreign key.
    @JoinColumn(name = "social_user_id")
    private SocialUser socialUser;






}