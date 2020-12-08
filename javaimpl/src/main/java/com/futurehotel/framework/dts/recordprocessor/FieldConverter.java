package com.futurehotel.framework.dts.recordprocessor;

import com.futurehotel.framework.dts.avro.Field;
import org.apache.commons.lang3.StringUtils;
import com.futurehotel.framework.dts.recordprocessor.mysql.MysqlFieldConverter;

public interface FieldConverter {
    FieldValue convert(Field field, Object o);
    public static FieldConverter getConverter(String sourceName, String sourceVersion) {
        if (StringUtils.endsWithIgnoreCase("mysql", sourceName)) {
            return new MysqlFieldConverter();
        } else {
            throw new RuntimeException("FieldConverter: only mysql supported for now");
        }
    }
}
