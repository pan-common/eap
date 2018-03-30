package com.taiji.eap.common.datasource.base;

import com.sun.xml.internal.ws.encoding.DataHandlerDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @author 潘宏智
 * @date
 */
public class DataSourceRouter extends AbstractRoutingDataSource{

    private static final Logger LOGGER = LoggerFactory.getLogger(DataSourceRouter.class);

    @Override
    protected Object determineCurrentLookupKey() {
        String datasource = DataSourceHolder.getDataSource();
        return datasource;
    }

}
