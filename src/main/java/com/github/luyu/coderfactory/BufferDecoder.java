package com.github.luyu.coderfactory;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;

public class BufferDecoder implements ProtocolDecoder{

    public static final int MAX_MSG_SIZE = 5000;

    public void decode(IoSession paramIoSession, IoBuffer in, ProtocolDecoderOutput out)
            throws Exception{
        if (in.prefixedDataAvailable(1, MAX_MSG_SIZE)) {
            int length = in.getInt();
            byte[] bytes = new byte[length];
            in.get(bytes);
            out.write(bytes);
        } else {

        }
    }

    @Override
    public void dispose(IoSession arg0) throws Exception {
        // TODO Auto-generated method stub

    }

    @Override
    public void finishDecode(IoSession arg0, ProtocolDecoderOutput arg1)
            throws Exception {
        // TODO Auto-generated method stub

    }
}