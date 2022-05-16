package wq.cdm.top.springbootdemo.config.datasource;

import org.apache.commons.lang3.StringUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DatasourceRoutingContext {
    private static final ThreadLocal<String> routingDatasourceName = new ThreadLocal<>();

    public static String get() {
        String name = StringUtils.defaultIfBlank(routingDatasourceName.get(), DatasourceConst.DATASOURCE_MASTER);
        return name;
    }

    public static void set(String name) {
        routingDatasourceName.set(StringUtils.defaultIfBlank(name, DatasourceConst.DATASOURCE_MASTER));
    }

    public static void del() {
        routingDatasourceName.remove();
    }
}
