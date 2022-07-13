package com.yunn.autumn.netty.demo2;

import com.yunn.autumn.netty.UserForTestSerializer;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;
import org.junit.Test;

import java.sql.SQLOutput;
import java.time.LocalDateTime;
import java.time.ZoneId;


/**
 * @author yunN
 * @date 2022/06/22
 */
class NettyServerHandler extends SimpleChannelInboundHandler<UserForTestSerializer> {

    // client -> server


    @Override
    protected void channelRead0(ChannelHandlerContext ctx, UserForTestSerializer msg) throws Exception {
        
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ByteBuf buf = Unpooled.copiedBuffer("客户端信息已经收到……", CharsetUtil.UTF_8);
        ctx.writeAndFlush(buf);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}
