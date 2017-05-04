package com.smedialink.abakarmagomedov.neyro;

import java.util.ArrayList;

/**
 * Created by abakarmagomedov on 04/05/17.
 */

public class Neuro {

    private String name;
    private Integer output;
    private ArrayList<Integer> input;
    private ArrayList<Integer> memory;

    public Neuro() {
    }

    public Neuro(String name, Integer output, ArrayList<Integer> input, ArrayList<Integer> memory) {
        this.name = name;
        this.output = output;
        this.input = input;
        this.memory = memory;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getOutput() {
        return output;
    }

    public void setOutput(Integer output) {
        this.output = output;
    }

    public ArrayList<Integer> getInput() {
        return input;
    }

    public void setInput(ArrayList<Integer> input) {
        this.input = input;
    }

    public ArrayList<Integer> getMemory() {
        return memory;
    }

    public void setMemory(ArrayList<Integer> memory) {
        this.memory = memory;
    }
}
