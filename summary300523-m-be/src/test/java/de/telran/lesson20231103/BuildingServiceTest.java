package de.telran.lesson20231103;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

public class BuildingServiceTest {

    private static BuildingService service;

    private static List<Building> testBuildings;

//    @Mock
    private static BuildingRepository repository = Mockito.mock(BuildingRepository.class);

    @BeforeEach
    public void init(){
//        BuildingRepository repository = new BuildingRepositoryImpl();
        service = new BuildingService(repository);

        Building building1 = new Building();
        building1.setName("Farm");
        building1.setCost(100);
        Building building2 = new Building();
        building2.setName("Library");
        building2.setCost(500);
        testBuildings = Arrays.asList(building1, building2);

        Mockito.when(repository.findAll()).thenReturn(testBuildings);
    }

    @Test
    public void increaseCost() {
        assertEquals(100, testBuildings.get(0).getCost());
        assertEquals(500, testBuildings.get(1).getCost());
        service.increaseCost(100);
        assertEquals(200, testBuildings.get(0).getCost());
        assertEquals(600, testBuildings.get(1).getCost());
//        Mockito.verify(repository, Mockito.times(2)).save(any());
        Mockito.verify(repository).save(testBuildings.get(0));
        Mockito.verify(repository).save(testBuildings.get(1));
    }

    @Test
    public void deleteFarm() {
        service.deleteFarm();
        Mockito.verify(repository).deleteByName("Farm");
//        Mockito.verify(repository).deleteByName(Mockito.any());
    }
}