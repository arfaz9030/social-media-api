package com.social.media;

import jakarta.persistence.*;

@Entity
// @Entity tells JPA/Hibernate that this class should be mapped
// to a database table. By default the table name will be "social_profile".
public class SocialProfile {

    // Primary key of the social_profile table.
    // Each profile will have a unique id.
    @Id

    // GenerationType.IDENTITY means the database generates the id
    // automatically using AUTO_INCREMENT (common in MySQL).
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    // ------------------ ONE TO ONE RELATIONSHIP ------------------

    // One SocialProfile belongs to one SocialUser.
    // Example:
    // User: Arfaz
    // Profile: "Java Developer | Spring Boot | Hyderabad"
    //
    // Default fetch type for @OneToOne is EAGER.
    // That means when a SocialProfile is loaded from the database,
    // the related SocialUser will also be loaded automatically.
    @OneToOne


    // @JoinColumn creates the foreign key column in this table.
    // "user_id" will be stored in the social_profile table.
    //
    // Example Database Table:
    // social_profile
    // -------------------------
    // id | bio | user_id
    // 1  | Java Dev | 10
    //
    // Here profile id=1 belongs to user id=10.
    //
    // IMPORTANT INTERVIEW POINT:
    // The entity that defines @JoinColumn is the OWNING SIDE
    // because it maintains the foreign key.
    //
    // Since the FK exists in the social_profile table,
    // SocialProfile is the owning side of the relationship.
    @JoinColumn(name = "user_id")
    private SocialUser user;

}