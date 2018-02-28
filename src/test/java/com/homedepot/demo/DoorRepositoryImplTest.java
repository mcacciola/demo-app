//package com.homedepot.demo;
//
//import com.google.cloud.spanner.DatabaseClient;
//import com.google.cloud.spanner.ResultSet;
//import com.homedepot.demo.domain.Door;
//import com.homedepot.demo.repository.DoorRepository;
//import com.homedepot.demo.repository.DoorRepositoryImpl;
//import com.homedepot.di.dc.osc.commons.spanner.ResultSetMapper;
//
//import org.junit.Before;
//import org.junit.FixMethodOrder;
//import org.junit.Test;
//import org.junit.experimental.categories.Category;
//import org.junit.runner.RunWith;
//import org.junit.runners.MethodSorters;
//import org.mockito.Answers;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.mockito.runners.MockitoJUnitRunner;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.Assert.assertEquals;
//import static org.mockito.Matchers.any;
//import static org.mockito.Mockito.*;
//
//@Category(UnitTest.class)
////@RunWith(MockitoJUnitRunner.class)
//public class DoorRepositoryImplTest
//{
//    @Mock(answer = Answers.RETURNS_DEEP_STUBS)
//    DatabaseClient dbClient;
//
////    DoorRepository doorRepo;
//
//    @Mock
//    private ResultSetMapper<Door> doorRowMapper;
//
//    @Autowired
//    @InjectMocks
//    private DoorRepositoryImpl doorRepo;
//
//    @Before
//    public void setup()
//    {
//        MockitoAnnotations.initMocks(this);
////        dbClient = mock(DatabaseClient.class);
//        doorRepo = new DoorRepositoryImpl(dbClient);
//    }
//    @Test
//    public void getAllDoors_returnsValidResults()
//    {
//        List<Door> doorList = new ArrayList<Door>();
//        ResultSet resultSet = mock(ResultSet.class);
//        Door door = new Door();
//        door.setDoorId("2");
//        door.setName("Black Door");
//        doorList.add(door);
//        door = new Door();
//        door.setDoorId("3");
//        door.setName("Blue Door");
//        doorList.add(door);
//
//
////        when(dbClient.singleUse().executeQuery(any())).thenReturn(resultSet);
////        when(resultSet.next()).thenReturn(true,false);
////        when(doorRowMapper.mapResultToObject(any())).thenReturn(doorList);
////        List<Door> result=doorRepo.getDoors();
////        assertEquals(2, result.size());
////        verify(dbClient.singleUse(),times(1)).executeQuery(any());
//    }
//}
