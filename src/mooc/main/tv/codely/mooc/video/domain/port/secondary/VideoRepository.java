package tv.codely.mooc.video.domain.port.secondary;

import tv.codely.mooc.video.domain.Video;

import java.util.Optional;

public interface VideoRepository {

    void save(Video video);

    Optional<Video> findLastVideo();

}
