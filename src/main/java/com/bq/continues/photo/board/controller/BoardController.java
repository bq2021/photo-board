package com.bq.continues.photo.board.controller;

import com.bq.continues.photo.board.entity.Photo;
import com.bq.continues.photo.board.respository.VolatileRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
@RequestMapping("board")
@Slf4j
public class BoardController {

    private VolatileRepo volatileRepo;

    public BoardController(VolatileRepo volatileRepo) {
        this.volatileRepo = volatileRepo;
        volatileRepo.save(1L,
                Photo.builder()
                        .id(1L)
                        .title("첫번째")
                        .content("테스트입니다~")
                        .writer("영남")
                        .generateDate(LocalDateTime.now())
                        .imageUrl("https://img1.daumcdn.net/thumb/R720x0.q80/?scode=mtistory2&fname=http%3A%2F%2Fcfile7.uf.tistory.com%2Fimage%2F24283C3858F778CA2EFABE")
                        .build()
        );
        volatileRepo.save(2L,
                Photo.builder()
                        .id(2L)
                        .title("제목입니다.")
                        .content("이 사진은 영국에서 시작되었으며")
                        .writer("byeonggyoo")
                        .generateDate(LocalDateTime.now())
                        .imageUrl("https://source.unsplash.com/random/500x300")
                        .build()
        );
        volatileRepo.save(3L,
                Photo.builder()
                        .id(3L)
                        .title("오늘 날씨")
                        .content("우충충합니더")
                        .writer("홍씨")
                        .generateDate(LocalDateTime.now())
                        .imageUrl("https://cdn.pixabay.com/photo/2017/06/19/07/41/umbrella-2418413_960_720.jpg")
                        .build()
        );
        volatileRepo.save(4L,
                Photo.builder()
                        .id(4L)
                        .title("제목입니다.")
                        .content("움 짤")
                        .writer("byeonggyoo")
                        .generateDate(LocalDateTime.now())
                        .imageUrl("https://img1.daumcdn.net/thumb/R800x0/?scode=mtistory2&fname=https%3A%2F%2Ft1.daumcdn.net%2Fcfile%2Ftistory%2F1871634C5010967C20")
                        .build()
        );
    }

    @GetMapping("list")
    public String listController(Model model) {
        model.addAttribute("title", "사진 게시판");
        model.addAttribute("photos", volatileRepo.findAll());
        return "board/list";
    }

    @GetMapping("detail/{id}")
    public String detailController(Model model, @PathVariable("id") long id) {
        model.addAttribute("title", String.valueOf(id) + "번 게시글");
        model.addAttribute("photo", volatileRepo.findById(id));
        return "board/detail";
    }

    @GetMapping("write")
    public String moveWritePageController(Model model) {
        model.addAttribute("title", "게시글 등록");
        return "board/write";
    }

    @PostMapping("write")
    public String writeController(Photo photo) {
        log.info("{}", photo);
        volatileRepo.save(photo.getId(),photo);
        return "redirect:list";
    }

}
