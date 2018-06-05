package at.jku.dke.semtech2018.skiwc;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Repository
public class PredicateDAO {
 
    private static final List<String> PREDICATES = new ArrayList<String>();
 
    static {
        initData();
    }
 
    private static void initData() {
        String p1 = "hatGewonnen";
        String p2 = "hatVornamen";
        String p3 = "hatStattgefunden";
 
        PREDICATES.add(p1);
        PREDICATES.add(p2);
        PREDICATES.add(p3);
    }
 
    public static List<String> getPredicates() {
        return PREDICATES;
    }
}