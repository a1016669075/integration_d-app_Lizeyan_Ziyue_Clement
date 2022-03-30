package com.demo.entity;
public class Userinfo {
    private Integer id;
    private String password;
    private String post;
    private String header;
    private String company;
    private String type;
    private String salary;
    private String username;
    private String _id;
    private String info;
    public Userinfo() {
        super();
    }
    public Userinfo(Integer id,String password,String post,String header,String company,String type,String salary,String username,String info) {
        super();
        this.id = id;
        this.password = password;
        this.post = post;
        this.header = header;
        this.company = company;
        this.type = type;
        this.salary = salary;
        this.username = username;
        this.info = info;
    }
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPost() {
        return this.post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getHeader() {
        return this.header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getCompany() {
        return this.company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSalary() {
        return this.salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getInfo() {
        return this.info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }
}
