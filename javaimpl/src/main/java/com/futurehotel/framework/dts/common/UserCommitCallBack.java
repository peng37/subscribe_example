package com.futurehotel.framework.dts.common;

import com.futurehotel.framework.dts.avro.Record;
import org.apache.kafka.common.TopicPartition;

public interface UserCommitCallBack {
    public void commit(TopicPartition tp, Record record, long offset, String metadata);
}
