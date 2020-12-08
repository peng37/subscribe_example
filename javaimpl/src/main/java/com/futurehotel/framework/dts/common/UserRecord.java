package com.futurehotel.framework.dts.common;

import com.futurehotel.framework.dts.avro.Record;
import org.apache.kafka.common.TopicPartition;

public class UserRecord {
    private final TopicPartition topicPartition;
    private final long offset;
    private final Record record;
    private final UserCommitCallBack userCommitCallBack;

    public UserRecord(TopicPartition tp, long offset, Record record, UserCommitCallBack userCommitCallBack) {
        this.topicPartition = tp;
        this.offset = offset;
        this.record = record;
        this.userCommitCallBack = userCommitCallBack;
    }

    public long getOffset() {
        return offset;
    }

    public Record getRecord() {
        return record;
    }

    public TopicPartition getTopicPartition() {
        return topicPartition;
    }

    public void commit(String metadata) {
        userCommitCallBack.commit(topicPartition, record, offset, metadata);
    }
}
