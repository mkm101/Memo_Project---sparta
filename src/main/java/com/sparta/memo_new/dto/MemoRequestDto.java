package com.sparta.memo_new.dto;


import lombok.Getter;

@Getter
public class MemoRequestDto {
    private String username;
    private String contents;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }
}