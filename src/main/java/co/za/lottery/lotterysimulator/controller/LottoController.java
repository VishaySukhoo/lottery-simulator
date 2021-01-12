package co.za.lottery.lotterysimulator.controller;

import co.za.lottery.lotterysimulator.data.Numbers;
import co.za.lottery.lotterysimulator.service.LottoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class LottoController {
    @Autowired
    private LottoService service;

    @RequestMapping("/lotto")
    public ArrayList<Integer> generate() {
        ArrayList<Numbers> data = service.generateRandomNumbers();
        return service.buildCommonList(data);
    }
}
