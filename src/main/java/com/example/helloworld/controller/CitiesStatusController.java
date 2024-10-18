package com.example.helloworld.controller;

import com.example.helloworld.Domain.Cities.CitiesStatus;
import com.example.helloworld.Service.CitiesStatusService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CitiesStatusController {

private final CitiesStatusService _service;
    public CitiesStatusController(CitiesStatusService service) {
        this._service = service;
    }
    @GetMapping("/hello")
    public String sendGreetings() {
        return "Hello, World!";
    }

    @GetMapping("/allCitiesStatus")
    public ResponseEntity<List<CitiesStatus>> getList() {
        return ResponseEntity.ok(_service.GetAllStatusCities());
    }


    @GetMapping("/cityStatus{id}")
    public ResponseEntity<CitiesStatus> getCityStatusById(@PathVariable("id") int id) {
        Optional<CitiesStatus> cityStatus = _service.getStatusCityById(id);
        return cityStatus.map(status -> new ResponseEntity<>(status, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("createCityStatus")
    public ResponseEntity<CitiesStatus> createCityStatus(@RequestBody CitiesStatus cityStatus) {
        CitiesStatus createdCityStatus = _service.createStatusCity(cityStatus);
        return new ResponseEntity<>(createdCityStatus, HttpStatus.CREATED);
    }

    @PutMapping("/PatchCityStatus{id}")
    public ResponseEntity<CitiesStatus> updateCityStatus(@PathVariable("id") int id, @RequestBody CitiesStatus cityStatus) {
        CitiesStatus updatedCityStatus = _service.updateStatusCity(id, cityStatus);
        return new ResponseEntity<>(updatedCityStatus, HttpStatus.OK);
    }

    @DeleteMapping("/DeleteCityStatus{id}")
    public ResponseEntity<Void> deleteCityStatus(@PathVariable("id") int id) {
        _service.deleteStatusCity(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
