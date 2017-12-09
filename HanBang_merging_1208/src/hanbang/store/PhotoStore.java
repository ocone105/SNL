package hanbang.store;

import java.util.List;

import hanbang.domain.Photo;

public interface PhotoStore {

	int create(String imageUrl, int shareHouseId);

	int deleteByShareHouse(int shareHouseId);

	int delete(int photoId);

	Photo retrive(int photoId);

	List<Photo> retriveAll(int shareHouseId);

}
