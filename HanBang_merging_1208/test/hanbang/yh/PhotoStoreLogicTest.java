package hanbang.yh;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import hanbang.domain.Photo;
import hanbang.store.PhotoStore;
import hanbang.store.logic.PhotoStoreLogic;

public class PhotoStoreLogicTest {

	private PhotoStore store;

	@Before
	public void setUp() {
		store = new PhotoStoreLogic();
	}

	// @Test
	// public void testCreate() {
	//
	// Photo photo = new Photo();
	// photo.setPhoto("yyy");
	// photo.setShareHouseId(2);
	//
	// store.create(photo);
	//
	// assertNotNull(photo);
	//// assertEquals("yyy", store.retriveAll(1).get(0).getPhoto());
	// }

	// @Test
	// public void testUpdate() {
	// Photo photo = store.retriveAll(1).get(0);
	// photo.setPhoto("yooho");
	// store.update(photo);
	//
	// assertNotNull(photo);
	// assertEquals("yooho", store.retriveAll(1).get(0).getPhoto());
	//
	// }

	// @Test
	// public void testDeleteByShareHouse() {
	// store.deleteByShareHouse(1);
	// assertNull(store.retriveAll(1).get(0));
	// }

	// @Test
	// public void testDelete() {
	// store.delete(1);
	// assertNull(store.retrive(1));
	// }

	 @Test
	 public void testRetriveAll() {
	 List<Photo> photos = store.retriveAll(2);
	 assertEquals(2, photos.size());
	
	 }

}
