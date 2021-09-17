package tp.part1.interfaces;

import jdk.internal.net.http.common.Pair;

import java.util.Map;

public interface IProvider {
    int getPrice(int ref);
    void order(Map<Integer,Integer> stock, int ref, int quantity);
}
