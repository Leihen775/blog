package blog.home.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import blog.home.dao.MessageMapper;
import blog.home.dao.MessageUserMapper;
import blog.home.model.Message;
import blog.home.model.MessageUser;
import blog.home.service.IMessageService;

@Service
@Transactional
public class MessageServiceImpl implements IMessageService {
  
  @Autowired
  MessageMapper messageMapper;
  @Autowired
  MessageUserMapper messageUserMapper;
  @Override
  public void sendSecretMessage(Message message, int uid) {
    messageMapper.addMessage(message);
    MessageUser messageUser = new MessageUser();
    messageUser.setMessage_id(message.getId());
    messageUser.setRecipient_uid(uid);
    messageUserMapper.addSecretMessager(messageUser);
  }
  @Override
  public void sendSysMessage(Message message, int uid) {
    messageMapper.addMessage(message);
    MessageUser messageUser = new MessageUser();
    messageUser.setMessage_id(message.getId());
    messageUser.setRecipient_uid(uid);
    messageUserMapper.addSysMessage(messageUser);
  }
  @Override
  public void sendSysMessageBatch(Message message, List<Integer> uidList) {
    messageMapper.addMessage(message);
    List<MessageUser> messageUserList = new ArrayList<MessageUser>();
    for(Integer uid:uidList) {
      MessageUser messageUser = new MessageUser();
      messageUser.setMessage_id(message.getId());
      messageUser.setRecipient_uid(uid);
      messageUserList.add(messageUser);
    }
    messageUserMapper.addSysMessageBatch(messageUserList);
  }
  @Override
  public void deleteSenderMessage(int id) {
    messageMapper.deleteMessage(id);
  }
  @Override
  public void deleteRecipientMessage(int id) {
    messageUserMapper.deleteMessage(id);
  }
  @Override
  public void updateRecipientMessage(int id) {
    messageUserMapper.updateMessage(id);    
  }
  @Override
  public Message findMessage(int id) {
    return messageMapper.findMessage(id);
  }
  @Override
  public List<MessageUser> findSecretMessage(int uid) {
    return messageUserMapper.findSecretMessage(uid);
  }
  @Override
  public List<MessageUser> findSecretMessageRead(int uid) {
    return messageUserMapper.findSecretMessageRead(uid);
  }
  @Override
  public List<MessageUser> findSysMessage(int uid) {
    return messageUserMapper.findSysMessage(uid);
  }
  @Override
  public List<MessageUser> findSysMessageRead(int uid) {
    return messageUserMapper.findSysMessageRead(uid);
  }
  @Override
  public int findCount(int uid) {
    return messageUserMapper.findCount(uid);
  }
  @Override
  public int findSecretCount(int uid) {
    return messageUserMapper.findSecretCount(uid);
  }
  @Override
  public int findSysCount(int uid) {
    return messageUserMapper.findSysCount(uid);
  }
  

}
