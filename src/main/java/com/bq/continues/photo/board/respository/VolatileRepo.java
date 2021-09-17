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

    public void save(long l, Photo photo) {
        photo.setGenerateDate(LocalDateTime.now());
        photos.put(photo.getId(), photo);
    }

}
