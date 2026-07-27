package io.netty.buffer;

//CHANGED: Is a shim. Needs implementing!
public interface ByteBuf {
    double readDouble();
    int readInt();
    short readShort();
    long readLong();
    float readFloat();
    String readString();
    byte readByte();
    void writeDouble(double v);
    void writeInt(int v);
    void writeLong(long v);
    void writeFloat(float v);
    void writeString(String v);
    void writeByte(int v);
    void writeShort(int v);
    void writeChar(int v);
}
