package mate.academy.springboot.swagger.util;

import java.util.ArrayList;
import java.util.List;
import org.springframework.data.domain.Sort;

public class SortUtil {
    public static Sort prepareSortParam(String sortBy) {
        List<Sort.Order> orders = new ArrayList<>();
        if (sortBy.contains(":")) {
            String[] sortingFields = sortBy.split(";");
            for (String field: sortingFields) {
                Sort.Order order;
                if (field.contains(":")) {
                    String[] fieldsAndDirections = field.split(":");
                    order = new Sort.Order(Sort.Direction.valueOf(
                            fieldsAndDirections[1]), fieldsAndDirections[0]);
                } else {
                    order = new Sort.Order(Sort.Direction.DESC, field);
                }
                orders.add(order);
            }
        } else {
            Sort.Order order = new Sort.Order(Sort.Direction.DESC, sortBy);
            orders.add(order);
        }
        return Sort.by(orders);
    }
}
