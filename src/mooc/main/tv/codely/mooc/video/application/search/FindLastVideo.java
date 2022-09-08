package tv.codely.mooc.video.application.search;

import tv.codely.mooc.video.domain.Video;
import tv.codely.mooc.video.domain.port.secondary.VideoRepository;

import java.util.Optional;

public class FindLastVideo {

    private final VideoRepository videoRepository;

    public FindLastVideo (VideoRepository videoRepository){
        this.videoRepository = videoRepository;
    }

    public Optional<Video> findLastVideo(){
        return videoRepository.findLastVideo();
    }

}
