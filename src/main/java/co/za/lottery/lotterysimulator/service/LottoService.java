package co.za.lottery.lotterysimulator.service;

import co.za.lottery.lotterysimulator.data.Numbers;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Map;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class LottoService {
    public ArrayList<Numbers> generateRandomNumbers() {
        Random objGenerator = new Random();
        ArrayList<Numbers> numsList = new ArrayList<>();
        for (int i = 0; i <= 31474839; i++) {
            Numbers toAdd = new Numbers();
            toAdd.setNum1(objGenerator.nextInt(52 - 1 + 1) + 1);
            toAdd.setNum2(objGenerator.nextInt(52 - 1 + 1) + 1);
            toAdd.setNum3(objGenerator.nextInt(52 - 1 + 1) + 1);
            toAdd.setNum4(objGenerator.nextInt(52 - 1 + 1) + 1);
            toAdd.setNum5(objGenerator.nextInt(52 - 1 + 1) + 1);
            toAdd.setNum6(objGenerator.nextInt(52 - 1 + 1) + 1);
            toAdd.setBonus(objGenerator.nextInt(52 - 1 + 1) + 1);
            numsList.add(toAdd);
        }
        return numsList;
    }

    public ArrayList<Integer> buildCommonList(ArrayList<Numbers> numbers) {
        ArrayList<Integer> num1s = new ArrayList<>();
        ArrayList<Integer> num2s = new ArrayList<>();
        ArrayList<Integer> num3s = new ArrayList<>();
        ArrayList<Integer> num4s = new ArrayList<>();
        ArrayList<Integer> num5s = new ArrayList<>();
        ArrayList<Integer> num6s = new ArrayList<>();
        ArrayList<Integer> bonuss = new ArrayList<>();

        for (Numbers x : numbers) {
            num1s.add(x.getNum1());
            num2s.add(x.getNum2());
            num3s.add(x.getNum3());
            num4s.add(x.getNum4());
            num5s.add(x.getNum5());
            num6s.add(x.getNum6());
            bonuss.add(x.getBonus());
        }
        Integer com1 = getMode(num1s);
        Integer com2 = getMode(num2s);
        Integer com3 = getMode(num3s);
        Integer com4 = getMode(num4s);
        Integer com5 = getMode(num5s);
        Integer com6 = getMode(num6s);
        Integer comBonus = getMode(bonuss);

        ArrayList<Integer> finalList = new ArrayList<>();
        finalList.add(com1);
        finalList.add(com2);
        finalList.add(com3);
        finalList.add(com4);
        finalList.add(com5);
        finalList.add(com6);
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