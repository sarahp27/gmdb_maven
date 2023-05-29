package com.glc.gmdb.Model;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
//import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
// @AllArgsConstructor
@Entity
@Table(name = "movieUsers")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // @OneToMany(mappedBy = "Reviews")
    // private Long reviewer_id;
    private String username;
    private Date dateJoin;
    private String role;
    private int numReview;

    @OneToMany(mappedBy = "reviewer_id")
    private List<Reviews> reviews;

    public User(String username, String role, Date dateJoin, int numReview) {
        this.username = username;
        this.role = role;
        this.dateJoin = dateJoin;
        this.numReview = numReview;
    }

}
