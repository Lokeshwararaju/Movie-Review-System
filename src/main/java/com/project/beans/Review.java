package com.project.beans;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.service.response.ReviewResponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "review")
//@Getter
//@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Data

public class Review{
	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String movieReview;
	private double rating;
	@ManyToOne
	@JoinColumn(name="movie_id", nullable=false)
	@JsonIgnore
	private Movie movie;
	@CreationTimestamp
	private Date createDate;
	@UpdateTimestamp
	private Date updateData;
	 public static ReviewResponse toReviewResponse(Review review){
	        return ReviewResponse.builder().review(review.movieReview).rating(review.rating).build();
	    }

	    public static List<ReviewResponse> toReviewResponse(List<Review> reviewList){
	        if(Objects.isNull(reviewList))
	            return new ArrayList<>();
	        else
	            return reviewList.stream().map(Review::toReviewResponse).collect(Collectors.toList());
	   }
}
