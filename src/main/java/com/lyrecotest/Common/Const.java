package com.lyrecotest.Common;

import java.util.HashMap;
import java.util.Map;

public class Const {
    public static final int NUMBER_QUESTION = 50;
    public static final String questionTypePop ="Pop";
    public static final String questionTypeSport = "Sport";
    public static final String questionTypeScience = "Science";
    public static final String questionTypeRock = "Rock";

    public static Map<Integer, String> CATEGORY_SQUARE = new HashMap() {{
        put(0, questionTypePop);
        put(4, questionTypePop);
        put(8, questionTypePop);
        put(1, questionTypeScience);
        put(5, questionTypeScience);
        put(9, questionTypeScience);
        put(2, questionTypeSport);
        put(6, questionTypeSport);
        put(10, questionTypeSport);
    }};
}
