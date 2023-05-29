package com.glc.gmdb.Model;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
// @AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "reviews")
public class Reviews {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name ="movie_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Movies movie_id;

    @ManyToOne
    @JoinColumn(name="reviewer_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private User reviewer_id;

    private String review_text;
    private Date date_time;

    public Reviews(String review_text, Date date_time) {
        this.review_text = review_text;
        this.date_time = date_time;
    }

    public void setReviewer(User user) {
    }

    public void setMovies(Movies movies) {
    }

    public void setDate_time(String string) {
    }

    public void setMovie_id(Movies movies) {
    }

}
