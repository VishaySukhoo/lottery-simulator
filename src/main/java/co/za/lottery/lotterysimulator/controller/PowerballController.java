package co.za.lottery.lotterysimulator.controller;

import co.za.lottery.lotterysimulator.data.Powerball;
import co.za.lottery.lotterysimulator.service.PowerballService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class PowerballController {

    @Autowired
    private PowerballService service;

    @RequestMapping("/powerball")
    public void generate(){
        ArrayList<Powerball> data = service.generateRandomNumbers();
        System.out.println(service.buildCommonList(data));
    }
}
