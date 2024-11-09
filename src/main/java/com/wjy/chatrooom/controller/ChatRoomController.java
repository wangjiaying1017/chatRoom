package com.wjy.chatrooom.controller;

import com.wjy.chatrooom.service.impl.ChatRoomServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/chatroom")
public class ChatRoomController {

    private final ChatRoomServiceImpl chatRoomService;

    /**
     * 加入聊天室
     * @param roomId
     * @param userId
     * @return
     */
    @GetMapping("/join")
    public String joinRoom(@RequestParam String roomId,@RequestParam String userId){
        return chatRoomService.joinRoom(roomId,userId);
    }

    /**
     * 离开聊天室
     * @param roomId
     * @param userId
     * @return
     */
    @GetMapping("/leave")
    public String leave(@RequestParam String roomId,@RequestParam String userId){
        return chatRoomService.leaveRoom(roomId,userId);
    }
}
