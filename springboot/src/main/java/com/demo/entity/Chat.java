package com.demo.entity;
public class Chat {
    private Integer id;
    private String from;
    private String read;
    private String createTime;
    private String to;
    private String content;
    private String chatId;
    public Chat() {
        super();
    }
    public Chat(Integer id,String from,String read,String createTime,String to,String content,String chatId) {
        super();
        this.id = id;
        this.from = from;
        this.read = read;
        this.createTime = createTime;
        this.to = to;
        this.content = content;
        this.chatId = chatId;
    }
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFrom() {
        return this.from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getRead() {
        return this.read;
    }

    public void setRead(String read) {
        this.read = read;
    }

    public String getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getTo() {
        return this.to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getChatId() {
        return this.chatId;
    }

    public void setChatId(String chatId) {
        this.chatId = chatId;
    }

}
