package blog.home.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

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
  public void deleteAllMessage(int uid) {
    messageUserMapper.deleteAllMessage(uid);
  }
  
  @Override
  public void AllMessageRead(int uid) {
    messageUserMapper.updateAllMessageRead(uid);    
  }
  
  @Override
  public void MessageRead(int id) {
    messageUserMapper.updateMessageRead(id);
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
  public PageInfo<MessageUser> findSysMessage(int uid,int pageNum) {
    PageHelper.startPage(pageNum,3);
    PageInfo<MessageUser> pageInfo = new PageInfo<MessageUser>(messageUserMapper.findSysMessage(uid),3);
    return pageInfo;
  }
  
  @Override
  public PageInfo<MessageUser> findSysMessageRead(int uid) {
    PageHelper.startPage(1, 3);
    PageInfo<MessageUser> pageInfo = new PageInfo<MessageUser>(messageUserMapper.findSysMessageRead(uid),3);
    return pageInfo;
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
  public PageInfo<Message> findDraft(int sender) {
    PageHelper.startPage(1, 3);
    PageInfo<Message> pageInfo = new PageInfo<Message>(messageMapper.findDraft(sender),3);
    return pageInfo;
  }

  @Override
  public Message findDraftDetail(int id) {
    return messageMapper.findDraftDetail(id);
  }

}
