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
  public void keepMessage(Message message) {
    messageMapper.addMessage(message);
    messageMapper.keepMessage(message.getId());
  }
  
  @Override
  public void sendSecretMessage(Message message, int uid) {
    messageMapper.addMessage(message);
    MessageUser messageUser = new MessageUser();
    messageUser.setMessageId(message.getId());
    messageUser.setRecipientUid(uid);
    messageUserMapper.addSecretMessage(messageUser);
    messageMapper.sendMessage(message.getId());
  }
  
  @Override
  public void sendSysMessage(Message message, int uid) {
    messageMapper.addMessage(message);
    MessageUser messageUser = new MessageUser();
    messageUser.setMessageId(message.getId());
    messageUser.setRecipientUid(uid);
    messageUserMapper.addSysMessage(messageUser);
    messageMapper.sendMessage(message.getId());
  }
  
  @Override
  public void sendSysMessageBatch(Message message, List<Integer> uidList) {
    messageMapper.addMessage(message);
    List<MessageUser> messageUserList = new ArrayList<MessageUser>();
    for(Integer uid:uidList) {
      MessageUser messageUser = new MessageUser();
      messageUser.setMessageId(message.getId());
      messageUser.setRecipientUid(uid);
      messageUserList.add(messageUser);
    }
    messageUserMapper.addSysMessageBatch(messageUserList);
    messageMapper.sendMessage(message.getId());
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
  public void AllMessageRead(List<Integer> idList) {
    messageUserMapper.updateAllMessageRead(idList);    
  }
  
  @Override
  public MessageUser findMessage(int id) {
    MessageUser messageUser = messageUserMapper.findMessage(id);
    messageUserMapper.updateMessageRead(id);
    return messageUser;
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

  @Override
  public List<Message> findDraft(int sender) {
    return messageMapper.findDraft(sender);
  }

  @Override
  public Message findDraftDetail(int id) {
    return messageMapper.findDraftDetail(id);
  }

}
