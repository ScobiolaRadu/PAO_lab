package ro.pao.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum EnumExample {
    FIELD_1("field1"),
    FIELD_2("field2"),
    NONE("none"); // in cazul in care nu este niciun field

    private final String typeString;

    public static EnumExample getEnumByFieldString(String field) {
        return Arrays.stream(EnumExample.values())
                .filter(enumElement -> enumElement.typeString.equals(field))
                .findAny()
                .orElse(NONE); // in cazul in care nu este niciun field
    }
}
