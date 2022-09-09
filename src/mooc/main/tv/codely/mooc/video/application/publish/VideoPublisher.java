package tv.codely.mooc.video.application.publish;

import tv.codely.mooc.video.domain.Video;
import tv.codely.mooc.video.domain.VideoDescription;
import tv.codely.mooc.video.domain.VideoTitle;
import tv.codely.mooc.video.domain.port.secondary.NotificationSender;
import tv.codely.mooc.video.domain.port.secondary.VideoRepository;
import tv.codely.shared.domain.EventBus;

public final class VideoPublisher {

    private final EventBus eventBus;
    private final VideoRepository videoRepository;
    private final NotificationSender notificationSender;

    public VideoPublisher(EventBus eventBus, VideoRepository videoRepository, NotificationSender notificationSender) {
        this.eventBus = eventBus;
        this.videoRepository = videoRepository;
        this.notificationSender = notificationSender;
    }

    public void publish(String rawTitle, String rawDescription) {
        final var title = new VideoTitle(rawTitle);
        final var description = new VideoDescription(rawDescription);

        final var video = Video.publish(title, description);

        eventBus.publish(video.pullDomainEvents());
        videoRepository.save(video);
        notificationSender.sendNotification(video);
    }
}
