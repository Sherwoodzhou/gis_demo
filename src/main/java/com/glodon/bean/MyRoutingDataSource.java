package com.glodon.bean;

import org.springframework.context.annotation.Primary;
import org.springframework.lang.Nullable;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
@Primary
public class MyRoutingDataSource extends AbstractRoutingDataSource {
    @Nullable
    @Override
    protected Object determineCurrentLookupKey() {
        return DBContextHolder.get();
    }
}
