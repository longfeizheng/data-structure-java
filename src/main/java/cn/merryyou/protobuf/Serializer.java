package cn.merryyou.protobuf;

public interface Serializer<T> {
    byte[] serialize(T obj) throws CommonException;

    T deSerialize(byte[] bytes) throws CommonException;
}