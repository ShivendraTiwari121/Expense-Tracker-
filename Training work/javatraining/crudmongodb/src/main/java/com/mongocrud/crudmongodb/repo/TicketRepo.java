package com.mongocrud.crudmongodb.repo;

import com.mongocrud.crudmongodb.model.TicketModel;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;
import java.util.Random;

public interface TicketRepo extends CrudRepository<TicketModel, Integer>{

    @Override
    List<TicketModel> findAll();


}