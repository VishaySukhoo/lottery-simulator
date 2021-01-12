package co.za.lottery.lotterysimulator.service;

import co.za.lottery.lotterysimulator.data.Powerball;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Map;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;
@Service
public class PowerballService {
    public static ArrayList<Powerball> generateRandomNumbers() {
        Random objGenerator = new Random();
        ArrayList<Powerball> numsList = new ArrayList<>();
        for (int i = 0; i <= 39474839; i++) {
            Powerball toAdd = new Powerball();
            toAdd.setNum1(objGenerator.nextInt(50 - 1 + 1) + 1);
            toAdd.setNum2(objGenerator.nextInt(50 - 1 + 1) + 1);
            toAdd.setNum3(objGenerator.nextInt(50 - 1 + 1) + 1);
            toAdd.setNum4(objGenerator.nextInt(50 - 1 + 1) + 1);
            toAdd.setNum5(objGenerator.nextInt(50 - 1 + 1) + 1);
            toAdd.setPowerball(objGenerator.nextInt(20 - 1 + 1) + 1);
            numsList.add(toAdd);
        }
        return numsList;
    }

    public ArrayList<Integer> buildCommonList(ArrayList<Powerball> powerballs) {
        ArrayList<Integer> num1s = new ArrayList<>();
        ArrayList<Integer> num2s = new ArrayList<>();
        ArrayList<Integer> num3s = new ArrayList<>();
        ArrayList<Integer> num4s = new ArrayList<>();
        ArrayList<Integer> num5s = new ArrayList<>();
        ArrayList<Integer> powerball = new ArrayList<>();

        for (Powerball x : powerballs) {
            num1s.add(x.getNum1());
            num2s.add(x.getNum2());
            num3s.add(x.getNum3());
            num4s.add(x.getNum4());
            num5s.add(x.getNum5());
            powerball.add(x.getPowerball());
        }
        Integer com1 = getMode(num1s);
        Integer com2 = getMode(num2s);
        Integer com3 = getMode(num3s);
        Integer com4 = getMode(num4s);
        Integer com5 = getMode(num5s);
        Integer comBonus = getMode(powerball);

        ArrayList<Integer> finalList = new ArrayList<>();
        finalList.add(com1);
        finalList.add(com2);
        finalList.add(com3);
        finalList.add(com4);
        finalList.add(com5);
        finalList.add(comBonus);

        return finalList;

    }

    private Integer getMode(ArrayList<Integer> nums) {
        return nums.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey).orElse(null);
    }

}