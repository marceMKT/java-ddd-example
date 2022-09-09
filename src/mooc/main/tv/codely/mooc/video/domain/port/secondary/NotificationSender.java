package tv.codely.mooc.video.domain.port.secondary;

import tv.codely.mooc.video.domain.Video;

public interface NotificationSender {

    public void sendNotification(Video video);
}
