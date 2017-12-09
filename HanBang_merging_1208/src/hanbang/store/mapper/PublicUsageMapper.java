package hanbang.store.mapper;

import java.util.List;

import hanbang.domain.PublicUsage;

public interface PublicUsageMapper {

	int create(PublicUsage publicUsage);
	
	int delete(int publicUsageId);

	int deleteByEssentialInfo(int essentialInfoId);
	
	PublicUsage retrive(int publicUseageId);

	List<PublicUsage> retriveAll(int essentialInfoId);
}
