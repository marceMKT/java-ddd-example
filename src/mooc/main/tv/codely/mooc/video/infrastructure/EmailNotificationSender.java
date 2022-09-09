package tv.codely.mooc.video.infrastructure;

import tv.codely.mooc.video.domain.Video;
import tv.codely.mooc.video.domain.port.secondary.NotificationSender;

public class EmailNotificationSender implements NotificationSender {

    private String from;
    private String to;
    private String subject;

    public EmailNotificationSender(String from, String to, String subject){
        this.from = from;
        this.to = to;
        this.subject = subject;
    }

    @Override
    public void sendNotification(Video video) {
        System.out.print("Send email to: " + to +"; from: " + from +"; with subject: " + subject + " ");
        System.out.println("A new Video is been published with this title: '" + video.getTitle() + "' and this descriprion: '" + video.getDescription() + "'");
    }
}
