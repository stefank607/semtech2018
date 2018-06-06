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
        String p3 = "hatNachnamen";
        String p4 = "hatStattgefunden";
        String p5 = "hatBezeichnung";

 
        PREDICATES.add(p1);
        PREDICATES.add(p2);
        PREDICATES.add(p3);
        PREDICATES.add(p4);
        PREDICATES.add(p5);
    }
 
    public static List<String> getPredicates() {
        return PREDICATES;
    }
}