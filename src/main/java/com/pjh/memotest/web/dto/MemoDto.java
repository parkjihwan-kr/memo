package com.pjh.memotest.web.dto;

import com.pjh.memotest.entity.Memo;
import lombok.Data;

@Data
public class MemoDto {
    private String username;
    private String contents;

    public Memo toEntity(){
        return Memo.builder()
                .username(username)
                .contents(contents)
                .build();
    }
}
