package com.yunn.autumn.netty.demo2;

import com.yunn.autumn.netty.UserForTestSerializer;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

/**
 * @author yunN
 * @date 2022/06/22
 */
class NettyClientHandler extends SimpleChannelInboundHandler<UserForTestSerializer> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, UserForTestSerializer msg) throws Exception {

    }

    // 信息发给其他客户端
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ByteBuf buf = Unpooled.copiedBuffer("ok, got it", CharsetUtil.UTF_8);
        ctx.writeAndFlush(buf);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
