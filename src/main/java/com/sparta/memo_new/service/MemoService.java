package com.sparta.memo_new.service;
import com.sparta.memo_new.Repository.MemoRepository;
import com.sparta.memo_new.dto.MemoRequestDto;
import com.sparta.memo_new.dto.MemoResponseDto;
import com.sparta.memo_new.entity.Memo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MemoService { // memoService 이러한 이름으로 등록된다.
    private final MemoRepository memoRepository;
    public MemoService(MemoRepository memoRepository){
        this.memoRepository = memoRepository;
    }


    // public MemoService(ApplicationContext context) {
        // 1. 'Bean'의 이름으로 가져오기
       // MemoRepository memoRepository1 = context.getBean("memoRepository");
        // 2. ;'Bean' 클래스 형식으로 가져오기
      //  MemoRepository memoRepository2 = context.getBean("memoRepository.class");
    //}

    private final MemoRepository memoRepository;

    public MemoResponseDto createMemo(MemoRequestDto requestDto) {
        // RequestDto -> Entity
        Memo memo = new Memo(requestDto);
        Memo savememo = memoRepository.save(memo);
        // Entity -> ResponseDto
        MemoResponseDto memoResponseDto = new MemoResponseDto(memo);
        return memoResponseDto;
    }

    public List<MemoResponseDto> getMemos() {
        // DB 조회
        return memoRepository.findAll();

    }

    public Long updateMemo(Long id, MemoRequestDto requestDto) {
        // 해당 메모가 DB에 존재하는지 확인
        Memo memo = memoRepository.findById(id);
        if(memo != null) {
            memoRepository.update(id,requestDto);
            // memo 내용 수정
            return id;
        } else {
            throw new IllegalArgumentException("선택한 메모는 존재하지 않습니다.");
        }
    }



    public Long deleteMemo(Long id) {
        MemoRepository memoRepository =new MemoRepository(jdbcTemplate);
        // 해당 메모가 DB에 존재하는지 확인
        Memo memo = memoRepository.findById(id);
        if(memo != null) {
            // memo 삭제
            memoRepository.delete(id);
            return id;
        } else {
            throw new IllegalArgumentException("선택한 메모는 존재하지 않습니다.");
        }
    }
}