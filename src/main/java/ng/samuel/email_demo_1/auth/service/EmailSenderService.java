package ng.samuel.email_demo_1.auth.service;

import ng.samuel.email_demo_1.auth.payload.request.EmailDetails;

public interface EmailSenderService {

    void sendMimeEmailAlert(EmailDetails emailDetails);
}
