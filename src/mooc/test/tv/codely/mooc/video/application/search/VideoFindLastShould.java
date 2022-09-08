package tv.codely.mooc.video.application.search;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import tv.codely.mooc.video.domain.port.secondary.VideoRepository;
import java.util.Optional;

import static org.mockito.Mockito.*;

final class VideoFindLastShould {
    @Test
    void find_last_video_1_element() {
        final VideoRepository videoRepository = mock(VideoRepository.class);
        final FindLastVideo findLastVideo = new FindLastVideo(videoRepository);

        when(videoRepository.findLastVideo()).thenReturn(Optional.empty());

        assertEquals(findLastVideo.findLastVideo(), Optional.empty());

    }

}
