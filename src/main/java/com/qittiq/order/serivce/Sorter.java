package com.qittiq.order.serivce;

import java.util.Arrays;
import java.util.Objects;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class Sorter {

    public static BiFunction<String, String, String> getSorter(){
        return (arb, alfa) ->
        {
            int aL = alfa.length();
            String[] symbols = new String[aL+1];
            for (char ch : arb.toCharArray()) {
                int ind = alfa.indexOf(ch);
                if (ind < 0) {
                    ind = aL;
                }
                symbols[ind] = symbols[ind] == null ? String.valueOf(ch) : symbols[ind] + ch;
            }
            return Arrays.stream(symbols).filter(Objects::nonNull).collect(Collectors.joining());
        };
    }

}
