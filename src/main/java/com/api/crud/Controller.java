package com.api.crud;

import com.api.crud.entity.InputRequest;
import com.api.crud.entity.Products;
import com.api.crud.repo.ProductRepository;
import com.api.crud.service.CrudService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.LockModeType;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;
@Slf4j
@RestController
public class Controller {
    @Autowired
    CrudService crudService;

    private static final Logger log = LoggerFactory.getLogger(Controller.class);

    @RequestMapping(value = "/saveAll",method = RequestMethod.POST)
    public void saveData(@RequestBody InputRequest inputRequest){
        try{
            log.info("Input request received {}",inputRequest);
            crudService.saveAllTheInfo(inputRequest.getProducts());
        }catch(Exception e){
            StringWriter stringWriter = new StringWriter();
             e.printStackTrace(new PrintWriter(stringWriter));
            log.info("Exception occurred while saving productData - {}",stringWriter.toString());
        }
    }
}

