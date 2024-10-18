package com.example.helloworld.Service;

import com.example.helloworld.Domain.Cities.CitiesStatus;
import com.example.helloworld.Repository.CitiesRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CitiesStatusService {


    private final CitiesRepository _repository;

    public CitiesStatusService(CitiesRepository service) {
        this._repository = service;
    }
    public List<CitiesStatus> GetAllStatusCities(){
        List<CitiesStatus> citiesStatusList;
        citiesStatusList =  _repository.findAll();

        return _repository.findAll();
    }

    public Optional<CitiesStatus> getStatusCityById(int id){
        return _repository.findById(id);
    }

    public CitiesStatus createStatusCity(CitiesStatus cityStatus){
        return _repository.save(cityStatus);
    }

    public CitiesStatus updateStatusCity(int id, CitiesStatus cityStatus){
        if (!_repository.existsById(id)) {
            cityStatus.setStatus("Não foi posisvel atualizar");
            cityStatus.setDate_updated(Date.from(Instant.now()));
            cityStatus.setCity("Não foi posisvel atualizar");
            cityStatus.setMsg("Não foi posisvel atualizar");
            return cityStatus;
        }
        cityStatus.setId(id);
        return _repository.save(cityStatus);
    }

    public String deleteStatusCity(int id){
        if (!_repository.existsById(id)) {
            return "Erro ao Deletar";
        }
        _repository.deleteById(id);

        return "Deletado com sucesso";
    }
}
