package com.glc.gmdb.Modal;

import java.util.Date;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Reviewer {

    @Id
    @NonNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long reivewer_iD;

    
    private long movie_id;

    private String  username;
    private Date date_joined;
    private int number_reviews;
}
