package tv.codely.mooc.video.application.publish;

import org.junit.jupiter.api.Test;
import tv.codely.mooc.video.domain.VideoPublished;
import tv.codely.mooc.video.domain.port.secondary.VideoRepository;
import tv.codely.shared.domain.EventBus;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

final class VideoPublisherShould {
    @Test
    void publish_the_video_published_domain_event() {
        final EventBus eventBus = mock(EventBus.class);
        final VideoRepository videoRepository = mock(VideoRepository.class);
        final VideoPublisher videoPublisher = new VideoPublisher(eventBus, videoRepository);

        final String videoTitle = "\uD83C\uDF89 New YouTube.com/CodelyTV video title";
        final String videoDescription = "This should be the video description \uD83D\uDE42";

        videoPublisher.publish(videoTitle, videoDescription);

        final VideoPublished expectedVideoCreated = new VideoPublished(videoTitle, videoDescription);

        verify(eventBus).publish(List.of(expectedVideoCreated));
        verify(videoRepository, times(1)).save(any());

    }

}
