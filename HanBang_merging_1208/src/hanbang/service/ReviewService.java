package hanbang.service;

import java.util.List;

import hanbang.domain.Review;

public interface ReviewService {

	boolean register(Review review);

	Review find(int reviewId);

	List<Review> findByShareHouseId(int shareHouseId);

	boolean modify(Review review);

	boolean removeByMemberId(String memberId);

	boolean removeByReviewId(int reviewId);

	boolean removeByShareHouse(int shareHouseId);

	boolean reportReview(String memberId, int reviewId);

}
