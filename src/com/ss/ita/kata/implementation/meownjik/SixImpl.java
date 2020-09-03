package com.ss.ita.kata.implementation.meownjik;

import com.ss.ita.kata.Six;

import java.math.BigDecimal;
import java.util.ArrayList;

import static java.lang.Integer.parseInt;

public class SixImpl implements Six {
    //== КОНСТАНТИ ==
    //...
    //========================================================================
    //== МЕТОДИ ==
    //----------------------------------------------------------------------
    @Override
    public int liters(double time) {
        return (int) Math.floor(time*0.5);
    }
    //----------------------------------------------------------------------

}
