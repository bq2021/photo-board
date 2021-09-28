package com.bq.continues.photo.board.respository;

import com.bq.continues.photo.board.entity.Photo;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class VolatileRepo {

    private static Map<Long, Photo> photos = new HashMap();


    public List<Photo> findAll() {
        return new ArrayList<>(photos.values());
    }

    public Photo findById(Long id) {
        return photos.get(id);
    }

    public void save(long id, Photo photo) {
        photo.setGenerateDate(LocalDateTime.now());
        checkSameKeyError(id);
        photos.put(photo.getId(), photo);
    }

    public void update(long id, Photo photo) {
        checkNotSameKeyError(id);
        photos.put(id, photo);
    }

    public void delete(long id) {
        checkNotSameKeyError(id);
        photos.remove(id);
    }

    private void checkNotSameKeyError(long l) {
        if (!photos.containsKey(l)) {
            throw new IllegalArgumentException(l + "번의 키는 존재하지 않습니다.");
        }
    }


    private void checkSameKeyError(long l) {
        if (photos.containsKey(l)) {
            throw new IllegalArgumentException("이미 값이 존재합니다.");
        }
    }

}
