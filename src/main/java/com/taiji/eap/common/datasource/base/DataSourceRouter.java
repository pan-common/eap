package com.taiji.eap.common.datasource.base;

import com.sun.xml.internal.ws.encoding.DataHandlerDataSource;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @author 潘宏智
 * @date
 */
public class DataSourceRouter extends AbstractRoutingDataSource{
    @Override
    protected Object determineCurrentLookupKey() {
        return DataSourceHolder.getDataSource();
    }
}
