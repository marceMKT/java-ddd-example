package tv.codely.mooc.video.infrastructure;

import tv.codely.mooc.notification.application.create.SendPushToSubscribersOnVideoPublished;
import tv.codely.mooc.video.application.publish.VideoPublisher;
import tv.codely.mooc.video.domain.Video;
import tv.codely.mooc.video.domain.port.secondary.VideoRepository;
import tv.codely.mooc.video.infrastructure.repository.VideoRepositoryInMemory;
import tv.codely.shared.application.DomainEventSubscriber;
import tv.codely.shared.domain.EventBus;
import tv.codely.shared.infrastructure.bus.ReactorEventBus;

import java.util.Optional;
import java.util.Set;

public class VideoFindLastController {
    public static void main(String[] args) {
        final Set<DomainEventSubscriber> subscribers = Set.of(
            new SendPushToSubscribersOnVideoPublished()
        );
        final EventBus eventBus = new ReactorEventBus(subscribers);
        final VideoRepository videoRepository = new VideoRepositoryInMemory();
        final VideoPublisher videoPublisher = new VideoPublisher(eventBus, videoRepository);

        final String videoTitle = "\uD83C\uDF89 New YouTube.com/CodelyTV video title";
        final String videoDescription = "This should be the video description \uD83D\uDE42";

        videoPublisher.publish(videoTitle, videoDescription);

        Optional<Video> video = videoRepository.findLastVideo();
        System.out.println(video.get().getTitle() + " - " + video.get().getDescription());

    }
}
