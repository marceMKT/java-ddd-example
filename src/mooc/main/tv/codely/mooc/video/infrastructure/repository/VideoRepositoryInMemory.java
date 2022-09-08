package tv.codely.mooc.video.infrastructure.repository;

import tv.codely.mooc.video.domain.Video;
import tv.codely.mooc.video.domain.port.secondary.VideoRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class VideoRepositoryInMemory implements VideoRepository {

    private final List<Video> videosInMemory;

    public VideoRepositoryInMemory(){
        this.videosInMemory = new ArrayList<Video>();
    }

    @Override
    public void save(Video video) {
        videosInMemory.add(video);
    }

    @Override
    public Optional<Video> findLastVideo() {

        if (videosInMemory.isEmpty()) {
            return Optional.empty();
        }
        else{
            return Optional.of(videosInMemory.get(videosInMemory.size() - 1));
        }

    }
}
