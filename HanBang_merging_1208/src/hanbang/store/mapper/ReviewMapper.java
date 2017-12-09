package hanbang.store.mapper;

import java.util.List;
import java.util.Map;

import hanbang.domain.Review;

public interface ReviewMapper {

	int create(Review review);

	List<Review> retriveAll(int shareHouseId);
	
	List<Review> retrieveByMemberId(String memberId);

	Review retrive(int retriveId);

	int update(Review review);

	int deleteByMemberId(String memberId);

	int deleteByReviewId(int reviewId);

	int deleteByShareHouse(int shareHouseId);

	int reviewReport(Map<String, Object> map);
	
	List<Integer> countReports(int reviewId);
	
	int deleteReportedReviews(int reviewId);

}
