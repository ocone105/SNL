package hanbang.store.mapper;

import java.util.List;
import java.util.Map;

import hanbang.domain.Photo;

public interface PhotoMapper {

	int deleteByShareHouse(int shareHouseId);

	int delete(int photoId);

	Photo retrive(int photoId);

	List<Photo> retriveAll(int shareHouseId);

	int create(Map<String, Object> map);
}
