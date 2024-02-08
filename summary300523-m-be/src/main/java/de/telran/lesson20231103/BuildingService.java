package de.telran.lesson20231103;

import java.util.List;

public class BuildingService {

    private BuildingRepository repository;

    public BuildingService(BuildingRepository repository) {
        this.repository = repository;
    }

    public void increaseCost(int amount){
        List<Building> buildings = repository.findAll();
        for (Building b : buildings) {
            b.setCost(b.getCost() + amount);
            repository.save(b);
        }
    }

    public void deleteFarm(){
        repository.deleteByName("Farm");
    }
}
