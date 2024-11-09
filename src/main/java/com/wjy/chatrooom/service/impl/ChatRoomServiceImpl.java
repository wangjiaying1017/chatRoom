package com.wjy.chatrooom.service.impl;

import com.wjy.chatrooom.service.ChatRoomService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 聊天室接口实现类
 */
@Service
public class ChatRoomServiceImpl implements ChatRoomService {
    private final Map<String, Set<String>> chatRooms = new HashMap();


    /**
     * 加入房间
     * @param roomId
     * @param userId
     */
    public String joinRoom(String roomId,String userId){
        chatRooms.computeIfAbsent(roomId,k->new HashSet<>()).add(userId);
        return getMemberList(roomId,userId);
    }

    /**
     * 离开房间
     * @param roomId
     * @param userId
     * @return
     */
    public String leaveRoom(String roomId,String userId){
        Set<String> users = chatRooms.get(roomId);
        if(users!=null){
            users.remove(userId);
            if(users.isEmpty()){
                chatRooms.remove(roomId);
            }
        }
        return getMemberList(roomId,userId);
    }
    private String getMemberList (String roomId,String userId){
        Set<String> users = chatRooms.get(roomId);
        if(users == null||users.isEmpty()) {
            return "Room" + roomId+"is Empty now";
        }
        StringBuilder memberList = new StringBuilder("Current member in room"+roomId+"( excluding"+userId+"):");
        users.stream().filter(u->!u.equals(userId)).forEach(member->memberList.append(member).append(", "));
        if(memberList.toString().endsWith(", ")){
            memberList.setLength(memberList.length()-2);
        }
        return memberList.toString();
    }
}
