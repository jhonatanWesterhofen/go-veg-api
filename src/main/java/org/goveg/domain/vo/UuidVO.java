package org.goveg.domain.vo;

import java.util.UUID;

public class UuidVO {

    private UUID value;

    public UuidVO(final String uuid) {
        this.value = uuid != null ? UUID.fromString(uuid) : UUID.randomUUID();
    }

    public UUID getValue() {
        return value;
    }
}