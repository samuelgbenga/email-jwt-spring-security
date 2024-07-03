package ng.samuel.email_demo_1.auth.service.impl;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import ng.samuel.email_demo_1.auth.payload.request.EmailDetails;
import ng.samuel.email_demo_1.auth.service.EmailSenderService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.nio.charset.StandardCharsets;

@Data
@Service
@RequiredArgsConstructor
public class EmailSenderServiceImpl implements EmailSenderService {

    private final JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String senderMail;

    @Override
    public void sendMimeEmailAlert(EmailDetails emailDetails) {
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, StandardCharsets.UTF_8.name());

            helper.setText(emailDetails.getMessageBody(), true); // Set true if the body is HTML, false for plain text
            helper.setFrom(senderMail);
            helper.setTo(emailDetails.getRecipient());
            helper.setSubject(emailDetails.getSubject());

            // for file attachment
            if (emailDetails.getAttachment() != null && !emailDetails.getAttachment().isEmpty()) {
                FileSystemResource file = new FileSystemResource(new File(emailDetails.getAttachment()));
                helper.addAttachment(file.getFilename(), file);
            }

            javaMailSender.send(mimeMessage);

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
