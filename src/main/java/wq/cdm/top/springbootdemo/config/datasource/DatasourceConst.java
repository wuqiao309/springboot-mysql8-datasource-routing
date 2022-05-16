package wq.cdm.top.springbootdemo.config.datasource;

import lombok.Getter;

@Getter
public class DatasourceConst {
    private DatasourceConst() {
    }

    public static final String DATASOURCE_MASTER = "master";
    public static final String DATASOURCE_SLAVE1 = "slave1";
    public static final String DATASOURCE_SLAVE2 = "slave2";
}
