package com.pjh.memotest.service;

import com.pjh.memotest.entity.Memo;
import com.pjh.memotest.entity.MemoRepository;
import com.pjh.memotest.web.dto.MemoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class MemoService {

    private final MemoRepository memoRepository;
    public List<Memo> 메모조회() {
        return memoRepository.findAll();
    }

    public Memo 메모생성(Memo memo) {
        Memo myMemo = new Memo();
        myMemo.setUsername(memo.getUsername());
        myMemo.setContents(memo.getContents());
        memoRepository.save(myMemo);
        return myMemo;
    }

    public Memo 메모수정(long id, String contents) {
        Memo myMemo = memoRepository.findById(id).orElse(null);
        if (myMemo != null) {
            myMemo.setContents(contents);
            return memoRepository.save(myMemo);
        }
        return null;
    }

    public void 메모삭제(long id) {
        memoRepository.deleteById(id);
    }
}
