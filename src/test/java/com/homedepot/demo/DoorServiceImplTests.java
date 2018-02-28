//package com.homedepot.demo;
//
//import com.google.cloud.Timestamp;
//import com.google.cloud.spanner.DatabaseClient;
//import com.google.cloud.spanner.Mutation;
//import com.google.cloud.spanner.ResultSet;
//import com.homedepot.demo.domain.Door;
//import com.homedepot.demo.repository.DoorRepository;
//import com.homedepot.demo.service.DoorService;
//import com.homedepot.demo.service.DoorServiceImpl;
//import com.homedepot.di.dc.osc.commons.spanner.ResultSetMapper;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.ArgumentCaptor;
//import org.mockito.Captor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.context.embedded.LocalServerPort;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.web.client.TestRestTemplate;
//import org.springframework.http.ResponseEntity;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import javax.xml.crypto.Data;
//import java.net.URL;
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotNull;
//import static org.mockito.Mockito.*;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//public class DoorServiceImplTests {
//	@Captor
//
//	private ArgumentCaptor<Iterable<Mutation>> doorCaptor;
//	private DatabaseClient databaseClient;
//	private DoorService doorService;
//	private DoorRepository doorRepository;
//
//	@LocalServerPort
//	private int port;
//
//	private URL base;
//
//
//	@Before
//	public void setUp() throws Exception {
//		doorRepository = mock(DoorRepository.class);
//		doorService = new DoorServiceImpl(doorRepository);
//		databaseClient = mock(DatabaseClient.class);
////		this.base = new URL("http://localhost:" + port + "/api/getAllDoors");
//	}
//
//	@Test
//	public void doorService_getAllDoors() throws Exception {
//		List<Door> doorList = new ArrayList<Door>();
//		Door door = new Door();
//		door.setDoorId("2");
//		door.setName("Black Door");
//		doorList.add(door);
//		door = new Door();
//		door.setDoorId("3");
//		door.setName("Blue Door");
//		doorList.add(door);
//		when(doorRepository.getDoors()).thenReturn(doorList);
//		List<Door> response = doorService.getAllDoors();
//		assertEquals("2", response.get(0).getDoorId());
//		assertEquals("Blue Door", response.get(1).getName());
//	}
//
//
//	@Test
//	public void domainService_createDoor() {
//		Door door = new Door("desc");
//		doNothing().when(doorRepository).addDoor(door);
//		doorService.addDoor(door);
//		verify(doorRepository).addDoor(any(Door.class));
//		assertNotNull(door.getDoorId());
//		assertEquals(36, door.getDoorId().length());
//	}
//
//
//}
