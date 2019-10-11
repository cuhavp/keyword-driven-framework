package core.keywords;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class OperationFactory {
    static Map<String, Operation> operationMap = new HashMap<>();
    static {
        operationMap.put("click", new Click());
    }
    public static Optional<Operation> getOperation(String operation){
        return Optional.ofNullable(operationMap.get(operation));
    }
}
