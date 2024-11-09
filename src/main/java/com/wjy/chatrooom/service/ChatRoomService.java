package com.wjy.chatrooom.service;

/**
 * 聊天室接口
 */
public interface ChatRoomService {
    public String joinRoom(String roomId,String userId);
    public String leaveRoom(String roomId,String userId);
}
