package hanbang.store;

import java.util.List;

import hanbang.domain.PublicUsage;

public interface PublicUsageStore {

	int create(PublicUsage publicUsage);

	int delete(int publicUsageId);

	int deleteByEssentialInfo(int essentialInfoId);

	PublicUsage retrive(int publicUseageId);

	List<PublicUsage> retriveAll(int essentialInfoId);
}
