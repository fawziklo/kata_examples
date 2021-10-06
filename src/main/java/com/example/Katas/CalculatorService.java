package com.example.Katas;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalculatorService {

    public Integer min(List<Integer> numbersList) {
        return numbersList.size() > 0 ? numbersList.stream().min(Integer::compare).get() : null;
    }

    public Integer max(List<Integer> numbersList) {
        return numbersList.size() > 0 ? numbersList.stream().max(Integer::compare).get() : null;
    }

    public Integer size(List<Integer> numbersList) {
        return numbersList.size() > 0 ? numbersList.size() : null;
    }

    public Double average(List<Integer> numbersList) {
        return numbersList.size() > 0 ? (double) ((numbersList.stream().reduce(Integer::sum).get()) / (float) numbersList.size()) : null;
    }

}
