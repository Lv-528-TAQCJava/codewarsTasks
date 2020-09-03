package com.ss.ita.kata.implementation.udzhas;

import com.ss.ita.kata.Six;

public class SixImpl implements Six {
    @Override
    public int liters(double time){
        return (int)Math.floor(time/2);
}
