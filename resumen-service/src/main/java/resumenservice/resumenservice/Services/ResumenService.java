package resumenservice.resumenservice.Services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import resumenservice.resumenservice.Config.RestTemplateConfig;
import resumenservice.resumenservice.Entities.ResumenEntity;
import resumenservice.resumenservice.Repositories.ResumenRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
@Service
public class ResumenService {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    ResumenRepository resumenRepository;

    public List<ResumenEntity> getall(){
        return (List<ResumenEntity>) resumenRepository.findAll();
    }

    public  void generarResumenes(Date inicial, Date Final){


    }
}
