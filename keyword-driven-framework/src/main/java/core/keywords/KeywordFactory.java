package core.keywords;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class KeywordFactory {
    static Map<String, Action> operationMap = new HashMap<>();
    static {
        operationMap.put("click", new Click());
        operationMap.put("open", new Open());
        operationMap.put("fill", new Fill());
        operationMap.put("visit",new Visit());
    }
    public static Optional<Action> getAction(String operation){
        return Optional.ofNullable(operationMap.get(operation));
    }
}
