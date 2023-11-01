package com.pjh.memotest.web;

import com.pjh.memotest.entity.Memo;
import com.pjh.memotest.service.MemoService;
import com.pjh.memotest.web.dto.MemoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class MemoController {

    private final MemoService memoService;

    @GetMapping("/memos")
    public List<Memo> getAllMemos() {
        return memoService.메모조회();
    }

    @PostMapping("/memos")
    public Memo createMemo(@RequestBody MemoDto memoDto) {
        Memo memo = memoService.메모생성(memoDto.toEntity());
        return memo;
    }

    @PutMapping("/memos/{id}")
    public Long updateMemo(@PathVariable Long id, @RequestBody MemoDto memoDto) {
        // 해당 메모가 DB에 존재하는지 확인
        Memo updateMyMemo = memoService.메모수정(id, memoDto.getContents());
        return updateMyMemo.getId();
    }

    @DeleteMapping("/memos/{id}")
    public Long deleteMemo(@PathVariable Long id) {
        memoService.메모삭제(id);
        return id;
    }
}