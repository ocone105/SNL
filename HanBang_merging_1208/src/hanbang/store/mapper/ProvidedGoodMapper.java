package hanbang.store.mapper;

import java.util.List;

import hanbang.domain.ProvidedGood;

public interface ProvidedGoodMapper {

	int create(ProvidedGood providedGood);

	int update(ProvidedGood providedGood);

	int delete(int providedGoodId);

	int deleteByRoom(int roomId);

	ProvidedGood retrive(int providedGoodId);

	List<ProvidedGood> retriveAll(int roomId);
}
