package tv.codely.mooc.video.infrastructure;

import tv.codely.mooc.notification.application.create.SendPushToSubscribersOnVideoPublished;
import tv.codely.mooc.video.application.publish.VideoPublisher;
import tv.codely.mooc.video.domain.VideoDescription;
import tv.codely.mooc.video.domain.VideoTitle;
import tv.codely.mooc.video.domain.port.secondary.NotificationSender;
import tv.codely.mooc.video.domain.port.secondary.VideoRepository;
import tv.codely.mooc.video.infrastructure.repository.VideoRepositoryInMemory;
import tv.codely.shared.application.DomainEventSubscriber;
import tv.codely.shared.domain.EventBus;
import tv.codely.shared.infrastructure.bus.ReactorEventBus;

import java.util.Set;

public class VideoPublisherCliController {
    public static void main(String[] args) {
        final Set<DomainEventSubscriber> subscribers = Set.of(
            new SendPushToSubscribersOnVideoPublished()
        );
        final EventBus eventBus = new ReactorEventBus(subscribers);
        final VideoRepository videoRepository = new VideoRepositoryInMemory();
        final NotificationSender notificationSender = new EmailNotificationSender("from@mail.com", "to@mail.com", "xxxSUBJECTxxx");
        final VideoPublisher videoPublisher = new VideoPublisher(eventBus, videoRepository, notificationSender);

        final String videoTitle = "\uD83C\uDF89 New YouTube.com/CodelyTV video title";
        final String videoDescription = "This should be the video description \uD83D\uDE42";

        videoPublisher.publish(videoTitle, videoDescription);
    }
}
