package com.kamluen.clickhouse.api.enums;

public enum DBTypeEnum {

    hadoop01("hadoop01"),
    hadoop02("hadoop02"),
    hadoop03("hadoop03");

    private String value;

    DBTypeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
