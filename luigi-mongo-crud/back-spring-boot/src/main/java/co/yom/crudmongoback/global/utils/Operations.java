package co.yom.crudmongoback.global.utils;

import co.yom.crudmongoback.global.entity.EntityId;

import java.util.Comparator;
import java.util.List;

public class Operations {

    public static String trimBrackets(String message) {
        // Quitar caracteres especiales
        return message.replaceAll("[\\[\\]]", "");
    }

    public static int autoIncrement(List<? extends EntityId> list) { // Cualquier clase hija de EntityId
        if (list.isEmpty())
            return 1;

        return list.stream().max(Comparator.comparing(EntityId::getId)).get().getId() + 1;
    }
}